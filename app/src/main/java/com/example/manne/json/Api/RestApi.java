package com.example.manne.json.Api;

import android.content.Context;

import com.example.manne.json.BuildConfig;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by manne on 04.7.2019.
 */

public class RestApi {

    private String token;
    private ApiService mApiService;

    public RestApi(Context context) {

//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder okClient = new OkHttpClient.Builder();
        okClient.addInterceptor(chain -> {
            Request request;
            request = chain.request();
            request = request.newBuilder()
                    .addHeader("Content-Type", "application/json")
                    //.addHeader("Authorization", token)
                    .build();
            return chain.proceed(request);
        })
                .connectTimeout(40, TimeUnit.SECONDS)
                .writeTimeout(40, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS);


        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation();
        Retrofit retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.mApiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return mApiService;
    }
  /*  public static final int request_max_time_tn_seconds=20;

    public Context activity;

    public RestApi(Context activity){
        this.activity=activity;
    }

    public Retrofit getRetrofitInstance(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .readTimeout(request_max_time_tn_seconds, TimeUnit.SECONDS)
                .connectTimeout(request_max_time_tn_seconds, TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
//                .baseUrl(ApiConstants.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public ApiService request(){
        return getRetrofitInstance().create(ApiService.class);
    }

    public Call<DataResponse>postUsename(String header, User user){
        return request().postUserInfo(header, user);
    }*/



}
