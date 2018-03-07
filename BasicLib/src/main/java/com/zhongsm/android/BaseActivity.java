package com.zhongsm.android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * TODO
 *
 * @author WangJ jie581825@yeah.net 2018/3/7
 * @version TODO
 *          Modified: TODO
 *          Modified on 2018/3/7 by TODO
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected static String TAG;

    /**
     * 获取页面Content布局文件ID
     * @return setContentView(int) 待置入页面的 layoutID
     */
    abstract int loadContentLayoutID();

    abstract void initViews();

    abstract void xx();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (loadContentLayoutID() > 0) {
            setContentView(loadContentLayoutID());
        }

        initViews();
        xx();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TAG = getClass().getSimpleName();
    }


}