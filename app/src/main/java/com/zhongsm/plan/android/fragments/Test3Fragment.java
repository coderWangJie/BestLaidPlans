package com.zhongsm.plan.android.fragments;

import android.content.Context;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zhongsm.android.BaseFragment;
import com.zhongsm.plan.R;
import com.zhongsm.plan.android.activities.HomeActivity;
import com.zhongsm.plan.android.entity.frag3.EventList;
import com.zhongsm.plan.consts.Constant;
import com.zhongsm.util.LogUtil;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
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

//    @BindView(R.id.recyclerView)
//    RecyclerView recyclerView;

    @BindView(R.id.recyclerView)
    ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test3, container, false);

        // TODO 封装一下，找个合适的位置
        ButterKnife.bind(this, view);
        return view;
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

    private void initHistoryList(List<EventList.EventVo> result) {
        LogUtil.d(TAG, "EventList-size:" + result.size());

        lv.setAdapter(new EventListAdapter(getActivity(), result));
    }


    public interface HistoryEventService {
        @GET("queryEvent.php")
        Call<EventList> getEventList(@Query("date") String date, @Query("key") String key);
    }

    class EventListAdapter extends BaseAdapter {
//        @Override
//        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            return null;
//        }
//
//        @Override
//        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return 0;
//        }

        private Context context;
        private List<EventList.EventVo> list;

        public EventListAdapter(Context context, List<EventList.EventVo> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = View.inflate(context, R.layout.item_history_event, null);
                holder = new ViewHolder();
                holder.tvDate = (TextView) convertView.findViewById(R.id.tv_eventDate);
                holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_eventName);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            EventList.EventVo vo = list.get(position);
            holder.tvDate.setText(vo.getDate());
            holder.tvTitle.setText(vo.getTitle());
            return convertView;
        }

        class ViewHolder {
            TextView tvDate;
            TextView tvTitle;
        }
    }
}