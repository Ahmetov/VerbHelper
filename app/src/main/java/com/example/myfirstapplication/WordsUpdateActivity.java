package com.example.myfirstapplication;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//МЕНЮ ADD EDIT

public class WordsUpdateActivity extends Activity {

    final Context context = this;
    private TextView final_text;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_words);
    }

    public void editOnButClick(View view){
        Intent intent = new Intent(WordsUpdateActivity.this,EditActivity.class);
        startActivity(intent);
    }

    public void addClick(View view){
        //Получаем вид с файла prompt.xml, который применим для диалогового окна:
        LayoutInflater li = LayoutInflater.from(context);
        final View promptsView = li.inflate(R.layout.activity_addwords, null);

        //Создаем AlertDialog
        AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);

        //Настраиваем prompt.xml для нашего AlertDialog:
        mDialogBuilder.setView(promptsView);

        //Настраиваем отображение поля для ввода текста в открытом диалоге:
        final EditText userInput = (EditText) promptsView.findViewById(R.id.input_text);
        final EditText userInput2 = (EditText) promptsView.findViewById(R.id.input_text2);

        //Настраиваем сообщение в диалоговом окне:
        mDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                //Вводим текст и отображаем в строке ввода на основном экране:
                                //final_text.setText(userInput.getText());
                                //EditText editText = (EditText)findViewById(R.id.input_text)
                                String first = userInput.getText().toString();
                                String second = userInput2.getText().toString();
                                SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
                                db.execSQL("CREATE TABLE IF NOT EXISTS verbs (id INTEGER PRIMARY KEY AUTOINCREMENT, verb TEXT, translate TEXT)");
                                db.execSQL("INSERT INTO verbs VALUES (NULL, '" + first + "', '" + second + "');");
                                //db.execSQL("INSERT INTO verbs VALUES ('call back', 'перезвонить');");
                                db.close();
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        //Создаем AlertDialog:
        AlertDialog alertDialog = mDialogBuilder.create();

        //и отображаем его:
        alertDialog.show();
    }

}
