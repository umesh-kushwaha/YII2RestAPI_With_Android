package com.order.trackingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.order.trackingapp.R;
import com.order.trackingapp.utils.Constant;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.putExtra(Constant.Extras.FRAGMENT_ID,Constant.FragmentId.LOGIN_FRAGMENT);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
