package com.order.trackingapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.order.trackingapp.api.model.main.User;

/**
 * Created by umesh on 16/8/17.
 */

public class PreferenceUtil {


    private static PreferenceUtil mPreferenceUtil;
    private static SharedPreferences mPref;
    private PreferenceUtil(Context context){
        mPref = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static PreferenceUtil newInstance(Context context){
        if(mPreferenceUtil == null){
            return new PreferenceUtil(context);
        }
        return mPreferenceUtil;
    }

    public  void setLoggedInStatus(boolean flag){
        SharedPreferences.Editor editor = mPref.edit();
        editor.putBoolean(Constant.Preference.IS_USER_LOGGEDIN, flag);
        editor.apply();
    }

    public  boolean isUserLoggedIn(){
        return mPref.getBoolean(Constant.Preference.IS_USER_LOGGEDIN, false);
    }

    public  void saveUser(User user){
        Gson gson = new Gson();
        String userData = gson.toJson(user, User.class);
        SharedPreferences.Editor editor = mPref.edit();
        editor.putString(Constant.Preference.USER_PROFILE_DATA, userData);
        editor.apply();
    }

    public  User getUserProfile(){
        Gson gson = new Gson();
        String userData = mPref.getString(Constant.Preference.USER_PROFILE_DATA, "");
        return gson.fromJson(userData, User.class);
    }
}
