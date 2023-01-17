package com.example.newsnow;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends AppCompatActivity {

BottomNavigationView btmview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//removing status bar


        btmview = findViewById(R.id.btmview);


       btmview.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              int id = item.getItemId();


              if(id == R.id.home){
              loadfrag(new home_news(),true,0);
                  //code redundancy

              }
              else if(id == R.id.bookmark){
                  loadfrag(new book_news(),false,0);
              }
              else {
                  loadfrag(new section_news(),false,0);
                  //for section

              }

              return true;
           }


       });

   btmview.setSelectedItemId(R.id.home);


}

    public void loadfrag(Fragment fragment,boolean flag,int num){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag){
            ft.add(R.id.container,fragment);
            num = 1;
            if(num > 0){
                ft.replace(R.id.container,fragment);
            }
        }
       else{
            ft.replace(R.id.container,fragment);

        }
        ft.commit();
    }

}