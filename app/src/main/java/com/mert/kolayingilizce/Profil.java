package com.mert.kolayingilizce;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class Profil extends Fragment implements AdapterView.OnItemSelectedListener{
    SharedPreferences sharedPreferences;
    String seviyesec;
    ArrayAdapter<CharSequence> adapter;
    int sayi =0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.profil,container,false);
        Spinner spinner = viewGroup.findViewById(R.id.gider2);
        sharedPreferences = getActivity().getSharedPreferences("com.mert.kolayingilizce", Context.MODE_PRIVATE);
        String sev = sharedPreferences.getString("seviye","Seviye Seçilmedi");
        switch (sev) {
            case "2.SINIF":
            case "3.SINIF":
            case "4.SINIF":
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.seviyeilkokul, android.R.layout.simple_spinner_item);
                break;
            case "5.SINIF":
            case "6.SINIF":
            case "7.SINIF":
            case "8.SINIF":
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.seviyeortaokul, android.R.layout.simple_spinner_item);
                break;
            case "9.SINIF":
            case "10.SINIF":
            case "11.SINIF":
            case "12.SINIF":
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.seviyelise, android.R.layout.simple_spinner_item);
                break;
            default:
                adapter = ArrayAdapter.createFromResource(getActivity(),
                        R.array.seviyegenel, android.R.layout.simple_spinner_item);
                break;
        }
        adapter.setDropDownViewResource(R.layout.spinner_size);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Aclonica-Regular.ttf");
        TextView textView = viewGroup.findViewById(R.id.textView10);
        TextView textView1 = viewGroup.findViewById(R.id.textView5);
        TextView textView2 = viewGroup.findViewById(R.id.textView15);
        TextView textView3 = viewGroup.findViewById(R.id.textView17);
        TextView textView4 = viewGroup.findViewById(R.id.textView16);
        EditText editText = viewGroup.findViewById(R.id.isim2);
        Button button = viewGroup.findViewById(R.id.button9);
        textView.setTypeface(typeface);
        textView1.setTypeface(typeface);
        textView2.setTypeface(typeface);
        textView3.setTypeface(typeface);
        textView4.setTypeface(typeface);
        editText.setTypeface(typeface);
        button.setTypeface(typeface);
        Button button1 = viewGroup.findViewById(R.id.button27);
        button1.setTypeface(typeface);
        String isim = sharedPreferences.getString("isim","Lütfen İsim Giriniz");
        String id = sharedPreferences.getString("id","Oluşturma Başarız");
        textView4.setText(id);
        editText.setText(isim);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MainActivity3.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String is = editText.getText().toString();
                if (!Objects.equals(seviyesec, "SEVİYE SEÇ") || !Objects.equals(seviyesec, "SINIF SEÇ")){
                    sharedPreferences.edit().putString("isim",is).apply();
                    sharedPreferences.edit().putString("seviye",seviyesec).apply();
                    Toast.makeText(getActivity(),"Kayıt Başarılı.",Toast.LENGTH_LONG).show();
                }else {
                    sharedPreferences.edit().putString("isim",is).apply();
                    Toast.makeText(getActivity(),"Kayıt Başarılı.",Toast.LENGTH_LONG).show();
                }
            }
        });





        return viewGroup;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String sec = sharedPreferences.getString("seviye","0");
        ((TextView) view).setTextColor(Color.WHITE);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Aclonica-Regular.ttf");
        ((TextView) view).setTextSize(28);
        ((TextView) view).setTypeface(typeface);
        if (sayi == 0) {
            switch (sec) {
                case "0":
                case "BÖLÜM SEÇ":
                case "SINIF SEÇ":
                    adapterView.setSelection(0);
                    break;
                case "A1":
                case "2.SINIF":
                case "5.SINIF":
                case "9.SINIF":
                    adapterView.setSelection(1);
                    break;
                case "A2":
                case "6.SINIF":
                case "3.SINIF":
                case "10.SINIF":
                    adapterView.setSelection(2);
                    break;
                case "B1":
                case "7.SINIF":
                case "11.SINIF":
                case "4.SINIF":
                    adapterView.setSelection(3);
                    break;
                case "B2":
                case "8.SINIF":
                case "12.SINIF":
                    adapterView.setSelection(4);
                    break;
                case "C1":
                    adapterView.setSelection(5);
                    break;
                case "C2":
                    adapterView.setSelection(6);
                    break;
            }
        }

        sayi++;
        System.out.println(sayi);
        seviyesec = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
