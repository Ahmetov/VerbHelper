package com.example.myfirstapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<FirstWord> {

        final Context context;
        private SQLiteDatabase db;
        private LayoutInflater inflater;
        private int layout;
        private ArrayList<FirstWord> productList;

            WordAdapter(Context context, int resource, ArrayList<FirstWord> products, SQLiteDatabase db) {
            super(context, resource, products);
            this.context = context;
            this.productList = products;
            this.layout = resource;
            this.inflater = LayoutInflater.from(context);
            this.db = db;
        }

        //...............не удаляется несколько записей
        public View getView(int position, View convertView, ViewGroup parent) {

            final ViewHolder viewHolder;
            if(convertView==null){
                convertView = inflater.inflate(this.layout, parent, false);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            }
            else{
                viewHolder = (ViewHolder) convertView.getTag();
            }
            final FirstWord product = productList.get(position);

            viewHolder.nameView.setText(product.getFirst());
            viewHolder.countView.setText(product.getSecond());

            //.................................REMOVE КНОПКА ...............................//

            viewHolder.removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        db.execSQL("DELETE FROM verbs WHERE id = " + product.getId() + ";");
                    } catch (IllegalStateException ex){
                        ex.printStackTrace();
                    }
                    //db.close();

                    viewHolder.nameView.setBackgroundColor(Color.parseColor("#D58785"));
                    viewHolder.countView.setBackgroundColor(Color.parseColor("#D58785"));
                }
            });

           //.............................EDIT КНОПКА ...................................//

            viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    String count = product.getSecond()+1;
//                    product.setSecond(count);
//                    viewHolder.countView.setText(count);
                    //Получаем вид с файла prompt.xml, который применим для диалогового окна:

                    //................................................../
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
                                            //db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
                                            db.execSQL("UPDATE verbs SET verb = '" + first + "', " + "translate = '" +
                                                    second + "' WHERE id = " +  product.getId() + ";");

                                            //db.close();
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
                    //................................................/
                }
            });

            return convertView;
        }

    public void addClick(View view){

    }

        private class ViewHolder {
            final Button addButton, removeButton;
            final TextView nameView, countView;
            ViewHolder(View view){
                addButton = (Button) view.findViewById(R.id.addButton);
                removeButton = (Button) view.findViewById(R.id.removeButton);
                nameView = (TextView) view.findViewById(R.id.nameView);
                countView = (TextView) view.findViewById(R.id.countView);
            }
        }
}
