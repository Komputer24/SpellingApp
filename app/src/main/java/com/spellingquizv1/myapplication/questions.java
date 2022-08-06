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

    public class Questions{
        private String opt1;
        private String opt2;
        private String opt3;
        private int qImg;
        private String correct;
        public Questions(String opt1, String opt2, String opt3, int qImg, String correct){
            this.opt1 = opt1;
            this.opt2 = opt2;
            this.opt3 = opt3;
            this.qImg = qImg;
            this.correct = correct;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        // Program Start

        ImageView qImage = (ImageView) findViewById(R.id.questionPic);

        ImageView checkMark = (ImageView) findViewById(R.id.checkmark);
        ImageView wrongMark = (ImageView) findViewById(R.id.wrongmark);

        final MediaPlayer correctSfx = MediaPlayer.create(this, R.raw.dingsfx);
        final MediaPlayer wrongSfx = MediaPlayer.create(this, R.raw.wrongsfx);

        Button option1 = (Button) findViewById(R.id.firstOption);
        Button option2 = (Button) findViewById(R.id.secondOption);
        Button option3 = (Button) findViewById(R.id.thirdOption);

        // Dynamics Start

        Questions questions[] = new Questions[10];
        questions[0] = new Questions("Dog", "Dug", "Doj", R.drawable.dogpic, "Dog");
        String optionArr[] = {"Option 1", "Option 2", "Option 3"};
        /*
        for(int i = 0; i <= 2; i++){
            x = "opt"+i;
            optionArr[i] = questions[0].opt+i;
        }
        */
        optionArr[0] = questions[0].opt1;
        optionArr[1] = questions[0].opt2;
        optionArr[2] = questions[0].opt3;

        qImage.setImageResource(questions[0].qImg);

        //END

        Random rand = new Random();
        for (int i = 0; i < optionArr.length; i++) {
            int randomIndexToSwap = rand.nextInt(optionArr.length);
            String temp = optionArr[randomIndexToSwap];
            optionArr[randomIndexToSwap] = optionArr[i];
            optionArr[i] = temp;
        }

        option1.setText(optionArr[0]);
        option2.setText(optionArr[1]);
        option3.setText(optionArr[2]);

        option1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (optionArr[0] == questions[0].correct){
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
                if (optionArr[1] == questions[0].correct){
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
                if (optionArr[2] == questions[0].correct){
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