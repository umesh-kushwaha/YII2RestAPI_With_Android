package com.order.trackingapp.api.model.response;

import com.google.gson.annotations.SerializedName;
import com.order.trackingapp.api.model.main.User;

/**
 * Created by umesh on 16/8/17.
 */

public class LoginResponse extends BaseResponse{

    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
