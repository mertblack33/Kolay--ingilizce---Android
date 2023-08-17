package com.mert.kolayingilizce;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Siralama extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.siralama,container,false);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Aclonica-Regular.ttf");
        TextView textView = viewGroup.findViewById(R.id.textView20);
        TextView textView1 = viewGroup.findViewById(R.id.textView19);
        TextView textView2 = viewGroup.findViewById(R.id.textView21);
        TextView textView3 = viewGroup.findViewById(R.id.textView23);
        TextView textView4 = viewGroup.findViewById(R.id.textView24);
        TextView textView5 = viewGroup.findViewById(R.id.textView25);
        TextView textView6 = viewGroup.findViewById(R.id.textView22);
        textView.setTypeface(typeface);
        textView1.setTypeface(typeface);
        textView2.setTypeface(typeface);
        textView3.setTypeface(typeface);
        textView4.setTypeface(typeface);
        textView5.setTypeface(typeface);
        textView6.setTypeface(typeface);
        return viewGroup;
    }
}
