package com.example.newsnow;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class section_news extends Fragment {



    public section_news() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_section_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardView ent,sp,hea,tech,sci,bus;
       ent= view.findViewById(R.id.ent);
        sp = view.findViewById(R.id.sp);
        hea = view.findViewById(R.id.hea);
        tech = view.findViewById(R.id.tech);
        sci = view.findViewById(R.id.sci);
        bus = view.findViewById(R.id.bus);


        ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Entertainment.class);
                startActivity(intent);

            }
        });

        sci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Science.class);
                startActivity(intent);

            }
        });
        sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Sports.class);
                startActivity(intent);

            }
        });
        hea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Health.class);
                startActivity(intent);

            }
        });
        tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Technology.class);
                startActivity(intent);

            }
        });
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Business.class);
                startActivity(intent);

            }
        });

    }
}