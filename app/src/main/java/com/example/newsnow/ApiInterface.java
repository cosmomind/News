package com.example.newsnow;

import com.example.newsnow.Models.Newsapiresponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
String BASE_URL =    "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<Newsapiresponse> get_Callheadlines(

            @Query("country") String country,
            @Query("pageSize") int pagesize,


           // @Query("category") String category,
            //@Query("q") String query,
            @Query("apiKey") String api_key);
//if u go to newsapi website u can see that the get call comes before query


;

}
