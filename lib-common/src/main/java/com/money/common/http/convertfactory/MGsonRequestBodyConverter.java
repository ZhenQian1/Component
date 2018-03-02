package com.money.common.http.convertfactory;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;


/**
 * 请求的数据处理    加密或者其他的操作
 * @param <T>
 */
public class MGsonRequestBodyConverter<T> implements Converter<T, RequestBody> {

    public static final String TAG = MGsonRequestBodyConverter.class.getSimpleName();

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    public MGsonRequestBodyConverter(Gson gson, TypeAdapter<T> adapter){

        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public RequestBody convert(T value) throws IOException {

        byte[] reqData = new byte[0];
        try {

            String reqString = value.toString();

            reqData = reqString.getBytes("utf-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return RequestBody.create(MEDIA_TYPE, reqData);
    }
}
