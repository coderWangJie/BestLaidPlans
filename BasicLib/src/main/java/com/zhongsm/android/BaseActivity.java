package com.zhongsm.android;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.zhongsm.util.LogUtil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    protected abstract int getContentLayoutId();

    protected abstract void doingOnCreat();

    protected abstract void doingOnResume();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("LogWangJ", "activity****onCreate");

        LogUtil.d(TAG, "Android OS version:" + Build.VERSION.SDK_INT);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        // android 5.0以上可定制状态栏
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//            window.setNavigationBarColor(Color.TRANSPARENT);
//        }

        if (getContentLayoutId() > 0) {
            setContentView(getContentLayoutId());
        }

        doingOnCreat();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TAG = getClass().getSimpleName();
        Log.e("LogWangJ", "activity****onResume");
        doingOnResume();
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


    public Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://v.juhe.cn/todayOnhistory/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
