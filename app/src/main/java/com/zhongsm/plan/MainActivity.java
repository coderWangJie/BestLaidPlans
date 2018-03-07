package com.zhongsm.plan;

import com.zhongsm.android.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int loadContentLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        toastShort("柴狗熊");
    }

    @Override
    protected void loadViewData() {

    }
}
