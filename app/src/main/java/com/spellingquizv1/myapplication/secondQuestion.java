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

public class secondQuestion extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_question);
        // Program Start

        //moveTaskToBack(false);

        ImageView myImageView = (ImageView) findViewById(R.id.catPic);
        myImageView.setImageResource(R.drawable.catpic);

        ImageView checkMark = (ImageView) findViewById(R.id.checkmark2);
        ImageView wrongMark = (ImageView) findViewById(R.id.wrongmark2);

        final MediaPlayer correctSfx = MediaPlayer.create(this, R.raw.dingsfx);
        final MediaPlayer wrongSfx = MediaPlayer.create(this, R.raw.wrongsfx);

        Button wCatOpt1 = (Button) findViewById(R.id.catOpt1);
        Button wCatOpt2 = (Button) findViewById(R.id.catOpt2);
        Button cCatOpt = (Button) findViewById(R.id.catOpt3);

        cCatOpt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                firstQuestion.score++;
                wCatOpt1.setEnabled(false);
                wCatOpt1.setBackgroundColor(Color.GRAY);
                wCatOpt2.setEnabled(false);
                wCatOpt2.setBackgroundColor(Color.GRAY);
                cCatOpt.setClickable(false);

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

        wCatOpt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                wCatOpt1.setClickable(false);
                wCatOpt2.setEnabled(false);
                wCatOpt2.setBackgroundColor(Color.GRAY);
                cCatOpt.setEnabled(false);
                cCatOpt.setBackgroundColor(Color.GRAY);

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

        wCatOpt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                wCatOpt1.setEnabled(false);
                wCatOpt1.setBackgroundColor(Color.GRAY);
                wCatOpt2.setClickable(false);
                cCatOpt.setEnabled(false);
                cCatOpt.setBackgroundColor(Color.GRAY);

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
        Intent intent = new Intent(this, thirdQuestion.class);
        startActivity(intent);
    }
}