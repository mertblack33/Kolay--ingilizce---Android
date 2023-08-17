package com.mert.kolayingilizce;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mert.kolayingilizce.a1a2.Bolum;
import com.mert.kolayingilizce.b1b2.Bolum2;
import com.mert.kolayingilizce.c1c2.Bolum3;
import com.mert.kolayingilizce.ilkokul.Bolumilkokul;
import com.mert.kolayingilizce.lise.Bolumlise;
import com.mert.kolayingilizce.ortaokul.Bolumortaokul;

import java.util.Objects;

public class Anasayfa extends Fragment implements AdapterView.OnItemSelectedListener {
    String bolum;
    SharedPreferences sharedPreferences;
    RadioButton radioButton,radioButton1;
    int sayi = 0;
    SQLiteDatabase database;
    ArrayAdapter<CharSequence> adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.anasayfa,container,false);
        sharedPreferences = getActivity().getSharedPreferences("com.mert.kolayingilizce", MODE_PRIVATE);
        String sev = sharedPreferences.getString("seviye","Seviye Seçilmedi");
        String para = sharedPreferences.getString("para","0");
        if (para.equals("1")){
            ImageView imageView = viewGroup.findViewById(R.id.imageView15);
            imageView.setImageResource(R.drawable.premium);
        }
        System.out.println(sev);
        TextView textView1 = viewGroup.findViewById(R.id.textView4);
        Spinner spinner = viewGroup.findViewById(R.id.gider);
        switch (sev) {
            case "2.SINIF":
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.sınıf2, android.R.layout.simple_spinner_item);
                textView1.setTextSize(45);
                break;
            case "3.SINIF":
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.sınıf3, android.R.layout.simple_spinner_item);
                textView1.setTextSize(45);
                break;
            case "4.SINIF":
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.sınıf4, android.R.layout.simple_spinner_item);
                textView1.setTextSize(45);
                break;
            case "5.SINIF":
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.sınıf5, android.R.layout.simple_spinner_item);
                textView1.setTextSize(45);
                break;
            case "6.SINIF":
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.sınıf6, android.R.layout.simple_spinner_item);
                textView1.setTextSize(45);
                break;
            case "7.SINIF":
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.sınıf7, android.R.layout.simple_spinner_item);
                textView1.setTextSize(45);
                break;
            case "8.SINIF":
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.sınıf8, android.R.layout.simple_spinner_item);
                textView1.setTextSize(45);
                break;
            case "9.SINIF":
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.sınıf9, android.R.layout.simple_spinner_item);
                textView1.setTextSize(45);
                break;
            case "10.SINIF":
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.sınıf10, android.R.layout.simple_spinner_item);
                textView1.setTextSize(45);
                break;
            case "11.SINIF":
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.sınıf11, android.R.layout.simple_spinner_item);
                textView1.setTextSize(45);
                break;
            case "12.SINIF":
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.sınıf12, android.R.layout.simple_spinner_item);
                textView1.setTextSize(45);
                break;
            default:
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.gidercesiti, android.R.layout.simple_spinner_item);
                textView1.setTextSize(45);
                break;
        }

        adapter.setDropDownViewResource(R.layout.spinner_size);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        TextView textView = viewGroup.findViewById(R.id.textView3);
        TextView textView2 = viewGroup.findViewById(R.id.textView26);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Aclonica-Regular.ttf");
        textView.setTypeface(typeface);
        textView1.setTypeface(typeface);
        textView2.setTypeface(typeface);
        radioButton = viewGroup.findViewById(R.id.radioButton);
        radioButton1 = viewGroup.findViewById(R.id.radioButton1);
        Button button = viewGroup.findViewById(R.id.button7);
        database = getActivity().openOrCreateDatabase("data", MODE_PRIVATE, null);
        Cursor cursor = database.rawQuery("SELECT * FROM P",null);
        int puan = Integer.parseInt(String.valueOf(cursor.getColumnIndex("puan")));
        while (cursor.moveToNext()) {
            textView2.setText("" + cursor.getInt(puan));
        }

        textView1.setText(sev);
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    sharedPreferences.edit().putString("saat","süreli").apply();
                }
            }
        });
        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    sharedPreferences.edit().putString("saat","süresiz").apply();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sev.equals("A1") || sev.equals("A2")) {
                    if (!Objects.equals(bolum, "BÖLÜM SEÇ")) {
                        if (Objects.equals(bolum, "1. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm1").apply();
                            Intent intent = new Intent(getActivity(), Bolum.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "2. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm2").apply();
                            Intent intent = new Intent(getActivity(), Bolum.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "3. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm3").apply();
                            Intent intent = new Intent(getActivity(), Bolum.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "4. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm4").apply();
                            Intent intent = new Intent(getActivity(), Bolum.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "5. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm5").apply();
                            Intent intent = new Intent(getActivity(), Bolum.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "6. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm6").apply();
                            Intent intent = new Intent(getActivity(), Bolum.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "7. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm7").apply();
                            Intent intent = new Intent(getActivity(), Bolum.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "8. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm8").apply();
                            Intent intent = new Intent(getActivity(), Bolum.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "9. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm9").apply();
                            Intent intent = new Intent(getActivity(), Bolum.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "10. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm10").apply();
                            Intent intent = new Intent(getActivity(), Bolum.class);
                            startActivity(intent);
                        }
                    }

                }
                if (sev.equals("B1") || sev.equals("B2")) {
                    if (!Objects.equals(bolum, "BÖLÜM SEÇ")) {
                        if (Objects.equals(bolum, "1. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm1").apply();
                            Intent intent = new Intent(getActivity(), Bolum2.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "2. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm2").apply();
                            Intent intent = new Intent(getActivity(), Bolum2.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "3. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm3").apply();
                            Intent intent = new Intent(getActivity(), Bolum2.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "4. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm4").apply();
                            Intent intent = new Intent(getActivity(), Bolum2.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "5. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm5").apply();
                            Intent intent = new Intent(getActivity(), Bolum2.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "6. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm6").apply();
                            Intent intent = new Intent(getActivity(), Bolum2.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "7. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm7").apply();
                            Intent intent = new Intent(getActivity(), Bolum2.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "8. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm8").apply();
                            Intent intent = new Intent(getActivity(), Bolum2.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "9. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm9").apply();
                            Intent intent = new Intent(getActivity(), Bolum2.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "10. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm10").apply();
                            Intent intent = new Intent(getActivity(), Bolum2.class);
                            startActivity(intent);
                        }
                    }
                }
                if (sev.equals("C1") || sev.equals("C2")) {
                    if (!Objects.equals(bolum, "BÖLÜM SEÇ")) {
                        if (Objects.equals(bolum, "1. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm1").apply();
                            Intent intent = new Intent(getActivity(), Bolum3.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "2. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm2").apply();
                            Intent intent = new Intent(getActivity(), Bolum3.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "3. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm3").apply();
                            Intent intent = new Intent(getActivity(), Bolum3.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "4. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm4").apply();
                            Intent intent = new Intent(getActivity(), Bolum3.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "5. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm5").apply();
                            Intent intent = new Intent(getActivity(), Bolum3.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "6. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm6").apply();
                            Intent intent = new Intent(getActivity(), Bolum3.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "7. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm7").apply();
                            Intent intent = new Intent(getActivity(), Bolum3.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "8. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm8").apply();
                            Intent intent = new Intent(getActivity(), Bolum3.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "9. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm9").apply();
                            Intent intent = new Intent(getActivity(), Bolum3.class);
                            startActivity(intent);
                        }
                        if (Objects.equals(bolum, "10. BÖLÜM")) {
                            sharedPreferences.edit().putString("bölüm", sev + "bölüm10").apply();
                            Intent intent = new Intent(getActivity(), Bolum3.class);
                            startActivity(intent);
                        }
                    }
                }
                    if (sev.equals("2.SINIF") || (sev.equals("3.SINIF") || (sev.equals("4.SINIF")))){
                        if (!Objects.equals(bolum, "ÜNİTE SEÇ")) {
                            if (bolum.contains("1")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm1").apply();
                                Intent intent = new Intent(getActivity(), Bolumilkokul.class);
                                Toast.makeText(getActivity(),sev+"bölüm1",Toast.LENGTH_LONG).show();
                                startActivity(intent);
                            }
                            if (bolum.contains("2")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm2").apply();
                                Intent intent = new Intent(getActivity(), Bolumilkokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("3")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm3").apply();
                                Intent intent = new Intent(getActivity(), Bolumilkokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("4")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm4").apply();
                                Intent intent = new Intent(getActivity(), Bolumilkokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("5")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm5").apply();
                                Intent intent = new Intent(getActivity(), Bolumilkokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("6")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm6").apply();
                                Intent intent = new Intent(getActivity(), Bolumilkokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("7")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm7").apply();
                                Intent intent = new Intent(getActivity(), Bolumilkokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("8")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm8").apply();
                                Intent intent = new Intent(getActivity(), Bolumilkokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("9")){
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm9").apply();
                                Intent intent = new Intent(getActivity(), Bolumilkokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("0")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm10").apply();
                                Intent intent = new Intent(getActivity(), Bolumilkokul.class);
                                startActivity(intent);

                            }

                        }
                    }if (sev.equals("5.SINIF") || (sev.equals("6.SINIF") || (sev.equals("7.SINIF") || (sev.equals("8.SINIF"))))) {
                        if (!Objects.equals(bolum, "ÜNİTE SEÇ")) {
                            if (bolum.contains("1")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm1").apply();
                                Intent intent = new Intent(getActivity(), Bolumortaokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("2")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm2").apply();
                                Intent intent = new Intent(getActivity(), Bolumortaokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("3")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm3").apply();
                                Intent intent = new Intent(getActivity(), Bolumortaokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("4")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm4").apply();
                                Intent intent = new Intent(getActivity(), Bolumortaokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("5")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm5").apply();
                                Intent intent = new Intent(getActivity(), Bolumortaokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("6")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm6").apply();
                                Intent intent = new Intent(getActivity(), Bolumortaokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("7")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm7").apply();
                                Intent intent = new Intent(getActivity(), Bolumortaokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("8")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm8").apply();
                                Intent intent = new Intent(getActivity(), Bolumortaokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("9")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm9").apply();
                                Intent intent = new Intent(getActivity(), Bolumortaokul.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("0")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm10").apply();
                                Intent intent = new Intent(getActivity(), Bolumortaokul.class);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        }
                    }if (sev.equals("9.SINIF") || (sev.equals("10.SINIF") || (sev.equals("11.SINIF") || (sev.equals("12.SINIF"))))) {
                        if (!Objects.equals(bolum, "ÜNİTE SEÇ")) {
                            if (bolum.contains("1")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm1").apply();
                                Intent intent = new Intent(getActivity(), Bolumlise.class);
                                Toast.makeText(getActivity(),sev,Toast.LENGTH_LONG).show();
                                startActivity(intent);

                            }
                            if (bolum.contains("2")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm2").apply();
                                Intent intent = new Intent(getActivity(), Bolumlise.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("3")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm3").apply();
                                Intent intent = new Intent(getActivity(), Bolumlise.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("4")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm4").apply();
                                Intent intent = new Intent(getActivity(), Bolumlise.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("5")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm5").apply();
                                Intent intent = new Intent(getActivity(), Bolumlise.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("6")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm6").apply();
                                Intent intent = new Intent(getActivity(), Bolumlise.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("7")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm7").apply();
                                Intent intent = new Intent(getActivity(), Bolumlise.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("8")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm8").apply();
                                Intent intent = new Intent(getActivity(), Bolumlise.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("9")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm9").apply();
                                Intent intent = new Intent(getActivity(), Bolumlise.class);
                                startActivity(intent);

                            }
                            if (bolum.contains("0")) {
                                sharedPreferences.edit().putString("bölüm", sev + "bölüm10").apply();
                                Intent intent = new Intent(getActivity(), Bolumlise.class);
                                startActivity(intent);

                            }
                        }
                    }
            }

        });
        return viewGroup;
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String sec = sharedPreferences.getString("sec","0");
        ((TextView) view).setTextColor(Color.WHITE);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Aclonica-Regular.ttf");
        ((TextView) view).setTextSize(28);
        ((TextView) view).setTypeface(typeface);
        if (sec.contains("0") || sec.equals("BÖLÜM SEÇ") && sayi ==0){
            adapterView.setSelection(0);
        }if (sec.contains("1")&& sayi ==0){
            adapterView.setSelection(1);
        }if (sec.contains("2")&& sayi ==0){
            adapterView.setSelection(2);
        }if (sec.contains("3")&& sayi ==0){
            adapterView.setSelection(3);
        }if (sec.contains("4")&& sayi ==0){
            adapterView.setSelection(4);
        }if (sec.contains("5")&& sayi ==0){
            adapterView.setSelection(5);
        }if (sec.contains("6")&& sayi ==0){
            adapterView.setSelection(6);
        }if (sec.contains("7")&& sayi ==0){
            adapterView.setSelection(7);
        }if (sec.contains("8")&& sayi ==0){
            adapterView.setSelection(8);
        }if (sec.contains("9")&& sayi ==0){
            adapterView.setSelection(9);
        }if (sec.contains("10")&& sayi ==0){
            adapterView.setSelection(10);
        }
        sayi++;

        bolum = adapterView.getItemAtPosition(i).toString();
        sharedPreferences.edit().putString("sec",bolum).apply();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
