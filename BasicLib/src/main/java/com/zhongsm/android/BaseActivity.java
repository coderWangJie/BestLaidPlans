package com.zhongsm.android;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.zhongsm.util.LogUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
     *
     * @return setContentView(int) 待置入页面的 layoutID
     */
    protected abstract int getContentLayoutId();

    protected abstract void doingOnCreate();

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.getWindow()
                    .getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

//            MIUISetStatusBarLightMode(this.getWindow(), true);
//            FlymeSetStatusBarLightMode(this.getWindow(), true);
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
            ButterKnife.bind(this);
        }

        doingOnCreate();
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

    private HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(LogUtil.httpLogLevel);
    private OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(logging)
            .build();

    public Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://v.juhe.cn/todayOnhistory/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();


    public static boolean FlymeSetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            try {
                WindowManager.LayoutParams lp = window.getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                window.setAttributes(lp);
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }

    public static boolean MIUISetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            Class clazz = window.getClass();
            try {
                int darkModeFlag = 0;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if (dark) {
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag);//状态栏透明且黑色字体
                } else {
                    extraFlagField.invoke(window, 0, darkModeFlag);//清除黑色字体
                }
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }
}
