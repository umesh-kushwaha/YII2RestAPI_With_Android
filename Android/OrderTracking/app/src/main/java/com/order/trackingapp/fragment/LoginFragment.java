package com.order.trackingapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.order.trackingapp.R;
import com.order.trackingapp.api.ApiService;
import com.order.trackingapp.api.ServiceGenerator;
import com.order.trackingapp.api.model.request.LoginRequest;
import com.order.trackingapp.api.model.response.LoginResponse;
import com.order.trackingapp.utils.Constant;
import com.order.trackingapp.utils.PreferenceUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by umesh on 15/8/17.
 */

public class LoginFragment extends BaseFragment implements Callback<LoginResponse> {


    private TextInputEditText mUserName;
    private TextInputEditText mPassword;
    private Button mLogin;
    public static LoginFragment newInstance(){
        return new LoginFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mUserName = (TextInputEditText) view.findViewById(R.id.username);
        mPassword = (TextInputEditText) view.findViewById(R.id.password);
        mLogin    = (Button) view.findViewById(R.id.btnlogin);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login(){
        if(isInternetConnected()) {
            ApiService apiService = ServiceGenerator.createService(ApiService.class);
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setUserName(mUserName.getText().toString());
            loginRequest.setPassword(mPassword.getText().toString());
            Call<LoginResponse> loginResponseCall = apiService.login(loginRequest);
            loginResponseCall.enqueue(this);
            showProgressDialog();
        }else{
            showErrorMessage(R.string.network_error);
        }
    }

    @Override
    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
        hideProgressDialog();
        if(response.isSuccessful() && response.errorBody() == null){
            LoginResponse loginResponse = response.body();
            if(loginResponse.isStatus()) {
                PreferenceUtil.newInstance(getContext()).setLoggedInStatus(true);
                PreferenceUtil.newInstance(getContext()).saveUser(loginResponse.getUser());
                mFragmentNavigation.navigateOnLoginSuccess();
            }else{
                /**
                 * show error
                 */
                Log.i("error",loginResponse.getMessage());
                showErrorMessage(loginResponse.getMessage());
            }
        }else{
            /**
             * Show error
             */
            showErrorMessage("Something went wrong.");
        }
    }

    @Override
    public void onFailure(Call<LoginResponse> call, Throwable t) {
        hideProgressDialog();

        /**
         * Show error
         */
        Log.i("error",t.getMessage());
        showErrorMessage(t.getMessage());
    }
}
