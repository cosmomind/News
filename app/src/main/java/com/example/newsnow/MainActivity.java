package com.example.newsnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Animation topanim,bottomanim,scale;
    ImageView imgview;
    TextView txtview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//removing status bar

        topanim = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        scale = AnimationUtils.loadAnimation(this,R.anim.scalle);
        imgview =  findViewById(R.id.logo);
        txtview =  findViewById(R.id.slogan);

        imgview.setAnimation(topanim);
        txtview.setAnimation(bottomanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgview.setAnimation(scale);
                scale.setFillAfter(true);//the animation will stay like that
            }
        }, 1500 );



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,Home.class);
                startActivity(i);
                finish();

            }
        }, 2500 );




    }
}