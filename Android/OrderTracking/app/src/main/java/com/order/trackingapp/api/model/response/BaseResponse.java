package com.order.trackingapp.api.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by umesh on 16/8/17.
 */

public class BaseResponse {

    @SerializedName("status_code")
    protected int statusCode;
    @SerializedName("status")
    protected boolean status;
    @SerializedName("message")
    protected String message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
