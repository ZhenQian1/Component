package com.money.login.presenter.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.money.common.http.listener.MRequestListener;
import com.money.login.presenter.ILoginPresenter;
import com.money.login.view.ILoginView;
import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2018/3/1.
 */
@Route(path="/login/loginPresenter", name = "登录的presenter")
public class ILoginPresenterImpl implements ILoginPresenter, MRequestListener {

    ILoginView view;
    Context context;

    @Override
    public void setView(ILoginView view) {
        this.view = view;
    }

    @Override
    public void init(Context context) {
        this.context = context;
    }

    @Override
    public void doLogin() {
        Logger.d("account:" + view.getAccount()+", password:" + view.getPassword());

    }

    @Override
    public void onSuccess(String url, String response, Object reqTag, String... byValue) {

    }

    @Override
    public void onError(String url, String response, Object reqTag, String... byValue) {

    }
}
