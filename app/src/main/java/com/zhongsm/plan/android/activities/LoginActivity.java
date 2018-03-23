package com.zhongsm.plan.android.activities;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;

import com.zhongsm.android.BaseActivity;
import com.zhongsm.plan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.til_account)
    TextInputLayout tilAccount;

    @BindView(R.id.tiet_account)
    TextInputEditText tietAccount;

    @BindView(R.id.til_pwd)
    TextInputLayout tilPWD;
    @BindView(R.id.tiet_pwd)
    TextInputEditText tietPwd;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void doingOnCreat() {
        ButterKnife.bind(this);
    }

    @Override
    protected void doingOnResume() {
    }

    @OnClick(R.id.tv_register)
    void gotoRegister(View view) {
        // TODO 注册
        toastShort("注册");
    }

    @OnClick(R.id.tv_resetPWD)
    void gotoResetPWD(View view) {
        // TODO 找回密码
        toastShort("找回密码");
    }

    @OnClick(R.id.btn_login)
    void doLogin(View view) {
        toastShort("登陆");
    }
}
