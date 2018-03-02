package com.money.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.money.common.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getName();

    private Button btn;

    @Override
    public void overloadInitView(Bundle savedInstanceState) {
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void overloadSetOnClickListener() {

    }

    @Override
    public void overloadSetValue() {

    }

    @Override
    public void overloadOnClickListener(View v, int id, Object tag) {
        if (v == btn){
            ARouter.getInstance().build("/login/loginActivity").navigation();
        }
    }

    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public String getReqTag() {
        return TAG;
    }

    @Override
    public void overloadOnReceive(String action, Intent intent) {

    }
}
