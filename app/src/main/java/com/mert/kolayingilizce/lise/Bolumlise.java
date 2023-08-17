package com.mert.kolayingilizce.lise;

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


public class Bolumlise extends AppCompatActivity {

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
        setContentView(R.layout.activity_bolumlise);
        sharedPreferences = this.getSharedPreferences("com.mert.kolayingilizce", Context.MODE_PRIVATE);
        TextView textView1 = findViewById(R.id.textView14);
        TextView textView2 = findViewById(R.id.textView6);
        TextView textView3 = findViewById(R.id.textView8);
        TextView textView4 = findViewById(R.id.textView9);
        dogru = findViewById(R.id.textView12);
        yanlis = findViewById(R.id.textView13);
        bir = findViewById(R.id.button16);
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
                Intent intent = new Intent(Bolumlise.this, Kelimelise.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s1").apply();
                finish();
            }
        });
        iki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumlise.this, Kelimelise.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s2").apply();
                finish();
            }
        });
        uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumlise.this, Kelimelise.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s3").apply();
                finish();
            }
        });
        dort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumlise.this, Kelimelise.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s4").apply();
                finish();
            }
        });
        bes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumlise.this, Kelimelise.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s5").apply();
                finish();
            }
        });
        alti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumlise.this, Kelimelise.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s6").apply();
                finish();
            }
        });
    }


    public void resimsorgu(){
        if (nerde.contains("9.SINIFbölüm1")){
            String sinif9bolum1s1 = sharedPreferences.getString("9.SINIFbölüm1s1yildiz","3");
            if(sinif9bolum1s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum1s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum1s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum1s2 = sharedPreferences.getString("9.SINIFbölüm1s2yildiz","3");
            if(sinif9bolum1s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum1s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum1s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum1s3 = sharedPreferences.getString("9.SINIFbölüm1s3yildiz","3");
            if(sinif9bolum1s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum1s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum1s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum1s4 = sharedPreferences.getString("9.SINIFbölüm1s4yildiz","3");
            if(sinif9bolum1s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum1s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum1s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum1s5 = sharedPreferences.getString("9.SINIFbölüm1s5yildiz","3");
            if(sinif9bolum1s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum1s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum1s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum1s6= sharedPreferences.getString("9.SINIFbölüm1s6yildiz","3");
            if(sinif9bolum1s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum1s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum1s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='9.SINIFbölüm1'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }




        }if (nerde.contains("9.SINIFbölüm2")){
            String sinif9bolum2s1 = sharedPreferences.getString("9.SINIFbölüm2s1yildiz","3");
            if(sinif9bolum2s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum2s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum2s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum2s2 = sharedPreferences.getString("9.SINIFbölüm2s2yildiz","3");
            if(sinif9bolum2s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum2s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum2s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum2s3 = sharedPreferences.getString("9.SINIFbölüm2s3yildiz","3");
            if(sinif9bolum2s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum2s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum2s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum2s4 = sharedPreferences.getString("9.SINIFbölüm2s4yildiz","3");
            if(sinif9bolum2s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum2s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum2s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum2s5 = sharedPreferences.getString("9.SINIFbölüm2s5yildiz","3");
            if(sinif9bolum2s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum2s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum2s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum2s6 = sharedPreferences.getString("9.SINIFbölüm2s6yildiz","3");
            if(sinif9bolum2s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum2s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum2s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='9.SINIFbölüm2'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }

        }if (nerde.contains("9.SINIFbölüm3")){
            String sinif9bolum3s1 = sharedPreferences.getString("9.SINIFbölüm3s1yildiz","3");
            if(sinif9bolum3s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum3s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum3s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum3s2 = sharedPreferences.getString("9.SINIFbölüm3s2yildiz","3");
            if(sinif9bolum3s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum3s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum3s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum3s3 = sharedPreferences.getString("9.SINIFbölüm3s3yildiz","3");
            if(sinif9bolum3s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum3s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum3s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum3s4 = sharedPreferences.getString("9.SINIFbölüm3s4yildiz","3");
            if(sinif9bolum3s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum3s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum3s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum3s5 = sharedPreferences.getString("9.SINIFbölüm3s5yildiz","3");
            if(sinif9bolum3s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum3s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum3s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum3s6 = sharedPreferences.getString("9.SINIFbölüm3s6yildiz","3");
            if(sinif9bolum3s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum3s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum3s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='9.SINIFbölüm3'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("9.SINIFbölüm4")){
            String sinif9bolum4s1 = sharedPreferences.getString("9.SINIFbölüm4s1yildiz","3");
            if(sinif9bolum4s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum4s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum4s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum4s2 = sharedPreferences.getString("9.SINIFbölüm4s2yildiz","3");
            if(sinif9bolum4s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum4s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum4s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum4s3 = sharedPreferences.getString("9.SINIFbölüm4s3yildiz","3");
            if(sinif9bolum4s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum4s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum4s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum4s4 = sharedPreferences.getString("9.SINIFbölüm4s4yildiz","3");
            if(sinif9bolum4s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum4s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum4s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum4s5 = sharedPreferences.getString("9.SINIFbölüm4s5yildiz","3");
            if(sinif9bolum4s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum4s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum4s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum4s6 = sharedPreferences.getString("9.SINIFbölüm4s6yildiz","3");
            if(sinif9bolum4s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum4s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum4s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='9.SINIFbölüm4'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("9.SINIFbölüm5")){
            String sinif9bolum5s1 = sharedPreferences.getString("9.SINIFbölüm5s1yildiz","3");
            if(sinif9bolum5s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum5s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum5s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum5s2 = sharedPreferences.getString("9.SINIFbölüm5s2yildiz","3");
            if(sinif9bolum5s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum5s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum5s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum5s3 = sharedPreferences.getString("9.SINIFbölüm5s3yildiz","3");
            if(sinif9bolum5s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum5s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum5s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum5s4 = sharedPreferences.getString("9.SINIFbölüm5s4yildiz","3");
            if(sinif9bolum5s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum5s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum5s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum5s5 = sharedPreferences.getString("9.SINIFbölüm5s5yildiz","3");
            if(sinif9bolum5s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum5s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum5s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum5s6 = sharedPreferences.getString("9.SINIFbölüm5s6yildiz","3");
            if(sinif9bolum5s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum5s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum5s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='9.SINIFbölüm5'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }

        }if (nerde.contains("9.SINIFbölüm6")){
            String sinif9bolum6s1 = sharedPreferences.getString("9.SINIFbölüm6s1yildiz","3");
            if(sinif9bolum6s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum6s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum6s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum6s2 = sharedPreferences.getString("9.SINIFbölüm6s2yildiz","3");
            if(sinif9bolum6s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum6s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum6s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum6s3 = sharedPreferences.getString("9.SINIFbölüm6s3yildiz","3");
            if(sinif9bolum6s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum6s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum6s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum6s4 = sharedPreferences.getString("9.SINIFbölüm6s4yildiz","3");
            if(sinif9bolum6s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum6s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum6s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum6s5 = sharedPreferences.getString("9.SINIFbölüm6s5yildiz","3");
            if(sinif9bolum6s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum6s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum6s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum6s6 = sharedPreferences.getString("9.SINIFbölüm6s6yildiz","3");
            if(sinif9bolum6s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum6s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum6s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='9.SINIFbölüm6'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("9.SINIFbölüm7")){
            String sinif9bolum7s1 = sharedPreferences.getString("9.SINIFbölüm7s1yildiz","3");
            if(sinif9bolum7s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum7s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum7s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum7s2 = sharedPreferences.getString("9.SINIFbölüm7s2yildiz","3");
            if(sinif9bolum7s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum7s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum7s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum7s3 = sharedPreferences.getString("9.SINIFbölüm7s3yildiz","3");
            if(sinif9bolum7s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum7s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum7s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum7s4 = sharedPreferences.getString("9.SINIFbölüm7s4yildiz","3");
            if(sinif9bolum7s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum7s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum7s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum7s5 = sharedPreferences.getString("9.SINIFbölüm7s5yildiz","3");
            if(sinif9bolum7s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum7s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum7s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum7s6 = sharedPreferences.getString("9.SINIFbölüm7s6yildiz","3");
            if(sinif9bolum7s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum7s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum7s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='9.SINIFbölüm7'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }
        }if (nerde.contains("9.SINIFbölüm8")){
            String sinif9bolum8s1 = sharedPreferences.getString("9.SINIFbölüm8s1yildiz","3");
            if(sinif9bolum8s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum8s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum8s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum8s2 = sharedPreferences.getString("9.SINIFbölüm8s2yildiz","3");
            if(sinif9bolum8s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum8s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum8s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum8s3 = sharedPreferences.getString("9.SINIFbölüm8s3yildiz","3");
            if(sinif9bolum8s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum8s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum8s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum8s4 = sharedPreferences.getString("9.SINIFbölüm8s4yildiz","3");
            if(sinif9bolum8s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum8s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum8s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum8s5 = sharedPreferences.getString("9.SINIFbölüm8s5yildiz","3");
            if(sinif9bolum8s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum8s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum8s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif9bolum8s6 = sharedPreferences.getString("9.SINIFbölüm8s6yildiz","3");
            if(sinif9bolum8s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif9bolum8s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif9bolum8s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='9.SINIFbölüm8'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("10.SINIFbölüm1")){
            String sinif10bolum1s1 = sharedPreferences.getString("10.SINIFbölüm1s1yildiz","3");
            if(sinif10bolum1s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum1s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum1s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum1s2 = sharedPreferences.getString("10.SINIFbölüm1s2yildiz","3");
            if(sinif10bolum1s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum1s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum1s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum1s3 = sharedPreferences.getString("10.SINIFbölüm1s3yildiz","3");
            if(sinif10bolum1s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum1s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum1s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum1s4 = sharedPreferences.getString("10.SINIFbölüm1s4yildiz","3");
            if(sinif10bolum1s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum1s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum1s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum1s5 = sharedPreferences.getString("10.SINIFbölüm1s5yildiz","3");
            if(sinif10bolum1s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum1s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum1s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum1s6= sharedPreferences.getString("10.SINIFbölüm1s6yildiz","3");
            if(sinif10bolum1s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum1s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum1s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='10.SINIFbölüm1'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("10.SINIFbölüm2")){
            String sinif10bolum2s1 = sharedPreferences.getString("10.SINIFbölüm2s1yildiz","3");
            if(sinif10bolum2s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum2s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum2s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum2s2 = sharedPreferences.getString("10.SINIFbölüm2s2yildiz","3");
            if(sinif10bolum2s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum2s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum2s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum2s3 = sharedPreferences.getString("10.SINIFbölüm2s3yildiz","3");
            if(sinif10bolum2s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum2s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum2s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum2s4 = sharedPreferences.getString("10.SINIFbölüm2s4yildiz","3");
            if(sinif10bolum2s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum2s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum2s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum2s5 = sharedPreferences.getString("10.SINIFbölüm2s5yildiz","3");
            if(sinif10bolum2s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum2s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum2s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum2s6 = sharedPreferences.getString("10.SINIFbölüm2s6yildiz","3");
            if(sinif10bolum2s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum2s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum2s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='10.SINIFbölüm2'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("10.SINIFbölüm3")){
            String sinif10bolum3s1 = sharedPreferences.getString("10.SINIFbölüm3s1yildiz","3");
            if(sinif10bolum3s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum3s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum3s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum3s2 = sharedPreferences.getString("10.SINIFbölüm3s2yildiz","3");
            if(sinif10bolum3s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum3s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum3s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum3s3 = sharedPreferences.getString("10.SINIFbölüm3s3yildiz","3");
            if(sinif10bolum3s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum3s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum3s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum3s4 = sharedPreferences.getString("10.SINIFbölüm3s4yildiz","3");
            if(sinif10bolum3s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum3s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum3s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum3s5 = sharedPreferences.getString("10.SINIFbölüm3s5yildiz","3");
            if(sinif10bolum3s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum3s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum3s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum3s6 = sharedPreferences.getString("10.SINIFbölüm3s6yildiz","3");
            if(sinif10bolum3s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum3s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum3s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='10.SINIFbölüm3'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }




        }if (nerde.contains("10.SINIFbölüm4")){
            String sinif10bolum4s1 = sharedPreferences.getString("10.SINIFbölüm4s1yildiz","3");
            if(sinif10bolum4s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum4s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum4s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum4s2 = sharedPreferences.getString("10.SINIFbölüm4s2yildiz","3");
            if(sinif10bolum4s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum4s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum4s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum4s3 = sharedPreferences.getString("10.SINIFbölüm4s3yildiz","3");
            if(sinif10bolum4s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum4s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum4s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum4s4 = sharedPreferences.getString("10.SINIFbölüm4s4yildiz","3");
            if(sinif10bolum4s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum4s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum4s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum4s5 = sharedPreferences.getString("10.SINIFbölüm4s5yildiz","3");
            if(sinif10bolum4s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum4s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum4s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum4s6 = sharedPreferences.getString("10.SINIFbölüm4s6yildiz","3");
            if(sinif10bolum4s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum4s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum4s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='10.SINIFbölüm4'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("10.SINIFbölüm5")){
            String sinif10bolum5s1 = sharedPreferences.getString("10.SINIFbölüm5s1yildiz","3");
            if(sinif10bolum5s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum5s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum5s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum5s2 = sharedPreferences.getString("10.SINIFbölüm5s2yildiz","3");
            if(sinif10bolum5s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum5s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum5s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum5s3 = sharedPreferences.getString("10.SINIFbölüm5s3yildiz","3");
            if(sinif10bolum5s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum5s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum5s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum5s4 = sharedPreferences.getString("10.SINIFbölüm5s4yildiz","3");
            if(sinif10bolum5s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum5s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum5s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum5s5 = sharedPreferences.getString("10.SINIFbölüm5s5yildiz","3");
            if(sinif10bolum5s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum5s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum5s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum5s6 = sharedPreferences.getString("10.SINIFbölüm5s6yildiz","3");
            if(sinif10bolum5s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum5s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum5s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='10.SINIFbölüm5'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("10.SINIFbölüm6")){
            String sinif10bolum6s1 = sharedPreferences.getString("10.SINIFbölüm6s1yildiz","3");
            if(sinif10bolum6s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum6s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum6s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum6s2 = sharedPreferences.getString("10.SINIFbölüm6s2yildiz","3");
            if(sinif10bolum6s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum6s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum6s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum6s3 = sharedPreferences.getString("10.SINIFbölüm6s3yildiz","3");
            if(sinif10bolum6s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum6s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum6s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum6s4 = sharedPreferences.getString("10.SINIFbölüm6s4yildiz","3");
            if(sinif10bolum6s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum6s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum6s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum6s5 = sharedPreferences.getString("10.SINIFbölüm6s5yildiz","3");
            if(sinif10bolum6s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum6s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum6s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum6s6 = sharedPreferences.getString("10.SINIFbölüm6s6yildiz","3");
            if(sinif10bolum6s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum6s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum6s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='10.SINIFbölüm6'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("10.SINIFbölüm7")){
            String sinif10bolum7s1 = sharedPreferences.getString("10.SINIFbölüm7s1yildiz","3");
            if(sinif10bolum7s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum7s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum7s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum7s2 = sharedPreferences.getString("10.SINIFbölüm7s2yildiz","3");
            if(sinif10bolum7s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum7s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum7s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum7s3 = sharedPreferences.getString("10.SINIFbölüm7s3yildiz","3");
            if(sinif10bolum7s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum7s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum7s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum7s4 = sharedPreferences.getString("10.SINIFbölüm7s4yildiz","3");
            if(sinif10bolum7s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum7s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum7s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum7s5 = sharedPreferences.getString("10.SINIFbölüm7s5yildiz","3");
            if(sinif10bolum7s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum7s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum7s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum7s6 = sharedPreferences.getString("10.SINIFbölüm7s6yildiz","3");
            if(sinif10bolum7s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum7s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum7s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='10.SINIFbölüm7'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("10.SINIFbölüm8")){
            String sinif10bolum8s1 = sharedPreferences.getString("10.SINIFbölüm8s1yildiz","3");
            if(sinif10bolum8s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum8s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum8s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum8s2 = sharedPreferences.getString("10.SINIFbölüm8s2yildiz","3");
            if(sinif10bolum8s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum8s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum8s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum8s3 = sharedPreferences.getString("10.SINIFbölüm8s3yildiz","3");
            if(sinif10bolum8s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum8s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum8s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum8s4 = sharedPreferences.getString("10.SINIFbölüm8s4yildiz","3");
            if(sinif10bolum8s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum8s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum8s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum8s5 = sharedPreferences.getString("10.SINIFbölüm8s5yildiz","3");
            if(sinif10bolum8s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum8s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum8s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum8s6 = sharedPreferences.getString("10.SINIFbölüm8s6yildiz","3");
            if(sinif10bolum8s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum8s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum8s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='10.SINIFbölüm8'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("10.SINIFbölüm9")){
            String sinif10bolum9s1 = sharedPreferences.getString("10.SINIFbölüm9s1yildiz","3");
            if(sinif10bolum9s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum9s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum9s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum9s2 = sharedPreferences.getString("10.SINIFbölüm9s2yildiz","3");
            if(sinif10bolum9s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum9s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum9s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum9s3 = sharedPreferences.getString("10.SINIFbölüm9s3yildiz","3");
            if(sinif10bolum9s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum9s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum9s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum9s4 = sharedPreferences.getString("10.SINIFbölüm9s4yildiz","3");
            if(sinif10bolum9s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum9s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum9s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum9s5 = sharedPreferences.getString("10.SINIFbölüm9s5yildiz","3");
            if(sinif10bolum9s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum9s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum9s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum9s6 = sharedPreferences.getString("10.SINIFbölüm9s6yildiz","3");
            if(sinif10bolum9s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum9s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum9s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='10.SINIFbölüm9'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("10.SINIFbölüm10")){
            String sinif10bolum10s1 = sharedPreferences.getString("10.SINIFbölüm10s1yildiz","3");
            if(sinif10bolum10s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum10s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum10s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum10s2 = sharedPreferences.getString("10.SINIFbölüm10s2yildiz","3");
            if(sinif10bolum10s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum10s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum10s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum10s3 = sharedPreferences.getString("10.SINIFbölüm10s3yildiz","3");
            if(sinif10bolum10s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum10s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum10s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum10s4 = sharedPreferences.getString("10.SINIFbölüm10s4yildiz","3");
            if(sinif10bolum10s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum10s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum10s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum10s5 = sharedPreferences.getString("10.SINIFbölüm10s5yildiz","3");
            if(sinif10bolum10s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum10s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum10s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif10bolum10s6 = sharedPreferences.getString("10.SINIFbölüm10s6yildiz","3");
            if(sinif10bolum10s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif10bolum10s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif10bolum10s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='10.SINIFbölüm10'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }
        }if (nerde.contains("11.SINIFbölüm1")){
            String sinif11bolum1s1 = sharedPreferences.getString("11.SINIFbölüm1s1yildiz","3");
            if(sinif11bolum1s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum1s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum1s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum1s2 = sharedPreferences.getString("11.SINIFbölüm1s2yildiz","3");
            if(sinif11bolum1s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum1s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum1s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            uc.setVisibility(View.INVISIBLE);
            dort.setVisibility(View.INVISIBLE);
            bes.setVisibility(View.INVISIBLE);
            alti.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='11.SINIFbölüm1'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("11.SINIFbölüm2")){
            String sinif11bolum2s1 = sharedPreferences.getString("11.SINIFbölüm2s1yildiz","3");
            if(sinif11bolum2s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum2s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum2s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum2s2 = sharedPreferences.getString("11.SINIFbölüm2s2yildiz","3");
            if(sinif11bolum2s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum2s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum2s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum2s3 = sharedPreferences.getString("11.SINIFbölüm2s3yildiz","3");
            if(sinif11bolum2s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum2s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum2s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum2s4 = sharedPreferences.getString("11.SINIFbölüm2s4yildiz","3");
            if(sinif11bolum2s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum2s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum2s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum2s5 = sharedPreferences.getString("11.SINIFbölüm2s5yildiz","3");
            if(sinif11bolum2s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum2s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum2s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum2s6 = sharedPreferences.getString("11.SINIFbölüm2s6yildiz","3");
            if(sinif11bolum2s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum2s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum2s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='11.SINIFbölüm2'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("11.SINIFbölüm3")){
            String sinif11bolum3s1 = sharedPreferences.getString("11.SINIFbölüm3s1yildiz","3");
            if(sinif11bolum3s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum3s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum3s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum3s2 = sharedPreferences.getString("11.SINIFbölüm3s2yildiz","3");
            if(sinif11bolum3s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum3s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum3s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum3s3 = sharedPreferences.getString("11.SINIFbölüm3s3yildiz","3");
            if(sinif11bolum3s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum3s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum3s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum3s4 = sharedPreferences.getString("11.SINIFbölüm3s4yildiz","3");
            if(sinif11bolum3s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum3s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum3s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum3s5 = sharedPreferences.getString("11.SINIFbölüm3s5yildiz","3");
            if(sinif11bolum3s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum3s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum3s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum3s6 = sharedPreferences.getString("11.SINIFbölüm3s6yildiz","3");
            if(sinif11bolum3s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum3s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum3s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='11.SINIFbölüm3'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }




        }if (nerde.contains("11.SINIFbölüm4")){
            String sinif11bolum4s1 = sharedPreferences.getString("11.SINIFbölüm4s1yildiz","3");
            if(sinif11bolum4s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum4s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum4s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum4s2 = sharedPreferences.getString("11.SINIFbölüm4s2yildiz","3");
            if(sinif11bolum4s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum4s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum4s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum4s3 = sharedPreferences.getString("11.SINIFbölüm4s3yildiz","3");
            if(sinif11bolum4s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum4s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum4s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum4s4 = sharedPreferences.getString("11.SINIFbölüm4s4yildiz","3");
            if(sinif11bolum4s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum4s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum4s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum4s5 = sharedPreferences.getString("11.SINIFbölüm4s5yildiz","3");
            if(sinif11bolum4s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum4s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum4s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum4s6 = sharedPreferences.getString("11.SINIFbölüm4s6yildiz","3");
            if(sinif11bolum4s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum4s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum4s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='11.SINIFbölüm4'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("11.SINIFbölüm5")){
            String sinif11bolum5s1 = sharedPreferences.getString("11.SINIFbölüm5s1yildiz","3");
            if(sinif11bolum5s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum5s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum5s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum5s2 = sharedPreferences.getString("11.SINIFbölüm5s2yildiz","3");
            if(sinif11bolum5s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum5s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum5s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum5s3 = sharedPreferences.getString("11.SINIFbölüm5s3yildiz","3");
            if(sinif11bolum5s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum5s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum5s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum5s4 = sharedPreferences.getString("11.SINIFbölüm5s4yildiz","3");
            if(sinif11bolum5s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum5s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum5s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum5s5 = sharedPreferences.getString("11.SINIFbölüm5s5yildiz","3");
            if(sinif11bolum5s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum5s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum5s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum5s6 = sharedPreferences.getString("11.SINIFbölüm5s6yildiz","3");
            if(sinif11bolum5s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum5s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum5s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='11.SINIFbölüm5'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("11.SINIFbölüm6")){
            String sinif11bolum6s1 = sharedPreferences.getString("11.SINIFbölüm6s1yildiz","3");
            if(sinif11bolum6s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum6s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum6s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum6s2 = sharedPreferences.getString("11.SINIFbölüm6s2yildiz","3");
            if(sinif11bolum6s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum6s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum6s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum6s3 = sharedPreferences.getString("11.SINIFbölüm6s3yildiz","3");
            if(sinif11bolum6s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum6s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum6s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum6s4 = sharedPreferences.getString("11.SINIFbölüm6s4yildiz","3");
            if(sinif11bolum6s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum6s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum6s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum6s5 = sharedPreferences.getString("11.SINIFbölüm6s5yildiz","3");
            if(sinif11bolum6s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum6s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum6s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum6s6 = sharedPreferences.getString("11.SINIFbölüm6s6yildiz","3");
            if(sinif11bolum6s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum6s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum6s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='11.SINIFbölüm6'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("11.SINIFbölüm7")){
            String sinif11bolum7s1 = sharedPreferences.getString("11.SINIFbölüm7s1yildiz","3");
            if(sinif11bolum7s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum7s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum7s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum7s2 = sharedPreferences.getString("11.SINIFbölüm7s2yildiz","3");
            if(sinif11bolum7s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum7s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum7s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum7s3 = sharedPreferences.getString("11.SINIFbölüm7s3yildiz","3");
            if(sinif11bolum7s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum7s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum7s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum7s4 = sharedPreferences.getString("11.SINIFbölüm7s4yildiz","3");
            if(sinif11bolum7s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum7s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum7s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum7s5 = sharedPreferences.getString("11.SINIFbölüm7s5yildiz","3");
            if(sinif11bolum7s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum7s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum7s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum7s6 = sharedPreferences.getString("11.SINIFbölüm7s6yildiz","3");
            if(sinif11bolum7s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum7s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum7s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='11.SINIFbölüm7'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("11.SINIFbölüm8")){
            String sinif11bolum8s1 = sharedPreferences.getString("11.SINIFbölüm8s1yildiz","3");
            if(sinif11bolum8s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum8s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum8s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum8s2 = sharedPreferences.getString("11.SINIFbölüm8s2yildiz","3");
            if(sinif11bolum8s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum8s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum8s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum8s3 = sharedPreferences.getString("11.SINIFbölüm8s3yildiz","3");
            if(sinif11bolum8s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum8s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum8s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum8s4 = sharedPreferences.getString("11.SINIFbölüm8s4yildiz","3");
            if(sinif11bolum8s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum8s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum8s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum8s5 = sharedPreferences.getString("11.SINIFbölüm8s5yildiz","3");
            if(sinif11bolum8s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum8s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum8s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum8s6 = sharedPreferences.getString("11.SINIFbölüm8s6yildiz","3");
            if(sinif11bolum8s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum8s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum8s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='11.SINIFbölüm8'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("11.SINIFbölüm9")){
            String sinif11bolum9s1 = sharedPreferences.getString("11.SINIFbölüm9s1yildiz","3");
            if(sinif11bolum9s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum9s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum9s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum9s2 = sharedPreferences.getString("11.SINIFbölüm9s2yildiz","3");
            if(sinif11bolum9s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum9s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum9s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum9s3 = sharedPreferences.getString("11.SINIFbölüm9s3yildiz","3");
            if(sinif11bolum9s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum9s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum9s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum9s4 = sharedPreferences.getString("11.SINIFbölüm9s4yildiz","3");
            if(sinif11bolum9s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum9s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum9s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum9s5 = sharedPreferences.getString("11.SINIFbölüm9s5yildiz","3");
            if(sinif11bolum9s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum9s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum9s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum9s6 = sharedPreferences.getString("11.SINIFbölüm9s6yildiz","3");
            if(sinif11bolum9s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum9s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum9s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='11.SINIFbölüm9'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("11.SINIFbölüm10")){
            String sinif11bolum10s1 = sharedPreferences.getString("11.SINIFbölüm10s1yildiz","3");
            if(sinif11bolum10s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum10s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum10s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum10s2 = sharedPreferences.getString("11.SINIFbölüm10s2yildiz","3");
            if(sinif11bolum10s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum10s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum10s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum10s3 = sharedPreferences.getString("11.SINIFbölüm10s3yildiz","3");
            if(sinif11bolum10s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum10s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum10s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum10s4 = sharedPreferences.getString("11.SINIFbölüm10s4yildiz","3");
            if(sinif11bolum10s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum10s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum10s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum10s5 = sharedPreferences.getString("11.SINIFbölüm10s5yildiz","3");
            if(sinif11bolum10s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum10s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum10s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif11bolum10s6 = sharedPreferences.getString("11.SINIFbölüm10s6yildiz","3");
            if(sinif11bolum10s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif11bolum10s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif11bolum10s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='11.SINIFbölüm10'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }
        }if (nerde.contains("12.SINIFbölüm1")){
            String sinif12bolum1s1 = sharedPreferences.getString("12.SINIFbölüm1s1yildiz","3");
            if(sinif12bolum1s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum1s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum1s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum1s2 = sharedPreferences.getString("12.SINIFbölüm1s2yildiz","3");
            if(sinif12bolum1s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum1s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum1s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum1s3 = sharedPreferences.getString("12.SINIFbölüm1s3yildiz","3");
            if(sinif12bolum1s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum1s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum1s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum1s4 = sharedPreferences.getString("12.SINIFbölüm1s4yildiz","3");
            if(sinif12bolum1s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum1s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum1s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum1s5 = sharedPreferences.getString("12.SINIFbölüm1s5yildiz","3");
            if(sinif12bolum1s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum1s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum1s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum1s6= sharedPreferences.getString("12.SINIFbölüm1s6yildiz","3");
            if(sinif12bolum1s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum1s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum1s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='12.SINIFbölüm1'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("12.SINIFbölüm2")){
            String sinif12bolum2s1 = sharedPreferences.getString("12.SINIFbölüm2s1yildiz","3");
            if(sinif12bolum2s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum2s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum2s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum2s2 = sharedPreferences.getString("12.SINIFbölüm2s2yildiz","3");
            if(sinif12bolum2s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum2s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum2s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum2s3 = sharedPreferences.getString("12.SINIFbölüm2s3yildiz","3");
            if(sinif12bolum2s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum2s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum2s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum2s4 = sharedPreferences.getString("12.SINIFbölüm2s4yildiz","3");
            if(sinif12bolum2s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum2s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum2s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum2s5 = sharedPreferences.getString("12.SINIFbölüm2s5yildiz","3");
            if(sinif12bolum2s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum2s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum2s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum2s6 = sharedPreferences.getString("12.SINIFbölüm2s6yildiz","3");
            if(sinif12bolum2s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum2s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum2s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='12.SINIFbölüm2'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("12.SINIFbölüm3")){
            String sinif12bolum3s1 = sharedPreferences.getString("12.SINIFbölüm3s1yildiz","3");
            if(sinif12bolum3s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum3s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum3s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum3s2 = sharedPreferences.getString("12.SINIFbölüm3s2yildiz","3");
            if(sinif12bolum3s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum3s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum3s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum3s3 = sharedPreferences.getString("12.SINIFbölüm3s3yildiz","3");
            if(sinif12bolum3s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum3s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum3s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum3s4 = sharedPreferences.getString("12.SINIFbölüm3s4yildiz","3");
            if(sinif12bolum3s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum3s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum3s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum3s5 = sharedPreferences.getString("12.SINIFbölüm3s5yildiz","3");
            if(sinif12bolum3s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum3s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum3s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum3s6 = sharedPreferences.getString("12.SINIFbölüm3s6yildiz","3");
            if(sinif12bolum3s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum3s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum3s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='12.SINIFbölüm3'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }




        }if (nerde.contains("12.SINIFbölüm4")){
            String sinif12bolum4s1 = sharedPreferences.getString("12.SINIFbölüm4s1yildiz","3");
            if(sinif12bolum4s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum4s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum4s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum4s2 = sharedPreferences.getString("12.SINIFbölüm4s2yildiz","3");
            if(sinif12bolum4s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum4s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum4s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum4s3 = sharedPreferences.getString("12.SINIFbölüm4s3yildiz","3");
            if(sinif12bolum4s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum4s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum4s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum4s4 = sharedPreferences.getString("12.SINIFbölüm4s4yildiz","3");
            if(sinif12bolum4s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum4s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum4s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum4s5 = sharedPreferences.getString("12.SINIFbölüm4s5yildiz","3");
            if(sinif12bolum4s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum4s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum4s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum4s6 = sharedPreferences.getString("12.SINIFbölüm4s6yildiz","3");
            if(sinif12bolum4s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum4s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum4s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='12.SINIFbölüm4'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("12.SINIFbölüm5")){
            String sinif12bolum5s1 = sharedPreferences.getString("12.SINIFbölüm5s1yildiz","3");
            if(sinif12bolum5s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum5s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum5s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum5s2 = sharedPreferences.getString("12.SINIFbölüm5s2yildiz","3");
            if(sinif12bolum5s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum5s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum5s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum5s3 = sharedPreferences.getString("12.SINIFbölüm5s3yildiz","3");
            if(sinif12bolum5s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum5s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum5s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum5s4 = sharedPreferences.getString("12.SINIFbölüm5s4yildiz","3");
            if(sinif12bolum5s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum5s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum5s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum5s5 = sharedPreferences.getString("12.SINIFbölüm5s5yildiz","3");
            if(sinif12bolum5s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum5s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum5s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum5s6 = sharedPreferences.getString("12.SINIFbölüm5s6yildiz","3");
            if(sinif12bolum5s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum5s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum5s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='12.SINIFbölüm5'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("12.SINIFbölüm6")){
            String sinif12bolum6s1 = sharedPreferences.getString("12.SINIFbölüm6s1yildiz","3");
            if(sinif12bolum6s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum6s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum6s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum6s2 = sharedPreferences.getString("12.SINIFbölüm6s2yildiz","3");
            if(sinif12bolum6s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum6s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum6s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum6s3 = sharedPreferences.getString("12.SINIFbölüm6s3yildiz","3");
            if(sinif12bolum6s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum6s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum6s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum6s4 = sharedPreferences.getString("12.SINIFbölüm6s4yildiz","3");
            if(sinif12bolum6s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum6s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum6s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum6s5 = sharedPreferences.getString("12.SINIFbölüm6s5yildiz","3");
            if(sinif12bolum6s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum6s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum6s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum6s6 = sharedPreferences.getString("12.SINIFbölüm6s6yildiz","3");
            if(sinif12bolum6s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum6s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum6s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='12.SINIFbölüm6'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("12.SINIFbölüm7")){
            String sinif12bolum7s1 = sharedPreferences.getString("12.SINIFbölüm7s1yildiz","3");
            if(sinif12bolum7s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum7s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum7s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum7s2 = sharedPreferences.getString("12.SINIFbölüm7s2yildiz","3");
            if(sinif12bolum7s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum7s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum7s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum7s3 = sharedPreferences.getString("12.SINIFbölüm7s3yildiz","3");
            if(sinif12bolum7s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum7s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum7s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum7s4 = sharedPreferences.getString("12.SINIFbölüm7s4yildiz","3");
            if(sinif12bolum7s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum7s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum7s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum7s5 = sharedPreferences.getString("12.SINIFbölüm7s5yildiz","3");
            if(sinif12bolum7s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum7s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum7s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum7s6 = sharedPreferences.getString("12.SINIFbölüm7s6yildiz","3");
            if(sinif12bolum7s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum7s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum7s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='12.SINIFbölüm7'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("12.SINIFbölüm8")){
            String sinif12bolum8s1 = sharedPreferences.getString("12.SINIFbölüm8s1yildiz","3");
            if(sinif12bolum8s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum8s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum8s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum8s2 = sharedPreferences.getString("12.SINIFbölüm8s2yildiz","3");
            if(sinif12bolum8s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum8s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum8s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum8s3 = sharedPreferences.getString("12.SINIFbölüm8s3yildiz","3");
            if(sinif12bolum8s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum8s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum8s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum8s4 = sharedPreferences.getString("12.SINIFbölüm8s4yildiz","3");
            if(sinif12bolum8s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum8s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum8s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum8s5 = sharedPreferences.getString("12.SINIFbölüm8s5yildiz","3");
            if(sinif12bolum8s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum8s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum8s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum8s6 = sharedPreferences.getString("12.SINIFbölüm8s6yildiz","3");
            if(sinif12bolum8s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum8s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum8s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='12.SINIFbölüm8'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("12.SINIFbölüm9")){
            String sinif12bolum9s1 = sharedPreferences.getString("12.SINIFbölüm9s1yildiz","3");
            if(sinif12bolum9s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum9s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum9s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum9s2 = sharedPreferences.getString("12.SINIFbölüm9s2yildiz","3");
            if(sinif12bolum9s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum9s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum9s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum9s3 = sharedPreferences.getString("12.SINIFbölüm9s3yildiz","3");
            if(sinif12bolum9s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum9s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum9s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum9s4 = sharedPreferences.getString("12.SINIFbölüm9s4yildiz","3");
            if(sinif12bolum9s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum9s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum9s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum9s5 = sharedPreferences.getString("12.SINIFbölüm9s5yildiz","3");
            if(sinif12bolum9s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum9s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum9s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum9s6 = sharedPreferences.getString("12.SINIFbölüm9s6yildiz","3");
            if(sinif12bolum9s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum9s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum9s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='12.SINIFbölüm9'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("12.SINIFbölüm10")){
            String sinif12bolum10s1 = sharedPreferences.getString("12.SINIFbölüm10s1yildiz","3");
            if(sinif12bolum10s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum10s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum10s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum10s2 = sharedPreferences.getString("12.SINIFbölüm10s2yildiz","3");
            if(sinif12bolum10s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum10s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum10s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum10s3 = sharedPreferences.getString("12.SINIFbölüm10s3yildiz","3");
            if(sinif12bolum10s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum10s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum10s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum10s4 = sharedPreferences.getString("12.SINIFbölüm10s4yildiz","3");
            if(sinif12bolum10s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum10s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum10s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum10s5 = sharedPreferences.getString("12.SINIFbölüm10s5yildiz","3");
            if(sinif12bolum10s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum10s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum10s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String sinif12bolum10s6 = sharedPreferences.getString("12.SINIFbölüm10s6yildiz","3");
            if(sinif12bolum10s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(sinif12bolum10s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(sinif12bolum10s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='12.SINIFbölüm10'",null);
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