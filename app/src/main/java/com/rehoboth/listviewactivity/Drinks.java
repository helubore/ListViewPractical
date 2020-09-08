package com.rehoboth.listviewactivity;

import androidx.annotation.NonNull;

public class Drinks {
    private String name;
    private String description;
    private int imageResourceId;

    public static final Drinks[] drinks = {
            new Drinks("latte","The best latte coffee you can find",R.drawable.latte),
            new Drinks("cappuccino", "The ethiopian brewed cappuccino coffee",R.drawable.cappaccino),
            new Drinks("filter","The purest coffee cup you will ever taste",R.drawable.filtercoffee)

    };

    private Drinks(String name, String description, int imageResourceId){
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public int getImageResourceId(){
        return this.imageResourceId;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
