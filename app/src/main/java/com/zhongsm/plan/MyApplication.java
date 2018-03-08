package com.zhongsm.plan;

import android.util.Log;

import com.zhongsm.android.BaseApplication;
import com.zhongsm.util.LogUtil;

/**
 * TODO
 *
 * @author WangJ jie581825@yeah.net 2018/3/8
 * @version TODO
 *          Modified: TODO
 *          Modified on 2018/3/8 by TODO
 */
public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        LogUtil.setLogLevel(Log.DEBUG);
    }
}