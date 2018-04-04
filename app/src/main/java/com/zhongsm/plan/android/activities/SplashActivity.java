package com.zhongsm.plan.android.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.zhongsm.android.BaseActivity;
import com.zhongsm.plan.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity {
    private int delay = 4;

    @BindView(R.id.tv_delay)
    TextView tvDelay;

    private Timer timer;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void doingOnCreate() {
        tvDelay.setText(delay + "s");
    }

    @Override
    protected void doingOnResume() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                delayHandler.sendEmptyMessage(0);
            }
        }, 1000, 1000);
    }

    @OnClick(R.id.layout_delay)
    void gotoHomePage() {
        timer.cancel();

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    // TODO 看看避免内存泄漏的Handler这么个写法
    Handler delayHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (delay == 0) {
                timer.cancel();

                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                delay--;
            }

            tvDelay.setText(delay + "s");
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        timer.cancel();
    }
}
