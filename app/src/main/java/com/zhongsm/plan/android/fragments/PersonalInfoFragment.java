package com.zhongsm.plan.android.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zhongsm.android.BaseFragment;
import com.zhongsm.plan.R;

/**
 * TODO
 *
 * @author WangJ jie581825@yeah.net 2018/3/9
 * @version TODO
 *          Modified: TODO
 *          Modified on 2018/3/9 by TODO
 */
public class PersonalInfoFragment extends BaseFragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("LogWangJ", "fragment----onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("LogWangJ", "fragment----onCreate");
    }

    @Override
    protected int getFragmnetLayoutId() {
        Log.e("LogWangJ", "fragment----onCreateView");
        return R.layout.fragment_personal_info;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("LogWangJ", "fragment----onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("LogWangJ", "fragment----onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("LogWangJ", "fragment----onResume");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("LogWangJ", "fragment----onActivityCreated");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("LogWangJ", "fragment----onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("LogWangJ", "fragment----onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("LogWangJ", "fragment----onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("LogWangJ", "fragment----onDetach");
    }
}