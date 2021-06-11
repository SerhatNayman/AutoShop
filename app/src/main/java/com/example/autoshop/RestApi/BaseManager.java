package com.example.autoshop.RestApi;

public class BaseManager {
    protected RestApi getRestApi(){

        RestApiClient restApiClient = new RestApiClient(BaseURL.URL);
        return restApiClient.getmRestApi();




    }
    protected  RestApi getRestApi1(){

        RestApiClient restApiClient1 = new RestApiClient(BaseURL.ResimEkleURL);
        return restApiClient1.getmRestApi();

    }


}
