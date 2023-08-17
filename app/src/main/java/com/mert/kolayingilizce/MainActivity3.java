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

import java.util.Objects;

public class MainActivity3 extends AppCompatActivity {
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        sharedPreferences = this.getSharedPreferences("com.mert.kolayingilizce",Context.MODE_PRIVATE);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Aclonica-Regular.ttf");
        TextView textView = findViewById(R.id.textView);
        Button button1 = findViewById(R.id.button2);
        Button button2 = findViewById(R.id.button3);
        textView.setTypeface(typeface);
        button1.setTypeface(typeface);
        button2.setTypeface(typeface);

    }

    public void okul(View view){
        sharedPreferences.edit().putString("genel","genel").apply();
        Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
        startActivity(intent);
        finish();

    }
    public void genel(View view){
        sharedPreferences.edit().putString("genel","genel").apply();
        Intent intent = new Intent(MainActivity3.this,seviye.class);
        startActivity(intent);
        finish();

    }

}