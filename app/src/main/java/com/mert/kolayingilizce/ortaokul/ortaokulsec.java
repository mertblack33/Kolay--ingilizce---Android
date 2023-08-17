package com.mert.kolayingilizce.ortaokul;

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
import com.mert.kolayingilizce.ilkokul.ilkokulsec;

public class ortaokulsec extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ortaokulsec);
        TextView textView = findViewById(R.id.textView);
        Button button1 = findViewById(R.id.button2);
        Button button2 = findViewById(R.id.button25);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button26);
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
                sharedPreferences.edit().putString("seviye","5.SINIF").apply();
                Intent intent = new Intent(ortaokulsec.this, MainActivity5.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","6.SINIF").apply();
                Intent intent = new Intent(ortaokulsec.this, MainActivity5.class);
                startActivity(intent);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","7.SINIF").apply();
                Intent intent = new Intent(ortaokulsec.this, MainActivity5.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","8.SINIF").apply();
                Intent intent = new Intent(ortaokulsec.this, MainActivity5.class);
                startActivity(intent);
            }
        });
    }
}