package com.rehoboth.listviewactivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class DrinksCategory extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_category);
        Toolbar toolB = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolB);

        ActionBar aBar = getSupportActionBar();
        aBar.setDisplayHomeAsUpEnabled(true);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_detail,menu);
        MenuItem menuItem = menu.findItem(R.id.shareAction);

        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareAction("Good Morning..");

        return super.onCreateOptionsMenu(menu);
    }

    private void setShareAction(String s) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,s);
        shareActionProvider.setShareIntent(intent);
    }
}
