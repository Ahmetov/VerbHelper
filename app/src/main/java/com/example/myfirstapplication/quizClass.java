package com.example.myfirstapplication;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class quizClass extends Activity {

    private int lens = 0;
    private ArrayList<QuizListSay> quizListSays = new ArrayList<>(4);


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz);

        sameSay();
        generateWords();

    }

    private void sameSay(){
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        Cursor query = db.rawQuery("SELECT * FROM verbs WHERE id >= (abs(random()) % (SELECT max(id) FROM verbs)) LIMIT 4;", null);
        if(query.moveToFirst()){
            do{

                int id = query.getInt(0);
                String verb = query.getString(1);
                String tran = query.getString(2);

                if(lens == 0){
                    quizListSays.add(new QuizListSay(tran, verb,true));
                } else {
                    quizListSays.add(new QuizListSay(tran,verb));
                }

            }
            while(query.moveToNext());
        }
        query.close();
    }

    private void generateWords(){

        TextView textView = findViewById(R.id.questTextView);
        textView.setText(quizListSays.get(0).getAnsw());

        RadioButton radioButton = findViewById(R.id.radioButton);
        radioButton.setText(quizListSays.get(0).getQ());

        radioButton = findViewById(R.id.radioButton2);

        radioButton.setText(quizListSays.get(1).getQ());

        radioButton = findViewById(R.id.radioButton3);

        radioButton.setText(quizListSays.get(2).getQ());

        radioButton = findViewById(R.id.radioButton4);

        radioButton.setText(quizListSays.get(3).getQ());
    }
}

//SELECT * FROM tTable ORDER BY RAND() LIMIT 10;