package com.mert.kolayingilizce.c1c2;

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

public class Bolum3 extends AppCompatActivity {

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
                Intent intent = new Intent(Bolum3.this, kelime3.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s1").apply();
                finish();
            }
        });
        iki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolum3.this,kelime3.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s2").apply();
                finish();
            }
        });
        uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolum3.this,kelime3.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s3").apply();
                finish();
            }
        });
        dort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolum3.this,kelime3.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s4").apply();
                finish();
            }
        });
        bes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolum3.this,kelime3.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s5").apply();
                finish();
            }
        });
        alti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolum3.this,kelime3.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1",nerde+"s6").apply();
                finish();
            }
        });
    }


    public void resimsorgu(){
        if (nerde.contains("C1bölüm1")){
            String C1bolum1s1 = sharedPreferences.getString("C1bölüm1s1yildiz","3");
            if(C1bolum1s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C1bolum1s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum1s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum1s2 = sharedPreferences.getString("C1bölüm1s2yildiz","3");
            if(C1bolum1s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C1bolum1s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum1s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum1s3 = sharedPreferences.getString("C1bölüm1s3yildiz","3");
            if(C1bolum1s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C1bolum1s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum1s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum1s4 = sharedPreferences.getString("C1bölüm1s4yildiz","3");
            if(C1bolum1s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C1bolum1s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum1s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum1s5 = sharedPreferences.getString("C1bölüm1s5yildiz","3");
            if(C1bolum1s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C1bolum1s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum1s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum1s6= sharedPreferences.getString("C1bölüm1s6yildiz","3");
            if(C1bolum1s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C1bolum1s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum1s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C1bölüm1'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }




        }if (nerde.contains("C1bölüm2")){
            String C1bolum2s1 = sharedPreferences.getString("C1bölüm2s1yildiz","3");
            if(C1bolum2s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C1bolum2s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum2s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum2s2 = sharedPreferences.getString("C1bölüm2s2yildiz","3");
            if(C1bolum2s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C1bolum2s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum2s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum2s3 = sharedPreferences.getString("C1bölüm2s3yildiz","3");
            if(C1bolum2s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C1bolum2s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum2s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum2s4 = sharedPreferences.getString("C1bölüm2s4yildiz","3");
            if(C1bolum2s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C1bolum2s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum2s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum2s5 = sharedPreferences.getString("C1bölüm2s5yildiz","3");
            if(C1bolum2s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C1bolum2s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum2s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum2s6 = sharedPreferences.getString("C1bölüm2s6yildiz","3");
            if(C1bolum2s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C1bolum2s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum2s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C1bölüm2'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }

        }if (nerde.contains("C1bölüm3")){
            String C1bolum3s1 = sharedPreferences.getString("C1bölüm3s1yildiz","3");
            if(C1bolum3s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C1bolum3s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum3s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum3s2 = sharedPreferences.getString("C1bölüm3s2yildiz","3");
            if(C1bolum3s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C1bolum3s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum3s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum3s3 = sharedPreferences.getString("C1bölüm3s3yildiz","3");
            if(C1bolum3s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C1bolum3s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum3s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum3s4 = sharedPreferences.getString("C1bölüm3s4yildiz","3");
            if(C1bolum3s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C1bolum3s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum3s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum3s5 = sharedPreferences.getString("C1bölüm3s5yildiz","3");
            if(C1bolum3s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C1bolum3s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum3s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum3s6 = sharedPreferences.getString("C1bölüm3s6yildiz","3");
            if(C1bolum3s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C1bolum3s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum3s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C1bölüm3'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("C1bölüm4")){
            String C1bolum4s1 = sharedPreferences.getString("C1bölüm4s1yildiz","3");
            if(C1bolum4s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C1bolum4s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum4s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum4s2 = sharedPreferences.getString("C1bölüm4s2yildiz","3");
            if(C1bolum4s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C1bolum4s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum4s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum4s3 = sharedPreferences.getString("C1bölüm4s3yildiz","3");
            if(C1bolum4s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C1bolum4s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum4s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum4s4 = sharedPreferences.getString("C1bölüm4s4yildiz","3");
            if(C1bolum4s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C1bolum4s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum4s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum4s5 = sharedPreferences.getString("C1bölüm4s5yildiz","3");
            if(C1bolum4s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C1bolum4s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum4s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum4s6 = sharedPreferences.getString("C1bölüm4s6yildiz","3");
            if(C1bolum4s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C1bolum4s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum4s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C1bölüm4'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("C1bölüm5")){
            String C1bolum5s1 = sharedPreferences.getString("C1bölüm5s1yildiz","3");
            if(C1bolum5s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C1bolum5s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum5s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum5s2 = sharedPreferences.getString("C1bölüm5s2yildiz","3");
            if(C1bolum5s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C1bolum5s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum5s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum5s3 = sharedPreferences.getString("C1bölüm5s3yildiz","3");
            if(C1bolum5s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C1bolum5s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum5s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum5s4 = sharedPreferences.getString("C1bölüm5s4yildiz","3");
            if(C1bolum5s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C1bolum5s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum5s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum5s5 = sharedPreferences.getString("C1bölüm5s5yildiz","3");
            if(C1bolum5s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C1bolum5s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum5s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum5s6 = sharedPreferences.getString("C1bölüm5s6yildiz","3");
            if(C1bolum5s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C1bolum5s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum5s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C1bölüm5'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }

        }if (nerde.contains("C1bölüm6")){
            String C1bolum6s1 = sharedPreferences.getString("C1bölüm6s1yildiz","3");
            if(C1bolum6s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C1bolum6s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum6s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum6s2 = sharedPreferences.getString("C1bölüm6s2yildiz","3");
            if(C1bolum6s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C1bolum6s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum6s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum6s3 = sharedPreferences.getString("C1bölüm6s3yildiz","3");
            if(C1bolum6s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C1bolum6s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum6s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum6s4 = sharedPreferences.getString("C1bölüm6s4yildiz","3");
            if(C1bolum6s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C1bolum6s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum6s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum6s5 = sharedPreferences.getString("C1bölüm6s5yildiz","3");
            if(C1bolum6s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C1bolum6s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum6s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum6s6 = sharedPreferences.getString("C1bölüm6s6yildiz","3");
            if(C1bolum6s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C1bolum6s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum6s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C1bölüm6'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("C1bölüm7")){
            String C1bolum7s1 = sharedPreferences.getString("C1bölüm7s1yildiz","3");
            if(C1bolum7s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C1bolum7s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum7s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum7s2 = sharedPreferences.getString("C1bölüm7s2yildiz","3");
            if(C1bolum7s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C1bolum7s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum7s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum7s3 = sharedPreferences.getString("C1bölüm7s3yildiz","3");
            if(C1bolum7s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C1bolum7s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum7s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum7s4 = sharedPreferences.getString("C1bölüm7s4yildiz","3");
            if(C1bolum7s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C1bolum7s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum7s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum7s5 = sharedPreferences.getString("C1bölüm7s5yildiz","3");
            if(C1bolum7s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C1bolum7s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum7s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum7s6 = sharedPreferences.getString("C1bölüm7s6yildiz","3");
            if(C1bolum7s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C1bolum7s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum7s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C1bölüm7'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }
        }if (nerde.contains("C1bölüm8")){
            String C1bolum8s1 = sharedPreferences.getString("C1bölüm8s1yildiz","3");
            if(C1bolum8s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C1bolum8s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum8s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum8s2 = sharedPreferences.getString("C1bölüm8s2yildiz","3");
            if(C1bolum8s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C1bolum8s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum8s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum8s3 = sharedPreferences.getString("C1bölüm8s3yildiz","3");
            if(C1bolum8s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C1bolum8s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum8s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum8s4 = sharedPreferences.getString("C1bölüm8s4yildiz","3");
            if(C1bolum8s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C1bolum8s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum8s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum8s5 = sharedPreferences.getString("C1bölüm8s5yildiz","3");
            if(C1bolum8s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C1bolum8s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum8s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum8s6 = sharedPreferences.getString("C1bölüm8s6yildiz","3");
            if(C1bolum8s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C1bolum8s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum8s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C1bölüm8'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("C1bölüm9")){
            String C1bolum9s1 = sharedPreferences.getString("C1bölüm9s1yildiz","3");
            if(C1bolum9s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C1bolum9s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum9s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum9s2 = sharedPreferences.getString("C1bölüm9s2yildiz","3");
            if(C1bolum9s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C1bolum9s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum9s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum9s3 = sharedPreferences.getString("C1bölüm9s3yildiz","3");
            if(C1bolum9s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C1bolum9s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum9s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum9s4 = sharedPreferences.getString("C1bölüm9s4yildiz","3");
            if(C1bolum9s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C1bolum9s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum9s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum9s5 = sharedPreferences.getString("C1bölüm9s5yildiz","3");
            if(C1bolum9s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C1bolum9s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum9s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum9s6 = sharedPreferences.getString("C1bölüm9s6yildiz","3");
            if(C1bolum9s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C1bolum9s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum9s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C1bölüm9'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }
        }if (nerde.contains("C1bölüm10")){
            String C1bolum10s1 = sharedPreferences.getString("C1bölüm10s1yildiz","3");
            if(C1bolum10s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C1bolum10s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum10s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum10s2 = sharedPreferences.getString("C1bölüm10s2yildiz","3");
            if(C1bolum10s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C1bolum10s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum10s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum10s3 = sharedPreferences.getString("C1bölüm10s3yildiz","3");
            if(C1bolum10s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C1bolum10s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum10s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum10s4 = sharedPreferences.getString("C1bölüm10s4yildiz","3");
            if(C1bolum10s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C1bolum10s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum10s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum10s5 = sharedPreferences.getString("C1bölüm10s5yildiz","3");
            if(C1bolum10s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C1bolum10s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum10s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C1bolum10s6 = sharedPreferences.getString("C1bölüm10s6yildiz","3");
            if(C1bolum10s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C1bolum10s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C1bolum10s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }




            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C1bölüm10'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }




        }if (nerde.contains("C2bölüm1")){
            String C2bolum1s1 = sharedPreferences.getString("C2bölüm1s1yildiz","3");
            if(C2bolum1s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C2bolum1s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum1s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum1s2 = sharedPreferences.getString("C2bölüm1s2yildiz","3");
            if(C2bolum1s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C2bolum1s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum1s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum1s3 = sharedPreferences.getString("C2bölüm1s3yildiz","3");
            if(C2bolum1s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C2bolum1s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum1s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum1s4 = sharedPreferences.getString("C2bölüm1s4yildiz","3");
            if(C2bolum1s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C2bolum1s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum1s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum1s5 = sharedPreferences.getString("C2bölüm1s5yildiz","3");
            if(C2bolum1s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C2bolum1s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum1s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum1s6= sharedPreferences.getString("C2bölüm1s6yildiz","3");
            if(C2bolum1s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C2bolum1s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum1s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C2bölüm1'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("C2bölüm2")){
            String C2bolum2s1 = sharedPreferences.getString("C2bölüm2s1yildiz","3");
            if(C2bolum2s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C2bolum2s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum2s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum2s2 = sharedPreferences.getString("C2bölüm2s2yildiz","3");
            if(C2bolum2s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C2bolum2s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum2s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum2s3 = sharedPreferences.getString("C2bölüm2s3yildiz","3");
            if(C2bolum2s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C2bolum2s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum2s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum2s4 = sharedPreferences.getString("C2bölüm2s4yildiz","3");
            if(C2bolum2s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C2bolum2s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum2s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum2s5 = sharedPreferences.getString("C2bölüm2s5yildiz","3");
            if(C2bolum2s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C2bolum2s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum2s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum2s6 = sharedPreferences.getString("C2bölüm2s6yildiz","3");
            if(C2bolum2s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C2bolum2s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum2s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C2bölüm2'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("C2bölüm3")){
            String C2bolum3s1 = sharedPreferences.getString("C2bölüm3s1yildiz","3");
            if(C2bolum3s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C2bolum3s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum3s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum3s2 = sharedPreferences.getString("C2bölüm3s2yildiz","3");
            if(C2bolum3s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C2bolum3s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum3s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum3s3 = sharedPreferences.getString("C2bölüm3s3yildiz","3");
            if(C2bolum3s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C2bolum3s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum3s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum3s4 = sharedPreferences.getString("C2bölüm3s4yildiz","3");
            if(C2bolum3s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C2bolum3s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum3s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum3s5 = sharedPreferences.getString("C2bölüm3s5yildiz","3");
            if(C2bolum3s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C2bolum3s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum3s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum3s6 = sharedPreferences.getString("C2bölüm3s6yildiz","3");
            if(C2bolum3s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C2bolum3s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum3s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C2bölüm3'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }




        }if (nerde.contains("C2bölüm4")){
            String C2bolum4s1 = sharedPreferences.getString("C2bölüm4s1yildiz","3");
            if(C2bolum4s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C2bolum4s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum4s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum4s2 = sharedPreferences.getString("C2bölüm4s2yildiz","3");
            if(C2bolum4s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C2bolum4s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum4s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum4s3 = sharedPreferences.getString("C2bölüm4s3yildiz","3");
            if(C2bolum4s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C2bolum4s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum4s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum4s4 = sharedPreferences.getString("C2bölüm4s4yildiz","3");
            if(C2bolum4s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C2bolum4s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum4s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum4s5 = sharedPreferences.getString("C2bölüm4s5yildiz","3");
            if(C2bolum4s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C2bolum4s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum4s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum4s6 = sharedPreferences.getString("C2bölüm4s6yildiz","3");
            if(C2bolum4s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C2bolum4s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum4s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C2bölüm4'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("C2bölüm5")){
            String C2bolum5s1 = sharedPreferences.getString("C2bölüm5s1yildiz","3");
            if(C2bolum5s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C2bolum5s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum5s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum5s2 = sharedPreferences.getString("C2bölüm5s2yildiz","3");
            if(C2bolum5s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C2bolum5s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum5s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum5s3 = sharedPreferences.getString("C2bölüm5s3yildiz","3");
            if(C2bolum5s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C2bolum5s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum5s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum5s4 = sharedPreferences.getString("C2bölüm5s4yildiz","3");
            if(C2bolum5s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C2bolum5s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum5s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum5s5 = sharedPreferences.getString("C2bölüm5s5yildiz","3");
            if(C2bolum5s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C2bolum5s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum5s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum5s6 = sharedPreferences.getString("C2bölüm5s6yildiz","3");
            if(C2bolum5s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C2bolum5s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum5s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C2bölüm5'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("C2bölüm6")){
            String C2bolum6s1 = sharedPreferences.getString("C2bölüm6s1yildiz","3");
            if(C2bolum6s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C2bolum6s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum6s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum6s2 = sharedPreferences.getString("C2bölüm6s2yildiz","3");
            if(C2bolum6s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C2bolum6s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum6s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum6s3 = sharedPreferences.getString("C2bölüm6s3yildiz","3");
            if(C2bolum6s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C2bolum6s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum6s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum6s4 = sharedPreferences.getString("C2bölüm6s4yildiz","3");
            if(C2bolum6s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C2bolum6s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum6s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum6s5 = sharedPreferences.getString("C2bölüm6s5yildiz","3");
            if(C2bolum6s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C2bolum6s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum6s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum6s6 = sharedPreferences.getString("C2bölüm6s6yildiz","3");
            if(C2bolum6s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C2bolum6s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum6s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C2bölüm6'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }if (nerde.contains("C2bölüm7")){
            String C2bolum7s1 = sharedPreferences.getString("C2bölüm7s1yildiz","3");
            if(C2bolum7s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C2bolum7s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum7s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum7s2 = sharedPreferences.getString("C2bölüm7s2yildiz","3");
            if(C2bolum7s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C2bolum7s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum7s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum7s3 = sharedPreferences.getString("C2bölüm7s3yildiz","3");
            if(C2bolum7s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C2bolum7s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum7s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum7s4 = sharedPreferences.getString("C2bölüm7s4yildiz","3");
            if(C2bolum7s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C2bolum7s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum7s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum7s5 = sharedPreferences.getString("C2bölüm7s5yildiz","3");
            if(C2bolum7s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C2bolum7s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum7s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum7s6 = sharedPreferences.getString("C2bölüm7s6yildiz","3");
            if(C2bolum7s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C2bolum7s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum7s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C2bölüm7'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("C2bölüm8")){
            String C2bolum8s1 = sharedPreferences.getString("C2bölüm8s1yildiz","3");
            if(C2bolum8s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C2bolum8s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum8s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum8s2 = sharedPreferences.getString("C2bölüm8s2yildiz","3");
            if(C2bolum8s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C2bolum8s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum8s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum8s3 = sharedPreferences.getString("C2bölüm8s3yildiz","3");
            if(C2bolum8s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C2bolum8s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum8s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum8s4 = sharedPreferences.getString("C2bölüm8s4yildiz","3");
            if(C2bolum8s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C2bolum8s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum8s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum8s5 = sharedPreferences.getString("C2bölüm8s5yildiz","3");
            if(C2bolum8s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C2bolum8s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum8s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum8s6 = sharedPreferences.getString("C2bölüm8s6yildiz","3");
            if(C2bolum8s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C2bolum8s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum8s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C2bölüm8'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("C2bölüm9")){
            String C2bolum9s1 = sharedPreferences.getString("C2bölüm9s1yildiz","3");
            if(C2bolum9s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C2bolum9s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum9s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum9s2 = sharedPreferences.getString("C2bölüm9s2yildiz","3");
            if(C2bolum9s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C2bolum9s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum9s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum9s3 = sharedPreferences.getString("C2bölüm9s3yildiz","3");
            if(C2bolum9s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C2bolum9s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum9s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum9s4 = sharedPreferences.getString("C2bölüm9s4yildiz","3");
            if(C2bolum9s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C2bolum9s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum9s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum9s5 = sharedPreferences.getString("C2bölüm9s5yildiz","3");
            if(C2bolum9s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C2bolum9s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum9s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum9s6 = sharedPreferences.getString("C2bölüm9s6yildiz","3");
            if(C2bolum9s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C2bolum9s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum9s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C2bölüm9'",null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }



        }if (nerde.contains("C2bölüm10")){
            String C2bolum10s1 = sharedPreferences.getString("C2bölüm10s1yildiz","3");
            if(C2bolum10s1.equals("0")){
                bir.setBackgroundResource(R.drawable.star1);
            }if(C2bolum10s1.equals("1")){
                bir.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum10s1.equals("2")){
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum10s2 = sharedPreferences.getString("C2bölüm10s2yildiz","3");
            if(C2bolum10s2.equals("0")){
                iki.setBackgroundResource(R.drawable.star1);
            }if(C2bolum10s2.equals("1")){
                iki.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum10s2.equals("2")){
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum10s3 = sharedPreferences.getString("C2bölüm10s3yildiz","3");
            if(C2bolum10s3.equals("0")){
                uc.setBackgroundResource(R.drawable.star1);
            }if(C2bolum10s3.equals("1")){
                uc.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum10s3.equals("2")){
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum10s4 = sharedPreferences.getString("C2bölüm10s4yildiz","3");
            if(C2bolum10s4.equals("0")){
                dort.setBackgroundResource(R.drawable.star1);
            }if(C2bolum10s4.equals("1")){
                dort.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum10s4.equals("2")){
                dort.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum10s5 = sharedPreferences.getString("C2bölüm10s5yildiz","3");
            if(C2bolum10s5.equals("0")){
                bes.setBackgroundResource(R.drawable.star1);
            }if(C2bolum10s5.equals("1")){
                bes.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum10s5.equals("2")){
                bes.setBackgroundResource(R.drawable.stars5);
            }
            String C2bolum10s6 = sharedPreferences.getString("C2bölüm10s6yildiz","3");
            if(C2bolum10s6.equals("0")){
                alti.setBackgroundResource(R.drawable.star1);
            }if(C2bolum10s6.equals("1")){
                alti.setBackgroundResource(R.drawable.stars2);
            }if(C2bolum10s6.equals("2")){
                alti.setBackgroundResource(R.drawable.stars5);
            }
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='C2bölüm10'",null);
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