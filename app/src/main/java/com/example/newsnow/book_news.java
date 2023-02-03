package com.example.newsnow;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newsnow.Models.Newsapiresponse;
import com.example.newsnow.Models.Newsheadlines;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class book_news extends Fragment {


    String api = "78e14e21361d4ffb8342672fb7737222";
    RecyclerView recyclerview ;
    Customadapter adapter;
    Context thiscontext;
    ArrayList<Newsheadlines> list;
    SearchView searchview;
    String country = "in";



    public book_news() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_book_news, container, false);
        // Inflate the layout for this fragment
        thiscontext = container.getContext();
        searchview = v.findViewById(R.id.sv);
        searchview.clearFocus();//to remove cursor at edittext;
        recyclerview = v.findViewById(R.id.recycler_home);
        list = new ArrayList<>();


        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new GridLayoutManager(thiscontext,1));
        adapter = new Customadapter(thiscontext,list);
        recyclerview.setAdapter(adapter);

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filernews(newText);
                return true;
            }


        });

        shownews();




        return v;



    }

    private void filernews(String text) {

        ArrayList<Newsheadlines> searchlist = new ArrayList<>();
        for (Newsheadlines item:list ) {
           if(item.getTitle().toLowerCase().contains(text.toLowerCase())){
               searchlist.add(item);
           }
        }

        if(searchlist.isEmpty()){
                   Toast.makeText(thiscontext,"No news found",Toast.LENGTH_SHORT).show();
        }
        else{
           adapter.setsearchlist(searchlist);
        }

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