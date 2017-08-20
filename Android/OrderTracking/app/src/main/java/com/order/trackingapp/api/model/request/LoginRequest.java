package com.order.trackingapp.api.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by umesh on 16/8/17.
 */

public class LoginRequest {

    @SerializedName("username")
    private String userName;

    @SerializedName("password")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
