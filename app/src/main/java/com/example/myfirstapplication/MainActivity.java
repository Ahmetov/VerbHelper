package com.example.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void wordsActivityOnClick(View view){
        Intent intent = new Intent(MainActivity.this,WordsUpdateActivity.class);
        startActivity(intent);
    }

    public void startActivityOnClick(View view){
        Intent intent = new Intent(MainActivity.this,quizClass.class);
        startActivity(intent);
    }

    public void aboutMeOnClick(View view){
        Intent intent = new Intent(MainActivity.this,AboutMeActivity.class);
        startActivity(intent);
    }
}
