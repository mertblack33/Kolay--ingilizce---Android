package com.mert.kolayingilizce.ortaokul;

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
import com.mert.kolayingilizce.a1a2.kelime;
import com.mert.kolayingilizce.c1c2.kelime3;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class Kelimeortaokul extends AppCompatActivity {
    /// DATA

    // 5 . SINIF

    // 1. bölüm
    String [] ortaokul5bolum1s1 = {"English","Turkish","Maths","Science","Social Studies","Art","Music","Physical Education (P.E)","Drama","Religion and Morals"};
    String [] ortaokul5bolum1s2 = {"Computer","History","Geography","French","German","Spanish","ICT","on Sunday","on Monday","on Tuesday"};
    String [] ortaokul5bolum1s3 = {"on Wednesday","on Thursday","on Friday","on Saturday","am/is/are bad at","am/is/are good at","dislike","hate","like/love/enjoy","learn language"};
    String [] ortaokul5bolum1s4 = {"play","solving problem","speak","study","How many","How old","Which","When","Where","Who"};
    String [] ortaokul5bolum1s5 = {"age","at 5th grade","at 6th grade","at 7th grade","at 8th grade","at middle school","at primary school","at secondary school","best friend","class"};

    String [] ortaokul5bolum1c1 = {"İngilizce"," Türkçe","Matematik","Fen Bilgisi","Sosyal Bilgiler","Resim","Müzik","Beden Eğ.","Tiyatro","DinKül.ve A.B."};
    String [] ortaokul5bolum1c2 = {"Bilgisayar","Tarih","Coğrafya"," Fransızca","Almanca","İspanyolca","Bilişim Teknolojileri"," Pazar","Pazartesi","Salı"};
    String [] ortaokul5bolum1c3 = {"Çarşamba"," Perşembe","Cuma","Cumartesi","(bir şeyde) kötü olmak","(bir şeyde) iyi olmak","sevmemek","nefret etmek","sevmek","dil öğrenmek"};
    String [] ortaokul5bolum1c4 = {"çalmak (enstrüman)","problem çözmek","konuşmak"," (okulda) okumak","Kaç tane?"," Kaç yaşında?","Hangi?"," Ne zaman?","Nerede, nereye?","Kim?"};
    String [] ortaokul5bolum1c5 = {"yaş"," 5. Sınıfta","6. Sınıfta","7. Sınıfta","8. Sınıfta","ortaokulda","ilkokulda","ortaokulda"," en iyi arkadaş","sınıf, ders"};

    // 2 . bölüm

    String [] ortaokul5bolum2s1 = {"behind","between","in front of","near","next to","on the left","on the right","on","opposite","under"};
    String [] ortaokul5bolum2s2 = {"go straight ahead","it is on the left","it is on the right","take the first right","take the second left","turn left","turn right","are there","excuse me","hi"};
    String [] ortaokul5bolum2s3 = {"I’m sorry","is there","not at all","see you","thank you","there are","there is","where","you are welcome","bakery"};
    String [] ortaokul5bolum2s4 = {"bank","barber’s","bookshop","bridge","bus station","bus stop","butcher","chemist’s","florist","gren grocer"};
    String [] ortaokul5bolum2s5 = {"grocery","hospital","house","library","mosque","museum","neighbourhood","pharmacy","playground","police station"};



    String [] ortaokul5bolum2c1 = {"arkasında","arasında","önünde","yanında","bitişiğinde","solda","sağda","üstünde","karşısında","altında"};
    String [] ortaokul5bolum2c2 = {"düz git","solda","sağda","ilk sağa dön","ilk sola dön","sola dön","sağa dön","var mı?","afedersiniz","merhaba, selam"};
    String [] ortaokul5bolum2c3 = {"üzgünüm","var mı?","bir şey değil, önemli değil","görüşürüz"," teşekkür ederim","var","var","nerede","rica ederim","fırın"};
    String [] ortaokul5bolum2c4 = {" banka","berber","kitapçı","köprü"," terminal","otobüs durağı","kasap","eczane","çiçekçi","manav"};
    String [] ortaokul5bolum2c5 = {"bakkal, market","hastane"," ev","kütüphane","cami","müze","mahalle","eczane","oyun alanı, park","karakol"};



    // 3. bölüm


    String [] ortaokul5bolum3s1 = {"play football","listen to music","read book","do puzzle","swing","paint","run","run fast","walk","eat"};
    String [] ortaokul5bolum3s2 = {"help","help me","want","learn","find","play marbles","play tag","draw","draw a picture","watch"};
    String [] ortaokul5bolum3s3 = {"take photos","like","love","live","play","game","outdoor games","blind mans’s buff","hide and seek","dodge ball"};
    String [] ortaokul5bolum3s4 = {"skipping rope","see saw","hopscotch","hula hop","board games","puzzle","backgommon","jigsaw puzzle","checkers","taboo"};
    String [] ortaokul5bolum3s5 = {"chess","hangman","scrabble","origami","cartoon","free time","leisure time","spare time","with","that’s"};



    String [] ortaokul5bolum3c1 = {"futbol oynamak","müzik dinlemek","kitap okumak","yapboz yapmak"," (salıncakta) sallanmak","boyamak","koşmak","hızlı koşmak"," yürümek","yemek"};
    String [] ortaokul5bolum3c2 = {"yardım etmek","bana yardım et","istemek","öğrenmek","bulmak","misket oynamak","ebelemece (elim sende) oynamak","çizmek","resim çizmek"," izlemek"};
    String [] ortaokul5bolum3c3 = {"fotoğraf çekmek","sevmek","sevmek","yaşamak","oynamak","oyun","dışarı oyunları","körebe","saklambaç","yakan top"};
    String [] ortaokul5bolum3c4 = {"ip atlamak","tahteravalli"," sek sek","bele takılıp çevirilen çember","masa başı – tahta oyunları","yapboz","tavla","bulmaca","dama","tabu"};
    String [] ortaokul5bolum3c5 = {"satranç","adam asmacaa","kelime oyunu"," kağıt katlama","çizgi film","boş zaman","boş zaman","boş zaman","ile","bu"};



    // 4. bölüm



    String [] ortaokul5bolum4s1 = {"answer the questions","arrive at school","arrive home","ask question","brush teeth","buy","clean","climb","comb hair","come back home"};
    String [] ortaokul5bolum4s2 = {"cook meal","do homework","do shopping","do","draw pictures","drink","drive","eat","feel","finish"};
    String [] ortaokul5bolum4s3 = {"get dressed","get home","get on the bus","get out of the bed","get up early","go by bike","go online","go out","go shopping","go to bed"};
    String [] ortaokul5bolum4s4 = {"go to school by school bus","go to school on foot","go","have a bath","have a rest","have a shower","have a snack","have breakfast","have classes","have dinner"};
    String [] ortaokul5bolum4s5 = {"have lunch","hear","help mother","learn","leave home","leave school","listen to","live","make","meet friends"};
    String [] ortaokul5bolum4s6 = {"need","play game","play instrument","play soccer","prefer","read book","read newspaper","ride bike","ride horse","say"};



    String [] ortaokul5bolum4c1 = {" soruları cevaplamak","okula varmak","eve varmak","soru sormak","diş fırçalamak","satın almak","temizlemek"," tırmanmak","saç taramak","eve dönmek"};
    String [] ortaokul5bolum4c2 = {" yemek pişirmek"," ödev apmak","alışveriş yapmak","yapmak","resim çizmek","içmek","araba sürmek","yemek"," hissetmek","bitirmek"};
    String [] ortaokul5bolum4c3 = {"giyinmek","eve varmak","otobüse binmek","yataktan kalkmak","erken kalkmak, erken uyanmak","bisikletle gitmek","internete girmek","dışarı çıkmak","alışverişe gitmek","yatmak"};
    String [] ortaokul5bolum4c4 = {"okula servisle gitmek","okula yürüyerek gitmek","gitmek","banyo yapmak","dinlenmek","duş almak","atıştırmak","kahvaltı yapmak"," derse girmek, dersi olmak"," akşam yemeği yemek"};
    String [] ortaokul5bolum4c5 = {"öğle yemeği yemek","duymak","anneye yardım etmek","öğrenmek","evden çıkmak"," okuldan çıkmak","dinlemek","yaşamak","yapmak","arkadaşlarla buluşmak"};
    String [] ortaokul5bolum4c6 = {"ihtiyaç duymak","oyun oynamak","enstrüman çalmak","futbol oynamak"," tercih etmek"," kitap okumak","gazete okumak"," bisiklet sürmek"," ata binmek","söylemek"};


    // 5. bölüm



    String [] ortaokul5bolum5s1 = {"arm","backache","bend","blanket","broken arm","broken leg","buy","candy","carry","clap"};
    String [] ortaokul5bolum5s2 = {"clinic","cold","cough","ear","eye","faint","feel","fever","flu","fruit and vegetable"};
    String [] ortaokul5bolum5s3 = {"hand","have a rest","head","headache","health","healthy","heavy","hot water bottle","hurt","ice bag"};
    String [] ortaokul5bolum5s4 = {"ill","illness","immediately","knee","measles","medicine","mint","mint and lemon tea","mouth","neck"};
    String [] ortaokul5bolum5s5 = {"need","nose","pain","pill","plaster","point","rest","runny nose","shoulder","shrug"};
    String [] ortaokul5bolum5s6 = {"sneeze","sore throat","stomach","stomachache","sweet","syrup","terrible","thermometer","throat","tired"};



    String [] ortaokul5bolum5c1 = {"kol","sırt ağrısı","bükmek,eğmek","battaniye","kırık kol","kırık bacak","satın almak","şeker","taşımak","alkışlamak, el çırpmak"};
    String [] ortaokul5bolum5c2 = {"klinik, muayenehane","soğuk algınlığı, üşüme","öksürük","kulak","göz","bayılmak, bitkin düşmek","hissetmek","ateş","grip","meyve sebze"};
    String [] ortaokul5bolum5c3 = {"klinik, muayenehane","soğuk algınlığı, üşüme","öksürük","kulak","göz","bayılmak, bitkin düşmek","hissetmek","ateş","grip","meyve sebze"};
    String [] ortaokul5bolum5c4 = {"hasta","hastalık","hemen","diz","kızamık","ilaç","nane","nane limon çayı","ağız","boyun"};
    String [] ortaokul5bolum5c5 = {"ihtiyaç duymak","burun","ağrı, sızı, acı","hap","yara bandı","göstermek, işaret etmek","dinlenmek","burun akıntısı","omuz","omuz silkmek"};
    String [] ortaokul5bolum5c6 = {"hapşırmak","boğaz ağrısı","karın","karın ağrısı","tatlı","şurup","berbat, korkunç","termometre","boğaz","yorgun"};



    //6. bölüm


    String [] ortaokul5bolum6s1 = {"action","adventure","animation","bad","beautiful","bored","boring","brave","cartoon","choose"};
    String [] ortaokul5bolum6s2 = {"clever","comedy","control","coward","crime","do magic","drama","emotion","evil","exciting"};
    String [] ortaokul5bolum6s3 = {"fairy tale","fantastic","fantasy","friendly","frightening","funny","good","hardworking","helpful","honest"};
    String [] ortaokul5bolum6s4 = {"honesty","horror","interesting","island","kind","lazy","lift up","movie","movie theater","power"};
    String [] ortaokul5bolum6s5 = {"rude","save","scary","science fiction","smart","special","spy","strong","tell lie","ugly"};



    String [] ortaokul5bolum6c1 = {"aksiyon","macera","animasyon","kötü","güzel","sıkılmış","sıkıcı","cesur","çizgi film","seçmek"};
    String [] ortaokul5bolum6c2 = {"zeki","komedi","denetlemek, kontrol etmek","korkak","suç","büyü/sihir yapmak","dram","duygu","kötü, fena","heyecan verici"};
    String [] ortaokul5bolum6c3 = {"peri masalı","şahane","kurgu","arkadaş canlısı","korkutucu","eğlenceli, komik","iyi","çalışkan","yardımsever","dürüst"};
    String [] ortaokul5bolum6c4 = {"dürüstlük","korku","ilginç","ada","nazik","tembel","yukarı kaldırmak","film","sinema","güç"};
    String [] ortaokul5bolum6c5 = {"kaba","kurtarmak","korkunç","bilim kurgu","zeki","özel","casus, casusluk yapmak","güçlü","yalan söylemek","çirkin"};


    // 7. bölüm


    String [] ortaokul5bolum7s1 = {"balloon","beverage","birthday party","buy","cake","call","candle","celebration","clothes","clown"};
    String [] ortaokul5bolum7s2 = {"come","confetti","cookie","decorate","decoration","dream","drink","excited","garden","gift"};
    String [] ortaokul5bolum7s3 = {"give","invitation","invitation card","invite","join","mobile phone","music band","need","order","party hat"};

    String [] ortaokul5bolum7c1 = {"balon","içecek","doğum günü partisi","satın almak","kek, pasta","telefonla aramak, seslenmek, çağırmak","mum","kutlama","giysi","palyaço"};
    String [] ortaokul5bolum7c2 = {"gelmek","konfeti","kurabiye","süslemek, dekore etmek","süsleme, dekorasyon","rüya(görmek), hayal(kurmak)","içmek","heyecanlı","bahçe","hediye"};
    String [] ortaokul5bolum7c3 = {"vermek","davet","davetiye","davet etmek","katılmak","cep telefonu","müzik grubu","ihtiyaç duymak","sipariş vermek","parti şapkası"};


    // 6 . SINIF


    // 1. bölüm


    String [] ortaokul6bolum1s1 = {"date","leave","lesson","start","finish","attend a course","get up","busy","arrive","get dressed"};
    String [] ortaokul6bolum1s2 = {"wake up","take care of the flowers","take a nap","run errands","study","have breakfast","weekday","weekend","have lunch","have dinner"};
    String [] ortaokul6bolum1s3 = {"visit relatives","visit grandparents","visit","play games","go to school","do homework","parent","do sports","invitation card","wedding ceremony"};
    String [] ortaokul6bolum1s4 = {"ticket","traditional","rest","have a rest","ride a bike/bicycle","do the ironing","walk","wash the clothes","take care of the plants","take care of the pet"};
    String [] ortaokul6bolum1s5 = {"meet friends","do cleaning","watch TV","take the dog for a walk","go to bed","write diary","Children’s Day","New Year’s Day","The Republic Day","Victory Day"};


    String [] ortaokul6bolum1c1 = {"tarih","ayrılmak","ders","başlamak","bitmek","kursa katılmak","yataktan kalkmak","meşgul, yoğun","varmak","giyinmek"};
    String [] ortaokul6bolum1c2 = {"uyanmak","çiçeklerle ilgilenmek","kestirmek, şekerleme yapmak","getir götür işleri yapmak","ders çalışmak","kahvaltı yapmak","hafta içi","hafta sonu","öğle yemeği yemek","akşam yemeği yemek"};
    String [] ortaokul6bolum1c3 = {"akrabaları ziyaret etmek","büyükanne/büyükbabayı ziyaret etmek","ziyaret etmek","oyun oynamak","okula gitmek","ödev yapmak","ebeveyn","spor yapmak","davetiye","nikah töreni, evlenme merasimi"};
    String [] ortaokul6bolum1c4 = {"bilet","geleneksel","dinlenmek","dinlenmek","bisiklet sürmek","ütü yapmak","yürümek","çamaşır yıkamak","bitkilerle ilgilenmek","evcil hayvanla ilgilenmek"};
    String [] ortaokul6bolum1c5 = {"arkadaşlarla buluşmak","temizlik yapmak","televizyon izlemek","köpeği gezdirmek","yatmak","günlük yazmak","Çocuk Bayramı","yılbaşı günü","Cumhuriyet Bayramı","Zafer Bayramı"};

    // 2 . bölüm

    String [] ortaokul6bolum2s1 = {"a bar of","apple juice","bagel","bean","boiled egg","bread","breakfast","butter","cacao","cereal"};
    String [] ortaokul6bolum2s2 = {"cheese","chef","chips","coconut","coffee","croissant","cucumber","drink","eat","egg"};
    String [] ortaokul6bolum2s3 = {"favourite","food","fruit","fruit juice","guest","habit","healthy","honey","jam","join"};
    String [] ortaokul6bolum2s4 = {"junk food","lemonade","milk","muffin","mushroom","nutrition facts","nutritious","olive","omelette","orange juice"};
    String [] ortaokul6bolum2s5 = {"pancake","pastrami","salami","sausage","sugar","tea","toast","tomato","traditional","unhealthy"};

    String [] ortaokul6bolum2c1 = {"bir kalıp, bir parça","elma suyu","simit","fasulye","haşlanmış yumurta","ekmek","kahvaltı","tereyağı, margarin","kakao","mısır gevreği"};
    String [] ortaokul6bolum2c2 = {"peynir","şef, aşçıbaşı","patates kızartması","hindistan cevizi","kahve","kruvasan","salatalık","içecek, içmek","yemek(fiil)","yumurta"};
    String [] ortaokul6bolum2c3 = {"favori","yiyecek","meyve suyu","meyve suyu","misafir","alışkanlık","sağlıklı","bal","reçel","katılmak"};
    String [] ortaokul6bolum2c4 = {"abur cubur","limonata","süt","çörek, kek","mantar","besin değerleri","besleyici","zeytin","omlet","portakal suyu"};
    String [] ortaokul6bolum2c5 = {"krep","pastırma","salam","sosis","şeker","çay","tost","domates","geleneksel","sağlıksız"};


    // 3. bölüm


    String [] ortaokul6bolum3s1 = {"barbeque","beautiful","big","boring","building","busy","cheap","city","clean","cold"};
    String [] ortaokul6bolum3s2 = {"comfortable","country","crowded","downtown","enjoyable","exciting","expensive","farm","fast","fat"};
    String [] ortaokul6bolum3s3 = {"feed","flat","happy","healthy","heavy","high","hot","interesting","kiosk","knit"};
    String [] ortaokul6bolum3s4 = {"large","life","long","make a cake","need","noisy","nutritious","old","peaceful","prepare"};
    String [] ortaokul6bolum3s5 = {"quiet","relaxing","rent","rest","rollerblade","sad","sell","set the table","shopping center","short"};
    String [] ortaokul6bolum3s6 = {"skyscraper","slim","slow","small","street","strong","study","take a nap","take care of","talk"};



    String [] ortaokul6bolum3c1 = {"mangal","güzel","büyü","sıkıcı","bina","yoğun, meşgul","ucuz","şehir","temiz, temizlemek","soğuk"};
    String [] ortaokul6bolum3c2 = {"konforlu","ülke, taşra, kırsal kesim","kalabalık","şehir merkezi","zevkli","heyecan verici","pahaı","çiftik","hızlı","şişman"};
    String [] ortaokul6bolum3c3 = {"beslemek","apartman dairesi","mutlu","sağlıklı","ağır","yüksek","sıcak","ilginç","büfe","örmek"};
    String [] ortaokul6bolum3c4 = {"büyük, geniş","yaşam","uzun","kek yapmak","ihtiyaç duymak","gürültülü","besleyici","yaşlı, eski","huzurlu","hazırlamak"};
    String [] ortaokul6bolum3c5 = {"sessiz,sakin","rahatlatıcı","kiralamak","dinlenmek","paten kayak","üzgün","satmak","masayı kurmak","alışveriş merkezi","kısa"};
    String [] ortaokul6bolum3c6 = {"gökdelen","zayıf","yavaş","küçük","sokak, cadde","güçlü","ders çalışmak","şekerleme yapmak, kestirmek","ilgilenmek","konuşmak"};


    // 4. bölüm



    String [] ortaokul6bolum4s1 = {"above","angry","anxious","cloudy","cold","crowded","degree","depressed","desert","dry"};
    String [] ortaokul6bolum4s2 = {"east","emoticon","emotion","energetic","excited","fabulous","fall/autumn","feel","foggy","freezing"};
    String [] ortaokul6bolum4s3 = {"hailing","happy","hometown","hot","lightning","minus","moody","mountain","need","north"};
    String [] ortaokul6bolum4s4 = {"partly cloudy","penfriend","rainy","repeat","sad","scared","sleepy","small","sound","south"};
    String [] ortaokul6bolum4s5 = {"spring","stormy","summer","sunglasses","sunny","surprised","temperature","thunder","umbrella","upset"};

    String [] ortaokul6bolum4c1 = {"üstünde, yukarıda","sinirli","endişeli","bulutlu","soğuk","kalabalık","derece","canı sıkkın, morali bozuk","çöl","kurak, yağmursuz"};
    String [] ortaokul6bolum4c2 = {"doğu","yüz ifadesi","duygu","enerjik","heyecanlı","olağanüstü, muhteşem","sonbahar","hissetmek","sisli","çok soğuk, buz gibi"};
    String [] ortaokul6bolum4c3 = {"dolu (hava durumu)","mutlu","memleket, mahalle","sıcak","şimşek","eksi","karamsar","dağ","ihtiyaç, ihtiyaç duymak","kuzey"};
    String [] ortaokul6bolum4c4 = {"parçalı bulutlu","mektup arkadaşı","yağmurlu","tekrarlamak","üzgün","korkmuş","uykulu","küçük","ses","güney"};
    String [] ortaokul6bolum4c5 = {"ilkbahar","fırtınalı","yaz","güneş gözlüğü","güneşli","şaşırmış","ısı, sıcaklık","gök gürültüsü","şemsiye","üzgün"};



    // 5. bölüm



    String [] ortaokul6bolum5s1 = {"agree","amazing","bored","boring","bumper car","carnival","carrousel","clown","dangerous","date"};
    String [] ortaokul6bolum5s2 = {"decide","disagree","dull","excited","exciting","fair","fantastic","feel","ferris wheel","frightened"};
    String [] ortaokul6bolum5s3 = {"frightening","fun","fun fair","funny","get on","ghost train","happy","horrible","interesting","laugh"};

    String [] ortaokul6bolum5c1 = {"aynı fikirde olmak","şaşırtıcı, harika","sıkılmış","sıkıcı","çarpışan araba","karnaval,festival","atlı karınca","palyaço","tehlikeli","tarih"};
    String [] ortaokul6bolum5c2 = {"karar vermek","zıt fikirde olmak","sıkıcı","heyecanlanmış","heyecan verici","panayır, fuar","şahane, harika","hissetmek","dönme dolap","korkmuş"};
    String [] ortaokul6bolum5c3 = {"korkutucu","eğlenceli","lunapark","komik, eğlendirici","binmek","korku tüneli treni","mutlu","berbat, kötü","ilgi çekici","gülmek"};


    //6. bölüm


    String [] ortaokul6bolum6s1 = {"actor","architect","artist","bridge","build","building","cook","court","cut","defend"};
    String [] ortaokul6bolum6s2 = {"dentist","design","disease","draw","driver","dye","engineer","examine","fabric","farmer"};
    String [] ortaokul6bolum6s3 = {"grow vegetables","hairdresser","ill","job","lawyer","look after","lorry","make","manager","meal"};
    String [] ortaokul6bolum6s4 = {"mechanic","nurse","occupation","patient","prepare","president","pull out","repair","retired","road"};
    String [] ortaokul6bolum6s5 = {"salesman","saleswoman","scientist","sell","serve","sew","singer","suit","tailor","take order"};

    String [] ortaokul6bolum6c1 = {"erkek oyuncu","mimar","sanatkar, ressam","köprü","inşa etmek","bina, inşaat","aşçı, yemek pişirmek","mahkeme","kesmek","savunmak"};
    String [] ortaokul6bolum6c2 = {"dişçi","tasarlamak","hastalık","çizmek","şoför","boyamak","mühendis","muayene etmek, incelemek","kumaş","çiftçi"};
    String [] ortaokul6bolum6c3 = {"sebze yetiştirmek","kuaför, berber","hastalık","iş, meslek","avukat","ilgilenmek, bakımını üstlenmek","kamyon","yapmak","yönetici, müdür","öğün, yemek"};
    String [] ortaokul6bolum6c4 = {"araba tamircisi","hemşire","meslek, iş","hasta","hazırlamak","başkan","çıkarmak, sökmek","hazırlamak","emekli","yol"};
    String [] ortaokul6bolum6c5 = {"bayan satış elemanı","erkek satış elemanı","bilim insanı","satmak","servis yapmak","dikmek","şarkıcı","takım elbise","terzi","sipariş almak"};

    // 7. bölüm


    String [] ortaokul6bolum7s1 = {"ancient","aquapark","boat trip","brochure","cable car","cuisine","delicious","gardening","excited","famous"};
    String [] ortaokul6bolum7s2 = {"fantastic","fitness centre","forest","holiday","kids club","lake","lakeside","learn","make","meal"};
    String [] ortaokul6bolum7s3 = {"mountain","nature","paragliding","pick","postcard","river","sailing","sandcastle","scuba diving","seaside"};



    String [] ortaokul6bolum7c1 = {"antik, eski","su parkı","tekne turu","broşür","teleferik","yemek pişirme sanatı","lezzetli","bahçecilik","heyecanlı","ünlü"};
    String [] ortaokul6bolum7c2 = {"şahane","spor salonu","orman","tatil","çocuk kulübü","göl","göl kenarı","öğrenmek","yapmak","yiyecek"};
    String [] ortaokul6bolum7c3 = {"dağ","doğa","yamaç paraşütü","toplamak","posta kartı","nehir","yelken sporu","kumdan kale","tüple dalış","deniz kenarı"};

    // 8. bölüm

    String [] ortaokul6bolum8s1 = {"against","amazing","answer","aquarium","assignment","author","behind","between","bookcase","bookshelf"};
    String [] ortaokul6bolum8s2 = {"bookworm","borrow","buy","call","carpet","classmate","clock","darkness","dictionary","drawer"};
    String [] ortaokul6bolum8s3 = {"e-book","enlighten","feel","fireplace","forest","fox","girl","give up","happen","houseplant"};
    String [] ortaokul6bolum8s4 = {"important","in","in front of","information","interesting","invite","keyboard","kiosk","kitten","lake"};
    String [] ortaokul6bolum8s5 = {"lamp","lend","librarian","library","literature","living room","local","location","look at","look for"};
    String [] ortaokul6bolum8s6 = {"look up","magazine","money","mountain","near","newspaper","next to","novel","novelist","object"};



    String [] ortaokul6bolum8c1 = {"karşı","şaşırtıcı, harika, ilginç","cevap vermek, yanıtlamak, cevap","akvaryum","görevlendirme, görev, ödev","yazar","arkasında","arasında","kitaplık","kitap rafı, kitaplık"};
    String [] ortaokul6bolum8c2 = {"kitap kurdu","ödünç almak","satın almak","çağırmak, telefon etmek","halı","sınıf arkadaşı","saat","karanlık","sözlük","çekmece"};
    String [] ortaokul6bolum8c3 = {"elektronik kitap","aydınlatmak, bilgi vermek","hissetmek","şömine","orman","tilki","kız çocuk","bırakmak, vazgeçmek","meydana gelmek, olmak","saksı çiçeği"};
    String [] ortaokul6bolum8c4 = {"önemli","içinde","önünde","bilgi ilginç, ilgi çekici","ilginç, ilgi çekici","davet etmek","klavye","kulübe, büfe","yavru kedi","göl"};
    String [] ortaokul6bolum8c5 = {"lamba","ödünç vermek","kütüphaneci","kütüphane","edebiyat","oturma odası, salon","yerel, yerli","yer, konum, mevki","seyretmek, bakmak","aramak"};
    String [] ortaokul6bolum8c6 = {"sözlükte aramak","dergi ,mecmua","para","dağ","yakınında","gazete","yanında","roman","roman yazarı","nesne, cisim, obje"};


    // 9. bölüm


    String [] ortaokul6bolum9s1 = {"air pollution","amount","atmosphere","attend","battery","carrier bag","classify","crowded","cut down","cycle"};
    String [] ortaokul6bolum9s2 = {"damage","destroy","device","distance","Earth","eco-friendly","enviromental pollution","environment","environmentally friendly product","everywhere"};
    String [] ortaokul6bolum9s3 = {"exhaust gas","filter","flower pot","garbage","glass","global warming","go green","grow","habitat","handbag"};
    String [] ortaokul6bolum9s4 = {"harm","heat","hometown","hunt","important","increase","jar","junk food","lake","light bulb"};
    String [] ortaokul6bolum9s5 = {"litter","lung","Moreover","natural","noise pollution","noisy","paper","pick","planet","plant"};
    String [] ortaokul6bolum9s6 = {"plugged","pollute","polluted","pot","pour","prevent","private","protect","public transportation","recycle"};



    String [] ortaokul6bolum9c1 = {"hava kirliliği","miktar, tutar","hava, atmosfer","katılmak","pil, batarya","poşet, taşıma çantası","sınıflandırmak, ayırmak","kalabalık","azal(t)mak, kesmek","bisiklete binmek"};
    String [] ortaokul6bolum9c2 = {"zarar vermek, hasara uğratmak","tahrip etmek, imha etmek, yıkmak","cihaz, alet, aygıt","mesafe, uzaklık","yeryüzü, toprak","çevreyle dost","çevre kirliliği","çevre","çevre dostu ürün","her yer"};
    String [] ortaokul6bolum9c3 = {"egzoz gazı","sizgeç, filtre, süzmek","çiçek saksısı","çöp","cam","küresel ısınma","çevreyi/yeşili korumak","yetiş(tir)mek, büyümek","doğal ortam, yaşam alanı","el çantası"};
    String [] ortaokul6bolum9c4 = {"zarar vermek","sıcaklık, ısı, ısıtmak","memleket","avlamak","önemli","artmak, çoğalmak","kavanoz","abur cubur yiyecek","göl","ampul"};
    String [] ortaokul6bolum9c5 = {"çöp","akciğer, ciğer","üstelik, ayrıca","doğal ","gürültü kirliliği","gürültülü","kağıt","toplamak","gezegen","ekmek, dikmek (bitki vb.), bitki"};
    String [] ortaokul6bolum9c6 = {"prize takılı","kirletmek","kirli, kirlenmiş","çanak, demlik, saksı","dökmek, akıtmak, koymak(çay vb.)","önlemek","özel, kişisel, gizli","korumak","toplu taşıma","geri dönüşüm yapmak"};


    // 10. bölüm

    String [] ortaokul6bolum10s1 = {"achieve","aim","ballot box","become","bookcase","bookworm","break the law","brilliant","cabinet","campaign"};
    String [] ortaokul6bolum10s2 = {"candidate","check","child rights","choice","choose","clever","count","decide","decision","democracy"};
    String [] ortaokul6bolum10s3 = {"democratic","different","director","education","elect","elected","election","envelope","equal","equality"};
    String [] ortaokul6bolum10s4 = {"excited","explain","express","fair","fold","formal","free","freely","friendly","give a speech"};
    String [] ortaokul6bolum10s5 = {"govern","hardworking","harmony","health care","helpful","human rights","idea","identity card","in general","junk food"};
    String [] ortaokul6bolum10s6 = {"kind","law","learn","live","make decision","medical care","nice","nutritious","official","opinion"};



    String [] ortaokul6bolum10c1 = {"başarmak","amaçlamak, hedeflemek, hedef, gaye","oy sandığı","olmak, dönüşmek, haline gelmek","kitaplık","kitap kurdu","yasayı çiğnemek","muhteşem, harika, zeki","kabin","kampanya"};
    String [] ortaokul6bolum10c2 = {"aday","kontrol etmek","çocuk hakları","seçenek","seçmek","zeki","saymak","karar vermek","karar","demokrasi"};
    String [] ortaokul6bolum10c3 = {"demokratik","farklı","yönetici, müdür, idareci","eğitim","seçmek","seçilmiş","seçim","zarf","eşit","eşitlik"};
    String [] ortaokul6bolum10c4 = {"heyecanlı","açıklamak, izah etmek, aydınlatmak","ifade etmek","adil","katlamak","resmi","bağımsız, özgür, serbest, bedava, ücretsiz","özgürce","arkadaş canlısı","konuşma yapmak"};
    String [] ortaokul6bolum10c5 = {"yönetmek, idare etmek","çalışkan","uyum","sağlık hizmetleri","yardım sever","insan hakları","fikir","kimlik kartı, nüfus cüzdanı","genel olarak","abur cubur yiyecek"};
    String [] ortaokul6bolum10c6 = {"nazik","kural, yasa, hukuk","öğrenmek","yaşamak","karar vermek","sağlık yardımı, tıbbi bakım","güzel, hoş, tatlı, nazik","besleyici","memur, yetkili, görevli","fikir"};


    // 7. SINIF

    // 1. bölüm
    String [] ortaokul7bolum1s1 = {"selfish","plump","generous","shy","well-built","slim","fat","stubborn","cheerful","tall"};
    String [] ortaokul7bolum1s2 = {"short","share","nervous","smile","gym","junk food","visit","present","buy","keep fit"};
    String [] ortaokul7bolum1s3 = {"thin","helpful","medium weight","medium height","creative","hardworking","glasses","tell","funny","story"};
    String [] ortaokul7bolum1s4 = {"make joke","warn","talkative","surf on the net","good looking","thoughtful","friendly","punctual","forget","similar"};
    String [] ortaokul7bolum1s5 = {"twin","make friend","outgoing","smart","attractive","cute","honest","bald","hazel","old"};
    String [] ortaokul7bolum1s6 = {"young","middle aged","tell lie","tell the truth","forgetful","handsome","easygoing","screenwriter","change mind","fashion"};

    String [] ortaokul7bolum1c1 = {"bencil","tombul","cömert","utangaç","yapılı, kaslı","zayıf","şişman","inatçı","neşeli","uzun"};
    String [] ortaokul7bolum1c2 = {"kısa","paylaşmak","gergin, sinirli","gülümsemek","spor salonu","abur cubur","ziyaret etmek","hediye","satın almak","formunu korumak"};
    String [] ortaokul7bolum1c3 = {"ince,zayıf","yardımsever","orta kilo","orta boy","yaratıcı","çalışkan","gözlük","söylemek, anlatmak","eğlenceli, komik","hikaye"};
    String [] ortaokul7bolum1c4 = {"şaka yapmak","uyarmak","konuşkan","internette gezinmek","hoş görünen","düşünceli","arkadaş canlısı","dakik","unutmak","benzer"};
    String [] ortaokul7bolum1c5 = {"ikiz","arkadaş edinmek","dışa dönük,girişken","zeki","etkileyici","sevimli, şirin","dürüst","kel","ela","eski, yaşlı"};
    String [] ortaokul7bolum1c6 = {"genç","orta yaşlı","yalan söylemek","doğru söylemek","unutmak","yakışıklı","uysal","senaryo yazarı","fikrini değiştirmek","moda"};

    // 2 . bölüm

    String [] ortaokul7bolum2s1 = {"applaud","archer","archery","arrow","backpack","baked","beat","belt","bow","coach"};
    String [] ortaokul7bolum2s2 = {"court","cycling","draw","enjoyable","equipment","exciting","exercise","fast food","fit","go on a diet"};
    String [] ortaokul7bolum2s3 = {"grilled","gym","gymnastics","handball","have fun","healthy","helmet","hiking","hit","ice skating"};
    String [] ortaokul7bolum2s4 = {"individual sports","indoor sports","injury","interested in","jogging","join","junk food","knee pad","lose","medal"};
    String [] ortaokul7bolum2s5 = {"muscular","net","opponent","outdoor sports","racket","represent","roller skating","skateboard","skating","skiing"};
    String [] ortaokul7bolum2s6 = {"snowboard","spectator","sprinter","steamed","success","successful","suit","surface","swimsuit","team"};



    String [] ortaokul7bolum2c1 = {"alkışlamak","okçu","okçuluk","ok","sırt çantası","fırında pişmiş","yenmek","kemer","yay","antrenör"};
    String [] ortaokul7bolum2c2 = {"saha","bisiklete binme","berabere bitme","keyifli, zevkli","alet, ekipman, araç gereç","heyecan verici","egzersiz,antrenman","hazır yemek","zinde","diyete girmek"};
    String [] ortaokul7bolum2c3 = {"ızgarada pişirilmiş","spor salonu","jimnastik","hentbol","eğlenmek","sağlıklı","kask","doğa yürüyüşü","vurmak","buz pateni"};
    String [] ortaokul7bolum2c4 = {"bireysel sporlar","kapalı alan sporları","yara, sakatlık, incinme","ilgi duymak","hafif koşu","katılmak","abur cubur","dizlik","kaybetmek","madalya"};
    String [] ortaokul7bolum2c5 = {"kaslı","file","rakip","açık alan sporları","raket","temsil etmek","paten kayma","kaykay","paten kayma","kayak yapma"};
    String [] ortaokul7bolum2c6 = {"kar kayağı","seyirci","koşucu","buharda pişmiş","başarı","başarılı","takım (giysi)","yüzey","mayo","takım"};


    // 3. bölüm


    String [] ortaokul7bolum3s1 = {"achievement","alone","award","be born","be interested in","biography","birth","brilliant","bulb","childhood"};
    String [] ortaokul7bolum3s2 = {"chronological","citizen","commander","company","competition","compose","date","death","degree","design"};
    String [] ortaokul7bolum3s3 = {"device","diary","die","discover","divorce","education","effort","event","experience","extraordinary"};
    String [] ortaokul7bolum3s4 = {"famous","flight","force","found","get engaged","get married","get retired","give information","government","graduate"};
    String [] ortaokul7bolum3s5 = {"grandchildren","grow up","high mark","hometown","important","influence","interest","invent","invention","inventor"};
    String [] ortaokul7bolum3s6 = {"leave","life","marriage","milestone","move","order","own","parent","physicist","physics"};



    String [] ortaokul7bolum3c1 = {"başarı","yalnız","ödül","doğmak","ilgi duymak","biyografi","doğum","zeki","ampul","çocukluk"};
    String [] ortaokul7bolum3c2 = {"kronolojik","vatandaş","komutan","şirket","yarışma","bestelemek","tarih","ölüm","derece, rütbe","tasarlamak"};
    String [] ortaokul7bolum3c3 = {"cihaz, alet","günlük","ölmek","keşfetmek","boşanmak","eğitim","çaba","olay","deneyim","olağanüstü"};
    String [] ortaokul7bolum3c4 = {"ünlü","uçuş","zorlamak, mecbur etmek","kurmak","nişanlanmak","evlenmek","emekli olmak","bilgi vermek","hükümet","mezun olmak"};
    String [] ortaokul7bolum3c5 = {"torunlar","büyümek, yetişmek","yüksek not","memleket","önemli","etkilemek","ilgi","icat etmek","icat","mucit"};
    String [] ortaokul7bolum3c6 = {"ayrılmak","yaşam","evlilik","dönüm noktası","taşınmak","sıra, düzen","sahip olmak","ebeveyn","fizikçi","fizik"};


    // 4. bölüm



    String [] ortaokul7bolum4s1 = {"attack","avarage","bat","be afraid of","bite","cage","carnivore","carnivorous","cause","cave"};
    String [] ortaokul7bolum4s2 = {"change","climate","crocodile","dangerous","deer","desert","destroy","die","discover","dolphin"};
    String [] ortaokul7bolum4s3 = {"eagle","eat","elephant","endangered","enormous","environment","excellent","extinct","extinction","fin"};
    String [] ortaokul7bolum4s4 = {"flower","fruit","fur","giraffe","global warming","grassland","grow up","habitat","harm","herbivore"};
    String [] ortaokul7bolum4s5 = {"herbivorous","huge","human","hunt","hunter","immediately","in danger","ivory","jungle","keep clean"};
    String [] ortaokul7bolum4s6 = {"kill","lake","land","leave","leg","lifespan","lion","live","lizard","main"};



    String [] ortaokul7bolum4c1 = {"saldırmak","ortalama","yarasa","-den korkmak","ısırmak","kafes","etobur, etçil","etobur, etçil","sebep olmak","mağara"};
    String [] ortaokul7bolum4c2 = {"değitirmek, değişmek","iklim","timsah","tehlikeli","geyik","çöl","tahrip etmek","ölmek","keşfetmek","yunus balığı"};
    String [] ortaokul7bolum4c3 = {"kartal","yemek yemek","fil","nesli tehlikede","kocaman","çevre","mükemmel","nesli tükenmiş","nesli tükenme","yüzgeç"};
    String [] ortaokul7bolum4c4 = {"çiçek","meyve","kürk","zürafa","küresel ısınma","otlak, çayır","büyümek","yaşam alanı","zarar vermek","otobur, otçul"};
    String [] ortaokul7bolum4c5 = {"otobur, otçul","kocaman","insan","avlamak","avcı","derhal","tehlikede","fildişi","balta girmemiş orman","temiz tutmak"};
    String [] ortaokul7bolum4c6 = {"öldürmek","göl","kara","ağaç yaprağı","bacak","ömür, yaşam süresi","aslan","yaşamak","kertenkele","başlıca"};


    // 5. bölüm



    String [] ortaokul7bolum5s1 = {"action","advantage","adventure","alien","amusing","audience","be interested in","behaviour","boring","cartoon"};
    String [] ortaokul7bolum5s2 = {"celebrity","change","channel","couh potato","commercial","content","cookery programme","creativity","development","director"};
    String [] ortaokul7bolum5s3 = {"disadvantage","discussion","documentary","draw","educational","effect","enjoyable","episode","escape","exciting"};
    String [] ortaokul7bolum5s4 = {"follow","forum","fresh air","get involved","global warming","guest","harmful","headache","health","healthy"};
    String [] ortaokul7bolum5s5 = {"horror","improve","informative","intelligence","interesting","interview","junk food","lazy","lie down","life style"};
    String [] ortaokul7bolum5s6 = {"love story","main character","mental","movie","news","nonsense","online","physical","prefer","quiz show"};



    String [] ortaokul7bolum5c1 = {"aksiyon","avantaj","macera","uzaylı, yaratık","eğlenceli,zevkli, komik","seyirci, izleyici","ilgi duymak","davranış","sıkıcı","çizgi film"};
    String [] ortaokul7bolum5c2 = {"ünlü kişi","değiştirmek","kanal","televizyon bağımlısı","reklam","içerik","yemek programı","yaratıcılık","gelişim","yönetmen"};
    String [] ortaokul7bolum5c3 = {"dezavantaj","tartışma","belgesel","berabere","eğitici","etki","zevkli, hoş","dizi bölümü","kaçmak","heyecan verici"};
    String [] ortaokul7bolum5c4 = {"takip etmek","toplantı, oturum","temiz hava","dahil olmak","küresel ısınma","konuk, davetli","zararlı","baş ağrısı","sağlık","sağlıklı"};
    String [] ortaokul7bolum5c5 = {"korku","gelişmek, geliştirmek","bilgilendirici, öğretici","zeka","ilgi çekici","röportaj","abur cubur yiyecek","tembel","uzanmak","yaşam biçimi"};
    String [] ortaokul7bolum5c6 = {"aşk hikayesi","baş karakter","zihinsel","film","haberler","saçmalık","çevrim içi","fiziksel","tercih etmek","bilgi yarışması"};



    //6. bölüm

    String [] ortaokul7bolum6s1 = {"a few","a little","a lot of","advice","Alright","amazing","arrange","arrange music","attend","bakery"};
    String [] ortaokul7bolum6s2 = {"balloon","be good at","be responsible for","begin","beverage","birthday party","blow up the candles","bring","buy","cake"};
    String [] ortaokul7bolum6s3 = {"candle","celebrate","celebration","choice","close friend","colourful","confetti","congratulations","cookie","corn"};
    String [] ortaokul7bolum6s4 = {"costume","costume party","crisps","crowded","date","decide","decorate","decoration","definitely","delicious"};
    String [] ortaokul7bolum6s5 = {"dessert","detail","drink beverage","egg","engagement party","entertainment","excited","fancy dress","fancy dress party","farewell party"};
    String [] ortaokul7bolum6s6 = {"father’s day","flour","food","forget","get a degree","get a diploma","gift","give a party","graduate","graduation party"};



    String [] ortaokul7bolum6c1 = {"birkaç","az, biraz","çok, birçok","nasihat, tavsiye, öğüt","peki, olur, tamam","şaşırtıcı, ilginç, harika","düzenlemek","müziği ayarlamak","katılmak","fırın, pastane"};
    String [] ortaokul7bolum6c2 = {"balon","bir şeyde iyi olmak","-den sorumlu olmak","başlamak","içecek","doğum günü partisi","mumları söndürmek","getirmek","satın almak","kek, pasta"};
    String [] ortaokul7bolum6c3 = {"mumları söndürmek","kutlamak","kutlama","tercih, seçenek","yakın arkadaş","renkli","konfeti","Tebrikler","kurabiye","mısır"};
    String [] ortaokul7bolum6c4 = {"kostüm","kostüm partisi","cips","kalabalık","tarih","karar vermek","dekore etmek, süslemek","dekorasyon, süsleme","kesinlikle, tamamen, elbette","lezzetli"};
    String [] ortaokul7bolum6c5 = {"tatlı","detay, ayrıntı","içecek içmek","yumurta","nişan partisi","eğlence, gösteri","heyecanlı, coşkulu","maskeli balo elbisesi","maskeli balo, kıyafet balosu","veda partisi"};
    String [] ortaokul7bolum6c6 = {"babalar günü","un","yiyecek","unutmak","mezun olmak","diploma almak","hediye","parti vermek","mezun olmak","mezuniyet partisi"};


    // 7. bölüm


    String [] ortaokul7bolum7s1 = {"abroad","accommodation","achieve","alien","be proud of","beat","believe","brain","brilliant","canary"};
    String [] ortaokul7bolum7s2 = {"cancer","career","certain","champion","climate","communication","company","concern","court","cure"};
    String [] ortaokul7bolum7s3 = {"definitely","disappear","discover","disease","dream","driving test","drought","education","election","environment"};
    String [] ortaokul7bolum7s4 = {"especially","excellent","exciting","exercise","expectation","expensive","extinct","fail","fashion","firm"};
    String [] ortaokul7bolum7s5 = {"future","get bored","get married","goal","graduate","grow up","guess","habitat","harm","healthy"};
    String [] ortaokul7bolum7s6 = {"hope","illness","imagine","improvement","increase","industry","invent","kitten","league","lifestyle"};



    String [] ortaokul7bolum7c1 = {"yurt dışında","konaklama, kalacak yer","başarmak","uzaylı, yaratık","gurur duymak","yenmek","inanmak","beyin","zeki","kanarya"};
    String [] ortaokul7bolum7c2 = {"kanser","kariyer","kesin","şampiyon","iklim","iletişim","şirket","ilgi, ilgili olmak","kort, spor sahası","çare, tedavi"};
    String [] ortaokul7bolum7c3 = {"kesinlikle","ortadan kaybolmak, yok olmak","keşfetmek","hastalık","rüya(görmek), hayal(kurmak)","direksiyon sınavı","kuraklık","eğitim","seçim","çevre"};
    String [] ortaokul7bolum7c4 = {"özellikle","mükemmel","heyecan verici","alıştırma, egzersiz(yapmak)","beklenti, umut","pahalı","nesli tükenmiş","başarısız olmak","moda","firma"};
    String [] ortaokul7bolum7c5 = {"gelecek","sıkılmak","evlenmek","amaç, hedef, gol","mezun olmak","yetişmek, büyümek","tahmin(etmek)","doğal ortam, yaşam alanı","zarar(vermek)","sağlıklı"};
    String [] ortaokul7bolum7c6 = {"umut(etmek)","hastalık","hayal etmek, sanmak","gelişim, ilerleme","artmak","endüstri, sanayi","icat etmek","kedi yavrusu","lig, küme","yaşam biçimi"};








    // 8. bölüm

    String [] ortaokul7bolum8s1 = {"alive","amazing","amusement park","art gallery","attend","backstage","bakery","besides","Blue Mosque","Bosphorus tour"};
    String [] ortaokul7bolum8s2 = {"boutique","bridge","bumper cars","burglary","busy","butcher","buy","capital","charity","chemist’s"};
    String [] ortaokul7bolum8s3 = {"city","city hall","clothes","coffee shop","company","cosmopolitan","crowded","delicious","department store","destroy"};
    String [] ortaokul7bolum8s4 = {"draw money","edge","enjoy","enormous","etc.","event","exhibition","experience","famous","far"};
    String [] ortaokul7bolum8s5 = {"fashionable","feel","fire","fire station","free time","furniture","game store","gift shop","governorship","Grand Bazaar"};
    String [] ortaokul7bolum8s6 = {"Great Wall","greengrocer’s","grocery","Hagia Sophia","have a rest","have fun","historic","inform","jewellery","jogging"};



    String [] ortaokul7bolum8c1 = {"canlı, yaşam dolu, zinde","şaşırtıcı, harika","lunapark","sanat galerisi","katılmak","sahne arkası","ekmek fırını, pastane","ayrıca, bunun yanısıra, üstelik","Sultanahmet Camii","Boğaz turu"};
    String [] ortaokul7bolum8c2 = {"butik","köprü","çarpışan araba","hırsızlık","meşgul, yoğun","kasap","satın almak","başkent","hayır işi, hayır kurumu","eczane"};
    String [] ortaokul7bolum8c3 = {"şehir","belediye binası","giysi","kahve dükkanı, kafe, kafeterya","şirket","çok uluslu","kalabalık","lezzetli","alışveriş merkezi","zarar vermek, yıkmak"};
    String [] ortaokul7bolum8c4 = {"para çekmek","köşe, uç, kenar","zevk almak, keyif almak, eğlenmek","kocaman, devasa","ve benzeri","etkinlik","sergi","deneyim","ünlü, meşhur","uzak"};
    String [] ortaokul7bolum8c5 = {"modaya uygun","hissetmek","yangın, ateş","itfaiye","boş zaman","eşya, mobilya","oyun dükkanı","hediye dükkanı","valilik","Kapalı Çarşı"};
    String [] ortaokul7bolum8c6 = {"Çin Seddi","manav","bakkal dükkanı, market","Ayasofya","dinlenmek","eğlenmek","tarihi","bilgilendirmek","mücevherat, kuyumculuk","hafif tempolu koşu"};


    // 9. bölüm


    String [] ortaokul7bolum9s1 = {"affect","agriculture","another","Arctic","atmosphere","balance","breathe","bulb","car exhaust","carelessly"};
    String [] ortaokul7bolum9s2 = {"cause","chemical","chew","choose","climate","climate change","consumption","dangerous","deep","Deforestation"};
    String [] ortaokul7bolum9s3 = {"depletion","destroy","destruction","device","dig","disease","disposable","earth","eco-friendly","efficient"};
    String [] ortaokul7bolum9s4 = {"endangered","environment","environmental","exhaust","factory","forest","fume","furniture","giant","give harm"};
    String [] ortaokul7bolum9s5 = {"global warming","greenhouse effect","gum","habitat","handicapped","harmful","health","heating","hole","human"};
    String [] ortaokul7bolum9s6 = {"Hunting","ice cap","immediately","increaase","industry","international","item","kill","lightening","main"};



    String [] ortaokul7bolum9c1 = {"etkilemek","tarım","öbür, başka, ayrı, farklı","Kuzey Kutup bölgesi","atmosfer, hava","dengelemek, denge","nefes almak","ampul","araba egzozu","dikkatsizce"};
    String [] ortaokul7bolum9c2 = {"sebep, sebep olmak","kimyasal","çiğnemek","seçmek","iklim","iklim değişikliği","tüketim","tehlikeli","derin","ormanları tahrip etme"};
    String [] ortaokul7bolum9c3 = {"tüketme, yok olma","tahrip etmek","tahribat","cihaz, alet","kazmak","hastalık","tek kullanımlık","kara, yeryüzü","çevre dostu","etkili"};
    String [] ortaokul7bolum9c4 = {"nesli tehlikede","çevre","çevresel","egzoz, yormak, tüketmek","fabika","ormanları tahrip etme","duman, duman çıkarmak","mobilya, ev eşyası","çok büyük, devasa, kocaman","zarar vermek"};
    String [] ortaokul7bolum9c5 = {"küresel ısınma","sera etkisi","sakız","doğal ortam, yaşam alanı","engelli","zararlı","sağlık","ısıtma","delik, çukur","insan"};
    String [] ortaokul7bolum9c6 = {"avlama, avcılık, avlanma","buzul, buz tabakası","derhal, hemen","artmak, çoğalmak","endüstri, sanayi","uluslararası","eşya","öldürmek","aydınlatma","başlıca, esas"};


    // 10. bölüm

    String [] ortaokul7bolum10s1 = {"alien","amazing","anymore","asteroid","atmosphere","black hole","circumference","comet","crew","decrease"};
    String [] ortaokul7bolum10s2 = {"define","definition","discover","dwarf","easily","equatorial","evidence","explode","exploration","explore"};
    String [] ortaokul7bolum10s3 = {"galaxy","gravity","information","inner","intend","iron oxide","journey","lunar","manned","Mass"};
    String [] ortaokul7bolum10s4 = {"material","meteor shower","Milky Way","mission","moon","mysterious","natural","nucleus","object","observe"};
    String [] ortaokul7bolum10s5 = {"orbit","orbital period","originally","outer","Planet","possible","proof","rescue","research","return"};
    String [] ortaokul7bolum10s6 = {"ring","rock","rocky","safely","sample","satellite","Scientist","size","solar system","space"};



    String [] ortaokul7bolum10c1 = {"uzaylı, yaratık","şaşırtıcı, harika, inanılmaz","artık, bundan sonra","asteroit, küçük gezegen","atmosfer, hava","kara delik","daire çevresi","kuyruklu yıldız","tayfa, mürettebat, ekip","küçülmek, azal(t)mak"};
    String [] ortaokul7bolum10c2 = {"tanımlamak, açıklamak","tanım, tarif, açıklama","keşfetmek, ortaya çıkarmak","cüce","kolaylıkla","ekvatoral, ekvatorla ilgili","delil, kanıtlamak, açığa vurmak","patla(t)mak, havaya uçurmak","keşif","keşfetmek, araştırmak, incelemek"};
    String [] ortaokul7bolum10c3 = {"galaksi","yer çekimi","bilgi","iç, içerideki","niyet etmek, demek istemek","demir oksit","yolculuk, seyahat, yolculuk etmek","ay ile ilgili","içinde insan bulunan (uzay aracı vb.)","yığmak, biriktirmek, yığın, kütle"};
    String [] ortaokul7bolum10c4 = {"materyal, madde, malzeme","meteor yağmuru","samanyolu","vazife, misyon, görev","ay","esrarengiz, gizemli, anlaşılmaz, garip","doğal","atom çekirdeği, kuyruklu yıldızın parlak başı","obje, nesne, cisim","gözlemlemek"};
    String [] ortaokul7bolum10c5 = {"yörünge, yörüngede dönmek","yörünge dönüş süresi","aslen, aslında","dış, dıştaki","gezegen","olası, muhtemel, mümkün","kanıt, ispat","kurtarmak","incelemek, araştırmak, araştırma","geri dönmek, iade etmek"};
    String [] ortaokul7bolum10c6 = {"çalmak(telefon/zil), halka","kaya, taş, sallanmak","kayalık","güvenli bir şekilde","örnek, numune","uydu","bilim insanı","büyüklük, ölçü, boyut","güneş sistemi","uzay"};


    // 8. SINIF


    // 1. bölüm
    String [] ortaokul8bolum1s1 = {"accept","action","adventurous","aggressive","amusement park","amusing","animation","argue","arrogant","attend"};
    String [] ortaokul8bolum1s2 = {"attract attention","back up","bad-tempered","best friend","book fair","bring","buddy","busy","calm","caring"};
    String [] ortaokul8bolum1s3 = {"casual","celebrate","chat","chit-chat","close friend","concert","come over","comedy","count on","cycle"};
    String [] ortaokul8bolum1s4 = {"deadline","depend on","determined","drama","duty","event","exciting","excuse","exhibition","fair"};
    String [] ortaokul8bolum1s5 = {"fascinating","fashion","follow","generous","get on well (with)","gloves","helpful","hometown","honest","information"};
    String [] ortaokul8bolum1s6 = {"interested in","invitation","invitation card","invite","inviter","invitee","jealous","join","keep secret","laid-back"};

    String [] ortaokul8bolum1c1 = {"kabul etmek","aksiyon","maceraperest","sinirli","lunapark","eğlenceli, komik","animasyon","tartışmak","kibirli","katılmak"};
    String [] ortaokul8bolum1c2 = {"dikkatini çekmek","destek olmak","kötü huylu","en iyi arkadaş","kitap fuarı","getirmek","kanka","meşgul, yoğun","sakin","şefkatli"};
    String [] ortaokul8bolum1c3 = {"gündelik","kutlamak","sohbet etmek","sohbet","yakın arkadaş","konser","uğramak, ziyaret etmek","komedi","güvenmek","bisiklete binmek"};
    String [] ortaokul8bolum1c4 = {"son teslim tarihi","güvenmek","azimli, kararlı","dram","görev","etkinlik","heyecan verici","mazeret, bahane","sergi","adil"};
    String [] ortaokul8bolum1c5 = {"büyüleyici","moda","takip etmek","cömert","biriyle iyi anlaşmak","eldiven","yardımsever","memleket","dürüst","bilgi"};
    String [] ortaokul8bolum1c6 = {"ilgi duymak","davet","davetiye","davet etmek","davet eden","davet edilen","kıskanç","katılmak","sır tutmak","sakin, rahat kişi"};

    // 2 . bölüm

    String [] ortaokul8bolum2s1 = {"archer","archery","backpack","be fond of","be keen on","boring","burn","campfire","can’t stand","chat"};
    String [] ortaokul8bolum2s2 = {"compass","countryside","energetic","equipment","exciting","feed","fit","fizzy drink","fresh-squeezed","fun"};
    String [] ortaokul8bolum2s3 = {"gain","go shopping","goal","greet","harmonic","healthy","in a hurry","indoor activities","insult","interested in"};
    String [] ortaokul8bolum2s4 = {"language","lend","map","match","news","on foot","outdoor activities","pay attention","pick up","pitch"};
    String [] ortaokul8bolum2s5 = {"pocketknife","prepare","relaxing","reward","ridiculous","rope","rugby","serious","set goal","skate"};
    String [] ortaokul8bolum2s6 = {"skydiving","sleeping bag","snob","speak","surf the internet / surf on the net","survey","teenager","tent","terrific","torch"};



    String [] ortaokul8bolum2c1 = {"okçu","okçuluk","sırt çantası","-e düşkün olmak","-e düşkün olmak","sıkıcı","yanmak, yakmak","kamp ateşi","tahammül edememek, katlanamamak","sohbet etmek"};
    String [] ortaokul8bolum2c2 = {"pusula","kırsal bölge","enerjik","araç-gereç, malzeme, ekipman","heyecan verici","beslemek","zinde","gazlı içecek","taze sıkılmış","zevkli, eğlenceli"};
    String [] ortaokul8bolum2c3 = {"kazanmak, elde etmek","alışverişe gitmek","gol, sayı, hedef","selamlaşmak, selam vermek, karşılaşmak","uyumlu","sağlıklı","telaş içinde","kapalı alan aktiviteleri","hakaret etmek, aşağılamak","ilgi duymak"};
    String [] ortaokul8bolum2c4 = {"dil, lisan","ödünç vermek","harita","kibrit","haber","yaya olarak, yürüyerek","açıkhava aktiviteleri","dikkate almak, kulak vermek","almak (bir yere gelip/gidip birini)","kurmak"};
    String [] ortaokul8bolum2c5 = {"çakı","hazırlamak","dinlendirici, rahatlatıcı","ödül","gülünç, saçma","ip","ragbi","ciddi","hedef belirlemek","paten kaymak"};
    String [] ortaokul8bolum2c6 = {"hava dalışı","uyku tulumu","burnu havada","konuşmak","internette gezinmek","araştırma, anket ","genç, ergen","çadır","müthiş, olağanüstü","el feneri"};


    // 3. bölüm


    String [] ortaokul8bolum3s1 = {"a bunch of","add","bake","baking tray","baking powder","basil","be fond of","beef","beef broth","bitter"};
    String [] ortaokul8bolum3s2 = {"black pepper","blueberry","boil","bowl","breadcrumb","butter","cake pan","chocolate chips","chop","cilantro"};
    String [] ortaokul8bolum3s3 = {"cinnamon","coconut","cornstarch","cover","crack","cranberry","crushed","cucumber","cuisine","culinary arts"};
    String [] ortaokul8bolum3s4 = {"cummin","cut","dessert","dice","dish","dissolve","dough","drain","experience","fatty"};
    String [] ortaokul8bolum3s5 = {"flour","fork","freeze","freezer","fry","frying pan","gain","garlic","ginger","graduate"};
    String [] ortaokul8bolum3s6 = {"grate","grater","greasy","grill","handful","heat","homemade","ingredient","knead","knife"};



    String [] ortaokul8bolum3c1 = {"bir demet","eklemek","fırında pişirmek","fırın tepsisi","kabartma tozu","fesleğen","düşkün olmak, çok sevmek","sığır eti","et suyu","acı, keskin"};
    String [] ortaokul8bolum3c2 = {"kara biber","yaban mersini","haşlamak","kase","ekmek kırıntısı","tereyağ, margarin","pasta kalıbı","damla çikolata","doğramak","kişniş"};
    String [] ortaokul8bolum3c3 = {"tarçın","hindistan cevizi","mısır nişastası","örtmek, kaplamak","kırmak","yaban mersini, kızılcık","ezilmiş, öğütülmüş","salatalık","mutfak (Türk mutfağı,Hint mutfağı vb.)","mutfak sanatları"};
    String [] ortaokul8bolum3c4 = {"kimyon","kesmek","tatlı","küp küp doğramak","yemek","erimek, eritmek","hamur","süzmek","tecrübe","yağlı"};
    String [] ortaokul8bolum3c5 = {"un","çatal","dondurmak, donmak","dondurucu","kızartmak","kızartma tavası","kazanmak, edinmek","sarımsak","zencefil","mezun olmak"};
    String [] ortaokul8bolum3c6 = {"rendelemek","rende","yağlı","ızgara yapmak","avuç dolusu","ısı, sıcaklık, ısıtmak","ev yapımı","malzeme","yoğurmak","bıçak"};


    // 4. bölüm



    String [] ortaokul8bolum4s1 = {"access","addiction","angry","answer","anymore","application","appointment","as soon as possible","available","bad line"};
    String [] ortaokul8bolum4s2 = {"bill","book","bored","break into","burglar","burglary","call","call center","collect","commander"};
    String [] ortaokul8bolum4s3 = {"communicate","communication","confirm","connect","contact","carry","cons","customer","customer service","dial"};
    String [] ortaokul8bolum4s4 = {"disabled","donate","doorbell","environment","embarrassed","emergency","engaged","evolve","face to face","fire"};
    String [] ortaokul8bolum4s5 = {"flight ticket","foreign language","garbage","generous","go on vacation","goldsmith","hang on","harmful","hold on","hang up"};
    String [] ortaokul8bolum4s6 = {"history","improve","in need","incident","information","interaction","invent","joke","keep in touch","learn"};



    String [] ortaokul8bolum4c1 = {"erişim","bağımlılık","sinirli","cevap, cevap vermek","artık, bundan sonra","uygulama (mobil)","randevu","bir an önce, olabildiğince çabuk","müsait, uygun","kötü hat"};
    String [] ortaokul8bolum4c2 = {"fatura","ayırtmak, rezervasyon yaptırmak","sıkılmış","zorla girmek","hırsız","hırsızlık","telefonla aramak","çağrı merkezi","toplamak","komutan"};
    String [] ortaokul8bolum4c3 = {"iletişim kurmak","iletişim","onaylamak","bağlamak, bağlanmak","irtibat kurmak","taşımak","dezavantajlar","müşteri","müşteri hizmeti","aramak, telefon numarasını çevirmek"};
    String [] ortaokul8bolum4c4 = {"engelli, sakat","bağış yapmak","kapı zili","çevre","mahcup, utanmış","acil vaka","meşgul (telefon)","değişmek, evrim geçirmek","yüz yüze","yangın, alev"};
    String [] ortaokul8bolum4c5 = {"uçak bileti","yabancı dil","çöp","cömert","tatile gitmek","kuyumcu","beklemek","zararlı","beklemek","telefonu kapamak"};
    String [] ortaokul8bolum4c6 = {"tarih","geliştirmek","muhtaç","olay","bilgi","etkileşim","icat etmek","şaka, şaka yapmak","irtibatta olmak","öğrenmek"};


    // 5. bölüm



    String [] ortaokul8bolum5s1 = {"account","addict","adult","attach","attachment","average","brand","broken","browser","button"};
    String [] ortaokul8bolum5s2 = {"buy","cardholder","chat","check","choose","click","comment","complainer","computer","confirm"};
    String [] ortaokul8bolum5s3 = {"connection","content","copyright","device","discount","download","etiquette","expert","expiry date","file"};
    String [] ortaokul8bolum5s4 = {"flight ticket","follower","foreign language","habit","influencer","influential","information","insert","join","keep in touch"};
    String [] ortaokul8bolum5s5 = {"log in / log on","log out / log off","make comment","make new friends","mostly","non-refundable","offline","one way ticket","online","online shopping"};
    String [] ortaokul8bolum5s6 = {"password","pay attention","pay the bill","percent","post","practice","product","properly","recognition","refundable"};



    String [] ortaokul8bolum5c1 = {"hesap","bağımlı","yetişkin","eklemek, iliştirmek","dosya eki","ortalama","marka","kırık","tarayıcı","düğme,tuş"};
    String [] ortaokul8bolum5c2 = {"satın almak","kart sahibi","sohbet etmek","kontrol etmek","seçmek","tıklamak","yorum, yorum yapmak","şikayetçi","bilgisayar","onaylamak, doğrulamak"};
    String [] ortaokul8bolum5c3 = {"bağlantı","içerik","telif hakkı","aygıt, cihaz","indirim","indirmek","görgü kuralları","uzman","son kullanma tarihi","dosya"};
    String [] ortaokul8bolum5c4 = {"uçak bileti","takipçi","yabancı dil","alışkanlık","etkileyen","etkili","bilgi","eklemek","katılmak","irtibatta olmak"};
    String [] ortaokul8bolum5c5 = {"oturum açmak","oturumu kapatmak","yorum yapmak","yeni arkadaşlar edinmek","çoğunlukla","iade edilemez","çevrim dışı","tek yön bilet","çevrim içi","internet alışverişi"};
    String [] ortaokul8bolum5c6 = {"şifre, parola","dikkat etmek","fatura ödemek","yüzde %","yayınlamak","uygulamak, alıştırma yapmak","ürün","düzgün bir şekilde","tanınırlık","iade edilebilir"};



    //6. bölüm


    String [] ortaokul8bolum6s1 = {"abroad","accident","accommodation","adrenalin junkie","adrenalin seeker","adventure","adventurer","adventurous","aerobatic","afraid"};
    String [] ortaokul8bolum6s2 = {"age range","aim","aircraft","all inclusive","amazing","ambitious","amusing","antenna","archery","armour"};
    String [] ortaokul8bolum6s3 = {"attend","axe","base jumping","beach","blow","bootie","boring","bravery","bridge","canoeing"};
    String [] ortaokul8bolum6s4 = {"catering","cave pack","caving","challenging","check","cliff","coal miner","complete","courage","crampon"};
    String [] ortaokul8bolum6s5 = {"danger","dangerous","demonstration","desert","destination","disappointing","distance","district","elbow pad","entertaining"};
    String [] ortaokul8bolum6s6 = {"equipment","excited","exciting","experience","experienced","expert","extreme sports","fascinating","fearless","feel"};



    String [] ortaokul8bolum6c1 = {"yurt dışında","kaza","konaklama, kalacak yer","adrenalin tutkunu","adrenalin tutkunu","macera","maceraperest","maceralı","hava akrobasisi","korkmuş"};
    String [] ortaokul8bolum6c2 = {"yaş aralığı","amaçlamak, amaç","uçak","her şey dahil","şaşırtıcı, harika","hırslı","eğlenceli, zevkli, komik","anten","okçuluk","zırh"};
    String [] ortaokul8bolum6c3 = {"katılmak","balta","paraşütle yüksekten atlama","sahil, kumsal, plaj","esmek, üflemek","patik","sıkıcı","cesurluk","köprü","kano sporu"};
    String [] ortaokul8bolum6c4 = {"yemek hizmeti","mağara çantası","mağara yürüyüşü","zorlu","denetlemek,kontrol etmek","uçurum","madenci","tamamlamak","cesurluk","tırmanma demiri"};
    String [] ortaokul8bolum6c5 = {"tehlike","tehlikeli","gösteri","çöl","varış yeri","hayal kırıklığına uğratan","mesafe","semt, ilçe, bölge","dirseklik","eğlendirici"};
    String [] ortaokul8bolum6c6 = {"araç gereç, teçhizat, donanım","heyecanlı","heyecan verici","deneyim, tecrübe etmek","tecrübeli","uzman","tehlikeli sporlar","büyüleyici, etkileyici","korkusuz","hissetmek"};


    // 7. bölüm


    String [] ortaokul8bolum7s1 = {"abandon","abroad","accommodation","advertisement","all-inclusive","amphitheater","ancient","aquarium","architecture","artifical"};
    String [] ortaokul8bolum7s2 = {"attend","attractive","authentic","average","basket","bed and breakfast","border","bridge","budget","bullfighting"};
    String [] ortaokul8bolum7s3 = {"capital city","caravansary","castle","cathedral","cave","celebration","ceremony","charming","climate","common"};
    String [] ortaokul8bolum7s4 = {"conquer","conquest","construct","construction","contain","countryside","cruise holiday","cultural","date back to","definitely"};
    String [] ortaokul8bolum7s5 = {"destination","dish","diversity","dominance","dormitory","earthen","emperor","empire","enormous","experience"};
    String [] ortaokul8bolum7s6 = {"famous","fascinating","fountain","fragrant","fried liver","guesthouse","handcraft","heaven","highland","historic"};



    String [] ortaokul8bolum7c1 = {"terk etmek, bırakmak","yurt dışında","konaklama, kalacak yer","ilan, reklam, duyuru","her şey dahil","anfitiyatro","eski, antik","akvaryum","mimari","yapay"};
    String [] ortaokul8bolum7c2 = {"katılmak","cazip, çekici,göz alıcı","özgün","ortalama","sepet","oda kahvaltı","sınır","köprü","bütçe","boğa güreşi"};
    String [] ortaokul8bolum7c3 = {"başkent","kervansaray","kale","katedral,büyük kilise","mağara","kutlama","tören","alımlı, büyüleyici, hoş","iklim","alışılmış, yaygın, sıradan"};
    String [] ortaokul8bolum7c4 = {"fethetmek, ele geçirmek","fetih","inşa etek, kurmak","yapı, inşaat, inşa etme","kapsamak, içermek","kırsal kesim","gemi tatili","kültürel","geçmişe dayanmak","kesinlikle, elbette"};
    String [] ortaokul8bolum7c5 = {"varış yeri, gidilecek yer","yemek","çeşitlilik","hakimiyet, üstünlük","öğreci yurdu","topraktan yapılmış","hükümdar","imparatorluk","kocaman","deneyim, başından geçmek, tecrübe etmek"};
    String [] ortaokul8bolum7c6 = {"ünlü, tanınmış, meşhur","büyüleyici, etkileyici","çeşme","hoş kokulu","ciğer kavurma","konukevi","el sanatı, el işi","cennet","dağlık arazi","tarihi"};


    // 8. bölüm

    String [] ortaokul8bolum8s1 = {"affect","assignment","be in charge of","be responsible for","become","bill","borrow","boss","brilliant","by the way"};
    String [] ortaokul8bolum8s2 = {"chat","chore","classmate","clean up","complain","cook","cooperate","damage","decorate","delicious"};
    String [] ortaokul8bolum8s3 = {"dessert","diary","dish","dishes","dishwasher","disturbing","do chores","do the laundry","do the washing up","doorbell"};
    String [] ortaokul8bolum8s4 = {"dry","dust","duty","empty","entire","experience","feature","flat","furniture","garbage"};
    String [] ortaokul8bolum8s5 = {"gather","get annoyed","get bored","graduate","grass","grocery shopping","habit","hang on","hang out","household"};
    String [] ortaokul8bolum8s6 = {"importance","iron","janitor","lawn","load","look after","make a suggestion","make the bed","meal","mess"};



    String [] ortaokul8bolum8c1 = {"etkilemek","görev, ödev","-den sorumlu olmak","-den sorumlu olmak","olmak","fatura","ödünç almak","patron","muhteşem, dahice","bu arada"};
    String [] ortaokul8bolum8c2 = {"sohbet etmek","günlük ev işi","sınıf arkadaşı","temizlemek","şikayet etmek","yemek pişirmek","işbirliği yapmak","zarar vermek","dekore etmek, süslemek","lezzetli"};
    String [] ortaokul8bolum8c3 = {"tatlı","günlük ev işi","yemek","bulaşık","bulaşık makinesi","rahatsız edici","ev işleri yapmak","çamaşır yıkamak","bulaşıkları yıkamak","kapı zili"};
    String [] ortaokul8bolum8c4 = {"kurutmak","toz almak","görev","boşaltmak","bütün, hepsi","deneyim, tecrübe(etmek)","özellik","apartman dairesi","mobilya, ev eşyası","çöp"};
    String [] ortaokul8bolum8c5 = {"topla(n)mak, biriktirmek","kızmak","sıkılmak","mezun olmak","otlak, çimen","market alışverişi","alışkanlık","asmak","çamaşır asmak","ev veya aileye ait"};
    String [] ortaokul8bolum8c6 = {"önem","ütü, ütülemek","temizlik görevlisi","çayır, çimen","yüklemek, doldurmak","ile ilgilenmek, göz kulak olmak","öneride bulunmak","yatağı toplamak","yemek, öğün","karışıklık, dağınıklık"};


    // 9. bölüm


    String [] ortaokul8bolum9s1 = {"a piece of","academician","achievement","adult","aim","air conditioner","airbag","alchemy","aluminum foil","amount"};
    String [] ortaokul8bolum9s2 = {"announce","appearance","article","as a result of","award","back and forth","backward","basil","battery","battery free"};
    String [] ortaokul8bolum9s3 = {"be dependent on","belong to","biochemist","birthplace","bravely","brilliant","cancer","canon","cartridge","cataract"};
    String [] ortaokul8bolum9s4 = {"catgut","cause","cause and effect","cell","century","certain","change","checkpoint","chemical","choose"};
    String [] ortaokul8bolum9s5 = {"circadian","cloned","co-founder","common","communication","company","compass","competition","competitor","completely"};
    String [] ortaokul8bolum9s6 = {"complex","computed tomography","computerised","condition","conduct","consular official","container","continuously","contribution","convey"};



    String [] ortaokul8bolum9c1 = {"bir parça","akademisyen, öğretim görevlisi","başarı","yetişkin","amaçlamak, hedeflemek, amaç, hedef, gaye","klima","hava yastığı","simya bilimi","alüminyum folyo","miktar, tutar, meblağ"};
    String [] ortaokul8bolum9c2 = {"anons etmek, duyurmak, ilan etmek","görünüm, görünüş","madde(sözleşmede), makale, yazı, nesne","sonucu olarak, neticesinde","ödüllendirmek, mükafat, ödül","ileri geri","geriye, geri, arka kısım","reyhan, fesleğen","akü, pil, batarya","pilsiz, bataryasız"};
    String [] ortaokul8bolum9c3 = {"e bağlı","ait olmak, bağlı olmak, üyesi olmak","biyokimyager","doğum yeri","cesurca, yiğitçe, mertçe","nefis, parlak, muhteşem, harika, dahice, göz alıcı","kanser","kanun, düzen, kural","kartuş","katarakt, göz perdesi, çağlayan, sel, şelale"};
    String [] ortaokul8bolum9c4 = {"ameliyat ipliği","sebep olmak, yol açmak, neden olmak, sebep","sebep sonuç","hücre","asır, yüzyıl","kesin, belirli, mutlak, kaçınılmaz","değişmek, değiştirmek, değişiklik, değişim","kontrol noktası","kimyasal","seçmek, karar vermek, tercih etmek"};
    String [] ortaokul8bolum9c5 = {"24 saatlik","klonlanmış","eş kurucu, kurucu ortak","alışılmış, sıradan, yaygın, ortak","iletişim","şirket, firma, grup, topluluk","pusula","yarışma, yarış, müsabaka, rekabet","yarışmacı, rakip","tamamen, tümüyle, eksiksiz, bütünüyle"};
    String [] ortaokul8bolum9c6 = {"karışık, karmaşık, güçlük","bilgisayarlı tomografi","bilgisayarlı","hal, koşul, durum, şart","yönetmek, yürütmek, idare etmek","konsolosluk görevlisi","konteyner, kap, saklama kabı","aralıksız, sürekli, durmaksızın, devamlı","katkı, bağış, aidat, destek","iletmek, geçirmek, ulaştırmak"};


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
            "asistan","gelişme","merkezi ısıtma","laboratuvar","aktif","dikkatsiz","zevk","kaplan","geri dönüştürmek","temiz"};

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
            "cevap","kurtulmak","oturmak","yapmak","çikolata","işçi","enstrüman","iş günü","kalp","jet"};


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
    private String sev;
    TextToSpeech textToSpeech;
    String saat;
    int soruyanlis = 0;
    int sorudogru = 0;
    int reklam =0;
    int i = 0;
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
        textToSpeech = new TextToSpeech(Kelimeortaokul.this, new TextToSpeech.OnInitListener() {
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
    private void ShowDialogBox (){
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
        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"fonts/Aclonica-Regular.ttf");
        textView1.setTypeface(typeface);
        textView2.setTypeface(typeface);
        textView3.setTypeface(typeface);
        textView4.setTypeface(typeface);
        textView5.setTypeface(typeface);
        textView1.setText(""+sorudogru);
        textView2.setText(""+soruyanlis);
        textView3.setText(""+sorudogru*2);
        mView.findViewById(R.id.restart).setOnClickListener(v -> {
            Intent intent = new Intent(Kelimeortaokul.this,Kelimeortaokul.class);
            startActivity(intent);
            finish();
        });

        mView.findViewById(R.id.next).setOnClickListener(v -> {
            if (Objects.equals(sev, "5.SINIFbölüm1s1")){
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm1s2").apply();
            } else if (Objects.equals(sev, "5.SINIFbölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm1s3").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm1s4").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm1s5").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm1s5")) {
                i++;
                alertDialog.dismiss();
                Toast.makeText(this, "Bölüm 1 Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }  if (Objects.equals(sev, "5.SINIFbölüm3s1")){
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm3s2").apply();
            } else if (Objects.equals(sev, "5.SINIFbölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm3s3").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm3s4").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm3s4")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm3s5").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm3s5")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            } if (Objects.equals(sev, "5.SINIFbölüm2s1")){
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm2s2").apply();
            } else if (Objects.equals(sev, "5.SINIFbölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm2s3").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm2s4").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm2s4")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm2s5").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm2s5")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "5.SINIFbölüm4s1")){
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm4s2").apply();
            } else if (Objects.equals(sev, "5.SINIFbölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm4s3").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm4s3")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm4s4").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm4s4")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm4s5").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm4s5")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm4s6").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm4s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "5.SINIFbölüm5s1")){
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm5s2").apply();
            } else if (Objects.equals(sev, "5.SINIFbölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm5s3").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm5s3")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm5s4").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm5s4")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm5s5").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm5s5")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm5s6").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm5s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "5.SINIFbölüm6s1")){
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm6s2").apply();
            } else if (Objects.equals(sev, "5.SINIFbölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm6s3").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm6s3")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm6s4").apply();
            }else if (Objects.equals(sev, "5.SINIFbölüm6s4")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm6s5").apply();

            }else if (Objects.equals(sev, "5.SINIFbölüm6s5")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "5.SINIFbölüm7s1")){
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm7s2").apply();
            } else if (Objects.equals(sev, "5.SINIFbölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","5.SINIFbölüm7s3").apply();

            }else if (Objects.equals(sev, "5.SINIFbölüm7s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            /// 6 . SINIF


            if (Objects.equals(sev, "6.SINIFbölüm1s1")){
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm1s2").apply();
            } else if (Objects.equals(sev, "6.SINIFbölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm1s3").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm1s4").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm1s5").apply();

            }else if (Objects.equals(sev, "6.SINIFbölüm1s5")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "6.SINIFbölüm2s1")){
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm2s2").apply();
            } else if (Objects.equals(sev, "6.SINIFbölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm2s3").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm2s4").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm2s4")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm2s5").apply();

            }else if (Objects.equals(sev, "6.SINIFbölüm2s5")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "6.SINIFbölüm3s1")){
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm3s2").apply();
            } else if (Objects.equals(sev, "6.SINIFbölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm3s3").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm3s4").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm3s4")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm3s5").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm3s5")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm3s6").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm3s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "6.SINIFbölüm4s1")){
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm4s2").apply();
            } else if (Objects.equals(sev, "6.SINIFbölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm4s3").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm4s3")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm4s4").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm4s4")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm4s5").apply();

            }else if (Objects.equals(sev, "6.SINIFbölüm4s5")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "6.SINIFbölüm5s1")){
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm5s2").apply();
            } else if (Objects.equals(sev, "6.SINIFbölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm5s3").apply();
              }else if (Objects.equals(sev, "6.SINIFbölüm5s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "6.SINIFbölüm6s1")){
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm6s2").apply();
            } else if (Objects.equals(sev, "6.SINIFbölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm6s3").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm6s3")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm6s4").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm6s4")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm6s5").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm6s5")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "6.SINIFbölüm7s1")){
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm7s2").apply();
            } else if (Objects.equals(sev, "6.SINIFbölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm7s3").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm7s3")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "6.SINIFbölüm8s1")){
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm8s2").apply();
            } else if (Objects.equals(sev, "6.SINIFbölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm8s3").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm8s4").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm8s4")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm8s5").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm8s5")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm8s6").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm8s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }




            if (Objects.equals(sev, "6.SINIFbölüm9s1")){
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm9s2").apply();
            } else if (Objects.equals(sev, "6.SINIFbölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm9s3").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm9s3")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm9s4").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm9s4")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm9s5").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm9s5")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm9s6").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm9s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "6.SINIFbölüm10s1")){
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm10s2").apply();
            } else if (Objects.equals(sev, "6.SINIFbölüm10s2")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm10s3").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm10s3")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm10s4").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm10s4")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm10s5").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm10s5")) {
                sharedPreferences.edit().putString("seviye1","6.SINIFbölüm10s6").apply();
            }else if (Objects.equals(sev, "6.SINIFbölüm10s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 10. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            // 7. sınıf

            if (Objects.equals(sev, "7.SINIFbölüm1s1")){
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm1s2").apply();
            } else if (Objects.equals(sev, "7.SINIFbölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm1s3").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm1s4").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm1s5").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm1s5")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm1s6").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm1s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "7.SINIFbölüm2s1")){
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm2s2").apply();
            } else if (Objects.equals(sev, "7.SINIFbölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm2s3").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm2s4").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm2s4")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm2s5").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm2s5")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm2s6").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm2s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "7.SINIFbölüm3s1")){
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm3s2").apply();
            } else if (Objects.equals(sev, "7.SINIFbölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm3s3").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm3s4").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm3s4")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm3s5").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm3s5")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm3s6").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm3s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "7.SINIFbölüm4s1")){
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm4s2").apply();
            } else if (Objects.equals(sev, "7.SINIFbölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm4s3").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm4s3")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm4s4").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm4s4")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm4s5").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm4s5")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm4s6").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm4s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "7.SINIFbölüm5s1")){
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm5s2").apply();
            } else if (Objects.equals(sev, "7.SINIFbölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm5s3").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm5s3")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm5s4").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm5s4")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm5s5").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm5s5")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm5s6").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm5s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "7.SINIFbölüm6s1")){
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm6s2").apply();
            } else if (Objects.equals(sev, "7.SINIFbölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm6s3").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm6s3")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm6s4").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm6s4")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm6s5").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm6s5")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm6s6").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm6s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "7.SINIFbölüm7s1")){
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm7s2").apply();
            } else if (Objects.equals(sev, "7.SINIFbölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm7s3").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm7s3")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm7s4").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm7s4")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm7s5").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm7s5")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm7s6").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm7s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "7.SINIFbölüm8s1")){
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm8s2").apply();
            } else if (Objects.equals(sev, "7.SINIFbölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm8s3").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm8s4").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm8s4")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm8s5").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm8s5")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm8s6").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm8s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }




            if (Objects.equals(sev, "7.SINIFbölüm9s1")){
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm9s2").apply();
            } else if (Objects.equals(sev, "7.SINIFbölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm9s3").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm9s3")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm9s4").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm9s4")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm9s5").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm9s5")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm9s6").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm9s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "7.SINIFbölüm10s1")){
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm10s2").apply();
            } else if (Objects.equals(sev, "7.SINIFbölüm10s2")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm10s3").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm10s3")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm10s4").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm10s4")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm10s5").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm10s5")) {
                sharedPreferences.edit().putString("seviye1","7.SINIFbölüm10s6").apply();
            }else if (Objects.equals(sev, "7.SINIFbölüm10s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 10. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            // 8. SINIF

            if (Objects.equals(sev, "8.SINIFbölüm1s1")){
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm1s2").apply();
            } else if (Objects.equals(sev, "8.SINIFbölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm1s3").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm1s4").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm1s5").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm1s5")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm1s6").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm1s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "8.SINIFbölüm2s1")){
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm2s2").apply();
            } else if (Objects.equals(sev, "8.SINIFbölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm2s3").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm2s4").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm2s4")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm2s5").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm2s5")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm2s6").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm2s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "8.SINIFbölüm3s1")){
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm3s2").apply();
            } else if (Objects.equals(sev, "8.SINIFbölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm3s3").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm3s4").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm3s4")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm3s5").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm3s5")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm3s6").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm3s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "8.SINIFbölüm4s1")){
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm4s2").apply();
            } else if (Objects.equals(sev, "8.SINIFbölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm4s3").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm4s3")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm4s4").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm4s4")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm4s5").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm4s5")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm4s6").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm4s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "8.SINIFbölüm5s1")){
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm5s2").apply();
            } else if (Objects.equals(sev, "8.SINIFbölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm5s3").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm5s3")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm5s4").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm5s4")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm5s5").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm5s5")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm5s6").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm5s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "8.SINIFbölüm6s1")){
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm6s2").apply();
            } else if (Objects.equals(sev, "A2bölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm6s3").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm6s3")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm6s4").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm6s4")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm6s5").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm6s5")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm6s6").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm6s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "8.SINIFbölüm7s1")){
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm7s2").apply();
            } else if (Objects.equals(sev, "8.SINIFbölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm7s3").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm7s3")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm7s4").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm7s4")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm7s5").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm7s5")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm7s6").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm7s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "8.SINIFbölüm8s1")){
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm8s2").apply();
            } else if (Objects.equals(sev, "8.SINIFbölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm8s3").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm8s4").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm8s4")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm8s5").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm8s5")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm8s6").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm8s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }




            if (Objects.equals(sev, "8.SINIFbölüm9s1")){
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm9s2").apply();
            } else if (Objects.equals(sev, "8.SINIFbölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm9s3").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm9s3")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm9s4").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm9s4")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm9s5").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm9s5")) {
                sharedPreferences.edit().putString("seviye1","8.SINIFbölüm9s6").apply();
            }else if (Objects.equals(sev, "8.SINIFbölüm9s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if(i == 0) {
                alertDialog.dismiss();
                Intent intent = new Intent(Kelimeortaokul.this, Kelimeortaokul.class);
                startActivity(intent);
                finish();
            }
        });
        mView.findViewById(R.id.anamenu).setOnClickListener(v -> {
            alertDialog.dismiss();
            Intent intent = new Intent(Kelimeortaokul.this,MainActivity5.class);
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
                    mInterstitialAd.show(Kelimeortaokul.this);
                }
            ShowDialogBox();
            if (sev.contains("5.SINIFbölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='5.SINIFbölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='5.SINIFbölüm1'");
            }
            if (sev.contains("5.SINIFbölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='5.SINIFbölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='5.SINIFbölüm2'");
            }
            if (sev.contains("5.SINIFbölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='5.SINIFbölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='5.SINIFbölüm3'");
            }
            if (sev.contains("5.SINIFbölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='5.SINIFbölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='5.SINIFbölüm4'");
            }
            if (sev.contains("A1bölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A1bölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A1bölüm5'");
            }
            if (sev.contains("5.SINIFbölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='5.SINIFbölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='5.SINIFbölüm6'");
            }
            if (sev.contains("5.SINIFbölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='5.SINIFbölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='5.SINIFbölüm7'");
            }


            if (sev.contains("6.SINIFbölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='6.SINIFbölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='6.SINIFbölüm1'");
            }
            if (sev.contains("6.SINIFbölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='6.SINIFbölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='6.SINIFbölüm2'");
            }
            if (sev.contains("6.SINIFbölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='6.SINIFbölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='6.SINIFbölüm3'");
            }
            if (sev.contains("6.SINIFbölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='6.SINIFbölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='6.SINIFbölüm4'");
            }
            if (sev.contains("6.SINIFbölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='6.SINIFbölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='6.SINIFbölüm5'");
            }
            if (sev.contains("6.SINIFbölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='6.SINIFbölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='6.SINIFbölüm6'");
            }
            if (sev.contains("6.SINIFbölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='6.SINIFbölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='6.SINIFbölüm7'");
            }
            if (sev.contains("6.SINIFbölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='6.SINIFbölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='6.SINIFbölüm8'");
            }
            if (sev.contains("6.SINIFbölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='6.SINIFbölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='6.SINIFbölüm9'");
            }
            if (sev.contains("6.SINIFbölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='6.SINIFbölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='6.SINIFbölüm10'");
            }
            // 7. SINIF

            if (sev.contains("7.SINIFbölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='7.SINIFbölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='7.SINIFbölüm1'");
            }
            if (sev.contains("7.SINIFbölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='7.SINIFbölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='7.SINIFbölüm2'");
            }
            if (sev.contains("7.SINIFbölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='7.SINIFbölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='7.SINIFbölüm3'");
            }
            if (sev.contains("7.SINIFbölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='7.SINIFbölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='7.SINIFbölüm4'");
            }
            if (sev.contains("7.SINIFbölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='7.SINIFbölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='7.SINIFbölüm5'");
            }
            if (sev.contains("7.SINIFbölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='7.SINIFbölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='7.SINIFbölüm6'");
            }
            if (sev.contains("7.SINIFbölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='7.SINIFbölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='7.SINIFbölüm7'");
            }
            if (sev.contains("7.SINIFbölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='7.SINIFbölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='7.SINIFbölüm8'");
            }
            if (sev.contains("7.SINIFbölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='7.SINIFbölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='7.SINIFbölüm9'");
            }
            if (sev.contains("7.SINIFbölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='7.SINIFbölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='7.SINIFbölüm10'");
            }








            // 8. SINIF



            if (sev.contains("8.SINIFbölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='8.SINIFbölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='8.SINIFbölüm1'");
            }
            if (sev.contains("8.SINIFbölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='8.SINIFbölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='8.SINIFbölüm2'");
            }
            if (sev.contains("8.SINIFbölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='8.SINIFbölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='8.SINIFbölüm3'");
            }
            if (sev.contains("8.SINIFbölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='8.SINIFbölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='8.SINIFbölüm4'");
            }
            if (sev.contains("8.SINIFbölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='8.SINIFbölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='8.SINIFbölüm5'");
            }
            if (sev.contains("8.SINIFbölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='8.SINIFbölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='8.SINIFbölüm6'");
            }
            if (sev.contains("8.SINIFbölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='8.SINIFbölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='8.SINIFbölüm7'");
            }
            if (sev.contains("8.SINIFbölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='8.SINIFbölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='8.SINIFbölüm8'");
            }
            if (sev.contains("8.SINIFbölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='8.SINIFbölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='8.SINIFbölüm9'");
            }

            database.execSQL("UPDATE P SET puan=puan+" + sorudogru * 2 + "");


            if (sev.equals("5.SINIFbölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm1s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm1s5yildiz", "2").apply();
                }
            }

            if (sev.equals("5.SINIFbölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm2s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm2s5yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm3s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm3s5yildiz", "2").apply();
                }
            }

            if (sev.equals("5.SINIFbölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm4s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s4yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm4s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s5yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm4s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm4s6yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm5s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s4yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm5s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s5yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm5s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm5s6yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm6s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s4yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm6s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm6s5yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("5.SINIFbölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("5.SINIFbölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("5.SINIFbölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("5.SINIFbölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm1s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm1s5yildiz", "2").apply();
                }
            }

            if (sev.equals("6.SINIFbölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm2s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm2s5yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm3s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s5yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm3s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm3s6yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm4s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s4yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm4s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm4s5yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm5s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s4yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm5s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm5s5yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm6s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s4yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm6s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm6s5yildiz", "2").apply();
                }
            }

            if (sev.equals("6.SINIFbölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm8s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s5yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm8s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm8s6yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s3yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm9s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s4yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm9s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s5yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm9s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm9s6yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm10s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s1yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm10s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s2yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm10s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s3yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm10s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s4yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm10s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s5yildiz", "2").apply();
                }
            }
            if (sev.equals("6.SINIFbölüm10s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("6.SINIFbölüm10s6yildiz", "2").apply();
                }
            }




            // 7. SINIF




            if (sev.equals("7.SINIFbölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm1s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s5yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm1s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm1s6yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm2s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s5yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm2s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm2s6yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm3s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s5yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm3s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm3s6yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm4s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s4yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm4s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s5yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm4s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm4s6yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm5s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s4yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm5s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s5yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm5s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm5s6yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm6s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s4yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm6s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s5yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm6s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm6s6yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm7s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s4yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm7s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s5yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm7s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm7s6yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm8s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s5yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm8s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm8s6yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s3yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm9s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s4yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm9s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s5yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm9s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm9s6yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm10s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s1yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm10s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s2yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm10s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s3yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm10s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s4yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm10s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s5yildiz", "2").apply();
                }
            }
            if (sev.equals("7.SINIFbölüm10s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("7.SINIFbölüm10s6yildiz", "2").apply();
                }
            }



            // 8. SINIF




            if (sev.equals("8.SINIFbölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm1s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s5yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm1s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm1s6yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm2s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s5yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm2s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm2s6yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm3s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s5yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm3s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm3s6yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm4s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s4yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm4s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s5yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm4s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm4s6yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm5s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s4yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm5s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s5yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm5s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm5s6yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm6s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s4yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm6s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s5yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm6s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm6s6yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm7s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s4yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm7s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s5yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm7s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm7s6yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm8s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s5yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm8s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm8s6yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s3yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm9s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s4yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm9s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s5yildiz", "2").apply();
                }
            }
            if (sev.equals("8.SINIFbölüm9s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("8.SINIFbölüm9s6yildiz", "2").apply();
                }
            }





            // SORU EKRANI

        } else if (Objects.equals(sev, "5.SINIFbölüm1s1")) {
            soru1 = new Soru(ortaokul5bolum1s1[sorusay], ortaokul5bolum1c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();

        }else if (Objects.equals(sev, "5.SINIFbölüm1s2")){
            soru1 = new Soru(ortaokul5bolum1s2[sorusay], ortaokul5bolum1c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm1s3")){
            soru1 = new Soru(ortaokul5bolum1s3[sorusay], ortaokul5bolum1c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm1s4")){
            soru1 = new Soru(ortaokul5bolum1s4[sorusay], ortaokul5bolum1c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm1s5")){
            soru1 = new Soru(ortaokul5bolum1s5[sorusay], ortaokul5bolum1c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();

        }else if (Objects.equals(sev,"5.SINIFbölüm2s1")){
            soru1 = new Soru(ortaokul5bolum2s1[sorusay], ortaokul5bolum2c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm2s2")){
            soru1 = new Soru(ortaokul5bolum2s2[sorusay], ortaokul5bolum2c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm2s3")){
            soru1 = new Soru(ortaokul5bolum2s3[sorusay], ortaokul5bolum2c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm2s4")){
            soru1 = new Soru(ortaokul5bolum2s4[sorusay], ortaokul5bolum2c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm2s5")){
            soru1 = new Soru(ortaokul5bolum2s5[sorusay], ortaokul5bolum2c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();

        }else if (Objects.equals(sev, "5.SINIFbölüm3s1")){
            soru1 = new Soru(ortaokul5bolum3s1[sorusay], ortaokul5bolum3c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm3s2")){
            soru1 = new Soru(ortaokul5bolum3s2[sorusay], ortaokul5bolum3c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm3s3")){
            soru1 = new Soru(ortaokul5bolum3s3[sorusay], ortaokul5bolum3c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm3s4")){
            soru1 = new Soru(ortaokul5bolum3s4[sorusay], ortaokul5bolum3c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm3s5")){
            soru1 = new Soru(ortaokul5bolum3s5[sorusay],ortaokul5bolum3c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();

        }else if (Objects.equals(sev, "5.SINIFbölüm4s1")){
            soru1 = new Soru(ortaokul5bolum4s1[sorusay], ortaokul5bolum4c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm4s2")){
            soru1 = new Soru(ortaokul5bolum4s2[sorusay], ortaokul5bolum4c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm4s3")){
            soru1 = new Soru(ortaokul5bolum4s3[sorusay], ortaokul5bolum4c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm4s4")){
            soru1 = new Soru(ortaokul5bolum4s4[sorusay], ortaokul5bolum4c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm4s5")){
            soru1 = new Soru(ortaokul5bolum4s5[sorusay], ortaokul5bolum4c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm4s6")){
            soru1 = new Soru(ortaokul5bolum4s6[sorusay], ortaokul5bolum4c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm5s1")){
            soru1 = new Soru(ortaokul5bolum5s1[sorusay], ortaokul5bolum5c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm5s2")){
            soru1 = new Soru(ortaokul5bolum5s2[sorusay], ortaokul5bolum5c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm5s3")){
            soru1 = new Soru(ortaokul5bolum5s3[sorusay], ortaokul5bolum5c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm5s4")){
            soru1 = new Soru(ortaokul5bolum5s4[sorusay], ortaokul5bolum5c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm5s5")){
            soru1 = new Soru(ortaokul5bolum5s5[sorusay], ortaokul5bolum5c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm5s6")){
            soru1 = new Soru(ortaokul5bolum5s6[sorusay], ortaokul5bolum5c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm6s1")){
            soru1 = new Soru(ortaokul5bolum6s1[sorusay], ortaokul5bolum6c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm6s2")){
            soru1 = new Soru(ortaokul5bolum6s2[sorusay], ortaokul5bolum6c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm6s3")){
            soru1 = new Soru(ortaokul5bolum6s3[sorusay], ortaokul5bolum6c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm6s4")){
            soru1 = new Soru(ortaokul5bolum6s4[sorusay], ortaokul5bolum6c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm6s5")){
            soru1 = new Soru(ortaokul5bolum6s5[sorusay], ortaokul5bolum6c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();

        }else if (Objects.equals(sev, "5.SINIFbölüm7s1")){
            soru1 = new Soru(ortaokul5bolum7s1[sorusay], ortaokul5bolum7c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm7s2")){
            soru1 = new Soru(ortaokul5bolum7s2[sorusay], ortaokul5bolum7c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "5.SINIFbölüm7s3")){
            soru1 = new Soru(ortaokul5bolum7s3[sorusay], ortaokul5bolum7c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();



        }else if (Objects.equals(sev, "6.SINIFbölüm1s1")){
        soru1 = new Soru(ortaokul6bolum1s1[sorusay], ortaokul6bolum1c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm1s2")){
        soru1 = new Soru(ortaokul6bolum1s2[sorusay], ortaokul6bolum1c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm1s3")){
        soru1 = new Soru(ortaokul6bolum1s3[sorusay], ortaokul6bolum1c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm1s4")){
        soru1 = new Soru(ortaokul6bolum1s4[sorusay], ortaokul6bolum1c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm1s5")){
        soru1 = new Soru(ortaokul6bolum1s5[sorusay], ortaokul6bolum1c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "6.SINIFbölüm2s1")){
        soru1 = new Soru(ortaokul6bolum2s1[sorusay], ortaokul6bolum2c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm2s2")){
        soru1 = new Soru(ortaokul6bolum2s2[sorusay], ortaokul6bolum2c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm2s3")){
        soru1 = new Soru(ortaokul6bolum2s3[sorusay], ortaokul6bolum2c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm2s4")){
        soru1 = new Soru(ortaokul6bolum2s4[sorusay], ortaokul6bolum2c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm2s5")){
        soru1 = new Soru(ortaokul6bolum2s5[sorusay], ortaokul6bolum2c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "6.SINIFbölüm3s1")){
        soru1 = new Soru(ortaokul6bolum3s1[sorusay], ortaokul6bolum3c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm3s2")){
        soru1 = new Soru(ortaokul6bolum3s2[sorusay], ortaokul6bolum3c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm3s3")){
        soru1 = new Soru(ortaokul6bolum3s3[sorusay], ortaokul6bolum3c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm3s4")){
        soru1 = new Soru(ortaokul6bolum3s4[sorusay], ortaokul6bolum3c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm3s5")){
        soru1 = new Soru(ortaokul6bolum3s5[sorusay], ortaokul6bolum3c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm3s6")){
        soru1 = new Soru(ortaokul6bolum3s6[sorusay], ortaokul6bolum3c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm4s1")){
        soru1 = new Soru(ortaokul6bolum4s1[sorusay], ortaokul6bolum4c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm4s2")){
        soru1 = new Soru(ortaokul6bolum4s2[sorusay], ortaokul6bolum4c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm4s3")){
        soru1 = new Soru(ortaokul6bolum4s3[sorusay], ortaokul6bolum4c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm4s4")){
        soru1 = new Soru(ortaokul6bolum4s4[sorusay], ortaokul6bolum4c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm4s5")){
        soru1 = new Soru(ortaokul6bolum4s5[sorusay], ortaokul6bolum4c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "6.SINIFbölüm5s1")){
        soru1 = new Soru(ortaokul6bolum5s1[sorusay], ortaokul6bolum5c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm5s2")){
        soru1 = new Soru(ortaokul6bolum5s2[sorusay], ortaokul6bolum5c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm5s3")){
        soru1 = new Soru(ortaokul6bolum5s3[sorusay], ortaokul6bolum5c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();

        }else if (Objects.equals(sev, "6.SINIFbölüm6s1")){
        soru1 = new Soru(ortaokul6bolum6s1[sorusay], ortaokul6bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm6s2")){
        soru1 = new Soru(ortaokul6bolum6s2[sorusay], ortaokul6bolum6c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm6s3")){
        soru1 = new Soru(ortaokul6bolum6s3[sorusay], ortaokul6bolum6c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm6s4")){
        soru1 = new Soru(ortaokul6bolum6s4[sorusay], ortaokul6bolum6c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm6s5")){
        soru1 = new Soru(ortaokul6bolum6s5[sorusay], ortaokul6bolum6c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm6s6")){
        soru1 = new Soru(ortaokul6bolum6s1[sorusay], ortaokul6bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm7s1")){
        soru1 = new Soru(ortaokul6bolum7s1[sorusay], ortaokul6bolum7c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm7s2")){
        soru1 = new Soru(ortaokul6bolum7s2[sorusay], ortaokul6bolum7c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm7s3")){
        soru1 = new Soru(ortaokul6bolum7s3[sorusay], ortaokul6bolum7c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm8s1")){
        soru1 = new Soru(ortaokul6bolum8s1[sorusay], ortaokul6bolum8c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm8s2")){
        soru1 = new Soru(ortaokul6bolum8s2[sorusay], ortaokul6bolum8c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm8s3")){
        soru1 = new Soru(ortaokul6bolum8s3[sorusay],ortaokul6bolum8c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm8s4")){
        soru1 = new Soru(ortaokul6bolum8s4[sorusay], ortaokul6bolum8c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm8s5")){
        soru1 = new Soru(ortaokul6bolum8s5[sorusay], ortaokul6bolum8c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm8s6")){
        soru1 = new Soru(ortaokul6bolum8s6[sorusay], ortaokul6bolum8c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm9s1")){
        soru1 = new Soru(ortaokul6bolum9s1[sorusay], ortaokul6bolum9c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm9s2")){
        soru1 = new Soru(ortaokul6bolum9s2[sorusay], ortaokul6bolum9c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm9s3")){
        soru1 = new Soru(ortaokul6bolum9s3[sorusay], ortaokul6bolum9c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm9s4")){
        soru1 = new Soru(ortaokul6bolum9s4[sorusay], ortaokul6bolum9c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        } else if (Objects.equals(sev, "6.SINIFbölüm9s5")){
        soru1 = new Soru(ortaokul6bolum9s5[sorusay], ortaokul6bolum9c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm9s6")){
        soru1 = new Soru(ortaokul6bolum9s6[sorusay], ortaokul6bolum9c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm10s1")){
        soru1 = new Soru(ortaokul6bolum10s1[sorusay], ortaokul6bolum10c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm10s2")){
        soru1 = new Soru(ortaokul6bolum10s2[sorusay], ortaokul6bolum10c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm10s3")){
        soru1 = new Soru(ortaokul6bolum10s3[sorusay], ortaokul6bolum10c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm10s4")){
        soru1 = new Soru(ortaokul6bolum10s4[sorusay], ortaokul6bolum10c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm10s5")){
        soru1 = new Soru(ortaokul6bolum10s5[sorusay], ortaokul6bolum10c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "6.SINIFbölüm10s6")){
        soru1 = new Soru(ortaokul6bolum10s6[sorusay], ortaokul6bolum10c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();




        // 7. SINIF




        }else if (Objects.equals(sev, "7.SINIFbölüm1s1")){
        soru1 = new Soru(ortaokul7bolum1s1[sorusay], ortaokul7bolum1c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm1s2")){
        soru1 = new Soru(ortaokul7bolum1s2[sorusay], ortaokul7bolum1c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm1s3")){
        soru1 = new Soru(ortaokul7bolum1s3[sorusay], ortaokul7bolum1c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm1s4")){
        soru1 = new Soru(ortaokul7bolum1s4[sorusay], ortaokul7bolum1c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm1s5")){
        soru1 = new Soru(ortaokul7bolum1s5[sorusay], ortaokul7bolum1c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm1s6")){
        soru1 = new Soru(ortaokul7bolum1s6[sorusay], ortaokul7bolum1c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm2s1")){
        soru1 = new Soru(ortaokul7bolum2s1[sorusay], ortaokul7bolum2c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm2s2")){
        soru1 = new Soru(ortaokul7bolum2s2[sorusay], ortaokul7bolum2c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm2s3")){
        soru1 = new Soru(ortaokul7bolum2s3[sorusay], ortaokul7bolum2c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm2s4")){
        soru1 = new Soru(ortaokul7bolum2s4[sorusay], ortaokul7bolum2c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm2s5")){
        soru1 = new Soru(ortaokul7bolum2s5[sorusay], ortaokul7bolum2c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm2s6")){
        soru1 = new Soru(ortaokul7bolum2s6[sorusay], ortaokul7bolum2c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm3s1")){
        soru1 = new Soru(ortaokul7bolum3s1[sorusay], ortaokul7bolum3c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm3s2")){
        soru1 = new Soru(ortaokul7bolum3s2[sorusay], ortaokul7bolum3c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm3s3")){
        soru1 = new Soru(ortaokul7bolum3s3[sorusay], ortaokul7bolum3c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm3s4")){
        soru1 = new Soru(ortaokul7bolum3s4[sorusay], ortaokul7bolum3c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm3s5")){
        soru1 = new Soru(ortaokul7bolum3s5[sorusay], ortaokul7bolum3c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm3s6")){
        soru1 = new Soru(ortaokul7bolum3s6[sorusay], ortaokul7bolum3c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm4s1")){
        soru1 = new Soru(ortaokul7bolum4s1[sorusay], ortaokul7bolum4c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm4s2")){
        soru1 = new Soru(ortaokul7bolum4s2[sorusay], ortaokul7bolum4c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm4s3")){
        soru1 = new Soru(ortaokul7bolum4s3[sorusay], ortaokul7bolum4c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm4s4")){
        soru1 = new Soru(ortaokul7bolum4s4[sorusay], ortaokul7bolum4c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm4s5")){
        soru1 = new Soru(ortaokul7bolum4s5[sorusay], ortaokul7bolum4c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm4s6")){
        soru1 = new Soru(ortaokul7bolum4s6[sorusay], ortaokul7bolum4c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm5s1")){
        soru1 = new Soru(ortaokul7bolum5s1[sorusay], ortaokul7bolum5c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm5s2")){
        soru1 = new Soru(ortaokul7bolum5s2[sorusay], ortaokul7bolum5c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm5s3")){
        soru1 = new Soru(ortaokul7bolum5s3[sorusay], ortaokul7bolum5c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm5s4")){
        soru1 = new Soru(ortaokul7bolum5s4[sorusay], ortaokul7bolum5c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm5s5")){
        soru1 = new Soru(ortaokul7bolum5s5[sorusay], ortaokul7bolum5c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm5s6")){
        soru1 = new Soru(ortaokul7bolum5s6[sorusay], ortaokul7bolum5c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm6s1")){
        soru1 = new Soru(ortaokul7bolum6s1[sorusay], ortaokul7bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm6s2")){
        soru1 = new Soru(ortaokul7bolum6s2[sorusay], ortaokul7bolum6c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm6s3")){
        soru1 = new Soru(ortaokul7bolum6s3[sorusay], ortaokul7bolum6c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm6s4")){
        soru1 = new Soru(ortaokul7bolum6s4[sorusay], ortaokul7bolum6c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm6s5")){
        soru1 = new Soru(ortaokul7bolum6s5[sorusay], ortaokul7bolum6c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm6s6")){
        soru1 = new Soru(ortaokul7bolum6s6[sorusay], ortaokul7bolum6c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm7s1")){
        soru1 = new Soru(ortaokul7bolum7s1[sorusay], ortaokul7bolum7c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm7s2")){
        soru1 = new Soru(ortaokul7bolum7s2[sorusay], ortaokul7bolum7c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm7s3")){
        soru1 = new Soru(ortaokul7bolum7s3[sorusay], ortaokul7bolum7c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm7s4")){
        soru1 = new Soru(ortaokul7bolum7s4[sorusay], ortaokul7bolum7c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm7s5")){
        soru1 = new Soru(ortaokul7bolum7s5[sorusay], ortaokul7bolum7c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm7s6")){
        soru1 = new Soru(ortaokul7bolum7s6[sorusay],ortaokul7bolum7c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm8s1")){
        soru1 = new Soru(ortaokul7bolum8s1[sorusay],ortaokul7bolum8c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm8s2")){
        soru1 = new Soru(ortaokul7bolum8s2[sorusay], ortaokul7bolum8c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm8s3")){
        soru1 = new Soru(ortaokul7bolum8s3[sorusay], ortaokul7bolum8c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm8s4")){
        soru1 = new Soru(ortaokul7bolum8s4[sorusay],ortaokul7bolum8c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm8s5")){
        soru1 = new Soru(ortaokul7bolum8s5[sorusay], ortaokul7bolum8c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm8s6")){
        soru1 = new Soru(ortaokul7bolum8s6[sorusay], ortaokul7bolum8c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm9s1")){
        soru1 = new Soru(ortaokul7bolum9s1[sorusay], ortaokul7bolum9c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm9s2")){
        soru1 = new Soru(ortaokul7bolum9s2[sorusay], ortaokul7bolum9c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm9s3")){
        soru1 = new Soru(ortaokul7bolum9s3[sorusay], ortaokul7bolum9c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm9s4")){
        soru1 = new Soru(ortaokul7bolum9s4[sorusay], ortaokul7bolum9c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        } else if (Objects.equals(sev, "7.SINIFbölüm9s5")){
        soru1 = new Soru(ortaokul7bolum9s5[sorusay], ortaokul7bolum9c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm9s6")){
        soru1 = new Soru(ortaokul7bolum9s6[sorusay], ortaokul7bolum9c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm10s1")){
        soru1 = new Soru(ortaokul7bolum10s1[sorusay], ortaokul7bolum10c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm10s2")){
        soru1 = new Soru(ortaokul7bolum10s2[sorusay], ortaokul7bolum10c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm10s3")){
        soru1 = new Soru(ortaokul7bolum10s3[sorusay], ortaokul7bolum10c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm10s4")){
        soru1 = new Soru(ortaokul7bolum10s4[sorusay], ortaokul7bolum10c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm10s5")){
        soru1 = new Soru(ortaokul7bolum10s5[sorusay],ortaokul7bolum10c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "7.SINIFbölüm10s6")){
        soru1 = new Soru(ortaokul7bolum10s6[sorusay], ortaokul7bolum10c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();



        // 8. SINIF



        }else if (Objects.equals(sev, "8.SINIFbölüm1s1")){
        soru1 = new Soru(ortaokul8bolum1s1[sorusay], ortaokul8bolum1c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm1s2")){
        soru1 = new Soru(ortaokul8bolum1s2[sorusay], ortaokul8bolum1c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm1s3")){
        soru1 = new Soru(ortaokul8bolum1s3[sorusay], ortaokul8bolum1c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm1s4")){
        soru1 = new Soru(ortaokul8bolum1s4[sorusay], ortaokul8bolum1c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm1s5")){
        soru1 = new Soru(ortaokul8bolum1s5[sorusay], ortaokul8bolum1c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm1s6")){
        soru1 = new Soru(ortaokul8bolum1s6[sorusay], ortaokul8bolum1c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm2s1")){
        soru1 = new Soru(ortaokul8bolum2s1[sorusay], ortaokul8bolum2c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm2s2")){
        soru1 = new Soru(ortaokul8bolum2s2[sorusay], ortaokul8bolum2c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm2s3")){
        soru1 = new Soru(ortaokul8bolum2s3[sorusay], ortaokul8bolum2c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm2s4")){
        soru1 = new Soru(ortaokul8bolum2s4[sorusay], ortaokul8bolum2c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm2s5")){
        soru1 = new Soru(ortaokul8bolum2s5[sorusay],ortaokul8bolum2c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm2s6")){
        soru1 = new Soru(ortaokul8bolum2s6[sorusay], ortaokul8bolum2c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm3s1")){
        soru1 = new Soru(ortaokul8bolum3s1[sorusay], ortaokul8bolum3c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm3s2")){
        soru1 = new Soru(ortaokul8bolum3s2[sorusay], ortaokul8bolum3c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm3s3")){
        soru1 = new Soru(ortaokul8bolum3s3[sorusay], ortaokul8bolum3c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm3s4")){
        soru1 = new Soru(ortaokul8bolum3s4[sorusay], ortaokul8bolum3c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm3s5")){
        soru1 = new Soru(ortaokul8bolum3s5[sorusay],ortaokul8bolum3c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm3s6")){
        soru1 = new Soru(ortaokul8bolum3s6[sorusay], ortaokul8bolum3c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm4s1")){
        soru1 = new Soru(ortaokul8bolum4s1[sorusay], ortaokul8bolum4c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm4s2")){
        soru1 = new Soru(ortaokul8bolum4s2[sorusay], ortaokul8bolum4c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm4s3")){
        soru1 = new Soru(ortaokul8bolum4s3[sorusay], ortaokul8bolum4c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm4s4")){
        soru1 = new Soru(ortaokul8bolum4s4[sorusay], ortaokul8bolum4c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm4s5")){
        soru1 = new Soru(ortaokul8bolum4s5[sorusay], ortaokul8bolum4c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm4s6")){
        soru1 = new Soru(ortaokul8bolum4s6[sorusay], ortaokul8bolum4c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm5s1")){
        soru1 = new Soru(ortaokul8bolum5s1[sorusay], ortaokul8bolum5c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm5s2")){
        soru1 = new Soru(ortaokul8bolum5s2[sorusay], ortaokul8bolum5c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm5s3")){
        soru1 = new Soru(ortaokul8bolum5s3[sorusay], ortaokul8bolum5c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm5s4")){
        soru1 = new Soru(ortaokul8bolum5s4[sorusay], ortaokul8bolum5c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm5s5")){
        soru1 = new Soru(ortaokul8bolum5s5[sorusay], ortaokul8bolum5c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm5s6")){
        soru1 = new Soru(ortaokul8bolum5s6[sorusay], ortaokul8bolum5c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm6s1")){
        soru1 = new Soru(ortaokul8bolum6s1[sorusay], ortaokul8bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm6s2")){
        soru1 = new Soru(ortaokul8bolum6s2[sorusay], ortaokul8bolum6c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm6s3")){
        soru1 = new Soru(ortaokul8bolum6s3[sorusay], ortaokul8bolum6c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm6s4")){
        soru1 = new Soru(ortaokul8bolum6s4[sorusay], ortaokul8bolum6c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm6s5")){
        soru1 = new Soru(ortaokul8bolum6s5[sorusay], ortaokul8bolum6c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm6s6")){
        soru1 = new Soru(ortaokul8bolum6s1[sorusay], ortaokul8bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm7s1")){
        soru1 = new Soru(ortaokul8bolum7s1[sorusay], ortaokul8bolum7c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm7s2")){
        soru1 = new Soru(ortaokul8bolum7s2[sorusay], ortaokul8bolum7c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm7s3")){
        soru1 = new Soru(ortaokul8bolum7s3[sorusay], ortaokul8bolum7c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm7s4")){
        soru1 = new Soru(ortaokul8bolum7s4[sorusay], ortaokul8bolum7c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm7s5")){
        soru1 = new Soru(ortaokul8bolum7s5[sorusay], ortaokul8bolum7c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm7s6")){
        soru1 = new Soru(ortaokul8bolum7s6[sorusay], ortaokul8bolum7c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm8s1")){
        soru1 = new Soru(ortaokul8bolum8s1[sorusay], ortaokul8bolum8c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm8s2")){
        soru1 = new Soru(ortaokul8bolum8s2[sorusay], ortaokul8bolum8c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm8s3")){
        soru1 = new Soru(ortaokul8bolum8s3[sorusay], ortaokul8bolum8c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm8s4")){
        soru1 = new Soru(ortaokul8bolum8s4[sorusay], ortaokul8bolum8c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm8s5")){
        soru1 = new Soru(ortaokul8bolum8s5[sorusay], ortaokul8bolum8c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm8s6")){
        soru1 = new Soru(ortaokul8bolum8s6[sorusay], ortaokul8bolum8c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm9s1")){
        soru1 = new Soru(ortaokul8bolum9s1[sorusay], ortaokul8bolum9c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm9s2")){
        soru1 = new Soru(ortaokul8bolum9s2[sorusay], ortaokul8bolum9c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm9s3")){
        soru1 = new Soru(ortaokul8bolum9s3[sorusay], ortaokul8bolum9c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm9s4")){
        soru1 = new Soru(ortaokul8bolum9s4[sorusay], ortaokul8bolum9c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        } else if (Objects.equals(sev, "8.SINIFbölüm9s5")){
        soru1 = new Soru(ortaokul8bolum9s5[sorusay], ortaokul8bolum9c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "8.SINIFbölüm9s6")){
        soru1 = new Soru(ortaokul8bolum9s6[sorusay], ortaokul8bolum9c6[sorusay], yanlislar3, yanlislar4);
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
