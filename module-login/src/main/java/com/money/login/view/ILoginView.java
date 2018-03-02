package com.money.login.view;

import com.money.common.base.IBaseView;

/**
 * Created by Administrator on 2018/3/1.
 */

public interface ILoginView extends IBaseView {

    void loginSuccess();

    void loginFailure();

    void loginIng();

    String getAccount();

    String getPassword();
}
