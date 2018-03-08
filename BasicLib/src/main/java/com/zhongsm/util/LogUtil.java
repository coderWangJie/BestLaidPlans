package com.zhongsm.util;

import android.util.Log;

/**
 * TODO
 *
 * @author WangJ jie581825@yeah.net 2018/3/8
 * @version TODO
 *          Modified: TODO
 *          Modified on 2018/3/8 by TODO
 */
public class LogUtil {
    /* 由于TAG要在静态方法中使用，只能在每个工具类中设置TAG值 */
    private static final String TAG = "LogUtil";

    private static int mLogLevel;

    public static void setLogLevel(int logLevel) {
        Log.d(TAG, "setLogLevel: " + logLevel);
        mLogLevel = logLevel;
    }

    public static void v(String tag, String message) {
        if (Log.VERBOSE >= mLogLevel) {
            Log.v(tag, message);
        }
    }

    public static void d(String tag, String message) {
        if (Log.DEBUG >= mLogLevel) {
            Log.d(tag, message);
        }
    }

    public static void i(String tag, String message) {
        if (Log.INFO >= mLogLevel) {
            Log.i(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (Log.WARN >= mLogLevel) {
            Log.w(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (Log.ERROR >= mLogLevel) {
            Log.e(tag, message);
        }
    }
}