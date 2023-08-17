package com.mert.kolayingilizce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity5 extends AppCompatActivity {

    private MeowBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.show(1,true);
        replace(new Anasayfa());

        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.baseline_person_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.baseline_interests_24));


        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        replace(new Anasayfa());
                        break;
                    case 2:
                        replace(new Profil());
                        break;
                    case 3:
                        replace(new Siralama());
                        break;
                }
                return null;
            }

        });

    bottomNavigation.setOnReselectListener(new Function1<MeowBottomNavigation.Model, Unit>() {
        @Override
        public Unit invoke(MeowBottomNavigation.Model model) {
            Toast.makeText(MainActivity5.this, "Hata Oluştu", Toast.LENGTH_SHORT).show();
            return null;
        }
    });
    }
            private void replace(Fragment fragment) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame,fragment);
                fragmentTransaction.commit();

            }


}