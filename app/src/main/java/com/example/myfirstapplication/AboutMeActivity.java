package com.example.myfirstapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

public class AboutMeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

//        TextView textView = findViewById(R.id.gitText);
//        textView.setText(Html.fromHtml("Check out my github profile:\n <a href=\"https://github.com/Ahmetov\"><font color=#AAA>https://github.com/Ahmetov</font></a>"));
    }
}
