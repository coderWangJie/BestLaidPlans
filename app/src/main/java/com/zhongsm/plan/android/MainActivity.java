package com.zhongsm.plan.android;

import com.zhongsm.android.BaseActivity;
import com.zhongsm.plan.R;
import com.zhongsm.util.LogUtil;

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
        toastLong("哈哈");

        LogUtil.v("A", "A");
        LogUtil.d("A", "A");
        LogUtil.i("A", "A");
        LogUtil.w("A", "A");
        LogUtil.e("A", "A");
    }
}
