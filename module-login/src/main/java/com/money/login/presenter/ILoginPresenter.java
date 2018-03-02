package com.money.login.presenter;

import com.money.common.base.IBasePresenter;
import com.money.login.view.ILoginView;

/**
 * Created by Administrator on 2018/3/1.
 */


public interface ILoginPresenter extends IBasePresenter<ILoginView> {

    void doLogin();

}
