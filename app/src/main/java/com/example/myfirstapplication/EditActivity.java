package com.example.myfirstapplication;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EditActivity extends Activity {

    ArrayList<FirstWord> products = new ArrayList();
    ListView productList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editwords);

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        Cursor query = db.rawQuery("SELECT * FROM verbs ORDER BY verb;", null);
        if(query.moveToFirst()){
            do{
                int id = query.getInt(0);
                String verb = query.getString(1);
                String tran = query.getString(2);
                products.add(new FirstWord(id, verb, tran));
            }
            while(query.moveToNext());
        }
        query.close();
        productList = (ListView) findViewById(R.id.productList);
        WordAdapter adapter = new WordAdapter(this, R.layout.list_item, products, db);
        productList.setAdapter(adapter);
        //db.close();
    }



//
//    public void showOnClick(View view){
//        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
//        Cursor query = db.rawQuery("SELECT * FROM verbs;", null);
//        TextView textView = (TextView) findViewById(R.id.textView4);
//        textView.setText("");
//        if(query.moveToFirst()){
//            do{
//                String verb = query.getString(0);
//                String tran = query.getString(1);
//                textView.append("Verb: " + verb + " Translation: " + tran + "\n");
//            }
//            while(query.moveToNext());
//        }
//        query.close();
//        db.close();
//    }
}
