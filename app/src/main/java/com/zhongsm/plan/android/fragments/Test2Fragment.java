package com.zhongsm.plan.android.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class Test2Fragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_test2, container, false);
//        View view = inflater.inflate(R.layout.fragment_personal_info, null);
        return view;
    }
}