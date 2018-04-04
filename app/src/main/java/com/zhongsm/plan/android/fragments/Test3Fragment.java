package com.zhongsm.plan.android.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhongsm.android.BaseFragment;
import com.zhongsm.plan.R;
import com.zhongsm.plan.android.activities.HomeActivity;
import com.zhongsm.plan.android.activities.history.EventDetailActivity;
import com.zhongsm.plan.android.entity.frag3.EventList;
import com.zhongsm.plan.consts.Constant;
import com.zhongsm.util.LogUtil;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * TODO
 *
 * @author WangJ jie581825@yeah.net 2018/3/9
 * @version TODO
 *          Modified: TODO
 *          Modified on 2018/3/9 by TODO
 */
public class Test3Fragment extends BaseFragment {
    private static final String TAG = PersonalInfoFragment.class.getSimpleName();

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_test3;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Calendar calendar = Calendar.getInstance();
        String date = calendar.get(Calendar.MONTH) + 1 + "/" + calendar.get(Calendar.DAY_OF_MONTH);

        HistoryEventService eventService = ((HomeActivity) getActivity()).retrofit.create(HistoryEventService.class);
        eventService.getEventList(date, Constant.JUHE_API_KEY).enqueue(new Callback<EventList>() {
            @Override
            public void onResponse(Call<EventList> call, retrofit2.Response<EventList> response) {
                initHistoryList(response.body().getResult());
            }

            @Override
            public void onFailure(Call<EventList> call, Throwable t) {
                LogUtil.e(TAG, t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void initHistoryList(final List<EventList.SimpleEventVo> result) {
        LogUtil.d(TAG, "EventList-size:" + result.size());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        EventListAdapter adapter = new EventListAdapter(getActivity(), result);
        adapter.setItemClickListener(new MyItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), EventDetailActivity.class);
                intent.putExtra("eventId", result.get(position).getE_id());
                intent.putExtra("eventDate", result.get(position).getDate());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }


    interface MyItemClickListener {
        void onItemClick(int position);
    }

    /**
     * 适配器
     */
    class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.MyViewHolder> {

        private MyItemClickListener itemClickListener;

        public void setItemClickListener(MyItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        private Context context;
        private List<EventList.SimpleEventVo> list;

        public EventListAdapter(Context context, List<EventList.SimpleEventVo> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_history_event, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            EventList.SimpleEventVo vo = list.get(position);
            holder.tvDate.setText(vo.getDate());
            holder.tvName.setText(vo.getTitle());

            holder.tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(position);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        /**
         * Item的ViewHolder
         */
        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tvDate;
            TextView tvName;

            public MyViewHolder(View itemView) {
                super(itemView);
                tvDate = (TextView) itemView.findViewById(R.id.tv_eventDate);
                tvName = (TextView) itemView.findViewById(R.id.tv_eventName);
            }
        }
    }

    public interface HistoryEventService {
        @GET("queryEvent.php")
        Call<EventList> getEventList(@Query("date") String date, @Query("key") String key);
    }

}