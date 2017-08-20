package com.order.trackingapp.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;

import com.order.trackingapp.R;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created by umesh on 16/8/17.
 */

public class BaseFragment extends Fragment{

    protected FragmentNavigation mFragmentNavigation;
    protected ProgressDialog mProgressDialog;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mFragmentNavigation = (FragmentNavigation) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setTitle("");
        mProgressDialog.setMessage("Please wait...");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setCancelable(false);
    }

    protected void showProgressDialog(){
        if(mProgressDialog != null && !mProgressDialog.isShowing()){
            mProgressDialog.show();
        }
    }

    protected void hideProgressDialog(){
        if(mProgressDialog != null && mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    protected void showErrorMessage(int resId){
        // Define configuration options
        Configuration croutonConfiguration = new Configuration.Builder()
                .setDuration(2500).build();
        // Define custom styles for crouton
        Style style = new Style.Builder()
                .setBackgroundColorValue(Color.RED)
                .setGravity(Gravity.CENTER_HORIZONTAL)
                .setConfiguration(croutonConfiguration)
                .setHeight(150)
                .setTextColorValue(Color.WHITE).build();
        // Display notice with custom style and configuration
        Crouton.showText(getActivity(), resId, style);
    }

    protected void showErrorMessage(String message){
        // Define configuration options
        Configuration croutonConfiguration = new Configuration.Builder()
                .setDuration(2500).build();
        // Define custom styles for crouton
        Style style = new Style.Builder()
                .setBackgroundColorValue(Color.RED)
                .setGravity(Gravity.CENTER_HORIZONTAL)
                .setConfiguration(croutonConfiguration)
                .setHeight(150)
                .setTextColorValue(Color.WHITE).build();
        // Display notice with custom style and configuration
        Crouton.showText(getActivity(), message, style);
    }

    protected boolean isInternetConnected(){
        ConnectivityManager cm =
                (ConnectivityManager)getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
    public interface FragmentNavigation{
        void addNewFragment(int fragmentId, boolean addToBackStack);
        void popFragment();
        void navigateOnLoginSuccess();
    }
}
