package com.rehoboth.listviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinksCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_category);

        ArrayAdapter<Drinks> listAdapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Drinks.drinks);

        ListView listView = (ListView) findViewById(R.id.listCoffee);
        listView.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(DrinksCategory.this, DrinksDetail.class);
                        intent.putExtra(DrinksDetail.DRINK_ID,(int) id);
                        startActivity(intent);

            }
        };
        listView.setOnItemClickListener(itemClickListener);
    }
}
