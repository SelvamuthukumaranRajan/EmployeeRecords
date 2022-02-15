package com.example.employeerecords.retrofitUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static RetrofitClient instance = null;
    private RetrofitAPI myAPI;

    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitAPI.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myAPI = retrofit.create(RetrofitAPI.class);
    }

    public static synchronized RetrofitClient getInstance(){
        if(instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public RetrofitAPI getMyAPI(){
        return myAPI;
    }
}
