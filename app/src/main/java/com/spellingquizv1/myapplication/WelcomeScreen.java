package com.spellingquizv1.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeScreen extends AppCompatActivity {
    private Button startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hides Title Bar
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Hides Action Bar
        //getSupportActionBar().hide();

        setContentView(R.layout.welcome_screen);
        // Program Start
        // Version Control Lets See
        startBtn = (Button) findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity();
            }
        });

    }
    public void openActivity(){
        Intent intent = new Intent(this, questions.class);
        startActivity(intent);
    }
    public void openSettings(){
        Intent intent = new Intent(this, settingScreen.class);
        startActivity(intent);
    }
    public void imageButtonOnClick(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.aaed.org"));
        startActivity(browserIntent);
    } public void settingClick(View v) {
        openSettings();
    }
}