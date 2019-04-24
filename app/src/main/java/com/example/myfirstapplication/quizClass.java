package com.example.myfirstapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class quizClass extends Activity {

    final Context context = this;
    private int answerId = 0;
    private int score = 0;
    private int i = 0;
    private int full = 0;
    private static final String TAG1 = "generation1";
    private static final String TAG2 = "click1";
    private ArrayList<QuizListSay> quizListSays = new ArrayList<>(4);
    private ArrayList<FieldsQuiz> questions = new ArrayList<>();
    private ArrayList<FieldsQuiz> answers = new ArrayList<>();
    ArrayList<FieldsQuiz> tmp = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        sameSay();
        generateWords();
    }
    private void sameSay() {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        Cursor query = db.rawQuery("SELECT * FROM verbs ORDER BY verb;", null);
        if (query.moveToFirst()) {
            do {
                String verb = query.getString(1);
                String tran = query.getString(2);
                questions.add(new FieldsQuiz(verb, tran, true));
                answers.add(new FieldsQuiz(verb, tran, false));
                full++;
            }
            while (query.moveToNext());
        }
        query.close();
        Collections.shuffle(questions);
        Collections.shuffle(answers);
    }
    private void generateWords() {
        TextView textView = findViewById(R.id.questTextView);
        textView.setText(questions.get(0).getTrans());
        tmp = new ArrayList<>();
        tmp.add(answers.get(0));
        tmp.add(answers.get(1));
        tmp.add(answers.get(2));
        tmp.add(questions.get(0));
        final String const0 = answers.get(0).getWord();
        String const1 = answers.get(0).getWord();
        String const2 = answers.get(0).getWord();
        String const3 = answers.get(0).getWord();
        if (tmp.get(3).getWord() == tmp.get(0).getWord()) {
            tmp.set(0, answers.get(3));
        } else if (tmp.get(3).getWord() == tmp.get(1).getWord()) {
            tmp.set(1, answers.get(3));
        } else if (tmp.get(3).getWord() == tmp.get(2).getWord()) {
            tmp.set(2, answers.get(3));
        }
        Collections.shuffle(tmp);
        for (int j = 0; j < 4; j++) {
            if (tmp.get(j).isAnswer()) {
                i = j;
                System.out.println("answer is " + j + " " + tmp.get(j).getWord() + " " + tmp.get(j).getTrans());
                break;
            }
        }
        RadioButton radioButton = findViewById(R.id.radioButton0);
        radioButton.setText(tmp.get(0).getWord());
        Log.i(TAG1, "i = " + i + "\n tmp = " + tmp.get(0).getWord() + "\n radio = " + radioButton.getText());
        radioButton = findViewById(R.id.radioButton1);
        radioButton.setText(tmp.get(1).getWord());
        Log.i(TAG1, "i = " + i + "\n tmp = " + tmp.get(1).getWord() + "\n radio = " + radioButton.getText());
        radioButton = findViewById(R.id.radioButton2);
        radioButton.setText(tmp.get(2).getWord());
        Log.i(TAG1, "i = " + i + "\n tmp = " + tmp.get(2).getWord() + "\n radio = " + radioButton.getText());
        radioButton = findViewById(R.id.radioButton3);

        radioButton.setText(tmp.get(3).getWord());

        Log.i(TAG1, "i = " + i + "\n tmp = " + tmp.get(3).getWord() + "\n radio = " + radioButton.getText());

        questions.remove(0);
    }


    public void okClick(View view) {

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        TextView textView = findViewById(R.id.scoreLabel);
        System.out.println("i = " + i);

        switch (i) {
            case 0: {
                TextView answerText = findViewById(R.id.correctis);
                RadioButton radioButton = findViewById(R.id.radioButton0);
                if (radioButton.isChecked()) {
                    textView.setText("Score: " + ++score);
                    answerText.setBackgroundColor(Color.parseColor("#91D971"));
                    answerText.setText("Correct!");

                } else {
                    answerText.setBackgroundColor(Color.parseColor("#F0B27A"));
                    answerText.setText("Wrong!");
                }

                //Log.i(TAG2,"i = " + i + "\n tmp = " + tmp.get(0).getWord() + "\n radio = " + radioButton.getText());


                break;
            }


            case 1: {
                TextView answerText = findViewById(R.id.correctis);
                RadioButton radioButton1 = findViewById(R.id.radioButton1);
                if (radioButton1.isChecked()) {
                    textView.setText("Score: " + ++score);
                    answerText.setBackgroundColor(Color.parseColor("#91D971"));
                    answerText.setText("Correct!");
                } else {
                    answerText.setBackgroundColor(Color.parseColor("#F0B27A"));
                    answerText.setText("Wrong!");
                }

                //Log.i(TAG2,"i = " + i + "\n tmp = " + tmp.get(1).getWord() + "\n radio = " + radioButton1.getText());

                break;
            }

            case 2: {
                TextView answerText = findViewById(R.id.correctis);
                RadioButton radioButton2 = findViewById(R.id.radioButton2);
                if (radioButton2.isChecked()) {
                    textView.setText("Score: " + ++score);
                    answerText.setBackgroundColor(Color.parseColor("#91D971"));
                    answerText.setText("Correct!");
                } else {
                    answerText.setBackgroundColor(Color.parseColor("#F0B27A"));
                    answerText.setText("Wrong!");
                }

                //Log.i(TAG2,"i = " + i + "\n tmp = " + tmp.get(2).getWord() + "\n radio = " + radioButton2.getText());

                break;
            }

            case 3: {
                TextView answerText = findViewById(R.id.correctis);
                RadioButton radioButton3 = findViewById(R.id.radioButton3);
                if (radioButton3.isChecked()) {
                    textView.setText("Score: " + ++score);
                    answerText.setBackgroundColor(Color.parseColor("#91D971"));
                    answerText.setText("Correct!");
                } else {
                    answerText.setBackgroundColor(Color.parseColor("#F0B27A"));
                    answerText.setText("Wrong!");
                }

                // Log.i(TAG2,"i = " + i + "\n tmp = " + tmp.get(3).getWord() + "\n radio = " + radioButton3.getText());

                break;
            }


        }

        radioGroup.clearCheck();

        Log.i(TAG2, "size = " + questions.size());

        //.......................ДИАЛОГ

        if (questions.size() <= 1) {

            //Получаем вид с файла prompt.xml, который применим для диалогового окна:
            LayoutInflater li = LayoutInflater.from(context);
            final View promptsView = li.inflate(R.layout.activity_scores, null);

            //Создаем AlertDialog
            AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);

            //Настраиваем prompt.xml для нашего AlertDialog:
            mDialogBuilder.setView(promptsView);


            //Настраиваем сообщение в диалоговом окне:
            mDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    quizClass.this.finish();
                                }
                            });


            TextView scores = promptsView.findViewById(R.id.scorehere);
            scores.setText(Integer.toString(score) + "/" + full);

            //Создаем AlertDialog:
            AlertDialog alertDialog = mDialogBuilder.create();

            //и отображаем его:
            alertDialog.show();

            //  TextView scoreText = findViewById(R.id.scoreLabel);

            //  scoreText.setText(Integer.toString(score));

            // TextView messageText = findViewById(R.id.messagescore);
            // messageText.setText("Good!");

        } //.............................................................ДИАЛОГ КОНЕЦ
        else {
            Collections.shuffle(answers);
            generateWords();
        }

    }
}

