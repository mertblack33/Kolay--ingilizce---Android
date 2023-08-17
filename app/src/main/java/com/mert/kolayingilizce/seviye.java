package com.mert.kolayingilizce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class seviye extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviye);
        TextView textView = findViewById(R.id.textView18);
        Button a1 = findViewById(R.id.button11);
        Button a2 = findViewById(R.id.button14);
        Button b1 = findViewById(R.id.button13);
        Button b2 = findViewById(R.id.button12);
        Button c1 = findViewById(R.id.button15);
        Button c2 = findViewById(R.id.button22);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Aclonica-Regular.ttf");
        textView.setTypeface(typeface);
        a1.setTypeface(typeface);
        a2.setTypeface(typeface);
        b1.setTypeface(typeface);
        b2.setTypeface(typeface);
        c1.setTypeface(typeface);
        c2.setTypeface(typeface);
        sharedPreferences = this.getSharedPreferences("com.mert.kolayingilizce", Context.MODE_PRIVATE);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","A1").apply();
                Intent intent = new Intent(seviye.this,MainActivity5.class);
                startActivity(intent);
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","A2").apply();
                Intent intent = new Intent(seviye.this,MainActivity5.class);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","B1").apply();
                Intent intent = new Intent(seviye.this,MainActivity5.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","B2").apply();
                Intent intent = new Intent(seviye.this,MainActivity5.class);
                startActivity(intent);
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","C1").apply();
                Intent intent = new Intent(seviye.this,MainActivity5.class);
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","C2").apply();
                Intent intent = new Intent(seviye.this,MainActivity5.class);
                startActivity(intent);
            }
        });


    }




}