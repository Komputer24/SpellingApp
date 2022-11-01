
package com.spellingquizv2.myapplication;

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

        TextView userScore = (TextView) findViewById(R.id.userScore);
        TextView userQNum = (TextView) findViewById((R.id.userQNum));

        userScore.setText(String.valueOf(questions.score));
        userQNum.setText(String.valueOf(questions.qsLength));

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
                questions.score = 0;
            }
        });

    }

    public void openActivity(){
        Intent intent = new Intent(this, WelcomeScreen.class);
        startActivity(intent);
        questions.score = 0;
    }
}
