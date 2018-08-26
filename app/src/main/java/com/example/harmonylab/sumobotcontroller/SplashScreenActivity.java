package com.example.harmonylab.sumobotcontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView imImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        imImageView = (ImageView) findViewById(R.id.imageView);
        Animation animateLogo = AnimationUtils.loadAnimation(this, R.anim.logo_transition);
        imImageView.startAnimation(animateLogo);

        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();
        //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //startActivity(intent);
        //finish();
    }

    private class LogoLauncher extends Thread{
        public void run(){
            try{
                sleep(2000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);

            SplashScreenActivity.this.finish();
        }
    }

}
