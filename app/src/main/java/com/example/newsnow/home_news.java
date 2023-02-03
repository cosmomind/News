package com.example.newsnow;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsnow.Models.Newsapiresponse;
import com.example.newsnow.Models.Newsheadlines;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class home_news extends Fragment {

   String api = "78e14e21361d4ffb8342672fb7737222";
    RecyclerView recyclerview ;
    Customadapter1 adapter;
    Context thiscontext;
    ArrayList<Newsheadlines> list;

    String country = "in";



    public home_news() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_news, container, false);
        // Inflate the layout for this fragment
        thiscontext = container.getContext();

        recyclerview = v.findViewById(R.id.recycler_home);
        list = new ArrayList<>();
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new GridLayoutManager(thiscontext,1));
        adapter = new Customadapter1(thiscontext,list);
        recyclerview.setAdapter(adapter);
        
        shownews();




        return v;



    }

    private void shownews() {

        RequestManager.getApiInterface().get_Callheadlines(country,100,api).enqueue(new Callback<Newsapiresponse>() {
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