package com.zhongsm.plan.android.activities.history;

import android.widget.TextView;

import com.zhongsm.android.BaseActivity;
import com.zhongsm.plan.R;
import com.zhongsm.plan.android.entity.frag3.EventDetialVo;
import com.zhongsm.plan.consts.Constant;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class EventDetailActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_date)
    TextView tvDate;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_event_detail;
    }

    @Override
    protected void doingOnCreate() {
        String eventId = getIntent().getStringExtra("eventId");

        EventDetailService eventDetailService = retrofit.create(EventDetailService.class);
        eventDetailService.getEventDetail(eventId, Constant.JUHE_API_KEY).enqueue(new Callback<EventDetialVo>() {
            @Override
            public void onResponse(Call<EventDetialVo> call, Response<EventDetialVo> response) {
                EventDetialVo.EventVo vo = response.body().getResult().get(0);
                tvTitle.setText(vo.getTitle());
                tvDate.setText(getIntent().getStringExtra("eventDate"));
                tvContent.setText(vo.getContent());
            }

            @Override
            public void onFailure(Call<EventDetialVo> call, Throwable t) {

            }
        });
    }

    @Override
    protected void doingOnResume() {
    }

    public interface EventDetailService {
        @GET("queryDetail.php")
        Call<EventDetialVo> getEventDetail(@Query("e_id") String eventId, @Query("key") String key);
    }
}
