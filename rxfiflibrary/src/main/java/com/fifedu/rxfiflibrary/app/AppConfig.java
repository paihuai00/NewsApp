package com.fifedu.rxfiflibrary.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.blankj.utilcode.util.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * 应用需要初始化的方法管理
 * @author weidingqiang
 *
 * 2015年7月28日
 */
public class AppConfig {
    public static final String TAG = "AppConfig";

    private final static String APP_CONFIG = "config";

    private Context mContext;
    private static AppConfig appConfig;

    private String[] mAppFolders = {

            AppConstants.CACHE_PATH,
            AppConstants.PARENT_FOLD_PATH,

            AppConstants.RECORD_PATH,
            AppConstants.DOWNLOAD_PATH,
            AppConstants.LOGS_PATH,

            AppConstants.RECORD_DOWNLOAD_PATH,
            AppConstants.PIC_DOWNLOAD_PATH,
            AppConstants.VIDEO_DOWNLOAD_PATH,
            AppConstants.FILE_DOWNLOAD_PATH,
            AppConstants.UNFILE_DOWNLOAD_PATH
    };

    private AppConfig(){
        initAppFolder();
    }

    public static AppConfig getAppConfig(Context context) {
        if (appConfig == null) {
            appConfig = new AppConfig();
            appConfig.mContext = context;
        }
        return appConfig;
    }


    /**
     * 初始化应用文件目录
     */
    public void initAppFolder(){
        for(String str:mAppFolders){
            FileUtils.createOrExistsDir(str);
        }
    }

    //*********************************************************************//

    /**
     * 获取Preference设置
     */
    public static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String get(String key) {
        Properties props = get();
        return (props != null) ? props.getProperty(key) : null;
    }

    public Properties get() {
        FileInputStream fis = null;
        Properties props = new Properties();
        try {
            // 读取files目录下的config
            // fis = activity.openFileInput(APP_CONFIG);

            // 读取app_config目录下的config
            File dirConf = mContext.getDir(APP_CONFIG, Context.MODE_PRIVATE);
            fis = new FileInputStream(dirConf.getPath() + File.separator
                    + APP_CONFIG);

            props.load(fis);
        } catch (Exception e) {
        } finally {
            try {
                fis.close();
            } catch (Exception e) {
            }
        }
        return props;
    }

    private void setProps(Properties p) {
        FileOutputStream fos = null;
        try {
            // 把config建在files目录下
            // fos = activity.openFileOutput(APP_CONFIG, Context.MODE_PRIVATE);

            // 把config建在(自定义)app_config的目录下
            File dirConf = mContext.getDir(APP_CONFIG, Context.MODE_PRIVATE);
            File conf = new File(dirConf, APP_CONFIG);
            fos = new FileOutputStream(conf);

            p.store(fos, null);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (Exception e) {
            }
        }
    }

    public void set(Properties ps) {
        Properties props = get();
        props.putAll(ps);
        setProps(props);
    }

    public void set(String key, String value) {
        Properties props = get();
        props.setProperty(key, value);
        setProps(props);
    }

    public void remove(String... key) {
        Properties props = get();
        for (String k : key)
            props.remove(k);
        setProps(props);
    }
}
