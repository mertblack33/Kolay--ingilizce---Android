package com.mert.kolayingilizce.ilkokul;

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
import com.mert.kolayingilizce.lise.lisesec;

public class ilkokulsec extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilkokulsec);
        TextView textView = findViewById(R.id.textView);
        Button button1 = findViewById(R.id.button2);
        Button button2 = findViewById(R.id.button25);
        Button button3 = findViewById(R.id.button3);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Aclonica-Regular.ttf");
        button1.setTypeface(typeface);
        button2.setTypeface(typeface);
        button3.setTypeface(typeface);
        textView.setTypeface(typeface);
        sharedPreferences = this.getSharedPreferences("com.mert.kolayingilizce", MODE_PRIVATE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","2.SINIF").apply();
                Intent intent = new Intent(ilkokulsec.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","3.SINIF").apply();
                Intent intent = new Intent(ilkokulsec.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("seviye","4.SINIF").apply();
                Intent intent = new Intent(ilkokulsec.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }
        });

    }
}