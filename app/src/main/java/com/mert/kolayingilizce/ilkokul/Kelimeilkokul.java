package com.mert.kolayingilizce.ilkokul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.mert.kolayingilizce.MainActivity5;
import com.mert.kolayingilizce.R;
import com.mert.kolayingilizce.Soru;
import com.mert.kolayingilizce.c1c2.kelime3;
import com.mert.kolayingilizce.ortaokul.Kelimeortaokul;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class Kelimeilkokul extends AppCompatActivity {

    /// İLK OKUL DATASI

    // 2. SINIF
    int i = 0;
    // 1. bölüm
    String [] ilkokul2bolum1s1 = {"Ambulance","Broccoli","Cafeteria","Doctor","Electric","Football","Garage","Helicopter","Italy","Jacket"};
    String [] ilkokul2bolum1s2 = {"Kimono","Lemon","Music","Negative","Oval","Park","Panda","Pizza","Picnic","Quiz"};
    String [] ilkokul2bolum1s3 = {"Robot","Stop","Taxi","Tennis","train","Supermarket","Telephone","University","Veterinarian","Wagoon"};

    String [] ilkokul2bolum1c1 = {"ambulans","brokoli","kafeterya","doktor","elektrik","futbol","garaj","helikopter","İtalya","ceket"};
    String [] ilkokul2bolum1c2 = {"kimono","limon","müzik","negatif","oval","Park","Panda","Pizza","Piknik","sınav"};
    String [] ilkokul2bolum1c3 = {"Robot","durmak","taksi","tenis","tren","süpermarket","telefon","üniversite","veteriner","vagon"};

    // 2 . bölüm

    String [] ilkokul2bolum2s1 = {"Fine","Good afternoon","Good bye","Good evening","Good morning","Good night","Great","Hi","How are you?","I’m fine, thanks"};
    String [] ilkokul2bolum2s2 = {"My name is","Okay","Thank you","What’s your name?","Fine","Good afternoon","Good bye","Good evening","Good morning","Good night"};

    String [] ilkokul2bolum2c1 = {"İyi","tünaydın, iyi öğlenler","hoşçakal","iyi akşamlar","günaydın","iyi geceler","Harika","selam, merhaba","nasılsın?","İyiyim, teşekkürler"};
    String [] ilkokul2bolum2c2 = {"benim adım","Tamam","teşekkürler","adın ne?","İyi","tünaydın, iyi öğlenler","hoşçakal","iyi akşamlar","günaydın","iyi geceler"};

    // 3. bölüm

    String [] ilkokul2bolum3s1 = {"Be quiet","Book","Classroom","Close","Close your book","Colour / paint","Cut","Desk","Door","Draw"};
    String [] ilkokul2bolum3s2 = {"Excuse me","Glue","Notebook","Open","Open the door","Paper","Pencil","Pencilcase","Please","Picture"};
    String [] ilkokul2bolum3s3 = {"Repeat","Rubber","Say","School bag","Sharpener","Sit down","Stand up","Stick","Sorry","Student"};
    String [] ilkokul2bolum3s4 = {"Table","Teacher","Turn","Turn left","Turn right","Window","You are welcome","Be quiet","Book","Classroom"};


    String [] ilkokul2bolum3c1 = {"sessiz ol","Kitap","Sınıf","Kapatmak","kitabını kapat","boyamak","kesmek","Sıra","Kapı","çizmek"};
    String [] ilkokul2bolum3c2 = {"Afedersiniz","Yapıştırıcı","Defter","Açmak","kapıyı aç","Kağıt","Kurşen Kalem","Kalem Kutusu","Lütfen","Resim"};
    String [] ilkokul2bolum3c3 = {"Tekrar etmek","Silgi","Söylemek","Okul Çantası","Kalem traş","otur","kalk","yapıştırmak","Üzgün","Öğrenci"};
    String [] ilkokul2bolum3c4 = {"Masa","Öğretmen","Dönmek","sola dön","sağa dön","Pencere","rica ederim","sessiz ol","Kitap","Sınıf"};

    // 4. bölüm

    String [] ilkokul2bolum4s1 = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    String [] ilkokul2bolum4s2 = {"10","How many?","I’m six years old","I’m seven years old","I’m eight years old","zero","one","two","three","four"};

    String [] ilkokul2bolum4c1 = {"Sıfır","Bir","İki","Üç","Dört","Beş","Altı","Yedi","Sekiz","Dokuz"};
    String [] ilkokul2bolum4c2 = {"On","kaç tane?","altı yaşındayım","yedi yaşındayım","sekiz yaşındayım","Sıfır","Bir","İki","Üç","Dört"};

    // 5. bölüm

    String [] ilkokul2bolum5s1 = {"black","blue","brown","colour","green","like","many","orange","pink","purple"};
    String [] ilkokul2bolum5s2 = {"red","white","who","yellow","black","blue","brown","colour","green","like"};


    String [] ilkokul2bolum5c1 = {"siyah","mavi","kahverengi","renk","yeşil","sevmek","çok","turuncu","pembe","mor"};
    String [] ilkokul2bolum5c2 = {"kırmızı","beyaz","kim","sarı","siyah","mavi","kahverengi","renk","yeşil","sevmek"};

    //6. bölüm


    String [] ilkokul2bolum6s1 = {"bike","dance","hide","hop","hopscotch","kick","Let’s","play","ride","rope"};
    String [] ilkokul2bolum6s2 = {"running","see-saw","skating","skipping rope","sliding","swinging","bike","dance","hide"};


    String [] ilkokul2bolum6c1 = {"bisiklet","dans etmek","saklanmak","hoplamak","sek sek","vurmak","haydi","oynamak","binmek, sürmek","ip"};
    String [] ilkokul2bolum6c2 = {"koşma","tahteravalli","paten kayma","ip atlama","kayma","salıncakta sallanma","bisiklet","dans etmek","saklanmak"};

    // 7. bölüm


    String [] ilkokul2bolum7s1 = {"arms","ear","eyes","feet","fingers","foot","fun","hands","head","hear"};
    String [] ilkokul2bolum7s2 = {"knees","legs","look","mouth","nose","point","raise","shoulders","show","teeth"};

    String [] ilkokul2bolum7c1 = {"kollar","kulak","gözler","ayaklar","el parmakları","ayak","eğlenceli","eller","baş","duymak"};
    String [] ilkokul2bolum7c2 = {"dizler","bacaklar","bakmak","ağız","burun","göstermek, işaret etmek","kaldırmak","omuzlar","göstermek","dişler"};

    // 8. bölüm

    String [] ilkokul2bolum8s1 = {"bed","bird","car","cat","dog","duck","fish","frog","grass","here"};
    String [] ilkokul2bolum8s2 = {"horse","in the tree","monkey","mouse","on the car","parrot","pets","rabbit","tree","where"};


    String [] ilkokul2bolum8c1 = {"yatak","kuş","araba","kedi","köpek","ördek","balık","kurbağa","ot","burada, buraya"};
    String [] ilkokul2bolum8c2 = {"at","ağaçın içinde","maymun","fare","arabanın üstünde","papağan","evcil hayvanlar","tavşan","ağaç","nerede, nereye"};


    // 9. bölüm


    String [] ilkokul2bolum9s1 = {"apple","apricot","banana","broccoli","cake","cheese","cherry","chocolate","fruit juice","grapefruit"};
    String [] ilkokul2bolum9s2 = {"grapes","honey","ice-cream","kiwi","lemon","mango","melon","milk","orange","peach"};
    String [] ilkokul2bolum9s3 = {"pineapple","pizza","plum","sandwich","strawberry","water","watermelon","turtle","under","chocolate"};


    String [] ilkokul2bolum9c1 = {"elma","kayısı","muz","brokoli","kek","peynir","kiraz","çikolata","meyve suyu","greyfurt"};
    String [] ilkokul2bolum9c2 = {"üzüm","bal","dondurma","kivi","limon","mango","kavun","süt","portakal","şeftali"};
    String [] ilkokul2bolum9c3 = {"ananas","pizza","erik","sandviç","çilek","su","karpuz","kamlumbağa","altında","çikolata"};

    // 10. bölüm

    String [] ilkokul2bolum10s1 = {"bird","chicken","cow","crocodile","donkey","duck","elephant","fly","giraffe","goat"};
    String [] ilkokul2bolum10s2 = {"gorilla","hippo","horse","kangaroo","lion","monkey","rabbit","sheep","snake","tiger"};


    String [] ilkokul2bolum10c1 = {"kuş","tavuk","inek","timsah","eşek","ördek","fil","uçmak","zürafa","keçi"};
    String [] ilkokul2bolum10c2 = {"goril","hipopotam","at","kanguru","aslan","maymun","tavşan","koyun","yılan","kaplan"};




    // 3 . SINIF

    // 1. bölüm
    String [] ilkokul3bolum1s1 = {"Hello","Good morning","Good afternoon","Good evening","Good night","Goodby","Have a good weekend","Have a nice day","Hi","How are you?"};
    String [] ilkokul3bolum1s2 = {"I am fine","Welcome","What is your  name?","My name is","Nice to meet you","See you","Spell","Student","Take care","How old are you?"};
    String [] ilkokul3bolum1s3 = {"I am nine years old","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    String [] ilkokul3bolum1s4 =  {"one","two","three","four","five","six","seven","eight","nine","ten"};

    String [] ilkokul3bolum1c1 = {"merhaba","günaydın","tünaydın","iyi akşamlar","iyi geceler","güle güle","iyi hafta sonları","iyi günler","merhaba","nasılsın?"};
    String [] ilkokul3bolum1c2 = {"ben iyiyim","hoşgeldiniz","adın ne?","Benim adım","Tanıştığıma memnun oldum","görüşmek üzere","hecelemek","öğrenci","kendine iyi bak","kaç yaşındasın?"};
    String [] ilkokul3bolum1c3 = {"ben 9 yaşındayım","Onbir","Oniki","Onüç","Ondört","Onbeş","Onaltı","Onyedi","Onsekiz","Ondokuz"};
    String [] ilkokul3bolum1c4 = {"Bir","İki","Üç","Dört","Beş","Altı","Yedi","Sekiz","Dokuz","On"};

    // 2 . bölüm

    String [] ilkokul3bolum2s1 = {"Aunt","Beautiful","Big","Brother","Cousin","Dad","Family","Fast","fat","Father"};
    String [] ilkokul3bolum2s2 = {"Grandfather","Grandma","Grandmother","Grandpa","he","Heavy","I","Mother","Mum","My family"};
    String [] ilkokul3bolum2s3 = {"Old","she","short","Sister","slow","small","Strong","Tall","they","thin"};
    String [] ilkokul3bolum2s4 = {"ugly","Uncle","we","weak","Who is he?","Who is she?","who?","you","young","thin"};

    String [] ilkokul3bolum2c1 = {"teyze hala","güzel","büyük","erkek kardeş","kuzen","baba","aile","hızlı","şişman","baba"};
    String [] ilkokul3bolum2c2 = {"büyükbaba","büyükanne","büyükanne","büyükbaba","o (erkek)","ağırkalın","ben","anne","anne","benim ailem"};
    String [] ilkokul3bolum2c3 = {"yaşlı","o (kadın)","kısa","kız kardeş","yavaş","küçük","güçlü","uzun","onlar","hafif ince"};
    String [] ilkokul3bolum2c4 = {"çirkin","amca dayı","biz","güçsüz","O kim (erkek)","O kim? (kadın)","Kim?","sen, siz","genç","hafif ince"};

    // 3. bölüm


    String [] ilkokul3bolum3s1 = {"big","climb the trees","dance","fast","heavy","high","jump","jump high","old","play basketball"};
    String [] ilkokul3bolum3s2 = {"play tennis","play the guitar","play the piano","play volleyball","read","ride a bike","run fast","short","sing a song","slow"};
    String [] ilkokul3bolum3s3 = {"small","strong","swim","tall","thin","weak","young","ugly","Uncle","we"};

    String [] ilkokul3bolum3c1 = {"büyük","ağaca tırmanmak","dans etmek","hızlı","ağır","yüksek","zıplamak","yükseğe zıplamak","yaşlı","basketbol oynamak"};
    String [] ilkokul3bolum3c2 = {"tenis oynamak","gitar çalmak","piyano çalmak","voleybol oynamak","okumak","bisitlete binmek","hızlı koşmak","kısa","şarkı söylemek","yavaş"};
    String [] ilkokul3bolum3c3 = {"küçük","güçlü","yüzmek","uzun","ince","güçsüz","genç","çirkin","amca dayı","biz"};

    // 4. bölüm

    String [] ilkokul3bolum4s1 = {"angry","bad","bored","cooking","crying","dancing","eating","energetic","good","happy"};
    String [] ilkokul3bolum4s2 = {"playing football","reading a book","riding a bike","sad","shy","singing","sleepy","studying","surprised","swimming"};

    String [] ilkokul3bolum4c1 = {"öfkeli"," kötü","canı sıkılmış","yemek pişirme","ağlama","dans etme","yemek yeme","enerjik","iyi","mutlu"};
    String [] ilkokul3bolum4c2 = {"futbol oynama","kitap okuma","bisiklet sürme","üzüntülü","utangaç","şarkı söyleme","uykulu","ders çalışma","şaşırmış","yüzme"};

    // 5. bölüm

    String [] ilkokul3bolum5s1 = {"ball ","block","board games","building blocks","button","clock","colour","doll","kite","marble"};
    String [] ilkokul3bolum5s2 = {"playing cards","puzzle","round","square","teddy bear","toy box","toy","toy car","toy train","truck"};

    String [] ilkokul3bolum5c1 = {"top","blok","masa oyunları","lego, yapı blokları","düğme","saat","renk","oyuncak bebek","uçurtma","misket"};
    String [] ilkokul3bolum5c2 = {"oyun kartları","bulmaca","yuvarlak"," kare","oyuncak ayı","oyuncak kutusu","oyuncak","oyuncak araba","oyuncak tren","kamyon"};

    //6. bölüm

    String [] ilkokul3bolum6s1 = {"bathroom","beautiful","bed ","bedroom","big","chair","computer game","cooker","cup","cupboard"};
    String [] ilkokul3bolum6s2 = {"doll","garage","home","kettle","kitchen","living room","playroom","room","rug","shampoo"};
    String [] ilkokul3bolum6s3 = {"shower","small","soap","sofa","stairs","table","television","tidy","untidy","wardrobe"};

    String [] ilkokul3bolum6c1 = {"banyo","güzel, hoş","yatak","yatak odası","büyük","sandalye","bilgisayar oyunu","fırın; ocak","fincan","dolap; büfe"};
    String [] ilkokul3bolum6c2 = {"oyuncak bebek","garaj"," ev","çaydanlık; su ısıtıcı","mutfak","oturma odası","oyun odası","oda","kilim; halı"," şampuan"};
    String [] ilkokul3bolum6c3 = {"duş","küçük","sabun","kanepe; sedir","merdiven","masa","televizyon","düzenli, tertipli","düzensiz, tertipsiz","elbise dolabı"};

    // 7. bölüm

    String [] ilkokul3bolum7s1 = {"at home","at school","at the carnival","at the hospital","at the library","at the market","at the museum","at the post office","at the shopping centre","at the zoo"};
    String [] ilkokul3bolum7s2 = {"bank","cafe","campus","carnival","cinema","fire station","hospital","library","market","museum"};
    String [] ilkokul3bolum7s3 = {"park","police station","post office","restaurant","school","shopping centre","zoo","at home","at school","at the carnival"};

    String [] ilkokul3bolum7c1 = {"evde","okulda","karnavalda","hastanede","kütüphanede","çarşıda, pazarda","müzede","postanede","alış veriş merkezinde","hayvanat bahçesinde"};
    String [] ilkokul3bolum7c2 = {"banka","kafe, kafterya","yerleşke, okul alanı","karnaval","sinema","itfaiye","hastane","kütüphane","çarşı, pazar","müze"};
    String [] ilkokul3bolum7c3 = {"park","polis karakolu","postane","lokanta","okul","alış veriş merkezi","hayvanat bahçesi","evde","okulda","karnavalda"};


    // 8. bölüm

    String [] ilkokul3bolum8s1 = {"ambulance","around","beautiful","bike","boat","bus","car","crowded","famous","get to"};
    String [] ilkokul3bolum8s2 = {"ghost","go round","helicopter","holiday","lorry","make a plan","motorcycle","nice","outside","parents"};
    String [] ilkokul3bolum8s3 = {"plan","plane","public","river","road","safe","school bus","ship","sightseeing bus","street"};
    String [] ilkokul3bolum8s4 = {"subway","take a bus","take a car ","train","transportation","truck","van","vehicle","what about","what about you?"};

    String [] ilkokul3bolum8c1 = {"ambulans"," etrafında, çevresinde","güzel","bisiklet","tekne, bot","otobüs","araba","kalabalık","ünlü","varmak, -e gelmek"};
    String [] ilkokul3bolum8c2 = {"hayalet","dönmek","helikopter","tatil","kamyon","plan yapmak","motosiklet","güzel, sevimli","dışarısı","anne ve baba, ebeveyn"};
    String [] ilkokul3bolum8c3 = {"planlamak","uçak","halk, halka açık","nehir","yol, cadde","güvenilir; tehlikesiz","okul servisi","gemiye binmek","tur otobüsü","cadde, sokak"};
    String [] ilkokul3bolum8c4 = {" metro","otobüse binmek","arabaya binmek","tren"," taşımacılık"," kamyon","kamyonet","araç, taşıt","ne dersin","peki ya sen"};

    // 9. bölüm

    String [] ilkokul3bolum9s1 = {"blow","build","cloud","cloudy","cold","cool","dry","foggy","get wet","hot "};
    String [] ilkokul3bolum9s2 = {"nice","rain","raincoat","raining","rainy","snow","snowy","stormy","sun","sunny"};
    String [] ilkokul3bolum9s3 = {"swim","umbrella","warm","wear","weather","wet","windy","effort","worth","reporter"};

    String [] ilkokul3bolum9c1 = {"esmek","yapmak, inşa etmek"," bulut","bulutlu","soğuk","serin","kuru","sisli"," ıslanmak","sıcak"};
    String [] ilkokul3bolum9c2 = {"güzel, hoş","yağmur, (yağmur) yağmak","yağmurluk","yağış","yağmurlu","kar, (kar) yağmak","karlı","fırtınalı","güneş","güneşli"};
    String [] ilkokul3bolum9c3 = {" yüzmek","şemsiye"," ılık, sıcak","giymek","hava","ıslak; ıslatmak","rüzgârlı","çaba","değer","muhabir"};

    // 10. bölüm

    String [] ilkokul3bolum10s1 = {"Nature","Seagull","Bear","Dolphin","Kangaroo","Snake","Cow","Rabbit","Forest","Cave"};
    String [] ilkokul3bolum10s2 = {"Bee","Frog","Whale","Lion","Panda","Tiger","Chicken","Donkey","Sea","Mountain"};
    String [] ilkokul3bolum10s3 = {"Ladybird","Pigeon","Shark","Duck","Elephant","Monkey","Horse","Dog","River","Desert"};


    String [] ilkokul3bolum10c1 = {" Doğa","Martı","Ayı","Yunus","Kanguru","Yılan"," İnek","Tavşan","Orman","Mağara"};
    String [] ilkokul3bolum10c2 = {"Arı","Kurbağa"," Balina","Aslan","Panda","Kaplan","Tavuk"," Eşek","Deniz","Dağ"};
    String [] ilkokul3bolum10c3 = {"Uğur böceği","Güvercin","Köpek balığı","Ördek","Fil","Maymun","At","Köpek"," Nehir, dere","Çöl"};






    // 4. SINIF



    // 1. bölüm
    String [] ilkokul4bolum1s1 = {"Open the door","Open the window","Sit down","Be quiet","Listen","Come in","Give me","Thank you","Sure","Ten"};
    String [] ilkokul4bolum1s2 = {"Thirty","Fifty","Seventy","Ninety","Close the door","Close the window","Stand up","Raise your hand","Clean the board","Turn around"};
    String [] ilkokul4bolum1s3 = {"Here you are","Please","Of course","Twenty","Forty","Sixty","Eighty","One hundre","Sure","Ten"};

    String [] ilkokul4bolum1c1 = {"Kapıyı aç","Pencereyi aç","Otur","Sesiz ol","Dinle"," İçeri gir"," Ver bana","Teşekkür ederim","Tabiki, elbette","On"};
    String [] ilkokul4bolum1c2 = {"Otuz"," Elli","Yetmiş","Doksan","Kapıyı kapat"," Pencereyi kapat","Kalk","Elini kaldır","Tahtayı sil"," Etrafında dön"};
    String [] ilkokul4bolum1c3 = {"Al, buyur","Lütfen","Tabiki, elbette","Yirmi"," Kırk","Altmış","Seksen","Yüz","Tabiki, elbette","On"};

    // 2 . bölüm

    String [] ilkokul4bolum2s1 = {"Country","Turkiye","Germany","France","Pakistan","Russia","The USA","North","Age","Nationality"};
    String [] ilkokul4bolum2s2 = {"Turkish","German","French","Pakistani","Russian","American","South","Maybe","Britain","Italy"};
    String [] ilkokul4bolum2s3 = {"Spain","Japan","China","Iraq","East","I thinks so","British","Italian","Spanish","Japanese"};

    String [] ilkokul4bolum2c1 = {"Ülke","Türkiye","Almanya","Fransa","Pakistan","Rusya","Amerika Birleşik Devletleri","Kuzey","Yaş","Millet"};
    String [] ilkokul4bolum2c2 = {"Türk","Alman","Fransız","Pakistanlı","Rus","Amerikalı","Güney"," Belki","Britanya","İtalya"};
    String [] ilkokul4bolum2c3 = {"İspanya","Japonya","Çin","Irak","Doğu","Sanırım","Britanyalı","İtalyalı","İspanyol","Japon"};

    // 3. bölüm

    String [] ilkokul4bolum3s1 = {"Read a book","Play the guitar","Play football","Play tennis","Drive a car","Run fast","Ride a horse","Cook","Skate","My"};
    String [] ilkokul4bolum3s2 = {"His","Ride a bike","Do puzzle","Play basketball","Play game","Catch a ball","Climb a tree","Sing","Walk","Skip rope"};
    String [] ilkokul4bolum3s3 = {"Your","Her","Slide","Swing","Dance","Carry","Fly","Dive","Jump","Swim"};

    String [] ilkokul4bolum3c1 = {"Kitap okumak","Gitar Çalmak","Futbol oynamak","Tenis oynamak","Araba sürmek","Hızlı koşmak","Ata binmek","Yemek yapmak","Paten kaymak","Benim"};
    String [] ilkokul4bolum3c2 = {"Onun","Bisiklet Sürmek"," Bulmaca çözmek, Yapboz yapmak","Basketbol oynamak","Oyun oynamak","Top yakalamak","Ağaca tırmanmak","Şarkı söylemek","Yürümek"," İp atlamak"};
    String [] ilkokul4bolum3c3 = {"Senin, sizin","Onun ( Kadınlar için)","Kaymak","Sallanmak","Dans etmek","Taşımak","Uçmak","Dalmak","Zıplamak","Yüzmek"};

    // 4. bölüm

    String [] ilkokul4bolum4s1 = {"climbing","dancing","doing puzzle","drawing a picture","drive","fishing","flying a kite","free time","jogging","learning english"};
    String [] ilkokul4bolum4s2 = {"listening to music","playing chess","playing computer games","playing football","playing hopscotch","playing table tennis","playing tag","playing volleyball","playing with marbles","playing with toys"};
    String [] ilkokul4bolum4s3 = {"readin a book","riding a bike","running","shopping","skipping a rope","singing","skating","skip rope","speaking english","swimming"};

    String [] ilkokul4bolum4c1 = {"tırmanma","dans etme","yapboz yapmak"," resim çizme","araba süğrmek"," balık avı"," uçurtma uçurma","boş zaman","tempolu ve yavaş koşu","ingilizce öğrenme"};
    String [] ilkokul4bolum4c2 = {"müzik dinleme","satranç oynama","bilgisayar oyunları oynama","futbol oynama","sek sek oynama","ping pong oynama","ebelemece oyunu","voleybol oynama","misket oynama","oyuncaklarla oynama"};
    String [] ilkokul4bolum4c3 = {" kitap okumak","bisiklete binme","koşma","alış veriş yapma","ip atlama","şarkı söylemek","patenle/ kaykayla kaymak","ip atlamak","ingilizce konuşma","yüzme"};

    // 5. bölüm

    String [] ilkokul4bolum5s1 = {"Brush teeth","Comb hair","Come home","Do homework","Do shopping","Get dressed","Go shopping","Go to bed","Go to school","Have a shower"};
    String [] ilkokul4bolum5s2 = {"Have breakfast","Have dinner","Have lunch","Leave school","Listen to the music","Listen to the teacher","Meet friends","Play chess","Play computer games","Play the guitar"};
    String [] ilkokul4bolum5s3 = {"Read a book","Sleep","Take a shower","Wake up","Wash face and hands","Watch television","Wear clothes","free time","jogging","learning english"};

    String [] ilkokul4bolum5c1 = {" Dişleri fırçalamak","saç taramak"," eve gelmek","ödev yapmak","alışveriş yapmak","giyinmek; üstünü giymak","alışverişe gitmek","yatmak","okula gitmek","duş almak"};
    String [] ilkokul4bolum5c2 = {"kahvaltı yapmak","akşam yemeği yemek","öğle yemeği yemek","okuldan ayrılmak","müzik dinlemek"," öğretmeni dinlemek","arkadaşlarla buluşmak","satranç oynamak","bilgisayar oyunları oynamak","gitar çalmak"};
    String [] ilkokul4bolum5c3 = {"kitap okumak","uyumak","duş almak","Uyanmak","elleri ve yüzü yıkamak","televizyon seyretmek","elbiseleri giymek","boş zaman","tempolu ve yavaş koşu","ingilizce öğrenme"};

    //6. bölüm

    String [] ilkokul4bolum6s1 = {"In","In front of","Box","Mix","Flower","Shake","Experiment","Fun","Glass","On"};
    String [] ilkokul4bolum6s2 = {"Behind","Bottle","Paint","Cut","Plant","Science","Seed","Melt","Under","Near"};
    String [] ilkokul4bolum6s3 = {"Brush","Water","Paper","Fold","Scientist","Palette","Ice","Policeman","Chef","Baker"};

    String [] ilkokul4bolum6c1 = {"İçinde","Önünde","Kutu","Karıştırmak","Çiçek","Sallamak","Deney","Eğlenmek,","Bardak","Üstünde"};
    String [] ilkokul4bolum6c2 = {"Arkasında","Şişe","Boya","Kesmek","Dikmek","Bilim","Tohum","Erimek","Altında","Yakınında, yanında"};
    String [] ilkokul4bolum6c3 = {"Fırça","Sulamak, su"," Kağıt","Katlamak","Bilim adamı","Palet","Buz","Polis","Aşçı","Fırıncı"};

    // 7. bölüm

    String [] ilkokul4bolum7s1 = {"Jobs","Nurse","Policeman","Chef","Baker","Pilot","Cook","Farm","Work","Teacher"};
    String [] ilkokul4bolum7s2 = {"Farmer","Fireman","Singer","Florist","Dancer","School","Fire station","Where?","Doctor","Dentist"};
    String [] ilkokul4bolum7s3 = {"Waiter","Vet","Postman","Tailor","Hospital","Police station","What?","Umbrella","Bag","Hot"};

    String [] ilkokul4bolum7c1 = {"Meslekler","Hemşire","Polis","Aşçı","Fırıncı","Pilot","Yemek yapmak","Çiftlik","Çalışmak","Öğretmen"};
    String [] ilkokul4bolum7c2 = {"Çiftçi","İtfaiyeci","Şarkıcı","Çiçekçi","Dansçı"," Okul","İtfaiye","Nerede?","Doktor","Diş doktoru"};
    String [] ilkokul4bolum7c3 = {"Garson","Veteriner","Postacı","Terzi","Hastane"," Polis karakolu","Ne?","Şemsiye","Çanta","Sıcak"};

    // 8. bölüm
    String [] ilkokul4bolum8s1 = {"Season","Summer","T-shirt","Hat","Skirt","Boots","Scarf","Umbrella","Bag","Hot"};
    String [] ilkokul4bolum8s2 = {"Cloudy","Warm","Winter","Autumn","Shirt","Coat","Jacket","Gloves","Socks","Shorts"};
    String [] ilkokul4bolum8s3 = {"Glasses","Cold","Rainy","Cool","Spring","Fall","Dress","Trousers","Shoes","Raincoat"};
    String [] ilkokul4bolum8s4 = {"Wear","Put on","Sunglasses","Sunny","Snowy","Weather","exchange rate","run out","cottage","street"};

    String [] ilkokul4bolum8c1 = {"Mevsim","Yaz","Tişört","Şapka","Etek","Bot","Atkı, Eşarp,Şal","Şemsiye","Çanta","Sıcak"};
    String [] ilkokul4bolum8c2 = {"Bulutlu","Sıcak","Kış","Sonbahar","Gömlek","Mont, ceket","Ceket","Eldiven","Çorap","Şort"};
    String [] ilkokul4bolum8c3 = {"Gözlük","Soğuk","Yağmurlu","Serin","İlkbahar","Sonbahar","Elbise","Pantolon","Ayakkabı","Yağmurluk"};
    String [] ilkokul4bolum8c4 = {"Giymek","Giymek","Güneş gözlüğü","Güneşli","Karlı","Hava","döviz kuru","tükenmek, bitmek","kulübe","sokak"};

    // 9. bölüm

    String [] ilkokul4bolum9s1 = {"Friend","Short","Hair color","Brown","Hair syle","Curly","Long","Body build","Fat","Blonde"};
    String [] ilkokul4bolum9s2 = {"Fair","Wavy","Handsome","Moustache","Tall","Thin / Slim","Black","Eye color","Straight","Beautiful"};

    String [] ilkokul4bolum9c1 = {" Arkadaş"," Kısa","Saç rengi","Kahverengi"," Saç modeli","Kıvırcık","uzun","Vücut yapısı","Şişman","Sarışın"};
    String [] ilkokul4bolum9c2 = {"Açık renk; Sarışın","Dalgalı","Yakışıklı","Bıyık","Uzun","Zayıf","Siyah","Göz rengi","Düz","Güzel"};

    // 10. bölüm

    String [] ilkokul4bolum10s1 = {"Food","Butter","Coffee","Lemonade","Orange juice","Salad","Tea","Cereal","I’m full","Drinks"};
    String [] ilkokul4bolum10s2 = {"Cheese","Honey","Milk","Pasta","Sandwich","Water","Egg","I’m hungry","Bread","Chicken"};
    String [] ilkokul4bolum10s3 = {"Ice cream","Olive","Pizza","Soup","Jam","Marmelade","I’m thirsty","Friend","Short","Tall"};

    String [] ilkokul4bolum10c1 = {"Yiyecek","Tereyağı","Kahve","Limonata","Portakal suyu","Salata","Çay","Mısır gevreği","Tokum","İçecekler"};
    String [] ilkokul4bolum10c2 = {"Peynir","Bal","Süt","Makarna","Sandviç","Su","Yumurta","Acıktım","Ekmek","Tavuk"};
    String [] ilkokul4bolum10c3 = {"Dondurma","Zeytin"," Pizza","Çorba"," Reçel","Marmelat","Susadım","Arkadaş","Kısa","Bıyık"};


    String[] yanlislar1 = {"dergi","güvenmek","görmek","yastık","itfaiyeci","mağaza","yazık","dava, durum","açık","tükenmek, bitmek","sokak","gök gürültüsü","rahatlamış","saray","lütfen","vurmak","yayınlamak","savunma","fantastik","tepe","çaba","muhabir","nokta; tespit etmek","ikinci, saniye","raket","doğa","makul","kafa karıştırıcı","yemek pişirme","darbe, vurma, esmek","çöp","sınav yapan","iki kere","nüfus","çeşitlilik","tırmanma","gururlu","güzel","hız","gizem","seyahat etmek","makul bir şekilde","ertelemek","matematik","serin","oyuncu","dalmak","ödünç vermek","mutlu","aşağı","mutlu","tartışmak","parlak","hava","kızartmak","akşam yemeği","işgal, meslek","yetiştirmek","Meyve","yüksek","kurs","güvenli, kasa","öldürmek","tüp","eğitmen","çan","dağınık","hayır","sıra, kürek çekmek","kulübe","meyve suyu","şaşırmış","öğrenmek","ders","zemin","eczane","tebrikler!","yakın, kapatmak","şekil, rakam","yaprak","dolap","motosiklet","bilgi","genç (13-19)","uyku","sermaye","henüz, ama","kısmak","kare","grip","ızgarada pişmiş","telefon etmek","evlilik","ulusal","ayrıca","yazı tahtası","hiçbiri","almak (zaman, yer)","hayat","ağaç","otopark","saat","verimli","müşteri","ambulans","yaş","gelin","muhteşem","nakit","sağlıklı",
            "nefes","renkli","yasa","gergin","götürmek","çerçeve","emin olmak","açık","olmak","galeri","düşkün","iğne, iğnelemek","yaka","taşıma","yürümek","diz","içermek","şerit","kazık","tatilde",
            "kızdırmak","kaymak","detay","derin","piyango","ev hanımı","nitelik","kapak","çakmak","sen","işsiz","anlaşma","fotoğraf","etrafında","yazılım","dikmek","uzman","mevcut, sunmak, hediye","karanlık","durum",
            "hayal kırıklığına uğratmak","belki","görünüm","başlık, manşet","çeşit","açmak (cihaz)","yükseklik","bilimsel","zalim","arkada kalmak",
            "anahtar","işaret","tamirci","dokunmak","kültürel","herhangi","ağrı","desteklemek","gitarist","arka plân","sık sık","doldurmak","sosyal","sert, zor","ancak","çift","eğitim","kaptan","taşımak","barbekü",
            "kimse","tren, antrenman yapmak","sisli","ev","meşgul","benzin","çanta","satmak","miktar","ayak bileği","kulak","kupa","Kuyruk","Giriş","uzak","görme, görüş","oğul","komedi","acilen","imza",
            "kesinlikle","posta","yerleştirmek","yabancı","bu","yün","taraftar","gelmek","sürmek","hayal",
            "ayıp","favori","ısırmak","hamile","tutmak","polis memuru","icat etmek","düğün","toplantı","inanılmaz",
            "veya","iletişim kurmak","eğlendirmek","kale","karşı, zıt","fotoğrafçılık","asgari","meslektaş","atmosfer","dinlemek",
            "dışında","kayıp","düşünmek, hayal etmek","hemen","görünmek","aktris","korkutmak","çorap","hasta","acı verici",
            "yerine koymak","dondurma","inanmak","suçlu","sarmak","gece kulübü","parti","güzel","paragraf","tanımlamak",
            "asistan","gelişme","merkezi ısıtma","laboratuvar","aktif","dikkatsiz","zevk","kaplan","geri dönüştürmek","temiz",
            "buzdolabı","tarihi geçmiş","silah","servis yapmak","…e göre","kıvırcık","turnuva","dikkat etmek","borçlu olmak","tatmin edici",
            "metin","büyük","önünde","at","açlık","ayrı","kanamak","güneşli","dans","İsim",
            "dönüş, geri dönmek","bavul","yere devirmek","minder","basit","yola çıkmak","kabin","kesin","eşya, malzeme","desteklemek",
            "hisse, pay, paylaşmak","diş macunu","şikâyet","sıkılmış","belki","sürücü","sallamak","çevre","eklemek","her yer",
            "yelken","kırmızı","bulmaca","postane","sormak","teşekkür etmek","sadece","elektronik","geniş","elverişsiz",
            "binici","kahve","ot","parmak","çözmek","bayan","bilet gişesi","yetenekli","dirsek","sessizlik",
            "canlı","…e kadar","şef","halk","önlemek","almak","gökyüzü","enerji","sohbet","yanıyor",
            "sınır","balık tutma","süslemek","musluk","indirim","öğle yemeği zamanı","kilim","gerekli","korumak","Bilirsin",
            "kemer","vasıtasıyla, yoluyla","kurşun, liderlik etmek","kaydetmek","ilan","fıstık","… sız, … madan","ıslak","çöp kovası","limonata",
            "kontrol etmek","azaltmak","sorumlu","bunalımlı","balayı","lastik (araba)","çorba","kesinlikle","bilinmeyen","geri vermek",
            "onu, onun","erkek arkadaş","kanal","parlamak","korku","bebek bakıcılığı","fırsat","gül","polis","mesaj",
            "yüz yüze","eczane","ekin","tavsiye etmek","tahmin etmek","kaydetmek","parfüm","sefil","çalmak","yapışkan",
            "ne zaman, … dığı zaman","umut kırıcı","tabela","tencere","hastalık","bireysel","araç","postacı","ucuz","heyecanlı",
            "az","liman","motosiklet","hasarlı","toplam, toplamak","fiş","sakal","tutuklamak","top","birisi",
            "ampul","yarış","dudak","öğrenmek","şahsen","cm","onlarınki","senin","kavga","sınır",
            "yatak","muhteşem","ruh hali","tamam","bellek","güney","ısıtıcı","geri ödeme","dürüstçe","yorucu",
            "rahat","dışarı","akşam yemeği","kolye","kıskanç","araştırmak","boş","renk","son","çevirmek",
            "Alarm","dilbilgisi","ilişki","lüks","turta","kol","şaşırmış","uygulama","akış","sürdürmek",
            "kırık","…mek amacıyla","şifre","koca","görünmek","hırs","artık","karar","sendika","sayfa",
            "kanıtlamak","çocuk","şeker","icat","bilgilendirmek","kız","kaynatmak","düzenli","düzenli","hızlı",
            "uçmak, sinek","torun","ayak","satılık","evren","orman","hatta, bile","gergin","son","fizik",
            "korsan","kalite","beklenmedik","merdiven","neşeli","oluşturmak, form","ziyaretçi","düzine","toplu taşıma","aslında",
            "küçük","mali","ilkokul","duymak","eğlence","korkutucu","peynir","kapak","kariyer","bağlamak (telefon)",
            "ana","kaza","toplum","pembe dizi","mahkeme","hecelemek","ikinci el","kuru","köpekbalığı","bilezik",
            "yıldönümü","talimat","bilim","çol büyük","üzgün","takas","şampiyonluk","kelebek","söylemek","ortalama",
            "dökmek","harika","emekli olmak","ulaşmak","herkes","kazanmak","fırça","hayvan","onun","lacivert",
            "sağlamak","çünkü, …dığı için","kabul etmek","raf","zarf","kavanoz","gerçekten","dondurucu","tablo, masa","yonga",
            "cilt","güney","yaklaşım","büyük","ipek","en uzak","popüler","puan","sonra","ödeme, çıkış",
            "defter","erken","endişe","ayrılmak","aralık","şampiyon","rol","jimnastik","kamu","banyo",
            "pozisyon","elektrik","kalabalık","deli","neden, akıl","sınırlı","kitaplık","sıfır","Kauçuk, silgi","kıyı",
            "ilgi, faiz, çıkar","hava Kuvvetleri","belgesel","grafik","çeşitli","tava","kraliçe","meslek","düşünmek","tramvay",
            "paket","çanak","dalga","fakir","ceket","aslında, gerçekten de","destekçi","suçlamak","ne yazık ki","ünlü",
            "sürdürmek","buz pateni","küvet","hasar","kutu","gevşek","söylemek","1,6 km","yeraltı, metro","Mahkum",
            "koleksiyon","havaalanı","satranç","sıkı","varmak","atık, ısraf etmek","ebeveyn","sahne","lig","neredeyse",
            "ferketmek","çatal","en az","sırayla","okuma","temas kurmak","ordu","yeniden inşa etmek","film","sinema",
            "sürahi","önem","melodi","otopark","kibar","konu","talep","biber","elbise","uçak",
            "ciddi bir şekilde","yedek","tesisler, imkanlar","başlangıç, baş","pişirmek","nesne","geçit","üniforma","kuş","vadi",
            "hava","demir, ütü","kontrol etmek","adam","amaç","içinde","kaybetmek","anahtar","temel","devam etmek",
            "suç","kesinlikle","çekici","doğru,","kalkış","savaş","fırıncı","harika","köşe","girmek",
            "oturma odası","durum","parça, bölüm","uzay, alan","an","beklemek","hemşire","bisiklet","girmek","genel",
            "kazak","ayakkabı","dalgıç","gümrüksüz","fare","hoşsohbet","farklı","toz","dansçı","sarışın",
            "gece hayatı","kolayca","ile ilgilenmek","hesap, hikaye","fırtına","yaratıcı","özgeçmiş","yaprak, çarşaf","kapatmak","ilerlemek",
            "genç","her nasılsa","kitaplık","seviye","yük","Yazıcı","akıl, önemsemek","öneri","gömmek","ünlü (harf)",
            "subay","onları/onlara","otel","nihayet","film","soru","okul müdürü","dönem","anıt","geciktirmek",




    };

    String[] yanlislar2 = {"aynı zamanda","alışılmadık","ekipman","ilgisiz","pazar","sınav","iğrenç","sakız","niyet etmek","zorlu","eski moda","plaj","altında","pil","cevap vermek","adil","vermek","soymak","çiftlik","perde",
            "bilet ücreti","baş öğretmen","duyurmak","dün","deneyimli","korkmuş","rezerv, şerh","beslemek","bol","planlamak","gümrük","yaralamak","bina","bulunan, konumlanan","çocuk","siyasi","önce","üst kat","çıkarmak","korkmuş",
            "cesaret","seçmek","giriş","dövmek","inşa etmek","ahır","Oda","reçel","konu, sorun, mesele","sevimli",
            "aperatif","kapamak","dik","bağımsız","mühendis","iz","altında","yerine","para","örnek",
            "balkon","geçici","dünya","azaltmak","kokmak","acı çekmek, katlanmak","elle","doğrudan"," yapılmış","birlikte",
            "şirket","merkezi","sanatçı","sigara içme","cetvel, kural koyucu","gemide","papağan","ani","işçi","uygun",
            "nedeniyle","endişeli","belki","ilk","konu","koltuk","daha az","gerçekleştirmek","üst","kalemlik",
            "cezalandırmak","canlı","söz","ikiz","teklif etmek","işaret","çığlık","Ben","çiçek","ayrıca, daha fazla",
            "yaratık","orman","erkek çocuk","keman","kuzu","sinir","sefer","aferin!","dürüst","savunmak",
            "nemli","lavabo","kalkmak","Sağ, doğru, hak","kişi","yere sermek","gündoğumu","aptal","kurmak","cesur",
            "cinsiyet","şık","ders","unutulmaz","ödeme","giysiler","…e dayandırmak","fren","yorum","adım",
            "coğrafya","evcil hayvan","konuşma","ya, ikisinden biri","tarihi","yıl","borç","tıklamak","dökmek","çöp kutusu",
            "milimetre","öğlen","yaratmak","boş","boğa","boyama","umutsuz","yıllık","kostüm","uç",
            "sörf tahtası","sahne","adam","çiftçi","her şey","hareket etmek","kantin","kültür","yakışıklı","uzun",
            "ton balığı","bilimkurgu","güncel","kısmen","yer, alan","yepyeni","koltuk","yaşlı","açık havada","yönetmen",
            "tekerlek","aptal","genellikle","düzenleme","satış","merakla","her bir","ile","özellik, mülk","tamamen",
            "kuzey","havlu","bugün","topuk","istemek","gümüş","kullanmak","emniyet kemeri","ilgi çekmeyen","birisi",
            "çöp tenekesi","orta yaşlı","dil","yağmurluk","rahatsız","içermek","değer","beni, bana","koşmak","…e kadar",
            "boyunca","gürültü","boyunca, vasıtasıyla","diş ağrısı","roman","çay","beyin","havza","gidip getirmek","biyografi",
            "daha iyi","son zamanlarda","kaza","sahil","yavaş yavaş","deniz yolculuğu","dışında","dev","tiyatro","süt",
            "bant","cezbetmek","parça","suçlu","antika","çocuk bakıcısı","tuhaf garip","herhangi bir kimse","yeşil","hızlıca",
            "şiir","bir şey","anlaşmak","koyun","arasında","izin","dede","kız kardeş","özel","balon",
            "bugüne/o güne dek","işveren","tartışma","den dolayı","ikincil","kuzey","aslan","yıkama","sevgili","merkez / merkez",
            "ziyaret etmek","yarasa","donma","yüksek sesle","büyük mağaza","izin vermek","alkışlamak","hediye eşya","düzenlemek","neden",
            "uçurum","olağanüstü","takım elbise, uymak","saldırı","kum","mutfak","ünsüz harf","ümkanı olmak, gücü yetmek","düzeltme","büyümek",
            "dil","tüm","kaba","çizgi","köprü","giymek, aşınmak","karşısında","araba","çeşme","boru",
            "cevap","kurtulmak","oturmak","yapmak","çikolata","işçi","enstrüman","iş günü","kalp","jet",
            "buzdolabı","tarihi geçmiş","silah","servis yapmak","…e göre","kıvırcık","turnuva","dikkat etmek","borçlu olmak","tatmin edici",
            "metin","büyük","önünde","at","açlık","ayrı","kanamak","güneşli","dans","İsim",
            "dönüş, geri dönmek","bavul","yere devirmek","minder","basit","yola çıkmak","kabin","kesin","eşya, malzeme","desteklemek",
            "hisse, pay, paylaşmak","diş macunu","şikâyet","sıkılmış","belki","sürücü","sallamak","çevre","eklemek","her yer",
            "yelken","kırmızı","bulmaca","postane","sormak","teşekkür etmek","sadece","elektronik","geniş","elverişsiz",
            "binici","kahve","ot","parmak","çözmek","bayan","bilet gişesi","yetenekli","dirsek","sessizlik",
            "canlı","…e kadar","şef","halk","önlemek","almak","gökyüzü","enerji","sohbet","yanıyor",
            "sınır","balık tutma","süslemek","musluk","indirim","öğle yemeği zamanı","kilim","gerekli","korumak","Bilirsin",
            "kemer","vasıtasıyla, yoluyla","kurşun, liderlik etmek","kaydetmek","ilan","fıstık","… sız, … madan","ıslak","çöp kovası","limonata",
            "kontrol etmek","azaltmak","sorumlu","bunalımlı","balayı","lastik (araba)","çorba","kesinlikle","bilinmeyen","geri vermek",
            "onu, onun","erkek arkadaş","kanal","parlamak","korku","bebek bakıcılığı","fırsat","gül","polis","mesaj",
            "yüz yüze","eczane","ekin","tavsiye etmek","tahmin etmek","kaydetmek","parfüm","sefil","çalmak","yapışkan",
            "ne zaman, … dığı zaman","umut kırıcı","tabela","tencere","hastalık","bireysel","araç","postacı","ucuz","heyecanlı",
            "az","liman","motosiklet","hasarlı","toplam, toplamak","fiş","sakal","tutuklamak","top","birisi",
            "ampul","yarış","dudak","öğrenmek","şahsen","cm","onlarınki","senin","kavga","sınır",
            "yatak","muhteşem","ruh hali","tamam","bellek","güney","ısıtıcı","geri ödeme","dürüstçe","yorucu",
            "rahat","dışarı","akşam yemeği","kolye","kıskanç","araştırmak","boş","renk","son","çevirmek",
            "Alarm","dilbilgisi","ilişki","lüks","turta","kol","şaşırmış","uygulama","akış","sürdürmek",
            "kırık","…mek amacıyla","şifre","koca","görünmek","hırs","artık","karar","sendika","sayfa",
            "kanıtlamak","çocuk","şeker","icat","bilgilendirmek","kız","kaynatmak","düzenli","düzenli","hızlı",
            "uçmak, sinek","torun","ayak","satılık","evren","orman","hatta, bile","gergin","son","fizik",
            "korsan","kalite","beklenmedik","merdiven","neşeli","oluşturmak, form","ziyaretçi","düzine","toplu taşıma","aslında",
            "küçük","mali","ilkokul","duymak","eğlence","korkutucu","peynir","kapak","kariyer","bağlamak (telefon)",
            "ana","kaza","toplum","pembe dizi","mahkeme","hecelemek","ikinci el","kuru","köpekbalığı","bilezik",
            "yıldönümü","talimat","bilim","çol büyük","üzgün","takas","şampiyonluk","kelebek","söylemek","ortalama",
            "dökmek","harika","emekli olmak","ulaşmak","herkes","kazanmak","fırça","hayvan","onun","lacivert",
            "sağlamak","çünkü, …dığı için","kabul etmek","raf","zarf","kavanoz","gerçekten","dondurucu","tablo, masa","yonga",
            "cilt","güney","yaklaşım","büyük","ipek","en uzak","popüler","puan","sonra","ödeme, çıkış",
            "defter","erken","endişe","ayrılmak","aralık","şampiyon","rol","jimnastik","kamu","banyo",
            "pozisyon","elektrik","kalabalık","deli","neden, akıl","sınırlı","kitaplık","sıfır","Kauçuk, silgi","kıyı",
            "ilgi, faiz, çıkar","hava Kuvvetleri","belgesel","grafik","çeşitli","tava","kraliçe","meslek","düşünmek","tramvay",
            "paket","çanak","dalga","fakir","ceket","aslında, gerçekten de","destekçi","suçlamak","ne yazık ki","ünlü",
            "sürdürmek","buz pateni","küvet","hasar","kutu","gevşek","söylemek","1,6 km","yeraltı, metro","Mahkum",
            "koleksiyon","havaalanı","satranç","sıkı","varmak","atık, ısraf etmek","ebeveyn","sahne","lig","neredeyse",
            "ferketmek","çatal","en az","sırayla","okuma","temas kurmak","ordu","yeniden inşa etmek","film","sinema",
            "sürahi","önem","melodi","otopark","kibar","konu","talep","biber","elbise","uçak",
            "ciddi bir şekilde","yedek","tesisler, imkanlar","başlangıç, baş","pişirmek","nesne","geçit","üniforma","kuş","vadi",
            "hava","demir, ütü","kontrol etmek","adam","amaç","içinde","kaybetmek","anahtar","temel","devam etmek",
            "suç","kesinlikle","çekici","doğru,","kalkış","savaş","fırıncı","harika","köşe","girmek",
            "oturma odası","durum","parça, bölüm","uzay, alan","an","beklemek","hemşire","bisiklet","girmek","genel",
            "kazak","ayakkabı","dalgıç","gümrüksüz","fare","hoşsohbet","farklı","toz","dansçı","sarışın",
            "gece hayatı","kolayca","ile ilgilenmek","hesap, hikaye","fırtına","yaratıcı","özgeçmiş","yaprak, çarşaf","kapatmak","ilerlemek",
            "genç","her nasılsa","kitaplık","seviye","yük","Yazıcı","akıl, önemsemek","öneri","gömmek","ünlü (harf)",
            "subay","onları/onlara","otel","nihayet","film","soru","okul müdürü","dönem","anıt","geciktirmek",



    };


    TextView textView;
    int run;
    Button button1, button2, button3,button4;
    Soru soru1;
    String dogru;
    int sorusay = 0;
    int kacsoru = 0;
    int yanlis1, yanlis;
    String cevap1, cevap2, cevap3, s1, s2, s3;
    private int cur = 0;
    Runnable runnable,runnable1;
    Handler handler,handler1;
    SQLiteDatabase database;

    ProgressBar progressBar;
    ImageView imageView;
    SharedPreferences sharedPreferences ;
    String sev;
    TextToSpeech textToSpeech;
    String saat;
    int soruyanlis = 0;
    int sorudogru = 0;
    int reklam =0;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelime);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-9283206876818854/6520854277", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                    }
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
        textToSpeech = new TextToSpeech(Kelimeilkokul.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });
        sharedPreferences = this.getSharedPreferences("com.mert.kolayingilizce", Context.MODE_PRIVATE);
        database = this.openOrCreateDatabase("data",MODE_PRIVATE,null);
        textView = findViewById(R.id.textView7);
        button1 = findViewById(R.id.button4);
        button2 = findViewById(R.id.button8);
        button3 = findViewById(R.id.button10);
        button4 = findViewById(R.id.button23);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageView4);
        sev = sharedPreferences.getString("seviye1","noll");
        saat = sharedPreferences.getString("saat","süreli");

        progressBar.setMax(500);
        if (sorusay == 0) {
            sorudegistirme();
            sorudegis();


        }

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech.speak(soru1.soru,TextToSpeech.QUEUE_FLUSH,null,null);
            }
        });


    }

    public void button11(View view){
        cevap1 = button1.getText().toString();
        dogru = soru1.cevap;

        if (Objects.equals(dogru, cevap1)) {
            dogruc();
            sorudogru++;
            reklam++;
        } else {
            button1.setBackgroundResource(R.drawable.y);
            dogruc();
            soruyanlis++;
            reklam++;
        }

    }
    public void button12(View view){
        cevap2 = button2.getText().toString();
        dogru = soru1.cevap;

        if (Objects.equals(dogru, cevap2)) {
            dogruc();
            sorudogru++;
            reklam++;
        } else {
            button2.setBackgroundResource(R.drawable.y);
            dogruc();
            soruyanlis++;
            reklam++;
        }

    }
    public void button13(View view){
        cevap3 = button3.getText().toString();
        dogru = soru1.cevap;
        if (Objects.equals(dogru, cevap3)) {
            dogruc();
            sorudogru++;
            reklam++;
        } else {
            button3.setBackgroundResource(R.drawable.y);
            dogruc();
            soruyanlis++;
            reklam++;
        }

    }
    private void ShowDialogBox () {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.dialog, null);
        alert.setView(mView);
        final AlertDialog alertDialog = alert.create();
        alertDialog.setCancelable(false);
        TextView textView1 = mView.findViewById(R.id.dogruset);
        TextView textView2 = mView.findViewById(R.id.yanlisset);
        TextView textView3 = mView.findViewById(R.id.puanset);
        TextView textView4 = mView.findViewById(R.id.baslik);
        TextView textView5 = mView.findViewById(R.id.baslik1);
        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/Aclonica-Regular.ttf");
        textView1.setTypeface(typeface);
        textView2.setTypeface(typeface);
        textView3.setTypeface(typeface);
        textView4.setTypeface(typeface);
        textView5.setTypeface(typeface);
        textView1.setText("" + sorudogru);
        textView2.setText("" + soruyanlis);
        textView3.setText("" + sorudogru * 2);
        mView.findViewById(R.id.restart).setOnClickListener(v -> {
            Intent intent = new Intent(Kelimeilkokul.this, Kelimeilkokul.class);
            startActivity(intent);
            finish();
        });

        mView.findViewById(R.id.next).setOnClickListener(v -> {
            if (Objects.equals(sev, "2.SINIFbölüm1s1")){
                sharedPreferences.edit().putString("seviye1","2.SINIFbölüm1s2").apply();
            } else if (Objects.equals(sev, "2.SINIFbölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","2.SINIFbölüm1s3").apply();
            }else if (Objects.equals(sev, "2.SINIFbölüm1s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1 Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }  if (Objects.equals(sev, "2.SINIFbölüm2s1")){
                sharedPreferences.edit().putString("seviye1","2.SINIFbölüm2s2").apply();
            }else if (Objects.equals(sev, "2.SINIFbölüm2s2")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            } if (Objects.equals(sev, "2.SINIFbölüm3s1")){
                sharedPreferences.edit().putString("seviye1","2.SINIFbölüm3s2").apply();
            } else if (Objects.equals(sev, "2.SINIFbölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","2.SINIFbölüm3s3").apply();
            }else if (Objects.equals(sev, "2.SINIFbölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","2.SINIFbölüm3s4").apply();
            }else if (Objects.equals(sev, "2.SINIFbölüm3s4")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "2.SINIFbölüm4s1")){
                sharedPreferences.edit().putString("seviye1","2.SINIFbölüm4s2").apply();
            }else if (Objects.equals(sev, "2.SINIFbölüm4s2")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "2.SINIFbölüm5s1")){
                sharedPreferences.edit().putString("seviye1","2.SINIFbölüm5s2").apply();
            }else if (Objects.equals(sev, "2.SINIFbölüm5s2")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "2.SINIFbölüm6s1")){
                sharedPreferences.edit().putString("seviye1","2.SINIFbölüm6s2").apply();
            }else if (Objects.equals(sev, "2.SINIFbölüm6s2")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "2.SINIFbölüm7s1")){
                sharedPreferences.edit().putString("seviye1","2.SINIFbölüm7s2").apply();
            }else if (Objects.equals(sev, "2.SINIFbölüm7s2")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "2.SINIFbölüm8s1")){
                sharedPreferences.edit().putString("seviye1","2.SINIFbölüm8s2").apply();
            }else if (Objects.equals(sev, "2.SINIFbölüm8s2")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "2.SINIFbölüm9s1")){
                sharedPreferences.edit().putString("seviye1","2.SINIFbölüm9s2").apply();
            } else if (Objects.equals(sev, "2.SINIFbölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","2.SINIFbölüm9s3").apply();
            }else if (Objects.equals(sev, "2.SINIFbölüm9s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "3.SINIFbölüm1s1")){
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm1s2").apply();
            } else if (Objects.equals(sev, "3.SINIFbölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm1s3").apply();
            }else if (Objects.equals(sev, "3.SINIFbölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm1s4").apply();
            }else if (Objects.equals(sev, "3.SINIFbölüm1s4")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "3.SINIFbölüm2s1")){
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm2s2").apply();
            } else if (Objects.equals(sev, "3.SINIFbölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm2s3").apply();
            }else if (Objects.equals(sev, "3.SINIFbölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm2s4").apply();
            }else if (Objects.equals(sev, "3.SINIFbölüm2s4")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "3.SINIFbölüm3s1")){
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm3s2").apply();
            } else if (Objects.equals(sev, "3.SINIFbölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm3s3").apply();
            }else if (Objects.equals(sev, "3.SINIFbölüm3s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "3.SINIFbölüm4s1")){
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm4s2").apply();
            } else if (Objects.equals(sev, "3.SINIFbölüm4s2")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "3.SINIFbölüm5s1")){
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm5s2").apply();
            } else if (Objects.equals(sev, "3.SINIFbölüm5s2")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "3.SINIFbölüm6s1")){
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm6s2").apply();
            } else if (Objects.equals(sev, "3.SINIFbölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm6s3").apply();
            }else if (Objects.equals(sev, "3.SINIFbölüm6s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "3.SINIFbölüm7s1")){
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm7s2").apply();
            } else if (Objects.equals(sev, "3.SINIFbölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm7s3").apply();
            }else if (Objects.equals(sev, "3.SINIFbölüm7s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "3.SINIFbölüm8s1")){
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm8s2").apply();
            } else if (Objects.equals(sev, "3.SINIFbölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm8s3").apply();
            }else if (Objects.equals(sev, "3.SINIFbölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm8s4").apply();
            }else if (Objects.equals(sev, "3.SINIFbölüm8s4")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "3.SINIFbölüm9s1")){
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm9s2").apply();
            } else if (Objects.equals(sev, "3.SINIFbölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm9s3").apply();
            }else if (Objects.equals(sev, "3.SINIFbölüm9s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "3.SINIFbölüm10s1")){
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm10s2").apply();
            } else if (Objects.equals(sev, "3.SINIFbölüm10s2")) {
                sharedPreferences.edit().putString("seviye1","3.SINIFbölüm10s3").apply();
            }else if (Objects.equals(sev, "3.SINIFbölüm10s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 10. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "4.SINIFbölüm1s1")){
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm1s2").apply();
            } else if (Objects.equals(sev, "4.SINIFbölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm1s3").apply();
            }else if (Objects.equals(sev, "4.SINIFbölüm1s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "4.SINIFbölüm2s1")){
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm2s2").apply();
            } else if (Objects.equals(sev, "4.SINIFbölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm2s3").apply();
            }else if (Objects.equals(sev, "4.SINIFbölüm2s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "4.SINIFbölüm3s1")){
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm3s2").apply();
            } else if (Objects.equals(sev, "4.SINIFbölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm3s3").apply();
            }else if (Objects.equals(sev, "4.SINIFbölüm3s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "4.SINIFbölüm4s1")){
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm4s2").apply();
            } else if (Objects.equals(sev, "4.SINIFbölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm4s3").apply();
            }else if (Objects.equals(sev, "4.SINIFbölüm4s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "4.SINIFbölüm5s1")){
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm5s2").apply();
            } else if (Objects.equals(sev, "4.SINIFbölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm5s3").apply();
            }else if (Objects.equals(sev, "4.SINIFbölüm5s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "4.SINIFbölüm6s1")){
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm6s2").apply();
            } else if (Objects.equals(sev, "4.SINIFbölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm6s3").apply();
            }else if (Objects.equals(sev, "4.SINIFbölüm6s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "4.SINIFbölüm7s1")){
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm7s2").apply();
            } else if (Objects.equals(sev, "4.SINIFbölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm7s3").apply();
            }else if (Objects.equals(sev, "4.SINIFbölüm7s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "4.SINIFbölüm8s1")){
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm8s2").apply();
            } else if (Objects.equals(sev, "4.SINIFbölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm8s3").apply();
            } else if (Objects.equals(sev, "4.SINIFbölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm8s4").apply();
            } else if (Objects.equals(sev, "4.SINIFbölüm8s4")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "4.SINIFbölüm9s1")){
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm9s2").apply();
            }else if (Objects.equals(sev, "4.SINIFbölüm9s2")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "4.SINIFbölüm10s1")){
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm10s2").apply();
            } else if (Objects.equals(sev, "4.SINIFbölüm10s2")) {
                sharedPreferences.edit().putString("seviye1","4.SINIFbölüm10s3").apply();
            }else if (Objects.equals(sev, "4.SINIFbölüm10s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 10. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeilkokul.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }




            if(i == 0){
                alertDialog.dismiss();
                Intent intent = new Intent(Kelimeilkokul.this,Kelimeilkokul.class);
                startActivity(intent);
                finish();
            }

        });
        mView.findViewById(R.id.anamenu).setOnClickListener(v -> {
            alertDialog.dismiss();
            Intent intent = new Intent(Kelimeilkokul.this,MainActivity5.class);
            startActivity(intent);
            finish();
        });

        alertDialog.show();
    }

    public void soru() {
        ArrayList<String> i1 = new ArrayList<String>();
        i1.add("boş");
        i1.add(soru1.yanlis);
        i1.add(soru1.yanlis1);
        i1.add(soru1.cevap);
        int sayi, Sorusec[] = new int[4];
        Sorusec[0] = 0;
        for (int i = 0; i < 4; i++) {
            sayi = (int) (Math.random() * 4);
            for (int j = 0; j <= i; j++) {
                if (Sorusec[j] == sayi) {
                    sayi = (int) (Math.random() * 4);
                    j = 0;
                }
            }
            Sorusec[i] = sayi;
        }
        for (int j = 0; j < 4; j++) {
            if (j == 1) {
                s1 = i1.get(Sorusec[j]);
            }
            if (j == 2) {
                s2 = i1.get(Sorusec[j]);
            }
            if (j == 3) {
                s3 = i1.get(Sorusec[j]);
            }
        }
        button1.setText(s1.toLowerCase());
        button2.setText(s2.toLowerCase());
        button3.setText(s3.toLowerCase());
        textView.setText(soru1.soru.toLowerCase());
    }
    public void ses(){
        textToSpeech.speak(soru1.soru,TextToSpeech.QUEUE_FLUSH,null,null);
    }
    public void sure() {
        if (Objects.equals(saat, "süresiz")){
            ses();
        }
        else {
            cur += 500;
            progressBar.setProgress(cur);
            handler = new Handler();
            runnable = new Runnable() {
                @Override
                public void run() {
                    cur -= 1;
                    progressBar.setProgress(cur);
                    if (cur == 480){
                        ses();
                    }
                    handler.postDelayed(this, 2);
                    if (cur == 0) {
                        handler.removeCallbacks(runnable);
                        sorudegistirme();
                        sorusay++;
                        reklam++;
                    }
                }
            };
            handler.post(runnable);
        }
    }
    public void dogruc(){
        cevap1 = button1.getText().toString().toLowerCase();
        cevap2 = button2.getText().toString().toLowerCase();
        cevap3 = button3.getText().toString().toLowerCase();
        dogru = soru1.cevap.toLowerCase();
        run = 0;
        handler1 = new Handler();
        runnable1 = new Runnable(){
            @Override
            public void run() {
                if (Objects.equals(dogru, cevap1)){
                    button1.setBackgroundResource(R.drawable.d);
                }else if (Objects.equals(dogru, cevap2)){
                    button2.setBackgroundResource(R.drawable.d);
                }else if (Objects.equals(dogru, cevap3)){
                    button3.setBackgroundResource(R.drawable.d);
                }
                run++;
                handler1.postDelayed(this, 1000);
                if(run == 2) {
                    System.out.println("DOGRU SONUC ÇALIŞTI");
                    System.out.println("dogru sonuc run :"+run);
                    handler1.removeCallbacks(runnable1);
                    if (Objects.equals(saat, "süreli")){
                        handler.removeCallbacks(runnable);
                    }
                    sorudegistirme();

                }
            }
        };
        handler1.post(runnable1);
    }

    public void sorudegis(){
        button1.setBackgroundResource(R.drawable.soru);
        button2.setBackgroundResource(R.drawable.soru);
        button3.setBackgroundResource(R.drawable.soru);
        if (kacsoru == 1){
            imageView.setImageResource(R.drawable.bir);

        }if (kacsoru == 2){
            imageView.setImageResource(R.drawable.iki);

        }if (kacsoru == 3){
            imageView.setImageResource(R.drawable.uc);

        }if (kacsoru == 4){
            imageView.setImageResource(R.drawable.dort);

        }if (kacsoru == 5){
            imageView.setImageResource(R.drawable.bes);

        }if (kacsoru == 6){
            imageView.setImageResource(R.drawable.alti);

        }if (kacsoru == 7){
            imageView.setImageResource(R.drawable.yedi);

        }if (kacsoru == 8){
            imageView.setImageResource(R.drawable.sekiz);

        }if (kacsoru == 9){
            imageView.setImageResource(R.drawable.dokuz);

        }if (kacsoru == 10){
            imageView.setImageResource(R.drawable.on);

        }
    }

    public void sorudegistirme() {
        // Random Kelime //

        Random random = new Random();
        yanlis = random.nextInt(yanlislar2.length);
        Random random1 = new Random();
        yanlis1 = random1.nextInt(yanlislar1.length);
        String yanlislar3 = yanlislar1[yanlis1];
        String yanlislar4 = yanlislar2[yanlis];
        kacsoru++;
        /////////////////////////////////////////
        if (sorusay == 10) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(Kelimeilkokul.this);
                }
            ShowDialogBox();
            if (sev.contains("2.SINIFbölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='2.SINIFbölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='2.SINIFbölüm1'");
            }
            if (sev.contains("2.SINIFbölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='2.SINIFbölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='2.SINIFbölüm2'");
            }
            if (sev.contains("2.SINIFbölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='2.SINIFbölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='2.SINIFbölüm3'");
            }
            if (sev.contains("2.SINIFbölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='2.SINIFbölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='2.SINIFbölüm4'");
            }
            if (sev.contains("2.SINIFbölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='2.SINIFbölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='2.SINIFbölüm5'");
            }
            if (sev.contains("2.SINIFbölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='2.SINIFbölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='2.SINIFbölüm6'");
            }
            if (sev.contains("2.SINIFbölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='2.SINIFbölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='2.SINIFbölüm7'");
            }
            if (sev.contains("2.SINIFbölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='2.SINIFbölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='2.SINIFbölüm8'");
            }
            if (sev.contains("2.SINIFbölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='2.SINIFbölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='2.SINIFbölüm9'");
            }
            if (sev.contains("2.SINIFbölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='2.SINIFbölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='2.SINIFbölüm10'");
            }
            if (sev.contains("3.SINIFbölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='3.SINIFbölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='3.SINIFbölüm1'");
            }
            if (sev.contains("3.SINIFbölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='3.SINIFbölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='3.SINIFbölüm2'");
            }
            if (sev.contains("3.SINIFbölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='3.SINIFbölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='3.SINIFbölüm3'");
            }
            if (sev.contains("3.SINIFbölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='3.SINIFbölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='3.SINIFbölüm4'");
            }
            if (sev.contains("3.SINIFbölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='3.SINIFbölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='3.SINIFbölüm5'");
            }
            if (sev.contains("3.SINIFbölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='3.SINIFbölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='3.SINIFbölüm6'");
            }
            if (sev.contains("3.SINIFbölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='3.SINIFbölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='3.SINIFbölüm7'");
            }
            if (sev.contains("3.SINIFbölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='3.SINIFbölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='3.SINIFbölüm8'");
            }
            if (sev.contains("3.SINIFbölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='3.SINIFbölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='3.SINIFbölüm9'");
            }
            if (sev.contains("3.SINIFbölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='3.SINIFbölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='3.SINIFbölüm10'");
            }
            if (sev.contains("4.SINIFbölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='4.SINIFbölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='4.SINIFbölüm1'");
            }
            if (sev.contains("4.SINIFbölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='4.SINIFbölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='4.SINIFbölüm2'");
            }
            if (sev.contains("4.SINIFbölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='4.SINIFbölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='4.SINIFbölüm3'");
            }
            if (sev.contains("4.SINIFbölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='4.SINIFbölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='4.SINIFbölüm4'");
            }
            if (sev.contains("4.SINIFbölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='4.SINIFbölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='4.SINIFbölüm5'");
            }
            if (sev.contains("4.SINIFbölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='4.SINIFbölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='4.SINIFbölüm6'");
            }
            if (sev.contains("4.SINIFbölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='4.SINIFbölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='4.SINIFbölüm7'");
            }
            if (sev.contains("4.SINIFbölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='4.SINIFbölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='4.SINIFbölüm8'");
            }
            if (sev.contains("4.SINIFbölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='4.SINIFbölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='4.SINIFbölüm9'");
            }
            if (sev.contains("4.SINIFbölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='4.SINIFbölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='4.SINIFbölüm10'");
            }
            database.execSQL("UPDATE P SET puan=puan+" + sorudogru * 2 + "");


            if (sev.equals("2.SINIFbölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("2.SINIFbölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("2.SINIFbölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("2.SINIFbölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("2.SINIFbölüm9s3yildiz", "2").apply();
                }
            }
            // 3. sınıf
            if (sev.equals("3.SINIFbölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm3s3yildiz", "2").apply();
                }
            }

            if (sev.equals("3.SINIFbölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("3.SINIFbölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("3.SINIFbölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("3.SINIFbölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("3.SINIFbölüm9s3yildiz", "2").apply();
                }
            }

            // 4. SINIF
            if (sev.equals("4.SINIFbölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("4.SINIFbölüm10s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("4.SINIFbölüm10s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("4.SINIFbölüm10s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("4.SINIFbölüm10s1yildiz", "2").apply();
                }
            }




            // SORU EKRANI

        } else if (Objects.equals(sev, "2.SINIFbölüm1s1")) {
            soru1 = new Soru(ilkokul2bolum1s1[sorusay], ilkokul2bolum1c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();

        }else if (Objects.equals(sev, "2.SINIFbölüm1s2")){
            soru1 = new Soru(ilkokul2bolum1s2[sorusay], ilkokul2bolum1c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm1s3")){
            soru1 = new Soru(ilkokul2bolum1s3[sorusay], ilkokul2bolum1c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev,"2.SINIFbölüm2s1")){
            soru1 = new Soru(ilkokul2bolum2s1[sorusay], ilkokul2bolum2c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm2s2")){
            soru1 = new Soru(ilkokul2bolum2s2[sorusay], ilkokul2bolum2c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm3s1")){
            soru1 = new Soru(ilkokul2bolum3s1[sorusay], ilkokul2bolum3c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm3s2")){
            soru1 = new Soru(ilkokul2bolum3s2[sorusay], ilkokul2bolum3c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm3s3")){
            soru1 = new Soru(ilkokul2bolum3s3[sorusay], ilkokul2bolum3c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm3s4")){
            soru1 = new Soru(ilkokul2bolum3s4[sorusay], ilkokul2bolum3c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm4s1")){
            soru1 = new Soru(ilkokul2bolum4s1[sorusay], ilkokul2bolum4c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm4s2")){
            soru1 = new Soru(ilkokul2bolum4s2[sorusay], ilkokul2bolum4c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm5s1")){
            soru1 = new Soru(ilkokul2bolum5s1[sorusay], ilkokul2bolum5c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm5s2")){
            soru1 = new Soru(ilkokul2bolum5s2[sorusay],ilkokul2bolum5c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();

        }else if (Objects.equals(sev, "2.SINIFbölüm6s1")){
            soru1 = new Soru(ilkokul2bolum6s1[sorusay], ilkokul2bolum6c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm6s2")){
            soru1 = new Soru(ilkokul2bolum6s2[sorusay], ilkokul2bolum6c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm7s1")){
            soru1 = new Soru(ilkokul2bolum7s1[sorusay], ilkokul2bolum7c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm7s2")){
            soru1 = new Soru(ilkokul2bolum7s2[sorusay], ilkokul2bolum7c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm8s1")){
            soru1 = new Soru(ilkokul2bolum8s1[sorusay], ilkokul2bolum8c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm8s2")){
            soru1 = new Soru(ilkokul2bolum8s2[sorusay], ilkokul2bolum8c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();

        }else if (Objects.equals(sev, "2.SINIFbölüm9s1")){
            soru1 = new Soru(ilkokul2bolum9s1[sorusay], ilkokul2bolum9c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm9s2")){
            soru1 = new Soru(ilkokul2bolum9s2[sorusay], ilkokul2bolum9c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm9s3")){
            soru1 = new Soru(ilkokul2bolum9s3[sorusay], ilkokul2bolum9c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm10s1")){
            soru1 = new Soru(ilkokul2bolum10s1[sorusay], ilkokul2bolum10c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "2.SINIFbölüm10s2")){
            soru1 = new Soru(ilkokul2bolum10s2[sorusay], ilkokul2bolum10c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();

        }else if (Objects.equals(sev, "3.SINIFbölüm1s1")){
        soru1 = new Soru(ilkokul3bolum1s1[sorusay], ilkokul3bolum1c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm1s2")){
        soru1 = new Soru(ilkokul3bolum1s2[sorusay], ilkokul3bolum1c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm1s3")){
        soru1 = new Soru(ilkokul3bolum1s3[sorusay], ilkokul3bolum1c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm1s4")){
        soru1 = new Soru(ilkokul3bolum1s4[sorusay], ilkokul3bolum1c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "3.SINIFbölüm2s1")){
        soru1 = new Soru(ilkokul3bolum2s1[sorusay], ilkokul3bolum2c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm2s2")){
        soru1 = new Soru(ilkokul3bolum2s2[sorusay], ilkokul3bolum2c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm2s3")){
        soru1 = new Soru(ilkokul3bolum2s3[sorusay], ilkokul3bolum2c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm2s4")){
        soru1 = new Soru(ilkokul3bolum2s4[sorusay], ilkokul3bolum2c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "3.SINIFbölüm3s1")){
        soru1 = new Soru(ilkokul3bolum3s1[sorusay], ilkokul3bolum3c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm3s2")){
        soru1 = new Soru(ilkokul3bolum3s2[sorusay], ilkokul3bolum3c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm3s3")){
        soru1 = new Soru(ilkokul3bolum3s3[sorusay], ilkokul3bolum3c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "3.SINIFbölüm4s1")){
        soru1 = new Soru(ilkokul3bolum4s1[sorusay], ilkokul3bolum4c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm4s2")){
        soru1 = new Soru(ilkokul3bolum4s2[sorusay], ilkokul3bolum4c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "3.SINIFbölüm5s1")){
        soru1 = new Soru(ilkokul3bolum5s1[sorusay], ilkokul3bolum5c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm5s2")){
        soru1 = new Soru(ilkokul3bolum5s2[sorusay], ilkokul3bolum5c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "3.SINIFbölüm6s1")){
        soru1 = new Soru(ilkokul3bolum6s1[sorusay], ilkokul3bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm6s2")){
        soru1 = new Soru(ilkokul3bolum6s2[sorusay], ilkokul3bolum6c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm6s3")){
        soru1 = new Soru(ilkokul3bolum6s3[sorusay], ilkokul3bolum6c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "3.SINIFbölüm7s1")){
        soru1 = new Soru(ilkokul3bolum7s1[sorusay], ilkokul3bolum7c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm7s2")){
        soru1 = new Soru(ilkokul3bolum7s2[sorusay], ilkokul3bolum7c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm7s3")){
        soru1 = new Soru(ilkokul3bolum7s3[sorusay], ilkokul3bolum7c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "3.SINIFbölüm8s1")){
        soru1 = new Soru(ilkokul3bolum8s1[sorusay], ilkokul3bolum8c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm8s2")){
        soru1 = new Soru(ilkokul3bolum8s2[sorusay], ilkokul3bolum8c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm8s3")){
        soru1 = new Soru(ilkokul3bolum8s3[sorusay],ilkokul3bolum8c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm8s4")){
        soru1 = new Soru(ilkokul3bolum8s4[sorusay], ilkokul3bolum8c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "3.SINIFbölüm9s1")){
        soru1 = new Soru(ilkokul3bolum9s1[sorusay], ilkokul3bolum9c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm9s2")){
        soru1 = new Soru(ilkokul3bolum9s2[sorusay], ilkokul3bolum9c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm9s3")){
        soru1 = new Soru(ilkokul3bolum9s3[sorusay], ilkokul3bolum9c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "3.SINIFbölüm10s1")){
        soru1 = new Soru(ilkokul3bolum10s1[sorusay], ilkokul3bolum10c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm10s2")){
        soru1 = new Soru(ilkokul3bolum10s2[sorusay], ilkokul3bolum10c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "3.SINIFbölüm10s3")){
        soru1 = new Soru(ilkokul3bolum10s3[sorusay], ilkokul3bolum10c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        // 4. SINIF



        }else if (Objects.equals(sev, "4.SINIFbölüm1s1")){
        soru1 = new Soru(ilkokul4bolum1s1[sorusay], ilkokul4bolum1c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm1s2")){
        soru1 = new Soru(ilkokul4bolum1s2[sorusay], ilkokul4bolum1c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm1s3")){
        soru1 = new Soru(ilkokul4bolum1s3[sorusay], ilkokul4bolum1c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "4.SINIFbölüm2s1")){
        soru1 = new Soru(ilkokul4bolum2s1[sorusay], ilkokul4bolum2c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm2s2")){
        soru1 = new Soru(ilkokul4bolum2s2[sorusay], ilkokul4bolum2c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm2s3")){
        soru1 = new Soru(ilkokul4bolum2s3[sorusay], ilkokul4bolum2c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "4.SINIFbölüm3s1")){
        soru1 = new Soru(ilkokul4bolum3s1[sorusay], ilkokul4bolum3c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm3s2")){
        soru1 = new Soru(ilkokul4bolum3s2[sorusay],ilkokul4bolum3c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm3s3")){
        soru1 = new Soru(ilkokul4bolum3s3[sorusay], ilkokul4bolum3c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "4.SINIFbölüm4s1")){
        soru1 = new Soru(ilkokul4bolum4s1[sorusay], ilkokul4bolum4c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm4s2")){
        soru1 = new Soru(ilkokul4bolum4s2[sorusay], ilkokul4bolum4c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm4s3")){
        soru1 = new Soru(ilkokul4bolum4s3[sorusay], ilkokul4bolum4c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "4.SINIFbölüm5s1")){
        soru1 = new Soru(ilkokul4bolum5s1[sorusay], ilkokul4bolum5c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm5s2")){
        soru1 = new Soru(ilkokul4bolum5s2[sorusay], ilkokul4bolum5c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm5s3")){
        soru1 = new Soru(ilkokul4bolum5s3[sorusay], ilkokul4bolum5c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "4.SINIFbölüm6s1")){
        soru1 = new Soru(ilkokul4bolum6s1[sorusay], ilkokul4bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm6s2")){
        soru1 = new Soru(ilkokul4bolum6s2[sorusay], ilkokul4bolum6c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm6s3")){
        soru1 = new Soru(ilkokul4bolum6s3[sorusay], ilkokul4bolum6c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "4.SINIFbölüm7s1")){
        soru1 = new Soru(ilkokul4bolum7s1[sorusay], ilkokul4bolum7c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm7s2")){
        soru1 = new Soru(ilkokul4bolum7s2[sorusay], ilkokul4bolum7c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm7s3")){
        soru1 = new Soru(ilkokul4bolum7s3[sorusay], ilkokul4bolum7c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "4.SINIFbölüm8s1")){
        soru1 = new Soru(ilkokul4bolum8s1[sorusay], ilkokul4bolum8c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm8s2")){
        soru1 = new Soru(ilkokul4bolum8s2[sorusay], ilkokul4bolum8c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm8s3")){
        soru1 = new Soru(ilkokul4bolum8s3[sorusay], ilkokul4bolum8c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm8s4")){
        soru1 = new Soru(ilkokul4bolum8s4[sorusay], ilkokul4bolum8c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "4.SINIFbölüm9s1")){
        soru1 = new Soru(ilkokul4bolum9s1[sorusay], ilkokul4bolum9c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm9s2")){
        soru1 = new Soru(ilkokul4bolum9s2[sorusay], ilkokul4bolum9c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "4.SINIFbölüm10s1")){
        soru1 = new Soru(ilkokul4bolum10s1[sorusay], ilkokul4bolum10c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm10s2")){
        soru1 = new Soru(ilkokul4bolum10s2[sorusay], ilkokul4bolum10c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "4.SINIFbölüm10s3")){
        soru1 = new Soru(ilkokul4bolum10s3[sorusay], ilkokul4bolum10c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }





        }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            finish();
        }

        return super.onKeyDown(keyCode, event);
    }
    }
