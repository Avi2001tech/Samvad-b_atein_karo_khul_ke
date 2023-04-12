package com.chat.samvad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;

public class splashScreen extends AppCompatActivity {
    LottieAnimationView lottie;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /*AppName = findViewById(R.id.AppName);*/
        lottie = findViewById(R.id.lottie);
        mAuth = FirebaseAuth.getInstance();


        lottie.animate().setDuration(3500).setStartDelay(20);
        lottie.animate().getInterpolator();
        lottie.playAnimation();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                if(mAuth.getCurrentUser()!=null){
                    Intent i = new Intent(splashScreen.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Intent i = new Intent(splashScreen.this,LoginActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        },5000);
    }
}