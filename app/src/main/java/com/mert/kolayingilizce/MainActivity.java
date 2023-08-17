package com.mert.kolayingilizce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = this.getSharedPreferences("com.mert.kolayingilizce", Context.MODE_PRIVATE);
        String olusturma = sharedPreferences.getString("tekrar","0");
        database = this.openOrCreateDatabase("data", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS A(bolum VARCHAR,dogru INT,yanlis INT)");
        database.execSQL("CREATE TABLE IF NOT EXISTS P(puan INT)");
        database.execSQL("CREATE TABLE IF NOT EXISTS Reklam(reklam INT)");
        if(olusturma.equals("0")){
                database.execSQL("INSERT INTO P(puan) VALUES (0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A1bölüm1',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A1bölüm2',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A1bölüm3',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A1bölüm4',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A1bölüm5',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A1bölüm6',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A1bölüm7',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A1bölüm8',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A1bölüm9',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A1bölüm10',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A2bölüm1',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A2bölüm2',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A2bölüm3',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A2bölüm4',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A2bölüm5',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A2bölüm6',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A2bölüm7',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A2bölüm8',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A2bölüm9',0,0)");
                database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('A2bölüm10',0,0)");


                /// B1 B2 DATA
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B1bölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B1bölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B1bölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B1bölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B1bölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B1bölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B1bölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B1bölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B1bölüm9',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B1bölüm10',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B2bölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B2bölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B2bölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B2bölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B2bölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B2bölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B2bölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B2bölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B2bölüm9',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('B2bölüm10',0,0)");




            // C1 C2 DATA
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C1bölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C1bölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C1bölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C1bölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C1bölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C1bölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C1bölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C1bölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C1bölüm9',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C1bölüm10',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C2bölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C2bölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C2bölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C2bölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C2bölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C2bölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C2bölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C2bölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C2bölüm9',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('C2bölüm10',0,0)");





            // İLK OKUL DATA

            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('2.SINIFbölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('2.SINIFbölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('2.SINIFbölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('2.SINIFbölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('2.SINIFbölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('2.SINIFbölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('2.SINIFbölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('2.SINIFbölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('2.SINIFbölüm9',0,0)");


            // 3. sınıf

            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('3.SINIFbölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('3.SINIFbölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('3.SINIFbölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('3.SINIFbölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('3.SINIFbölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('3.SINIFbölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('3.SINIFbölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('3.SINIFbölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('3.SINIFbölüm9',0,0)");



            // 4. sınıf

            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('4.SINIFbölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('4.SINIFbölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('4.SINIFbölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('4.SINIFbölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('4.SINIFbölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('4.SINIFbölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('4.SINIFbölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('4.SINIFbölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('4.SINIFbölüm9',0,0)");



            // ORTA OKUL DATA

            // 5. sınıf

            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('5.SINIFbölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('5.SINIFbölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('5.SINIFbölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('5.SINIFbölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('5.SINIFbölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('5.SINIFbölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('5.SINIFbölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('5.SINIFbölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('5.SINIFbölüm9',0,0)");



            // 6. sınıf

            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('6.SINIFbölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('6.SINIFbölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('6.SINIFbölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('6.SINIFbölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('6.SINIFbölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('6.SINIFbölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('6.SINIFbölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('6.SINIFbölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('6.SINIFbölüm9',0,0)");




            // 7. sınıf

            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('7.SINIFbölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('7.SINIFbölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('7.SINIFbölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('7.SINIFbölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('7.SINIFbölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('7.SINIFbölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('7.SINIFbölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('7.SINIFbölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('7.SINIFbölüm9',0,0)");


            // 8. sınıf

            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('8.SINIFbölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('8.SINIFbölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('8.SINIFbölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('8.SINIFbölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('8.SINIFbölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('8.SINIFbölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('8.SINIFbölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('8.SINIFbölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('8.SINIFbölüm9',0,0)");



            // LİSE DATA


            // 9. sınıf

            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('9.SINIFbölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('9.SINIFbölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('9.SINIFbölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('9.SINIFbölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('9.SINIFbölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('9.SINIFbölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('9.SINIFbölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('9.SINIFbölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('9.SINIFbölüm9',0,0)");

            // 10. sınıf

            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('10.SINIFbölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('10.SINIFbölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('10.SINIFbölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('10.SINIFbölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('10.SINIFbölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('10.SINIFbölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('10.SINIFbölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('10.SINIFbölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('10.SINIFbölüm9',0,0)");

            // 11. sınıf

            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('11.SINIFbölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('11.SINIFbölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('11.SINIFbölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('11.SINIFbölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('11.SINIFbölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('11.SINIFbölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('11.SINIFbölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('11.SINIFbölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('11.SINIFbölüm9',0,0)");

            // 12. sınıf

            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('12.SINIFbölüm1',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('12.SINIFbölüm2',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('12.SINIFbölüm3',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('12.SINIFbölüm4',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('12.SINIFbölüm5',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('12.SINIFbölüm6',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('12.SINIFbölüm7',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('12.SINIFbölüm8',0,0)");
            database.execSQL("INSERT INTO A(bolum,dogru,yanlis) VALUES ('12.SINIFbölüm9',0,0)");

            sharedPreferences.edit().putString("tekrar","1").apply();


        }



        new CountDownTimer(2000,1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                String isim = sharedPreferences.getString("isim","i");
                String genel = sharedPreferences.getString("genel","s");
                System.out.println(isim);
                System.out.println(genel);
                if (!isim.equals("i") && genel.equals("genel")){
                    Intent intent = new Intent(MainActivity.this,MainActivity5.class);
                    startActivity(intent);
                    finish();
                } else if (!isim.equals("i")) {
                    Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                    finish();
                }

            }
        }.start();




    }
}