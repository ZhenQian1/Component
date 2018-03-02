package com.money.common.http;

import com.google.gson.Gson;
import com.money.common.http.convertfactory.MGsonConverterFactory;
import com.money.common.http.listener.MRequestListener;
import com.money.common.http.manager.RxApiManager;
import com.money.common.http.service.BaseService;
import com.orhanobut.logger.Logger;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Money.
 */

public class HttpUtil {

    private static HttpUtil INSTANCE;

    private Retrofit retrofit;

    public static HttpUtil getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (HttpUtil.class) {
                INSTANCE = new HttpUtil();
            }
        }
        return INSTANCE;
    }

    public HttpUtil() {
        initRetrofit();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(BaseService.BASE_URL)
                .addConverterFactory(MGsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }

    //打印日志
    private static final HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private OkHttpClient getOkHttpClient() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logInterceptor)
//                .addInterceptor(new HeadInterceptor())
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool(8, 10, TimeUnit.SECONDS)) //线程池  8个  每个保持10毫秒
                .build();

        return okHttpClient;
    }

    public void doPost(final MRequestListener listener, final String url, Map<String, Object> map, final Object reqTag, final String... byValue) {

        BaseService service = retrofit.create(BaseService.class);
        Gson gson = new Gson();
        Observable<String> observable = service.postParams(url, map);

        Subscription subscription = observable.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        super.onStart();
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(url, e.toString(), reqTag, byValue);
                    }

                    @Override
                    public void onNext(String mResponse) {
                        Logger.d("response:" + mResponse);
                        listener.onSuccess(url, mResponse, reqTag, byValue);
                    }
                });
        RxApiManager.getINSTANCE().add(reqTag, subscription);
    }
}
