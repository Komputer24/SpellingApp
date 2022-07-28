package com.spellingquizv1.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class thirdQuestion extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_question);
        // Program Start

        //moveTaskToBack(false);

        ImageView myImageView = (ImageView) findViewById(R.id.fishPic);
        myImageView.setImageResource(R.drawable.fishpic);

        ImageView checkMark = (ImageView) findViewById(R.id.checkmark3);
        ImageView wrongMark = (ImageView) findViewById(R.id.wrongmark3);

        final MediaPlayer correctSfx = MediaPlayer.create(this, R.raw.dingsfx);
        final MediaPlayer wrongSfx = MediaPlayer.create(this, R.raw.wrongsfx);

        Button wFishOpt1 = (Button) findViewById(R.id.fishOpt1);
        Button cFishOpt = (Button) findViewById(R.id.fishOpt2);
        Button wFishOpt3 = (Button) findViewById(R.id.fishOpt3);

        cFishOpt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                firstQuestion.score++;
                wFishOpt1.setEnabled(false);
                wFishOpt1.setBackgroundColor(Color.GRAY);
                cFishOpt.setClickable(false);
                wFishOpt3.setEnabled(false);
                wFishOpt3.setBackgroundColor(Color.GRAY);

                correctSfx.start();
                checkMark.setVisibility(View.VISIBLE);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        checkMark.setVisibility(View.INVISIBLE);
                        openActivity();
                    }
                }, 1000);
            }
        });

        wFishOpt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                wFishOpt1.setClickable(false);
                cFishOpt.setEnabled(false);
                cFishOpt.setBackgroundColor(Color.GRAY);
                wFishOpt3.setEnabled(false);
                wFishOpt3.setBackgroundColor(Color.GRAY);

                wrongSfx.start();
                wrongMark.setVisibility(View.VISIBLE);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        wrongMark.setVisibility(View.INVISIBLE);
                        openActivity();
                    }
                }, 1000);
            }
        });

        wFishOpt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                wFishOpt1.setEnabled(false);
                wFishOpt1.setBackgroundColor(Color.GRAY);
                cFishOpt.setEnabled(false);
                cFishOpt.setBackgroundColor(Color.GRAY);
                wFishOpt3.setClickable(false);

                wrongSfx.start();
                wrongMark.setVisibility(View.VISIBLE);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        wrongMark.setVisibility(View.INVISIBLE);
                        openActivity();
                    }
                }, 1000);
            }
        });
    }
    public void openActivity(){
        Intent intent = new Intent(this, EndScreen.class);
        startActivity(intent);
    }
}