package com.example.autoshop.RestApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {
    private RestApi mRestApi;


    public RestApiClient(String restApiServiceUrl) {


        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
                .writeTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
                .connectTimeout(3, java.util.concurrent.TimeUnit.SECONDS);

        OkHttpClient okHttpClient = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(restApiServiceUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mRestApi = retrofit.create(RestApi.class);


    }

    public RestApi getmRestApi() {

        return mRestApi;

    }


}