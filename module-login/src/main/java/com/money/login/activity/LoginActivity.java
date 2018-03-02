package com.money.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.money.common.base.BaseActivity;
import com.money.login.R;
import com.money.login.presenter.ILoginPresenter;
import com.money.login.view.ILoginView;
import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2018/2/24.
 */

@Route(path = "/login/loginActivity")
public class LoginActivity extends BaseActivity implements ILoginView {

    private Button helloB;

    @Autowired
    ILoginPresenter presenter;

    @Override
    public void overloadInitView(Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);
        helloB = (Button) findViewById(R.id.helloB);
    }

    @Override
    public void overloadSetOnClickListener() {
        helloB.setOnClickListener(this);
    }

    @Override
    public void overloadSetValue() {
        presenter.setView(this);
    }

    @Override
    public void overloadOnClickListener(View v, int id, Object tag) {
        presenter.doLogin();
    }

    @Override
    public int initLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public String getReqTag() {
        return null;
    }

    @Override
    public void overloadOnReceive(String action, Intent intent) {

    }

    @Override
    public void loginIng() {

    }

    @Override
    public String getAccount() {
        return "钱镇";
    }

    @Override
    public String getPassword() {
        return "121313asdasd";
    }

    @Override
    public void loginSuccess() {
        Logger.d("loginSuccess");
    }

    @Override
    public void loginFailure() {

    }
}
