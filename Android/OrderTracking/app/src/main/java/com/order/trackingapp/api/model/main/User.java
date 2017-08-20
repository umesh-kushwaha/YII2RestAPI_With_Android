package com.order.trackingapp.api.model.main;

import com.google.gson.annotations.SerializedName;

/**
 * Created by umesh on 16/8/17.
 */

public class User {

    @SerializedName("user_id")
    private int userId;
    @SerializedName("username")
    private String userName;
    @SerializedName("password")
    private String password;
    @SerializedName("secret_key")
    private String secretKey;
    @SerializedName("user_device_id")
    private String userDeviceId;
    @SerializedName("email")
    private String email;
    @SerializedName("role_id")
    private int roleId;
    @SerializedName("registered_date")
    private String registeredDate;
    @SerializedName("is_active")
    private int isActive;
    @SerializedName("last_logged_in")
    private String lastLoggedIn;
    @SerializedName("mobile")
    private String mobileNo;
    @SerializedName("notification_token")
    private String notificationToken;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getUserDeviceId() {
        return userDeviceId;
    }

    public void setUserDeviceId(String userDeviceId) {
        this.userDeviceId = userDeviceId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(String lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getNotificationToken() {
        return notificationToken;
    }

    public void setNotificationToken(String notificationToken) {
        this.notificationToken = notificationToken;
    }
}
