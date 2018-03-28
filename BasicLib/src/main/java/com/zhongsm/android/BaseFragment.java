package com.zhongsm.android;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhongsm.R;

import butterknife.ButterKnife;

/**
 * TODO
 *
 * @author WangJ jie581825@yeah.net 2018/3/9
 * @version TODO
 *          Modified: TODO
 *          Modified on 2018/3/9 by TODO
 */
public abstract class BaseFragment extends Fragment {
    protected static String TAG;

    protected abstract int getFragmnetLayoutId();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        if (getFragmnetLayoutId() > 0) {
            view = inflater.inflate(getFragmnetLayoutId(), container, false);
        } else {
            view = inflater.inflate(R.layout.error, container, false);
        }
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        TAG = getClass().getSimpleName();
    }
}