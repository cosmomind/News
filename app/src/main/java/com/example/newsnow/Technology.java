package com.example.newsnow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.newsnow.Models.Newsapiresponse;
import com.example.newsnow.Models.Newsheadlines;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Technology extends AppCompatActivity {


    String api = "78e14e21361d4ffb8342672fb7737222";
    RecyclerView recyclerviewent ;
    Customadapter adapter;
    Context thiscontext;
    ArrayList<Newsheadlines> list;

    String country = "in";
    private String category = "technology";


    public Technology() {
        // Required empty public constructor
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology);


        //thiscontext = container.getContext();

        recyclerviewent = findViewById(R.id.recycler_home);
        list = new ArrayList<>();
        recyclerviewent .setHasFixedSize(true);
        recyclerviewent .setLayoutManager(new GridLayoutManager(thiscontext,1));
        adapter = new Customadapter(this,list);
        recyclerviewent.setAdapter(adapter);

        shownews();

    }
    private void shownews() {

        RequestManager.getApiInterface().get_Category_News(country,100,category,api).enqueue(new Callback<Newsapiresponse>() {
            @Override
            public void onResponse(Call<Newsapiresponse> call, Response<Newsapiresponse> response) {
                if(response.isSuccessful()){
                    list.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Newsapiresponse> call, Throwable t) {

            }
        });
    }
}