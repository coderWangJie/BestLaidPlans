package com.zhongsm.plan.android.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.zhongsm.android.BaseActivity;
import com.zhongsm.plan.R;
import com.zhongsm.plan.android.fragments.AdvancesFragment;
import com.zhongsm.plan.android.fragments.PersonalInfoFragment;
import com.zhongsm.plan.android.fragments.Test2Fragment;
import com.zhongsm.plan.android.fragments.Test3Fragment;

public class HomeActivity extends BaseActivity {

    private FragmentManager fragmentManager;

    private AdvancesFragment advancesFragment;
    private Test2Fragment test2Fragment;
    private Test3Fragment test3Fragment;
    private PersonalInfoFragment personalFragment;

    private Fragment currentFragment;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void doingOnCreat() {
        fragmentManager = getFragmentManager();

        advancesFragment = new AdvancesFragment();
        test2Fragment = new Test2Fragment();
        test3Fragment = new Test3Fragment();
        personalFragment = new PersonalInfoFragment();

        currentFragment = advancesFragment;

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch (i) {
                    case R.id.radio_frag1:
                        switchShowedFragment(R.id.frame_container, advancesFragment);
                        break;

                    case R.id.radio_frag2:
                        switchShowedFragment(R.id.frame_container, test2Fragment);
                        break;

                    case R.id.radio_frag3:
//                        switchShowedFragment(R.id.frame_container, test2Fragment);
                        break;

                    case R.id.radio_frag4:
                        switchShowedFragment(R.id.frame_container, test3Fragment);
                        break;

                    case R.id.radio_frag5:
                        switchShowedFragment(R.id.frame_container, personalFragment);
                        break;
                }
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    protected void doingOnResume() {
    }

    private void switchShowedFragment(int containerId, Fragment fragment) {
        if (currentFragment == fragment) {
            return;
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragment.isAdded()) {
            transaction.hide(currentFragment);
            transaction.show(fragment);
        } else {
            transaction.hide(currentFragment);
            transaction.add(containerId, fragment, fragment.getClass().getSimpleName());
        }

        transaction.commit();
        currentFragment = fragment;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO 保存想要存留的数据
        super.onSaveInstanceState(outState);
    }
}
