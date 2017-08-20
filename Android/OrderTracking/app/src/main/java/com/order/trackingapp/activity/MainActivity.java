package com.order.trackingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.order.trackingapp.R;
import com.order.trackingapp.api.model.main.User;
import com.order.trackingapp.fragment.AdminDashBoardFragment;
import com.order.trackingapp.fragment.BaseFragment;
import com.order.trackingapp.fragment.HomeFragment;
import com.order.trackingapp.fragment.LoginFragment;
import com.order.trackingapp.utils.Constant;
import com.order.trackingapp.utils.PreferenceUtil;

/**
 * Created by umesh on 15/8/17.
 */

public class MainActivity extends BaseActivity implements BaseFragment.FragmentNavigation{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigateFragment(getStartupFragmentId(), true);
    }




    private void navigateFragment(int fragmentId, boolean addToBackstack){
        Fragment fragment = null;
        String tag  = null;
        switch (fragmentId){
            case Constant.FragmentId.LOGIN_FRAGMENT:
                fragment = LoginFragment.newInstance();
                tag = Constant.FragmentTag.LOGINFRAGMENT;
                break;
            case Constant.FragmentId.ADMIN_FRAGMENT:
                fragment = AdminDashBoardFragment.newInstance();
                tag = Constant.FragmentTag.ADMIN_FRAGMENT;
                break;
            default:
                fragment = HomeFragment.newInstance();
                tag = Constant.FragmentTag.HOME_FRAGMENT;
                break;
        }

        FragmentManager  fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, tag);
        if(addToBackstack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();

    }

    @Override
    public void addNewFragment(int fragmentId, boolean addToBackStack) {
        navigateFragment(fragmentId, addToBackStack);
    }

    @Override
    public void popFragment() {
        if(getSupportFragmentManager().getBackStackEntryCount() >1) {
            getSupportFragmentManager().popBackStack();
        }else{
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() >1) {
            getSupportFragmentManager().popBackStack();
        }else{
            finish();
        }
    }

    @Override
    public void navigateOnLoginSuccess() {
        getSupportFragmentManager().popBackStack();
        navigateFragment(getStartupFragmentId(), true);
    }

    public int getStartupFragmentId(){
        PreferenceUtil preferenceUtil = PreferenceUtil.newInstance(this);
        if(preferenceUtil.isUserLoggedIn()){
            User user = preferenceUtil.getUserProfile();
            switch (user.getRoleId()){
                case Constant.LoginType.ADMIN:
                    return Constant.FragmentId.ADMIN_FRAGMENT;
                case Constant.LoginType.PRODUCTION:
                    return Constant.FragmentId.PRODUCTION_FRAGMENT;
                case Constant.LoginType.SALESMAN:
                    return Constant.FragmentId.SALESMAN_FRAGMENT;
            }
        }else{
            return Constant.FragmentId.LOGIN_FRAGMENT;
        }
        return 0;
    }
}
