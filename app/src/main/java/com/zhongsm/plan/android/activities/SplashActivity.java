package com.zhongsm.plan.android.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.zhongsm.android.BaseActivity;
import com.zhongsm.plan.R;
import com.zhongsm.plan.consts.Constant;
import com.zhongsm.util.LogUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

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
    protected void doingOnCreat() {
        ButterKnife.bind(this);
        tvDelay.setText(delay + "s");
    }

    @Override
    protected void doingOnResume() {
        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                delayHandler.sendEmptyMessage(0);
//            }
//        }, 1000, 1000);


        TianqiService tinqi = retrofit.create(TianqiService.class);
        tinqi.getTianqi().enqueue(new Callback<TianQiVo>() {
            @Override
            public void onResponse(Call<TianQiVo> call, retrofit2.Response<TianQiVo> response) {

                LogUtil.d(TAG, "哈哈11111");
                LogUtil.d(TAG, response.body().getError_code() + "\n" + response.body().getReason() + response.body().getResult().size());
            }

            @Override
            public void onFailure(Call<TianQiVo> call, Throwable t) {
                LogUtil.d(TAG, "哈哈222222");
                LogUtil.d(TAG, t.getMessage());
                t.printStackTrace();
            }
        });
    }

    @OnClick(R.id.layout_delay)
    void gotoHomePage() {
        timer.cancel();

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
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

    public interface TianqiService {
        @GET("queryEvent.php?date=3/20&key=" + Constant.JUHE_API_KEY)
        Call<TianQiVo> getTianqi();
    }

    public class TianQiVo implements Serializable {
        private String error_code;
        private String reason;
        private List result;

        public String getError_code() {
            return error_code;
        }

        public void setError_code(String error_code) {
            this.error_code = error_code;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public List getResult() {
            return result;
        }

        public void setResult(List result) {
            this.result = result;
        }
    }
}
