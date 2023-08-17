package com.mert.kolayingilizce.a1a2;

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

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class kelime extends AppCompatActivity {

    // Data A1

    String[] a1bolum1s1 = {"magazine", "on foot", "trust", "solve", "see", "corn", "pillow", "certificate", "firefighter", "in time"};
    String[] a1bolum1s2 = {"shop", "lorry", "pity", "east", "case", "qualified", "outdoor", "exchange rate", "run out", "cottage"};
    String[] a1bolum1s3 = {"street", "spy", "thunder", "spicy", "relaxed", "contents", "palace", "fog", "please", "kitten"};
    String[] a1bolum1s4 = {"hit", "night", "publish", "partner", "defence", "change", "fantastic", "cent", "hill", "credit"};
    String[] a1bolum1s5 = {"effort", "worth", "reporter", "cross out", "spot", "put up", "second", "tax", "racket", "peace"};
    String[] a1bolum1s6 = {"nature", "house", "reasonable", "cookie", "confusing", "fully", "cooking", "another", "blow", "moustache"};
    String[] a1bolum2s1 = {"rubbish", "climate", "examiner", "hall", "twice", "boot", "population", "pop", "variety", "cheers"};
    String[] a1bolum2s2 = {"climbing", "cabinet", "proud", "recent", "nice", "warn", "speed", "call", "mystery", "environmental"};
    String[] a1bolum2s3 = {"travel", "cave", "reasonably", "birthday", "put off", "prefer", "maths", "request", "cool", "wonder"};
    String[] a1bolum2s4 = {"player", "scooter", "dive", "instruction", "lend", "disadvantage", "delighted", "dessert", "down", " boarding pass"};
    String[] a1bolum2s5 = {"happy", "terrible", "discuss", "windy", "shiny", "future", "weather", "approve", "roast", "cleaner"};
    String[] a1bolum2s6 = {"supper", "hers", "occupation", "teach", "bring up", "quite", "fruit", "upload", "high", "member"};
    String[] a1bolum3s1 = {"ballet", "attach", "brief", "understand", "nasty", "have to", "circus", "pedestrian", "hopeful", "permanent"};
    String[] a1bolum3s2 = {"chilli", "latest", "dusty", "staff", "musician", "fry", "area", "shout", "presentation", "accent"};
    String[] a1bolum3s3 = {"course", "relative", "safe", "bread", "kill", "boat", "tube", "locker", "instructor", "ache"};
    String[] a1bolum3s4 = {"bell", "likely", "messy", "possible", "no", "design", "row", "translation", "hut", "get off"};
    String[] a1bolum3s5 = {"juice", "carefully", "amazed", "dentist", "find out", "next", "lesson", "magnificent", "floor", "degree"};
    String[] a1bolum3s6 = {"pharmacy", "people", "congratulations", "myself", "close", "realize", "figure", "brother", "leaf", "tomorrow"};
    String[] a1bolum4s1 = {"cupboard", "similar", "motorbike", "study", "knowledge", "block", "teenager", "hire", "sleep", "quiet"};
    String[] a1bolum4s2 = {"capital", "wing", "yet", "week", "turn down", "leader", "square", "vegetable", "flu", "apologise"};
    String[] a1bolum4s3 = {"grilled", "since", "ring up", "false", "marriage", "frozen", "national", "ground", "also", "hand-held"};
    String[] a1bolum4s4 = {"blackboard", "runner", "none", "bad", "take up", "candy", "life", "own", "tree", "ocean"};
    String[] a1bolum4s5 = {"hairdresser", "grandmother", "boring", "homework", "casual", "star", "grape", "calculator", "duvet", "drawer"};
    String[] a1bolum4s6 = {"on purpose", "sour", "disappointed", "argue", "journalist", "mate", "car park", "angry", "clock", "probably"};
    String[] a1bolum5s1 = {"efficient", "donkey", "customer", "currency", "ambulance", "stress", "age", "dirt", "bride", "chemistry"};
    String[] a1bolum5s2 = {"spectacular", "hand", "cash", "soul", "healthy", "suprising", "breath", "gift", "colourful", "spelling"};
    String[] a1bolum5s3 = {"law", "fried", "tense", "sightseeing", "take away", "tiny", "frame", "biscuit", "make sure", "handkerchief"};
    String[] a1bolum5s4 = {"clear", "cancel", "become", "favour", "gallery", "wheelchair", "fond of", "stadium", "pin", "confused"};
    String[] a1bolum5s5 = {"collar", "bag", "transport", "skate", "walk", "by mistake", "knee", "convince", "contain", "side"};
    String[] a1bolum5s6 = {"stripe", "crazy", "pile", "meat", "on holiday", "audience", "annoy", "insist", "slip", "familiar"};
    String[] a1bolum6s1 = {"detail", "crowd", "deep", "blouse", "lottery", "wind", "housewife", "inquiry", "qualification", "farming"};
    String[] a1bolum6s2 = {"cover", "newspaper", "lighter", "extra", "you", "direction", "dot", "below", "tent", "push"};
    String[] a1bolum6s3 = {"admission", "town", "branch", "ahead of", "typical", "sculpture", "slice", "grocery store", "split up", "heating"};
    String[] a1bolum6s4 = {"impossible", "baby", "unemployed", "diet", "deal", "mail", "photo", "at all", "around", "produce"};
    String[] a1bolum6s5 = {"software", "stay", "sew", "forward", "expert", "pocket money", "present", "face", "dark", "knife"};
    String[] a1bolum6s6 = {"situation", "roll", "disappoint", "disease", "maybe", "in advance", "view", "mend", "headline", "rule"};
    String[] a1bolum7s1 = {"sort", "ship", "turn on", "regret", "height", "can", "scientific", "underline", "cruel", "disappear"};
    String[] a1bolum7s2 = {"stay behind", "develop", "switch", "rise", "mark", "unhappy", "mechanic", "themselves", "touch", "enough"};
    String[] a1bolum7s3 = {"cultural", "lonely", "any", "smart", "sore", "head", "promote", "historical", "guitarist", "whale"};
    String[] a1bolum7s4 = {"background", "field", "often", "rock", "fill up", "chest of drawers", "social", "cure", "hard", "ready"};
    String[] a1bolum7s5 = {"however", "ironing", "double", "worse", "education", "reward", "captain", "undress", "carry", "still"};
    String[] a1bolum7s6 = {"barbecue", "back", "land", "tin", "art", "beginner", "care", "gap", "ring back", "burning"};
    String[] a1bolum8s1 = {"destroy", "point", "childhood", "spoon", "burn", "matter", "furniture", "heroine", "nobody", "get on"};
    String[] a1bolum8s2 = {"train", "conference", "foggy", "generation", "home", "between", "busy", "school", "petrol", "wish"};
    String[] a1bolum8s3 = {"handbag", "earn", "sell", "percent", "quantity", "till", "ankle", "writer", "ear", "garlic"};
    String[] a1bolum8s4 = {"mug", "wise", "queue", "fall", "entrance", "unlikely", "far", "unit", "sight", "unless"};
    String[] a1bolum8s5 = {"son", "comb", "comedy", "digital camera", "urgently", "wake up", "signature", "set up", "certainly", "appearance"};
    String[] a1bolum8s6 = {"post", "connect", "locate", "divide", "foreign", "recording", "this", "save", "wool", "president"};
    String[] a1bolum9s1 = {"fan", "exciting", "come", "thunderstorm", "drive", "user", "imagination", "pants", "shame", "feeling"};
    String[] a1bolum9s2 = {"favourite", "liquid", "bite", "trend", "pregnant", "grey", "hold", "sea", "police officer", "store"};
    String[] a1bolum9s3 = {"invent", "complete", "wedding", "smoke", "meeting", "disappointment", "incredible", "plant", "title", "my"};
    String[] a1bolum9s4 = {"careful", "island", "tear", "teaching", "emergency", "game", "cross", "grandfather", "end", "experience"};
    String[] a1bolum9s5 = {"lock", "awful", "wrong", "giraffe", "or", "total", "communicate", "flavour", "entertain", "late"};//521
    String[] a1bolum9s6 = {"castle", "couple", "opposite", "keen", "photography", "flood", "minimum", "service", "colleague", "beneath"};
    String[] a1bolum10s1 = {"atmosphere", "full-time", "listen", "hour", "out of", "continent", "lost", "dangerous", "imagine", "catch"};
    String[] a1bolum10s2 = {"at once", "granddaughter", "appear", "designer", "actress", "require", "frighten", "on business", "sock", "kiss"};
    String[] a1bolum10s3 = {"patient", "male", "painful", "fill", "put away", "health", "ice cream", "princess", "believe", "refreshments"};
    String[] a1bolum10s4 = {"criminal", "soft", "wrap", "sunglasses", "nightclub", "canal", "party", "million", "lovely", "guest"};
    String[] a1bolum10s5 = {"paragraph", "lamp", "describe", "composition", "assistant", "particular", "improvement", "depth", "central heating", "gate"};
    String[] a1bolum10s6 = {"laboratory", "interested", "active", "apology", "careless", "multiply", "pleasure", "somewhere", "tiger", "ill"};

    // Data A1 Cevaplar

    String[] a1bolum1c1 = {"dergi", "yaya, yürüyerek", "güvenmek", "çözmek", "görmek", "mısır", "yastık", "sertifika", "itfaiyeci", "zamanında"};
    String[] a1bolum1c2 = {"mağaza", "kamyon","acımak", "doğu", "dava, durum", "kalifiye", "açık", "döviz kuru", "dışarı koşmak", "kır evi"};
    String[] a1bolum1c3 = {"sokak", "casus", "gök gürültüsü", "baharatlı", "rahatlamış", "içindekiler", "saray", "sis", "lütfen", "kedi yavrusu"};
    String[] a1bolum1c4 = {"vurmak", "gece", "yayınlamak", "ortak", "savunma", "değişiklik", "fantastik", "sent", "tepe", "kredi"};
    String[] a1bolum1c5 = {"çaba", "değer", "muhabir", "üzerini çizmek", "nokta; tespit etmek", "inşa etmek, misafir etmek", "ikinci, saniye", "vergi", "raket", "barış"};
    String[] a1bolum1c6 = {"doğa", "ev", "makul", "kurabiye", "kafa karıştırıcı", "tam olarak", "yemek pişirme", "başka bir", "darbe, vurma, esmek", "bıyık"};
    String[] a1bolum2c1 = {"çöp", "iklim", "sınav yapan", "salon", "iki kere", "çizme, bagaj", "nüfus", "pop", "çeşitlilik", "şerefe"};
    String[] a1bolum2c2 = {"tırmanma", "dolap", "gururlu", "yakın zaman", "güzel", "uyarmak", "hız", "çağırmak, aramak", "gizem", "çevresel"};
    String[] a1bolum2c3 = {"seyahat etmek", "mağara", "makul bir şekilde", "doğum günü", "ertelemek", "tercih etmek", "matematik", "rica, rica etmek", "serin", "merak etmek, harika"};
    String[] a1bolum2c4 = {"oyuncu", "mobilet", "dalmak", "talimat", "ödünç vermek", "dezavantaj", "mutlu", "tatlı", "aşağı", "biniş kartı"};
    String[] a1bolum2c5 = {"mutlu", "korkunç", "tartışmak", "rüzgarlı", "parlak", "gelecek", "hava", "onaylamak", "kızartmak", "temizleyici"};
    String[] a1bolum2c6 = {"akşam yemeği", "onunki", "işgal, meslek", "öğretmek", "yetiştirmek", "oldukça", "Meyve", "yüklemek", "yüksek", "üye"};
    String[] a1bolum3c1 = {"bale", "iliştirmek", "kısa", "anlamak", "nahoş", "zorunda olmak", "sirk", "yaya", "umutlu", "kalıcı"};
    String[] a1bolum3c2 = {"kırmızı biber", "son", "tozlu", "personel", "müzisyen", "kızartmak", "alan", "bağırmak", "sunum", "aksan"};
    String[] a1bolum3c3 = {"kurs", "göreceli", "güvenli, kasa", "ekmek", "öldürmek", "tekne", "tüp", "kilitli dolap", "eğitmen", "ağrı"};
    String[] a1bolum3c4 = {"çan", "olası", "dağınık", "mümkün", "hayır", "tasarım", "sıra, kürek çekmek", "çeviri", "kulübe", "inmek"};
    String[] a1bolum3c5 = {"meyve suyu", "dikkatlice", "şaşırmış", "dişçi", "öğrenmek", "sonraki", "ders", "muhteşem", "zemin", "derece"};
    String[] a1bolum3c6 = {"eczane", "insanlar", "tebrikler!", "kendim", "yakın, kapatmak", "farketmek", "şekil, rakam", "kardeş", "yaprak", "yarın"};
    String[] a1bolum4c1 = {"dolap", "benzer", "motosiklet", "çalışmak", "bilgi", "blok", "genç (13-19)", "kiralamak, işe almak", "uyku", "sessiz"};
    String[] a1bolum4c2 = {"sermaye", "kanat", "henüz, ama", "hafta", "kısmak", "lider", "kare", "sebze", "grip", "özür dilemek"};
    String[] a1bolum4c3 = {"ızgarada pişmiş", "…den beri, dığı için", "telefon etmek", "yanlış,", "evlilik", "dondurulmuş", "ulusal", "zemin", "ayrıca", "elde tutulan"};
    String[] a1bolum4c4 = {"yazı tahtası", "koşucu", "hiçbiri", "kötü", "almak (zaman, yer)", "şeker", "hayat", "sahip olmak", "ağaç", "okyanus"};
    String[] a1bolum4c5 = {"kuaför", "büyükanne", "sıkıcı", "ev ödevi", "gündelik", "yıldız", "üzüm", "hesap makinesi", "Yorgan", "çekmece"};
    String[] a1bolum4c6 = {"bilerek", "hayal kırıklığına uğramış", "tartışmak", "gazeteci", "arkadaş", "otopark", "kızgın", "saat", "muhtemelen"};
    String[] a1bolum5c1 = {"verimli", "eşek", "müşteri", "para birimi", "ambulans", "gerilim, vurgulamak", "yaş", "kir", "gelin", "kimya"};
    String[] a1bolum5c2 = {"muhteşem", "El", "nakit", "ruh", "sağlıklı", "şaşırtıcı", "nefes", "hediye", "renkli", "yazım"};
    String[] a1bolum5c3 = {"yasa", "Kızarmış", "gergin", "gezi", "götürmek", "küçücük", "çerçeve", "bisküvi", "emin olmak", "mendil"};
    String[] a1bolum5c4 = {"açık", "iptal etmek", "olmak", "iyilik", "galeri", "tekerlekli sandalye", "düşkün", "stadyum", "iğne, iğnelemek", "şaşkın"};
    String[] a1bolum5c5 = {"yaka", "çanta", "taşıma", "paten", "yürümek", "yanlışlıkla", "diz", "ikna etmek", "içermek", "yan"};
    String[] a1bolum5c6 = {"şerit", "çılgın", "kazık", "et", "tatilde", "seyirci", "kızdırmak", "ısrar etmek", "kaymak", "tanıdık"};
    String[] a1bolum6c1 = {"detay", "kalabalık", "derin", "bluz", "piyango", "rüzgar", "ev hanımı", "soruşturma", "nitelik", "tarım"};
    String[] a1bolum6c2 = {"kapak", "gazete", "çakmak", "ekstra", "sen", "yön", "nokta", "aşağıda", "çadır", "itmek"};
    String[] a1bolum6c3 = {"kabul etme, giriş", "kasaba", "şube", "…ın önünde", "tipik", "heykel", "dilim", "Bakkal", "ayrılmak, ayırmak", "ısıtma"};
    String[] a1bolum6c4 = {"imkansız", "bebek", "işsiz", "diyet, beslenme düzeni", "anlaşma", "posta", "fotoğraf", "hiç", "etrafında", "üretmek"};
    String[] a1bolum6c5 = {"yazılım", "kalmak", "dikmek", "ileri", "uzman", "cep harçlığı", "mevcut, sunmak, hediye", "yüz", "karanlık", "bıçak"};
    String[] a1bolum6c6 = {"durum", "yuvarlanmak", "hayal kırıklığına uğratmak", "hastalık", "belki", "önceden", "görünüm", "tamir", "başlık, manşet", "Kural"};
    String[] a1bolum7c1 = {"çeşit", "gemi", "açmak (cihaz)", "pişman olmak", "yükseklik", "teneke kutu, …ebilmek", "bilimsel", "altını çizmek", "zalim", "gözden kaybolmak"};
    String[] a1bolum7c2 = {"arkada kalmak", "geliştirmek", "anahtar", "yükselmek, doğmak", "işaret", "mutsuz", "tamirci", "kendileri", "dokunmak", "yeterli"};
    String[] a1bolum7c3 = {"kültürel", "yalnız", "herhangi", "akıllı", "ağrı", "kafa", "desteklemek", "tarihi", "gitarist", "balina"};
    String[] a1bolum7c4 = {"arka plân", "alan", "sık sık", "kaya", "doldurmak", "çekmeceli dolap", "sosyal", "tedavi etmek", "sert, zor", "hazır"};
    String[] a1bolum7c5 = {"ancak", "ütüleme", "çift", "daha kötü", "eğitim", "Ödül", "kaptan", "soyunmak", "taşımak", "hala, yine de, durgun"};
    String[] a1bolum7c6 = {"barbekü", "geri", "arazi", "kalay", "sanat", "acemi", "bakım", "boşluk", "geri aramak", "yanan"};
    String[] a1bolum8c1 = {"yıkmak", "nokta", "çocukluk", "kaşık", "yanmak", "madde, mesele", "mobilya", "kahraman (kadın), eroin", "kimse", "binmek"};
    String[] a1bolum8c2 = {"tren, antrenman yapmak", "konferans", "sisli", "nesil", "ev", "arasında", "meşgul", "okul", "benzin", "dilek, dilemek"};
    String[] a1bolum8c3 = {"çanta", "kazanmak", "satmak", "yüzde", "miktar", "…e kadar", "ayak bileği", "yazar", "kulak", "sarımsak"};
    String[] a1bolum8c4 = {"kupa", "bilge", "Kuyruk", "düşmek", "Giriş", "olası olmayan", "uzak", "birim", "görme, görüş", "…medikçe/mezse"};
    String[] a1bolum8c5 = {"oğul", "tarak", "komedi", "dijital kamera", "acilen", "uyanmak, uyandırmak", "imza", "kurmak", "kesinlikle", "görünüm"};
    String[] a1bolum8c6 = {"posta", "bağlamak", "yerleştirmek", "bölmek", "yabancı", "kayıt", "bu", "kurtarmak, kaydetmek", "yün", "başkan"};
    String[] a1bolum9c1 = {"taraftar", "heyecan verici", "gelmek", "sağanak", "sürmek", "kullanıcı", "hayal", "pantolon", "ayıp", "his"};
    String[] a1bolum9c2 = {"favori", "sıvı", "ısırmak", "eğilim", "hamile", "gri", "tutmak", "deniz", "polis memuru", "mağaza, depo"};
    String[] a1bolum9c3 = {"icat etmek", "tamamlamak, tam", "düğün", "duman", "toplantı", "hayal kırıklığı", "inanılmaz", "bitki", "başlık, ünvan", "benim"};
    String[] a1bolum9c4 = {"dikkatli", "ada", "gözyaşı, yırtmak", "öğretim", "acil durum", "oyun", "çapraz", "dede", "son", "deneyim"};
    String[] a1bolum9c5 = {"kilitlemek", "korkunç", "yanlış,", "zürafa", "veya", "toplam", "iletişim kurmak", "lezzet", "eğlendirmek", "geç"};
    String[] a1bolum9c6 = {"kale", "çift", "karşı, zıt", "keskin", "fotoğrafçılık", "sel", "asgari", "hizmet", "meslektaş", "altında"};
    String[] a1bolum10c1 = {"atmosfer", "tam zamanlı", "dinlemek", "saat", "dışında", "kıta", "kayıp", "tehlikeli", "düşünmek, hayal etmek", "yakalamak"};
    String[] a1bolum10c2 = {"hemen", "torun", "görünmek", "tasarımcı", "aktris", "gerektirmek", "korkutmak", "iş için", "çorap", "öpmek"};
    String[] a1bolum10c3 = {"hasta", "erkek", "acı verici", "doldurmak", "yerine koymak", "sağlık", "dondurma", "prenses", "inanmak", "ikramlar"};
    String[] a1bolum10c4 = {"suçlu", "yumuşak", "sarmak", "güneş gözlüğü", "gece kulübü", "kanal", "parti", "milyon", "güzel", "konuk"};
    String[] a1bolum10c5 = {"paragraf", "lamba", "tanımlamak", "kompozisyon", "asistan", "özel", "gelişme", "derinlik", "merkezi ısıtma", "kapı"};
    String[] a1bolum10c6 = {"laboratuvar", "ilgili", "aktif", "özür", "dikkatsiz", "çarpmak", "zevk", "bir yer", "kaplan", "hasta"};


    // Data A2


    String[] a2bolum1s1 = {"recycle", "foreigner", "clean", "kit", "toe", "exactly", "benefit", "fun", "west", "blood"};
    String[] a2bolum1s2 = {"motorway", "rail", "despite", "competitor", "drop", "bookstore", "forgive", "relaxation", "draw", "complicated"};
    String[] a2bolum1s3 = {"shape", "deliver", "chin", "department", "dig", "get", "tasty", "architecture", "avoid", "discover"};
    String[] a2bolum1s4 = {"easygoing", "diploma", "pleasant", "remain", "mouth", "bookshop", "airline", "print", "possibility", "adventure"};
    String[] a2bolum1s5 = {"at the same time", "dog", "unusual", "soon", "equipment", "make", "uninterested", "examination/exam", "market", "pretty"};
    String[] a2bolum1s6 = {"quiz", "disturb", "disgusting", "button", "gum", "activity", "intend", "us", "challenging", "garage"};
    String[] a2bolum2s1 = {"old-fashioned", "excitement", "beach", "usual", "under", "go on", "battery", "throw", "reply", "hand out"};
    String[] a2bolum2s2 = {"fair", "information", "give", "put out", "peel", "enjoy", "farm", "nightmare", "curtain", "bit"};
    String[] a2bolum2s3 = {"fare", "fat", "headteacher", "cold", "announce", "recycling", "yesterday", "about", "experienced", "rescue"};
    String[] a2bolum2s4 = {"afraid", "pause", "reserve", "actor", "feed", "large", "plenty", "location", "plan", "apart from"};
    String[] a2bolum2s5 = {"slow", "remove", "behind", "contest", "helmet", "taste", "valuable", "housework", "monkey", "deposit"};
    String[] a2bolum2s6 = {"herself", "previous", "intelligent", "never", "hand in", "danger", "customs", "over", "injure", "as"};
    String[] a2bolum3s1 = {"building", "silly", "situated", "classroom", "kid", "snow", "political", "keep", "ago", "hospital"};
    String[] a2bolum3s2 = {"upstairs", "factory", "subtract", "ant", "terrified", "frog", "courage", "switch on/off", "select", "shadow"};
    String[] a2bolum3s3 = {"access", "door", "beat", "both", "build", "escape", "stall", "beauty", "room", "file"};
    String[] a2bolum3s4 = {"jam", "phone", "issue", "bicycle", "cute", "totally", "snack", "trick", "shut", "short"};
    String[] a2bolum3s5 = {"steep", "bank", "independent", "admit", "engineer", "near", "track", "him", "underneath", "lightning"};
    String[] a2bolum3s6 = {"instead", "else", "money", "rabbit", "instance", "human", "balcony", "temperature", "temporary", "translate"};
    String[] a2bolum4s1 = {"world", "card", "decrease", "hate", "smell", "baseball", "suffer from", "autumn", "by hand", "shocking"};
    String[] a2bolum4s2 = {"direct", "delivery", "made of/from/out of", "no one", "together", "forever", "shy", "pack", "clever", "rice"};
    String[] a2bolum4s3 = {"medium", "manage", "nationality", "copy", "toast", "pale", "desk", "worst", "overnight", "fiction"};
    String[] a2bolum4s4 = {"weekend", "mess", "company", "leave", "central", "relation", "artist", "unpleasant", "smoking", "left"};
    String[] a2bolum4s5 = {"ruler", "pool", "on board", "wild", "parrot", "accommodation", "sudden", "show", "employee", "campsite"};
    String[] a2bolum4s6 = {"proper", "next to", "due to", "explanation", "anxious", "wooden", "possibly", "invite", "first", "dish"};
    String[] a2bolum5s1 = {"topic", "bug", "seat", "light", "less", "literature", "perform", "strict", "top", "hunt"};
    String[] a2bolum5s2 = {"pencil case", "wonderful", "punish", "whenever", "alive", "tidy up", "promise", "cow", "twin", "narrow"};
    String[] a2bolum5s3 = {"offer", "behave", "signal", "sunset", "scream", "pea", "I", "timetable", "flower", "poet"};
    String[] a2bolum5s4 = {"further", "shortly", "creature", "advanced", "jungle", "cinema", "boy", "alphabet", "violin", "hidden"};
    String[] a2bolum5s5 = {"lamb", "urgent", "nervous", "married", "expedition", "earth", "well done!", "above", "honest", "broad"};
    String[] a2bolum5s6 = {"defend", "southwest", "admire", "at least", "film star", "fancy", "engine", "digital", "shoot", "anything"};
    String[] a2bolum6s1 = {"little", "scary", "true", "selfish", "how much", "unhealthy", "fashionable", "holiday", "humid", "mine"};
    String[] a2bolum6s2 = {"sink", "usually", "get up", "besides", "right", "work", "person", "ingredient", "lay", "funny"};
    String[] a2bolum6s3 = {"sunrise", "full stop", "fool", "route", "install", "onion", "brave", "hardly", "sex", "depend"};
    String[] a2bolum6s4 = {"stylish", "prescription", "lecture", "scarf", "unforgettable", "air conditioning", "checkout", "roof", "clothes", "think"};
    String[] a2bolum6s5 = {"base on", "go", "brake", "so-so", "review", "powerful", "step", "original", "fold", "development"};
    String[] a2bolum6s6 = {"size", "marry", "desert", "delay", "date", "southeast", "whether", "advice", "knock", "pick"};
    String[] a2bolum7s1 = {"useful", "engaged", "and", "dining room", "make-up", "secretary", "stop", "vase", "afternoon", "coin"};
    String[] a2bolum7s2 = {"hug", "written", "part-time", "start", "thought", "product", "obviously", "such", "cattle", "sweet"};
    String[] a2bolum7s3 = {"village", "hat", "price", "common", "asleep", "song", "equal", "appointment", "board", "thing"};
    String[] a2bolum7s4 = {"new", "application", "guest-house", "blind", "bucket", "bandage", "backpack", "coast", "opinion", "swim"};
    String[] a2bolum7s5 = {"by accident", "resort", "introduce", "as well", "geography", "link", "pet", "surname", "conversation", "choice"};
    String[] a2bolum7s6 = {"either", "server", "historic", "recognise", "year", "same", "loan", "front", "click", "recommend"};
    String[] a2bolum8s1 = {"spill", "youth", "bin", "passenger", "millimetre", "know", "midday", "happen", "create", "huge"};
    String[] a2bolum8s2 = {"empty", "path", "bull", "character", "painting", "grab", "hopeless", "explorer", "annual", "sure"};
    String[] a2bolum8s3 = {"costume", "library", "tip", "reliable", "surfboard", "sport", "stage", "pure", "man", "look like"};
    String[] a2bolum8s4 = {"farmer", "dad", "everything", "low", "move", "flour", "canteen", "firework", "culture", "handwriting"};
    String[] a2bolum8s5 = {"handsome", "diagram", "long", "fax", "tuna", "bean", "science fiction", "unfriendly", "up to date", "cyclist"};
    String[] a2bolum8s6 = {"partly", "lots / a lot", "site", "hang up", "brand new", "tooth/teeth", "armchair", "boss", "aged", "cream"};
    String[] a2bolum9s1 = {"outdoors", "cough", "director", "again", "shoulder", "gas", "concert", "zone", "dishwasher", "paint"};
    String[] a2bolum9s2 = {"cooker", "already", "interview", "mineral water", "underwear", "pass", "warm", "part time", "strong", "way"};
    String[] a2bolum9s3 = {"wheel", "comma", "stupid", "running", "generally", "hang out", "arrangement", "anybody", "sale", "grow"};
    String[] a2bolum9s4 = {"curiously", "prince", "each", "granny", "with", "plate", "property", "unpack", "altogether", "beyond"};
    String[] a2bolum9s5 = {"north", "orange", "towel", "upper", "today", "painter", "heel", "club", "want", "anyway"};
    String[] a2bolum9s6 = {"silver", "dead", "use", "suggest", "seat belt", "pump", "uninteresting", "celebrate", "somebody", "half"};
    String[] a2bolum10s1 = {"trash can", "competition", "middle-aged", "obvious", "language", "group", "raincoat", "frequent", "uncomfortable", "tower"};
    String[] a2bolum10s2 = {"involve", "choose", "value", "explore", "me", "happily", "run", "thumb", "up to", "closed"};
    String[] a2bolum10s3 = {"along", "author", "noise", "ourselves", "through", "dance", "toothache", "be over", "novel", "smooth"};
    String[] a2bolum10s4 = {"tea", "let", "brain", "accurate", "basin", "trip", "fetch", "icy", "biography", "fit"};
    String[] a2bolum10s5 = {"material", "cucumber", "destination", "perfect", "pasta", "bunch", "horrible", "fortunately", "fail", "indoor"};
    String[] a2bolum10s6 = {"whatever", "knit", "sick", "heat", "comfort", "get along", "better", "forbidden", "lately", "performer"};

    // Data A2 Cevaplar

    String[] a2bolum1c1 = {"geri dönüştürmek", "yabancı", "temiz", "malzeme", "parmak", "tam", "yarar", "eğlence", "batı", "kan"};
    String[] a2bolum1c2 = {"otoyol", "ray", "rağmen", "rakip", "damla", "kitapçı", "affetmek", "gevşeme", "çizmek", "karmaşık"};
    String[] a2bolum1c3 = {"şekil", "teslim etmek", "çene", "bölüm", "kazmak", "almak, elde etmek", "lezzetli", "mimari", "…den sakınmak", "keşfetmek"};
    String[] a2bolum1c4 = {"Uyumlu", "diploma", "hoş", "kalmak", "ağız", "kitapçı", "havayolu", "Baskı", "olasılık", "macera"};
    String[] a2bolum1c5 = {"aynı zamanda", "köpek", "alışılmadık", "yakında", "ekipman", "yapmak", "ilgisiz", "sınav / sınav", "pazar", "güzel"};
    String[] a2bolum1c6 = {"sınav", "rahatsız etmek", "iğrenç", "düğme", "sakız", "etkinlik", "niyet etmek", "bizi/bize", "zorlu", "garaj"};
    String[] a2bolum2c1 = {"eski moda", "heyecan", "plaj", "olağan", "altında", "devam etmek", "pil", "atmak", "cevap vermek", "dağıtmak"};
    String[] a2bolum2c2 = {"adil", "bilgi", "vermek", "söndürmek", "soymak", "hoşlanmak", "çiftlik", "kâbus", "perde", "parça"};
    String[] a2bolum2c3 = {"bilet ücreti", "şişman", "baş öğretmen", "soğuk", "duyurmak", "geri dönüşüm", "dün", "yaklaşık, hakkında", "deneyimli", "kurtarmak"};
    String[] a2bolum2c4 = {"korkmuş", "durmak", "rezerv, şerh", "aktör", "beslemek", "büyük", "bol", "konum", "planlamak", "…den başka"};
    String[] a2bolum2c5 = {"yavaş", "yok etmek, ortadan kaldırmak", "arkasında", "yarışma", "kask, miğfer", "tatmak", "değerli", "ev işi", "maymun", "mevduat"};
    String[] a2bolum2c6 = {"kendisi", "önceki", "zeki", "asla", "elden teslim etmek", "tehlike", "gümrük", "üzerinde", "yaralamak", "olarak, gibi"};
    String[] a2bolum3c1 = {"bina", "aptal", "bulunan, konumlanan", "sınıf", "çocuk", "kar", "siyasi", "tutmak", "önce", "hastane"};
    String[] a2bolum3c2 = {"üst kat", "fabrika", "çıkarmak", "karınca", "korkmuş", "kurbağa", "cesaret", "açmak/kapamak", "seçmek", "gölge"};
    String[] a2bolum3c3 = {"giriş", "kapı", "dövmek", "her ikisi de", "inşa etmek", "kaçmak", "ahır", "güzellik", "Oda", "dosya"};
    String[] a2bolum3c4 = {"reçel", "telefon", "konu, sorun, mesele", "bisiklet", "sevimli", "tamamen", "aperatif", "hile", "kapamak", "kısa"};
    String[] a2bolum3c5 = {"dik", "banka", "bağımsız", "itiraf etmek", "mühendis", "yakın", "iz", "onu", "altında", "yıldırım"};
    String[] a2bolum3c6 = {"yerine", "başka", "para", "tavşan", "örnek", "insan", "balkon", "sıcaklık", "geçici", "tercüme etmek"};
    String[] a2bolum4c1 = {"dünya", "kart", "azaltmak", "nefret etmek", "kokmak", "beysbol", "acı çekmek, katlanmak", "sonbahar", "elle", "şok edici"};
    String[] a2bolum4c2 = {"doğrudan", "teslim", "yapılmış", "kimse", "birlikte", "sonsuza dek", "utangaç", "paket", "zeki", "Pirinç"};
    String[] a2bolum4c3 = {"orta", "yönetmek", "milliyet", "kopyalamak", "tost", "soluk", "masa", "en kötü", "gecelik", "kurgu"};
    String[] a2bolum4c4 = {"hafta sonu", "karışıklık", "şirket", "ayrılmak, bırakmak", "merkezi", "ilişki", "sanatçı", "nahoş", "sigara içme", "sol"};
    String[] a2bolum4c5 = {"cetvel, kural koyucu", "havuz", "gemide", "vahşi", "papağan", "kalacak yer", "ani", "göstermek", "işçi", "kamp yeri"};
    String[] a2bolum4c6 = {"uygun", "yanında", "nedeniyle", "açıklama", "endişeli", "ahşap", "belki", "davet etmek", "ilk", "yemek, tabak"};
    String[] a2bolum5c1 = {"konu", "böcek", "koltuk", "ışık, hafif", "daha az", "edebiyat", "gerçekleştirmek", "sıkı, katı", "üst", "av"};
    String[] a2bolum5c2 = {"kalemlik", "harika", "cezalandırmak", "her ne zaman olursa olsun", "canlı", "düzenlemek", "söz", "inek", "ikiz", "dar"};
    String[] a2bolum5c3 = {"teklif etmek", "davranmak", "işaret", "gün batımı", "çığlık", "bezelye", "Ben", "tarife", "çiçek", "şair"};
    String[] a2bolum5c4 = {"ayrıca, daha fazla", "kısaca", "yaratık", "gelişmiş", "orman", "sinema", "erkek çocuk", "alfabe", "keman", "gizli"};
    String[] a2bolum5c5 = {"kuzu", "acil", "sinir", "evli", "sefer", "yeryüzü", "aferin!", "üzerinde", "dürüst", "geniş"};
    String[] a2bolum5c6 = {"savunmak", "güneybatısında", "hayran olmak", "en azından", "film yıldızı", "hayal etmek", "motor", "dijital", "ateş etmek", "herhangi bir şey"};
    String[] a2bolum6c1 = {"küçük", "korkutucu", "gerçek", "bencil", "ne kadar", "sağlıksız", "moda", "tatil", "nemli", "mayın, maden"};
    String[] a2bolum6c2 = {"lavabo", "genellikle", "kalkmak", "ek olarak", "Sağ, doğru, hak", "iş, çalışmak", "kişi", "bileşen", "yere sermek", "komik"};
    String[] a2bolum6c3 = {"gündoğumu", "nokta", "aptal", "Rota", "kurmak", "soğan", "cesur", "hemen hemen hiç", "cinsiyet", "bağlı"};
    String[] a2bolum6c4 = {"şık", "reçete", "ders", "eşarp", "unutulmaz", "klima", "ödeme", "Çatı", "giysiler", "düşünmek"};
    String[] a2bolum6c5 = {"dayandırmak", "gitmek", "fren", "Eh işte", "yorum", "güçlü", "adım", "orijinal", "kat", "gelişme"};
    String[] a2bolum6c6 = {"boyut", "evlenmek", "çöl", "gecikme", "tarih", "güneydoğu", "… ıp … ımadığı", "tavsiye", "vurmak", "toplamak, almak"};
    String[] a2bolum7c1 = {"yararlı", "nişanlı", "ve", "yemek odası", "makyaj", "sekreter", "durdurmak", "vazo", "öğleden sonra", "metal para"};
    String[] a2bolum7c2 = {"sarılmak", "yazılı", "yarı zamanlı", "başlamak", "düşünce", "Ürün", "açık bir şekilde", "böyle", "sığırlar", "tatlı"};
    String[] a2bolum7c3 = {"köy", "şapka", "fiyat", "ortak, yaygın", "uykuda", "şarkı", "eşit", "randevu", "tahta", "şey"};
    String[] a2bolum7c4 = {"yeni", "uygulama", "konuk evi", "kör", "kova", "bandaj", "sırt çantası", "sahil", "görüş", "yüzmek"};
    String[] a2bolum7c5 = {"kazara", "tatil yöresi", "tanıtmak, piyasaya sürmek", "de (dahi anlamında),", "coğrafya", "bağlantı", "evcil hayvan", "soyadı", "konuşma", "seçim"};
    String[] a2bolum7c6 = {"ya, ikisinden biri", "Sunucu", "tarihi", "tanımak", "yıl", "aynı", "borç", "Ön", "tıklamak", "tavsiye etmek"};
    String[] a2bolum8c1 = {"dökmek", "gençlik", "çöp kutusu", "yolcu", "milimetre", "bilmek", "öğlen", "olmak", "yaratmak", "dev"};
    String[] a2bolum8c2 = {"boş", "yol", "boğa", "karakter", "boyama", "kapmak", "umutsuz", "kâşif", "yıllık", "emin"};
    String[] a2bolum8c3 = {"kostüm", "kütüphane", "uç", "güvenilir", "sörf tahtası", "spor", "sahne", "saf", "adam", "benzemek"};
    String[] a2bolum8c4 = {"çiftçi", "baba", "her şey", "düşük", "hareket etmek", "un", "kantin", "havai fişek", "kültür", "el yazısı"};
    String[] a2bolum8c5 = {"yakışıklı", "diyagram", "uzun", "faks", "ton balığı", "fasulye", "bilimkurgu", "düşmanca", "güncel", "bisikletçi"};
    String[] a2bolum8c6 = {"kısmen", "çok / çok", "yer, alan", "asmak", "yepyeni", "diş dişler", "koltuk", "patron", "yaşlı", "krem"};
    String[] a2bolum9c1 = {"açık havada", "öksürmek", "yönetmen", "tekrar", "omuz", "gaz/benzin", "konser", "bölge", "bulaşık makinesi", "boyamak"};
    String[] a2bolum9c2 = {"ocak", "zaten", "görüşme", "maden suyu", "iç çamaşırı", "geçmek", "sıcak", "yarı zamanlı", "güçlü", "yol"};
    String[] a2bolum9c3 = {"tekerlek", "virgül", "aptal", "koşu", "genellikle", "asmak", "düzenleme", "herhangi bir kimse", "satış", "büyü(t)mek"};
    String[] a2bolum9c4 = {"merakla", "prens", "her bir", "anneanne", "ile", "tabak, plaka", "özellik, mülk", "açmak (paket)", "tamamen", "ötesinde"};
    String[] a2bolum9c5 = {"kuzey", "turuncu", "havlu", "üst, yukarı", "bugün", "ressam", "topuk", "kulüp", "istemek", "neyse"};
    String[] a2bolum9c6 = {"gümüş", "ölü", "kullanmak", "önermek", "emniyet kemeri", "pompalamak", "ilgi çekmeyen", "kutlamak", "birisi", "yarım"};
    String[] a2bolum10c1 = {"çöp tenekesi", "yarışma", "orta yaşlı", "açık", "dil", "grup", "yağmurluk", "sık", "rahatsız", "kule"};
    String[] a2bolum10c2 = {"içermek", "seçmek", "değer", "keşfetmek", "beni, bana", "mutlulukla", "koşmak", "başparmak", "kadar", "kapalı"};
    String[] a2bolum10c3 = {"boyunca", "yazar", "gürültü", "kendimiz", "boyunca, vasıtasıyla", "dans", "diş ağrısı", "bitmek", "roman", "pürüzsüz"};
    String[] a2bolum10c4 = {"çay", "izin vermek", "beyin", "doğru, tam", "havza", "gezi", "gidip getirmek", "buzlu", "biyografi", "uygun, formda"};
    String[] a2bolum10c5 = {"malzeme", "salatalık", "hedef", "mükemmel", "makarna", "demet", "korkunç", "neyse ki", "başarısız olmak", "kapalı"};
    String[] a2bolum10c6 = {"ne olursa olsun", "örgü örmek", "hasta", "ısı", "rahat", "geçinmek", "daha iyi", "yasak", "son zamanlarda", "sanatçı"};

    // Yanlış Cevaplar     ca-app-pub-9283206876818854/6520854277

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

    int i = 0;
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
    int so =0;
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
        textToSpeech = new TextToSpeech(kelime.this, new TextToSpeech.OnInitListener() {
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
            Intent intent = new Intent(kelime.this,kelime.class);
            startActivity(intent);
            finish();
        });

        mView.findViewById(R.id.next).setOnClickListener(v -> {
            if (Objects.equals(sev, "A1bölüm1s1")){
                sharedPreferences.edit().putString("seviye1","A1bölüm1s2").apply();
            } else if (Objects.equals(sev, "A1bölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm1s3").apply();
            }else if (Objects.equals(sev, "A1bölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm1s4").apply();
            }else if (Objects.equals(sev, "A1bölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm1s5").apply();
            }else if (Objects.equals(sev, "A1bölüm1s5")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm1s6").apply();
            }else if (Objects.equals(sev, "A1bölüm1s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1 Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }  if (Objects.equals(sev, "A1bölüm3s1")){
                sharedPreferences.edit().putString("seviye1","A1bölüm3s2").apply();
            } else if (Objects.equals(sev, "A1bölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm3s3").apply();
            }else if (Objects.equals(sev, "A1bölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm3s4").apply();
            }else if (Objects.equals(sev, "A1bölüm3s4")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm3s5").apply();
            }else if (Objects.equals(sev, "A1bölüm3s5")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm3s6").apply();
            }else if (Objects.equals(sev, "A1bölüm3s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            } if (Objects.equals(sev, "A1bölüm2s1")){
                sharedPreferences.edit().putString("seviye1","A1bölüm2s2").apply();
            } else if (Objects.equals(sev, "A1bölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm1s3").apply();
            }else if (Objects.equals(sev, "A1bölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm2s4").apply();
            }else if (Objects.equals(sev, "A1bölüm2s4")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm2s5").apply();
            }else if (Objects.equals(sev, "A1bölüm2s5")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm2s6").apply();
            }else if (Objects.equals(sev, "A1bölüm2s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "A1bölüm4s1")){
                sharedPreferences.edit().putString("seviye1","A1bölüm4s2").apply();
            } else if (Objects.equals(sev, "A1bölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm4s3").apply();
            }else if (Objects.equals(sev, "A1bölüm4s3")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm4s4").apply();
            }else if (Objects.equals(sev, "A1bölüm4s4")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm4s5").apply();
            }else if (Objects.equals(sev, "A1bölüm4s5")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm4s6").apply();
            }else if (Objects.equals(sev, "A1bölüm4s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "A1bölüm5s1")){
                sharedPreferences.edit().putString("seviye1","A1bölüm5s2").apply();
            } else if (Objects.equals(sev, "A1bölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm5s3").apply();
            }else if (Objects.equals(sev, "A1bölüm5s3")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm5s4").apply();
            }else if (Objects.equals(sev, "A1bölüm5s4")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm5s5").apply();
            }else if (Objects.equals(sev, "A1bölüm5s5")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm5s6").apply();
            }else if (Objects.equals(sev, "A1bölüm5s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "A1bölüm6s1")){
                sharedPreferences.edit().putString("seviye1","A1bölüm6s2").apply();
            } else if (Objects.equals(sev, "A1bölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm6s3").apply();
            }else if (Objects.equals(sev, "A1bölüm6s3")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm6s4").apply();
            }else if (Objects.equals(sev, "A1bölüm6s4")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm6s5").apply();
            }else if (Objects.equals(sev, "A1bölüm6s5")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm6s6").apply();
            }else if (Objects.equals(sev, "A1bölüm6s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "A1bölüm7s1")){
                sharedPreferences.edit().putString("seviye1","A1bölüm7s2").apply();
            } else if (Objects.equals(sev, "A1bölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm7s3").apply();
            }else if (Objects.equals(sev, "A1bölüm7s3")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm7s4").apply();
            }else if (Objects.equals(sev, "A1bölüm7s4")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm7s5").apply();
            }else if (Objects.equals(sev, "A1bölüm7s5")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm7s6").apply();
            }else if (Objects.equals(sev, "A1bölüm7s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "A1bölüm8s1")){
                sharedPreferences.edit().putString("seviye1","A1bölüm8s2").apply();
            } else if (Objects.equals(sev, "A1bölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm8s3").apply();
            }else if (Objects.equals(sev, "A1bölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm8s4").apply();
            }else if (Objects.equals(sev, "A1bölüm8s4")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm8s5").apply();
            }else if (Objects.equals(sev, "A1bölüm8s5")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm8s6").apply();
            }else if (Objects.equals(sev, "A1bölüm8s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "A1bölüm9s1")){
                sharedPreferences.edit().putString("seviye1","A1bölüm9s2").apply();
            } else if (Objects.equals(sev, "A1bölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm9s3").apply();
            }else if (Objects.equals(sev, "A1bölüm9s3")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm9s4").apply();
            }else if (Objects.equals(sev, "A1bölüm9s4")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm9s5").apply();
            }else if (Objects.equals(sev, "A1bölüm9s5")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm9s6").apply();
            }else if (Objects.equals(sev, "A1bölüm9s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "A1bölüm10s1")){
                sharedPreferences.edit().putString("seviye1","A1bölüm10s2").apply();
            } else if (Objects.equals(sev, "A1bölüm10s2")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm10s3").apply();
            }else if (Objects.equals(sev, "A1bölüm10s3")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm10s4").apply();
            }else if (Objects.equals(sev, "A1bölüm10s4")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm10s5").apply();
            }else if (Objects.equals(sev, "A1bölüm10s5")) {
                sharedPreferences.edit().putString("seviye1","A1bölüm10s6").apply();
            }else if (Objects.equals(sev, "A1bölüm10s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 10. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "A2bölüm1s1")){
                sharedPreferences.edit().putString("seviye1","A2bölüm1s2").apply();
            } else if (Objects.equals(sev, "A2bölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm1s3").apply();
            }else if (Objects.equals(sev, "A2bölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm1s4").apply();
            }else if (Objects.equals(sev, "A2bölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm1s5").apply();
            }else if (Objects.equals(sev, "A2bölüm1s5")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm1s6").apply();
            }else if (Objects.equals(sev, "A2bölüm1s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "A2bölüm2s1")){
                sharedPreferences.edit().putString("seviye1","A2bölüm2s2").apply();
            } else if (Objects.equals(sev, "A2bölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm2s3").apply();
            }else if (Objects.equals(sev, "A2bölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm2s4").apply();
            }else if (Objects.equals(sev, "A2bölüm2s4")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm2s5").apply();
            }else if (Objects.equals(sev, "A2bölüm2s5")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm2s6").apply();
            }else if (Objects.equals(sev, "A2bölüm2s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "A2bölüm3s1")){
                sharedPreferences.edit().putString("seviye1","A2bölüm3s2").apply();
            } else if (Objects.equals(sev, "A2bölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm3s3").apply();
            }else if (Objects.equals(sev, "A2bölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm3s4").apply();
            }else if (Objects.equals(sev, "A2bölüm3s4")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm3s5").apply();
            }else if (Objects.equals(sev, "A2bölüm3s5")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm3s6").apply();
            }else if (Objects.equals(sev, "A2bölüm3s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "A2bölüm4s1")){
                sharedPreferences.edit().putString("seviye1","A2bölüm4s2").apply();
            } else if (Objects.equals(sev, "A2bölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm4s3").apply();
            }else if (Objects.equals(sev, "A2bölüm4s3")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm4s4").apply();
            }else if (Objects.equals(sev, "A2bölüm4s4")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm4s5").apply();
            }else if (Objects.equals(sev, "A2bölüm4s5")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm4s6").apply();
            }else if (Objects.equals(sev, "A2bölüm4s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "A2bölüm5s1")){
                sharedPreferences.edit().putString("seviye1","A2bölüm5s2").apply();
            } else if (Objects.equals(sev, "A2bölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm5s3").apply();
            }else if (Objects.equals(sev, "A2bölüm5s3")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm5s4").apply();
            }else if (Objects.equals(sev, "A2bölüm5s4")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm5s5").apply();
            }else if (Objects.equals(sev, "A2bölüm5s5")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm5s6").apply();
            }else if (Objects.equals(sev, "A2bölüm5s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "A2bölüm6s1")){
                sharedPreferences.edit().putString("seviye1","A2bölüm6s2").apply();
            } else if (Objects.equals(sev, "A2bölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm6s3").apply();
            }else if (Objects.equals(sev, "A2bölüm6s3")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm6s4").apply();
            }else if (Objects.equals(sev, "A2bölüm6s4")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm6s5").apply();
            }else if (Objects.equals(sev, "A2bölüm6s5")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm6s6").apply();
            }else if (Objects.equals(sev, "A2bölüm6s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "A2bölüm7s1")){
                sharedPreferences.edit().putString("seviye1","A2bölüm7s2").apply();
            } else if (Objects.equals(sev, "A2bölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm7s3").apply();
            }else if (Objects.equals(sev, "A2bölüm7s3")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm7s4").apply();
            }else if (Objects.equals(sev, "A2bölüm7s4")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm7s5").apply();
            }else if (Objects.equals(sev, "A2bölüm7s5")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm7s6").apply();
            }else if (Objects.equals(sev, "A2bölüm7s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "A2bölüm8s1")){
                sharedPreferences.edit().putString("seviye1","A2bölüm8s2").apply();
            } else if (Objects.equals(sev, "A2bölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm8s3").apply();
            }else if (Objects.equals(sev, "A2bölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm8s4").apply();
            }else if (Objects.equals(sev, "A2bölüm8s4")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm8s5").apply();
            }else if (Objects.equals(sev, "A2bölüm8s5")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm8s6").apply();
            }else if (Objects.equals(sev, "A2bölüm8s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }




            if (Objects.equals(sev, "A2bölüm9s1")){
                sharedPreferences.edit().putString("seviye1","A2bölüm9s2").apply();
            } else if (Objects.equals(sev, "A2bölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm9s3").apply();
            }else if (Objects.equals(sev, "A2bölüm9s3")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm9s4").apply();
            }else if (Objects.equals(sev, "A2bölüm9s4")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm9s5").apply();
            }else if (Objects.equals(sev, "A2bölüm9s5")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm9s6").apply();
            }else if (Objects.equals(sev, "A2bölüm9s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "A2bölüm10s1")){
                sharedPreferences.edit().putString("seviye1","A2bölüm10s2").apply();
            } else if (Objects.equals(sev, "A2bölüm10s2")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm10s3").apply();
            }else if (Objects.equals(sev, "A2bölüm10s3")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm10s4").apply();
            }else if (Objects.equals(sev, "A2bölüm10s4")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm10s5").apply();
            }else if (Objects.equals(sev, "A2bölüm10s5")) {
                sharedPreferences.edit().putString("seviye1","A2bölüm10s6").apply();
            }else if (Objects.equals(sev, "A2bölüm10s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 10. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if(i == 0) {
                alertDialog.dismiss();
                Intent intent = new Intent(kelime.this, kelime.class);
                startActivity(intent);
                finish();
            }
        });
        mView.findViewById(R.id.anamenu).setOnClickListener(v -> {
            alertDialog.dismiss();
            Intent intent = new Intent(kelime.this,MainActivity5.class);
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
                handler1.postDelayed(this, 1200);
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
                    mInterstitialAd.show(kelime.this);
                }
            ShowDialogBox();
            if (sev.contains("A1bölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A1bölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A1bölüm1'");
            }
            if (sev.contains("A1bölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A1bölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A1bölüm2'");
            }
            if (sev.contains("A1bölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A1bölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A1bölüm3'");
            }
            if (sev.contains("A1bölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A1bölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A1bölüm4'");
            }
            if (sev.contains("A1bölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A1bölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A1bölüm5'");
            }
            if (sev.contains("A1bölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A1bölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A1bölüm6'");
            }
            if (sev.contains("A1bölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A1bölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A1bölüm7'");
            }
            if (sev.contains("A1bölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A1bölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A1bölüm8'");
            }
            if (sev.contains("A1bölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A1bölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A1bölüm9'");
            }
            if (sev.contains("A1bölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A1bölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A1bölüm10'");
            }
            if (sev.contains("A2bölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A2bölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A2bölüm1'");
            }
            if (sev.contains("A2bölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A2bölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A2bölüm2'");
            }
            if (sev.contains("A2bölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A2bölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A2bölüm3'");
            }
            if (sev.contains("A2bölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A2bölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A2bölüm4'");
            }
            if (sev.contains("A2bölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A2bölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A2bölüm5'");
            }
            if (sev.contains("A2bölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A2bölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A2bölüm6'");
            }
            if (sev.contains("A2bölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A2bölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A2bölüm7'");
            }
            if (sev.contains("A2bölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A2bölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A2bölüm8'");
            }
            if (sev.contains("A2bölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A2bölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A2bölüm9'");
            }
            if (sev.contains("A2bölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='A2bölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='A2bölüm10'");
            }
            database.execSQL("UPDATE P SET puan=puan+" + sorudogru * 2 + "");


            if (sev.equals("A1bölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm1s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm1s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm1s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm1s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm1s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm1s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm1s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm1s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm2s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm2s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm2s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm2s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm2s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm2s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm2s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm2s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm3s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm3s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm3s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm3s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm3s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm3s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm3s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm3s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm4s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm4s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm4s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm4s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm4s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm4s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm4s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm4s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm4s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm4s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm4s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm4s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm5s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm5s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm5s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm5s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm5s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm5s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm5s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm5s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm5s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm5s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm5s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm5s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm6s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm6s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm6s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm6s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm6s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm6s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm6s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm6s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm6s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm6s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm6s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm6s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm7s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm7s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm7s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm7s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm7s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm7s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm7s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm7s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm7s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm7s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm7s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm7s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm8s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm8s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm8s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm8s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm8s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm8s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm8s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm8s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm9s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm9s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm9s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm9s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm9s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm9s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm9s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm9s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm9s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm9s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm9s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm9s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm9s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm10s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm10s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm10s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm10s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm10s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm10s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm10s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm10s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm10s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm10s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm10s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm10s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm10s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm10s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm10s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm10s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm10s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm10s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm10s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm10s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A1bölüm10s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A1bölüm10s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A1bölüm10s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A1bölüm10s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm1s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm1s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm1s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm1s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm1s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm1s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm1s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm1s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm2s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm2s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm2s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm2s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm2s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm2s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm2s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm2s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm3s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm3s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm3s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm3s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm3s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm3s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm3s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm3s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm4s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm4s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm4s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm4s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm4s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm4s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm4s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm4s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm4s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm4s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm4s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm4s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm5s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm5s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm5s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm5s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm5s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm5s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm5s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm5s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm5s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm5s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm5s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm5s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm6s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm6s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm6s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm6s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm6s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm6s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm6s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm6s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm6s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm6s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm6s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm6s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm7s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm7s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm7s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm7s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm7s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm7s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm7s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm7s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm7s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm7s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm7s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm7s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm8s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm8s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm8s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm8s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm8s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm8s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm8s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm8s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm9s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm9s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm9s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm9s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm9s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm9s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm9s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm9s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm9s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm9s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm9s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm9s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm9s6yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm10s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm10s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm10s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm10s1yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm10s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm10s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm10s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm10s2yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm10s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm10s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm10s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm10s3yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm10s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm10s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm10s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm10s4yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm10s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm10s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm10s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm10s5yildiz", "2").apply();
                }
            }
            if (sev.equals("A2bölüm10s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("A2bölüm10s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("A2bölüm10s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("A2bölüm10s6yildiz", "2").apply();
                }
            }


            // SORU EKRANI

        } else if (Objects.equals(sev, "A1bölüm1s1")) {
            soru1 = new Soru(a1bolum1s1[sorusay], a1bolum1c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();

        }else if (Objects.equals(sev, "A1bölüm1s2")){
            soru1 = new Soru(a1bolum1s2[sorusay], a1bolum1c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm1s3")){
            soru1 = new Soru(a1bolum1s3[sorusay], a1bolum1c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm1s4")){
            soru1 = new Soru(a1bolum1s4[sorusay], a1bolum1c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm1s5")){
            soru1 = new Soru(a1bolum1s5[sorusay], a1bolum1c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm1s6")){
            soru1 = new Soru(a1bolum1s6[sorusay], a1bolum1c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev,"A1bölüm2s1")){
            soru1 = new Soru(a1bolum2s1[sorusay], a1bolum2c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm2s2")){
            soru1 = new Soru(a1bolum2s2[sorusay], a1bolum2c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm2s3")){
            soru1 = new Soru(a1bolum2s3[sorusay], a1bolum2c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm2s4")){
            soru1 = new Soru(a1bolum2s4[sorusay], a1bolum2c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm2s5")){
            soru1 = new Soru(a1bolum2s5[sorusay], a1bolum2c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm2s6")){
            soru1 = new Soru(a1bolum2s6[sorusay], a1bolum2c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm3s1")){
            soru1 = new Soru(a1bolum3s1[sorusay], a1bolum3c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm3s2")){
            soru1 = new Soru(a1bolum3s2[sorusay], a1bolum3c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm3s3")){
            soru1 = new Soru(a1bolum3s3[sorusay], a1bolum3c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm3s4")){
            soru1 = new Soru(a1bolum3s4[sorusay], a1bolum3c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm3s5")){
            soru1 = new Soru(a1bolum3s5[sorusay], a1bolum3c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm3s6")){
            soru1 = new Soru(a1bolum3s6[sorusay], a1bolum3c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm4s1")){
            soru1 = new Soru(a1bolum4s1[sorusay], a1bolum4c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm4s2")){
            soru1 = new Soru(a1bolum4s2[sorusay], a1bolum4c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm4s3")){
            soru1 = new Soru(a1bolum4s3[sorusay], a1bolum4c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm4s4")){
            soru1 = new Soru(a1bolum4s4[sorusay], a1bolum4c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm4s5")){
            soru1 = new Soru(a1bolum4s5[sorusay], a1bolum4c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm4s6")){
            soru1 = new Soru(a1bolum4s6[sorusay], a1bolum4c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm5s1")){
            soru1 = new Soru(a1bolum5s1[sorusay], a1bolum5c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm5s2")){
            soru1 = new Soru(a1bolum5s2[sorusay], a1bolum5c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm5s3")){
            soru1 = new Soru(a1bolum5s3[sorusay], a1bolum5c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm5s4")){
            soru1 = new Soru(a1bolum5s4[sorusay], a1bolum5c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm5s5")){
            soru1 = new Soru(a1bolum5s5[sorusay], a1bolum5c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm5s6")){
            soru1 = new Soru(a1bolum5s6[sorusay], a1bolum5c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm6s1")){
            soru1 = new Soru(a1bolum6s1[sorusay], a1bolum6c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm6s2")){
            soru1 = new Soru(a1bolum6s2[sorusay], a1bolum6c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm6s3")){
            soru1 = new Soru(a1bolum6s3[sorusay], a1bolum6c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm6s4")){
            soru1 = new Soru(a1bolum6s4[sorusay], a1bolum6c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm6s5")){
            soru1 = new Soru(a1bolum6s5[sorusay], a1bolum6c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm6s6")){
            soru1 = new Soru(a1bolum6s1[sorusay], a1bolum6c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm7s1")){
            soru1 = new Soru(a1bolum7s1[sorusay], a1bolum7c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm7s2")){
            soru1 = new Soru(a1bolum7s2[sorusay], a1bolum7c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm7s3")){
            soru1 = new Soru(a1bolum7s3[sorusay], a1bolum7c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm7s4")){
            soru1 = new Soru(a1bolum7s4[sorusay], a1bolum7c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm7s5")){
            soru1 = new Soru(a1bolum7s5[sorusay], a1bolum7c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm7s6")){
            soru1 = new Soru(a1bolum7s6[sorusay], a1bolum7c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm8s1")){
            soru1 = new Soru(a1bolum8s1[sorusay], a1bolum8c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm8s2")){
            soru1 = new Soru(a1bolum8s2[sorusay], a1bolum8c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm8s3")){
            soru1 = new Soru(a1bolum8s3[sorusay], a1bolum8c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm8s4")){
            soru1 = new Soru(a1bolum8s4[sorusay], a1bolum8c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm8s5")){
            soru1 = new Soru(a1bolum8s5[sorusay], a1bolum8c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm8s6")){
            soru1 = new Soru(a1bolum8s6[sorusay], a1bolum8c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm9s1")){
            soru1 = new Soru(a1bolum9s1[sorusay], a1bolum9c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm9s2")){
            soru1 = new Soru(a1bolum9s2[sorusay], a1bolum9c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm9s3")){
            soru1 = new Soru(a1bolum9s3[sorusay], a1bolum9c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm9s4")){
            soru1 = new Soru(a1bolum9s4[sorusay], a1bolum9c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm9s5")){
            soru1 = new Soru(a1bolum9s5[sorusay], a1bolum9c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm9s6")){
            soru1 = new Soru(a1bolum9s6[sorusay], a1bolum9c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm10s1")){
            soru1 = new Soru(a1bolum10s1[sorusay], a1bolum10c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm10s2")){
            soru1 = new Soru(a1bolum10s2[sorusay], a1bolum10c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm10s3")){
            soru1 = new Soru(a1bolum10s3[sorusay], a1bolum10c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm10s4")){
            soru1 = new Soru(a1bolum10s4[sorusay], a1bolum10c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm10s5")){
            soru1 = new Soru(a1bolum10s5[sorusay], a1bolum10c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A1bölüm10s6")){
            soru1 = new Soru(a1bolum10s6[sorusay], a1bolum10c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "A2bölüm1s1")){
        soru1 = new Soru(a2bolum1s1[sorusay], a2bolum1c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm1s2")){
        soru1 = new Soru(a2bolum1s2[sorusay], a2bolum1c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm1s3")){
        soru1 = new Soru(a2bolum1s3[sorusay], a2bolum1c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm1s4")){
        soru1 = new Soru(a2bolum1s4[sorusay], a2bolum1c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm1s5")){
        soru1 = new Soru(a2bolum1s5[sorusay], a2bolum1c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm1s6")){
        soru1 = new Soru(a2bolum1s6[sorusay], a2bolum1c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm2s1")){
        soru1 = new Soru(a2bolum2s1[sorusay], a2bolum2c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm2s2")){
        soru1 = new Soru(a2bolum2s2[sorusay], a2bolum2c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm2s3")){
        soru1 = new Soru(a2bolum2s3[sorusay], a2bolum2c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm2s4")){
        soru1 = new Soru(a2bolum2s4[sorusay], a2bolum2c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm2s5")){
        soru1 = new Soru(a2bolum2s5[sorusay], a2bolum2c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm2s6")){
        soru1 = new Soru(a2bolum2s6[sorusay], a2bolum2c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm3s1")){
        soru1 = new Soru(a2bolum3s1[sorusay], a2bolum3c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm3s2")){
        soru1 = new Soru(a2bolum3s2[sorusay], a2bolum3c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm3s3")){
        soru1 = new Soru(a2bolum3s3[sorusay], a2bolum3c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm3s4")){
        soru1 = new Soru(a2bolum3s4[sorusay], a2bolum3c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm3s5")){
        soru1 = new Soru(a2bolum3s5[sorusay], a2bolum3c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm3s6")){
        soru1 = new Soru(a2bolum3s6[sorusay], a2bolum3c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm4s1")){
        soru1 = new Soru(a2bolum4s1[sorusay], a2bolum4c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm4s2")){
        soru1 = new Soru(a2bolum4s2[sorusay], a2bolum4c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm4s3")){
        soru1 = new Soru(a2bolum4s3[sorusay], a2bolum4c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm4s4")){
        soru1 = new Soru(a2bolum4s4[sorusay], a2bolum4c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm4s5")){
        soru1 = new Soru(a2bolum4s5[sorusay], a2bolum4c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm4s6")){
        soru1 = new Soru(a2bolum4s6[sorusay], a2bolum4c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm5s1")){
        soru1 = new Soru(a2bolum5s1[sorusay], a2bolum5c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm5s2")){
        soru1 = new Soru(a2bolum5s2[sorusay], a2bolum5c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm5s3")){
        soru1 = new Soru(a2bolum5s3[sorusay], a2bolum5c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm5s4")){
        soru1 = new Soru(a2bolum5s4[sorusay], a2bolum5c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm5s5")){
        soru1 = new Soru(a2bolum5s5[sorusay], a2bolum5c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm5s6")){
        soru1 = new Soru(a2bolum5s6[sorusay], a2bolum5c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm6s1")){
        soru1 = new Soru(a2bolum6s1[sorusay], a2bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm6s2")){
        soru1 = new Soru(a2bolum6s2[sorusay], a2bolum6c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm6s3")){
        soru1 = new Soru(a2bolum6s3[sorusay], a2bolum6c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm6s4")){
        soru1 = new Soru(a2bolum6s4[sorusay], a2bolum6c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm6s5")){
        soru1 = new Soru(a2bolum6s5[sorusay], a2bolum6c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm6s6")){
        soru1 = new Soru(a2bolum6s1[sorusay], a2bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm7s1")){
        soru1 = new Soru(a2bolum7s1[sorusay], a2bolum7c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm7s2")){
        soru1 = new Soru(a2bolum7s2[sorusay], a2bolum7c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm7s3")){
        soru1 = new Soru(a2bolum7s3[sorusay], a2bolum7c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm7s4")){
        soru1 = new Soru(a2bolum7s4[sorusay], a2bolum7c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm7s5")){
        soru1 = new Soru(a2bolum7s5[sorusay], a2bolum7c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm7s6")){
        soru1 = new Soru(a2bolum7s6[sorusay], a2bolum7c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm8s1")){
        soru1 = new Soru(a2bolum8s1[sorusay], a2bolum8c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm8s2")){
        soru1 = new Soru(a2bolum8s2[sorusay], a2bolum8c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm8s3")){
        soru1 = new Soru(a2bolum8s3[sorusay], a2bolum8c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm8s4")){
        soru1 = new Soru(a2bolum8s4[sorusay], a2bolum8c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm8s5")){
        soru1 = new Soru(a2bolum8s5[sorusay], a2bolum8c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm8s6")){
        soru1 = new Soru(a2bolum8s6[sorusay], a2bolum8c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm9s1")){
        soru1 = new Soru(a2bolum9s1[sorusay], a2bolum9c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm9s2")){
        soru1 = new Soru(a2bolum9s2[sorusay], a2bolum9c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm9s3")){
        soru1 = new Soru(a2bolum9s3[sorusay], a2bolum9c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm9s4")){
        soru1 = new Soru(a2bolum9s4[sorusay], a2bolum9c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        } else if (Objects.equals(sev, "A2bölüm9s5")){
        soru1 = new Soru(a2bolum9s5[sorusay], a2bolum9c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm9s6")){
        soru1 = new Soru(a2bolum9s6[sorusay], a2bolum9c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm10s1")){
        soru1 = new Soru(a2bolum10s1[sorusay], a2bolum10c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm10s2")){
        soru1 = new Soru(a2bolum10s2[sorusay], a2bolum10c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm10s3")){
        soru1 = new Soru(a2bolum10s3[sorusay], a2bolum10c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm10s4")){
        soru1 = new Soru(a2bolum10s4[sorusay], a2bolum10c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm10s5")){
        soru1 = new Soru(a2bolum10s5[sorusay], a2bolum10c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "A2bölüm10s6")){
        soru1 = new Soru(a2bolum10s6[sorusay], a2bolum10c6[sorusay], yanlislar3, yanlislar4);
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

