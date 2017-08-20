package com.order.trackingapp.utils;

import com.order.trackingapp.fragment.AdminDashBoardFragment;
import com.order.trackingapp.fragment.HomeFragment;
import com.order.trackingapp.fragment.LoginFragment;

/**
 * Created by umesh on 15/8/17.
 */

public interface  Constant {

    interface FragmentId{
        int LOGIN_FRAGMENT = 1;
        int ADMIN_FRAGMENT = 2;
        int SALESMAN_FRAGMENT = 3;
        int PRODUCTION_FRAGMENT = 4;
    }

    interface FragmentTag{
        String LOGINFRAGMENT = LoginFragment.class.getName();
        String HOME_FRAGMENT = HomeFragment.class.getName();
        String ADMIN_FRAGMENT = AdminDashBoardFragment.class.getName();
    }

    interface Extras{
        String FRAGMENT_ID = "fragment_id";
    }

    interface Preference{
        String IS_USER_LOGGEDIN = "IS_USER_LOGGEDIN";
        String USER_PROFILE_DATA = "USER_PROFILE_DATA";
    }

    interface LoginType{
        int ADMIN = 1;
        int SALESMAN = 2;
        int PRODUCTION = 3;
    }
}
