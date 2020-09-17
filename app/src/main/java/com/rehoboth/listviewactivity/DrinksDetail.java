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
import android.widget.ImageView;
import android.widget.TextView;

public class DrinksDetail extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;

    public static String DRINK_ID = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_detail);

        Toolbar tBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tBar);

        ActionBar aBar = getSupportActionBar();
        aBar.setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        int drinkId = (Integer) intent.getIntExtra(DRINK_ID,0);

        Drinks drink = Drinks.drinks[drinkId];

        ImageView image = (ImageView) findViewById(R.id.coffeeImage);
        image.setImageResource(drink.getImageResourceId());
        image.setContentDescription(drink.getName());

        TextView tName = (TextView) findViewById(R.id.textName);
        tName.setText(drink.getName());

        TextView tDescription = (TextView) findViewById(R.id.textDescription);
        tDescription.setText(drink.getDescription());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_detail,menu);

        MenuItem menuItem = menu.findItem(R.id.shareAction);

        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareAction();

        return super.onCreateOptionsMenu(menu);
    }

    private void setShareAction(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Want to join me for coffee");
        shareActionProvider.setShareIntent(intent);
    }
}
