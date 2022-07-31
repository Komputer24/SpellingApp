package com.spellingquizv1.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeScreen extends AppCompatActivity {
    private Button startBtn;
    public void settingClick(View v) {
        //openSettings();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Coming Soon");
        builder.setMessage("This is currently in development, try out the other features.");

        // add a button
        builder.setPositiveButton("OK", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hides Title Bar
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Hides Action Bar
        //getSupportActionBar().hide();

        setContentView(R.layout.welcome_screen);
        setupHyperlink();
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
        Intent intent = new Intent(this, firstQuestion.class);
        startActivity(intent);
    }
    public void openSettings(){
        Intent intent = new Intent(this, settingScreen.class);
        startActivity(intent);
    }
    public void imageButtonOnClick(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.aaed.org"));
        startActivity(browserIntent);
    }
    private void setupHyperlink() {
        TextView linkTextView = findViewById(R.id.privacy);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}