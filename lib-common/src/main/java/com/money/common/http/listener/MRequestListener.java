package com.money.common.http.listener;


/**
 * Created by Money.
 */

public interface MRequestListener {

    void onSuccess(String url, String response, Object reqTag, String... byValue);

    void onError(String url, String response, Object reqTag, String... byValue);
}
