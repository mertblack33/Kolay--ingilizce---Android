package com.mert.kolayingilizce.b1b2;

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

public class kelime2 extends AppCompatActivity {
    // Data B1

    String[] b1bolum1s1 = {"note", "exist", "aunt", "math", "prince", "suspect", "sake", "beach", "location", "common"};
    String[] b1bolum1s2 = {"evil", "leader", "prisoner", "project", "dirty", "although", "smoke", "usually", "guilty", "type"};
    String[] b1bolum1s3 = {"besides", "threaten", "difficult", "ridiculous", "trial", "tape", "issue", "research", "public", "castle"};
    String[] b1bolum1s4 = {"student", "area", "advice", "wrote", "stone", "wash", "west", "department", "earlier", "member"};
    String[] b1bolum1s5 = {"text", "press", "switch", "soldier", "ghost", "mystery", "piss", "apart", "mountain", "bro"};
    String[] b1bolum1s6 = {"lay", "twice", "everywhere", "tea", "right now", "supply", "trade", "guest", "fake", "bleed"};
    String[] b1bolum2s1 = {"notice", "art", "buck", "herself", "especially", "command", "trap", "final", "rain", "beyond"};
    String[] b1bolum2s2 = {"saving", "patient", "breathe", "strange", "neck", "iron", "impossible", "snow", "sitting", "chair"};
    String[] b1bolum2s3 = {"opportunity", "my", "develop", "somehow", "chuck", "american", "spy", "come to", "indeed", "dumb"};
    String[] b1bolum2s4 = {"photo", "shirt", "warm", "rich", "enter", "planet", "egg", "credit", "plant", "weak"};
    String[] b1bolum2s5 = {"option", "shower", "scientist", "come on", "get to", "hotel", "dig", "double", "greatest", "cake"};
    String[] b1bolum2s6 = {"cheer", "convince", "monkey", "vote", "base", "english", "page", "nose", "quickly", "abandon"};
    String[] b1bolum3s1 = {"disappear", "odd", "get it", "bury", "strength", "excellent", "receive", "map", "path", "sight"};
    String[] b1bolum3s2 = {"cloth", "barely", "bottom", "plenty", "easier", "empty", "frank", "warrior", "require", "button"};
    String[] b1bolum3s3 = {"hook", "mommy", "themselves", "rose", "destiny", "complete", "super", "avoid", "bless", "possibly"};
    String[] b1bolum3s4 = {"foot", "dare", "often", "bus", "fate", "study", "animal", "fan", "embarrass", "settle"};
    String[] b1bolum3s5 = {"tool", "farm", "pray", "liar", "purpose", "otherwise", "folk", "amazing", "east", "threw"};
    String[] b1bolum3s6 = {"safety", "email", "skin", "corner", "continue", "tear", "knife", "mask", "bridge", "raise"};
    String[] b1bolum4s1 = {"grant", "insane", "rat", "honestly", "gas", "sky", "powerful", "cash", "term", "deliver"};
    String[] b1bolum4s2 = {"breakfast", "ourselves", "set", "split", "fought", "shadow", "throne", "witness", "prepare", "flower"};
    String[] b1bolum4s3 = {"yell", "bone", "toward", "further", "bottle", "regret", "closer", "above", "asleep", "interview"};
    String[] b1bolum4s4 = {"mate", "career", "throat", "bite", "mama", "load", "comfortable", "circle", "fir", "nut"};
    String[] b1bolum4s5 = {"emergency", "hood", "band", "president", "tight", "named", "held", "duty", "chinese", "teacher"};
    String[] b1bolum4s6 = {"fresh", "van", "match", "pocket", "speech", "defend", "prefer", "older", "sold", "afternoon"};
    String[] b1bolum5s1 = {"low", "jealous", "blind", "pressure", "gather", "sail", "add", "spread", "kitchen", "event"};
    String[] b1bolum5s2 = {"strike", "stranger", "giant", "storm", "roof", "process", "root", "itself", "color", "nowhere"};
    String[] b1bolum5s3 = {"bell", "tiny", "russian", "restaurant", "sweetheart", "invite", "loose", "arrive", "slept", "connect"};
    String[] b1bolum5s4 = {"bedroom", "spoke", "necessary", "device", "cousin", "moon", "flame", "large", "tower", "cream"};
    String[] b1bolum5s5 = {"however", "hire", "brilliant", "savior", "skill", "nervous", "league", "harm", "defeat", "creat"};
    String[] b1bolum5s6 = {"crack", "dump", "brave", "sawyer", "harder", "earn", "seek", "earl", "medical", "slip"};
    String[] b1bolum6s1 = {"sacrifice", "awful", "shoulder", "knee", "punch", "desk", "ain't", "spirit", "size", "chain"};
    String[] b1bolum6s2 = {"asshole", "attorney", "due", "likely", "defense", "river", "billion", "jerk", "plate", "responsible"};
    String[] b1bolum6s3 = {"subject", "crew", "race", "attempt", "genius", "milk", "tip", "depend", "operation", "feelings"};
    String[] b1bolum6s4 = {"onto", "dry", "aware", "revenge", "condition", "major", "roommate", "lower", "lesson", "sooner"};
    String[] b1bolum6s5 = {"familiar", "secure", "servant", "result", "rome", "clever", "jail", "weather", "march", "horrible"};
    String[] b1bolum6s6 = {"damage", "practice", "aye", "whenever", "cab", "community", "cheat", "military", "lift", "climb"};
    String[] b1bolum7s1 = {"teeth", "fancy", "bust", "make it", "bean", "loud", "cave", "afford", "request", "obvious"};
    String[] b1bolum7s2 = {"social", "come back", "backup", "recognize", "eventually", "nail", "lately", "faster", "post", "data"};
    String[] b1bolum7s3 = {"apology", "french", "whore", "pill", "murderer", "pie", "comic", "spare", "knowledge", "heal"};
    String[] b1bolum7s4 = {"boring", "tire", "protection", "village", "cheese", "wild", "romantic", "firm", "grew", "general"};
    String[] b1bolum7s5 = {"center", "borrow", "create", "tech", "challenge", "sandwich", "effect", "trigger", "proof", "famous"};
    String[] b1bolum7s6 = {"bow", "traitor", "responsibility", "language", "main", "grand", "shop", "site", "release", "total"};
    String[] b1bolum8s1 = {"silly", "pig", "heat", "sneak", "shock", "regular", "score", "simply", "duck", "perfectly"};
    String[] b1bolum8s2 = {"unfortunately", "clock", "doc", "spell", "disappoint", "used to", "toy", "mercy", "ate", "prime"};
    String[] b1bolum8s3 = {"recently", "evening", "source", "authority", "deny", "council", "connection", "engineer", "clothe", "grade"};
    String[] b1bolum8s4 = {"amount", "scary", "rise", "rescue", "don", "married", "shield", "debt", "nah", "slap"};
    String[] b1bolum8s5 = {"local", "bullshit", "birth", "basically", "approach", "chamber", "view", "intend", "prize", "hug"};
    String[] b1bolum8s6 = {"havent", "former", "seal", "cure", "heaven", "rough", "couch", "suddenly", "sin", "value"};
    String[] b1bolum9s1 = {"dozen", "congratulation", "look at", "take it", "row", "neighbor", "bath", "toast", "journey", "investigation"};
    String[] b1bolum9s2 = {"trail", "heavy", "mix", "crown", "string", "gang", "swing", "hidden", "wave", "pal"};
    String[] b1bolum9s3 = {"awake", "impressive", "bowl", "chick", "experiment", "discover", "identity", "agreement", "chief", "devil"};
    String[] b1bolum9s4 = {"speed", "fella", "suicide", "nature", "aside", "grown", "incredible", "sport", "loss", "zero"};
    String[] b1bolum9s5 = {"energy", "tunnel", "pair", "saturday", "became", "confess", "wise", "driving", "player", "torture"};
    String[] b1bolum9s6 = {"pyramid", "physic", "jungle", "surely", "someday", "fed", "stronger", "meat", "exact", "limit"};
    String[] b1bolum10s1 = {"crush", "demand", "demon", "impress", "bug", "network", "goddamn", "coat", "tongue", "wheel"};
    String[] b1bolum10s2 = {"terrorist", "solve", "capable", "unravel", "university", "get out", "slave", "funeral", "expansion", "nurse"};
    String[] b1bolum10s3 = {"flag", "solution", "schedule", "precious", "interrupt", "exit", "surgery", "manage", "physical", "vow"};
    String[] b1bolum10s4 = {"task", "complicated", "shake", "pit", "actual", "weight", "gosh", "sexy", "kinda", "route"};
    String[] b1bolum10s5 = {"direction", "square", "rate", "coin", "driver", "friday", "opinion", "curious", "mostly", "natural"};
    String[] b1bolum10s6 = {"coward", "sale", "punish", "property", "assistant", "glades", "friendship", "shift", "legal", "tall"};


    // Data B1 Cevaplar

    String[] b1bolum1c1 = {"not", "var olmak", "teyze, hala", "matematik", "prens", "şüpheli", "uğruna", "plaj, kumsala çekmek", "yer", "yaygın"};
    String[] b1bolum1c2 = {"kötülük", "önder", "mahkum", "proje", "kirli", "olmasına rağmen", "sigara içmek", "genelde", "suçlu", "tip"};
    String[] b1bolum1c3 = {"dışında, ayrıca", "tehdit etmek", "zor", "gülünç", "deneme", "kaset, kasede almak", "konu", "araştırma", "halk, umumi, kamu", "kale, şato, hisar"};
    String[] b1bolum1c4 = {"öğrenci", "alan", "tavsiye", "yazdı", "taş", "yıkama", "batı", "bölüm", "daha erken", "üye"};
    String[] b1bolum1c5 = {"metin", "basın", "şalter, değiştirmek", "asker", "hayalet", "gizem", "işemek", "ayrı", "dağ", "kanka"};
    String[] b1bolum1c6 = {"yatırmak", "iki defa", "her yerde", "çay", "hemen şimdi, derhal", "arz", "ticaret", "konuk", "sahte", "kanamak"};
    String[] b1bolum2c1 = {"farkına varmak", "sanat", "dolar, sıçramak", "kendini", "özellikle", "komuta", "tuzak", "nihai", "yağmur", "ötesinde"};
    String[] b1bolum2c2 = {"tasarruf", "hasta", "nefes almak", "garip", "boyun", "demir", "imkansız", "kar", "oturma", "sandalye"};
    String[] b1bolum2c3 = {"fırsat", "benim", "geliştirmek", "bir şekilde", "atmak", "amerikan", "casus", "gel", "aslında", "aptal, sessiz"};
    String[] b1bolum2c4 = {"fotoğraf", "gömlek", "ilık, hafif sıcak", "zengin", "girmek, katılmak", "gezegen", "yumurta", "kredi", "bitki", "zayıf"};
    String[] b1bolum2c5 = {"seçenek", "duş", "bilim insanı", "haydi", "e gelmek, noktasına gelmek", "otel", "kazmak", "çift", "en büyük", "kek"};
    String[] b1bolum2c6 = {"tezahürat", "ikna etmek", "maymun", "oy", "baz, dayandırmak", "ingilizce", "sayfa", "burun", "hızlı bir şekilde", "terketmek"};
    String[] b1bolum3c1 = {"kaybolmak", "garip", "anla", "gömmek", "kuvvet", "mükemmel, enfes", "teslim almak", "harita", "yol, yörünge", "görme"};
    String[] b1bolum3c2 = {"bez", "zar zor", "alt, dip, temeline inmek", "bol", "daha kolay", "boş, boşaltmak", "dürüst", "savaşçı", "gerekmek, gerektirmek, gerektirir, icap etmek", "düğme"};
    String[] b1bolum3c3 = {"kanca", "anne", "kendilerini", "gül", "kader", "tamamlamak, tam, eksiksiz", "süper", "önlemek, kaçınmak", "kutsamak", "muhtemelen, belki"};
    String[] b1bolum3c4 = {"ayak", "kafa tutmak, cesaret", "sıklıkla", "otobüs", "kader", "ders çalışma", "hayvan", "yelpaze", "utandırmak", "yerleşmek"};
    String[] b1bolum3c5 = {"aracı", "çiftlik", "dua etmek", "yalancı", "amaç", "aksi takdirde", "halk", "inanılmaz, şaşırtıcı", "doğu", "attı"};
    String[] b1bolum3c6 = {"emniyet", "e-posta", "cilt", "köşe", "devam et", "gözyaşı", "bıçak", "maskelemek", "köprü", "yükseltmek"};
    String[] b1bolum4c1 = {"hibe", "deli", "sıçan", "dürüstçe", "gaz", "gökyüzü", "güçlü", "nakit", "terim", "teslim etmek"};
    String[] b1bolum4c2 = {"kahvaltı", "kendimizi", "ayarlamak", "bölünmüş", "kavga etti", "gölge", "taht", "tanık olmak, şahit olmak", "hazırlamak", "çiçek"};
    String[] b1bolum4c3 = {"bağırma", "kemik", "karşı, doğru", "daha ileri", "şişe, şişelemek", "pişmanlık", "daha yakın, sonlandırıcı", "yukarıda", "uykuda, tembel", "röportaj, söyleşi yapmak"};
    String[] b1bolum4c4 = {"dostum", "kariyer", "boğaz", "ısırmak", "anne", "yük, yüklemek", "rahat", "daire", "köknar", "fındık"};
    String[] b1bolum4c5 = {"acil durum", "kapüşon", "bant, şerit", "devlet başkanı", "sıkı", "adlı", "kavradı", "görev", "çince", "öğretmen"};
    String[] b1bolum4c6 = {"taze", "kamyonet", "eşleşme", "cep", "konuşma", "savunmak", "tercih etmek", "daha eski", "satıldı", "öğleden sonra"};
    String[] b1bolum5c1 = {"düşük", "kıskanç", "kör", "basınç", "toplamak", "yelken", "eklemek", "yaymak, yayılmak", "mutfak", "etkinlik"};
    String[] b1bolum5c2 = {"vuruş", "yabancı", "dev", "fırtına", "çatı", "süreç", "kök, köken", "kendisi", "renk", "hiçbir yerde"};
    String[] b1bolum5c3 = {"çan, zil, böğürmek", "çok küçük", "rusça, rus", "restoran", "birtanem", "davet et", "gevşek", "varmak", "uyudu", "bağlamak"};
    String[] b1bolum5c4 = {"yatak odası", "konuştu", "gerekli", "cihaz", "kuzen", "ay", "alev", "büyük", "kule", "krem"};
    String[] b1bolum5c5 = {"ancak", "kiralama", "parlak", "kurtarıcı", "beceri", "sinir, gergin, sinirli", "lig", "zarar", "yenilgi", "kaynak oluşturmak"};
    String[] b1bolum5c6 = {"çatlak", "çöplük, çöp dökmek", "cesur", "bıçkıcı", "daha güçlü", "kazanmak", "aramak", "kont", "tıbbi", "kayma"};
    String[] b1bolum6c1 = {"kurban", "berbat", "omuz", "diz", "yumruk", "sıra", "değil", "ruh", "boyut", "zincir"};
    String[] b1bolum6c2 = {"kıç deliği", "avukat", "nedeniyle", "muhtemelen", "savunma", "nehir", "milyar", "sarsmak, ahmak", "tabak", "sorumluluk sahibi"};
    String[] b1bolum6c3 = {"konu, özne", "mürettebat", "yarış", "girişimde bulunmak", "deha", "süt", "ipucu, bahşiş", "bağlı olmak, güvenmek", "operasyon", "gönül, his dünyası"};
    String[] b1bolum6c4 = {"üstüne", "kuru", "farkında olmak", "intikam", "şart, koşul", "asıl, büyük, başlıca", "oda arkadaşı", "alt, düşürmek", "ders", "er"};
    String[] b1bolum6c5 = {"tanıdık", "güvenli", "hizmetçi", "sonuç", "roma", "zeki", "hapis", "hava", "mart", "korkunç"};
    String[] b1bolum6c6 = {"hasar", "uygulama", "Evet, kabul oyu", "her ne zaman", "taksi", "topluluk", "hile", "askeri", "asansör, kaldırmak", "tırmanış"};
    String[] b1bolum7c1 = {"diş", "fantezi", "bozulmak, tutuklamak, iflas etmek", "bunu yapmak", "fasulye", "yüksek sesle", "mağara", "parası yetmek, gücü yetmek", "istek", "açık"};
    String[] b1bolum7c2 = {"sosyal", "dönmek", "yedek, yedeğini almak", "tanımak", "sonuçta", "tırnak", "son zamanlarda", "daha hızlı", "postalamak, ileti", "veri"};
    String[] b1bolum7c3 = {"özür", "fransızca", "fahişe", "hap", "katil", "turta", "komik", "yedek", "bilgi", "iyileşmek"};
    String[] b1bolum7c4 = {"sıkıcı", "tekerlek", "koruma", "köy", "peynir", "vahşi", "romantik", "firma", "büyüdü", "genel"};
    String[] b1bolum7c5 = {"merkez", "ödünç almak", "yaratmak, yapmak, tasarlamak, üretmek", "teknoloji", "meydan okuma", "sandviç", "etki, tesir", "tetik", "kanıt", "meşhur"};
    String[] b1bolum7c6 = {"yay, başla selamlama", "hain", "sorumluluk", "dil", "ana", "büyük", "dükkan", "yer", "salıvermek, salmak, serbest bırakmak", "toplam"};
    String[] b1bolum8c1 = {"saçma", "domuz", "ısıtmak, sıcaklık, ısı", "gizlice, sinsice", "şok", "düzenli", "puan, skor", "basitçe", "ördek", "mükemmel bir şekilde"};
    String[] b1bolum8c2 = {"ne yazık ki", "saat", "doktor", "harf harf kodlamak", "hayal kırıklığına uğratmak", "alışık, alışkın", "oyuncak", "merhamet", "yemek( past hali )", "asal"};
    String[] b1bolum8c3 = {"son günlerde", "akşam", "kaynak", "yetki", "reddetmek", "konsey", "bağ", "mühendis", "giydirmek", "sınıf"};
    String[] b1bolum8c4 = {"miktar", "korkunç", "yükselmek", "kurtarmak", "giymek", "evli", "kalkan", "borç", "hayır", "tokat"};
    String[] b1bolum8c5 = {"yerel", "saçmalık", "doğum, doğurma", "temel olarak", "yaklaşım, yaklaşmak", "bölme", "görünüm", "niyet etmek", "ödül", "sarılmak"};
    String[] b1bolum8c6 = {"sığınak", "eski", "mühür", "çare", "cennet", "kaba", "kanepe", "aniden", "günah", "değer, kıymet"};
    String[] b1bolum9c1 = {"düzine", "tebrik", "bakmak", "varsaymak, kabul etmek", "kürek çekmek", "komşu", "banyo, yıkanmak", "kızarmış ekmek", "seyahat", "soruşturma"};
    String[] b1bolum9c2 = {"iz", "ağır", "karıştırmak", "taç", "sicim, dizi, kandırmak", "çete, işbirliği yapmak", "salıncak", "gizli", "dalga", "ahbap"};
    String[] b1bolum9c3 = {"uyanık, uyanmak", "etkileyici", "kase, yuvarlamak", "civciv", "deney", "keşfetmek", "kimlik", "anlaşma", "şef", "şeytan"};
    String[] b1bolum9c4 = {"hız", "yakın arkadaş, delikanlı", "intihar", "doğa", "bir kenara", "yetişkin", "inanılmaz", "spor", "kayıp", "sıfır"};
    String[] b1bolum9c5 = {"enerji", "tünel", "çift", "cumartesi", "oldu, haline geldi", "itiraf etmek", "bilge", "sürme", "oyuncu", "işkence"};
    String[] b1bolum9c6 = {"piramit", "ilaç vermek, tedavi etmek, tıp", "orman", "elbette", "birgün", "besledi", "daha güçlü", "et", "tam, kesin", "sınır"};
    String[] b1bolum10c1 = {"ezmek", "talep", "iblis", "etkilemek", "hata, dinleme cihazı", "ağ", "lanet olası", "ceket", "dil", "tekerlek"};
    String[] b1bolum10c2 = {"terörist", "çözmek", "yetenekli", "çözmek", "üniversite", "defol", "köle", "cenaze", "genişleme", "hemşire"};
    String[] b1bolum10c3 = {"bayrak", "çözüm", "program", "değerli", "kesmek", "çıkış", "cerrahlık", "yönetmek", "fiziksel", "yemin etmek, ant içmek, yemin"};
    String[] b1bolum10c4 = {"görev", "karmaşık", "sallamak", "çukur", "gerçek", "ağırlık", "allah allah", "seksi", "sayılır, gibi", "rota"};
    String[] b1bolum10c5 = {"yön", "meydan", "oran", "madeni para", "sürücü", "cuma", "görüş, fikir", "meraklı", "çoğunlukla", "doğal"};
    String[] b1bolum10c6 = {"ödlek, korkak", "satış", "cezalandırmak", "özellik, mal mülk, emlak", "yardımcı, asistan", "ormanlarını", "dostluk", "vardiya", "yasal", "uzun boylu"};

    // Data B2

    String[] b2bolum1s1 = {"winter", "rush", "noise", "robin", "will", "anger", "sentence", "national", "mum", "sync"};
    String[] b2bolum1s2 = {"drown", "creature", "chest", "alert", "argue", "disease", "trace", "custody", "reward", "violence"};
    String[] b2bolum1s3 = {"forgotten", "drool", "divorce", "annoy", "celebrate", "rent", "grave", "locate", "meal", "version"};
    String[] b2bolum1s4 = {"cancel", "virus", "get in", "do with", "contract", "stolen", "grateful", "immediately", "airport", "dense"};
    String[] b2bolum1s5 = {"darkness", "float", "central", "ordinary", "host", "wire", "sat", "repeat", "dawn", "crowd"};
    String[] b2bolum1s6 = {"character", "texas", "loser", "fantastic", "be in", "tag", "ignore", "collect", "juice", "pee"};
    String[] b2bolum2s1 = {"dealer", "usual", "progress", "channel", "cage", "adult", "remove", "survived", "nor", "pool"};
    String[] b2bolum2s2 = {"insult", "whom", "goal", "disgust", "package", "talent", "toilet", "ugly", "medicine", "affair"};
    String[] b2bolum2s3 = {"insult", "whom", "goal", "disgust", "package", "talent", "toilet", "ugly", "medicine", "affair"};
    String[] b2bolum2s4 = {"gut", "example", "stock", "chocolate", "loyal", "season", "autotrophs", "bride", "mood", "health"};
    String[] b2bolum2s5 = {"candy", "twin", "governor", "creepy", "missy", "bright", "distract", "loyalty", "spring", "wing"};
    String[] b2bolum2s6 = {"expensive", "detect", "wherever", "wet", "higher", "false", "rude", "lieutenant", "stood", "current"};
    String[] b2bolum3s1 = {"violent", "positive", "commit", "fund", "christian", "literally", "assure", "several", "elevator", "invent"};
    String[] b2bolum3s2 = {"statement", "stair", "beauty", "professional", "fourth", "robbery", "butt", "shopping", "offense", "accord"};
    String[] b2bolum3s3 = {"mail", "launch", "angel", "holiday", "ocean", "complain", "fence", "noticed", "emotional", "gross"};
    String[] b2bolum3s4 = {"soft", "trash", "reality", "healthy", "mental", "specific", "technically", "awkward", "babe", "fruit"};
    String[] b2bolum3s5 = {"proper", "edge", "shape", "miracle", "fuel", "yellow", "stare", "print", "terrific", "patch"};
    String[] b2bolum3s6 = {"jacket", "confirm", "insist", "resource", "pet", "contain", "architect", "stage", "respond", "ought"};
    String[] b2bolum4s1 = {"drag", "entirely", "understood", "cancer", "lonely", "quarter", "comfort", "surveillance", "perform", "battery"};
    String[] b2bolum4s2 = {"vault", "classic", "belt", "insurance", "alright", "hatch", "execute", "bread", "lover", "distance"};
    String[] b2bolum4s3 = {"grandmother", "traffic", "available", "advance", "soup", "commercial", "alien", "steel", "amen", "laundry"};
    String[] b2bolum4s4 = {"sunday", "expert", "silence", "ancient", "lip", "hail", "percent", "freedom", "propose", "chosen"};
    String[] b2bolum4s5 = {"potential", "tail", "winner", "cast", "grandpa", "useful", "boom", "heir", "refuse", "technology"};
    String[] b2bolum4s6 = {"personally", "intelligence", "unbelievable", "recall", "male", "blade", "spoken", "vision", "assault", "homicide"};
    String[] b2bolum5s1 = {"sergeant", "standard", "plea", "desperate", "polic", "laser", "puzzle", "manager", "handsome", "freeze"};
    String[] b2bolum5s2 = {"victory", "nightmare", "sexual", "apply", "lack", "solid", "chat", "merry", "behavior", "extremely"};
    String[] b2bolum5s3 = {"advantage", "facility", "guilt", "frighten", "zone", "china", "dale", "affect", "surrender", "stress"};
    String[] b2bolum5s4 = {"desire", "possibility", "compare", "whisper", "flip", "doll", "baseball", "panic", "bound", "planned"};
    String[] b2bolum5s5 = {"clue", "per", "direct", "crawl", "fellow", "survivor", "grandma", "garden", "treatment", "sweat"};
    String[] b2bolum5s6 = {"equipment", "curse", "particular", "bike", "delicious", "blah", "hammer", "salt", "adventure", "accomplish"};
    String[] b2bolum6s1 = {"pitch", "license", "thief", "laid", "armor", "library", "easily", "product", "wrap", "scout"};
    String[] b2bolum6s2 = {"hostage", "breach", "recover", "negative", "courage", "temple", "judgment", "effort", "golden", "be on"};
    String[] b2bolum6s3 = {"pour", "trapped", "item", "replace", "pen", "crystal", "ability", "closet", "include", "circumstance"};
    String[] b2bolum6s4 = {"actor", "underwear", "indian", "nonsense", "downstair", "uncomfortable", "permission", "owner", "mall", "butter"};
    String[] b2bolum6s5 = {"porn", "joy", "yard", "fully", "priest", "forced", "fuckin", "blast", "sheet", "bump"};
    String[] b2bolum6s6 = {"gear", "lake", "female", "costume", "factory", "badly", "sink", "bee", "swore", "silver"};
    String[] b2bolum7s1 = {"introduce", "pure", "prevent", "nuclear", "section", "meantime", "friendly", "rare", "highly", "irrelevant"};
    String[] b2bolum7s2 = {"toss", "melt", "beast", "alliance", "selfish", "starve", "aim", "raid", "parking", "protocol"};
    String[] b2bolum7s3 = {"yay", "potato", "dick", "swim", "sugar", "cookie", "happiness", "slaughter", "tv", "get out of"};
    String[] b2bolum7s4 = {"cooper", "separate", "tour", "privacy", "image", "mirror", "goodness", "wipe", "echo", "delivery"};
    String[] b2bolum7s5 = {"bleep", "period", "waitress", "sudden", "gain", "jury", "vehicle", "snake", "fallen", "slowly"};
    String[] b2bolum7s6 = {"museum", "audition", "tale", "infect", "coincidence", "drill", "citizen", "ceremony", "brick", "tent"};
    String[] b2bolum8s1 = {"charity", "outta", "scratch", "spill", "decent", "below", "rumor", "joking", "argument", "stripper"};
    String[] b2bolum8s2 = {"chancellor", "think about", "successful", "palace", "smoking", "stomach", "presence", "rabbit", "vacation", "attend"};
    String[] b2bolum8s3 = {"champagne", "wide", "aid", "carefully", "staff", "alcohol", "represent", "appointment", "recent", "subway"};
    String[] b2bolum8s4 = {"monitor", "chemical", "activity", "success", "reveal", "raised", "horn", "lecture", "measure", "desert"};
    String[] b2bolum8s5 = {"equal", "northern", "inform", "garbage", "based", "sack", "halloween", "massage", "ash", "diamond"};
    String[] b2bolum8s6 = {"footage", "canary", "sorcerer", "flat", "warrant", "incredibly", "royal", "border", "wizard", "artist"};
    String[] b2bolum9s1 = {"pink", "directly", "wander", "swallow", "core", "blanket", "patrol", "lion", "lame", "alley"};
    String[] b2bolum9s2 = {"incident", "herd", "accuse", "dating", "employee", "valentine", "screen", "coach", "normally", "sharp"};
    String[] b2bolum9s3 = {"dirt", "garage", "pattern", "fighter", "currently", "stake", "engine", "beneath", "know about", "come in"};
    String[] b2bolum9s4 = {"unlike", "thin", "midnight", "tattoo", "quality", "satellite", "illegal", "steady", "barn", "breast"};
    String[] b2bolum9s5 = {"spider", "tax", "champion", "disturb", "capital", "manner", "regard", "purse", "dish", "yourselves"};
    String[] b2bolum9s6 = {"helpful", "hill", "neighborhood", "go on", "benefit", "aint", "habit", "safer", "asset", "counsel"};
    String[] b2bolum10s1 = {"recommend", "skip", "stink", "comment", "nation", "maid", "customer", "greater", "attract", "grandfather"};
    String[] b2bolum10s2 = {"despite", "retreat", "valuable", "oil", "stretch", "rope", "bail", "fever", "response", "testify"};
    String[] b2bolum10s3 = {"hung", "cow", "generous", "canada", "bore", "maester", "reputation", "sophia", "opposite", "shown"};
    String[] b2bolum10s4 = {"motion", "realm", "district", "someplace", "coast", "role", "barrel", "sigh", "pathetic", "hive"};
    String[] b2bolum10s5 = {"smarter", "transport", "lad", "rocket", "spit", "hyah", "worm", "physicist", "popular", "haunt"};
    String[] b2bolum10s6 = {"episode", "random", "slide", "wolf", "toe", "magazine", "terror", "sock", "missile", "knight"};


    // Data B2 Cevaplar


    String[] b2bolum1c1 = {"kış", "acele", "gürültü, ses", "narbülbülü", "niyet", "öfke, kızdırmak", "cümle, ceza vermek", "ulusal", "anne", "senkronize etmek"};
    String[] b2bolum1c2 = {"bastırmak", "yaratık", "sandık", "alarm, uyarmak", "tartışmak", "hastalık", "iz sürmek", "gözaltı", "ödül", "şiddet"};
    String[] b2bolum1c3 = {"unutulmuş", "saçmalamak", "boşanma", "rahatsız etmek", "kutlamak", "kira", "mezar", "yerleştirmek", "yemek", "versiyon"};
    String[] b2bolum1c4 = {"iptal etmek", "virüs", "binmek, içeriye girmek", "ile yapmak", "sözleşme", "çalıntı", "minnettar", "hemen", "havaalanı", "yoğun"};
    String[] b2bolum1c5 = {"karanlık", "şamandıra", "merkezi", "sıradan", "evsahibi", "tel", "oturdu", "tekrar et", "şafak", "kalabalık"};
    String[] b2bolum1c6 = {"karakter", "teksas", "ezik", "fantastik", "içeride olmak", "etiket", "aldırmamak", "toplamak", "meyve suyu", "işemek"};
    String[] b2bolum2c1 = {"satıcı", "olağan", "ilerleme", "kanal", "kafes", "yetişkin", "kaldır", "hayatta", "ne de", "havuz"};
    String[] b2bolum2c2 = {"hakaret", "kime", "hedef", "iğrenme", "paket", "yetenek", "tuvalet", "çirkin", "ilaç", "mesele, şey"};
    String[] b2bolum2c3 = {"orman", "resmi", "futbol", "kahverengi", "çekicilik", "radyasyon", "arasında", "sağlamak", "şerit, soymak, üstünü çıkarmak", "elbette"};
    String[] b2bolum2c4 = {"bağırsak", "örnek", "stok", "çikolata", "sadık", "mevsim", "ototraflar", "gelin", "ruh hali", "sağlık"};
    String[] b2bolum2c5 = {"şeker", "ikiz", "vali", "ürpertici", "küçük hanım", "parlak", "dikkatini dağıtmak", "bağlılık", "bahar", "kanat"};
    String[] b2bolum2c6 = {"pahalı", "belirlemek", "nerede olursa", "ıslak", "daha yüksek", "False", "kaba", "teğmen", "durdu", "şimdiki"};
    String[] b2bolum3c1 = {"şiddet eğilimli", "pozitif", "işlemek", "fon, sermaye", "hristiyan", "resmen", "garanti etmek", "birkaç", "asansör", "icat etmek"};
    String[] b2bolum3c2 = {"beyan", "basamak", "güzellik", "profesyonel", "dördüncü", "soygun", "popo", "alışveriş yapmak", "suç", "uymak"};
    String[] b2bolum3c3 = {"posta", "başlatmak", "melek", "tatil", "okyanus", "şikayet", "çit, kaçamaklı konuşmak", "fark", "duygusal, dokunaklı", "brüt"};
    String[] b2bolum3c4 = {"yumuşak", "çöp", "gerçeklik", "sağlıklı", "zihinsel", "özel", "teknik olarak", "beceriksiz", "bebeğim", "meyve"};
    String[] b2bolum3c5 = {"uygun, düzgün", "kenar", "şekil", "mucize", "yakıt", "sarı, sararmak", "dik dik bakmak", "baskı", "müthiş", "yama"};
    String[] b2bolum3c6 = {"ceket", "onaylamak", "ısrar etmek", "kaynak", "evcil hayvan", "içermek, kapsamak", "mimar", "sahne", "cevap vermek", "gerektiğini"};
    String[] b2bolum4c1 = {"sürüklemek", "baştan sona", "anladım, anlaşıldı", "kanser", "yalnız", "çeyrek", "konfor", "gözetim, gözetleme, gözaltı", "yapmak, uygulamak, yerine getirmek", "pil, batarya"};
    String[] b2bolum4c2 = {"tonoz", "klasik", "kemer", "sigorta", "Tamam", "kapak", "gerçekleştirmek, yerine getirmek, idam etmek", "ekmek", "sevgili", "mesafe, uzaklık"};
    String[] b2bolum4c3 = {"anneanne", "trafik", "mevcut, uygun", "ilerlemek, terfi ettirmek", "çorba", "ticari", "uzaylı", "çelik", "amin", "çamaşır"};
    String[] b2bolum4c4 = {"pazar", "uzman", "sessizlik", "eski, antik", "dudak", "selamlamak", "yüzde", "özgürlük", "teklif etmek, önermek", "seçilmiş"};
    String[] b2bolum4c5 = {"potansiyel", "kuyruk", "kazanan", "oyuncular", "dede", "işe yarar", "gümlemek, patlama sesi", "mirasçı", "reddetmek", "teknoloji"};
    String[] b2bolum4c6 = {"şahsen", "zeka", "inanılmaz", "hatırlama", "erkek", "bıçak ağzı, kılıç", "konuşulmuş", "vizyon", "saldırmak", "cinayet"};
    String[] b2bolum5c1 = {"çavuş", "standart", "savunma", "umutsuz", "polis istasyonu", "lazer", "bulmaca", "yönetici", "yakışıklı", "donmak"};
    String[] b2bolum5c2 = {"zafer", "kabus, endişe, kaygı", "cinsel", "uygulamak", "eksiklik", "katı", "sohbet", "şen", "davranış", "son derece"};
    String[] b2bolum5c3 = {"avantaj", "tesis", "suç", "korkutmak", "bölge", "çin", "vadi", "etkilemek", "teslim", "stres"};
    String[] b2bolum5c4 = {"arzu etmek", "olasılık", "karşılaştırmak", "fısıltı", "fiske", "oyuncak bebek", "beyzbol", "panik", "ciltli, bağlı, zıplamak", "planlı"};
    String[] b2bolum5c5 = {"ipucu", "her, tarafından, başına", "direkt", "yavaş ilerleme", "adam", "hayatta kalan", "büyükanne", "bahçe, bahçede çalışmak", "tedavi", "ter"};
    String[] b2bolum5c6 = {"ekipman", "lanet", "belirli", "bisiklet, bisiklet sürmek", "lezzetli", "zırva, palavra", "çekiç", "tuz", "macera", "başarmak"};
    String[] b2bolum6c1 = {"saha", "ruhsat, yetki vermek", "hırsız", "koydu", "zırh", "kütüphane", "kolayca", "ürün", "paketlemek", "izci, keşif yapmak, gözcü"};
    String[] b2bolum6c2 = {"rehin", "ihlal, karşı gelme", "kurtarmak, geri kazanmak, iyileşmek, kurtulmak", "olumsuz", "cesaret", "tapınak", "yargı", "çaba", "altın", "açık olmak, çalışmak"};
    String[] b2bolum6c3 = {"dökmek, akıtmak, dökülmek", "hapsolmuş", "madde", "yer değiştirmek, yerine geçmek", "dolma kalem", "kristal", "yetenek", "dolap", "dahil etmek", "durum, koşul"};
    String[] b2bolum6c4 = {"aktör", "iç çamaşırı", "hintli", "saçmalık", "alt kat", "rahatsız", "izin", "sahip", "alışveriş merkezi", "tereyağı"};
    String[] b2bolum6c5 = {"porno", "sevinç", "avlu", "tamamen", "rahip", "zorunlu", "lanet", "büyük patlama, infilak etmek", "tabaka", "çarpmak"};
    String[] b2bolum6c6 = {"vites", "göl", "kadın", "kostüm", "fabrika", "kötü bir şekilde", "lavabo", "bal arısı", "yemin", "gümüş"};
    String[] b2bolum7c1 = {"tanıtmak, takdim etmek", "saf", "önlemek", "nükleer", "bölüm", "bu arada", "arkadaş canlısı", "nadir", "büyük ölçüde", "ilgisiz, alakasız, konu dışı, yersiz"};
    String[] b2bolum7c2 = {"atmak", "erimek, eritmek", "canavar, hayvan", "ittifak, antlaşma", "bencil", "açlıktan öldürmek", "amaç", "baskın", "otopark", "protokol"};
    String[] b2bolum7c3 = {"yuppi", "patates", "penis", "yüzmek", "şeker", "kurabiye", "mutluluk", "katliam", "televizyon", "çıkmak"};
    String[] b2bolum7c4 = {"şarapçı, fıçılamak", "ayrı", "tur", "gizlilik", "görüntü", "ayna", "iyilik", "silme", "eko", "teslim"};
    String[] b2bolum7c5 = {"biplemek", "dönem", "bayan garson", "ani", "kazanç", "jüri", "araç", "yılan", "düşmüş", "yavaşça"};
    String[] b2bolum7c6 = {"müze", "işitme, ses sınavı yapmak", "masal", "bulaştırmak", "tesadüf", "matkap", "vatandaş", "tören", "tuğla", "çadır"};
    String[] b2bolum8c1 = {"sadaka", "-den dışarı", "çizik", "dökmek", "terbiyeli", "altında", "söylenti", "şaka", "tartışma, argüman", "striptizci"};
    String[] b2bolum8c2 = {"rektör", "uzun uzun düşünmek, aklına gelmek", "başarılı", "saray", "sigara içmek", "mide", "varlık", "tavşan", "tatil", "katılmak"};
    String[] b2bolum8c3 = {"şampanya", "geniş", "yardım etmek", "dikkatlice", "personel", "alkol", "temsil etmek", "randevu, atama, tayin", "son, yakında olan", "metro"};
    String[] b2bolum8c4 = {"izlemek", "kimyasal", "etkinlik, faaliyet", "başarı", "ortaya çıkartmak", "kalkık", "boynuz, toslamak", "ders", "ölçmek, ölçü, tedbir, önlem", "çöl"};
    String[] b2bolum8c5 = {"eşit", "kuzey", "bilgi vermek", "çöp", "merkezli, bazlı", "çuval", "cadılar bayramı", "masaj", "kül", "elmas"};
    String[] b2bolum8c6 = {"kamera görüntüsü", "kanarya", "büyücü", "düz", "garanti", "inanılmaz şekilde", "asil", "sınır, sınır koymak", "sihirbaz", "sanatçı"};
    String[] b2bolum9c1 = {"pembe", "direkt olarak", "gezmek", "yutmak", "çekirdek", "battaniye", "devriye gezmek", "aslan", "topal", "geçit"};
    String[] b2bolum9c2 = {"olay", "sürü", "suçlamak", "buluşma, tanışma, flört etme", "işçi, çalışan, personel", "sevgili", "ekran", "koç", "normalde", "keskin"};
    String[] b2bolum9c3 = {"kir", "garaj", "desen", "savaşçı", "şu anda", "kazık", "motor", "altında", "haberi olmak, bilmek", "içeri gel"};
    String[] b2bolum9c4 = {"aksine", "ince", "gece yarısı", "dövme", "kalite", "uydu", "yasadışı", "sabit", "ahır", "meme"};
    String[] b2bolum9c5 = {"örümcek", "vergi", "şampiyon", "bozmak", "başkent", "tavır", "saygı", "para kesesi", "tabak", "kendiniz"};
    String[] b2bolum9c6 = {"faydalı", "tepe", "mahalle", "devam et", "yarar, fayda", "olumsuzluk takısı, aren't", "alışkanlık", "daha güvenli", "varlık, mülk", "avukat"};
    String[] b2bolum10c1 = {"önermek", "atlamak", "pis koku", "yorum yap", "ulus", "hizmetçi", "müşteri", "daha büyük", "çekmek, cezbetmek", "büyük baba"};
    String[] b2bolum10c2 = {"rağmen", "geri çekilmek", "değerli, kıymetli", "sıvı yağ", "uzatmak", "i·p", "kefalet, kefaletle serbest bırakmak", "ateş", "tepki", "ifade vermek"};
    String[] b2bolum10c3 = {"asılı", "inek", "cömert", "kanada", "delik, bunaltmak, sıkmak", "üstat", "itibar", "sofya", "karşısında", "gösterilen"};
    String[] b2bolum10c4 = {"hareket", "diyar", "ilçe, bölge, semt", "bir yere", "sahil", "rol", "namlu, varil, uçmak", "iç çekmek", "acıklı", "kovan"};
    String[] b2bolum10c5 = {"daha akıllı", "taşıma", "delikanlı", "roket", "tükürmek", "geh", "solucan", "fizikçi", "popüler", "uğrak"};
    String[] b2bolum10c6 = {"bölüm", "rasgele", "kaymak", "kurt", "ayak parmağı", "dergi", "terör", "çorap", "füze", "şövalye"};

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

    int i =0;
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
        textToSpeech = new TextToSpeech(kelime2.this, new TextToSpeech.OnInitListener() {
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
            Intent intent = new Intent(kelime2.this,kelime2.class);
            startActivity(intent);
            finish();
        });

        mView.findViewById(R.id.next).setOnClickListener(v -> {
            if (Objects.equals(sev, "B1bölüm1s1")){
                sharedPreferences.edit().putString("seviye1","B1bölüm1s2").apply();
            } else if (Objects.equals(sev, "B1bölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm1s3").apply();
            }else if (Objects.equals(sev, "B1bölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm1s4").apply();
            }else if (Objects.equals(sev, "B1bölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm1s5").apply();
            }else if (Objects.equals(sev, "B1bölüm1s5")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm1s6").apply();
            }else if (Objects.equals(sev, "B1bölüm1s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1 Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }  if (Objects.equals(sev, "B1bölüm3s1")){
                sharedPreferences.edit().putString("seviye1","B1bölüm3s2").apply();
            } else if (Objects.equals(sev, "B1bölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm3s3").apply();
            }else if (Objects.equals(sev, "B1bölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm3s4").apply();
            }else if (Objects.equals(sev, "B1bölüm3s4")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm3s5").apply();
            }else if (Objects.equals(sev, "B1bölüm3s5")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm3s6").apply();
            }else if (Objects.equals(sev, "B1bölüm3s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            } if (Objects.equals(sev, "B1bölüm2s1")){
                sharedPreferences.edit().putString("seviye1","B1bölüm2s2").apply();
            } else if (Objects.equals(sev, "B1bölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm2s3").apply();
            }else if (Objects.equals(sev, "B1bölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm2s4").apply();
            }else if (Objects.equals(sev, "B1bölüm2s4")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm2s5").apply();
            }else if (Objects.equals(sev, "B1bölüm2s5")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm2s6").apply();
            }else if (Objects.equals(sev, "B1bölüm2s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "B1bölüm4s1")){
                sharedPreferences.edit().putString("seviye1","B1bölüm4s2").apply();
            } else if (Objects.equals(sev, "B1bölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm4s3").apply();
            }else if (Objects.equals(sev, "B1bölüm4s3")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm4s4").apply();
            }else if (Objects.equals(sev, "B1bölüm4s4")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm4s5").apply();
            }else if (Objects.equals(sev, "B1bölüm4s5")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm4s6").apply();
            }else if (Objects.equals(sev, "B1bölüm4s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "B1bölüm5s1")){
                sharedPreferences.edit().putString("seviye1","B1bölüm5s2").apply();
            } else if (Objects.equals(sev, "B1bölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm5s3").apply();
            }else if (Objects.equals(sev, "B1bölüm5s3")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm5s4").apply();
            }else if (Objects.equals(sev, "B1bölüm5s4")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm5s5").apply();
            }else if (Objects.equals(sev, "B1bölüm5s5")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm5s6").apply();
            }else if (Objects.equals(sev, "B1bölüm5s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "B1bölüm6s1")){
                sharedPreferences.edit().putString("seviye1","B1bölüm6s2").apply();
            } else if (Objects.equals(sev, "B1bölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm6s3").apply();
            }else if (Objects.equals(sev, "B1bölüm6s3")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm6s4").apply();
            }else if (Objects.equals(sev, "B1bölüm6s4")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm6s5").apply();
            }else if (Objects.equals(sev, "B1bölüm6s5")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm6s6").apply();
            }else if (Objects.equals(sev, "B1bölüm6s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "B1bölüm7s1")){
                sharedPreferences.edit().putString("seviye1","B1bölüm7s2").apply();
            } else if (Objects.equals(sev, "B1bölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm7s3").apply();
            }else if (Objects.equals(sev, "B1bölüm7s3")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm7s4").apply();
            }else if (Objects.equals(sev, "B1bölüm7s4")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm7s5").apply();
            }else if (Objects.equals(sev, "B1bölüm7s5")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm7s6").apply();
            }else if (Objects.equals(sev, "B1bölüm7s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "B1bölüm8s1")){
                sharedPreferences.edit().putString("seviye1","B1bölüm8s2").apply();
            } else if (Objects.equals(sev, "B1bölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm8s3").apply();
            }else if (Objects.equals(sev, "B1bölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm8s4").apply();
            }else if (Objects.equals(sev, "B1bölüm8s4")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm8s5").apply();
            }else if (Objects.equals(sev, "B1bölüm8s5")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm8s6").apply();
            }else if (Objects.equals(sev, "B1bölüm8s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "B1bölüm9s1")){
                sharedPreferences.edit().putString("seviye1","B1bölüm9s2").apply();
            } else if (Objects.equals(sev, "B1bölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm9s3").apply();
            }else if (Objects.equals(sev, "B1bölüm9s3")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm9s4").apply();
            }else if (Objects.equals(sev, "B1bölüm9s4")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm9s5").apply();
            }else if (Objects.equals(sev, "B1bölüm9s5")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm9s6").apply();
            }else if (Objects.equals(sev, "B1bölüm9s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "B1bölüm10s1")){
                sharedPreferences.edit().putString("seviye1","B1bölüm10s2").apply();
            } else if (Objects.equals(sev, "B1bölüm10s2")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm10s3").apply();
            }else if (Objects.equals(sev, "B1bölüm10s3")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm10s4").apply();
            }else if (Objects.equals(sev, "B1bölüm10s4")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm10s5").apply();
            }else if (Objects.equals(sev, "B1bölüm10s5")) {
                sharedPreferences.edit().putString("seviye1","B1bölüm10s6").apply();
            }else if (Objects.equals(sev, "B1bölüm10s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 10. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "B2bölüm1s1")){
                sharedPreferences.edit().putString("seviye1","B2bölüm1s2").apply();
            } else if (Objects.equals(sev, "B2bölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm1s3").apply();
            }else if (Objects.equals(sev, "B2bölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm1s4").apply();
            }else if (Objects.equals(sev, "B2bölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm1s5").apply();
            }else if (Objects.equals(sev, "B2bölüm1s5")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm1s6").apply();
            }else if (Objects.equals(sev, "B2bölüm1s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "B2bölüm2s1")){
                sharedPreferences.edit().putString("seviye1","B2bölüm2s2").apply();
            } else if (Objects.equals(sev, "B2bölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm2s3").apply();
            }else if (Objects.equals(sev, "B2bölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm2s4").apply();
            }else if (Objects.equals(sev, "B2bölüm2s4")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm2s5").apply();
            }else if (Objects.equals(sev, "B2bölüm2s5")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm2s6").apply();
            }else if (Objects.equals(sev, "B2bölüm2s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "B2bölüm3s1")){
                sharedPreferences.edit().putString("seviye1","B2bölüm3s2").apply();
            } else if (Objects.equals(sev, "B2bölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm3s3").apply();
            }else if (Objects.equals(sev, "B2bölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm3s4").apply();
            }else if (Objects.equals(sev, "B2bölüm3s4")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm3s5").apply();
            }else if (Objects.equals(sev, "B2bölüm3s5")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm3s6").apply();
            }else if (Objects.equals(sev, "B2bölüm3s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "B2bölüm4s1")){
                sharedPreferences.edit().putString("seviye1","B2bölüm4s2").apply();
            } else if (Objects.equals(sev, "B2bölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm4s3").apply();
            }else if (Objects.equals(sev, "B2bölüm4s3")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm4s4").apply();
            }else if (Objects.equals(sev, "B2bölüm4s4")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm4s5").apply();
            }else if (Objects.equals(sev, "B2bölüm4s5")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm4s6").apply();
            }else if (Objects.equals(sev, "B2bölüm4s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "B2bölüm5s1")){
                sharedPreferences.edit().putString("seviye1","B2bölüm5s2").apply();
            } else if (Objects.equals(sev, "B2bölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm5s3").apply();
            }else if (Objects.equals(sev, "B2bölüm5s3")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm5s4").apply();
            }else if (Objects.equals(sev, "B2bölüm5s4")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm5s5").apply();
            }else if (Objects.equals(sev, "B2bölüm5s5")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm5s6").apply();
            }else if (Objects.equals(sev, "B2bölüm5s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "B2bölüm6s1")){
                sharedPreferences.edit().putString("seviye1","B2bölüm6s2").apply();
            } else if (Objects.equals(sev, "B2bölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm6s3").apply();
            }else if (Objects.equals(sev, "B2bölüm6s3")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm6s4").apply();
            }else if (Objects.equals(sev, "B2bölüm6s4")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm6s5").apply();
            }else if (Objects.equals(sev, "B2bölüm6s5")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm6s6").apply();
            }else if (Objects.equals(sev, "B2bölüm6s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "B2bölüm7s1")){
                sharedPreferences.edit().putString("seviye1","B2bölüm7s2").apply();
            } else if (Objects.equals(sev, "B2bölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm7s3").apply();
            }else if (Objects.equals(sev, "B2bölüm7s3")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm7s4").apply();
            }else if (Objects.equals(sev, "B2bölüm7s4")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm7s5").apply();
            }else if (Objects.equals(sev, "B2bölüm7s5")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm7s6").apply();
            }else if (Objects.equals(sev, "B2bölüm7s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "B2bölüm8s1")){
                sharedPreferences.edit().putString("seviye1","B2bölüm8s2").apply();
            } else if (Objects.equals(sev, "B2bölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm8s3").apply();
            }else if (Objects.equals(sev, "B2bölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm8s4").apply();
            }else if (Objects.equals(sev, "B2bölüm8s4")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm8s5").apply();
            }else if (Objects.equals(sev, "B2bölüm8s5")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm8s6").apply();
            }else if (Objects.equals(sev, "B2bölüm8s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }




            if (Objects.equals(sev, "B2bölüm9s1")){
                sharedPreferences.edit().putString("seviye1","B2bölüm9s2").apply();
            } else if (Objects.equals(sev, "B2bölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm9s3").apply();
            }else if (Objects.equals(sev, "B2bölüm9s3")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm9s4").apply();
            }else if (Objects.equals(sev, "B2bölüm9s4")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm9s5").apply();
            }else if (Objects.equals(sev, "B2bölüm9s5")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm9s6").apply();
            }else if (Objects.equals(sev, "B2bölüm9s6")) {
                alertDialog.dismiss();
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                i++;
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "B2bölüm10s1")){
                sharedPreferences.edit().putString("seviye1","B2bölüm10s2").apply();
            } else if (Objects.equals(sev, "B2bölüm10s2")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm10s3").apply();
            }else if (Objects.equals(sev, "B2bölüm10s3")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm10s4").apply();
            }else if (Objects.equals(sev, "B2bölüm10s4")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm10s5").apply();
            }else if (Objects.equals(sev, "B2bölüm10s5")) {
                sharedPreferences.edit().putString("seviye1","B2bölüm10s6").apply();
            }else if (Objects.equals(sev, "B2bölüm10s6")) {
                alertDialog.dismiss();
                Toast.makeText(this, "Bölüm 10. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                i++;
                Intent intent = new Intent(kelime2.this,MainActivity5.class);
                startActivity(intent);
                finish();

            }



            if(i == 0){
                alertDialog.dismiss();
                Intent intent = new Intent(kelime2.this, kelime2.class);
                startActivity(intent);
                finish();
            }
        });
        mView.findViewById(R.id.anamenu).setOnClickListener(v -> {
            alertDialog.dismiss();
            Intent intent = new Intent(kelime2.this,MainActivity5.class);
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
        //Random Kelime //

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
                    mInterstitialAd.show(kelime2.this);
                }
            ShowDialogBox();
            if (sev.contains("B2bölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B2bölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B2bölüm1'");
            }
            if (sev.contains("B2bölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B2bölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B2bölüm2'");
            }
            if (sev.contains("B2bölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B2bölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B2bölüm3'");
            }
            if (sev.contains("B2bölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B2bölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B2bölüm4'");
            }
            if (sev.contains("B2bölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B2bölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B2bölüm5'");
            }
            if (sev.contains("B2bölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B2bölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B2bölüm6'");
            }
            if (sev.contains("B2bölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B2bölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B2bölüm7'");
            }
            if (sev.contains("B2bölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B2bölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B2bölüm8'");
            }
            if (sev.contains("B2bölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B2bölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B2bölüm9'");
            }
            if (sev.contains("B2bölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B2bölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B2bölüm10'");
            }
            if (sev.contains("B1bölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B1bölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B1bölüm1'");
            }
            if (sev.contains("B1bölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B1bölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B1bölüm2'");
            }
            if (sev.contains("B1bölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B1bölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B1bölüm3'");
            }
            if (sev.contains("B1bölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B1bölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B1bölüm4'");
            }
            if (sev.contains("B1bölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B1bölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B1bölüm5'");
            }
            if (sev.contains("B1bölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B1bölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B1bölüm6'");
            }
            if (sev.contains("B1bölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B1bölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B1bölüm7'");
            }
            if (sev.contains("B1bölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B1bölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B1bölüm8'");
            }
            if (sev.contains("B1bölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B1bölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B1bölüm9'");
            }
            if (sev.contains("B1bölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='B1bölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='B1bölüm10'");
            }
            database.execSQL("UPDATE P SET puan=puan+" + sorudogru * 2 + "");


            if (sev.equals("B1bölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm1s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm1s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm1s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm1s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm1s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm1s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm1s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm1s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm2s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm2s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm2s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm2s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm2s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm2s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm2s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm2s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm3s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm3s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm3s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm3s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm3s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm3s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm3s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm3s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm4s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm4s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm4s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm4s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm4s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm4s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm4s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm4s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm4s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm4s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm4s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm4s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm5s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm5s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm5s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm5s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm5s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm5s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm5s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm5s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm5s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm5s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm5s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm5s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm6s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm6s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm6s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm6s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm6s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm6s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm6s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm6s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm6s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm6s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm6s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm6s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm7s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm7s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm7s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm7s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm7s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm7s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm7s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm7s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm7s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm7s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm7s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm7s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm8s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm8s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm8s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm8s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm8s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm8s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm8s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm8s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm9s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm9s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm9s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm9s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm9s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm9s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm9s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm9s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm9s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm9s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm9s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm9s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm9s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm10s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm10s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm10s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm10s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm10s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm10s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm10s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm10s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm10s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm10s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm10s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm10s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm10s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm10s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm10s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm10s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm10s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm10s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm10s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm10s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B1bölüm10s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B1bölüm10s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B1bölüm10s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B1bölüm10s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm1s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm1s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm1s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm1s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm1s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm1s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm1s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm1s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm2s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm2s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm2s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm2s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm2s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm2s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm2s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm2s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm3s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm3s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm3s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm3s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm3s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm3s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm3s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm3s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm4s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm4s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm4s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm4s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm4s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm4s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm4s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm4s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm4s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm4s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm4s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm4s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm5s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm5s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm5s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm5s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm5s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm5s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm5s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm5s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm5s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm5s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm5s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm5s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm6s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm6s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm6s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm6s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm6s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm6s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm6s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm6s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm6s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm6s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm6s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm6s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm7s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm7s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm7s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm7s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm7s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm7s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm7s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm7s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm7s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm7s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm7s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm7s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm8s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm8s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm8s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm8s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm8s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm8s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm8s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm8s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm9s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm9s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm9s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm9s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm9s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm9s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm9s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm9s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm9s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm9s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm9s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm9s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm9s6yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm10s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm10s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm10s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm10s1yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm10s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm10s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm10s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm10s2yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm10s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm10s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm10s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm10s3yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm10s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm10s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm10s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm10s4yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm10s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm10s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm10s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm10s5yildiz", "2").apply();
                }
            }
            if (sev.equals("B2bölüm10s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("B2bölüm10s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("B2bölüm10s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("B2bölüm10s6yildiz", "2").apply();
                }
            }


            // SORU EKRANI

        } else if (Objects.equals(sev, "B1bölüm1s1")) {
            soru1 = new Soru(b1bolum1s1[sorusay], b1bolum1c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();

        }else if (Objects.equals(sev, "B1bölüm1s2")){
            soru1 = new Soru(b1bolum1s2[sorusay], b1bolum1c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm1s3")){
            soru1 = new Soru(b1bolum1s3[sorusay], b1bolum1c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm1s4")){
            soru1 = new Soru(b1bolum1s4[sorusay], b1bolum1c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm1s5")){
            soru1 = new Soru(b1bolum1s5[sorusay], b1bolum1c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm1s6")){
            soru1 = new Soru(b1bolum1s6[sorusay], b1bolum1c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev,"B1bölüm2s1")){
            soru1 = new Soru(b1bolum2s1[sorusay], b1bolum2c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm2s2")){
            soru1 = new Soru(b1bolum2s2[sorusay], b1bolum2c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm2s3")){
            soru1 = new Soru(b1bolum2s3[sorusay], b1bolum2c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm2s4")){
            soru1 = new Soru(b1bolum2s4[sorusay], b1bolum2c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm2s5")){
            soru1 = new Soru(b1bolum2s5[sorusay], b1bolum2c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm2s6")){
            soru1 = new Soru(b1bolum2s6[sorusay], b1bolum2c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm3s1")){
            soru1 = new Soru(b1bolum3s1[sorusay], b1bolum3c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm3s2")){
            soru1 = new Soru(b1bolum3s2[sorusay], b1bolum3c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm3s3")){
            soru1 = new Soru(b1bolum3s3[sorusay], b1bolum3c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm3s4")){
            soru1 = new Soru(b1bolum3s4[sorusay], b1bolum3c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm3s5")){
            soru1 = new Soru(b1bolum3s5[sorusay], b1bolum3c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm3s6")){
            soru1 = new Soru(b1bolum3s6[sorusay], b1bolum3c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm4s1")){
            soru1 = new Soru(b1bolum4s1[sorusay], b1bolum4c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm4s2")){
            soru1 = new Soru(b1bolum4s2[sorusay], b1bolum4c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm4s3")){
            soru1 = new Soru(b1bolum4s3[sorusay], b1bolum4c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm4s4")){
            soru1 = new Soru(b1bolum4s4[sorusay], b1bolum4c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm4s5")){
            soru1 = new Soru(b1bolum4s5[sorusay], b1bolum4c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm4s6")){
            soru1 = new Soru(b1bolum4s6[sorusay], b1bolum4c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm5s1")){
            soru1 = new Soru(b1bolum5s1[sorusay], b1bolum5c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm5s2")){
            soru1 = new Soru(b1bolum5s2[sorusay], b1bolum5c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm5s3")){
            soru1 = new Soru(b1bolum5s3[sorusay], b1bolum5c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm5s4")){
            soru1 = new Soru(b1bolum5s4[sorusay], b1bolum5c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm5s5")){
            soru1 = new Soru(b1bolum5s5[sorusay], b1bolum5c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm5s6")){
            soru1 = new Soru(b1bolum5s6[sorusay], b1bolum5c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm6s1")){
            soru1 = new Soru(b1bolum6s1[sorusay], b1bolum6c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm6s2")){
            soru1 = new Soru(b1bolum6s2[sorusay], b1bolum6c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm6s3")){
            soru1 = new Soru(b1bolum6s3[sorusay], b1bolum6c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm6s4")){
            soru1 = new Soru(b1bolum6s4[sorusay], b1bolum6c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm6s5")){
            soru1 = new Soru(b1bolum6s5[sorusay], b1bolum6c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm6s6")){
            soru1 = new Soru(b1bolum6s1[sorusay], b1bolum6c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm7s1")){
            soru1 = new Soru(b1bolum7s1[sorusay], b1bolum7c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm7s2")){
            soru1 = new Soru(b1bolum7s2[sorusay], b1bolum7c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm7s3")){
            soru1 = new Soru(b1bolum7s3[sorusay], b1bolum7c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm7s4")){
            soru1 = new Soru(b1bolum7s4[sorusay], b1bolum7c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm7s5")){
            soru1 = new Soru(b1bolum7s5[sorusay], b1bolum7c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm7s6")){
            soru1 = new Soru(b1bolum7s6[sorusay], b1bolum7c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm8s1")){
            soru1 = new Soru(b1bolum8s1[sorusay], b1bolum8c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm8s2")){
            soru1 = new Soru(b1bolum8s2[sorusay], b1bolum8c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm8s3")){
            soru1 = new Soru(b1bolum8s3[sorusay], b1bolum8c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm8s4")){
            soru1 = new Soru(b1bolum8s4[sorusay], b1bolum8c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm8s5")){
            soru1 = new Soru(b1bolum8s5[sorusay], b1bolum8c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm8s6")){
            soru1 = new Soru(b1bolum8s6[sorusay], b1bolum8c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm9s1")){
            soru1 = new Soru(b1bolum9s1[sorusay], b1bolum9c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm9s2")){
            soru1 = new Soru(b1bolum9s2[sorusay], b1bolum9c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm9s3")){
            soru1 = new Soru(b1bolum9s3[sorusay], b1bolum9c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm9s4")){
            soru1 = new Soru(b1bolum9s4[sorusay], b1bolum9c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm9s5")){
            soru1 = new Soru(b1bolum9s5[sorusay], b1bolum9c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm9s6")){
            soru1 = new Soru(b1bolum9s6[sorusay], b1bolum9c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm10s1")){
            soru1 = new Soru(b1bolum10s1[sorusay], b1bolum10c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm10s2")){
            soru1 = new Soru(b1bolum10s2[sorusay], b1bolum10c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm10s3")){
            soru1 = new Soru(b1bolum10s3[sorusay], b1bolum10c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm10s4")){
            soru1 = new Soru(b1bolum10s4[sorusay], b1bolum10c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm10s5")){
            soru1 = new Soru(b1bolum10s5[sorusay], b1bolum10c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B1bölüm10s6")){
            soru1 = new Soru(b1bolum10s6[sorusay], b1bolum10c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "B2bölüm1s1")){
        soru1 = new Soru(b2bolum1s1[sorusay], b2bolum1c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm1s2")){
        soru1 = new Soru(b2bolum1s2[sorusay], b2bolum1c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm1s3")){
        soru1 = new Soru(b2bolum1s3[sorusay], b2bolum1c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm1s4")){
        soru1 = new Soru(b2bolum1s4[sorusay], b2bolum1c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm1s5")){
        soru1 = new Soru(b2bolum1s5[sorusay], b2bolum1c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm1s6")){
        soru1 = new Soru(b2bolum1s6[sorusay], b2bolum1c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm2s1")){
        soru1 = new Soru(b2bolum2s1[sorusay], b2bolum2c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm2s2")){
        soru1 = new Soru(b2bolum2s2[sorusay], b2bolum2c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm2s3")){
        soru1 = new Soru(b2bolum2s3[sorusay], b2bolum2c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm2s4")){
        soru1 = new Soru(b2bolum2s4[sorusay], b2bolum2c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm2s5")){
        soru1 = new Soru(b2bolum2s5[sorusay], b2bolum2c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm2s6")){
        soru1 = new Soru(b2bolum2s6[sorusay], b2bolum2c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm3s1")){
        soru1 = new Soru(b2bolum3s1[sorusay], b2bolum3c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm3s2")){
        soru1 = new Soru(b2bolum3s2[sorusay], b2bolum3c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm3s3")){
        soru1 = new Soru(b2bolum3s3[sorusay], b2bolum3c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm3s4")){
        soru1 = new Soru(b2bolum3s4[sorusay], b2bolum3c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm3s5")){
        soru1 = new Soru(b2bolum3s5[sorusay], b2bolum3c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm3s6")){
        soru1 = new Soru(b2bolum3s6[sorusay], b2bolum3c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm4s1")){
        soru1 = new Soru(b2bolum4s1[sorusay], b2bolum4c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm4s2")){
        soru1 = new Soru(b2bolum4s2[sorusay], b2bolum4c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm4s3")){
        soru1 = new Soru(b2bolum4s3[sorusay], b2bolum4c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm4s4")){
        soru1 = new Soru(b2bolum4s4[sorusay], b2bolum4c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm4s5")){
        soru1 = new Soru(b2bolum4s5[sorusay], b2bolum4c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm4s6")){
        soru1 = new Soru(b2bolum4s6[sorusay], b2bolum4c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm5s1")){
        soru1 = new Soru(b2bolum5s1[sorusay], b2bolum5c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm5s2")){
        soru1 = new Soru(b2bolum5s2[sorusay], b2bolum5c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm5s3")){
        soru1 = new Soru(b2bolum5s3[sorusay], b2bolum5c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm5s4")){
        soru1 = new Soru(b2bolum5s4[sorusay], b2bolum5c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm5s5")){
        soru1 = new Soru(b2bolum5s5[sorusay], b2bolum5c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm5s6")){
        soru1 = new Soru(b2bolum5s6[sorusay], b2bolum5c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm6s1")){
        soru1 = new Soru(b2bolum6s1[sorusay], b2bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm6s2")){
        soru1 = new Soru(b2bolum6s2[sorusay], b2bolum6c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm6s3")){
        soru1 = new Soru(b2bolum6s3[sorusay], b2bolum6c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm6s4")){
        soru1 = new Soru(b2bolum6s4[sorusay], b2bolum6c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm6s5")){
        soru1 = new Soru(b2bolum6s5[sorusay], b2bolum6c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm6s6")){
        soru1 = new Soru(b2bolum6s1[sorusay], b2bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm7s1")){
        soru1 = new Soru(b2bolum7s1[sorusay], b2bolum7c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm7s2")){
        soru1 = new Soru(b2bolum7s2[sorusay], b2bolum7c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm7s3")){
        soru1 = new Soru(b2bolum7s3[sorusay], b2bolum7c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm7s4")){
        soru1 = new Soru(b2bolum7s4[sorusay], b2bolum7c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm7s5")){
        soru1 = new Soru(b2bolum7s5[sorusay], b2bolum7c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm7s6")){
        soru1 = new Soru(b2bolum7s6[sorusay], b2bolum7c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm8s1")){
        soru1 = new Soru(b2bolum8s1[sorusay], b2bolum8c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm8s2")){
        soru1 = new Soru(b2bolum8s2[sorusay], b2bolum8c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm8s3")){
        soru1 = new Soru(b2bolum8s3[sorusay], b2bolum8c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm8s4")){
        soru1 = new Soru(b2bolum8s4[sorusay], b2bolum8c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm8s5")){
        soru1 = new Soru(b2bolum8s5[sorusay], b2bolum8c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm8s6")){
        soru1 = new Soru(b2bolum8s6[sorusay], b2bolum8c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm9s1")){
        soru1 = new Soru(b2bolum9s1[sorusay], b2bolum9c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm9s2")){
        soru1 = new Soru(b2bolum9s2[sorusay], b2bolum9c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm9s3")){
        soru1 = new Soru(b2bolum9s3[sorusay], b2bolum9c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm9s4")){
        soru1 = new Soru(b2bolum9s4[sorusay], b2bolum9c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        } else if (Objects.equals(sev, "B2bölüm9s5")){
        soru1 = new Soru(b1bolum9s5[sorusay], b1bolum9c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm9s6")){
        soru1 = new Soru(b2bolum9s6[sorusay], b2bolum9c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm10s1")){
        soru1 = new Soru(b2bolum10s1[sorusay], b2bolum10c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm10s2")){
        soru1 = new Soru(b2bolum10s2[sorusay], b2bolum10c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm10s3")){
        soru1 = new Soru(b2bolum10s3[sorusay], b2bolum10c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm10s4")){
        soru1 = new Soru(b2bolum10s4[sorusay], b2bolum10c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm10s5")){
        soru1 = new Soru(b2bolum10s5[sorusay], b2bolum10c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "B2bölüm10s6")){
        soru1 = new Soru(b2bolum10s6[sorusay], b2bolum10c6[sorusay], yanlislar3, yanlislar4);
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

