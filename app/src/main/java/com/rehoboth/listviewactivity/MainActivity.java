package com.rehoboth.listviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tView = (TextView) findViewById(R.id.textSelected);




         AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, DrinksCategory.class);
                        startActivity(intent);
                        break;
                    case 1:
                        TextView textView = (TextView) view;
                        tView.setText(textView.getText());
                        Toast toast = Toast.makeText(MainActivity.this,"Activity not implemented",Toast.LENGTH_LONG);
                        toast.show();
                        break;
                    case 2:
                        TextView textView1 = (TextView) view;
                        tView.setText(textView1.getText());
                        Toast toast1 = Toast.makeText(MainActivity.this,"Activity not implemented",Toast.LENGTH_LONG);
                        toast1.show();
                        break;
                    case 3:
                        TextView textView2 = (TextView) view;
                        tView.setText(textView2.getText());
                        Toast toast2 = Toast.makeText(MainActivity.this,"Activity not implemented",Toast.LENGTH_LONG);
                        toast2.show();
                        break;
                }
            }
        };
        ListView listView = (ListView) findViewById(R.id.listTop);
        listView.setOnItemClickListener(itemClickListener);
    }
}