package com.money.common.http.service;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;


/**
 * Created by Money.
 */

public interface BaseService {
//    http://localhost:8080/moments/
//    String BASE_URL = "http://192.168.1.125:8080/moments/";
//    String BASE_URL = "http://103.208.33.33:8081/";http://124.130.131.90:8023/Code_HttpService/
//    String BASE_URL = "http://124.130.131.90:8023/Code_HttpService/";
//    String BASE_URL = "http://58.58.116.77:8001/Code_HttpService/";
//    String BASE_URL = "http://192.168.2.142:8080/web/";
    String BASE_URL = "http://www.tshuiwan.com:8082/wp/webapi/";

    @POST
    Observable<String> post(@Url String url, @Body String map);

    @FormUrlEncoded
    @POST
    Observable<String> postParams(@Url String url, @FieldMap Map<String, Object> map);

}
