package com.csx.newsapp.widget.download;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.csx.newsapp.R;
import com.csx.newsapp.ui.main.activity.MainActivity;
import com.fifedu.rxfiflibrary.baserx.RxBus;

import java.io.File;

/**
 * Created by cuishuxiang on 2017/7/11.
 *
 * 新建一个服务，确保服务一直在后台执行
 */

public class DownloadService extends Service {
    private DownloadTask downloadTask;

    private String downloadUrl;

    private DownloadListener downloadListener = new DownloadListener() {
        @Override
        public void onProgress(int progress) {
            getNotificationManager().notify(1, getNotification("Downloading.....", progress));
        }

        @Override
        public void onSuccess() {
            downloadTask = null;
            //下载成功，通知前台服务关闭，并且创建一个下载成功的通知
            stopForeground(true);
            getNotificationManager().notify(1, getNotification("DownLoad Success", -1));
            getNotificationManager().cancel(1);//下载成功，服务关闭
            Toast.makeText(DownloadService.this,"DownLoad Success!",Toast.LENGTH_SHORT).show();

            RxBus.getInstance().post("Download Success", "Download Success");

        }

        @Override
        public void onFailed() {
            downloadTask = null;
            //下载成功，通知前台服务关闭，并且创建一个下载失败的通知
            stopForeground(true);

            getNotificationManager().notify(1, getNotification("Download Failed!", -1));

            Toast.makeText(DownloadService.this,"DownLoad Failed!",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {
            downloadTask = null;
            Toast.makeText(DownloadService.this,"DownLoad Paused!",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCanceled() {
            downloadTask = null;
            //下载成功，通知前台服务关闭，并且创建一个下载取消的通知
            stopForeground(true);
            Toast.makeText(DownloadService.this,"DownLoad Paused!",Toast.LENGTH_SHORT).show();
        }
    };

    private DownloadBinder downloadBinder = new DownloadBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return downloadBinder;
    }

    //与activity 交互
    public class DownloadBinder extends Binder {
        public void startDownload(String url) {
            if (downloadTask == null) {
                downloadUrl = url;
                downloadTask = new DownloadTask(downloadListener);
                downloadTask.execute(downloadUrl);
                startForeground(1, getNotification("Downloading....", 0));

                Toast.makeText(DownloadService.this,"Downloading....",Toast.LENGTH_SHORT).show();
            }
        }

        public void pausedDownload() {
            if (downloadTask != null) {
                downloadTask.pausedDownload();
            }
        }

        public void cancelDownload() {
            if (downloadTask != null) {
                downloadTask.cancelDownload();
            } else {
                if (downloadUrl != null) {
                    //取消下载时，需要将文件删除，通知关闭
                    String filename = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
                    String directory = Environment.getExternalStoragePublicDirectory
                            (Environment.DIRECTORY_DOWNLOADS).getPath();

                    File file = new File(directory + filename);
                    if (file.exists()) {
                        file.delete();
                    }
                    getNotificationManager().cancel(1);
                    stopForeground(true);

                    Toast.makeText(DownloadService.this,"Download Cancel.",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    private NotificationManager getNotificationManager() {
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    private Notification getNotification(String title, int progress) {
        Intent intent = new Intent(this, MainActivity.class);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle(title);
        if (progress > 0) {
            //当progress大于0时，才显示需要下载的进度
            builder.setContentText(progress + "%");
            builder.setProgress(100, progress, false);
        }

        return builder.build();
    }
}
