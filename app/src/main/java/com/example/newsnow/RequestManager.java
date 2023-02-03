package com.example.newsnow;

import android.content.Context;
import android.widget.Toast;

import com.example.newsnow.Models.Newsapiresponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {
//to handle api calls rather than writing it in mainactivity.java
    private static Retrofit retrofit = null;

    Context context;

    public static  ApiInterface getApiInterface(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit.create(ApiInterface.class);

    }






}
