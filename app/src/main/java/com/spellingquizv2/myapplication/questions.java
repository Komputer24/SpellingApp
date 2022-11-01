package com.spellingquizv2.myapplication;

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
    public int qLoop = -1;
    public static Integer score = 0;
    public static Integer qsLength;
    public ImageView qImage;
    public MediaPlayer correctSfx;
    public MediaPlayer wrongSfx;
    public QuestionsAll questions[] = new QuestionsAll[3];

    public Button option1;
    public Button option2;
    public Button option3;
    public String optionArr[] = {"Option 1", "Option 2", "Option 3"};

    public static class QuestionsAll {
        private String opt1;
        private String opt2;
        private String opt3;
        private int qImg;
        private String correct;
        public QuestionsAll(String opt1, String opt2, String opt3, int qImg, String correct){
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
        qsLength = questions.length;
        qImage = (ImageView) findViewById(R.id.questionPic);

        ImageView checkMark = (ImageView) findViewById(R.id.checkmark);
        ImageView wrongMark = (ImageView) findViewById(R.id.wrongmark);

        correctSfx = MediaPlayer.create(this, R.raw.dingsfx);
        wrongSfx = MediaPlayer.create(this, R.raw.wrongsfx);

        option1 = (Button) findViewById(R.id.firstOption);
        option2 = (Button) findViewById(R.id.secondOption);
        option3 = (Button) findViewById(R.id.thirdOption);

        /* Orig Questions
        questions[0] = new Questions("Dog", "Dug", "Doj", R.drawable.dogpic, "Dog");
        questions[1] = new Questions("Cab", "Cat", "Cap", R.drawable.catpic, "Cat");
        questions[2] = new Questions("Fist", "Fash", "Fish", R.drawable.fishpic, "Fish");
        */
        questions[0] = new QuestionsAll("Dog", "Dag", "Doug", R.drawable.dogpic, "Dog");
        questions[1] = new QuestionsAll("Crat", "Cat", "Cut", R.drawable.catpic, "Cat");
        questions[2] = new QuestionsAll("Fosh", "Fesh", "Fish", R.drawable.fishpic, "Fish");
        // Dynamics Start
        nextIteration();

        option1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (optionArr[0] == questions[qLoop].correct){
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
                        wrongMark.setVisibility(View.INVISIBLE);
                        option1.setEnabled(true);
                        option2.setEnabled(true);
                        option3.setEnabled(true);
                        option1.setBackgroundColor(Color.parseColor("#e6e6cc"));
                        option2.setBackgroundColor(Color.parseColor("#e6e6cc"));
                        option3.setBackgroundColor(Color.parseColor("#e6e6cc"));
                        nextIteration();
                    }
                }, 1000);
            }
        });

        option2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (optionArr[1] == questions[qLoop].correct){
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
                        wrongMark.setVisibility(View.INVISIBLE);
                        option1.setEnabled(true);
                        option2.setEnabled(true);
                        option3.setEnabled(true);
                        option1.setBackgroundColor(Color.parseColor("#e6e6cc"));
                        option2.setBackgroundColor(Color.parseColor("#e6e6cc"));
                        option3.setBackgroundColor(Color.parseColor("#e6e6cc"));
                        nextIteration();
                    }
                }, 1000);
            }
        });

        option3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (optionArr[2] == questions[qLoop].correct){
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
                        wrongMark.setVisibility(View.INVISIBLE);
                        option1.setEnabled(true);
                        option2.setEnabled(true);
                        option3.setEnabled(true);
                        option1.setBackgroundColor(Color.parseColor("#e6e6cc"));
                        option2.setBackgroundColor(Color.parseColor("#e6e6cc"));
                        option3.setBackgroundColor(Color.parseColor("#e6e6cc"));
                        nextIteration();
                    }
                }, 1000);
            }
        });
    }
    private void nextIteration(){
        qLoop++;
        if(qLoop == questions.length){
            //openActivity();
            Intent intent = new Intent(this, EndScreen.class);
            startActivity(intent);
        }else {
        /*
        Questions questions[] = new Questions[3];
        questions[0] = new Questions("Dog", "Dug", "Doj", R.drawable.dogpic, "Dog");
        questions[1] = new Questions("Cab", "Cat", "Cap", R.drawable.catpic, "Cat");
        questions[2] = new Questions("Fist", "Fash", "Fish", R.drawable.fishpic, "Fish");
        */
            //String optionArr[] = {"Option 1", "Option 2", "Option 3"};
       /*
       for(int i = 0; i <= 2; i++){
           x = "opt"+i;
           optionArr[i] = questions[0].opt+i;
       }
       */

           // wrongSfx.stop();
           // correctSfx.stop();

            optionArr[0] = questions[qLoop].opt1;
            optionArr[1] = questions[qLoop].opt2;
            optionArr[2] = questions[qLoop].opt3;

            qImage.setImageResource(questions[qLoop].qImg);

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
        }
    }

    /*public void openActivity(){
        Intent intent = new Intent(this, EndScreen.class);
        startActivity(intent);
    }*/

}
