package com.mert.kolayingilizce.lise;

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
import com.mert.kolayingilizce.ortaokul.Kelimeortaokul;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class Kelimelise extends AppCompatActivity {
    /// DATA

    // 9 . SINIF

    // 1. bölüm
    String [] lise9bolum1s1 = {"excuse me ","far ","fascinating ","fashion designer ","fight ","financial ","find ","fine ","finish ","fire station "};
    String [] lise9bolum1s2 = {"first of all ","fix ","florist ","flower ","football player ","for a long time ","French ","future jobs ","gardener ","German "};
    String [] lise9bolum1s3 = {"Germany ","get together ","go ahead ","go back ","go down ","go past ","go shopping ","go straight ahead ","grandfather ","grandmother "};
    String [] lise9bolum1s4 = {"grandparents ","Greece ","Greek ","greeting ","hammer ","hardware store ","have a great time ","help out ","hope ","hotel reservation "};
    String [] lise9bolum1s5 = {"how do you do? ","hurt ","husband ","I am so glad to meet you ","Indian ","introduce ","it's great to see you ","job ","journalist ","keep "};
    String [] lise9bolum1s6 = {"know ","laundromat ","law book ","lawyer ","learn ","leave ","library ","listen ","long time no see ","look for "};

    String [] lise9bolum1c1 = {"afedersiniz","uzak","büyüleyici","modacı","dövüşmek","parasal","bulmak","iyi","bitirmek","itfaiye merkezi"};
    String [] lise9bolum1c2 = {"öncelikle","tamir etmek","çiçekçi","çiçek","futbolcu","uzun zamandan beri","Fransız","nageleceğin meslekleri","bahçıvan","Alman"};
    String [] lise9bolum1c3 = {"Almanya","bir araya gelmek","devam etmek","geri gitmek","inmek","geçmek","alışverişe çıkmak","dümdüz gitmek","büyükbaba","büyükanne"};
    String [] lise9bolum1c4 = {"büyükbaba veya büyükanne","Yunanistan","Yunan","selamlaşma","çekiç","nalbur dükkanı","iyi vakit geçirmek","yardımda bulunmak","ummak","otel rezervasyonu"};
    String [] lise9bolum1c5 = {"nasılsınız","incinmek","koca","tanıştığımıza çok memnun oldum","Hintli","tanıtmak","sizi görmek çok güzel","meslek","gazeteci","Tutmak"};
    String [] lise9bolum1c6 = {"bilmek","çamaşırhane","hukuk kitabı","avukat","öğrenmek","ayrılmak","kütüphane","dinlemek","görüşmeyeli uzun zaman oldu","aramak"};

    // 2 . bölüm

    String [] lise9bolum2s1 = {"environment","across","all over","apartment building","around","as you know","at the end of","auditorium","bacause","baker's"};
    String [] lise9bolum2s2 = {"bazaar","beach","beautiful","bed","bedroom","bedside table","behind","between","blue sky","bookshop"};
    String [] lise9bolum2s3 = {"borrow","bottom","bright","bus station","busy","butcher's","by the end of the day","cafe","called","calm"};
    String [] lise9bolum2s4 = {"candle","car park","cellar","cheap","chemist's","city centre","city hall","close","clothes shop","coffee table"};
    String [] lise9bolum2s5 = {"coin","compare","corner","countryside","court house","crime","crowded","cushion","day-trip","definitely"};
    String [] lise9bolum2s6 = {"delicious","difficult","direction","dirty","drive","each other","easy","electronic store","equally","every morning"};



    String [] lise9bolum2c1 = {"çevre","karşısında","tamamen","apartman binası","çevrede","biliyorsunuz ki","sonunda","konser salonu","çünkü","fırın"};
    String [] lise9bolum2c2 = {"pazar","kumsal","güzel","yatak","yatak odası","komodin","arkasında","arasında","mavi gökyüzü","kitapçı"};
    String [] lise9bolum2c3 = {"ödünç almak","alt","parlak","otobüs durağı","meşgul","kasap","günün sonunda","kafe","adlandırılan","sakin"};
    String [] lise9bolum2c4 = {"mum","otopark","kiler","ucuz","eczane","kent merkezi","belediye binası","yakın","giyim mağazası","sehpa"};
    String [] lise9bolum2c5 = {"madeni para","karşılaştırmak","köşe","kırsal kesim","adliye","suç","kalabalık","minder","günübirlik gezi","kesinlikle"};
    String [] lise9bolum2c6 = {"lezzetli","zor","yön","kirli","sürmek","birbirini","kolay","elektronik dükkanı","eşit olarak","her sabah"};


    // 3. bölüm


    String [] lise9bolum3s1 = {"action","adventure","animation","comedy","drama","historical","historical","horror","love story","musical"};
    String [] lise9bolum3s2 = {"romantic comedy","science fiction","thriller","war","western","NOUNS AND ACTIVITIES","a feel-good movie","accept","actor","actress"};
    String [] lise9bolum3s3 = {"advise","ambition","award","being in nature","cast","celebrity","character","collecting things","cycling","dancing"};
    String [] lise9bolum3s4 = {"director","do pilates","doing origami","doing sports","doing yoga","excuse","film reviews","going for a walk","hiking","knitting"};
    String [] lise9bolum3s5 = {"location","marbling","novel","opinion","playing chess","playing golf","playing the guitar","plot","preference","reading a book"};
    String [] lise9bolum3s6 = {"refuse","rollerblading","scenario","scuba diving","setting","singing","snowboarding","stars","story of the movie","story"};



    String [] lise9bolum3c1 = {" aksiyon"," macera"," animasyon"," komedi"," drama"," tarihi"," tarihi film"," korku"," aşk filmi"," müzikal"};
    String [] lise9bolum3c2 = {" romantik komedi"," bilim kurgu"," gerilim filmi"," savaş filmi"," kovboy filmi"," kovboy filmi"," iyi hissettiren film"," kabul etmek"," erkek oyuncu"," kadın oyuncu"};
    String [] lise9bolum3c3 = {" tavsiye etmek"," istek"," ödül"," tabiatta olmak"," rol vermek"," ünlü"," karakter"," koleksiyon yapmak"," bisiklete binme"," dans etme"};
    String [] lise9bolum3c4 = {" yönetmen"," pilates yapmak"," origami yapmak"," spor yapmak"," yoga yapma"," mazeret"," film incelemesi"," yürüyüşe çıkmak"," doğa yürüyüşü"," örgü örmek"};
    String [] lise9bolum3c5 = {" konum"," ebru sanatı"," roman"," fikir"," satranç oynama"," golf oynama"," gitar çalma"," filmin konusu"," tercih"," kitap okumak"};
    String [] lise9bolum3c6 = {" reddetmek"," patenle kayma"," senaryo"," tüple dalış"," filmin çekildiği yer"," şarkı söylemek"," kar kayağı"," film oyuncuları"," filmin hikayesi"," hikaye"};


    // 4. bölüm



    String [] lise9bolum4s1 = {"amaze","ask","call","catch fish","cause","change","clean the kitchen","come back home","cook","do gardening"};
    String [] lise9bolum4s2 = {"do homework","do ironing","dream","drive","end","fall","feed the animal","fix","freeze","get up"};
    String [] lise9bolum4s3 = {"go camping","go on holiday","go shopping","go to the gym","go to the mosque","go trekking","hate","have a bath","have a match","have breakfast"};
    String [] lise9bolum4s4 = {"have lunch","help people","hike","increase","keep","kiss","like","make money","measure","meet (her) friends"};
    String [] lise9bolum4s5 = {"meet","miss the bus","move","occur","pass","prepare breakfast","prevent","protect the environment","receive","reduce"};
    String [] lise9bolum4s6 = {"ride","run","sing","sleep late","sleep","speak","start","stay at home","stop","survive"};



    String [] lise9bolum4c1 = {" şaşırtmak"," sormak"," aramak"," balık yakalamak"," sebep olmak"," değiştirmek"," mutfağı temizlemek"," eve geri gelmek"," yemek pişirmek"," bahçe işleri yapmak"};
    String [] lise9bolum4c2 = {" ödev yapmak"," ütü yapmak"," hayal kurmak"," araba sürmek"," bitmek"," düşmek"," hayvanı beslemek"," tamir etmek"," donmak"," kalkmak"};
    String [] lise9bolum4c3 = {" kampa gitmek"," tatile gitmek"," alışverişe gitmek"," spor salonuna gitmek"," camiye gitmek"," doğa yürüyüşü yapmak"," nefret etmek"," banyo yapmak"," maç yapmak"," kahvaltı etmek"};
    String [] lise9bolum4c4 = {" öğle yemeği yemek"," insanlara yardım etmek"," yürüyüşe çıkmak"," artmak"," yakalamak, tutmak"," öpmek"," hoşlanmak"," para kazanmak"," ölçmek"," arkadaşlarıyla buluşmak"};
    String [] lise9bolum4c5 = {" buluşmak, tanışmak"," otobüsü kaçırmak"," taşınmak"," meydana gelmek"," geçmek"," kahvaltı hazırlamak"," önlemek"," çevreyi korumak"," almak"," azaltmak"};
    String [] lise9bolum4c6 = {" sürmek"," koşmak"," şarkı söylemek"," geç uyumak"," uyumak"," konuşmak"," başlamak"," evde kalmak"," durmak"," hayatta kalmak"};


    // 5. bölüm



    String [] lise9bolum5s1 = {"attractive","bald","beard","beautiful","curly hair","dark skin","dyed hair","elegant","fair hair","fat"};
    String [] lise9bolum5s2 = {"good-looking","green eyes","handsome","headscarf","long face","long hair","loose hair","medium build","medium height","medium weight"};
    String [] lise9bolum5s3 = {"middle-aged","moustache","old","plump","pretty","short","shoulder-length hair","slim","small nose","spiky hair"};
    String [] lise9bolum5s4 = {"straight hair","tall","thin","ugly","wavy hair","wear glasses","well-built","wrinkles","young","belt"};
    String [] lise9bolum5s5 = {"blouse","boots","bracelet","cap","clutch","coat","dress","earmuffs","flip flops","gloves"};
    String [] lise9bolum5s6 = {"hair-band","headscarf","high-heeled shoes","jeans","necklace","sandals","shirt","shorts","skirt","slippers"};



    String [] lise9bolum5c1 = {" çekici, alımlı"," kel"," sakal"," güzel"," kıvırcık saç"," koyu ten"," boyalı saç"," şık"," kumral saç"," şişman"};
    String [] lise9bolum5c2 = {" güzel / yakışıklı"," yeşil göz"," yakışıklı"," başörtüsü"," uzun yüz"," uzun saç"," saçlarını açmak"," orta yapılı"," orta boylu"," orta kilolu"};
    String [] lise9bolum5c3 = {" orta yaşlı"," bıyık"," yaşlı"," toplu, kilolu"," sevimli"," kısa"," omuza gelen saç"," zayıf, ince"," küçük burun"," saçları dik dik"};
    String [] lise9bolum5c4 = {" düz saç"," uzun"," ince, zayıf"," çirkin"," dalgalı saç"," gözlük takmak"," yapılı"," kırışıklıklar"," genç"," kemer"};
    String [] lise9bolum5c5 = {" bluz"," bot"," bilezik"," şapka"," el çantası"," mont, kaban"," elbise"," kulak koruyucusu"," parmak arası terlik"," eldiven"};
    String [] lise9bolum5c6 = {" saç bandı"," başörtüsü"," yüksek topuklu ayakkabı"," kot pantolon"," kolye"," sandalet"," gömlek"," şort"," etek"," terlik"};



    //6. bölüm


    String [] lise9bolum6s1 = {"airlines","airport","aisle seat","ancient","announcement","arrival","arrive","bagel","baggage","beans"};
    String [] lise9bolum6s2 = {"beef","bill","board","boarding pass","boat tour","book a flight","boring","breakfast","bring","business class"};
    String [] lise9bolum6s3 = {"busy","buy a ticket","cancel","capital","cheap","check-in desk","cheese","chopsticks","clothing","crowded"};
    String [] lise9bolum6s4 = {"culture","customer","customs","delay","delicious","dessert","destination","disgusting","dish","doughnuts"};
    String [] lise9bolum6s5 = {"drink something","dumpling","economy class","exciting","expensive","experience","fabulous","fasten seat belt","first class","fish"};
    String [] lise9bolum6s6 = {"flight","flour","foreign country","foreigners","fresh","fried tomatoes","fries","garlic","gate number","gate"};



    String [] lise9bolum6c1 = {" haya yolları"," havalimanı"," koridor koltuğu"," antik"," anons"," varış"," varmak"," simit"," bagaj, valiz"," fasülye"};
    String [] lise9bolum6c2 = {" sığır eti"," hesap"," uçağa binmek"," uçuş kartı"," tekne gezisi"," uçak bileti ayırtmak"," sıkıcı"," kahvaltı"," getirmek"," ticari sınıf"};
    String [] lise9bolum6c3 = {" meşgul, yoğun"," bilet almak"," iptal etmek"," başkent"," ucuz"," bilet kontrol masası"," peynir"," yemek çubukları"," giyim"," kalabalık"};
    String [] lise9bolum6c4 = {" kültür"," müşteri"," gelenek"," ertelemek"," lezzetli"," tatlı"," gidilecek yer"," iğrenç, berbat"," yemek"," çörek, gözleme"};
    String [] lise9bolum6c5 = {" bir şey içmek"," çin mantısı"," ekonomi sınıfı"," heyecanlı"," pahalı"," tecrübe, deneyim"," olağanüstü"," emniyet kemeri takmak"," birinci sınıf"," balık"};
    String [] lise9bolum6c6 = {" uçuş"," un"," yabancı ülke"," yabancılar"," taze"," kızarmış domates"," patates kızartması"," sarımsak"," kapı numarası"," kapı"};


    // 7. bölüm


    String [] lise9bolum7s1 = {"accident","achievement","ancient kings","ancient sites","ancient times","ancient trade centre","architect","book","build","buy"};
    String [] lise9bolum7s2 = {"cable car","capital","castle","cemetery","century","ceremony","civilization","commit suicide","construct","convention"};
    String [] lise9bolum7s3 = {"cultural heritage","destroy","discover","empire","excavate","experience","future generations","gift","grow","historian"};
    String [] lise9bolum7s4 = {"historical structure","history","homeland","invent","island","ladder","legendary","lighthouse","lighthouse","location"};
    String [] lise9bolum7s5 = {"memory","millennium","mosque","mountain","museum","natural heritage","nominate","ornament","palace","pass"};
    String [] lise9bolum7s6 = {"pick up","prefer","preserve","protect","raise sheep","remarkable","rescue","ruin","sailor","sculpture"};



    String [] lise9bolum7c1 = {" kaza"," başarı"," antik krallar"," antik şehir"," ilk çağlar, antik dönemler"," antik ticaret merkezi"," mimar"," rezervasyon yaptırmak"," inşa etmek"," satın almak"};
    String [] lise9bolum7c2 = {" teleferik"," başkent"," kale, hisar"," mezarlık"," yüzyıl"," tören"," uygarlık, medeniyet"," intihar etmek"," inşa etmek"," sözleşme"};
    String [] lise9bolum7c3 = {" kültürel miras"," yok etmek"," keşfetmek"," imparatorluk"," kazı yapmak"," tecrübe"," gelecek nesil"," hediye"," yetiştirmek"," tarihçi"};
    String [] lise9bolum7c4 = {" tarihi yapı"," tarih"," memleket, vatan"," icat etmek"," ada"," merdiven"," efsanevi"," deniz feneri"," deniz feneri"," konum, yer"};
    String [] lise9bolum7c5 = {" anı, hatıra"," bin yıl"," cami"," dağ"," müze"," doğal miras"," aday göstermek, tayin etmek"," süs"," saray"," geçirmek, devretmek"};
    String [] lise9bolum7c6 = {" bir yerden birini almak"," tercih etmek"," korumak, muhafaza etmek"," korumak"," koyun yetiştirmek"," göze çarpan, olağanüstü"," kurtarmak"," ören, yıkıntı"," denizci"," heykel"};


    // 8. bölüm

    String [] lise9bolum8s1 = {"accept","arrive at the party place","baker’s","barbecue party","beef","birth of a new baby","birthday party","bookshop","bring some food","bring"};
    String [] lise9bolum8s2 = {"butcher’s","call","candles","casual dress","celebrate","celebration","ceremony","championship celebration","change","cleaning the house"};
    String [] lise9bolum8s3 = {"clothes shop","cook","cooking gloves","cooking","costume","cucumber","culture","customer","decorating the house","decorations"};
    String [] lise9bolum8s4 = {"democracy and national unity day","dinner party","do shopping","emotional music","engagement","enjoy","explain","farewell party","flour","food and drinks"};
    String [] lise9bolum8s5 = {"gain","games and CDs","get ready","gift","give a call","graduation hat","graduation party","grape","greengrocer","grocer’s"};
    String [] lise9bolum8s6 = {"guest","harvest","hot dog","housewarming party","iftar meal","invitation","invite","join a party","location","look for"};



    String [] lise9bolum8c1 = {" kabul etmek"," partinn"," fırın"," mangal partisi"," biftek"," bebek doğması"," doğumgünü partisi"," kitapçı"," yiyecek getirmek"," getirmek"};
    String [] lise9bolum8c2 = {" kasap"," aramak"," mumlar"," günlük kıyafet"," kutlamak"," kutlama"," tören"," şampiyonluk kutlaması"," para üstü"," evi temizleme"};
    String [] lise9bolum8c3 = {" giyim mağazası"," yemek pişirmek"," pişirme eldiveni"," yemek pişirme"," kostüm"," salatalık"," kültür"," müşteri"," evi süsleme"," süslemeler"};
    String [] lise9bolum8c4 = {" demokrasi ve milli birlik bayramı"," akşam yemeği partisi"," alışveriş yapmak"," duygusal müzik"," nişan"," eğlenmek"," açıklamak"," veda partisi"," un"," yiyecek ve içecekler"};
    String [] lise9bolum8c5 = {" kazanmak"," oyun ve CD ler"," hazırlanmak"," hediye"," aramak"," mezuniyet kepi"," mezuniyet partisi"," üzüm"," manav"," market"};
    String [] lise9bolum8c6 = {" konuk"," toplamak"," sosisli sandwiç"," hoş geldin partisi"," iftar yemeği"," davet"," davet etmek"," partiye katılmak"," konum"," aramak"};


    // 10 . SINIF


    // 1. bölüm
    String [] lise10bolum1s1 = {"art","astronomy","athletics","biology","careers education","chemistry","citizenship","design and technology","drama","english"};
    String [] lise10bolum1s2 = {"fashion design","folk dances","geography","german","history","ICT","literature","maths","music","P.E. (physical education)"};
    String [] lise10bolum1s3 = {"philosophy","photography","physics","psychology","science","argue with friends","avoid loneliness","be abroad","catch the school bus","chat"};
    String [] lise10bolum1s4 = {"come back home","consult","cooperate","cope with stress","do homework","fond of","get enough sleep","get on well","go jogging","go to the theater"};
    String [] lise10bolum1s5 = {"good at","hang around","have breakfast","have dinner","have some snacks","keen on","listen to music","play chess","prepare portfolios","read a book"};
    String [] lise10bolum1s6 = {"revise regularly","skip breakfast","skip courses","spend time","study","surf the net","walk to school","watch a movie","assignment","compulsory courses"};

    String [] lise10bolum1c1 = {" resim"," gökbilim"," spor / atletizm"," biyoloji"," mesleki eğitim"," kimya"," vatandaşlık dersi"," teknoloji tasarım"," drama"," ingilizce"};
    String [] lise10bolum1c2 = {" moda tasarımı"," halk oyunları"," coğrafya"," almanca"," tarih"," bilişim ve iletişim teknolojileri"," edebiyat"," matematik"," müzik"," beden eğitimi"};
    String [] lise10bolum1c3 = {" felsefe"," fotoğrafçılık"," fizik"," psikoloji"," fen bilimleri"," arkadaşlarıyla kavga etmek"," yalnızlıktan kaçınmak"," yurtdışına gitmek"," servise binmek"," sohbet etmek"};
    String [] lise10bolum1c4 = {" eve dönmek"," danışmak"," birlikte çalışmak"," stres ile başa çıkmak"," ödev yapmak"," düşkün olmak"," yeterince uyumak"," iyi geçinmek"," koşmak"," tiyatroya gitmek"};
    String [] lise10bolum1c5 = {" bir şeyde iyi olmak"," dolaşmak, gezinmek"," kahvaltı etmek"," akşam yemeği yemek"," bir şeyler atıştırmak"," meraklı"," müzik dinlemek"," satranç oynamak"," portfolyo hazırlamak"," kitap okumak"};
    String [] lise10bolum1c6 = {" düzenli tekrar yapmak"," kahvaltı yapmamak"," dersleri kaçırmak"," zaman geçirmek"," ders çalışmak, (okulda) okumak"," İnternette gezinmek"," okula yürüyerek gitmek"," film izlemek"," ödev"," zorunlu dersler"};

    // 2 . bölüm

    String [] lise10bolum2s1 = {"arrange a party","arrive","be looking forward to","be over the moon","buy groceries","call","carry","celebrate","celebration","come back"};
    String [] lise10bolum2s2 = {"cook dinner","cycling","doing shopping","eating out","enjoy time","fail","faint","finish homework","finish report","fly to"};
    String [] lise10bolum2s3 = {"give a hand","go shopping","going camping","going on a picnic","going out of the city","going to a concert","hanging around with friends","have a party","having a barbecue","having dinner"};
    String [] lise10bolum2s4 = {"interested in","jogging","joining a party","leave the house","make a plan","meet friends","pick up kids","prepare a shopping list","receive a message","refreshment"};
    String [] lise10bolum2s5 = {"relaxation","represent","ride","see dentist","seeing a movie","spend a week","spending time together","split","staying in a tent","take a quick decision"};
    String [] lise10bolum2s6 = {"taking a city tour","throw a party","tidy","trekking","turn the light on","visiting a museum","visiting the grannies","watch a comedy","arrangement","balloons"};



    String [] lise10bolum2c1 = {" parti düzenlemek"," varmak"," dört gözle beklemek"," sevinçten uçmak"," yiyecek almak"," telefonla aramak"," taşımak"," kutlamak"," kutlama"," geri dönmek"};
    String [] lise10bolum2c2 = {" yemek pişirmek"," bisiklete binme"," alışveriş yapmak"," dışarda yemek"," iyi vakit geçirmek"," başarısız olmak"," bayılmak"," ödevini bitirmek"," raporu bitirmek"," uçakla gitmek"};
    String [] lise10bolum2c3 = {" yardım etmek"," alışverişe gitmek"," kampa gitmek"," pikniğe gitmek"," şehir dışına gitmek"," konsere gitmek"," arkadaşlarla dolaşmak"," parti yapmak"," mangal yapmak"," akşam yemeği yemek"};
    String [] lise10bolum2c4 = {" ilgisini çekmek"," hafif koşu"," partiye katılmak"," evden ayrılmak"," plan yapmak"," arkadaşlarla buluşmak"," çocukları almak"," alışveriş listesi hazırlamak"," mesaj almak"," canlanma"};
    String [] lise10bolum2c5 = {" dinlenme"," temsil etmek"," bisikletle gitmek"," dişçiye gitmek"," film izlemek"," bir hafta geçirmek"," birlikte zaman geçirmek"," dökmek"," çadırda kalmak"," hızlıca karar almak"};
    String [] lise10bolum2c6 = {" şehir turu yapmak"," parti vermek"," toplamak, temizlemek"," doğa yürüyüşü"," ışığı açmak"," müze ziyaret etmek"," büyükanne ve büyükbabayı ziyaret etmek"," komedi filmi izlemek"," ayarlama"," balonlar"};


    // 3. bölüm


    String [] lise10bolum3s1 = {"accept","argue","attack","be born","become","begin","believe","besiege","book","borrow"};
    String [] lise10bolum3s2 = {"call","come across","come back","come","conquer","cope with","damage","dare","decide","defeat"};
    String [] lise10bolum3s3 = {"describe","design","destroy","die","dislike","divide","dunk","establish","feel scared","fight"};
    String [] lise10bolum3s4 = {"find out","find","focus on","give back","give permission","greet politely","grow up","grow","help","hit"};
    String [] lise10bolum3s5 = {"hug","ignore","injure","inspire","invade","invite","join army","join","kill","land"};
    String [] lise10bolum3s6 = {"laugh","learn the truth","live","look after","lose","make a change","manage to","move","need","offer"};



    String [] lise10bolum3c1 = {" kabul etmek"," kavga etmek"," saldırmak, hücum etmek"," doğmak"," olmak"," başlamak"," inanmak"," kuşatmak"," yer ayırtmak"," ödünç almak"};
    String [] lise10bolum3c2 = {" aramak"," karşılaşmak"," geri gelmek"," gelmek"," fethetmek"," başa çıkmak"," zarar vermek"," cesaret etmek"," karar vermek"," yenmek"};
    String [] lise10bolum3c3 = {" tarif etmek"," tasarlamak"," tahrip etmek"," ölmek"," hoşlanmamak"," bölmek"," batırmak"," kurmak"," korkmak"," dövüşmek, savaşmak"};
    String [] lise10bolum3c4 = {" öğrenmek"," bulmak"," odaklanmak"," geri vermek"," izin vermek"," kibarca selamlamak"," büyümek"," yetişmek"," yardım etmek"," vurmak"};
    String [] lise10bolum3c5 = {" kucaklamak"," görmezden gelmek"," sakatlanmak"," ilham almak"," ele geçirmek"," davet etmek"," orduya katılmak"," katılmak"," öldürmek"," karaya çıkmak"};
    String [] lise10bolum3c6 = {" gülmek"," gerçeği öğrenmek"," yaşamak"," bakmak"," kaybetmek"," değişiklik yapmak"," başarmak"," taşınmak"," ihtiyaç duymak"," teklif etmek"};


    // 4. bölüm



    String [] lise10bolum4s1 = {"affect life","ask for directions","back up = support","be afraid of","be online","begin working","blow your nose","break with tradition","communicate","cover"};
    String [] lise10bolum4s2 = {"disappear","do homework","do the household chores","dress in similar ways","earn money","eat with chopsticks","embroider","entertain","feel impressed","gather together"};
    String [] lise10bolum4s3 = {"get information","greet with a bow","greet","grow vegetables","have chat","have no contact","help each other","help neighbours","help parents","ignore"};
    String [] lise10bolum4s4 = {"inherit","kiss on the cheek","lead the family","light","look after the children","look up words","make bread","make clothes","make eye contact","make life easy"};
    String [] lise10bolum4s5 = {"make own toy","obey","post","prefer","preserve the traditions","protect","remember","remind","respect the elderly","send postcards"};
    String [] lise10bolum4s6 = {"shake hands","share household chores","share pictures","socialize","spend time with family","stay at home","study maps","surf the net","take off shoes","tell stories"};



    String [] lise10bolum4c1 = {" hayatı etkilemek"," adres sormak"," destek olmak"," korkmak"," çevrimiçi olmak"," çalışmaya başlamak"," burnunu silmek"," geleneği bozmak"," iletişim kutusu"," kapatmak"};
    String [] lise10bolum4c2 = {" ortadan kaybolmak"," ödev yapmak"," ev işlerini yapmak"," aynı tarz giyinmek"," para kazanmak"," çubuklarla yemek"," nakış işlemek"," eğlendirmek"," etkilenmek"," bir araya gelmek"};
    String [] lise10bolum4c3 = {" bilgi edinmek"," eğilerek selamlamak"," selamlamak"," sebze yetiştirmek"," sohbet etmek"," irtibatı olmamak"," birbirine yardım etmek"," komşulara yardım etmek"," ebeyenlere yardım etmek"," görmezden gelmek"};
    String [] lise10bolum4c4 = {" miras olarak kalmak"," yanaktan öpmek"," aileye liderlik etmek"," aydınlatmak"," çocuklara bakmak"," kelime aramak"," ekmek yapmak"," kıyafet dikmek"," göz teması kurmak"," hayatı kolaylaştırmak"};
    String [] lise10bolum4c5 = {" kendi oyuncağını yapmak"," itaat etmek"," göndermek"," tercih etmek"," gelenekleri korumak"," korumak"," hatırlamak"," hatırlatmak"," yaşlılara saygı duymak"," kartpostal yollamak"};
    String [] lise10bolum4c6 = {" el sıkışmak"," ev işlerini paylaşmak"," fotoğraf paylaşmak"," sosyalleşmek"," aile ile vakit geçirmek"," evde kalmak"," haritaya bakmak"," internette gezinmek"," ayakkabılarını çıkarmak"," hikaye anlatmak"};


    // 5. bölüm



    String [] lise10bolum5s1 = {"activity based vacations","adventure vacation","all-inclusive hotels","beach vacations","camping","cruise vacation","cultural vacation","cycling vacation","digital detox","diving trip"};
    String [] lise10bolum5s2 = {"facility based vacations","glamping","hiking vacation","jet skiing","kayaking","mountaineering","outdoor vacations","parasailing","safari vacation","scuba diving"};
    String [] lise10bolum5s3 = {"skiing vacation","snorkelling","sports tours","staycation","sunbathing","surfing","trekking and hiking vacations","voluntourism","windsurfing","a boat trip"};
    String [] lise10bolum5s4 = {"a three-day vacation","a two- night stay","a window seat","accommodation","airline company","all-inclusive resort","all-inclusive stay","an aisle seat","arrival","available"};
    String [] lise10bolum5s5 = {"B&B","bad sides","baggage allowance","be abroad","book a flight","book a room","booking a room","boutique","bungalow","bus journey"};
    String [] lise10bolum5s6 = {"by the window","campsite","caravan","check-in","climate","confirm your flight","contact number","cuisine","cultural events","customer"};



    String [] lise10bolum5c1 = {" aktivite tatilleri"," macera tatili"," her şey dahil oteller"," plaj tatili"," kamp yapma"," gemi tatili"," kültürel tatil"," bisikletle çıkılan tatil"," kişinin elektronik aletlerden isteyerek uzak kalması"," dalış gezisi"};
    String [] lise10bolum5c2 = {" olanak temelli tatiller"," tesislerde yapılan kamp"," doğa yürüyüşü tatili"," deniz motosikleti"," kano sporu"," dağcılık"," açıkhava tatilleri"," paraşütle uçma sporu"," safari tatili"," tüple dalış"};
    String [] lise10bolum5c3 = {" kayak tatili"," şnorkelle yüzme"," spor gezileri"," evde geçirilen tatil"," güneşlenme"," sörf yapma"," doğa ürüyüşü tatilleri"," gönüllü turizm"," rüzgar sörfü"," tekne turu"};
    String [] lise10bolum5c4 = {" üç günlük tatil"," iki gece konaklama"," cam kenarı koltuk"," konaklama"," havayolu şirketi"," her şey dahil tatil yeri"," herşey dahil konaklama"," koridor koltuğu"," varış"," müsait, uygun"};
    String [] lise10bolum5c5 = {" oda kahvaltı"," kötü yönler"," bagaj limiti"," yurtdışında olmak"," uçak bileti rezervasyonu yapmak"," oda rezervasyonu yapmak"," oda rezervasyonu yapmak"," butik mağaza"," bungalov ev"," otobüs yolculuğu"};
    String [] lise10bolum5c6 = {" cam kenarı"," kamp yeri"," karavan"," biletini kontrol etmek"," iklim"," uçuşu onaylamak"," iletişim numarası"," mutfak kültürü"," kültürel etkinlikler"," müşteri"};



    //6. bölüm


    String [] lise10bolum6s1 = {"advice","ask for advice","ask for permission","be confident","become extinct","boundary","carbon footprint","catch a cold","check messages","choice"};
    String [] lise10bolum6s2 = {"clean the house","clean the refrigerator","communicating with people","consequence","consumption","contribute","cope with","cut off","damage ecological balance","damp"};
    String [] lise10bolum6s3 = {"disappear","discover yourself","discover","distraction","do the cooking","do the laundry","do the shopping","dust the furniture","empty the dishwasher","energy sources"};
    String [] lise10bolum6s4 = {"environment-friendly","fabric","face famine","fear","feel annoyed","fold the clothes","get a degree","get the job","give advice","go on a diet"};
    String [] lise10bolum6s5 = {"go on time","graduate","handle","hang out the washing","have a bad cough","have a job interview","have a stomachache","helping people","infer","insurance"};
    String [] lise10bolum6s6 = {"iron the clothes","law","learning difficulties","leave rubbish around","liberty","load the dishwasher","lose weight","lower","make a decision","make eye contact"};



    String [] lise10bolum6c1 = {" tavsiye"," tavsiye istemek"," izin istemek"," kendinden emin olmak"," soyu tükenmek"," sınır"," karbon ayak izi"," nezle olmak, üşütmek"," mesajları kontrol etmek"," seçim, tercih"};
    String [] lise10bolum6c2 = {" evi temizlemek"," buzdolabını temizlemek"," insanlarla iletişim kurmak"," netice, sonuç"," tüketim"," katkıda bulunmak"," başa çıkmak"," kesmek"," ekolojik dengeye zarar vermek"," nemli"};
    String [] lise10bolum6c3 = {" yok olmak"," kendini keşfetmek"," keşfetmek"," dikkatin dağılması"," yemek yapmak"," çamaşırları yıkamak"," alışveriş yapmak"," mobilyanın tozunu almak"," bulaşık makinasını boşaltmak"," enerji kaynakları"};
    String [] lise10bolum6c4 = {" çevre dostu"," kumaş"," kıtlıkla karşılaşmak"," korku"," rahatsız hissetmek"," çamaşırları katlamak"," mezun olmak"," iş bulmak"," tavsiye vermek"," diyet yapmak"};
    String [] lise10bolum6c5 = {" zamanında gitmek"," mezun olmak"," idare etmek"," çamaşır asmak"," kötü öksürmek"," iş görüşmesi yapmak"," karnı ağrımak"," insanlara yardım etmek"," anlam çıkarmak"," sigorta"};
    String [] lise10bolum6c6 = {" kıyafetleri ütülemek"," yasa, hukuk"," öğrenme zorlukları"," çöpleri etrafa bırakmak"," özgürlük"," bulaşık makinesini doldurmak"," kilo vermek"," daha düşük"," karar vermek"," göz teması kurmak"};


    // 7. bölüm


    String [] lise10bolum7s1 = {"add","advise","arrange","be part of","bring good luck","bring","carve pumpkins","celebrate","clean homes","come together"};
    String [] lise10bolum7s2 = {"consume","cook","damage","decorate with flags","decorate","display","exchange gifts","fast","feel","give alms"};
    String [] lise10bolum7s3 = {"give gifts","hand out","help the needy","hold","impact","invite","join activities","last for three weeks","organize","perform"};
    String [] lise10bolum7s4 = {"pilgrimage","prepare","protect","provide","recite","respect","sacrifice","take place","throw parties","visit relatives"};
    String [] lise10bolum7s5 = {"welcome","art events","bagel","bake","bitter","black pepper","boil","candle","celebration","chicken"};
    String [] lise10bolum7s6 = {"children’s day","chop","christmas","competition","cook","cookery shows","cooking process","costumes","cuisine","cultural diversity"};



    String [] lise10bolum7c1 = {" eklemek"," tavsiye etmek"," ayarlamak, düzenlemek"," parçası olmak"," iyi şans getirmek"," getirmek"," kabak oymak"," kutlamak"," evleri temizlemek"," bir araya gelmek"};
    String [] lise10bolum7c2 = {" tüketmek"," yemek pişirmek"," zarar vermek"," bayraklarla süslemek"," süslemek"," sergilemek"," hediye alıp vermek"," oruç tutmak"," hissetmek"," zekat vermek"};
    String [] lise10bolum7c3 = {" hediye vermek"," dağıtmak"," ihtiyaç sahiplerine yardım etmek"," düzenlemek"," etkilemek"," davet etmek"," etkinliklere katılmak"," üç hafta sürmek"," düzenlemek"," yerine getirmek"};
    String [] lise10bolum7c4 = {" hacca gitmek"," hazırlamak"," korumak"," temin etmek, sağlamak"," ezbere okumak"," saygı göstermek"," kurban kesmek"," meydana gelmek, olmak"," parti düzenlemek"," akrabaları ziyaret etmek"};
    String [] lise10bolum7c5 = {" karşılamak"," sanat etkinlikleri"," simit"," fırında pişirmek"," acılı"," kara biber"," suda kaynatmak"," mum"," kutlama"," tavuk"};
    String [] lise10bolum7c6 = {" çocuk bayramı"," doğramak"," noel"," müsabaka, yarışma"," pişirmek"," yemek programları"," pişirme işlemi"," kostümler"," mutfak kültürü"," kültürel çeşitlilik"};


    // 8. bölüm

    String [] lise10bolum8s1 = {"access the information","access","addicted to","addictive","affect","app store","application","artificial intelligence","banking transaction","big deal"};
    String [] lise10bolum8s2 = {"black&white tv","call people","check account","communicate","computer","connect","contact each other","contact","control e-mails","criticize"};
    String [] lise10bolum8s3 = {"curved tv","depend on","desktop PC","develop computer skills","develop","dial phone","doing homework","dominate","download music","e- book reader"};
    String [] lise10bolum8s4 = {"effect","evolution of technology","excessive internet usage","face to face communication","feel lonely","function","game console","habit","hardware","homepage"};
    String [] lise10bolum8s5 = {"increase","innovation","interact","interaction","invent","join chat rooms","join discussion forums","keep changing","keep in touch","keyboard"};
    String [] lise10bolum8s6 = {"latest developments","listen to music","make easier","make friends","making reservations","medical technology","memory card","mouse","navigation systems","negative effects"};



    String [] lise10bolum8c1 = {" bilgiye ulaşmak"," erişim"," bağımlı"," alışkanlık yapan"," etkilemek"," uygulama mağazası"," uygulama"," yapay zeka"," bankacılık işlemi"," çok önemli"};
    String [] lise10bolum8c2 = {" siyah beyaz televizyon"," insanları aramak"," hesabını kontrol etmek"," haberleşmek"," bilgisayar"," bağlanmak"," birbiriyle iletişim kurmak"," irtibat kurmak"," e-postaları kontrol etmek"," eleştirmek"};
    String [] lise10bolum8c3 = {" kavisli televizyon"," bağlı olmak"," masaüstü bilgisayar"," bilgisayar becerilerini geliştirmek"," gelişmek"," telefon"," ödev yapmak"," hakim olmak"," müzik indirmek"," e-kitap okuyucu"};
    String [] lise10bolum8c4 = {" etki"," teknolojinin gelişimi"," aşırı internet kullanımı"," yüz yüze iletişim"," yalnız hissetmek"," işlev"," oyun konsolu"," alışkanlık"," donanım"," anasayfa"};
    String [] lise10bolum8c5 = {" artmak"," yenilik"," etkileşimde bulunmak"," etkileşim"," icat etmek"," sohbet odalarına katılmak"," tartışma forumlarına katılmak"," değişmeye devam etmek"," iletişim halinde bulunmak"," klavye"};
    String [] lise10bolum8c6 = {" en son gelişmeler"," müzik dinlemek"," kolaylaştırmak"," arkadaş edinmek"," yer ayırtmak"," tıbbi teknoloji"," hafıza kartı"," fare"," yön bulma sistemi"," olumsuz etkiler"};


    // 9. bölüm


    String [] lise10bolum9s1 = {"ability","achieve","admire","affect","amazing","astrophysicist","attractive","award=prize","ban","become invisible"};
    String [] lise10bolum9s2 = {"brave","calm down","carry out","chase","clever","come to an end","common sense","compete","cure","danger"};
    String [] lise10bolum9s3 = {"deadline","dedicate","detect","develop","device","didactic","discover","disease","distinguished","do magic"};
    String [] lise10bolum9s4 = {"dream","education life","endurance","enemy","extraordinary","fear of failure","fight for freedom","fly","folk tale","fulfill"};
    String [] lise10bolum9s5 = {"get adapted","get stuck in traffic","give up","go after","grow up","gun","have a chance","have in common","heal himself","heart attack"};
    String [] lise10bolum9s6 = {"heart diseases","helpful","hero","heroine","historical character","hormones","humanity","imaginary situation","imagination","impoverished"};



    String [] lise10bolum9c1 = {" yetenek"," başarmak"," hayran olmak"," etkilemek"," harika"," astrofizikçi"," çekici"," ödül"," yasaklamak"," görünmez olmak"};
    String [] lise10bolum9c2 = {" cesur"," sakinleştirmek"," yürütmek"," peşinden gitmek"," zeki, akıllı"," sona ermek"," sağduyu"," yarışmak"," çare, tedavi"," tehlike"};
    String [] lise10bolum9c3 = {" son teslim tarihi"," adamak"," belirlemek"," geliştirmek"," cihaz"," öğretici"," keşfetmek"," hastalık"," seçkin"," sihir yapmak"};
    String [] lise10bolum9c4 = {" hayal etmek"," eğitim hayatı"," dayanıklılık"," düşman"," olağan dışı"," başarısızlık korkusu"," özgürlük için savaşmak"," uçmak"," halk hikayesi"," uygulamak"};
    String [] lise10bolum9c5 = {" alışmak"," trafiğe takılmak"," vazgeçmek, bırakmak"," peşinden gitmek"," büyümek"," tabanca"," şans bulmak"," ortak bir özelliğe sahip olmak"," kendini iyileştirmek"," kalp krizi"};
    String [] lise10bolum9c6 = {" kalp hastalıkları"," yardımsever"," (erkek) kahraman"," kadın kahraman"," tarihi karakter"," hormon"," insanlık"," hayali durum"," hayal gücü"," yoksul"};


    // 10. bölüm

    String [] lise10bolum10s1 = {"blouse","boot","coat","dress","flip-flops","gloves","hat","headscarf","jacket","jeans"};
    String [] lise10bolum10s2 = {"shirt","shoes","skirt","socks","tracksuit","trainers","trousers","tshirt","attractive","available"};
    String [] lise10bolum10s3 = {"average height","cheap","comfortable","cute","dry","elderly","elegant","expensive","fair","fairly short"};
    String [] lise10bolum10s4 = {"fashionable","fat","glowing","good looking","gorgeous","heavy","in her 20s","large","light","mature"};
    String [] lise10bolum10s5 = {"muscular","of medium height","old","old-fashioned","ordinary-looking","overweight","pale","plain","plump","pretty"};
    String [] lise10bolum10s6 = {"ridiculous","rough","short","slim","smooth-skin","stocky","stylish","tall","tanned","teenager"};



    String [] lise10bolum10c1 = {" bluz"," bot"," mont"," elbise"," parmak arası"," eldiven"," şapka"," başörtüsü"," ceket"," kot pantolon"};
    String [] lise10bolum10c2 = {" gömlek"," ayakkabı"," etek"," çorap"," eşofman"," spor ayakkabı"," pantolon"," tişört"," çekici"," mevcut"};
    String [] lise10bolum10c3 = {" ortalama boy"," ucuz"," rahat"," sevimli"," kuru"," yaşlı"," şık"," pahalı"," açık tenli"," epey kısa"};
    String [] lise10bolum10c4 = {" moda olan"," şişman"," parlak"," hoş görünen"," çok güzel"," ağır"," 20 li yaşlarında"," büyük"," açık"," yetişkin"};
    String [] lise10bolum10c5 = {" kaslı"," orta boylu"," yaşlı"," eski moda"," sıradan görünümlü"," kilolu"," solgun"," sade"," toplu"," sevimli"};
    String [] lise10bolum10c6 = {" saçma"," pürüzlü"," kısa"," ince"," pürüzsüz cilt"," bodur, tıknaz"," şık"," uzun"," esmerleşmiş"," ergen"};


    // 11. SINIF

    // 1. bölüm
    String [] lise11bolum1s1 = {"absolutely perfect","academic burnout","accent","accessories","accommodation","accompanies","achievement","acquired","advertising","against"};
    String [] lise11bolum1s2 = {"allowance","an excuse","app developer","applicant’s name","application","apply","arouse","artificial intelligence","astonishing","attempt"};

    String [] lise11bolum1c1 = {"kesinlikle mükemmel","akademik tükenmişlik","aksan","donatılar","konaklama","eşlik etmek","başarı","zamanla kazanılan","reklamcılık","karşı"};
    String [] lise11bolum1c2 = {"izin","mazeret","uygulama geliştiricisi","başvuranın adı","başvuru","başvurmak","uyandırmak","yapay zeka","şaşılacak","girişimde bulunmak"};

    // 2 . bölüm

    String [] lise11bolum2s1 = {"acting","archery","bodyboarding","building model planes","car tattooing","caving","collecting stamps","cooking","creating blogs","dancing"};
    String [] lise11bolum2s2 = {"drawing pictures","environmentalism","fixing","follow fashion","helping other people","helping the poor","highlining","ice climbing","ice-skating","juggling"};
    String [] lise11bolum2s3 = {"knitting","knitting","listening to music","making puzzles","meeting new people","model making","motor racing","mountain-climbing","painting","parachute jump"};
    String [] lise11bolum2s4 = {"parkour","photography","photography","playing chess","playing football","playing golf","playing tennis","playing the drums","playing the guitar","playing the piano"};
    String [] lise11bolum2s5 = {"playing the violin","pottery","rafting","scuba diving","spending time with friends","surfing","swimming","travelling","trekking","turkish calligraphy"};
    String [] lise11bolum2s6 = {"watching cartoons","watching movies","watching TV","wingsuiting","writing computer programmes","writing lyrics","writing poems","alone","cheerful","dangerous"};



    String [] lise11bolum2c1 = {" oyunculuk yapmak"," okçuluk"," dalga sörfü"," maket uçak yapmak"," araba boyama"," mağaracılık"," pul koleksiyonu yapmak"," yemek pişirme"," blog oluşturmak"," dans etmek"};
    String [] lise11bolum2c2 = {" resim çizmek"," çevrecilik"," tamir yapmak"," modayı takip etmek"," insanlara yardım etmek"," ihtiyaç sahiplerine yardım etmek"," ip üzerinde yürüme"," buz tırmanışı"," buz pateni"," hokkabazlık"};
    String [] lise11bolum2c3 = {" örgü örmek"," örgü örmek"," müzik dinlemek"," yapboz yapmak"," yeni insanlarla tanışmak"," maket yapımı"," motor yarışı"," dağa tırmanma"," resim yapmak"," paraşütle atlamak"};
    String [] lise11bolum2c4 = {" parkur sporu"," fotoğrafçılık"," fotoğrafçılık"," satranç oynamak"," futbol oynamak"," golf oynamak"," tenis oynamak"," bateri çalmak"," gitar çalmak"," piyano çalmak"};
    String [] lise11bolum2c5 = {" keman çalmak"," çömlekçilik"," rafting"," tüplü dalış"," arkadaşlarıyla zaman geçirmek"," sörf yapmak"," yüzme"," seyahat etmek"," doğa yürüyüşü"," hat sanatı"};
    String [] lise11bolum2c6 = {" çizgi film izlemek"," film izlemek"," televizyon izlemek"," kanatlı elbise uçuşu"," bilgisayar programları yazmak"," şarkı sözü yazmak"," şiir yazmak"," yalnız"," neşeli"," tehlikeli"};


    // 3. bölüm


    String [] lise11bolum3s1 = {"acne","appliance","apply ointment","arrive","attempt","attend school","be born","become a king","begin","break leg"};
    String [] lise11bolum3s2 = {"bullying","buy","candle","challenges","chemistry","childhood","come across","common","communication","courage"};
    String [] lise11bolum3s3 = {"crowded","crucial","cry","curiosity","cyber addiction","daily chores","damage environment","declare war","depression","dermatologist"};
    String [] lise11bolum3s4 = {"determination","develop","die","disability","discovery","drive","drop out of","earthquake","eating disorder","educated"};
    String [] lise11bolum3s5 = {"education","embassy","equal rights","exam stress","expose","face to face communication","factories","fail the class","failure","faint"};
    String [] lise11bolum3s6 = {"feel embarrassed","feel responsible","find a job","forget","get a prize","get rid of","graduate","hard conditions","hard times","hard work"};



    String [] lise11bolum3c1 = {" sivilce"," cihaz"," merhem sürmek"," varmak"," girişim"," okula girmek"," doğmak"," kral olmak"," başlamak"," bacağını kırmak"};
    String [] lise11bolum3c2 = {" zorbalık"," satın almak"," mum"," zorluklar"," kimya"," çocukluk"," karşılaşmak"," yaygın"," iletişim"," cesaret"};
    String [] lise11bolum3c3 = {" kalabalık"," çok önemli"," ağlamak"," merak"," sanal bağımlılık"," günlük işler"," çevreye zarar vermek"," savaş ilan etmek"," depresyon"," cilt doktoru"};
    String [] lise11bolum3c4 = {" kararlılık"," geliştirmek"," ölmek"," engellilik"," keşif"," araba sürmek"," okulu bırakmak"," deprem"," yeme bozukluğu"," eğitimli"};
    String [] lise11bolum3c5 = {" eğitim"," elçilik"," eşit haklar"," sınav stresi"," maruz kalmak"," yüz yüze iletişim"," fabrikalar"," sınıfta kalmak"," başarısızlık"," bayılmak"};
    String [] lise11bolum3c6 = {" utanmak"," sorumlu hissetmek"," iş bulmak"," unutmak"," ödül almak"," kurtulmak"," mezun olmak"," ağır şartlar"," zor zamanlar"," çok çalışma"};


    // 4. bölüm



    String [] lise11bolum4s1 = {"achieve","allow","attend","be a scientist","be famous","become an adult","break","build","collapse","conduct experiment"};
    String [] lise11bolum4s2 = {"conquer","cry","declare ","defend","delay","do research","donate","elect","enroll","establish"};
    String [] lise11bolum4s3 = {"explode","find a hidden treasure","fly","following our dreams","gain fame","get by","get crazy","get mad","get on","go to space"};
    String [] lise11bolum4s4 = {"graduate","grow up","have a hard life","have a new job","help the poor","launch","lift off","live in a castle","lose","make it real"};
    String [] lise11bolum4s5 = {"move","persuade","prepare","preserve","pursue","remind","renew","require","sacrifice","save money"};
    String [] lise11bolum4s6 = {"share experiences","shoot","spend time in space","stay in a tent","study medicine","study medicine","survive","take control","take off","take place"};



    String [] lise11bolum4c1 = {" başarmak"," izin vermek"," katılmak"," bilim insanı olmak"," ünlü olmak"," yetişkin olmak"," kırmak"," inşa etmek"," çökmek"," deney yapmak"};
    String [] lise11bolum4c2 = {" fethetmek"," ağlamak"," açıklamak, ilan etmek"," savunmak"," ertelemek"," araştırma yapmak"," bağışlamak"," seçmek"," kaydını yaptırmak"," kurmak"};
    String [] lise11bolum4c3 = {" patlamak"," gizli hazine bumak"," uçmak"," hayallerimizin"," üne kavuşmak"," geçinmek"," çılgına dönmek"," kızmak"," binmek"," uzaya gitmek"};
    String [] lise11bolum4c4 = {" mezun olmak"," yetişmek"," zor bir hayatı olmak"," yeni işe girmek"," fakirlere yardım etmek"," fırlatmak"," kalkış yapmak"," kalede yaşamak"," kaybetmek"," gerçekleştirmek"};
    String [] lise11bolum4c5 = {" taşınmak", " ikna etmek", " hazırlamak", " korumak", " sürdürmek", " hatırlatmak", " yenilemek", " gerektirmek", " feda etmek", " para biriktirmek"};
    String [] lise11bolum4c6 = {" tecrübelerini paylaşmak"," ateş etmek"," uzayda zaman geçirmek"," çadırda kalmak"," tıp okumak"," tıp okumak"," hayatta kalmak"," kontrolü ele almak"," uçağın havalanması"," meydana gelmek"};


    // 5. bölüm



    String [] lise11bolum5s1 = {"advice","affect","apply sunscreen","arrive on time","ask for help","attempt","attend a seminar","authorisation","bad habit","be addicted to alcohol"};
    String [] lise11bolum5s2 = {"be optimistic","be sick","become a social media addict","break a bad habit","break heart","call an advisor","chance","change","chatting during lessons","cheat"};
    String [] lise11bolum5s3 = {"childhood","collapse","coming late to classes","chaos","consequences","cracking knuckles","crime","culture","cyberattack","cyberbully"};
    String [] lise11bolum5s4 = {"cybercriminal","cyberlaw","cybersecurity","deceive","decision","dedication","delaying projects","display","document","doing away with"};
    String [] lise11bolum5s5 = {"eat too much","economy","environment","equivocal","establishing good sleeping routine","fail","feel embarrassed / ashamed","feel sad","feel stressed","flossing your teeth"};
    String [] lise11bolum5s6 = {"foresight","forgive","get a better job","get angry","get worried","grinding teeth","hand in","harm","have a proper life","have suntan"};



    String [] lise11bolum5c1 = {" tavsiye"," etkilemek"," güneş kremi sürmek"," zamanında gelmek"," yardım istemek"," teşebbüs etmek"," seminere katılmak"," yetki"," kötü alışkanlık"," alkol bağımlısı olmak"};
    String [] lise11bolum5c2 = {" iyimser olmak"," hasta olmak"," sosyal medya bağımlısı olmak"," kötü alışkanlıktan kurtulmak"," kalp kırmak"," danışmanı aramak"," fırsat, şanş"," değiştirmek"," ders boyunca konuşma"," sınavda kopya çekmek"};
    String [] lise11bolum5c3 = {" çocukluk"," çökmek"," derse geç gelmek"," karmaşa"," sonuçlar"," parmak çıtlatmak"," suç"," kültür"," siber saldırı"," siber zorba"};
    String [] lise11bolum5c4 = {" siber suçlu"," siber hukuk"," siber güvenlik"," aldatmak"," karar"," ithaf etme"," projelerini ertelemek"," görüntü"," doküman, belge"," tasfiye"};
    String [] lise11bolum5c5 = {" çok fazla yemek"," ekonomi"," çevre"," şüpheli"," iyi bir uyku düzeni kurma"," sınavdan kalmak"," utanmak"," üzgün hissetmek"," stres altında hissetmek"," diş ipi ile temizleme"};
    String [] lise11bolum5c6 = {" öngörü"," affetmek"," daha iyi bir iş bulmak"," sinirlenmek"," endişelenmek"," diş gıcırdatma"," teslim etmek"," zarar vermek"," düzgün bir hayatı olmak"," bronzlaşmak"};



    //6. bölüm


    String [] lise11bolum6s1 = {"advice","appreciation","ask opinion","ask out","assassinated","assignment","bad news","be employed","be injured","blossom"};
    String [] lise11bolum6s2 = {"break up","bully","burglar","call back","choose","coincidence","communicative","complain","consider","controll his temper"};
    String [] lise11bolum6s3 = {"criticism","criticize","decision","deserted","dim","drift apart","dye","eagerly","ear operation","empathy"};
    String [] lise11bolum6s4 = {"fail","fall apart","fall for someone","fall in love","find","floating","forgiveness","give seat","give up","honesty"};
    String [] lise11bolum6s5 = {"hurt","ignore","inquire","knowledge","lack of communication","lack of honesty","lack of patience","lack of respect and love","lack of responsibility","lack"};
    String [] lise11bolum6s6 = {"leave home","live happily","log","look for something","loyalty","make a mistake","make upset","mistake","move to another city","open-minded"};



    String [] lise11bolum6c1 = {" tavsiye"," takdir"," fikrini sormak"," davet etmek"," suikaste uğramış"," ödev"," kötü haber"," işe alınmak"," yaralanmak, sakatlanmak"," çiçek açmak"};
    String [] lise11bolum6c2 = {" birinden ayrılmak"," zorbalık etmek"," hırsız"," geri aramak"," seçmek"," rastlantı"," konuşkan"," yakınmak, şikayet etmek"," dikkate almak"," öfkesini kontrol etmek"};
    String [] lise11bolum6c3 = {" eleştiri"," eleştirmek"," karar"," ıssız, terkedilmiş"," loş"," uzaklaşmak"," saç boyamak"," hevesle"," kulak ameliyatı"," empati"};
    String [] lise11bolum6c4 = {" sınavdan kalmak"," duygusal olarak dağılmak"," aşık olmak"," aşık olmak"," bulmak"," sabit olmayan, yüzen"," affetme"," yer vermek"," bırakmak"," dürüstlük"};
    String [] lise11bolum6c5 = {" yaralanmak"," görmezden gelmek"," soru sormak"," bilgi"," iletişim kopukluğu"," dürüstlük eksikliği"," sabır eksikliği"," sevgi ve saygı eksikliği"," sorumsuzluk"," yoksun olmak"};
    String [] lise11bolum6c6 = {" evden ayrılmak"," mutlu yaşamak"," kayıt"," bir şey aramak"," sadakat"," hata yapmak"," üzmek"," hata"," başka şehre taşınmak"," açık görüşlü"};


    // 7. bölüm


    String [] lise11bolum7s1 = {"aggressive","agora","alive and kicking","alter","ancient theatre","ancient times","ancient world","animal figures","antique theatre","architecture"};
    String [] lise11bolum7s2 = {"bath","build","castle","cathedral","church","construct","construction","content myself with","cuisine","cultural heritage"};
    String [] lise11bolum7s3 = {"damage","demolish","deserted","design","destroy","destruction","discover","empire","excavate","fairy chimneys"};
    String [] lise11bolum7s4 = {"get in touch","heritage","historians","historical sites","huge","human settlement","hunter-gatherers","imaginary","lake","landscape"};
    String [] lise11bolum7s5 = {"locate","location","mind blowing","miss the boat","monastry","monument","mosque","mountain","museum","must-see"};
    String [] lise11bolum7s6 = {"myth","natural beauties","occupy","occur","palace","pillar","pray","prehistoric times","prehistory","rebuild"};



    String [] lise11bolum7c1 = {" kavgacı"," meydan, kent meydanı"," hayat dolu"," değiştirmek"," antik tiyatro"," ilk çağlar, antik dönemler"," antik dünya"," hayvan figürleri"," antik tiyatro"," mimari"};
    String [] lise11bolum7c2 = {" hamam"," inşa etmek"," kale"," katedral, büyük kilise"," kilise"," inşa etmek"," yapı"," -ile yetinmek"," mutfak kültürü"," kültürel miras"};
    String [] lise11bolum7c3 = {" zarar vermek"," yıkmak"," terkedilmiş"," tasarlamak"," zarar vermek"," tahribat"," keşfetmek"," imparatorluk",""," peri bacaları"};
    String [] lise11bolum7c4 = {" temasta olmak"," miras"," tarihçiler"," tarihi yerler"," çok büyük"," insan yerleşimi"," avcı toplayıcı"," hayali"," göl"," manzara"};
    String [] lise11bolum7c5 = {" yer almak"," konum"," insanın aklını başından alan"," fırsatı kaçırmak"," manastır"," abide, anıt"," cami"," dağ"," müze"," görülmesi gereken"};
    String [] lise11bolum7c6 = {" efsane"," doğal güzellikler"," işgal etmek"," ortaya çıkmak"," saray"," sütun"," ibadet etmek"," tarih öncesi"," tarih öncesi"," yeniden inşa etmek"};

    int i =0;
    // 8. bölüm

    String [] lise11bolum8s1 = {"achieve","achievement","announce","athlete","athletics","award","basketball","be keen on","break world record","canoeing"};
    String [] lise11bolum8s2 = {"captain","celebrate","champion team","championship","cliff diving","climbing","coach","compete","competition","competitors"};
    String [] lise11bolum8s3 = {"consider the danger","countdown","court","cycle race","cyclist/rider","dare","develop","diving","encourage","end"};
    String [] lise11bolum8s4 = {"equipment","extreme sports","fair play","get retired","get the chance","goggles","helmet","hold breath","ice climbing","ice hockey"};
    String [] lise11bolum8s5 = {"individual sports","inspire","jersey","jump","kickboxing","kite surfing","last","match","mountain biking","move"};
    String [] lise11bolum8s6 = {"national team","parachute","paragliding","paralympic games","player","purchase","raise awareness","rat race","referee","relieve stress"};



    String [] lise11bolum8c1 = {" başarmak"," başarı"," duyurmak"," atlet"," atletizm"," ödül"," basketbol"," düşkün olmak"," dünya rekoru kırmak"," kano sporu"};
    String [] lise11bolum8c2 = {" takım kaptanı"," kutlamak"," şampiyon takım"," şampiyonluk"," uçurumdan atlama"," tırmanma"," antrenör"," yarışmak"," müsabaka"," rakipler"};
    String [] lise11bolum8c3 = {" tehlikeyi hesaba katmak"," geri sayma"," tenis kortu"," bisiklet yarışı"," bisikletçi"," cesaret etmek"," geliştirmek"," dalış"," teşvik etmek"," sonlandırmak"};
    String [] lise11bolum8c4 = {" ekipman"," tehlikeli sporlar"," adil oyun"," emekli olmak"," şansını yakalamak"," yüzücü gözlüğü"," kask"," nefesini tutmak"," buz tırmanışı"," buz hokeyi"};
    String [] lise11bolum8c5 = {" bireysel sporlar"," ilham vermek"," forma"," atlamak"," kikboks"," uçurtma sörfü"," sürmek"," maç"," dağ bisikletciliği"," taşınmak"};
    String [] lise11bolum8c6 = {" milli takım"," paraşüt"," yamaç paraşütü"," engelli olimpiyatları"," oyuncu"," satın almak"," farkındalığı arttırmak"," mücadele ortamı"," hakem"," stresi azaltmak"};


    // 9. bölüm


    String [] lise11bolum9s1 = {"altruistic","arrogant","athletic","calm","charming","cheerful","clever","cute","disloyal","easygoing"};
    String [] lise11bolum9s2 = {"elegant","encouraging","extinguished","eye-catching","fierce","friendly","generous","gentle","gifted","hardworking"};
    String [] lise11bolum9s3 = {"helpful","honest","kind","loyal","modest","polite","powerful","prominent","sensible","sensitive"};
    String [] lise11bolum9s4 = {"serious","short-lived","sincere","strong","stubborn","supportive","talented","talkative","temporary","traditional"};
    String [] lise11bolum9s5 = {"trustworthy","unforgettable","unnoticeable","wealthy","well-built","well-known","achievement","adopt","adventure","afford"};
    String [] lise11bolum9s6 = {"architecture","arrangements","care","childhood","city break","close to heart","defender","depict","descendant","disagreement"};



    String [] lise11bolum9c1 = {" fedakar"," kibirli"," atletik"," sakin"," çekici"," neşeli"," akıllı"," sevimli"," vefasız"," uysal"};
    String [] lise11bolum9c2 = {" şık"," cesaretlendirici"," ortadan kaldırılmış"," göz alıcı"," berbat"," arkadaş canlısı"," cömert"," kibar"," kabiliyetli"," çalışkan"};
    String [] lise11bolum9c3 = {" yardımsever"," dürüst"," kibar"," sadık"," mütevazı"," kibar"," güçlü"," ünlü"," mantıklı"," hassas"};
    String [] lise11bolum9c4 = {" ciddi"," kısa ömürlü"," samimi"," güçlü"," inatçı"," destekleyici"," yetenekli"," konuşkan"," geçici"," geleneksel"};
    String [] lise11bolum9c5 = {" güvenilir"," unutulmaz"," fark edilmeyen"," varlıklı"," yapılı"," bilinen"," başarı"," sahiplenme"," macera"," parası yetmek"};
    String [] lise11bolum9c6 = {" mimari yapı"," düzenlemeler"," önem vermek"," çocukluk"," şehir gezisi"," birine yakın olmak"," muhafız"," resmini çizmek"," torun"," anlaşmazlık"};


    // 10. bölüm

    String [] lise11bolum10s1 = {"anger","angry","appear","arrogant","attitude","autonomy","be patient","be understanding","behave","blissful"};
    String [] lise11bolum10s2 = {"careful","collectivistic","commemorate","commitment","compassion","compassionate","concealing","conceited","connection","cooperation"};
    String [] lise11bolum10s3 = {"core values","cultural awareness","cultural differences","cultural values","culture shock","customs","demand","diligence","discrimination","disrespectful"};
    String [] lise11bolum10s4 = {"elegance","empathy","equality","etiquette","excellent","fair","family structure","family","fault","forgive"};
    String [] lise11bolum10s5 = {"generosity","generous","gentle","grace","graceful","hatred","healthy","helping elderly","honesty","hospitable"};
    String [] lise11bolum10s6 = {"hospitality","hug","humanity","humans","humiliation","humility","humor","humorist","independent","individualistic"};



    String [] lise11bolum10c1 = {" öfke"," öfkeli"," görünmek"," kibirli"," tutum"," bağımsızlık"," sabırlı olmak"," anlayışlı olmak"," davranmak"," çok mutlu"};
    String [] lise11bolum10c2 = {" dikkatli"," ortaklaşacı"," anmak"," bağlılık"," şefkat"," merhametli"," gizleme"," kendini beğenmiş"," bağ"," işbirliği"};
    String [] lise11bolum10c3 = {" temel değerler"," kültürel farkındalık"," kültürel farklılıklar"," kültürel değerler"," kültür şoku"," gelenekler"," rağbet görmek"," çalışkanlık"," ayırım (ırk, cinsiyet vb)"," saygısız"};
    String [] lise11bolum10c4 = {" zarafet"," empati"," eşitlik"," görgü kuralları"," mükemmel"," adil"," aile yapısı"," aile"," hata"," affetmek"};
    String [] lise11bolum10c5 = {" cömertlik"," cömert"," kibar"," nezaket"," zarif"," nefret"," sağlıklı"," büyüklere yardım etme"," dürüstlük"," misafirperver"};
    String [] lise11bolum10c6 = {" misafirperverlik"," sarılmak"," insaniyet"," insanlar"," aşağılama"," tevazu"," mizah"," mizahçı"," bağımsız"," bireyci"};


    // 12. SINIF


    // 1. bölüm
    String [] lise12bolum1s1 = {"ads","agree to an extent","agreeing","appeal","as for me","as i see it","assignment","attitude","attract","award"};
    String [] lise12bolum1s2 = {"aware of","background","based on","bassoon","be neutral","brass","cheer","clarinet","classical","come on!"};
    String [] lise12bolum1s3 = {"conclude","country","cymbals","deafening","determine","disagreeing","dispute","distract","disturb","drums"};
    String [] lise12bolum1s4 = {"eerie","embedded","estimated temperature","fame","fee","folk","french horn","funky","genre","gradually"};
    String [] lise12bolum1s5 = {"harp","healing","heroic","humming","ı don’t think so","ı suppose","ı totally disagree","ın my view","ındeed","impact"};
    String [] lise12bolum1s6 = {"increasing","incredible","inspiration","interviewee","keyboard","lyrics","majority","memorable","mesmerizing","minority"};

    String [] lise12bolum1c1 = {"reklamlar","bir ölçüde katılıyorum","kabul eden","cazip gelmek","bence","bence","görev","tutum","cezbetmek","ödüllendirmek"};
    String [] lise12bolum1c2 = {"farkında","özgeçmiş","bağlı olarak","ağızla çalınan çalgı","tarafsız olmak","bando","neşelendirmek","klarnet","klasik","hadi!"};
    String [] lise12bolum1c3 = {"sonuçlandırmak","kırsal kesim müziği","büyük zil","sağır edici","belirlemek","aynı fikirde olmamak","tartışma","dikkatini dağıtmak","rahatsız etmek","bateri"};
    String [] lise12bolum1c4 = {"ürkütücü","saklı","tahmini sıcaklık","ün","ücret","halk","fransız kornosu","çok iyi","tür","yavaş yavaş"};
    String [] lise12bolum1c5 = {"arp","şifalı","kahramanca","mırıldama","hiç sanmıyorum","sanırım","kesinlikle katılmıyorum","fikrimce","gerçekten de","etki"};
    String [] lise12bolum1c6 = {"artan","inanılmaz","ilham","görüşülen kimse","klavye","şarkı sözleri","çoğunluk","unutulmaz","büyüleyici","azınlık"};

    // 2 . bölüm

    String [] lise12bolum2s1 = {"a life of dedication","absent-minded","accompany","achieve","acquaintance","active","after all","agricultural science","ambitious","angle"};
    String [] lise12bolum2s2 = {"apathetic","architect","argue","argumentative","armed robbery","arriving on time","assignment","associate","average height","average weight"};
    String [] lise12bolum2s3 = {"bad- tempered","badly dressed","bald","barrier","beard","beget","behavioural pattern","beige","beloved owner","benefit"};
    String [] lise12bolum2s4 = {"breed","build","burglary","careless","caucasian","cautious","cheekbone","cheerful","chubby","claim"};
    String [] lise12bolum2s5 = {"collocation","common","considerate","cooperation with friends","cooperative","cruel","dead or alive","debate","decisive","dedication"};
    String [] lise12bolum2s6 = {"demand","dependable","determined","disagreeable","disappear","disappointed","disappointment","disciplined","distinguishing mark","distracted"};



    String [] lise12bolum2c1 = {"adanmış bir hayat","unutkan","eşlik etmek","başarmak","tanıdık","aktif","sonuç olarak","tarım bilimi","hırslı","açı"};
    String [] lise12bolum2c2 = {"soğuk","mimar","tartışmak","tartışmaya açık","silahlı soygun","zamanında ulaşmak","ödev","birleştirmek","ortalama boy","ortalama ağırlık"};
    String [] lise12bolum2c3 = {"huysuz","kötü giyimli","kel","set","sakal","yol açmak","davranış biçimi","bej","sevgili sahibi","yararlanmak"};
    String [] lise12bolum2c4 = {"doğurmak","yapı (vücut)","hırsızlık","dikkatsiz","kafkasyalı","ihtiyatlı","elmacık kemiği","neşeli","hantal","talep etmek"};
    String [] lise12bolum2c5 = {"sıralama","ortak","düşünceli","arkadaşlar ile işbirliği","işbirliği yapan","zalim","ölü ya da diri","tartışma","kararlı","adama"};
    String [] lise12bolum2c6 = {"talepte bulunmak","güvenilir","azimli","kavgacı","gözden kaybolmak","üzgün","hayal kırıklığı","disiplinli","ayırt edici işaret","kaçık"};


    // 3. bölüm


    String [] lise12bolum3s1 = {"allocated","alongside","animal rights","antagonism","application","appreciate","arctic","armband","aspect","associate"};
    String [] lise12bolum3s2 = {"at least","background","banner","basic resources","battlefield","beggar","belief","berate","blame","blanket"};
    String [] lise12bolum3s3 = {"blind","brute","bulletin","bulletin boards","bullfighting","cash prize","children rights","circumstance","civilian","complain"};
    String [] lise12bolum3s4 = {"complaint","conscience","constructed","consumer","cope with","copyright","culture","deaf","decade","definition"};
    String [] lise12bolum3s5 = {"deported","deprived","diamond mines","disabled people","disadvantaged groups","discrimination","discuss a problem","display","distribute","domestic violence"};
    String [] lise12bolum3s6 = {"donation","dormitories","emphasize","existence","expressions of regret","fair wage","fairly","fight against","figure out","first aid"};



    String [] lise12bolum3c1 = {"tahsis edilmiş","yanı sıra","hayvan hakları","düşmanlık","başvuru","değerini artırmak","kuzey kutup bölgesi","kolluk","hal","birleştirmek"};
    String [] lise12bolum3c2 = {"en azından","geçmiş","afiş","temel kaynaklar","harp meydanı","dilenci","inanç","paylamak","suçlamak","battaniye"};
    String [] lise12bolum3c3 = {"kör","kaba","bülten","bülten tahtaları","boğa güreşi","para ödülü","çocuk hakları","durum","sivil","şikayet etmek"};
    String [] lise12bolum3c4 = {"şikayet","vicdan","yapılı","tüketici","baş etmek","telif hakkı","kültür","sağır","onluk","tanım"};
    String [] lise12bolum3c5 = {"sürgün edilmiş","yoksun","elmas madenleri","engelliler","ezilen gruplar","ayrım","bir sorunu ele almak","gösterme","dağıtmak","aile içi şiddet"};
    String [] lise12bolum3c6 = {"bağış","öğrenci yurtları","vurgulamak","mevcudiyet","pişmanlık ifadeleri","iyi bir ücret","iyice","savaşmak","halletmek","ilkyardım"};


    // 4. bölüm



    String [] lise12bolum4s1 = {"accessible","addiction","anti-spyware","apparently","backup","banking password","beneficial","bitter","causing","citizenship number"};
    String [] lise12bolum4s2 = {"come up with","contribution","create an account","crucial","culprit","cyber bullying","cyber crime","cyber tools","cyber world","decrease"};
    String [] lise12bolum4s3 = {"default","dependent","deserve","downloading","eco-friendly","edition","eliminate","embedded","emission","emphasize"};
    String [] lise12bolum4s4 = {"environmental","exponential","extinct","filter","fortune","futurist","gain access","global warming","government","grandchildren"};
    String [] lise12bolum4s5 = {"harassment","harmful","ınvasion of privacy","identity theft","imaginary","imagination","immediately","impact","income","industry"};
    String [] lise12bolum4s6 = {"infamous","injured","innocuous","insecurely","instant","interpret","invasion","keep","knowledge","legitimate"};



    String [] lise12bolum4c1 = {"ulaşılabilir","düşkünlük","anti-casus yazılım","görünüşte","yedek","bankacılık şifresi","yararlı","acı","sebebiyet","vatandaşlık numarası"};
    String [] lise12bolum4c2 = {"ileri sürmek","katkı","hesap açmak","çok önemli","suçlu","sanal zorbalık","bilişim suçu","siber araçlar","sanal alem","azalmak"};
    String [] lise12bolum4c3 = {"kusur","bağımlı","layık olmak","yükleme","çevre dostu","yayın","elemek","gömülü","emisyon","vurgulamak"};
    String [] lise12bolum4c4 = {"çevresel","üsse ait sayı","tükenmiş","filtre","şans","gelecek bilimci","erişim sağlamak","küresel ısınma","hükümet","torunlar"};
    String [] lise12bolum4c5 = {"taciz","zararlı","mahremiyetin ihlali","kimlik hırsızlığı","hayali","hayal gücü","derhal","etki","kazanç","sanayi"};
    String [] lise12bolum4c6 = {"adı kötüye çıkmış","yaralı","zararsız","güvensizce","anlık","yorumlamak","saldırı","saklamak","bilgi","meşrulaştırmak"};


    // 5. bölüm



    String [] lise12bolum5s1 = {"all up","alternatively","amused","annoyed","anxiety","anxious","approachable","approving","blunt","borrow"};
    String [] lise12bolum5s2 = {"bossy","calm","childish","chill out","client","competitor","confusion","contagious","cope with","credibility"};
    String [] lise12bolum5s3 = {"deal with","debt","deep breath","depressed","despair","desperate","determined","disorder","disrespectful","disturb"};
    String [] lise12bolum5s4 = {"dizzy","dried out","elated","embarrassed","empathetic","excited","excited","frown","frustrated","fund"};
    String [] lise12bolum5s5 = {"immune system","impact","influence","interaction","interdependent","joyful","lip","maintaining","miserable","mood"};
    String [] lise12bolum5s6 = {"mood swings","nervous","neutral","optimistic","overhear","postpone","private","puppeteer","recall","recently"};



    String [] lise12bolum5c1 = {"hapı yutmuş","alternatifli olarak","memnuniyet içinde","sinirli","endişe","endişeli","ulaşılabilir","onaylayıcı","köreltmek","ödünç almak"};
    String [] lise12bolum5c2 = {"buyurgan","sakin","çocuksu","sakin ol","müşteri","yarışmacı","karışıklık","bulaşıcı","baş etmek","güvenilirlik"};
    String [] lise12bolum5c3 = {"ile ilgilenmek","borç","derin nefes","morali bozuk","umudunu kesmek","umutsuz","kararlı","kargaşa","saygısız","rahatsız etmek"};
    String [] lise12bolum5c4 = {"başı dönen","kurumak","memnun","utangaç","anlayışlı","heyecanlı","heyecanlı","somurtmak","sinirli","kaynak"};
    String [] lise12bolum5c5 = {"bağışıklık sistemi","etki","etkilemek","etkileşim","birbirine bağlı olan","neşeli","dudak","koruma","acınası","ruh hali"};
    String [] lise12bolum5c6 = {"ruh halinde ani değişimler","gergin","yansız","iyimser","kulak misafiri olmak","ötelemek","özel","kukla oynatıcısı","hatırlamak","son zamanlarda"};



    //6. bölüm


    String [] lise12bolum6s1 = {"Favor ","Decease ","Request ","Undertake ","Ask for ","Provide ","Price ","Scholarship ","Book ","Adopt "};
    String [] lise12bolum6s2 = {"Order ","Development ","Clarification ","Adherent ","Wonder ","Lifelong ","Do you mind ? ","Inquirer ","Find out ","Society "};
    String [] lise12bolum6s3 = {"Convince ","Admission ","Uneager ","Boarding ","Summary ","Found ","Come along ","Required ","Promise ","Establish "};
    String [] lise12bolum6s4 = {"A couple of ","Resource ","Appreciate ","Craftsman ","Deadline ","Grand Bazaar ","Yummy ","Architect ","Vacation ","Non-profit "};
    String [] lise12bolum6s5 = {"View ","Amendment ","Stranger ","Notable ","Accept ","Noted ","Decline ","Volunteer ","Hand ","Disturb "};
    String [] lise12bolum6s6 = {"Hope ","Sweetheart ","Raise ","Glad ","Awaraness ","Turn down ","Donation ","Borrow ","Venue ","Shaker "};



    String [] lise12bolum6c1 = {" İyilik, iyilik etmek"," Ölmek, vefat etmek"," Rica"," Üstlenmek"," Rica etmek, aramak"," Sağlamak, temin etmek"," Ücret"," Burs"," Ayırtmak, rezervasyon yapmak"," Benimsemek"};
    String [] lise12bolum6c2 = {" Sipariş vermek"," Gelişme, kalkınma"," Açıklama"," Bağlı, taraftar"," Merak etmek"," Yaşam boyu"," Sakıncası var mı?"," Sorgulayan"," Bulup çıkarmak"," Toplum"};
    String [] lise12bolum6c3 = {" İkna etmek"," Kabul"," İsteksiz"," Yatılı"," Özet"," Kurmak"," İlerlemek"," Gerekli, istenen"," Söz vermek"," Kurmak"};
    String [] lise12bolum6c4 = {" İki, birkaç"," Kaynak, olanak"," Takdir etmek"," Sanatçı, zanaatkar"," Son teslim tarihi"," Kapalı çarşı"," Lezzetli, nefis"," Mimar"," Tatil"," Kar amacı gütmeyen"};
    String [] lise12bolum6c5 = {" Manzara"," Yasa değişikliği"," Yabancı"," İleri gelen tanınmış kimse"," Kabul etmek"," Meşhur, ünlü"," Reddetmek"," Gönüllü olmak"," Vermek, uzatmak"," Rahatsız etmek"};
    String [] lise12bolum6c6 = {" Ümit"," Canım, canımın içi"," Yükseltmek"," Mutlu"," Farkındalık"," Kısmak, azaltmak"," Bağış"," Ödünç almak"," Olay yeri"," Tuzluk"};


    // 7. bölüm


    String [] lise12bolum7s1 = {"acquaintance","automotive industry","breath","bump into","bye for now","collapse","compete","coronary failure","dawn","debris"};
    String [] lise12bolum7s2 = {"delegation","diagnose","die down","emergency","encounter","exceptionally","experience","eyelids","flag","flashlight"};
    String [] lise12bolum7s3 = {"fresh air","government","grab","gripe","hail","headline","hit the road","honor","hopeful","ice cube"};
    String [] lise12bolum7s4 = {"income","indicator","insurance","intelligent","intensive care","interrupt","joy","likewise","locksmith","meanwhile"};
    String [] lise12bolum7s5 = {"miraculous","miraculously","nervous","overnight","possibility","postpone","prayer","precaution","private","reputation"};
    String [] lise12bolum7s6 = {"shelter","snow flake","steep slope","stopover","strange","stroll","success","suddenly","sunshine","survival"};



    String [] lise12bolum7c1 = {"tanıdık","otomobil sanayi","nefes","karşılaşmak","şimdilik hoşça kal","çökmek","rekabet etmek","kalp yetmezliği","şafak","enkaz"};
    String [] lise12bolum7c2 = {"heyet","teşhis etmek","kesilmek","acil durum","karşılaşmak","istisnai olarak","deneyim","göz kapakları","bayrak","el feneri"};
    String [] lise12bolum7c3 = {"taze hava","hükümet","yakalamak","sancı","dolu","manşet","yola çıkmak","onur","umutlu","buz küpü"};
    String [] lise12bolum7c4 = {"gelir","gösterge","sigorta","zeki","yoğun bakım","kesmek","keyif","aynı şekilde","çilingir","bu sırada"};
    String [] lise12bolum7c5 = {"garip","mucizevi","asabi","gecelemek","imkan","ertelemek","ibadet eden kimse","önlem","özel","ün"};
    String [] lise12bolum7c6 = {"barınak","kar tanesi","dik yamaç","mola","tuhaf","gezip dolaşmak","başarı","aniden","güneş ışığı","hayatta kalma"};


    // 8. bölüm

    String [] lise12bolum8s1 = {"Account for ","Address ","Affordable ","Alternative ","Amazing ","Appreciate ","At issue ","Average ","Avoid ","Awareness "};
    String [] lise12bolum8s2 = {"Ban ","Banner ","Boast ","Broaden ","Carbon footprint ","Celebrity ","Central Heating ","Charger ","Coal ","Co-founder "};
    String [] lise12bolum8s3 = {"Combined ","Commercial ","Company ","Compare ","Complaint ","Concern ","Consider ","Construct ","Consumption ","Continuously "};
    String [] lise12bolum8s4 = {"Contribution ","Council ","CRT ","Curb ","Cure ","Deal with ","Debatable ","Dedicate ","Deforestation ","Demand "};
    String [] lise12bolum8s5 = {"Determine ","Devote ","Disposal ","Drain ","Dump ","Emission ","End up ","Essential ","Excessive ","Expectation "};
    String [] lise12bolum8s6 = {"Expert ","Exploration ","Extend ","Extinction ","Familiar ","Fascinate ","Fatal ","Figure out ","Focus on ","Folder "};



    String [] lise12bolum8c1 = {"Sorumlu olmak, sebebi olmak","Hitap etmek","Düşük maliyetli"," Alternatif"," Şaşırtıcı"," Takdir etmek"," Tartışılan konu"," Ortalama"," Kaçınmak"," Farkındalık"};
    String [] lise12bolum8c2 = {"Yasaklama, yasak","Pankart,afiş","Övünmek","Genişletmek"," Çevreye verilen zararın ölçümü amacıyla, belirli bir zaman içinde bir kişi, kurum tarafından doğaya verilen karbon miktarı"," Ünlü kişi"," Kalorifer, merkezi ısıtma"," Şarj aleti"," Kömür"," Kurucu ortak"};
    String [] lise12bolum8c3 = {"Birleşik, karma","Ticari","Şirket","Karşılaştırmak","Şikayet"," İlgilendirmek, ilgililendiren şey"," Düşünmek"," İnşa etmek"," Tüketim"," Sürekli, durmadan"};
    String [] lise12bolum8c4 = {"Katkı"," Konsey, meclis","Katot ışın tüpü"," Kontrol altına almak"," İyileşmek"," Üstesinden gelmek"," Tartışılır"," Adamak"," Ormanı yok etme"," Talep"};
    String [] lise12bolum8c5 = {"Karar vermek","Adamak","İmha etme"," Tüketmek, sömürmek"," Boşaltmak, atmak"," Emisyon, çıkarma"," Bitirmek, bağlamak"," Temel, esas"," Aşırı"," Beklenti"};
    String [] lise12bolum8c6 = {"Uzman"," Keşif","Uzatmak,genişletmek"," Ortadan kalkma"," Tanıdık, aşina"," Büyülemek"," Ölümcül"," Düşünerek bulmak"," Odaklanmak"," Dosya"};


    // 9. bölüm


    String [] lise12bolum9s1 = {"accessible","additionally","advertisement banners","air conditioning","alert","annotate","anyway","backtrack","bandwidth","beneficial"};
    String [] lise12bolum9s2 = {"binary number","bitwise","brake","breadcrumbs","broken cord","built- in","cache","catch criminal","ceramic tile","chemical weapons"};
    String [] lise12bolum9s3 = {"chopping board","complete mess","contribute","copier","crack","crease","cruel","cutting edge","deal with","delivery"};
    String [] lise12bolum9s4 = {"dimension","door handle","doughy","drag and drop","drone","electromagnetically","emit","enhance","exaggerate","executing"};
    String [] lise12bolum9s5 = {"expenditure","eyesight","familiar with","fatal","faucet","feature","footer","formatted","gadget","get out of sight"};
    String [] lise12bolum9s6 = {"goggles","grab","headset","hit the nail on the head","household","housekeeper","hyperlink","ın spite of","ındeed","ındifference"};



    String [] lise12bolum9c1 = {"ulaşılabilir","bundan başka","reklam afişleri","klima","uyarmak","not eklemek","neyse","geriye dönüş yapma","band aralığı","yararlı"};
    String [] lise12bolum9c2 = {"ikili sayı","bitsel","fren","ekmek kırıntıları","kırık kordon","içinde var olan","saklamak","suçlu yakalamak","karo fayans","kimyasal silahlar"};
    String [] lise12bolum9c3 = {"kesme tahtası","tam bir karmaşa","katkıda bulunmak","fotokopi makinesi","çatlamak","kırışık","zalim","en yeni","muhatap olmak","teslimat"};
    String [] lise12bolum9c4 = {"boyut","kapı tokmağı","pelte gibi","sürükleyip bırakmak","insansız hava aracı","elektromanyetik olarak","yaymak","büyütmek","abartmak","yürütme"};
    String [] lise12bolum9c5 = {"gider","görme gücü","aşina","ölümcül","musluk","özellik","altbaşlık","formatlanmış","ıvır zıvır/küçük alet","ortadan kaybolmak"};
    String [] lise12bolum9c6 = {"gözlük","yakalamak","kulaklık","tam üstüne basmak","evle ilgili","temizlikçi kadın","köprü","-e rağmen","doğrusu","ilgisizlik"};


    // 10. bölüm

    String [] lise12bolum10s1 = {"acceptability","accidentally","admit","aware","be carried away","belching","bother","burp","charge","compensation"};
    String [] lise12bolum10s2 = {"complaining","component","constant","continuously","crucial","curse","desperate","determine","distract","do a favor"};
    String [] lise12bolum10s3 = {"dude","eager","embarrassed","enthusiasm","era","excessive noise","expectation","flabbergast","frustration","get in line"};
    String [] lise12bolum10s4 = {"go off","handbag","helpless","ignorance","intention","jerked","jungle","lifeblood","loyalty","make a grimace"};
    String [] lise12bolum10s5 = {"mannerism","manners","massive","much-needed","nearby","necessity","out of use","overlooked","oversight","paper route"};
    String [] lise12bolum10s6 = {"perceive","pick one’s nose","precious","preserved","rails","refuse","regret","regretful","respect","scared"};



    String [] lise12bolum10c1 = {" kabul edilebilirlik"," kazara"," kabul etmek"," farkında"," kapılmak"," püskürtme"," rahatsız etmek"," geğirmek"," ödetmek"," telafi"};
    String [] lise12bolum10c2 = {" şikayet etme"," parça"," değişmez"," aralıksız"," çok önemli"," küfretmek"," umutsuz"," belirlemek"," dikkatini dağıtmak"," iyilik etmek"};
    String [] lise12bolum10c3 = {" ahbap"," istekli"," mahcup"," çoşku"," dönem"," aşırı gürültü"," beklenti"," çok şaşırtmak"," hüsran"," sıra almak"};
    String [] lise12bolum10c4 = {" çıkıp gitmek"," el çantası"," çaresiz"," bilgisizlik"," niyet"," kandırılmış"," orman"," Yaşam kaynağı"," sadakat"," suratını ekşitmek"};
    String [] lise12bolum10c5 = {" üsluba bağlılık"," görgü"," büyük"," çok ihtiyaç duyulan"," yakındaki"," gereklilik"," kullanılmayan"," gözden kaçmış"," dikkatsizlik"," gazete dağıtma işi"};
    String [] lise12bolum10c6 = {" algılamak"," burnunu karıştırmak"," kıymetli"," korunmuş"," tren rayları"," reddetmek"," pişmanlık"," pişman"," saygı"," korkmuş"};



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
        setContentView(R.layout.activity_kelimelise);
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
        textToSpeech = new TextToSpeech(Kelimelise.this, new TextToSpeech.OnInitListener() {
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
            Intent intent = new Intent(Kelimelise.this,Kelimelise.class);
            startActivity(intent);
            finish();
        });

        mView.findViewById(R.id.next).setOnClickListener(v -> {
            if (Objects.equals(sev, "9.SINIFbölüm1s1")){
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm1s2").apply();
            } else if (Objects.equals(sev, "9.SINIFbölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm1s3").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm1s4").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm1s5").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm1s5")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm1s6").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm1s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1 Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }  if (Objects.equals(sev, "9.SINIFbölüm3s1")){
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm3s2").apply();
            } else if (Objects.equals(sev, "9.SINIFbölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm3s3").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm3s4").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm3s4")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm3s5").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm3s5")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm3s6").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm3s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            } if (Objects.equals(sev, "9.SINIFbölüm2s1")){
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm2s2").apply();
            } else if (Objects.equals(sev, "9.SINIFbölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm1s3").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm2s4").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm2s5").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm2s5")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm2s6").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm2s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "9.SINIFbölüm4s1")){
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm4s2").apply();
            } else if (Objects.equals(sev, "9.SINIFbölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm4s3").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm4s3")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm4s4").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm4s4")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm4s5").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm4s5")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm4s6").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm4s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "9.SINIFbölüm5s1")){
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm5s2").apply();
            } else if (Objects.equals(sev, "9.SINIFbölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm5s3").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm5s3")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm5s4").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm5s4")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm5s5").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm5s5")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm5s6").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm5s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "9.SINIFbölüm6s1")){
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm6s2").apply();
            } else if (Objects.equals(sev, "9.SINIFbölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm6s3").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm6s3")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm6s4").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm6s4")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm6s5").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm6s5")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm6s6").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm6s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "9.SINIFbölüm7s1")){
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm7s2").apply();
            } else if (Objects.equals(sev, "9.SINIFbölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm7s3").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm7s3")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm7s4").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm7s4")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm7s5").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm7s5")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm7s6").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm7s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "9.SINIFbölüm8s1")){
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm8s2").apply();
            } else if (Objects.equals(sev, "9.SINIFbölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm8s3").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm8s4").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm8s4")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm8s5").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm8s5")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm8s6").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm8s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "9.SINIFbölüm9s1")){
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm9s2").apply();
            } else if (Objects.equals(sev, "9.SINIFbölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm9s3").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm9s3")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm9s4").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm9s4")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm9s5").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm9s5")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm9s6").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm9s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "9.SINIFbölüm10s1")){
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm10s2").apply();
            } else if (Objects.equals(sev, "9.SINIFbölüm10s2")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm10s3").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm10s3")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm10s4").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm10s4")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm10s5").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm10s5")) {
                sharedPreferences.edit().putString("seviye1","9.SINIFbölüm10s6").apply();
            }else if (Objects.equals(sev, "9.SINIFbölüm10s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 10. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "10.SINIFbölüm1s1")){
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm1s2").apply();
            } else if (Objects.equals(sev, "10.SINIFbölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm1s3").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm1s4").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm1s5").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm1s5")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm1s6").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm1s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "10.SINIFbölüm2s1")){
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm2s2").apply();
            } else if (Objects.equals(sev, "10.SINIFbölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm2s3").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm2s4").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm2s4")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm2s5").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm2s5")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm2s6").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm2s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "10.SINIFbölüm3s1")){
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm3s2").apply();
            } else if (Objects.equals(sev, "10.SINIFbölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm3s3").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm3s4").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm3s4")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm3s5").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm3s5")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm3s6").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm3s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "10.SINIFbölüm4s1")){
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm4s2").apply();
            } else if (Objects.equals(sev, "10.SINIFbölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm4s3").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm4s3")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm4s4").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm4s4")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm4s5").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm4s5")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm4s6").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm4s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "10.SINIFbölüm5s1")){
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm5s2").apply();
            } else if (Objects.equals(sev, "10.SINIFbölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm5s3").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm5s3")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm5s4").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm5s4")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm5s5").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm5s5")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm5s6").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm5s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "10.SINIFbölüm6s1")){
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm6s2").apply();
            } else if (Objects.equals(sev, "10.SINIFbölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm6s3").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm6s3")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm6s4").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm6s4")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm6s5").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm6s5")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm6s6").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm6s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "10.SINIFbölüm7s1")){
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm7s2").apply();
            } else if (Objects.equals(sev, "10.SINIFbölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm7s3").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm7s3")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm7s4").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm7s4")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm7s5").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm7s5")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm7s6").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm7s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "10.SINIFbölüm8s1")){
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm8s2").apply();
            } else if (Objects.equals(sev, "10.SINIFbölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm8s3").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm8s4").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm8s4")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm8s5").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm8s5")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm8s6").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm8s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }




            if (Objects.equals(sev, "10.SINIFbölüm9s1")){
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm9s2").apply();
            } else if (Objects.equals(sev, "10.SINIFbölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm9s3").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm9s3")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm9s4").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm9s4")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm9s5").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm9s5")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm9s6").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm9s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "10.SINIFbölüm10s1")){
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm10s2").apply();
            } else if (Objects.equals(sev, "10.SINIFbölüm10s2")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm10s3").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm10s3")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm10s4").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm10s4")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm10s5").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm10s5")) {
                sharedPreferences.edit().putString("seviye1","10.SINIFbölüm10s6").apply();
            }else if (Objects.equals(sev, "10.SINIFbölüm10s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 10. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            // 11 . SINIF



              if (Objects.equals(sev, "11.SINIFbölüm1s1")){
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm1s2").apply();
            } else if (Objects.equals(sev, "11.SINIFbölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm1s3").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm1s4").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm1s5").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm1s5")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm1s6").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm1s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "11.SINIFbölüm2s1")){
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm2s2").apply();
            } else if (Objects.equals(sev, "11.SINIFbölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm2s3").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm2s4").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm2s4")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm2s5").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm2s5")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm2s6").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm2s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "11.SINIFbölüm3s1")){
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm3s2").apply();
            } else if (Objects.equals(sev, "11.SINIFbölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm3s3").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm3s4").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm3s4")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm3s5").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm3s5")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm3s6").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm3s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "11.SINIFbölüm4s1")){
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm4s2").apply();
            } else if (Objects.equals(sev, "11.SINIFbölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm4s3").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm4s3")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm4s4").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm4s4")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm4s5").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm4s5")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm4s6").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm4s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "11.SINIFbölüm5s1")){
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm5s2").apply();
            } else if (Objects.equals(sev, "11.SINIFbölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm5s3").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm5s3")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm5s4").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm5s4")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm5s5").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm5s5")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm5s6").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm5s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "11.SINIFbölüm6s1")){
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm6s2").apply();
            } else if (Objects.equals(sev, "11.SINIFbölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm6s3").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm6s3")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm6s4").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm6s4")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm6s5").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm6s5")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm6s6").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm6s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "11.SINIFbölüm7s1")){
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm7s2").apply();
            } else if (Objects.equals(sev, "11.SINIFbölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm7s3").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm7s3")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm7s4").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm7s4")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm7s5").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm7s5")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm7s6").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm7s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "11.SINIFbölüm8s1")){
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm8s2").apply();
            } else if (Objects.equals(sev, "11.SINIFbölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm8s3").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm8s4").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm8s4")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm8s5").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm8s5")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm8s6").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm8s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }




            if (Objects.equals(sev, "11.SINIFbölüm9s1")){
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm9s2").apply();
            } else if (Objects.equals(sev, "11.SINIFbölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm9s3").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm9s3")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm9s4").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm9s4")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm9s5").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm9s5")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm9s6").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm9s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "11.SINIFbölüm10s1")){
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm10s2").apply();
            } else if (Objects.equals(sev, "11.SINIFbölüm10s2")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm10s3").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm10s3")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm10s4").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm10s4")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm10s5").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm10s5")) {
                sharedPreferences.edit().putString("seviye1","11.SINIFbölüm10s6").apply();
            }else if (Objects.equals(sev, "11.SINIFbölüm10s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 10. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            //12 . SINIF



              if (Objects.equals(sev, "12.SINIFbölüm1s1")){
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm1s2").apply();
            } else if (Objects.equals(sev, "12.SINIFbölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm1s3").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm1s4").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm1s5").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm1s5")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm1s6").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm1s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "12.SINIFbölüm2s1")){
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm2s2").apply();
            } else if (Objects.equals(sev, "12.SINIFbölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm2s3").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm2s4").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm2s4")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm2s5").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm2s5")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm2s6").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm2s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "12.SINIFbölüm3s1")){
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm3s2").apply();
            } else if (Objects.equals(sev, "12.SINIFbölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm3s3").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm3s4").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm3s4")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm3s5").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm3s5")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm3s6").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm3s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "12.SINIFbölüm4s1")){
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm4s2").apply();
            } else if (Objects.equals(sev, "12.SINIFbölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm4s3").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm4s3")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm4s4").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm4s4")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm4s5").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm4s5")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm4s6").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm4s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "12.SINIFbölüm5s1")){
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm5s2").apply();
            } else if (Objects.equals(sev, "12.SINIFbölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm5s3").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm5s3")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm5s4").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm5s4")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm5s5").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm5s5")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm5s6").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm5s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "12.SINIFbölüm6s1")){
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm6s2").apply();
            } else if (Objects.equals(sev, "12.SINIFbölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm6s3").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm6s3")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm6s4").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm6s4")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm6s5").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm6s5")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm6s6").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm6s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "12.SINIFbölüm7s1")){
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm7s2").apply();
            } else if (Objects.equals(sev, "12.SINIFbölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm7s3").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm7s3")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm7s4").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm7s4")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm7s5").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm7s5")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm7s6").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm7s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "12.SINIFbölüm8s1")){
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm8s2").apply();
            } else if (Objects.equals(sev, "12.SINIFbölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm8s3").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm8s4").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm8s4")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm8s5").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm8s5")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm8s6").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm8s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }




            if (Objects.equals(sev, "12.SINIFbölüm9s1")){
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm9s2").apply();
            } else if (Objects.equals(sev, "12.SINIFbölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm9s3").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm9s3")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm9s4").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm9s4")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm9s5").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm9s5")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm9s6").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm9s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "12.SINIFbölüm10s1")){
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm10s2").apply();
            } else if (Objects.equals(sev, "12.SINIFbölüm10s2")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm10s3").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm10s3")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm10s4").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm10s4")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm10s5").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm10s5")) {
                sharedPreferences.edit().putString("seviye1","12.SINIFbölüm10s6").apply();
            }else if (Objects.equals(sev, "12.SINIFbölüm10s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 10. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if(i ==0){
                alertDialog.dismiss();
                Intent intent = new Intent(Kelimelise.this, Kelimelise.class);
                startActivity(intent);
                finish();
            }
        });
        mView.findViewById(R.id.anamenu).setOnClickListener(v -> {
            alertDialog.dismiss();
            Intent intent = new Intent(Kelimelise.this,MainActivity5.class);
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
                    mInterstitialAd.show(Kelimelise.this);
                }
            ShowDialogBox();
            if (sev.contains("9.SINIFbölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='9.SINIFbölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='9.SINIFbölüm1'");
            }
            if (sev.contains("9.SINIFbölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='9.SINIFbölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='9.SINIFbölüm2'");
            }
            if (sev.contains("9.SINIFbölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='9.SINIFbölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='9.SINIFbölüm3'");
            }
            if (sev.contains("9.SINIFbölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='9.SINIFbölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='9.SINIFbölüm4'");
            }
            if (sev.contains("9.SINIFbölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='9.SINIFbölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='9.SINIFbölüm5'");
            }
            if (sev.contains("9.SINIFbölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='9.SINIFbölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='9.SINIFbölüm6'");
            }
            if (sev.contains("9.SINIFbölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='9.SINIFbölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='9.SINIFbölüm7'");
            }
            if (sev.contains("9.SINIFbölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='9.SINIFbölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='9.SINIFbölüm8'");
            }
            if (sev.contains("9.SINIFbölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='9.SINIFbölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='9.SINIFbölüm9'");
            }
            if (sev.contains("9.SINIFbölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='9.SINIFbölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='9.SINIFbölüm10'");
            }


            // 10. SINIF




            if (sev.contains("10.SINIFbölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='10.SINIFbölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='10.SINIFbölüm1'");
            }
            if (sev.contains("10.SINIFbölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='10.SINIFbölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='10.SINIFbölüm2'");
            }
            if (sev.contains("10.SINIFbölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='10.SINIFbölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='10.SINIFbölüm3'");
            }
            if (sev.contains("10.SINIFbölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='10.SINIFbölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='10.SINIFbölüm4'");
            }
            if (sev.contains("10.SINIFbölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='10.SINIFbölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='10.SINIFbölüm5'");
            }
            if (sev.contains("10.SINIFbölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='10.SINIFbölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='10.SINIFbölüm6'");
            }
            if (sev.contains("10.SINIFbölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='10.SINIFbölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='10.SINIFbölüm7'");
            }
            if (sev.contains("10.SINIFbölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='10.SINIFbölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='10.SINIFbölüm8'");
            }
            if (sev.contains("10.SINIFbölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='10.SINIFbölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='10.SINIFbölüm9'");
            }
            if (sev.contains("10.SINIFbölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='10.SINIFbölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='10.SINIFbölüm10'");
            }




            // 11. SINIF



            if (sev.contains("11.SINIFbölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='11.SINIFbölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='11.SINIFbölüm1'");
            }
            if (sev.contains("11.SINIFbölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='11.SINIFbölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='11.SINIFbölüm2'");
            }
            if (sev.contains("11.SINIFbölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='11.SINIFbölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='11.SINIFbölüm3'");
            }
            if (sev.contains("11.SINIFbölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='11.SINIFbölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='11.SINIFbölüm4'");
            }
            if (sev.contains("11.SINIFbölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='11.SINIFbölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='11.SINIFbölüm5'");
            }
            if (sev.contains("11.SINIFbölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='11.SINIFbölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='11.SINIFbölüm6'");
            }
            if (sev.contains("11.SINIFbölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='11.SINIFbölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='11.SINIFbölüm7'");
            }
            if (sev.contains("11.SINIFbölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='11.SINIFbölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='11.SINIFbölüm8'");
            }
            if (sev.contains("11.SINIFbölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='11.SINIFbölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='11.SINIFbölüm9'");
            }
            if (sev.contains("11.SINIFbölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='11.SINIFbölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='11.SINIFbölüm10'");
            }



            // 12 . SINIF




            if (sev.contains("12.SINIFbölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='12.SINIFbölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='12.SINIFbölüm1'");
            }
            if (sev.contains("12.SINIFbölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='12.SINIFbölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='12.SINIFbölüm2'");
            }
            if (sev.contains("12.SINIFbölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='12.SINIFbölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='12.SINIFbölüm3'");
            }
            if (sev.contains("12.SINIFbölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='12.SINIFbölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='12.SINIFbölüm4'");
            }
            if (sev.contains("12.SINIFbölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='12.SINIFbölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='12.SINIFbölüm5'");
            }
            if (sev.contains("12.SINIFbölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='12.SINIFbölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='12.SINIFbölüm6'");
            }
            if (sev.contains("12.SINIFbölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='12.SINIFbölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='12.SINIFbölüm7'");
            }
            if (sev.contains("12.SINIFbölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='12.SINIFbölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='12.SINIFbölüm8'");
            }
            if (sev.contains("12.SINIFbölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='12.SINIFbölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='12.SINIFbölüm9'");
            }
            if (sev.contains("12.SINIFbölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='12.SINIFbölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='12.SINIFbölüm10'");
            }

            database.execSQL("UPDATE P SET puan=puan+" + sorudogru * 2 + "");


            if (sev.equals("9.SINIFbölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm1s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s5yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm1s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm1s6yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm2s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s5yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm2s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm2s6yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm3s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s5yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm3s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm3s6yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm4s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s4yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm4s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s5yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm4s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm4s6yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm5s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s4yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm5s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s5yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm5s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm5s6yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm6s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s4yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm6s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s5yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm6s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm6s6yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm7s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s4yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm7s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s5yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm7s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm7s6yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm8s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s5yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm8s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm8s6yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s3yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm9s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s4yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm9s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s5yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm9s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm9s6yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm10s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s1yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm10s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s2yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm10s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s3yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm10s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s4yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm10s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s5yildiz", "2").apply();
                }
            }
            if (sev.equals("9.SINIFbölüm10s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("9.SINIFbölüm10s6yildiz", "2").apply();
                }
            }


            // 10 . SINIF

            if (sev.equals("10.SINIFbölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm1s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIF2bölüm1s5yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm1s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm1s6yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm2s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s5yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm2s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm2s6yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm3s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s5yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm3s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm3s6yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm4s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s4yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm4s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s5yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm4s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm4s6yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm5s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s4yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm5s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s5yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm5s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm5s6yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm6s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s4yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm6s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s5yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm6s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm6s6yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm7s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s4yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm7s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s5yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm7s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm7s6yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm8s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s5yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm8s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm8s6yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s3yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm9s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s4yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm9s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s5yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm9s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm9s6yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm10s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s1yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm10s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s2yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm10s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s3yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm10s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s4yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm10s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s5yildiz", "2").apply();
                }
            }
            if (sev.equals("10.SINIFbölüm10s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("10.SINIFbölüm10s6yildiz", "2").apply();
                }
            }



            // 11. SINIF


            if (sev.equals("11.SINIFbölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm1s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIF2bölüm1s5yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm1s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm1s6yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm2s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s5yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm2s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm2s6yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm3s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s5yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm3s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm3s6yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm4s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s4yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm4s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s5yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm4s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm4s6yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm5s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s4yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm5s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s5yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm5s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm5s6yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm6s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s4yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm6s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s5yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm6s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm6s6yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm7s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s4yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm7s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s5yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm7s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm7s6yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm8s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s5yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm8s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm8s6yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s3yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm9s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s4yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm9s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s5yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm9s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm9s6yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm10s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s1yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm10s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s2yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm10s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s3yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm10s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s4yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm10s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s5yildiz", "2").apply();
                }
            }
            if (sev.equals("11.SINIFbölüm10s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("11.SINIFbölüm10s6yildiz", "2").apply();
                }
            }




            // 12. SINIF



            if (sev.equals("12.SINIFbölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm1s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIF2bölüm1s5yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm1s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm1s6yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm2s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s5yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm2s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm2s6yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm3s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s5yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm3s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm3s6yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm4s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s4yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm4s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s5yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm4s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm4s6yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm5s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s4yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm5s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s5yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm5s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm5s6yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm6s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s4yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm6s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s5yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm6s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm6s6yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm7s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s4yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm7s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s5yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm7s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm7s6yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm8s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s5yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm8s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm8s6yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s3yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm9s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s4yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm9s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s5yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm9s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm9s6yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm10s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s1yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm10s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s2yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm10s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s3yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm10s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s4yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm10s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s5yildiz", "2").apply();
                }
            }
            if (sev.equals("12.SINIFbölüm10s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("12.SINIFbölüm10s6yildiz", "2").apply();
                }
            }





            // SORU EKRANI




            // 9. SINIF

        } else if (Objects.equals(sev, "9.SINIFbölüm1s1")) {
            soru1 = new Soru( lise9bolum1s1[sorusay],  lise9bolum1c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm1s2")){
            soru1 = new Soru( lise9bolum1s2[sorusay],  lise9bolum1c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm1s3")){
            soru1 = new Soru( lise9bolum1s3[sorusay],  lise9bolum1c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm1s4")){
            soru1 = new Soru( lise9bolum1s4[sorusay],  lise9bolum1c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm1s5")){
            soru1 = new Soru( lise9bolum1s5[sorusay],  lise9bolum1c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm1s6")){
            soru1 = new Soru( lise9bolum1s6[sorusay],  lise9bolum1c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev,"9.SINIFbölüm2s1")){
            soru1 = new Soru( lise9bolum2s1[sorusay], lise9bolum2c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm2s2")){
            soru1 = new Soru( lise9bolum2s2[sorusay],  lise9bolum2c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm2s3")){
            soru1 = new Soru( lise9bolum2s3[sorusay],  lise9bolum2c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm2s4")){
            soru1 = new Soru( lise9bolum2s4[sorusay],  lise9bolum2c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm2s5")){
            soru1 = new Soru( lise9bolum2s5[sorusay],  lise9bolum2c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm2s6")){
            soru1 = new Soru( lise9bolum2s6[sorusay],  lise9bolum2c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm3s1")){
            soru1 = new Soru( lise9bolum3s1[sorusay],  lise9bolum3c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm3s2")){
            soru1 = new Soru( lise9bolum3s2[sorusay],  lise9bolum3c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm3s3")){
            soru1 = new Soru( lise9bolum3s3[sorusay],  lise9bolum3c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm3s4")){
            soru1 = new Soru( lise9bolum3s4[sorusay],  lise9bolum3c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm3s5")){
            soru1 = new Soru( lise9bolum3s5[sorusay],  lise9bolum3c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm3s6")){
            soru1 = new Soru( lise9bolum3s6[sorusay],  lise9bolum3c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm4s1")){
            soru1 = new Soru( lise9bolum4s1[sorusay],  lise9bolum4c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm4s2")){
            soru1 = new Soru( lise9bolum4s2[sorusay],  lise9bolum4c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm4s3")){
            soru1 = new Soru( lise9bolum4s3[sorusay],  lise9bolum4c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm4s4")){
            soru1 = new Soru( lise9bolum4s4[sorusay],  lise9bolum4c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm4s5")){
            soru1 = new Soru( lise9bolum4s5[sorusay],  lise9bolum4c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm4s6")){
            soru1 = new Soru( lise9bolum4s6[sorusay],  lise9bolum4c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm5s1")){
            soru1 = new Soru( lise9bolum5s1[sorusay],  lise9bolum5c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm5s2")){
            soru1 = new Soru( lise9bolum5s2[sorusay],  lise9bolum5c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm5s3")){
            soru1 = new Soru( lise9bolum5s3[sorusay],  lise9bolum5c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm5s4")){
            soru1 = new Soru( lise9bolum5s4[sorusay], lise9bolum5c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm5s5")){
            soru1 = new Soru( lise9bolum5s5[sorusay],  lise9bolum5c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm5s6")){
            soru1 = new Soru( lise9bolum5s6[sorusay],  lise9bolum5c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm6s1")){
            soru1 = new Soru( lise9bolum6s1[sorusay],  lise9bolum6c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm6s2")){
            soru1 = new Soru( lise9bolum6s2[sorusay],  lise9bolum6c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm6s3")){
            soru1 = new Soru( lise9bolum6s3[sorusay], lise9bolum6c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm6s4")){
            soru1 = new Soru( lise9bolum6s4[sorusay],  lise9bolum6c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm6s5")){
            soru1 = new Soru( lise9bolum6s5[sorusay], lise9bolum6c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm6s6")){
            soru1 = new Soru( lise9bolum6s1[sorusay],  lise9bolum6c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm7s1")){
            soru1 = new Soru( lise9bolum7s1[sorusay],  lise9bolum7c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm7s2")){
            soru1 = new Soru( lise9bolum7s2[sorusay],  lise9bolum7c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm7s3")){
            soru1 = new Soru( lise9bolum7s3[sorusay],  lise9bolum7c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm7s4")){
            soru1 = new Soru( lise9bolum7s4[sorusay],  lise9bolum7c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm7s5")){
            soru1 = new Soru( lise9bolum7s5[sorusay],  lise9bolum7c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm7s6")){
            soru1 = new Soru( lise9bolum7s6[sorusay],  lise9bolum7c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm8s1")){
            soru1 = new Soru( lise9bolum8s1[sorusay],  lise9bolum8c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm8s2")){
            soru1 = new Soru( lise9bolum8s2[sorusay], lise9bolum8c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm8s3")){
            soru1 = new Soru(lise9bolum8s3[sorusay], lise9bolum8c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm8s4")){
            soru1 = new Soru(lise9bolum8s4[sorusay], lise9bolum8c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm8s5")){
            soru1 = new Soru(lise9bolum8s5[sorusay], lise9bolum8c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "9.SINIFbölüm8s6")){
            soru1 = new Soru(lise9bolum8s6[sorusay], lise9bolum8c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();

         // 10 . SINIF

        }else if (Objects.equals(sev, "10.SINIFbölüm1s1")){
        soru1 = new Soru(lise10bolum1s1[sorusay], lise10bolum1c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm1s2")){
        soru1 = new Soru(lise10bolum1s2[sorusay], lise10bolum1c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm1s3")){
        soru1 = new Soru(lise10bolum1s3[sorusay], lise10bolum1c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm1s4")){
        soru1 = new Soru(lise10bolum1s4[sorusay], lise10bolum1c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm1s5")){
        soru1 = new Soru(lise10bolum1s5[sorusay], lise10bolum1c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm1s6")){
        soru1 = new Soru(lise10bolum1s6[sorusay], lise10bolum1c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm2s1")){
        soru1 = new Soru(lise10bolum2s1[sorusay], lise10bolum2c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm2s2")){
        soru1 = new Soru(lise10bolum2s2[sorusay], lise10bolum2c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm2s3")){
        soru1 = new Soru(lise10bolum2s3[sorusay], lise10bolum2c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm2s4")){
        soru1 = new Soru(lise10bolum2s4[sorusay], lise10bolum2c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm2s5")){
        soru1 = new Soru(lise10bolum2s5[sorusay], lise10bolum2c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm2s6")){
        soru1 = new Soru(lise10bolum2s6[sorusay],lise10bolum2c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm3s1")){
        soru1 = new Soru(lise10bolum3s1[sorusay], lise10bolum3c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm3s2")){
        soru1 = new Soru(lise10bolum3s2[sorusay], lise10bolum3c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm3s3")){
        soru1 = new Soru(lise10bolum3s3[sorusay], lise10bolum3c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm3s4")){
        soru1 = new Soru(lise10bolum3s4[sorusay], lise10bolum3c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm3s5")){
        soru1 = new Soru(lise10bolum3s5[sorusay], lise10bolum3c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm3s6")){
        soru1 = new Soru(lise10bolum3s6[sorusay], lise10bolum3c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm4s1")){
        soru1 = new Soru(lise10bolum4s1[sorusay], lise10bolum4c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm4s2")){
        soru1 = new Soru(lise10bolum4s2[sorusay],lise10bolum4c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm4s3")){
        soru1 = new Soru(lise10bolum4s3[sorusay],lise10bolum4c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm4s4")){
        soru1 = new Soru(lise10bolum4s4[sorusay], lise10bolum4c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm4s5")){
        soru1 = new Soru(lise10bolum4s5[sorusay], lise10bolum4c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm4s6")){
        soru1 = new Soru(lise10bolum4s6[sorusay], lise10bolum4c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm5s1")){
        soru1 = new Soru(lise10bolum5s1[sorusay], lise10bolum5c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm5s2")){
        soru1 = new Soru(lise10bolum5s2[sorusay], lise10bolum5c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm5s3")){
        soru1 = new Soru(lise10bolum5s3[sorusay],lise10bolum5c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm5s4")){
        soru1 = new Soru(lise10bolum5s4[sorusay], lise10bolum5c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm5s5")){
        soru1 = new Soru(lise10bolum5s5[sorusay], lise10bolum5c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm5s6")){
        soru1 = new Soru(lise10bolum5s6[sorusay], lise10bolum5c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm6s1")){
        soru1 = new Soru(lise10bolum6s1[sorusay], lise10bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm6s2")){
        soru1 = new Soru(lise10bolum6s2[sorusay], lise10bolum6c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm6s3")){
        soru1 = new Soru(lise10bolum6s3[sorusay], lise10bolum6c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm6s4")){
        soru1 = new Soru(lise10bolum6s4[sorusay], lise10bolum6c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm6s5")){
        soru1 = new Soru(lise10bolum6s5[sorusay], lise10bolum6c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm6s6")){
        soru1 = new Soru(lise10bolum6s1[sorusay], lise10bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm7s1")){
        soru1 = new Soru(lise10bolum7s1[sorusay], lise10bolum7c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm7s2")){
        soru1 = new Soru(lise10bolum7s2[sorusay], lise10bolum7c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm7s3")){
        soru1 = new Soru(lise10bolum7s3[sorusay], lise10bolum7c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm7s4")){
        soru1 = new Soru(lise10bolum7s4[sorusay], lise10bolum7c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm7s5")){
        soru1 = new Soru(lise10bolum7s5[sorusay], lise10bolum7c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm7s6")){
        soru1 = new Soru(lise10bolum7s6[sorusay], lise10bolum7c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm8s1")){
        soru1 = new Soru(lise10bolum8s1[sorusay], lise10bolum8c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm8s2")){
        soru1 = new Soru(lise10bolum8s2[sorusay], lise10bolum8c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm8s3")){
        soru1 = new Soru(lise10bolum8s3[sorusay], lise10bolum8c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm8s4")){
        soru1 = new Soru(lise10bolum8s4[sorusay], lise10bolum8c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm8s5")){
        soru1 = new Soru(lise10bolum8s5[sorusay], lise10bolum8c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm8s6")){
        soru1 = new Soru(lise10bolum8s6[sorusay], lise10bolum8c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm9s1")){
        soru1 = new Soru(lise10bolum9s1[sorusay], lise10bolum9c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm9s2")){
        soru1 = new Soru(lise10bolum9s2[sorusay], lise10bolum9c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm9s3")){
        soru1 = new Soru(lise10bolum9s3[sorusay], lise10bolum9c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm9s4")){
        soru1 = new Soru(lise10bolum9s4[sorusay], lise10bolum9c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        } else if (Objects.equals(sev, "10.SINIFbölüm9s5")){
        soru1 = new Soru(lise10bolum9s5[sorusay],lise10bolum9c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm9s6")){
        soru1 = new Soru(lise10bolum9s6[sorusay], lise10bolum9c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm10s1")){
        soru1 = new Soru(lise10bolum10s1[sorusay], lise10bolum10c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm10s2")){
        soru1 = new Soru(lise10bolum10s2[sorusay],lise10bolum10c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm10s3")){
        soru1 = new Soru(lise10bolum10s3[sorusay], lise10bolum10c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm10s4")){
        soru1 = new Soru(lise10bolum10s4[sorusay], lise10bolum10c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm10s5")){
        soru1 = new Soru(lise10bolum10s5[sorusay], lise10bolum10c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "10.SINIFbölüm10s6")){
        soru1 = new Soru(lise10bolum10s6[sorusay], lise10bolum10c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }




        // 11. SINIF





        else if (Objects.equals(sev, "11.SINIFbölüm1s1")){
        soru1 = new Soru(lise11bolum1s1[sorusay], lise11bolum1c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm1s2")){
        soru1 = new Soru(lise11bolum1s2[sorusay], lise11bolum1c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm2s1")){
        soru1 = new Soru(lise11bolum2s1[sorusay], lise11bolum2c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm2s2")){
        soru1 = new Soru(lise11bolum2s2[sorusay], lise11bolum2c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm2s3")){
        soru1 = new Soru(lise11bolum2s3[sorusay], lise11bolum2c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm2s4")){
        soru1 = new Soru(lise11bolum2s4[sorusay], lise11bolum2c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm2s5")){
        soru1 = new Soru(lise11bolum2s5[sorusay], lise11bolum2c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm2s6")){
        soru1 = new Soru(lise11bolum2s6[sorusay],lise11bolum2c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm3s1")){
        soru1 = new Soru(lise11bolum3s1[sorusay], lise11bolum3c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm3s2")){
        soru1 = new Soru(lise11bolum3s2[sorusay], lise11bolum3c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm3s3")){
        soru1 = new Soru(lise11bolum3s3[sorusay], lise11bolum3c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm3s4")){
        soru1 = new Soru(lise11bolum3s4[sorusay], lise11bolum3c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm3s5")){
        soru1 = new Soru(lise11bolum3s5[sorusay], lise11bolum3c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm3s6")){
        soru1 = new Soru(lise11bolum3s6[sorusay], lise11bolum3c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm4s1")){
        soru1 = new Soru(lise11bolum4s1[sorusay], lise11bolum4c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm4s2")){
        soru1 = new Soru(lise11bolum4s2[sorusay],lise11bolum4c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm4s3")){
        soru1 = new Soru(lise11bolum4s3[sorusay],lise11bolum4c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm4s4")){
        soru1 = new Soru(lise11bolum4s4[sorusay], lise11bolum4c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm4s5")){
        soru1 = new Soru(lise11bolum4s5[sorusay], lise11bolum4c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm4s6")){
        soru1 = new Soru(lise11bolum4s6[sorusay], lise11bolum4c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm5s1")){
        soru1 = new Soru(lise11bolum5s1[sorusay], lise11bolum5c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm5s2")){
        soru1 = new Soru(lise11bolum5s2[sorusay], lise11bolum5c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm5s3")){
        soru1 = new Soru(lise11bolum5s3[sorusay],lise11bolum5c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm5s4")){
        soru1 = new Soru(lise11bolum5s4[sorusay], lise11bolum5c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm5s5")){
        soru1 = new Soru(lise11bolum5s5[sorusay], lise11bolum5c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm5s6")){
        soru1 = new Soru(lise11bolum5s6[sorusay], lise11bolum5c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm6s1")){
        soru1 = new Soru(lise11bolum6s1[sorusay], lise11bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm6s2")){
        soru1 = new Soru(lise11bolum6s2[sorusay], lise11bolum6c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm6s3")){
        soru1 = new Soru(lise11bolum6s3[sorusay], lise11bolum6c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm6s4")){
        soru1 = new Soru(lise11bolum6s4[sorusay], lise11bolum6c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm6s5")){
        soru1 = new Soru(lise11bolum6s5[sorusay], lise11bolum6c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm6s6")){
        soru1 = new Soru(lise11bolum6s1[sorusay], lise11bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm7s1")){
        soru1 = new Soru(lise11bolum7s1[sorusay], lise11bolum7c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm7s2")){
        soru1 = new Soru(lise11bolum7s2[sorusay], lise11bolum7c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm7s3")){
        soru1 = new Soru(lise11bolum7s3[sorusay], lise11bolum7c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm7s4")){
        soru1 = new Soru(lise11bolum7s4[sorusay], lise11bolum7c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm7s5")){
        soru1 = new Soru(lise11bolum7s5[sorusay], lise11bolum7c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm7s6")){
        soru1 = new Soru(lise11bolum7s6[sorusay], lise11bolum7c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm8s1")){
        soru1 = new Soru(lise11bolum8s1[sorusay], lise11bolum8c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm8s2")){
        soru1 = new Soru(lise11bolum8s2[sorusay], lise11bolum8c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm8s3")){
        soru1 = new Soru(lise11bolum8s3[sorusay], lise11bolum8c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm8s4")){
        soru1 = new Soru(lise11bolum8s4[sorusay], lise11bolum8c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm8s5")){
        soru1 = new Soru(lise11bolum8s5[sorusay], lise11bolum8c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm8s6")){
        soru1 = new Soru(lise11bolum8s6[sorusay], lise11bolum8c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm9s1")){
        soru1 = new Soru(lise11bolum9s1[sorusay], lise11bolum9c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm9s2")){
        soru1 = new Soru(lise11bolum9s2[sorusay], lise11bolum9c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm9s3")){
        soru1 = new Soru(lise11bolum9s3[sorusay], lise11bolum9c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm9s4")){
        soru1 = new Soru(lise11bolum9s4[sorusay], lise11bolum9c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        } else if (Objects.equals(sev, "11.SINIFbölüm9s5")){
        soru1 = new Soru(lise11bolum9s5[sorusay],lise11bolum9c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm9s6")){
        soru1 = new Soru(lise11bolum9s6[sorusay], lise11bolum9c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm10s1")){
        soru1 = new Soru(lise11bolum10s1[sorusay], lise11bolum10c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm10s2")){
        soru1 = new Soru(lise11bolum10s2[sorusay],lise11bolum10c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm10s3")){
        soru1 = new Soru(lise11bolum10s3[sorusay], lise11bolum10c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm10s4")){
        soru1 = new Soru(lise11bolum10s4[sorusay], lise11bolum10c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm10s5")){
        soru1 = new Soru(lise11bolum10s5[sorusay], lise11bolum10c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "11.SINIFbölüm10s6")){
        soru1 = new Soru(lise11bolum10s6[sorusay], lise11bolum10c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }


        // 12 . SINIF


        else if (Objects.equals(sev, "12.SINIFbölüm1s1")){
        soru1 = new Soru(lise12bolum1s1[sorusay], lise12bolum1c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm1s2")){
        soru1 = new Soru(lise12bolum1s2[sorusay], lise12bolum1c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm1s3")){
        soru1 = new Soru(lise12bolum1s3[sorusay], lise12bolum1c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm1s4")){
        soru1 = new Soru(lise12bolum1s4[sorusay], lise12bolum1c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm1s5")){
        soru1 = new Soru(lise12bolum1s5[sorusay], lise12bolum1c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm1s6")){
        soru1 = new Soru(lise12bolum1s6[sorusay], lise12bolum1c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm2s1")){
        soru1 = new Soru(lise12bolum2s1[sorusay], lise12bolum2c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm2s2")){
        soru1 = new Soru(lise12bolum2s2[sorusay], lise12bolum2c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm2s3")){
        soru1 = new Soru(lise12bolum2s3[sorusay], lise12bolum2c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm2s4")){
        soru1 = new Soru(lise12bolum2s4[sorusay], lise12bolum2c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm2s5")){
        soru1 = new Soru(lise12bolum2s5[sorusay], lise12bolum2c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm2s6")){
        soru1 = new Soru(lise12bolum2s6[sorusay],lise12bolum2c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm3s1")){
        soru1 = new Soru(lise12bolum3s1[sorusay], lise12bolum3c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm3s2")){
        soru1 = new Soru(lise12bolum3s2[sorusay], lise12bolum3c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm3s3")){
        soru1 = new Soru(lise12bolum3s3[sorusay], lise12bolum3c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm3s4")){
        soru1 = new Soru(lise12bolum3s4[sorusay], lise12bolum3c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm3s5")){
        soru1 = new Soru(lise12bolum3s5[sorusay], lise12bolum3c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm3s6")){
        soru1 = new Soru(lise12bolum3s6[sorusay], lise12bolum3c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm4s1")){
        soru1 = new Soru(lise12bolum4s1[sorusay], lise12bolum4c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm4s2")){
        soru1 = new Soru(lise12bolum4s2[sorusay],lise12bolum4c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm4s3")){
        soru1 = new Soru(lise12bolum4s3[sorusay],lise12bolum4c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm4s4")){
        soru1 = new Soru(lise10bolum4s4[sorusay], lise10bolum4c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm4s5")){
        soru1 = new Soru(lise12bolum4s5[sorusay], lise12bolum4c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm4s6")){
        soru1 = new Soru(lise12bolum4s6[sorusay], lise12bolum4c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm5s1")){
        soru1 = new Soru(lise12bolum5s1[sorusay], lise12bolum5c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm5s2")){
        soru1 = new Soru(lise12bolum5s2[sorusay], lise12bolum5c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm5s3")){
        soru1 = new Soru(lise12bolum5s3[sorusay],lise12bolum5c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm5s4")){
        soru1 = new Soru(lise12bolum5s4[sorusay], lise12bolum5c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm5s5")){
        soru1 = new Soru(lise12bolum5s5[sorusay], lise12bolum5c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm5s6")){
        soru1 = new Soru(lise12bolum5s6[sorusay], lise12bolum5c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm6s1")){
        soru1 = new Soru(lise12bolum6s1[sorusay], lise12bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm6s2")){
        soru1 = new Soru(lise12bolum6s2[sorusay], lise12bolum6c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm6s3")){
        soru1 = new Soru(lise12bolum6s3[sorusay], lise12bolum6c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm6s4")){
        soru1 = new Soru(lise12bolum6s4[sorusay], lise12bolum6c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm6s5")){
        soru1 = new Soru(lise12bolum6s5[sorusay], lise12bolum6c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm6s6")){
        soru1 = new Soru(lise12bolum6s1[sorusay], lise12bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm7s1")){
        soru1 = new Soru(lise12bolum7s1[sorusay], lise12bolum7c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm7s2")){
        soru1 = new Soru(lise12bolum7s2[sorusay], lise12bolum7c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm7s3")){
        soru1 = new Soru(lise12bolum7s3[sorusay], lise12bolum7c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm7s4")){
        soru1 = new Soru(lise12bolum7s4[sorusay], lise12bolum7c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm7s5")){
        soru1 = new Soru(lise12bolum7s5[sorusay], lise12bolum7c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm7s6")){
        soru1 = new Soru(lise12bolum7s6[sorusay], lise12bolum7c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm8s1")){
        soru1 = new Soru(lise12bolum8s1[sorusay], lise12bolum8c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm8s2")){
        soru1 = new Soru(lise12bolum8s2[sorusay], lise12bolum8c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm8s3")){
        soru1 = new Soru(lise12bolum8s3[sorusay], lise12bolum8c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm8s4")){
        soru1 = new Soru(lise12bolum8s4[sorusay], lise12bolum8c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm8s5")){
        soru1 = new Soru(lise12bolum8s5[sorusay], lise12bolum8c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm8s6")){
        soru1 = new Soru(lise12bolum8s6[sorusay], lise12bolum8c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm9s1")){
        soru1 = new Soru(lise12bolum9s1[sorusay], lise12bolum9c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm9s2")){
        soru1 = new Soru(lise12bolum9s2[sorusay], lise12bolum9c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm9s3")){
        soru1 = new Soru(lise12bolum9s3[sorusay], lise12bolum9c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm9s4")){
        soru1 = new Soru(lise12bolum9s4[sorusay], lise12bolum9c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        } else if (Objects.equals(sev, "12.SINIFbölüm9s5")){
        soru1 = new Soru(lise12bolum9s5[sorusay],lise12bolum9c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm9s6")){
        soru1 = new Soru(lise12bolum9s6[sorusay], lise12bolum9c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm10s1")){
        soru1 = new Soru(lise12bolum10s1[sorusay], lise12bolum10c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm10s2")){
        soru1 = new Soru(lise12bolum10s2[sorusay],lise12bolum10c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm10s3")){
        soru1 = new Soru(lise12bolum10s3[sorusay], lise12bolum10c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm10s4")){
        soru1 = new Soru(lise12bolum10s4[sorusay], lise12bolum10c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm10s5")){
        soru1 = new Soru(lise12bolum10s5[sorusay], lise12bolum10c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "12.SINIFbölüm10s6")){
        soru1 = new Soru(lise12bolum10s6[sorusay], lise12bolum10c6[sorusay], yanlislar3, yanlislar4);
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
