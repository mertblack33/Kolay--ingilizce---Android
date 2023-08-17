package com.mert.kolayingilizce.lise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mert.kolayingilizce.MainActivity5;
import com.mert.kolayingilizce.R;

public class lisesec extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisesec);
        TextView textView = findViewById(R.id.textView);
        Button button1 = findViewById(R.id.button2);
        Button button2 = findViewById(R.id.button25);
        Button button3 = findViewById(R.id.button26);
        Button button4 = findViewById(R.id.button3);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Aclonica-Regular.ttf");
        button1.setTypeface(typeface);
        button2.setTypeface(typeface);
        button3.setTypeface(typeface);
        button4.setTypeface(typeface);
        textView.setTypeface(typeface);
        sharedPreferences = this.getSharedPreferences("com.mert.kolayingilizce", MODE_PRIVATE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","9.SINIF").apply();
                Intent intent = new Intent(lisesec.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","10.SINIF").apply();
                Intent intent = new Intent(lisesec.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","12.SINIF").apply();
                Intent intent = new Intent(lisesec.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","11.SINIF").apply();
                Intent intent = new Intent(lisesec.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }
        });


    }


}