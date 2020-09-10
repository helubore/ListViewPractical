package com.rehoboth.listviewactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinksDetail extends AppCompatActivity {

    public static String DRINK_ID = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_detail);

        Toolbar tBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tBar);

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
}
