package com.example.newsnow;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsnow.Models.Newsheadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Customadapter1 extends RecyclerView.Adapter<Customviewholder> {
    Context context;
    List<Newsheadlines> headlines;



    public Customadapter1(Context context, List<Newsheadlines> headlines) {
        this.context = context;
        this.headlines = headlines;
    }





    @NonNull
    @Override
    public Customviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Customviewholder(LayoutInflater.from(context).inflate(R.layout.headsinglehome,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Customviewholder holder, @SuppressLint("RecyclerView") int position) {
        //Newsnow
        holder.cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,webView.class);
                i.putExtra("url",headlines.get(position).getUrl());
                context.startActivity(i);

            }
        });


        holder.txt_title.setText(headlines.get(position).getTitle());
        holder.txt_desc.setText(headlines.get(position).getDescription());
//image loading
        if(headlines.get(position).getUrlToImage() != null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
        }


    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
