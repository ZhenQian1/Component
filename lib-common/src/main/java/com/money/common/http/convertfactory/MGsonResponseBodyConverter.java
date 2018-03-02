package com.money.common.http.convertfactory;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;


/**
 * 返回数据的处理  解密或者其他的操作
 * @param <T>
 */
public class MGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    public static final String TAG = MGsonResponseBodyConverter.class.getSimpleName();

    private final Gson mGson;//gson对象
    private final TypeAdapter<T> adapter;

    /**
     * 构造器
     */
    public MGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.mGson = gson;
        this.adapter = adapter;
    }


    @Override
    public T convert(ResponseBody value) throws IOException {

        return (T)value.string();
    }
}
