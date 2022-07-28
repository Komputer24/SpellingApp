package com.spellingquizv1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class settingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_screen);

        Button addQ = (Button) findViewById(R.id.addQ);
        Button removeQ = (Button) findViewById(R.id.removeQ);

        addQ.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity(EndScreen.class);
            }
        });
    }
    public void openActivity(Class activity){
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}