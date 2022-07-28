package com.spellingquizv1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndScreen extends AppCompatActivity {
    private Button restartBtn, leaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_screen);

        //moveTaskToBack(false);

        restartBtn = (Button) findViewById(R.id.restartBtn);
        leaveBtn = (Button) findViewById(R.id.leaveBtn);

        TextView textView = (TextView) findViewById(R.id.userScore);
        textView.setText(String.valueOf(firstQuestion.score));

        restartBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity();
            }
        });

        leaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                firstQuestion.score = 0;
            }
        });

    }

    public void openActivity(){
        Intent intent = new Intent(this, WelcomeScreen.class);
        startActivity(intent);
        firstQuestion.score = 0;
    }
}