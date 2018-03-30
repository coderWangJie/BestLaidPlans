package com.zhongsm.plan.android.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.zhongsm.android.BaseFragment;
import com.zhongsm.plan.R;
import com.zhongsm.util.LogUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * TODO
 *
 * @author WangJ jie581825@yeah.net 2018/3/9
 * @version TODO
 *          Modified: TODO
 *          Modified on 2018/3/9 by TODO
 */
public class PersonalInfoFragment extends BaseFragment {
    private static final String TAG = PersonalInfoFragment.class.getSimpleName();

    @BindView(R.id.img_portrait)
    ImageView imgPortrait;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "fragment----onCreate");
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_personal_info;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "fragment----onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "fragment----onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "fragment----onResume");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "fragment----onActivityCreated");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "fragment----onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "fragment----onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "fragment----onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "fragment----onDetach");
    }

    @OnClick(R.id.img_portrait)
    void clickPottrait(View view) {
        LogUtil.d(TAG, "点击");
    }
}