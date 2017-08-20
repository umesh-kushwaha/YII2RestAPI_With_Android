package com.order.trackingapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.order.trackingapp.R;

/**
 * Created by umesh on 15/8/17.
 */

public class HomeFragment extends BaseFragment{

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        return view;
    }
}
