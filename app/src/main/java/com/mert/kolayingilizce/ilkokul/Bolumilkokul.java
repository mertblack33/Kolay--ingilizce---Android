package com.mert.kolayingilizce.ilkokul;

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


public class Bolumilkokul extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    String nerde;
    Button bir, iki, uc, dort;
    SQLiteDatabase database;
    TextView yanlis;
    TextView dogru;
    int s = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolumilkokul);
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
        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/Aclonica-Regular.ttf");
        textView1.setTypeface(typeface);
        textView2.setTypeface(typeface);
        textView3.setTypeface(typeface);
        textView4.setTypeface(typeface);
        nerde = sharedPreferences.getString("bölüm", "noll");
        database = this.openOrCreateDatabase("data", MODE_PRIVATE, null);
        resimsorgu();

        bir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumilkokul.this, Kelimeilkokul.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1", nerde + "s1").apply();
                finish();
            }
        });
        iki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumilkokul.this, Kelimeilkokul.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1", nerde + "s2").apply();
                finish();
            }
        });
        uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumilkokul.this, Kelimeilkokul.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1", nerde + "s3").apply();
                finish();
            }
        });
        dort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bolumilkokul.this, Kelimeilkokul.class);
                startActivity(intent);
                sharedPreferences.edit().putString("seviye1", nerde + "s4").apply();
                finish();
            }
        });
    }


    public void resimsorgu() {
        if (nerde.contains("2.SINIFbölüm1")) {
            String sinif2bolum1s1 = sharedPreferences.getString("2.SINIFbölüm1s1yildiz", "3");
            if (sinif2bolum1s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum1s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum1s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif2bolum1s2 = sharedPreferences.getString("2.SINIFbölüm1s2yildiz", "3");
            if (sinif2bolum1s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum1s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum1s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif2bolum1s3 = sharedPreferences.getString("2.SINIFbölüm1s3yildiz", "3");
            if (sinif2bolum1s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum1s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum1s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }

            dort.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='2.SINIFbölüm1'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("2.SINIFbölüm2")) {
            String sinif2bolum2s1 = sharedPreferences.getString("2.SINIFbölüm2s1yildiz", "3");
            if (sinif2bolum2s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum2s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum2s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif2bolum2s2 = sharedPreferences.getString("2.SINIFbölüm2s2yildiz", "3");
            if (sinif2bolum2s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum2s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum2s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            uc.setVisibility(View.INVISIBLE);


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='2.SINIFbölüm2'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }

        }
        if (nerde.contains("2.SINIFbölüm3")) {
            String sinif2bolum3s1 = sharedPreferences.getString("2.SINIFbölüm3s1yildiz", "3");
            if (sinif2bolum3s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum3s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum3s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif2bolum3s2 = sharedPreferences.getString("2.SINIFbölüm3s2yildiz", "3");
            if (sinif2bolum3s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum3s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum3s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif2bolum3s3 = sharedPreferences.getString("2.SINIFbölüm3s3yildiz", "3");
            if (sinif2bolum3s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum3s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum3s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif2bolum3s4 = sharedPreferences.getString("2.SINIFbölüm3s4yildiz", "3");
            if (sinif2bolum3s4.equals("0")) {
                dort.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum3s4.equals("1")) {
                dort.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum3s4.equals("2")) {
                dort.setBackgroundResource(R.drawable.stars5);
            }


            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='2.SINIFbölüm3'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("2.SINIFbölüm4")) {
            String sinif2bolum4s1 = sharedPreferences.getString("2.SINIFbölüm4s1yildiz", "3");
            if (sinif2bolum4s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum4s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum4s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif2bolum4s2 = sharedPreferences.getString("2.SINIFbölüm4s2yildiz", "3");
            if (sinif2bolum4s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum4s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum4s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            uc.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='2.SINIFbölüm4'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("2.SINIFbölüm5")) {
            String sinif2bolum5s1 = sharedPreferences.getString("2.SINIFbölüm5s1yildiz", "3");
            if (sinif2bolum5s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum5s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum5s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif2bolum5s2 = sharedPreferences.getString("2.SINIFbölüm5s2yildiz", "3");
            if (sinif2bolum5s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum5s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum5s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            uc.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='2.SINIFbölüm5'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }

        }
        if (nerde.contains("2.SINIFbölüm6")) {
            String sinif2bolum6s1 = sharedPreferences.getString("2.SINIFbölüm6s1yildiz", "3");
            if (sinif2bolum6s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum6s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum6s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif2bolum6s2 = sharedPreferences.getString("2.SINIFbölüm6s2yildiz", "3");
            if (sinif2bolum6s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum6s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum6s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            uc.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='2.SINIFbölüm6'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("2.SINIFbölüm7")) {
            String sinif2bolum7s1 = sharedPreferences.getString("2.SINIFbölüm7s1yildiz", "3");
            if (sinif2bolum7s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum7s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum7s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif2bolum7s2 = sharedPreferences.getString("2.SINIFbölüm7s2yildiz", "3");
            if (sinif2bolum7s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum7s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum7s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            uc.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='2.SINIFbölüm7'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }
        }
        if (nerde.contains("2.SINIFbölüm8")) {
            String sinif2bolum8s1 = sharedPreferences.getString("2.SINIFbölüm8s1yildiz", "3");
            if (sinif2bolum8s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum8s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum8s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif2bolum8s2 = sharedPreferences.getString("2.SINIFbölüm8s2yildiz", "3");
            if (sinif2bolum8s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum8s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum8s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            uc.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='2.SINIFbölüm8'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("2.SINIFbölüm9")) {
            String sinif2bolum9s1 = sharedPreferences.getString("2.SINIFbölüm9s1yildiz", "3");
            if (sinif2bolum9s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum9s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum9s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif2bolum9s2 = sharedPreferences.getString("2.SINIFbölüm9s2yildiz", "3");
            if (sinif2bolum9s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum9s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum9s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif2bolum9s3 = sharedPreferences.getString("2.SINIFbölüm9s3yildiz", "3");
            if (sinif2bolum9s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum9s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum9s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='2.SINIFbölüm9'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }
        }
        if (nerde.contains("2.SINIFbölüm10")) {
            String sinif2bolum10s1 = sharedPreferences.getString("2.SINIFbölüm10s1yildiz", "3");
            if (sinif2bolum10s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum10s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum10s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif2bolum10s2 = sharedPreferences.getString("2.SINIFbölüm10s2yildiz", "3");
            if (sinif2bolum10s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif2bolum10s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif2bolum10s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            uc.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='2.SINIFbölüm10'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("3.SINIFbölüm1")) {
            String sinif3bolum1s1 = sharedPreferences.getString("3.SINIFbölüm1s1yildiz", "3");
            if (sinif3bolum1s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum1s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum1s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum1s2 = sharedPreferences.getString("3.SINIFbölüm1s2yildiz", "3");
            if (sinif3bolum1s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum1s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum1s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum1s3 = sharedPreferences.getString("3.SINIFbölüm1s3yildiz", "3");
            if (sinif3bolum1s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum1s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum1s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum1s4 = sharedPreferences.getString("3.SINIFbölüm1s4yildiz", "3");
            if (sinif3bolum1s4.equals("0")) {
                dort.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum1s4.equals("1")) {
                dort.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum1s4.equals("2")) {
                dort.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='3.SINIFbölüm1'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }
        }
        if (nerde.contains("3.SINIFbölüm2")) {
            String sinif3bolum2s1 = sharedPreferences.getString("3.SINIFbölüm2s1yildiz", "3");
            if (sinif3bolum2s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum2s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum2s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum2s2 = sharedPreferences.getString("3.SINIFbölüm2s2yildiz", "3");
            if (sinif3bolum2s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum2s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum2s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum2s3 = sharedPreferences.getString("3.SINIFbölüm2s3yildiz", "3");
            if (sinif3bolum2s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum2s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum2s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum2s4 = sharedPreferences.getString("3.SINIFbölüm2s4yildiz", "3");
            if (sinif3bolum2s4.equals("0")) {
                dort.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum2s4.equals("1")) {
                dort.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum2s4.equals("2")) {
                dort.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='3.SINIFbölüm2'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("3.SINIFbölüm3")) {
            String sinif3bolum3s1 = sharedPreferences.getString("3.SINIFbölüm3s1yildiz", "3");
            if (sinif3bolum3s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum3s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum3s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum3s2 = sharedPreferences.getString("3.SINIFbölüm3s2yildiz", "3");
            if (sinif3bolum3s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum3s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum3s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum3s3 = sharedPreferences.getString("3.SINIFbölüm3s3yildiz", "3");
            if (sinif3bolum3s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum3s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum3s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='3.SINIFbölüm3'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("3.SINIFbölüm4")) {
            String sinif3bolum4s1 = sharedPreferences.getString("3.SINIFbölüm4s1yildiz", "3");
            if (sinif3bolum4s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum4s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum4s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum4s2 = sharedPreferences.getString("3.SINIFbölüm4s2yildiz", "3");
            if (sinif3bolum4s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum4s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum4s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            uc.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='3.SINIFbölüm4'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("3.SINIFbölüm5")) {
            String sinif3bolum5s1 = sharedPreferences.getString("3.SINIFbölüm5s1yildiz", "3");
            if (sinif3bolum5s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum5s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum5s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum5s2 = sharedPreferences.getString("3.SINIFbölüm5s2yildiz", "3");
            if (sinif3bolum5s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum5s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum5s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            uc.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='3.SINIFbölüm5'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("3.SINIFbölüm6")) {
            String sinif3bolum6s1 = sharedPreferences.getString("3.SINIFbölüm6s1yildiz", "3");
            if (sinif3bolum6s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum6s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum6s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum6s2 = sharedPreferences.getString("3.SINIFbölüm6s2yildiz", "3");
            if (sinif3bolum6s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum6s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum6s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum6s3 = sharedPreferences.getString("3.SINIFbölüm6s3yildiz", "3");
            if (sinif3bolum6s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum6s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum6s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='3.SINIFbölüm6'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("3.SINIFbölüm7")) {
            String sinif3bolum7s1 = sharedPreferences.getString("3.SINIFbölüm7s1yildiz", "3");
            if (sinif3bolum7s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum7s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum7s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum7s2 = sharedPreferences.getString("3.SINIFbölüm7s2yildiz", "3");
            if (sinif3bolum7s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum7s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum7s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum7s3 = sharedPreferences.getString("3.SINIFbölüm7s3yildiz", "3");
            if (sinif3bolum7s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum7s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum7s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            uc.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='3.SINIFbölüm7'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("3.SINIFbölüm8")) {
            String sinif3bolum8s1 = sharedPreferences.getString("3.SINIFbölüm8s1yildiz", "3");
            if (sinif3bolum8s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum8s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum8s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum8s2 = sharedPreferences.getString("3.SINIFbölüm8s2yildiz", "3");
            if (sinif3bolum8s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum8s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum8s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum8s3 = sharedPreferences.getString("3.SINIFbölüm8s3yildiz", "3");
            if (sinif3bolum8s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum8s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum8s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum8s4 = sharedPreferences.getString("3.SINIFbölüm8s4yildiz", "3");
            if (sinif3bolum8s4.equals("0")) {
                dort.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum8s4.equals("1")) {
                dort.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum8s4.equals("2")) {
                dort.setBackgroundResource(R.drawable.stars5);
            }

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='3.SINIFbölüm8'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("3.SINIFbölüm9")) {
            String sinif3bolum9s1 = sharedPreferences.getString("3.SINIFbölüm9s1yildiz", "3");
            if (sinif3bolum9s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum9s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum9s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum9s2 = sharedPreferences.getString("3.SINIFbölüm9s2yildiz", "3");
            if (sinif3bolum9s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum9s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum9s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum9s3 = sharedPreferences.getString("3.SINIFbölüm9s3yildiz", "3");
            if (sinif3bolum9s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum9s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum9s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='3.SINIFbölüm9'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("3.SINIFbölüm10")) {
            String sinif3bolum10s1 = sharedPreferences.getString("3.SINIFbölüm10s1yildiz", "3");
            if (sinif3bolum10s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum10s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum10s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum10s2 = sharedPreferences.getString("3.SINIFbölüm10s2yildiz", "3");
            if (sinif3bolum10s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum10s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum10s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif3bolum10s3 = sharedPreferences.getString("3.SINIFbölüm10s3yildiz", "3");
            if (sinif3bolum10s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif3bolum10s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif3bolum10s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='3.SINIFbölüm10'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }
        }
        if (nerde.contains("4.SINIFbölüm1")) {
            String sinif4bolum1s1 = sharedPreferences.getString("4.SINIFbölüm1s1yildiz", "3");
            if (sinif4bolum1s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum1s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum1s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum1s2 = sharedPreferences.getString("4.SINIFbölüm1s2yildiz", "3");
            if (sinif4bolum1s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum1s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum1s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum1s3 = sharedPreferences.getString("4.SINIFbölüm1s3yildiz", "3");
            if (sinif4bolum1s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum1s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum1s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='4.SINIFbölüm1'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("4.SINIFbölüm2")) {
            String sinif4bolum2s1 = sharedPreferences.getString("4.SINIFbölüm2s1yildiz", "3");
            if (sinif4bolum2s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum2s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum2s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum2s2 = sharedPreferences.getString("4.SINIFbölüm2s2yildiz", "3");
            if (sinif4bolum2s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum2s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum2s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum2s3 = sharedPreferences.getString("4.SINIFbölüm2s3yildiz", "3");
            if (sinif4bolum2s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum2s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum2s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='4.SINIFbölüm2'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("4.SINIFbölüm3")) {
            String sinif4bolum3s1 = sharedPreferences.getString("4.SINIFbölüm3s1yildiz", "3");
            if (sinif4bolum3s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum3s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum3s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum3s2 = sharedPreferences.getString("4.SINIFbölüm3s2yildiz", "3");
            if (sinif4bolum3s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum3s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum3s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum3s3 = sharedPreferences.getString("4.SINIFbölüm3s3yildiz", "3");
            if (sinif4bolum3s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum3s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum3s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='4.SINIFbölüm3'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("4.SINIFbölüm4")) {
            String sinif4bolum4s1 = sharedPreferences.getString("4.SINIFbölüm4s1yildiz", "3");
            if (sinif4bolum4s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum4s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum4s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum4s2 = sharedPreferences.getString("4.SINIFbölüm4s2yildiz", "3");
            if (sinif4bolum4s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum4s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum4s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum4s3 = sharedPreferences.getString("4.SINIFbölüm4s3yildiz", "3");
            if (sinif4bolum4s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum4s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum4s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='4.SINIFbölüm4'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("4.SINIFbölüm5")) {
            String sinif4bolum5s1 = sharedPreferences.getString("4.SINIFbölüm5s1yildiz", "3");
            if (sinif4bolum5s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum5s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum5s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum5s2 = sharedPreferences.getString("4.SINIFbölüm5s2yildiz", "3");
            if (sinif4bolum5s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum5s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum5s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum5s3 = sharedPreferences.getString("4.SINIFbölüm5s3yildiz", "3");
            if (sinif4bolum5s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum5s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum5s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);

            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='4.SINIFbölüm5'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("4.SINIFbölüm6")) {
            String sinif4bolum6s1 = sharedPreferences.getString("4.SINIFbölüm6s1yildiz", "3");
            if (sinif4bolum6s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum6s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum6s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum6s2 = sharedPreferences.getString("4.SINIFbölüm6s2yildiz", "3");
            if (sinif4bolum6s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum6s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum6s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum6s3 = sharedPreferences.getString("4.SINIFbölüm6s3yildiz", "3");
            if (sinif4bolum6s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum6s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum6s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }

            dort.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='4.SINIFbölüm6'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("4.SINIFbölüm7")) {
            String sinif4bolum7s1 = sharedPreferences.getString("4.SINIFbölüm7s1yildiz", "3");
            if (sinif4bolum7s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum7s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum7s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum7s2 = sharedPreferences.getString("4.SINIFbölüm7s2yildiz", "3");
            if (sinif4bolum7s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum7s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum7s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum7s3 = sharedPreferences.getString("4.SINIFbölüm7s3yildiz", "3");
            if (sinif4bolum7s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum7s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum7s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='4.SINIFbölüm7'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("4.SINIFbölüm8")) {
            String sinif4bolum8s1 = sharedPreferences.getString("4.SINIFbölüm8s1yildiz", "3");
            if (sinif4bolum8s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum8s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum8s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum8s2 = sharedPreferences.getString("4.SINIFbölüm8s2yildiz", "3");
            if (sinif4bolum8s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum8s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum8s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum8s3 = sharedPreferences.getString("4.SINIFbölüm8s3yildiz", "3");
            if (sinif4bolum8s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum8s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum8s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='4.SINIFbölüm8'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("4.SINIFbölüm9")) {
            String sinif4bolum9s1 = sharedPreferences.getString("4.SINIFbölüm9s1yildiz", "3");
            if (sinif4bolum9s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum9s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum9s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum9s2 = sharedPreferences.getString("4.SINIFbölüm9s2yildiz", "3");
            if (sinif4bolum9s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum9s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum9s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            uc.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='4.SINIFbölüm9'", null);
            int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
            int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
            while (cursor.moveToNext()) {
                dogru.setText("" + cursor.getInt(sayi));
                yanlis.setText("" + cursor.getInt(sayi1));
            }


        }
        if (nerde.contains("4.SINIFbölüm10")) {
            String sinif4bolum10s1 = sharedPreferences.getString("4.SINIFbölüm10s1yildiz", "3");
            if (sinif4bolum10s1.equals("0")) {
                bir.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum10s1.equals("1")) {
                bir.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum10s1.equals("2")) {
                bir.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum10s2 = sharedPreferences.getString("4.SINIFbölüm10s2yildiz", "3");
            if (sinif4bolum10s2.equals("0")) {
                iki.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum10s2.equals("1")) {
                iki.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum10s2.equals("2")) {
                iki.setBackgroundResource(R.drawable.stars5);
            }
            String sinif4bolum10s3 = sharedPreferences.getString("4.SINIFbölüm10s3yildiz", "3");
            if (sinif4bolum10s3.equals("0")) {
                uc.setBackgroundResource(R.drawable.star1);
            }
            if (sinif4bolum10s3.equals("1")) {
                uc.setBackgroundResource(R.drawable.stars2);
            }
            if (sinif4bolum10s3.equals("2")) {
                uc.setBackgroundResource(R.drawable.stars5);
            }
            dort.setVisibility(View.INVISIBLE);
            Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='4.SINIFbölüm10'", null);
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