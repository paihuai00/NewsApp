package com.csx.newsapp.widget.download;

import android.os.AsyncTask;
import android.os.Environment;

import com.fifedu.rxfiflibrary.utils.LogUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by cuishuxiang on 2017/7/11.
 */

public class DownloadTask extends AsyncTask<String, Integer, Integer> {
    private static final String TAG = "DownloadTask";
    private static final int TYPE_SUCCESS = 0;
    private static final int TYPE_FAILED = 1;
    private static final int TYPE_PAUSED = 2;
    private static final int TYPE_CANCELED = 3;

    private DownloadListener downloadListener;

    private boolean isCancel = false;
    private boolean isPaused = false;
    private int lastProgress;

    public DownloadTask(DownloadListener downloadListener) {
        this.downloadListener = downloadListener;
    }

    @Override
    protected Integer doInBackground(String... params) {
        InputStream inputStream = null;
        RandomAccessFile savedFile = null;
        File file = null;
        try {
            long downloadLength = 0;//记录已经下载的文件长度
            String downloadUrl = params[0];
            String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
            String directory = Environment.getExternalStoragePublicDirectory
                    (Environment.DIRECTORY_DOWNLOADS).getPath();
            file = new File(directory + fileName);

            if (file.exists()) {
                downloadLength = file.length();
            }

            long contentLength = getContentLength(downloadUrl);

            if (contentLength == 0) {
                return TYPE_FAILED;
            } else if (contentLength == downloadLength) {
                return TYPE_SUCCESS;//如果已经下载的字节=总长度，下载完毕
            }
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .addHeader("RANGE", "bytes=" + downloadLength + "-")
                    .url(downloadUrl)
                    .build();
            Response response = okHttpClient.newCall(request).execute();

            if (response != null) {
                inputStream = response.body().byteStream();
                savedFile = new RandomAccessFile(file, "rw");
                savedFile.seek(downloadLength);//跳过已经下载的字节
                byte[] bytes = new byte[1024];
                int total = 0;
                int len;

                while ((len = inputStream.read(bytes)) != -1) {
                    if (isCancel) {
                        return TYPE_CANCELED;
                    } else if (isPaused) {
                        return TYPE_PAUSED;
                    } else {
                        total += len;
                        savedFile.write(bytes, 0, len);

                        //计算已经下载的百分比
                        int progress = (int) ((total + downloadLength) * 100 / contentLength);
                        publishProgress(progress);

                    }
                }
                response.body().close();
                return TYPE_SUCCESS;
            }
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.debug(TAG, e.toString());
        }finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (savedFile != null) {
                    savedFile.close();
                }
                if (isCancel && file != null) {
                    file.delete();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return TYPE_FAILED;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];

        if (progress > lastProgress) {
            downloadListener.onProgress(progress);
            lastProgress = progress;
        }
    }

    @Override
    protected void onPostExecute(Integer status) {
        switch (status) {
            case TYPE_SUCCESS:
                downloadListener.onSuccess();
                break;

            case TYPE_PAUSED:
                downloadListener.onPaused();
                break;

            case TYPE_FAILED:
                downloadListener.onFailed();
                break;

            case TYPE_CANCELED:
                downloadListener.onCanceled();
                break;
        }
    }

    public void pausedDownload() {
        isPaused = true;
    }

    public void cancelDownload() {
        isCancel = true;
    }

    private long getContentLength(String downloadUrl) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(downloadUrl)
                .build();
        Response response = client.newCall(request).execute();

        if (response != null && response.isSuccessful()) {
            long contentLength = response.body().contentLength();
            response.body().close();
            return contentLength;
        }
        return 0;
    }
}
