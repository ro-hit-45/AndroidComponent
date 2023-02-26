package com.example.truthdare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
Random mRandomNumber =new Random();
int lastDirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         imageView =findViewById(R.id.imageView);
         final Button mButton =findViewById(R.id.button);
         mButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int newDirection= mRandomNumber.nextInt(9999)+360;
              float pivoteX=(float)imageView.getWidth() /2;
              float pivoteY=(float)imageView.getWidth() /2;

                 Animation rotate= new RotateAnimation(lastDirection,newDirection,pivoteX,pivoteY);
                 rotate .setDuration(3000);
                 rotate.setFillAfter(true);

                 rotate.setAnimationListener(new Animation.AnimationListener() {
                     @Override
                     public void onAnimationStart(Animation animation) {
                         mButton.setEnabled(true);
                     }

                     @Override
                     public void onAnimationEnd(Animation animation) {

                     }

                     @Override
                     public void onAnimationRepeat(Animation animation) {

                     }
                 });
                 lastDirection=newDirection;
                 imageView.startAnimation(rotate);
             }
         });

    }
}