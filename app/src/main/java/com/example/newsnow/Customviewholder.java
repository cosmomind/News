package com.example.newsnow;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Customviewholder extends RecyclerView.ViewHolder {

TextView txt_title,txt_source;
ImageView img_headline;

CardView cardview;


    public Customviewholder(@NonNull View itemView) {
        super(itemView);

        txt_title = itemView.findViewById(R.id.text_title);
        txt_source = itemView.findViewById(R.id.text_source);
        img_headline = itemView.findViewById(R.id.image_card);
        cardview = itemView.findViewById(R.id.main_container);



    }
}
