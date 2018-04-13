package com.zhongsm.util;

import android.util.Log;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 日志打印工具类
 *
 * @author WangJ jie581825@yeah.net 2018/3/8
 * @version 1.0
 *          Modified:
 *          Modified on 2018/x/x by xxx
 */
public class LogUtil {
    /* 由于TAG要在静态方法中使用，只能在每个工具类中设置TAG值 */
    private static final String TAG = "LogUtil";

    private static int runLogLevel = Log.ASSERT + 1; // 默认不打印运行日志
    public static HttpLoggingInterceptor.Level httpLogLevel = HttpLoggingInterceptor.Level.NONE;  // 默认不打印网络通信日志

    public static void setHttpLogLevel(HttpLoggingInterceptor.Level httpLogLevel) {
        LogUtil.httpLogLevel = httpLogLevel;
    }

    public static void setRunLogLevel(int runLogLevel) {
        Log.d(TAG, "setRunLogLevel: " + runLogLevel);
        LogUtil.runLogLevel = runLogLevel;
    }

    public static void v(String tag, String message) {
        if (Log.VERBOSE >= runLogLevel) {
            Log.v(tag, message);
        }
    }

    public static void d(String tag, String message) {
        if (Log.DEBUG >= runLogLevel) {
            Log.d(tag, message);
        }
    }

    public static void i(String tag, String message) {
        if (Log.INFO >= runLogLevel) {
            Log.i(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (Log.WARN >= runLogLevel) {
            Log.w(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (Log.ERROR >= runLogLevel) {
            Log.e(tag, message);
        }
    }
}