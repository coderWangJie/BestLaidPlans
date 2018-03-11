package com.zhongsm.plan.android;

import android.content.Intent;

import com.zhongsm.android.BaseActivity;
import com.zhongsm.plan.R;
import com.zhongsm.util.LogUtil;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity {

    @Override
    protected int loadContentLayoutID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void loadViewData() {
        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LogUtil.d(TAG, "激活");
            }
        }, 1000, 2000);

//        timer.cancel();
    }
}
