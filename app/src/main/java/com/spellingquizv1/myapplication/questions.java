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

import java.util.Random;

public class questions extends AppCompatActivity {
    private Button button;

    public static Integer score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        // Program Start

        ImageView myImageView = (ImageView) findViewById(R.id.questionPic);
        myImageView.setImageResource(R.drawable.dogpic);

        ImageView checkMark = (ImageView) findViewById(R.id.checkmark);
        ImageView wrongMark = (ImageView) findViewById(R.id.wrongmark);

        final MediaPlayer correctSfx = MediaPlayer.create(this, R.raw.dingsfx);
        final MediaPlayer wrongSfx = MediaPlayer.create(this, R.raw.wrongsfx);

        Button option1 = (Button) findViewById(R.id.firstOption);
        Button option2 = (Button) findViewById(R.id.secondOption);
        Button option3 = (Button) findViewById(R.id.thirdOption);

        String optionArr[] = {"Dog", "Dug", "Doj"};

        Random rand = new Random();

        for (int i = 0; i < optionArr.length; i++) {
            int randomIndexToSwap = rand.nextInt(optionArr.length);
            String temp = optionArr[randomIndexToSwap];
            optionArr[randomIndexToSwap] = optionArr[i];
            optionArr[i] = temp;
        }

        //randomize(optionArr, optionArr.length);
        option1.setText(optionArr[0]);
        option2.setText(optionArr[1]);
        option3.setText(optionArr[2]);

        option1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (optionArr[0] == "Dog"){
                    correctSfx.start();
                    checkMark.setVisibility(View.VISIBLE);
                    score++;
                }else{
                    wrongSfx.start();
                    wrongMark.setVisibility(View.VISIBLE);
                }
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);

                option2.setBackgroundColor(Color.GRAY);
                option3.setBackgroundColor(Color.GRAY);

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

        option2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (optionArr[1] == "Dog"){
                    correctSfx.start();
                    checkMark.setVisibility(View.VISIBLE);
                    score++;
                }else{
                    wrongSfx.start();
                    wrongMark.setVisibility(View.VISIBLE);
                }
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);

                option1.setBackgroundColor(Color.GRAY);
                option3.setBackgroundColor(Color.GRAY);

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

        option3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (optionArr[2] == "Dog"){
                    correctSfx.start();
                    checkMark.setVisibility(View.VISIBLE);
                    score++;
                }else{
                    wrongSfx.start();
                    wrongMark.setVisibility(View.VISIBLE);
                }
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);

                option1.setBackgroundColor(Color.GRAY);
                option2.setBackgroundColor(Color.GRAY);

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
    }
    public void openActivity(){
        Intent intent = new Intent(this, EndScreen.class);
        startActivity(intent);
    }
}