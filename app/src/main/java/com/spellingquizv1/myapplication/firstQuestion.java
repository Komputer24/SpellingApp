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

public class firstQuestion extends AppCompatActivity {
    private Button button;

    public static Integer score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_question);
        // Program Start

        //moveTaskToBack(false);

        ImageView myImageView = (ImageView) findViewById(R.id.dogPic);
        myImageView.setImageResource(R.drawable.dogpic);

        ImageView checkMark = (ImageView) findViewById(R.id.checkmark);
        ImageView wrongMark = (ImageView) findViewById(R.id.wrongmark);

        final MediaPlayer correctSfx = MediaPlayer.create(this, R.raw.dingsfx);
        final MediaPlayer wrongSfx = MediaPlayer.create(this, R.raw.wrongsfx);

        Button cDogOpt = (Button) findViewById(R.id.dogOpt1);
        Button wDogOpt2 = (Button) findViewById(R.id.dogOpt2);
        Button wDogOpt3 = (Button) findViewById(R.id.dogOpt3);

        cDogOpt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                score++;
                cDogOpt.setClickable(false);
                wDogOpt2.setEnabled(false);
                wDogOpt2.setBackgroundColor(Color.GRAY);
                wDogOpt3.setEnabled(false);
                wDogOpt3.setBackgroundColor(Color.GRAY);

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

        wDogOpt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cDogOpt.setEnabled(false);
                cDogOpt.setBackgroundColor(Color.GRAY);
                wDogOpt2.setClickable(false);
                wDogOpt3.setEnabled(false);
                wDogOpt3.setBackgroundColor(Color.GRAY);

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

        wDogOpt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cDogOpt.setEnabled(false);
                cDogOpt.setBackgroundColor(Color.GRAY);
                wDogOpt2.setEnabled(false);
                wDogOpt2.setBackgroundColor(Color.GRAY);
                wDogOpt3.setClickable(false);

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
        Intent intent = new Intent(this, secondQuestion.class);
        startActivity(intent);
    }
}