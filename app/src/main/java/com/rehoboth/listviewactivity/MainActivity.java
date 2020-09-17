package com.rehoboth.listviewactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tBar);



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
                        textView1.setText(textView1.getText());
                        Toast toast1 = Toast.makeText(MainActivity.this,"Activity not implemented",Toast.LENGTH_LONG);
                        toast1.show();
                        break;
                    case 3:
                        TextView textView2 = (TextView) view;
                        textView2.setText(textView2.getText());
                        Toast toast2 = Toast.makeText(MainActivity.this,"Activity not implemented",Toast.LENGTH_LONG);
                        toast2.show();
                        break;
                }
            }
        };
        ListView listView = (ListView) findViewById(R.id.listTop);
        listView.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_create_order:
                Intent intent = new Intent(MainActivity.this, DrinksCategory.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}