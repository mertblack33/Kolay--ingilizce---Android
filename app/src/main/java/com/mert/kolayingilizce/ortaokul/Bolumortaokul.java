package com.mert.kolayingilizce.ortaokul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mert.kolayingilizce.R;

public class Bolumortaokul extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    String nerde;
    Button bir,iki,uc,dort,bes,alti;
    SQLiteDatabase database;
    TextView yanlis;
    TextView dogru;
    int s =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolum);
        sharedPreferences = this.getSharedPreferences("com.mert.kolayingilizce", Context.MODE_PRIVATE);
        TextView textView1 = findViewById(R.id.textView14);
        TextView textView2 = findViewById(R.id.textView6);
        TextView textView3 = findViewById(R.id.textView8);
        TextView textView4 = findViewById(R.id.textView9);
        dogru = findViewById(R.id.textView101);
        yanlis = findViewById(R.id.textView102);
        bir = findViewById(R.id.button101);
        iki = findViewById(R.id.button17);
        uc = findViewById(R.id.button18);
        dort = findViewById(R.id.button20);
        bes = findViewById(R.id.button19);
        alti = findViewById(R.id.button21);
        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"fonts/Aclonica-Regular.ttf");
        textView1.setTypeface(typeface);
        textView2.setTypeface(typeface);
        textView3.setTypeface(typeface);
        textView4.setTypeface(typeface);
        nerde = sharedPreferences.getString("bölüm","noll");
        database = this.openOrCreateDatabase("data", MODE_PRIVATE, null);
        resimsorgu();

        bir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumortaokul.this, Kelimeortaokul.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s1").apply();
                finish();
            }
        });
        iki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumortaokul.this,Kelimeortaokul.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s2").apply();
                finish();
            }
        });
        uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumortaokul.this,Kelimeortaokul.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s3").apply();
                finish();
            }
        });
        dort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumortaokul.this,Kelimeortaokul.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s4").apply();
                finish();
            }
        });
        bes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumortaokul.this,Kelimeortaokul.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s5").apply();
                finish();
            }
        });
        alti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumortaokul.this,Kelimeortaokul.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s6").apply();
                finish();
            }
        });
    }


    public void resimsorgu(){
        if (nerde.contains("5.SINIFbölüm1")){
            String sinif5bolum1s1 = sharedPreferences.getString("5.SINIFbölüm1s1yildiz","3");
            if(sinif5bolum1s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum1s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum1s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum1s2 = sharedPreferences.getString("5.SINIFbölüm1s2yildiz","3");
            if(sinif5bolum1s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum1s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum1s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum1s3 = sharedPreferences.getString("5.SINIFbölüm1s3yildiz","3");
            if(sinif5bolum1s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum1s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum1s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum1s4 = sharedPreferences.getString("5.SINIFbölüm1s4yildiz","3");
            if(sinif5bolum1s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum1s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum1s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum1s5 = sharedPreferences.getString("5.SINIFbölüm1s5yildiz","3");
            if(sinif5bolum1s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum1s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum1s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            alti.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='5.SINIFbölüm1'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }




        }if (nerde.contains("5.SINIFbölüm2")){
            String sinif5bolum2s1 = sharedPreferences.getString("5.SINIFbölüm2s1yildiz","3");
            if(sinif5bolum2s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum2s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum2s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum2s2 = sharedPreferences.getString("5.SINIFbölüm2s2yildiz","3");
            if(sinif5bolum2s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum2s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum2s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum2s3 = sharedPreferences.getString("5.SINIFbölüm2s3yildiz","3");
            if(sinif5bolum2s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum2s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum2s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum2s4 = sharedPreferences.getString("5.SINIFbölüm2s4yildiz","3");
            if(sinif5bolum2s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum2s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum2s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum2s5 = sharedPreferences.getString("5.SINIFbölüm2s5yildiz","3");
            if(sinif5bolum2s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum2s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum2s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            alti.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='5.SINIFbölüm2'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }

        }if (nerde.contains("5.SINIFbölüm3")){
            String sinif5bolum3s1 = sharedPreferences.getString("5.SINIFbölüm3s1yildiz","3");
            if(sinif5bolum3s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum3s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum3s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum3s2 = sharedPreferences.getString("5.SINIFbölüm3s2yildiz","3");
            if(sinif5bolum3s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum3s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum3s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum3s3 = sharedPreferences.getString("5.SINIFbölüm3s3yildiz","3");
            if(sinif5bolum3s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum3s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum3s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum3s4 = sharedPreferences.getString("5.SINIFbölüm3s4yildiz","3");
            if(sinif5bolum3s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum3s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum3s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum3s5 = sharedPreferences.getString("5.SINIFbölüm3s5yildiz","3");
            if(sinif5bolum3s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum3s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum3s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            alti.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='5.SINIFbölüm3'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("5.SINIFbölüm4")){
            String sinif5bolum4s1 = sharedPreferences.getString("5.SINIFbölüm4s1yildiz","3");
            if(sinif5bolum4s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum4s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum4s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum4s2 = sharedPreferences.getString("5.SINIFbölüm4s2yildiz","3");
            if(sinif5bolum4s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum4s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum4s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum4s3 = sharedPreferences.getString("5.SINIFbölüm4s3yildiz","3");
            if(sinif5bolum4s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum4s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum4s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum4s4 = sharedPreferences.getString("5.SINIFbölüm4s4yildiz","3");
            if(sinif5bolum4s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum4s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum4s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum4s5 = sharedPreferences.getString("5.SINIFbölüm4s5yildiz","3");
            if(sinif5bolum4s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum4s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum4s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum4s6 = sharedPreferences.getString("5.SINIFbölüm4s6yildiz","3");
            if(sinif5bolum4s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum4s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum4s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='5.SINIFbölüm4'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("5.SINIFbölüm5")){
            String sinif5bolum5s1 = sharedPreferences.getString("5.SINIFbölüm5s1yildiz","3");
            if(sinif5bolum5s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum5s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum5s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum5s2 = sharedPreferences.getString("5.SINIFbölüm5s2yildiz","3");
            if(sinif5bolum5s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum5s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum5s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum5s3 = sharedPreferences.getString("5.SINIFbölüm5s3yildiz","3");
            if(sinif5bolum5s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum5s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum5s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum5s4 = sharedPreferences.getString("5.SINIFbölüm5s4yildiz","3");
            if(sinif5bolum5s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum5s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum5s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum5s5 = sharedPreferences.getString("5.SINIFbölüm5s5yildiz","3");
            if(sinif5bolum5s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum5s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum5s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum5s6 = sharedPreferences.getString("5.SINIFbölüm5s6yildiz","3");
            if(sinif5bolum5s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum5s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum5s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='5.SINIFbölüm5'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }

        }if (nerde.contains("5.SINIFbölüm6")){
            String sinif5bolum6s1 = sharedPreferences.getString("5.SINIFbölüm6s1yildiz","3");
            if(sinif5bolum6s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum6s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum6s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum6s2 = sharedPreferences.getString("5.SINIFbölüm6s2yildiz","3");
            if(sinif5bolum6s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum6s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum6s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum6s3 = sharedPreferences.getString("5.SINIFbölüm6s3yildiz","3");
            if(sinif5bolum6s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum6s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum6s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum6s4 = sharedPreferences.getString("5.SINIFbölüm6s4yildiz","3");
            if(sinif5bolum6s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum6s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum6s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum6s5 = sharedPreferences.getString("5.SINIFbölüm6s5yildiz","3");
            if(sinif5bolum6s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum6s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum6s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            alti.setVisibility(View.INVISIBLE);


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='5.SINIFbölüm6'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("5.SINIFbölüm7")){
            String sinif5bolum7s1 = sharedPreferences.getString("5.SINIFbölüm7s1yildiz","3");
            if(sinif5bolum7s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum7s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum7s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum7s2 = sharedPreferences.getString("5.SINIFbölüm7s2yildiz","3");
            if(sinif5bolum7s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum7s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum7s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif5bolum7s3 = sharedPreferences.getString("5.SINIFbölüm7s3yildiz","3");
            if(sinif5bolum7s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif5bolum7s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif5bolum7s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }

            dort.setVisibility(View.INVISIBLE);
            bes.setVisibility(View.INVISIBLE);
            alti.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='5.SINIFbölüm7'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }






        }if (nerde.contains("6.SINIFbölüm1")){
            String sinif6bolum1s1 = sharedPreferences.getString("6.SINIFbölüm1s1yildiz","3");
            if(sinif6bolum1s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum1s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum1s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum1s2 = sharedPreferences.getString("6.SINIFbölüm1s2yildiz","3");
            if(sinif6bolum1s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum1s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum1s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum1s3 = sharedPreferences.getString("6.SINIFbölüm1s3yildiz","3");
            if(sinif6bolum1s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum1s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum1s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum1s4 = sharedPreferences.getString("6.SINIFbölüm1s4yildiz","3");
            if(sinif6bolum1s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum1s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum1s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum1s5 = sharedPreferences.getString("6.SINIFbölüm1s5yildiz","3");
            if(sinif6bolum1s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum1s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum1s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            alti.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='6.SINIFbölüm1'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("6.SINIFbölüm2")){
            String sinif6bolum2s1 = sharedPreferences.getString("6.SINIFbölüm2s1yildiz","3");
            if(sinif6bolum2s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum2s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum2s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum2s2 = sharedPreferences.getString("6.SINIFbölüm2s2yildiz","3");
            if(sinif6bolum2s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum2s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum2s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum2s3 = sharedPreferences.getString("6.SINIFbölüm2s3yildiz","3");
            if(sinif6bolum2s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum2s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum2s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum2s4 = sharedPreferences.getString("6.SINIFbölüm2s4yildiz","3");
            if(sinif6bolum2s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum2s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum2s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum2s5 = sharedPreferences.getString("6.SINIFbölüm2s5yildiz","3");
            if(sinif6bolum2s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum2s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum2s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            alti.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='6.SINIFbölüm2'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("6.SINIFbölüm3")){
            String sinif6bolum3s1 = sharedPreferences.getString("6.SINIFbölüm3s1yildiz","3");
            if(sinif6bolum3s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum3s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum3s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum3s2 = sharedPreferences.getString("6.SINIFbölüm3s2yildiz","3");
            if(sinif6bolum3s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum3s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum3s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum3s3 = sharedPreferences.getString("6.SINIFbölüm3s3yildiz","3");
            if(sinif6bolum3s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum3s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum3s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum3s4 = sharedPreferences.getString("6.SINIFbölüm3s4yildiz","3");
            if(sinif6bolum3s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum3s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum3s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum3s5 = sharedPreferences.getString("6.SINIFbölüm3s5yildiz","3");
            if(sinif6bolum3s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum3s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum3s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum3s6 = sharedPreferences.getString("6.SINIFbölüm3s6yildiz","3");
            if(sinif6bolum3s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum3s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum3s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='6.SINIFbölüm3'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }




        }if (nerde.contains("6.SINIFbölüm4")){
            String sinif6bolum4s1 = sharedPreferences.getString("6.SINIFbölüm4s1yildiz","3");
            if(sinif6bolum4s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum4s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum4s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum4s2 = sharedPreferences.getString("6.SINIFbölüm4s2yildiz","3");
            if(sinif6bolum4s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum4s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum4s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum4s3 = sharedPreferences.getString("6.SINIFbölüm4s3yildiz","3");
            if(sinif6bolum4s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum4s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum4s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum4s4 = sharedPreferences.getString("6.SINIFbölüm4s4yildiz","3");
            if(sinif6bolum4s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum4s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum4s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum4s5 = sharedPreferences.getString("6.SINIFbölüm4s5yildiz","3");
            if(sinif6bolum4s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum4s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum4s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            alti.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='6.SINIFbölüm4'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("6.SINIFbölüm5")){
            String sinif6bolum5s1 = sharedPreferences.getString("6.SINIFbölüm5s1yildiz","3");
            if(sinif6bolum5s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum5s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum5s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum5s2 = sharedPreferences.getString("6.SINIFbölüm5s2yildiz","3");
            if(sinif6bolum5s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum5s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum5s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum5s3 = sharedPreferences.getString("6.SINIFbölüm5s3yildiz","3");
            if(sinif6bolum5s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum5s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum5s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            bes.setVisibility(View.INVISIBLE);
            alti.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='6.SINIFbölüm5'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("6.SINIFbölüm6")){
            String sinif6bolum6s1 = sharedPreferences.getString("6.SINIFbölüm6s1yildiz","3");
            if(sinif6bolum6s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum6s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum6s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum6s2 = sharedPreferences.getString("6.SINIFbölüm6s2yildiz","3");
            if(sinif6bolum6s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum6s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum6s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum6s3 = sharedPreferences.getString("6.SINIFbölüm6s3yildiz","3");
            if(sinif6bolum6s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum6s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum6s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum6s4 = sharedPreferences.getString("6.SINIFbölüm6s4yildiz","3");
            if(sinif6bolum6s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum6s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum6s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum6s5 = sharedPreferences.getString("6.SINIFbölüm6s5yildiz","3");
            if(sinif6bolum6s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum6s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum6s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            alti.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='6.SINIFbölüm6'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("6.SINIFbölüm7")){
            String sinif6bolum7s1 = sharedPreferences.getString("6.SINIFbölüm7s1yildiz","3");
            if(sinif6bolum7s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum7s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum7s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum7s2 = sharedPreferences.getString("6.SINIFbölüm7s2yildiz","3");
            if(sinif6bolum7s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum7s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum7s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum7s3 = sharedPreferences.getString("6.SINIFbölüm7s3yildiz","3");
            if(sinif6bolum7s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum7s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum7s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            bes.setVisibility(View.INVISIBLE);
            alti.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='6.SINIFbölüm7'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("6.SINIFbölüm8")){
            String sinif6bolum8s1 = sharedPreferences.getString("6.SINIFbölüm8s1yildiz","3");
            if(sinif6bolum8s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum8s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum8s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum8s2 = sharedPreferences.getString("6.SINIFbölüm8s2yildiz","3");
            if(sinif6bolum8s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum8s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum8s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum8s3 = sharedPreferences.getString("6.SINIFbölüm8s3yildiz","3");
            if(sinif6bolum8s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum8s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum8s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum8s4 = sharedPreferences.getString("6.SINIFbölüm8s4yildiz","3");
            if(sinif6bolum8s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum8s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum8s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum8s5 = sharedPreferences.getString("6.SINIFbölüm8s5yildiz","3");
            if(sinif6bolum8s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum8s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum8s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum8s6 = sharedPreferences.getString("6.SINIFbölüm8s6yildiz","3");
            if(sinif6bolum8s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum8s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum8s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='6.SINIFbölüm8'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("6.SINIFbölüm9")){
            String sinif6bolum9s1 = sharedPreferences.getString("6.SINIFbölüm9s1yildiz","3");
            if(sinif6bolum9s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum9s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum9s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum9s2 = sharedPreferences.getString("6.SINIFbölüm9s2yildiz","3");
            if(sinif6bolum9s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum9s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum9s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum9s3 = sharedPreferences.getString("6.SINIFbölüm9s3yildiz","3");
            if(sinif6bolum9s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum9s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum9s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum9s4 = sharedPreferences.getString("6.SINIFbölüm9s4yildiz","3");
            if(sinif6bolum9s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum9s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum9s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum9s5 = sharedPreferences.getString("6.SINIFbölüm9s5yildiz","3");
            if(sinif6bolum9s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum9s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum9s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum9s6 = sharedPreferences.getString("6.SINIFbölüm9s6yildiz","3");
            if(sinif6bolum9s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum9s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum9s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='6.SINIFbölüm9'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("6.SINIFbölüm10")){
            String sinif6bolum10s1 = sharedPreferences.getString("6.SINIFbölüm10s1yildiz","3");
            if(sinif6bolum10s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum10s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum10s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum10s2 = sharedPreferences.getString("6.SINIFbölüm10s2yildiz","3");
            if(sinif6bolum10s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum10s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum10s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum10s3 = sharedPreferences.getString("6.SINIFbölüm10s3yildiz","3");
            if(sinif6bolum10s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum10s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum10s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum10s4 = sharedPreferences.getString("6.SINIFbölüm10s4yildiz","3");
            if(sinif6bolum10s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum10s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum10s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum10s5 = sharedPreferences.getString("6.SINIFbölüm10s5yildiz","3");
            if(sinif6bolum10s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum10s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum10s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif6bolum10s6 = sharedPreferences.getString("6.SINIFbölüm10s6yildiz","3");
            if(sinif6bolum10s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif6bolum10s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif6bolum10s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='6.SINIFbölüm10'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("7.SINIFbölüm1")){
            String sinif7bolum1s1 = sharedPreferences.getString("7.SINIFbölüm1s1yildiz","3");
            if(sinif7bolum1s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum1s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum1s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum1s2 = sharedPreferences.getString("7.SINIFbölüm1s2yildiz","3");
            if(sinif7bolum1s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum1s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum1s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum1s3 = sharedPreferences.getString("7.SINIFbölüm1s3yildiz","3");
            if(sinif7bolum1s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum1s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum1s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum1s4 = sharedPreferences.getString("7.SINIFbölüm1s4yildiz","3");
            if(sinif7bolum1s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum1s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum1s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum1s5 = sharedPreferences.getString("7.SINIFbölüm1s5yildiz","3");
            if(sinif7bolum1s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum1s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum1s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum1s6 = sharedPreferences.getString("7.SINIFbölüm1s6yildiz","3");
            if(sinif7bolum1s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum1s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum1s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }
            alti.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='7.SINIFbölüm1'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("7.SINIFbölüm2")){
            String sinif7bolum2s1 = sharedPreferences.getString("7.SINIFbölüm2s1yildiz","3");
            if(sinif7bolum2s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum2s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum2s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum2s2 = sharedPreferences.getString("7.SINIFbölüm2s2yildiz","3");
            if(sinif7bolum2s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum2s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum2s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum2s3 = sharedPreferences.getString("7.SINIFbölüm2s3yildiz","3");
            if(sinif7bolum2s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum2s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum2s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum2s4 = sharedPreferences.getString("7.SINIFbölüm2s4yildiz","3");
            if(sinif7bolum2s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum2s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum2s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum2s5 = sharedPreferences.getString("7.SINIFbölüm2s5yildiz","3");
            if(sinif7bolum2s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum2s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum2s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum2s6 = sharedPreferences.getString("7.SINIFbölüm2s6yildiz","3");
            if(sinif7bolum2s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum2s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum2s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='7.SINIFbölüm2'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("7.SINIFbölüm3")){
            String sinif7bolum3s1 = sharedPreferences.getString("7.SINIFbölüm3s1yildiz","3");
            if(sinif7bolum3s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum3s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum3s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum3s2 = sharedPreferences.getString("7.SINIFbölüm3s2yildiz","3");
            if(sinif7bolum3s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum3s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum3s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum3s3 = sharedPreferences.getString("7.SINIFbölüm3s3yildiz","3");
            if(sinif7bolum3s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum3s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum3s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum3s4 = sharedPreferences.getString("7.SINIFbölüm3s4yildiz","3");
            if(sinif7bolum3s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum3s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum3s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum3s5 = sharedPreferences.getString("7.SINIFbölüm3s5yildiz","3");
            if(sinif7bolum3s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum3s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum3s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum3s6 = sharedPreferences.getString("7.SINIFbölüm3s6yildiz","3");
            if(sinif7bolum3s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum3s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum3s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='7.SINIFbölüm3'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }




        }if (nerde.contains("7.SINIFbölüm4")){
            String sinif7bolum4s1 = sharedPreferences.getString("7.SINIFbölüm4s1yildiz","3");
            if(sinif7bolum4s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum4s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum4s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum4s2 = sharedPreferences.getString("7.SINIFbölüm4s2yildiz","3");
            if(sinif7bolum4s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum4s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum4s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum4s3 = sharedPreferences.getString("7.SINIFbölüm4s3yildiz","3");
            if(sinif7bolum4s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum4s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum4s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum4s4 = sharedPreferences.getString("7.SINIFbölüm4s4yildiz","3");
            if(sinif7bolum4s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum4s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum4s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum4s5 = sharedPreferences.getString("7.SINIFbölüm4s5yildiz","3");
            if(sinif7bolum4s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum4s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum4s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum4s6 = sharedPreferences.getString("7.SINIFbölüm4s6yildiz","3");
            System.out.println(sinif7bolum4s6);
            if(sinif7bolum4s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum4s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum4s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='7.SINIFbölüm4'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("7.SINIFbölüm5")){
            String sinif7bolum5s1 = sharedPreferences.getString("7.SINIFbölüm5s1yildiz","3");
            if(sinif7bolum5s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum5s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum5s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum5s2 = sharedPreferences.getString("7.SINIFbölüm5s2yildiz","3");
            if(sinif7bolum5s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum5s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum5s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum5s3 = sharedPreferences.getString("7.SINIFbölüm5s3yildiz","3");
            if(sinif7bolum5s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum5s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum5s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum5s6 = sharedPreferences.getString("7.SINIFbölüm5s6yildiz","3");
            if(sinif7bolum5s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum5s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum5s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum5s4 = sharedPreferences.getString("7.SINIFbölüm5s4yildiz","3");
            if(sinif7bolum5s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum5s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum5s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum5s5 = sharedPreferences.getString("7.SINIFbölüm5s5yildiz","3");
            if(sinif7bolum5s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum5s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum5s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='7.SINIFbölüm5'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("7.SINIFbölüm6")){
            String sinif7bolum6s1 = sharedPreferences.getString("7.SINIFbölüm6s1yildiz","3");
            if(sinif7bolum6s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum6s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum6s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum6s2 = sharedPreferences.getString("7.SINIFbölüm6s2yildiz","3");
            if(sinif7bolum6s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum6s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum6s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum6s3 = sharedPreferences.getString("7.SINIFbölüm6s3yildiz","3");
            if(sinif7bolum6s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum6s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum6s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum6s4 = sharedPreferences.getString("7.SINIFbölüm6s4yildiz","3");
            if(sinif7bolum6s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum6s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum6s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum6s5 = sharedPreferences.getString("7.SINIFbölüm6s5yildiz","3");
            if(sinif7bolum6s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum6s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum6s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum6s6 = sharedPreferences.getString("7.SINIFbölüm6s6yildiz","3");
            if(sinif7bolum6s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum6s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum6s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='7.SINIFbölüm6'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("7.SINIFbölüm7")){
            String sinif7bolum7s1 = sharedPreferences.getString("7.SINIFbölüm7s1yildiz","3");
            if(sinif7bolum7s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum7s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum7s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum7s2 = sharedPreferences.getString("7.SINIFbölüm7s2yildiz","3");
            if(sinif7bolum7s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum7s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum7s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum7s3 = sharedPreferences.getString("7.SINIFbölüm7s3yildiz","3");
            if(sinif7bolum7s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum7s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum7s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum7s4 = sharedPreferences.getString("7.SINIFbölüm7s4yildiz","3");
            if(sinif7bolum7s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum7s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum7s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum7s5 = sharedPreferences.getString("7.SINIFbölüm7s5yildiz","3");
            if(sinif7bolum7s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum7s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum7s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum7s6 = sharedPreferences.getString("7.SINIFbölüm7s6yildiz","3");
            if(sinif7bolum7s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum7s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum7s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='7.SINIFbölüm7'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("7.SINIFbölüm8")){
            String sinif7bolum8s1 = sharedPreferences.getString("7.SINIFbölüm8s1yildiz","3");
            if(sinif7bolum8s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum8s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum8s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum8s2 = sharedPreferences.getString("7.SINIFbölüm8s2yildiz","3");
            if(sinif7bolum8s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum8s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum8s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum8s3 = sharedPreferences.getString("7.SINIFbölüm8s3yildiz","3");
            if(sinif7bolum8s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum8s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum8s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum8s4 = sharedPreferences.getString("7.SINIFbölüm8s4yildiz","3");
            if(sinif7bolum8s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum8s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum8s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum8s5 = sharedPreferences.getString("7.SINIFbölüm8s5yildiz","3");
            if(sinif7bolum8s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum8s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum8s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum8s6 = sharedPreferences.getString("7.SINIFbölüm8s6yildiz","3");
            if(sinif7bolum8s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum8s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum8s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='7.SINIFbölüm8'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("7.SINIFbölüm9")){
            String sinif7bolum9s1 = sharedPreferences.getString("7.SINIFbölüm9s1yildiz","3");
            if(sinif7bolum9s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum9s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum9s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum9s2 = sharedPreferences.getString("7.SINIFbölüm9s2yildiz","3");
            if(sinif7bolum9s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum9s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum9s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum9s3 = sharedPreferences.getString("7.SINIFbölüm9s3yildiz","3");
            if(sinif7bolum9s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum9s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum9s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum9s4 = sharedPreferences.getString("7.SINIFbölüm9s4yildiz","3");
            if(sinif7bolum9s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum9s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum9s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum9s5 = sharedPreferences.getString("7.SINIFbölüm9s5yildiz","3");
            if(sinif7bolum9s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum9s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum9s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum9s6 = sharedPreferences.getString("7.SINIFbölüm9s6yildiz","3");
            if(sinif7bolum9s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum9s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum9s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='7.SINIFbölüm9'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("7.SINIFbölüm10")){
            String sinif7bolum10s1 = sharedPreferences.getString("7.SINIFbölüm10s1yildiz","3");
            if(sinif7bolum10s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum10s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum10s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum10s2 = sharedPreferences.getString("7.SINIFbölüm10s2yildiz","3");
            if(sinif7bolum10s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum10s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum10s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum10s3 = sharedPreferences.getString("7.SINIFbölüm10s3yildiz","3");
            if(sinif7bolum10s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum10s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum10s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum10s4 = sharedPreferences.getString("7.SINIFbölüm10s4yildiz","3");
            if(sinif7bolum10s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum10s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum10s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum10s5 = sharedPreferences.getString("7.SINIFbölüm10s5yildiz","3");
            if(sinif7bolum10s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum10s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum10s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif7bolum10s6 = sharedPreferences.getString("7.SINIFbölüm10s6yildiz","3");
            if(sinif7bolum10s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif7bolum10s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif7bolum10s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='7.SINIFbölüm10'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }
    }if (nerde.contains("8.SINIFbölüm1")){
        String sinif8bolum1s1 = sharedPreferences.getString("8.SINIFbölüm1s1yildiz","3");
        if(sinif8bolum1s1.equals("0")){
            bir.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum1s1.equals("1")){
            bir.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum1s1.equals("2")){
            bir.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum1s2 = sharedPreferences.getString("8.SINIFbölüm1s2yildiz","3");
        if(sinif8bolum1s2.equals("0")){
            iki.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum1s2.equals("1")){
            iki.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum1s2.equals("2")){
            iki.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum1s3 = sharedPreferences.getString("8.SINIFbölüm1s3yildiz","3");
        if(sinif8bolum1s3.equals("0")){
            uc.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum1s3.equals("1")){
            uc.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum1s3.equals("2")){
            uc.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum1s4 = sharedPreferences.getString("8.SINIFbölüm1s4yildiz","3");
        if(sinif8bolum1s4.equals("0")){
            dort.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum1s4.equals("1")){
            dort.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum1s4.equals("2")){
            dort.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum1s5 = sharedPreferences.getString("8.SINIFbölüm1s5yildiz","3");
        if(sinif8bolum1s5.equals("0")){
            bes.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum1s5.equals("1")){
            bes.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum1s5.equals("2")){
            bes.setBackgroundResource(R.drawable.stars5);
        }
        String sinif86bolum1s6 = sharedPreferences.getString("8.SINIFbölüm1s6yildiz","3");
        if(sinif86bolum1s6.equals("0")){
            alti.setBackgroundResource(R.drawable.star1);
        }if(sinif86bolum1s6.equals("1")){
            alti.setBackgroundResource(R.drawable.stars2);
        }if(sinif86bolum1s6.equals("2")){
            alti.setBackgroundResource(R.drawable.stars5);
        }
        Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='8.SINIFbölüm1'",null);
        int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
        int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
        while (cursor.moveToNext()) {
            dogru.setText("" + cursor.getInt(sayi));
            yanlis.setText("" + cursor.getInt(sayi1));
        }


    }if (nerde.contains("8.SINIFbölüm2")){
        String sinif8bolum2s1 = sharedPreferences.getString("8.SINIFbölüm2s1yildiz","3");
        if(sinif8bolum2s1.equals("0")){
            bir.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum2s1.equals("1")){
            bir.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum2s1.equals("2")){
            bir.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum2s2 = sharedPreferences.getString("8.SINIFbölüm2s2yildiz","3");
        if(sinif8bolum2s2.equals("0")){
            iki.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum2s2.equals("1")){
            iki.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum2s2.equals("2")){
            iki.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum2s3 = sharedPreferences.getString("8.SINIFbölüm2s3yildiz","3");
        if(sinif8bolum2s3.equals("0")){
            uc.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum2s3.equals("1")){
            uc.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum2s3.equals("2")){
            uc.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum2s4 = sharedPreferences.getString("8.SINIFbölüm2s4yildiz","3");
        if(sinif8bolum2s4.equals("0")){
            dort.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum2s4.equals("1")){
            dort.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum2s4.equals("2")){
            dort.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum2s5 = sharedPreferences.getString("8.SINIFbölüm2s5yildiz","3");
        if(sinif8bolum2s5.equals("0")){
            bes.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum2s5.equals("1")){
            bes.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum2s5.equals("2")){
            bes.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum2s6 = sharedPreferences.getString("8.SINIFbölüm2s6yildiz","3");
        if(sinif8bolum2s6.equals("0")){
            alti.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum2s6.equals("1")){
            alti.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum2s6.equals("2")){
            alti.setBackgroundResource(R.drawable.stars5);
        }


        Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='8.SINIFbölüm2'",null);
        int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
        int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
        while (cursor.moveToNext()) {
            dogru.setText("" + cursor.getInt(sayi));
            yanlis.setText("" + cursor.getInt(sayi1));
        }


    }if (nerde.contains("8.SINIFbölüm3")){
        String sinif8bolum3s1 = sharedPreferences.getString("8.SINIFbölüm3s1yildiz","3");
        if(sinif8bolum3s1.equals("0")){
            bir.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum3s1.equals("1")){
            bir.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum3s1.equals("2")){
            bir.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum3s2 = sharedPreferences.getString("8.SINIFbölüm3s2yildiz","3");
        if(sinif8bolum3s2.equals("0")){
            iki.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum3s2.equals("1")){
            iki.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum3s2.equals("2")){
            iki.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum3s3 = sharedPreferences.getString("8.SINIFbölüm3s3yildiz","3");
        if(sinif8bolum3s3.equals("0")){
            uc.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum3s3.equals("1")){
            uc.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum3s3.equals("2")){
            uc.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum3s4 = sharedPreferences.getString("8.SINIFbölüm3s4yildiz","3");
        if(sinif8bolum3s4.equals("0")){
            dort.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum3s4.equals("1")){
            dort.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum3s4.equals("2")){
            dort.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum3s5 = sharedPreferences.getString("8.SINIFbölüm3s5yildiz","3");
        if(sinif8bolum3s5.equals("0")){
            bes.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum3s5.equals("1")){
            bes.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum3s5.equals("2")){
            bes.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum3s6 = sharedPreferences.getString("8.SINIFbölüm3s6yildiz","3");
        if(sinif8bolum3s6.equals("0")){
            alti.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum3s6.equals("1")){
            alti.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum3s6.equals("2")){
            alti.setBackgroundResource(R.drawable.stars5);
        }

        Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='8.SINIFbölüm3'",null);
        int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
        int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
        while (cursor.moveToNext()) {
            dogru.setText("" + cursor.getInt(sayi));
            yanlis.setText("" + cursor.getInt(sayi1));
        }




    }if (nerde.contains("8.SINIFbölüm4")){
        String sinif8bolum4s1 = sharedPreferences.getString("8.SINIFbölüm4s1yildiz","3");
        if(sinif8bolum4s1.equals("0")){
            bir.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum4s1.equals("1")){
            bir.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum4s1.equals("2")){
            bir.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum4s2 = sharedPreferences.getString("8.SINIFbölüm4s2yildiz","3");
        if(sinif8bolum4s2.equals("0")){
            iki.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum4s2.equals("1")){
            iki.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum4s2.equals("2")){
            iki.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum4s3 = sharedPreferences.getString("8.SINIFbölüm4s3yildiz","3");
        if(sinif8bolum4s3.equals("0")){
            uc.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum4s3.equals("1")){
            uc.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum4s3.equals("2")){
            uc.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum4s4 = sharedPreferences.getString("8.SINIFbölüm4s4yildiz","3");
        if(sinif8bolum4s4.equals("0")){
            dort.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum4s4.equals("1")){
            dort.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum4s4.equals("2")){
            dort.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum4s5 = sharedPreferences.getString("8.SINIFbölüm4s5yildiz","3");
        if(sinif8bolum4s5.equals("0")){
            bes.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum4s5.equals("1")){
            bes.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum4s5.equals("2")){
            bes.setBackgroundResource(R.drawable.stars5);
        }
        String B01bolum4s6 = sharedPreferences.getString("8.SINIFbölüm4s6yildiz","3");
        if(B01bolum4s6.equals("0")){
            alti.setBackgroundResource(R.drawable.star1);
        }if(B01bolum4s6.equals("1")){
            alti.setBackgroundResource(R.drawable.stars2);
        }if(B01bolum4s6.equals("2")){
            alti.setBackgroundResource(R.drawable.stars5);
        }
        Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='8.SINIFbölüm4'",null);
        int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
        int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
        while (cursor.moveToNext()) {
            dogru.setText("" + cursor.getInt(sayi));
            yanlis.setText("" + cursor.getInt(sayi1));
        }


    }if (nerde.contains("8.SINIFbölüm5")){
        String sinif8bolum5s1 = sharedPreferences.getString("8.SINIFbölüm5s1yildiz","3");
        if(sinif8bolum5s1.equals("0")){
            bir.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum5s1.equals("1")){
            bir.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum5s1.equals("2")){
            bir.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum5s2 = sharedPreferences.getString("8.SINIFbölüm5s2yildiz","3");
        if(sinif8bolum5s2.equals("0")){
            iki.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum5s2.equals("1")){
            iki.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum5s2.equals("2")){
            iki.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum5s3 = sharedPreferences.getString("8.SINIFbölüm5s3yildiz","3");
        if(sinif8bolum5s3.equals("0")){
            uc.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum5s3.equals("1")){
            uc.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum5s3.equals("2")){
            uc.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum55s6 = sharedPreferences.getString("8.SINIFbölüm5s6yildiz","3");
        if(sinif8bolum55s6.equals("0")){
            alti.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum55s6.equals("1")){
            alti.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum55s6.equals("2")){
            alti.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum55s4 = sharedPreferences.getString("8.SINIFbölüm5s4yildiz","3");
        if(sinif8bolum55s4.equals("0")){
            dort.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum55s4.equals("1")){
            dort.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum55s4.equals("2")){
            dort.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum55s5 = sharedPreferences.getString("8.SINIFbölüm5s5yildiz","3");
        if(sinif8bolum55s5.equals("0")){
            bes.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum55s5.equals("1")){
            bes.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum55s5.equals("2")){
            bes.setBackgroundResource(R.drawable.stars5);
        }


        Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='8.SINIFbölüm5'",null);
        int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
        int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
        while (cursor.moveToNext()) {
            dogru.setText("" + cursor.getInt(sayi));
            yanlis.setText("" + cursor.getInt(sayi1));
        }


    }if (nerde.contains("8.SINIFbölüm6")){
        String sinif8bolum6s1 = sharedPreferences.getString("8.SINIFbölüm6s1yildiz","3");
        if(sinif8bolum6s1.equals("0")){
            bir.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum6s1.equals("1")){
            bir.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum6s1.equals("2")){
            bir.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum6s2 = sharedPreferences.getString("8.SINIFbölüm6s2yildiz","3");
        if(sinif8bolum6s2.equals("0")){
            iki.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum6s2.equals("1")){
            iki.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum6s2.equals("2")){
            iki.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum6s3 = sharedPreferences.getString("8.SINIFbölüm6s3yildiz","3");
        if(sinif8bolum6s3.equals("0")){
            uc.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum6s3.equals("1")){
            uc.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum6s3.equals("2")){
            uc.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum6s4 = sharedPreferences.getString("8.SINIFbölüm6s4yildiz","3");
        if(sinif8bolum6s4.equals("0")){
            dort.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum6s4.equals("1")){
            dort.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum6s4.equals("2")){
            dort.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum6s5 = sharedPreferences.getString("8.SINIFbölüm6s5yildiz","3");
        if(sinif8bolum6s5.equals("0")){
            bes.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum6s5.equals("1")){
            bes.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum6s5.equals("2")){
            bes.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum66s6 = sharedPreferences.getString("8.SINIFbölüm6s6yildiz","3");
        if(sinif8bolum66s6.equals("0")){
            alti.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum66s6.equals("1")){
            alti.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum66s6.equals("2")){
            alti.setBackgroundResource(R.drawable.stars5);
        }


        Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='8.SINIFbölüm6'",null);
        int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
        int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
        while (cursor.moveToNext()) {
            dogru.setText("" + cursor.getInt(sayi));
            yanlis.setText("" + cursor.getInt(sayi1));
        }


    }if (nerde.contains("8.SINIFbölüm7")){
        String sinif8bolum7s1 = sharedPreferences.getString("8.SINIFbölüm7s1yildiz","3");
        if(sinif8bolum7s1.equals("0")){
            bir.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum7s1.equals("1")){
            bir.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum7s1.equals("2")){
            bir.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum7s2 = sharedPreferences.getString("8.SINIFbölüm7s2yildiz","3");
        if(sinif8bolum7s2.equals("0")){
            iki.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum7s2.equals("1")){
            iki.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum7s2.equals("2")){
            iki.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum7s3 = sharedPreferences.getString("8.SINIFbölüm7s3yildiz","3");
        if(sinif8bolum7s3.equals("0")){
            uc.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum7s3.equals("1")){
            uc.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum7s3.equals("2")){
            uc.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum77s4 = sharedPreferences.getString("8.SINIFbölüm7s4yildiz","3");
        if(sinif8bolum77s4.equals("0")){
            dort.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum77s4.equals("1")){
            dort.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum77s4.equals("2")){
            dort.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum77s5 = sharedPreferences.getString("8.SINIFbölüm7s5yildiz","3");
        if(sinif8bolum77s5.equals("0")){
            bes.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum77s5.equals("1")){
            bes.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum77s5.equals("2")){
            bes.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum77s6 = sharedPreferences.getString("8.SINIFbölüm7s6yildiz","3");
        if(sinif8bolum77s6.equals("0")){
            alti.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum77s6.equals("1")){
            alti.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum77s6.equals("2")){
            alti.setBackgroundResource(R.drawable.stars5);
        }

        Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='8.SINIFbölüm7'",null);
        int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
        int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
        while (cursor.moveToNext()) {
            dogru.setText("" + cursor.getInt(sayi));
            yanlis.setText("" + cursor.getInt(sayi1));
        }



    }if (nerde.contains("8.SINIFbölüm8")){
        String sinif8bolum8s1 = sharedPreferences.getString("8.SINIFbölüm8s1yildiz","3");
        if(sinif8bolum8s1.equals("0")){
            bir.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum8s1.equals("1")){
            bir.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum8s1.equals("2")){
            bir.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum8s2 = sharedPreferences.getString("8.SINIFbölüm8s2yildiz","3");
        if(sinif8bolum8s2.equals("0")){
            iki.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum8s2.equals("1")){
            iki.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum8s2.equals("2")){
            iki.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum8s3 = sharedPreferences.getString("8.SINIFbölüm8s3yildiz","3");
        if(sinif8bolum8s3.equals("0")){
            uc.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum8s3.equals("1")){
            uc.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum8s3.equals("2")){
            uc.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum8s4 = sharedPreferences.getString("8.SINIFbölüm8s4yildiz","3");
        if(sinif8bolum8s4.equals("0")){
            dort.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum8s4.equals("1")){
            dort.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum8s4.equals("2")){
            dort.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum8s5 = sharedPreferences.getString("8.SINIFbölüm8s5yildiz","3");
        if(sinif8bolum8s5.equals("0")){
            bes.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum8s5.equals("1")){
            bes.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum8s5.equals("2")){
            bes.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum8s6 = sharedPreferences.getString("8.SINIFbölüm8s6yildiz","3");
        if(sinif8bolum8s6.equals("0")){
            alti.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum8s6.equals("1")){
            alti.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum8s6.equals("2")){
            alti.setBackgroundResource(R.drawable.stars5);
        }

        Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='8.SINIFbölüm8'",null);
        int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
        int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
        while (cursor.moveToNext()) {
            dogru.setText("" + cursor.getInt(sayi));
            yanlis.setText("" + cursor.getInt(sayi1));
        }



    }if (nerde.contains("8.SINIFbölüm9")){
        String sinif8bolum9s1 = sharedPreferences.getString("8.SINIFbölüm9s1yildiz","3");
        if(sinif8bolum9s1.equals("0")){
            bir.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum9s1.equals("1")){
            bir.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum9s1.equals("2")){
            bir.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum9s2 = sharedPreferences.getString("8.SINIFbölüm9s2yildiz","3");
        if(sinif8bolum9s2.equals("0")){
            iki.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum9s2.equals("1")){
            iki.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum9s2.equals("2")){
            iki.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum9s3 = sharedPreferences.getString("8.SINIFbölüm9s3yildiz","3");
        if(sinif8bolum9s3.equals("0")){
            uc.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum9s3.equals("1")){
            uc.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum9s3.equals("2")){
            uc.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum9s4 = sharedPreferences.getString("8.SINIFbölüm9s4yildiz","3");
        if(sinif8bolum9s4.equals("0")){
            dort.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum9s4.equals("1")){
            dort.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum9s4.equals("2")){
            dort.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum9s5 = sharedPreferences.getString("8.SINIFbölüm9s5yildiz","3");
        if(sinif8bolum9s5.equals("0")){
            bes.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum9s5.equals("1")){
            bes.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum9s5.equals("2")){
            bes.setBackgroundResource(R.drawable.stars5);
        }
        String sinif8bolum9s6 = sharedPreferences.getString("8.SINIFbölüm9s6yildiz","3");
        if(sinif8bolum9s6.equals("0")){
            alti.setBackgroundResource(R.drawable.star1);
        }if(sinif8bolum9s6.equals("1")){
            alti.setBackgroundResource(R.drawable.stars2);
        }if(sinif8bolum9s6.equals("2")){
            alti.setBackgroundResource(R.drawable.stars5);
        }

        Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='8.SINIFbölüm9'",null);
        int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
        int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
        while (cursor.moveToNext()) {
            dogru.setText("" + cursor.getInt(sayi));
            yanlis.setText("" + cursor.getInt(sayi1));
        }
    }
        s++;



    }
}