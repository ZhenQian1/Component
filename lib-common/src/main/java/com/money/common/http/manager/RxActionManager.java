package com.money.common.http.manager;

import rx.Subscription;


/**
 * Created by Money.
 */

public interface RxActionManager<T> {

    void add(T tag, Subscription subscription);

    void remove(T tag);

    void cancel(T tag);

    void cancelAll();
}
