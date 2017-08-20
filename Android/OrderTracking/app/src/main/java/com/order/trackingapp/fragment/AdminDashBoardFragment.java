package com.order.trackingapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.order.trackingapp.R;

/**
 * Created by umesh on 18/8/17.
 */

public class AdminDashBoardFragment extends BaseFragment{

    public static AdminDashBoardFragment newInstance(){
        return new AdminDashBoardFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.admin_dashboard_fragment, container, false);
    }
}
