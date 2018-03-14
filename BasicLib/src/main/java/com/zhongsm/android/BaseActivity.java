package com.zhongsm.android;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

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
    protected abstract int loadContentLayoutID();

    protected abstract void initViews();

    protected abstract void loadViewData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("LogWangJ", "activity****onCreate");

        if (loadContentLayoutID() > 0) {
            setContentView(loadContentLayoutID());
        }

        initViews();
        loadViewData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TAG = getClass().getSimpleName();
        Log.e("LogWangJ", "activity****onResume");
    }

    private Toast toast;

    private void toast(String toastMsg, int duration) {
        if (toast != null) {
            toast.setText(toastMsg);
            toast.setDuration(duration);
        } else {
            toast = Toast.makeText(this, toastMsg, duration);
        }
        toast.show();
    }

    protected void toastShort(@NonNull String toastMsg) {
        toast(toastMsg, Toast.LENGTH_SHORT);
    }

    protected void toastLong(@NonNull String toastMsg) {
        toast(toastMsg, Toast.LENGTH_LONG);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LogWangJ", "activity****onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LogWangJ", "activity****onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LogWangJ", "activity****onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LogWangJ", "activity****onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("LogWangJ", "activity****onRestart");
    }
}
