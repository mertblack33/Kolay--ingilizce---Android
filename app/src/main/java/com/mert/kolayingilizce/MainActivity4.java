package com.mert.kolayingilizce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mert.kolayingilizce.ilkokul.ilkokulsec;
import com.mert.kolayingilizce.lise.lisesec;
import com.mert.kolayingilizce.ortaokul.ortaokulsec;

public class MainActivity4 extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        TextView textView = findViewById(R.id.textView2);
        Button button1 = findViewById(R.id.button5);
        Button button2 = findViewById(R.id.button8);
        Button button3 = findViewById(R.id.button6);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Aclonica-Regular.ttf");
        textView.setTypeface(typeface);
        button1.setTypeface(typeface);
        button2.setTypeface(typeface);
        button3.setTypeface(typeface);



    }



    public void ilkokul(View view){
        Intent intent= new Intent(MainActivity4.this, ilkokulsec.class);
        startActivity(intent);
        finish();

    }
    public void ortaokul(View view){
        Intent intent= new Intent(MainActivity4.this, ortaokulsec.class);
        startActivity(intent);
        finish();

    }

    public void lise(View view){
        Intent intent= new Intent(MainActivity4.this, lisesec.class);
        startActivity(intent);
        finish();

    }
}