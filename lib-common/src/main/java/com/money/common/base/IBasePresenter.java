package com.money.common.base;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by Administrator on 2018/3/1.
 */

public interface IBasePresenter<T extends IBaseView> extends IProvider {

    void setView(T view);

}
