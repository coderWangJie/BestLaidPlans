package com.zhongsm.plan.android.app;

import android.app.Application;
import android.util.Log;

import com.zhongsm.plan.consts.Constant;
import com.zhongsm.util.LogUtil;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * TODO
 *
 * @author WangJ jie581825@yeah.net 2018/3/8
 * @version TODO
 *          Modified: TODO
 *          Modified on 2018/3/8 by TODO
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        setAppLog();
    }

    private void setAppLog() {
        if (Constant.APP_IS_DEBUG) {
            // 运行日志
            LogUtil.setRunLogLevel(Log.DEBUG); // 测试
            // OkHttp3网络通信日志
            LogUtil.setHttpLogLevel(HttpLoggingInterceptor.Level.BODY); // 测试
        }
    }
}