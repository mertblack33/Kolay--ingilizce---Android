package com.mert.kolayingilizce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;
import java.util.UUID;

public class MainActivity2 extends AppCompatActivity {
    EditText isim;
    String name;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        isim = findViewById(R.id.isim);
        Button button = findViewById(R.id.button);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Aclonica-Regular.ttf");
        isim.setTypeface(typeface);
        button.setTypeface(typeface);
        sharedPreferences = this.getSharedPreferences("com.mert.kolayingilizce",Context.MODE_PRIVATE);


    }
    public void devam(View view){
        name = isim.getText().toString();

        if (name.equals("")){
            Toast.makeText(MainActivity2.this,"Lütfen Kullanıcı Adı Giriniz.",Toast.LENGTH_LONG).show();
            finish();
        }else {
            UUID uuid = UUID.randomUUID();
            sharedPreferences.edit().putString("id",""+uuid).apply();
            sharedPreferences.edit().putString("isim",name).apply();
            Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
            startActivity(intent);
            finish();
        }



    }



}