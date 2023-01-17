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


    //new method to manage api call

//    public void getNewsHeadlines(Onfetchdatalistener listener,String category,String query){
//      Callnewsapi callnewsapi = retrofit.create(Callnewsapi.class);//creating object
//        //Call opject
//       Call<Newsapiresponse> call = callnewsapi.Callheadlines("in",category,query,context.getString(R.string.api_key));
//
//
//       try{
//         call.enqueue(new Callback<Newsapiresponse>() {
//             @Override
//             public void onResponse(Call<Newsapiresponse> call, Response<Newsapiresponse> response) {
//                 if(!response.isSuccessful()){
//                     Toast.makeText(context,"Error!",Toast.LENGTH_SHORT).show();
//                 }
//
//                 listener.onFetchData(response.body().getArticles(), response.message());
//             }
//
//             @Override
//             public void onFailure(Call<Newsapiresponse> call, Throwable t) {
//                 listener.onError("Request Failed!");
//             }
//         });
//       }
//
//       catch (Exception e){
//           e.printStackTrace();
//       }


//    }
//    public RequestManager(Context context) {
//        this.context = context;    }

    //creating a new interface

//    public interface Callnewsapi{
//        //type Newsapiresponse in call,request parameters
//        @GET("top-headlines")
//Call<Newsapiresponse> get_Callheadlines(
//
//            @Query("country") String country,
//            @Query("category") String category,
//            @Query("q") String query,
//            @Query("apiKey") String api_key);
////if u go to newsapi website u can see that the get call comes before query
//
//
//    }
}
