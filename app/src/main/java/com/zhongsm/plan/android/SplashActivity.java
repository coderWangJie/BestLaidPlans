package com.zhongsm.plan.android;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhongsm.android.BaseActivity;
import com.zhongsm.plan.R;
import com.zhongsm.plan.consts.Constant;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity {
    private int delay = 4;

    private TextView tvDelay;

    private Timer timer;

    @Override
    protected int loadContentLayoutID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViews() {
        LinearLayout layoutDelay = (LinearLayout) findViewById(R.id.layout_delay);
        tvDelay = (TextView) findViewById(R.id.tv_delay);
        tvDelay.setText(delay + "s");

        layoutDelay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();

                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        String x = Constant.JUHE_API_KEY;
    }

    @Override
    protected void loadViewData() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                delayHandler.sendEmptyMessage(0);
            }
        }, 1000, 1000);
    }

    private Handler delayHandler = new Handler() {
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
