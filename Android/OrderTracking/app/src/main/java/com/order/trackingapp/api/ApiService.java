package com.order.trackingapp.api;

import com.order.trackingapp.api.model.request.LoginRequest;
import com.order.trackingapp.api.model.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by umesh on 16/8/17.
 */

public interface ApiService {
    @POST("index.php?r=users/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}
