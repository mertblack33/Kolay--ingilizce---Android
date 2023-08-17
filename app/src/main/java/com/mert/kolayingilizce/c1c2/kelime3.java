package com.mert.kolayingilizce.c1c2;

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

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class kelime3 extends AppCompatActivity {
    // Data C1
    int i =0;
    String[] c1bolum1s1 = {"sticker", "exam", "rebel", "treaty", "smack", "wingman", "lookout", "motorcycle", "bedtime", "asian"};
    String[] c1bolum1s2 = {"silk", "homeland", "ink", "alongside", "retire", "circuit", "sixth", "germany", "maintenance", "shiny"};
    String[] c1bolum1s3 = {"torch", "acceptable", "manual", "sarcasm", "anticipate", "alternate", "withdraw", "pork", "secretly", "poet"};
    String[] c1bolum1s4 = {"rubbish", "partnership", "vegetable", "earthquake", "musical", "promotion", "elbow", "outer", "unacceptable", "mankind"};
    String[] c1bolum1s5 = {"reduce", "foul", "imprison", "wrath", "vet", "stitch", "lightly", "douche", "skank", "thieves"};
    String[] c1bolum1s6 = {"glorious", "vital", "advisor", "straighten", "declare", "tomb", "shining", "pointless", "cardinal", "rice"};
    String[] c1bolum2s1 = {"ant", "launder", "barge", "freckle", "filed", "finance", "pay for", "ex", "according", "solved"};
    String[] c1bolum2s2 = {"intern", "payroll", "antique", "vatican", "override", "association", "backyard", "info", "parked", "unstable"};
    String[] c1bolum2s3 = {"restrain", "handful", "circus", "meetings", "forensic", "psychiatrist", "stag", "messy", "cartoon", "radius"};
    String[] c1bolum2s4 = {"dose", "exposure", "ruling", "grass", "jewelry", "examine", "jewel", "mummy", "dine", "youth"};
    String[] c1bolum2s5 = {"protective", "presume", "column", "unpleasant", "heroic", "foundation", "aspect", "hardest", "gladly", "keen"};
    String[] c1bolum2s6 = {"bruise", "depart", "announcement", "laughter", "antidote", "lease", "anxious", "described", "pepper", "accompany"};
    String[] c1bolum3s1 = {"generally", "toll", "tit", "fifty", "youngest", "independent", "shutting", "elsewhere", "safest", "urge"};
    String[] c1bolum3s2 = {"helium", "lethal", "aggressive", "dove", "hereby", "crib", "louder", "lend", "controlled", "discount"};
    String[] c1bolum3s3 = {"janitor", "magnetic", "passport", "transferred", "look for", "turn out", "came in", "valley", "stay in", "go down"};
    String[] c1bolum3s4 = {"narcotic", "councilman", "closure", "experimental", "rental", "inject", "thankful", "flank", "glue", "tan"};
    String[] c1bolum3s5 = {"strain", "explore", "maiden", "chin", "cabinet", "annual", "awhile", "shade", "maniac", "provided"};
    String[] c1bolum3s6 = {"thread", "turtle", "prophecy", "flee", "disabled", "verdict", "piano", "hydrogen", "resolve", "eastern"};
    String[] c1bolum4s1 = {"rarely", "journalist", "raw", "purchase", "grease", "sensor", "sushi", "institution", "pronounce", "liver"};
    String[] c1bolum4s2 = {"relation", "thai", "investigate", "immortal", "theoretical", "sexually", "imaginary", "exploit", "mercenary", "rack"};
    String[] c1bolum4s3 = {"depth", "via", "pose", "divide", "flea", "suite", "revolution", "goddess", "brothel", "spark"};
    String[] c1bolum4s4 = {"consent", "payback", "slim", "celebrating", "cracker", "replacement", "filter", "reckless", "confusion", "sinner"};
    String[] c1bolum4s5 = {"scheduled", "mentor", "genuine", "tray", "graduate", "behold", "thou", "pancakes", "administration", "tactic"};
    String[] c1bolum4s6 = {"gimme", "presentation", "soil", "prep", "maze", "fundraiser", "autopsy", "anomaly", "nickel", "refrigerator"};
    String[] c1bolum5s1 = {"naughty", "salary", "accountant", "adoption", "live with", "rip", "show up", "dreamland", "snap", "kitty"};
    String[] c1bolum5s2 = {"look after", "bluff", "gallon", "inspector", "investor", "encrypt", "fugitive", "lighthouse", "user", "domestic"};
    String[] c1bolum5s3 = {"donation", "hike", "bass", "appetite", "olive", "captive", "creative", "outsider", "peel", "rising"};
    String[] c1bolum5s4 = {"broad", "continued", "jammed", "tissue", "praise", "spared", "squire", "invasion", "delusion", "twelve"};
    String[] c1bolum5s5 = {"causing", "disappointment", "cigar", "rigged", "absurd", "origin", "tammy", "efficient", "whatsoever", "occupy"};
    String[] c1bolum5s6 = {"resistance", "limb", "profession", "lazy", "sympathy", "substance", "banker", "premise", "protest", "boundary"};
    String[] c1bolum6s1 = {"crab", "creation", "weed", "shatter", "vessel", "crappy", "ransom", "additional", "elegant", "scrape"};
    String[] c1bolum6s2 = {"rooftop", "stadium", "longest", "faint", "stepping", "sum", "mushroom", "guild", "furious", "roast"};
    String[] c1bolum6s3 = {"craft", "unnecessary", "timeline", "satisfaction", "tore", "raising", "container", "leaf", "intact", "herb"};
    String[] c1bolum6s4 = {"submarine", "july", "reinforcement", "intervention", "delightful", "beam", "hardware", "cocaine", "luggage", "swan"};
    String[] c1bolum6s5 = {"classes", "move on", "get away", "be out", "exciting", "pleas", "sit down", "get into", "come up", "faced"};
    String[] c1bolum6s6 = {"prosecution", "briefcase", "encryption", "unleash", "teenage", "pencil", "confidential", "strongly", "rehab", "autograph"};
    String[] c1bolum7s1 = {"geology", "vagina", "favourite", "whereabouts", "permanently", "mica", "sip", "buckle", "blink", "audio"};
    String[] c1bolum7s2 = {"dutch", "break in", "maximum", "brass", "tension", "scissor", "fragile", "kindness", "agenda", "salmon"};
    String[] c1bolum7s3 = {"chatter", "wealth", "breed", "innocence", "convert", "lust", "hut", "despair", "institute", "construct"};
    String[] c1bolum7s4 = {"coconut", "recognized", "granddaughter", "pickup", "differ", "willingly", "author", "corps", "legally", "descend"};
    String[] c1bolum7s5 = {"africa", "bowel", "slavery", "maple", "shampoo", "interfere", "intellectual", "breakthrough", "difficulty", "nun"};
    String[] c1bolum7s6 = {"reserv", "remorse", "tide", "goose", "decay", "orchid", "economy", "toxin", "spite", "growth"};
    String[] c1bolum8s1 = {"helpless", "restrict", "valid", "horizon", "outnumber", "closely", "spi", "swimming", "bush", "riot"};
    String[] c1bolum8s2 = {"rotten", "ladder", "approximately", "destination", "correctly", "mechanic", "consistent", "shook", "denial", "underestimate"};
    String[] c1bolum8s3 = {"stir", "hump", "grind", "infirmary", "courthouse", "interference", "insect", "artificial", "elephant", "recognise"};
    String[] c1bolum8s4 = {"cricket", "detector", "courtroom", "strawberry", "drugged", "casualties", "servers", "give it to", "bob", "troll"};
    String[] c1bolum8s5 = {"draco", "lockup", "tennis", "caller", "sociopath", "prescription", "clearance", "brisket", "chemist", "environmental"};
    String[] c1bolum8s6 = {"reader", "quarantine", "stroll", "mere", "setup", "in addition", "apple", "cease", "sorrow", "heavily"};
    String[] c1bolum9s1 = {"graveyard", "thorough", "framed", "caution", "policeman", "crossbow", "scatter", "hose", "smuggler", "burner"};
    String[] c1bolum9s2 = {"sundown", "chernobyl", "greedy", "integrity", "tequila", "traveler", "snore", "intervene", "analyze", "lantern"};
    String[] c1bolum9s3 = {"vanilla", "beverage", "shipping", "negotiation", "costum", "judged", "priestess", "hottest", "seventh", "undo"};
    String[] c1bolum9s4 = {"enlist", "elect", "imminent", "universal", "pottery", "ribbon", "addiction", "lone", "wage", "grill"};
    String[] c1bolum9s5 = {"radioactive", "happiest", "wield", "mermaid", "oops", "sewer", "dignity", "gunfire", "vast", "kin"};
    String[] c1bolum9s6 = {"doorstep", "telephone", "grain", "minus", "sleeve", "mattress", "confusing", "intruder", "lawsuit", "cushion"};
    String[] c1bolum10s1 = {"psychological", "scanner", "cranky", "stripe", "electromagnetic", "navy", "organized", "ongoing", "mexico", "dementors"};
    String[] c1bolum10s2 = {"put on", "con", "doom", "go away", "tab", "medium", "sticky", "restroom", "receipt", "underwater"};
    String[] c1bolum10s3 = {"cramp", "pageant", "lipstick", "remedy", "expertise", "controlling", "strict", "struggling", "sedative", "southwest"};
    String[] c1bolum10s4 = {"reset", "improvement", "utterly", "vouch", "parole", "agony", "reverend", "lurk", "formal", "wooden"};
    String[] c1bolum10s5 = {"fitting", "strictly", "assassinate", "conclave", "marrow", "understandable", "fifteen", "executive", "moan", "fiction"};
    String[] c1bolum10s6 = {"biological", "buffet", "boost", "skate", "telescope", "reopen", "sparrow", "disobey", "skeleton", "spice"};


    // Data C1 Cevaplar


    String[] c1bolum1c1 = {"etiket", "sınav", "asi", "antlaşma", "şaplak", "yancı", "gözleme, gözculuk yapma", "motosiklet", "yatma zamanı", "asyalı"};
    String[] c1bolum1c2 = {"ipek", "vatan", "mürekkep", "yanında", "emekli olmak", "devre", "altıncı", "almanya", "bakım", "parlak"};
    String[] c1bolum1c3 = {"meşale", "kabul edilebilir", "manuel", "iğneleme", "beklemek, ummak", "alternatif, sıra ile yapmak", "çekil", "domuz eti", "gizlice", "şair"};
    String[] c1bolum1c4 = {"döküntü, çöp, enkaz, moloz", "ortaklık", "sebze", "deprem", "müzikal", "tanıtım", "dirsek", "dış", "kabul edilemez", "insanlık"};
    String[] c1bolum1c5 = {"azaltmak", "faul", "hapsetmek", "gazap", "veteriner", "dikiş", "hafifçe", "şırınga", "sürtük", "hırsızlar"};
    String[] c1bolum1c6 = {"şanlı", "hayati", "Danışman", "düzleştirmek", "bildirmek", "mezar", "parlıyor", "anlamsız", "kardinal", "pirinç"};
    String[] c1bolum2c1 = {"karınca", "aklamak", "duba, içeri dalmak", "çil", "dosyalanmış", "maliyei finans, finanse etmek", "ödemek", "eski", "göre", "çözülmüş"};
    String[] c1bolum2c2 = {"stajyer", "maaş bordrosu", "antika", "vatikan", "geçersiz kılma", "dernek", "arka bahçe", "bilgi", "park etmiş, beklemede", "kararsız"};
    String[] c1bolum2c3 = {"dizginlemek", "avuç", "sirk", "toplantılar", "adli", "psikiyatrist", "erkeklere özel", "dağınık", "karikatür", "yarıçap"};
    String[] c1bolum2c4 = {"doz", "maruz kalma, teşhir, poz", "yonetmek", "çimen", "takı", "muayene etmek", "mücevher", "mumya", "yemek", "gençlik"};
    String[] c1bolum2c5 = {"koruyucu", "varsaymak", "kolon, sütun", "hoş olmayan", "kahraman", "yapı temeli", "görünüş", "en zor", "memnuniyetle", "keskin"};
    String[] c1bolum2c6 = {"çürük, zedelemek", "ayrılmak", "duyuru, ilan", "kahkaha", "panzehir", "kiralama", "endişeli", "tarif edilen", "biber", "eşlik etmek"};
    String[] c1bolum3c1 = {"genellikle", "geçiş ücreti", "meme, meme başı", "elli", "en genç", "bağımsız", "kapatma", "başka yerde", "en güvenli", "dürtü"};
    String[] c1bolum3c2 = {"helyum", "öldürücü", "agresif, saldırgan", "güvercin", "bu vesile ile", "beşik", "yüksek sesle", "ödünç vermek", "kontrollü", "indirim"};
    String[] c1bolum3c3 = {"kapıcı", "manyetik", "pasaport", "transfer", "aramak", "sonuçlanmak", "içeri geldi", "vadi", "kal", "aşağı in"};
    String[] c1bolum3c4 = {"narkotik", "meclis üyesi", "kapatma", "deneysel", "kiralık", "enjekte etmek", "müteşekkir", "böğür", "tutkal", "bronzlaştırmak, dövmek"};
    String[] c1bolum3c5 = {"gerginlik", "keşfetmek", "bakire, bekar", "çene", "kabine", "yıllık", "bir süre", "gölge", "manyak", "sağlanan"};
    String[] c1bolum3c6 = {"konu", "kaplumbağa", "kehanet", "kaçmak", "engelli", "karar", "piyano", "hidrojen", "çözmek, gidermek, çözümlemek", "doğu"};
    String[] c1bolum4c1 = {"seyrek", "gazeteci", "çiğ, ham", "satın alma", "gres", "algılayıcı", "suşi", "kurum", "telaffuz", "karaciğer"};
    String[] c1bolum4c2 = {"ilişki", "tayland", "incelemek", "ölümsüz", "teorik", "cinsel", "hayali", "sömürmek", "paralı", "raf"};
    String[] c1bolum4c3 = {"derinlik", "üzerinden", "poz", "bölmek", "pire", "süit", "devrim", "tanrıça", "genelev", "kıvılcım"};
    String[] c1bolum4c4 = {"razı olmak", "geri ödeme", "ince", "kutluyor", "kraker", "değiştirme", "filtre", "umursamaz", "karışıklık", "günahkâr"};
    String[] c1bolum4c5 = {"tarifeli", "akıl hocası", "hakiki", "tepsi", "mezun olmak", "dikkatle bakmak", "sen", "krep", "yönetim", "taktik"};
    String[] c1bolum4c6 = {"çocuk oyuncağı, yat benimle", "sunum", "toprak", "hazırlık", "labirent", "bağış", "otopsi", "anomali", "nikel", "buzdolabı"};
    String[] c1bolum5c1 = {"yaramaz", "maaş", "muhasebeci", "benimseme, evlat edinme", "birlikte yaşamak", "huzur içinde yatsın", "ortaya çıkmak", "hayaller ülkesi", "ani", "yavru kedi"};
    String[] c1bolum5c2 = {"ilgilenmek", "blöf yapmak", "galon", "müfettiş", "yatırımcı", "şifrelemek", "firari", "fener", "kullanıcı", "yerli, iç, evcil"};
    String[] c1bolum5c3 = {"bağış", "yürüyüş", "bas", "iştah", "zeytin", "esir", "yaratıcı", "yabancı", "kabuk", "yükselen"};
    String[] c1bolum5c4 = {"geniş", "devam etti", "sıkışmış", "doku", "övgü", "kurtulmuş", "bey", "istila", "kuruntu", "on iki"};
    String[] c1bolum5c5 = {"neden olan", "hayal kırıklığı", "puro", "hileli", "saçma", "menşei", "bere", "verimli", "hangi, herhangi bir", "işgal etmek"};
    String[] c1bolum5c6 = {"direnç", "uzuv", "meslek", "tembel", "sempati", "madde, cisim", "bankacı", "öncül", "protesto", "sınır"};
    String[] c1bolum6c1 = {"yengeç", "oluşturma", "ot", "çatlamak, çatlatmak", "gemi", "berbat", "fidye", "ek", "zarif", "kazımak"};
    String[] c1bolum6c2 = {"çatı", "stadyum", "en uzun", "baygın", "adım", "toplam", "mantar", "lonca", "öfkeli", "rosto"};
    String[] c1bolum6c3 = {"zanaat", "gereksiz", "zaman çizelgesi", "memnuniyet", "yırttı", "yükselen", "konteyner", "yaprak", "dokunulmamış, el değmemiş", "ot"};
    String[] c1bolum6c4 = {"denizaltı", "temmuz", "güçlendirme", "müdahale", "hoş", "ışın, kiriş", "donanım", "kokain", "valiz", "kuğu"};
    String[] c1bolum6c5 = {"sınıflar", "devam et", "kurtulmak!", "söz konusu olmamak, bitmiş olmak, çıkmak", "heyecan verici", "yakarışlarıyla", "otur", "içine girmek", "ortaya çıkmak", "yüzlü"};
    String[] c1bolum6c6 = {"ilerletme, sürdürme", "evrak çantası", "şifreleme", "salıvermek, serbest bırakmak", "genç", "kalem", "gizli", "şiddetle", "rehabilitasyon", "imzalamak"};
    String[] c1bolum7c1 = {"jeoloji", "vajina", "favori", "nerelerde", "kalıcı olarak", "mika, yalıtkan", "yudum", "toka, ilişkilendirmek", "göz kırpmak, yanıp sönmek", "ses"};
    String[] c1bolum7c2 = {"flemenkçe", "sözünü kesmek", "maksimum", "pirinç", "gerginlik", "makasla kesmek", "kırılgan", "iyilik", "gündem", "somon"};
    String[] c1bolum7c3 = {"gevezelik", "servet", "doğurmak", "saflık, masumiyet", "dönüştürmek", "şehvet", "kulübe", "umutsuzluk", "enstitü", "kurmak"};
    String[] c1bolum7c4 = {"hindistan cevizi", "tanınan", "kız torun", "almak", "farklılık", "isteyerek", "yazar", "kolordu", "yasal olarak", "inmek"};
    String[] c1bolum7c5 = {"Afrika", "bağırsak", "kölelik", "akçaağaç", "şampuan", "karışmak", "entellektüel", "atılım", "zorluk", "rahibe"};
    String[] c1bolum7c6 = {"rezerv", "vicdan azabı", "gelgit", "kaz", "çürüme", "orkide", "ekonomi", "toksin", "nispet", "büyüme"};
    String[] c1bolum8c1 = {"çaresiz", "kısıtlamak", "geçerli", "ufuk", "fazla gelmek", "yakından", "spektropolarimetrik görüntüleme", "yüzme", "çalı, orman, kırsal, kaplamak", "isyan"};
    String[] c1bolum8c2 = {"çürük", "merdiven", "yaklaşık olarak", "hedef", "doğru şekilde", "tamirci", "tutarlı, istikrarlı", "salladı", "ret", "azımsamak"};
    String[] c1bolum8c3 = {"karıştırmak", "kambur, kamburluk", "eziyet", "revir", "adliye", "girişim", "böcek", "yapay", "fil", "tanımak"};
    String[] c1bolum8c4 = {"kriket", "detektör", "mahkeme salonu", "çilek", "uyuşturulmuş", "kayıplar", "sunucular", "vermek", "inip çıkmak", "trol"};
    String[] c1bolum8c5 = {"drakon", "kilitlemek", "tenis", "arayan", "sosyopat", "reçete", "boşluk", "döş", "eczacı", "çevre"};
    String[] c1bolum8c6 = {"okuyucu", "karantina", "gezinti", "sırf", "kurmak", "ek olarak", "elma", "durdurmak, vazgeçmek, son vermek", "üzüntü", "ağır şekilde"};
    String[] c1bolum9c1 = {"mezarlık", "tam", "iskeletli, çerçeveli", "uyarmak, ihtar etmek, dikkat çekmek", "polis", "yaylı tüfek", "saçmak, dağıtmak", "hortum", "kaçakçı", "yakıcı"};
    String[] c1bolum9c2 = {"gün batımı", "çernobil", "açgözlü", "bütünlük", "tekila", "gezgin", "horlama", "araya girmek", "analiz etmek", "fener"};
    String[] c1bolum9c3 = {"vanilya", "içecek", "nakliye", "müzakere", "kostüm", "yargılanır", "rahibe", "sıcak", "yedinci", "geri alma"};
    String[] c1bolum9c4 = {"kaydetmek", "seçmek, seçilmiş", "eli kulağında, pek yakın", "evrensel", "çömlekçilik", "kurdele", "bağımlılık", "yalnız", "ücret", "ızgara"};
    String[] c1bolum9c5 = {"radyoaktif", "en mutlu", "kullanmak", "deniz kızı", "ayy", "lağım", "haysiyet, onur", "top ateşi", "muazzam", "soydaş"};
    String[] c1bolum9c6 = {"eşik, basamak, kapı önü", "telefon", "tahıl", "eksi", "kol", "yatak", "kafa karıştırıcı", "davetsiz misafir", "dava", "minder"};
    String[] c1bolum10c1 = {"psikolojik", "tarayıcı", "huysuz", "şerit", "elektromanyetik", "donanma", "örgütlü", "devam eden", "meksika", "ruh emiciler"};
    String[] c1bolum10c2 = {"giymek", "aleyhte", "kıyamet, felaket, dehşet", "çekip gitmek, defolmak, terk etmek", "çıkıntı", "orta", "yapışkan", "tuvalet", "fiş", "su altı"};
    String[] c1bolum10c3 = {"kramp", "geçit töreni", "ruj", "çare", "uzmanlık", "kontrol", "sıkı", "mücadele", "yatıştırıcı", "güneybatısında"};
    String[] c1bolum10c4 = {"sıfırla", "gelişme, iyileşme, düzelme, ilerleme", "tamamen", "kefil olmak", "şartlı tahliye", "acı", "saygıdeğer, muhterem", "gizlenmek", "biçimsel", "ahşap"};
    String[] c1bolum10c5 = {"uydurma", "kesinlikle", "suikast yapmak", "kardinaller meclisi", "ilik", "anlaşılabilir", "onbeş", "yönetici", "inilti", "kurgu"};
    String[] c1bolum10c6 = {"biyolojik", "büfe, yumruklama", "artırmak", "paten", "teleskop", "yeniden açmak", "serçe", "uymamak", "iskelet", "baharat"};

    // Data C2

    String[] c2bolum1s1 = {"occasionally", "pervert", "restraint", "compass", "enlighten", "serpent", "transform", "charter", "freshman", "bravery"};
    String[] c2bolum1s2 = {"setback", "divine", "endanger", "rebellion", "elaborate", "allies", "petition", "renounce", "little finger", "amateur"};
    String[] c2bolum1s3 = {"bandage", "creek", "comedy", "sadness", "occasional", "fewer", "dreamt", "faithful", "transportation", "adapt"};
    String[] c2bolum1s4 = {"homemade", "shaking", "lighter", "being", "penalty", "hairy", "catholic", "superpower", "september", "tenant"};
    String[] c2bolum1s5 = {"shuttle", "input", "campus", "graduation", "firework", "condo", "matches", "refused", "alias", "fall in"};
    String[] c2bolum1s6 = {"upstairs", "thursday", "bye-bye", "goodman", "firearm", "collateral", "commissioner", "platinum", "scumbag", "chore"};
    String[] c2bolum2s1 = {"globe", "processor", "morgue", "clay", "pacific", "jazz", "consultant", "naming", "redemption", "rang"};
    String[] c2bolum2s2 = {"productive", "cooperate", "bunk", "rookie", "stranded", "mainly", "soy", "photographer", "faked", "evacuation"};
    String[] c2bolum2s3 = {"stray", "freezer", "withdrawal", "embarrassment", "breeze", "sector", "massacre", "passionate", "assemble", "rear"};
    String[] c2bolum2s4 = {"puke", "artery", "intercourse", "lid", "overrun", "nazis", "instant", "essence", "shorter", "builder"};
    String[] c2bolum2s5 = {"rum", "exotic", "persuade", "suitable", "notion", "expectation", "initiate", "defect", "chunk", "logical"};
    String[] c2bolum2s6 = {"household", "iit", "skirt", "outpost", "weasel", "guid", "hunger", "whale", "variable", "jealousy"};
    String[] c2bolum3s1 = {"torment", "kite", "freely", "scrub", "gallery", "acquaintance", "marathon", "compete", "ingredient", "disguise"};
    String[] c2bolum3s2 = {"sentiment", "prophet", "ultimately", "grandkid", "parasite", "tremendous", "prosecutor", "disconnect", "preserve", "merchant"};
    String[] c2bolum3s3 = {"quarry", "cozy", "shitty", "farther", "hunch", "duct", "northwest", "porch", "wolves", "inn"};
    String[] c2bolum3s4 = {"awfully", "flock", "resolution", "skipped", "unto", "broom", "curfew", "thirty", "contribute", "brat"};
    String[] c2bolum3s5 = {"hopeless", "slippery", "doorbell", "classroom", "ounce", "mercury", "academic", "tumor", "nipple", "documentary"};
    String[] c2bolum3s6 = {"mining", "detention", "coffeehouse", "unemployed", "tourist", "destined", "tommy", "get over", "hired", "headquarter"};
    String[] c2bolum4s1 = {"pot", "sandy", "mage", "put in", "cured", "antenna", "bakery", "suburb", "doughnut", "limo"};
    String[] c2bolum4s2 = {"typically", "mainframe", "morse", "bonding", "improv", "poll", "feather", "grudge", "forehead", "jaw"};
    String[] c2bolum4s3 = {"mode", "severe", "context", "shepherd", "spinning", "recommendation", "virtual", "pony", "fuse", "cocoa"};
    String[] c2bolum4s4 = {"untie", "satan", "heartbeat", "holed", "lever", "easiest", "rational", "wealthy", "redhead", "resent"};
    String[] c2bolum4s5 = {"bureau", "immune", "sincere", "gin", "coolest", "souvenir", "appoint", "allergy", "fealty", "volume"};
    String[] c2bolum4s6 = {"fatal", "ruthless", "seer", "renew", "orcs", "ranch", "orbit", "lump", "compassion", "obsession"};
    String[] c2bolum5s1 = {"voyage", "underestimated", "manipulate", "bathtub", "hog", "shush", "proposition", "disappearance", "wreckage", "urine"};
    String[] c2bolum5s2 = {"various", "fabric", "whatnot", "salvation", "dread", "messenger", "hazard", "transaction", "continent", "gown"};
    String[] c2bolum5s3 = {"archive", "surrounding", "mild", "dunk", "pud", "roam", "slaver", "simpler", "cooperation", "gamble"};
    String[] c2bolum5s4 = {"oldfashioned", "democracy", "dwell", "olympic", "sever", "landmark", "reflection", "saddle", "certainty", "blacksmith"};
    String[] c2bolum5s5 = {"flavor", "steward", "psychology", "merit", "outdoor", "ive", "uterus", "wheat", "stumble", "filing"};
    String[] c2bolum5s6 = {"needy", "distribution", "classy", "mechanism", "diner", "marijuana", "kidnapper", "businessman", "wrestler", "allegation"};
    String[] c2bolum6s1 = {"goblin", "warlock", "have in", "look in", "come down", "asteroid", "form", "so-called", "dedicated", "inches"};
    String[] c2bolum6s2 = {"airlock", "immunity", "detonate", "infinity", "fabulous", "amaze", "uncover", "wuss", "dorm", "unpack"};
    String[] c2bolum6s3 = {"weekly", "authorize", "neutrino", "pimp", "dryer", "slot", "mammal", "hippie", "endure", "kindly"};
    String[] c2bolum6s4 = {"concussion", "novel", "raccoon", "goods", "delusional", "bash", "soccer", "industrial", "cord", "scheme"};
    String[] c2bolum6s5 = {"fare", "babysitting", "france", "sane", "psst", "rug", "predictable", "forty", "peak", "discipline"};
    String[] c2bolum6s6 = {"regain", "ambitious", "portion", "hence", "oar", "secondly", "pupil", "involvement", "vain", "tasty"};
    String[] c2bolum7s1 = {"seduce", "painter", "liability", "inspiration", "despise", "countless", "hideous", "defensive", "expedition", "fountain"};
    String[] c2bolum7s2 = {"wig", "contrary", "disorder", "crossword", "essential", "apparent", "venture", "snitch", "stairwell", "estimate"};
    String[] c2bolum7s3 = {"chairman", "aka", "valiant", "penthouse", "sang", "exclusive", "invade", "wail", "tribe", "midst"};
    String[] c2bolum7s4 = {"mechanical", "behead", "copper", "scavenge", "onetime", "froze", "pointy", "comb", "babysit", "dairy"};
    String[] c2bolum7s5 = {"hangover", "dent", "turd", "unload", "longterm", "dental", "demonstrate", "chopped", "successfully", "caring"};
    String[] c2bolum7s6 = {"fastest", "unfold", "wicked", "outbreak", "syrup", "pantie", "dam", "confidentiality", "obtain", "biology"};
    String[] c2bolum8s1 = {"modify", "revenue", "tailor", "cipher", "probability", "playground", "tons", "vaccine", "come over", "bobby"};
    String[] c2bolum8s2 = {"beacon", "apprehend", "papal", "ward", "elder", "ring in", "pen up", "you-know-who", "doppelganger", "dated"};
    String[] c2bolum8s3 = {"argentina", "antibiotic", "scoff", "invention", "semester", "hurricane", "deadline", "upstate", "wireless", "alcoholic"};
    String[] c2bolum8s4 = {"contraction", "noodle", "hemorrhoid", "madame", "nightclub", "japan", "pantry", "korea", "fuss", "thankyou"};
    String[] c2bolum8s5 = {"donkey", "extent", "compartment", "curve", "achievement", "offensive", "originally", "discreet", "operational", "cans"};
    String[] c2bolum8s6 = {"bitten", "confuse", "instructor", "hospitality", "inclined", "luxury", "refugee", "georgia", "attaboy", "sucker"};
    String[] c2bolum9s1 = {"pond", "litter", "filth", "trader", "esteem", "sausage", "redeem", "overthrow", "vocal", "unite"};
    String[] c2bolum9s2 = {"inquiry", "grieve", "tender", "contribution", "nicest", "oscar", "spicy", "evolution", "fasten", "unfinished"};
    String[] c2bolum9s3 = {"shallow", "obligation", "assassination", "ascension", "crane", "tolerate", "isle", "carriage", "applause", "treachery"};
    String[] c2bolum9s4 = {"corruption", "demonstration", "preach", "lace", "altogether", "inflict", "verse", "outstanding", "caesar", "ape"};
    String[] c2bolum9s5 = {"reserve", "irony", "waist", "parallel", "plow", "grandchildren", "neutral", "essentially", "thermal", "fellowship"};
    String[] c2bolum9s6 = {"projection", "lizard", "sept", "eldest", "peril", "crave", "drunken", "sufficient", "arse", "whichever"};
    String[] c2bolum10s1 = {"merciful", "amuse", "stitches", "settling", "generate", "hearth", "sofa", "voicemail", "firepower", "tripped"};
    String[] c2bolum10s2 = {"penguin", "guaranteed", "orientation", "cyber", "blossom", "volcano", "motivation", "cheerleader", "yacht", "specialist"};
    String[] c2bolum10s3 = {"opium", "airline", "allowance", "summoned", "enchanted", "wristband", "replaced", "refusing", "stay away", "sleep with"};
    String[] c2bolum10s4 = {"uh-oh", "go up", "go through", "get about", "buzz", "gay", "get rid of", "pension", "reapers", "violated"};
    String[] c2bolum10s5 = {"polygraph", "sunflower", "digit", "catalog", "potentially", "bloke", "scholarship", "swiss", "crumb", "nude"};
    String[] c2bolum10s6 = {"wardrobe", "quirky", "psychiatric", "virginity", "visa", "roller", "coal", "mill", "rapist", "shootout"};

    // Data C2 Cevaplar

    String[] c2bolum1c1 = {"bazen", "sapık", "kısıtlama", "pusula", "aydınlatmak", "yılan", "dönüşüm", "tüzük", "birinci sınıf öğrencisi", "cesaret"};
    String[] c2bolum1c2 = {"gerileme", "ilahi", "tehlikeye atmak", "isyan", "ayrıntılı", "itilaf devletleri", "dilekçe", "vazgeçmek", "serçe parmağı", "amatör"};
    String[] c2bolum1c3 = {"bandaj, bandajlamak", "dere", "komedi", "üzüntü", "nadiren", "daha az", "hayal", "sadık", "ulaşım", "uymak, adapte olmak"};
    String[] c2bolum1c4 = {"ev yapımı", "sallama", "çakmak", "varlık", "ceza", "kıllı", "katolik", "süper güç", "eylül", "kiracı"};
    String[] c2bolum1c5 = {"servis aracı", "giriş", "yerleşke", "mezuniyet", "havai fişek", "konut", "maçlar", "reddetti", "sahte isim, takma isim", "içine düşmek"};
    String[] c2bolum1c6 = {"üst katta", "perşembe", "güle güle", "koca, baba, aile reisi", "ateşli silâh", "yan", "komiser", "platin", "pislik", "zevksiz iş"};
    String[] c2bolum2c1 = {"küre", "işlemci", "morg", "kil", "pasifik", "caz", "danışman", "adlandırma", "ödeme", "çalmak"};
    String[] c2bolum2c2 = {"üretken", "işbirliği yapmak", "ranza, kaçmak", "çaylak", "mahsur, çıkmaza düşmüş", "esasen", "soya", "fotoğrafçı", "sahte", "tahliye"};
    String[] c2bolum2c3 = {"başıboş", "dondurucu", "para çekme", "sıkıntı", "esinti", "sektör", "katliam", "tutkulu", "birleştirmek, monte etmek", "arka"};
    String[] c2bolum2c4 = {"kusmak", "ana yol, atardamar", "ilişki", "kapak", "aşmak", "naziler", "anlık", "öz", "daha kısa", "kurucu, oluşturucu"};
    String[] c2bolum2c5 = {"tuhaf, rum, içki", "egzotik", "ikna etmek", "uygun", "kavram", "beklenti", "başlatmak", "kusur", "yığın", "mantıklı"};
    String[] c2bolum2c6 = {"ev halkı", "oic the science, technology and innovation organization", "etek", "ileri karakol", "gelincik", "kılavuz", "açlık, özlem, istek", "balina", "değişken", "kıskançlık"};
    String[] c2bolum3c1 = {"azap", "uçurtma", "serbestçe", "ovmak", "galeri", "tanıdık", "maraton", "yarışmak", "bileşen", "gizlemek"};
    String[] c2bolum3c2 = {"duygusallık", "peygamber", "en sonunda", "torun", "parazit", "muazzam", "savcı", "bağlantıyı kesmek", "korumak", "tüccar"};
    String[] c2bolum3c3 = {"taş ocağı", "rahat", "boktan", "daha uzağa", "önsezi", "kanal", "kuzey batı", "sundurma", "kurtlar", "han"};
    String[] c2bolum3c4 = {"berbat bir şekilde", "sürü", "çözüm", "atlanır", "üzerine", "süpürge", "sokağa çıkma yasağı", "otuz", "katkıda bulunmak", "velet"};
    String[] c2bolum3c5 = {"umutsuz", "kaygan", "kapı zili", "sınıf", "ons", "merkür", "akademik", "tümör", "meme", "belgesel"};
    String[] c2bolum3c6 = {"madencilik", "tutuklama", "kahve evi", "işsiz", "turist", "kaderinde", "ingiliz askeri", "atlatmak", "kiralanmış", "merkezi"};
    String[] c2bolum4c1 = {"tencere", "kumlu", "sihirbaz", "koymak", "kürlenmiş", "anten", "fırın", "kenar mahalle", "tatlı çörek", "limuzin"};
    String[] c2bolum4c2 = {"genellikle", "anabilgisayar", "mors", "yapıştırma, tutturma", "doğaçlama", "anket", "kuş tüyü", "kin", "alın", "çene"};
    String[] c2bolum4c3 = {"kip", "şiddetli", "bağlam", "çoban", "döndürme", "öneri", "sanal", "midilli", "sigorta", "kakao"};
    String[] c2bolum4c4 = {"çözmek", "şeytan", "kalp atışı", "delikli", "kaldıraç", "en kolay", "akılcı", "zengin, varlıklı", "kızıl saçlı", "yeniden gönderilen"};
    String[] c2bolum4c5 = {"büro, acente", "bağışık", "samimi", "cin", "havalı", "hatıra", "atamak", "alerji", "sadakat", "ses"};
    String[] c2bolum4c6 = {"ölümcül", "acımasız", "falcı", "yenile", "orklar", "çiftlik", "yörünge", "topak, yumru", "merhamet", "takıntı"};
    String[] c2bolum5c1 = {"yolculuk", "hafife", "idare", "küvet", "domuz", "sus", "önerme", "yok olma", "enkaz", "idrar"};
    String[] c2bolum5c2 = {"çeşitli", "kumaş", "ıvır zıvır", "kurtulma, kurtuluş", "dehşet", "haberci, elçi", "tehlike", "işlem", "kıta", "elbise"};
    String[] c2bolum5c3 = {"arşiv", "çevreleyen", "hafif", "daldırmak", "puding", "dolaşmak", "köleci", "daha basit", "işbirliği", "kumar"};
    String[] c2bolum5c4 = {"eski moda", "demokrasi", "yaşamak", "olimpiyat, olimpik", "ayırmak", "işaret", "yansıma", "sele", "kesinlik", "demirci"};
    String[] c2bolum5c5 = {"lezzet, lezzet kazmak, tat duyusu", "kamarot", "psikoloji", "hak", "dış mekan", "ben sahibim", "rahim", "buğday", "yanılmak", "dosyalama"};
    String[] c2bolum5c6 = {"muhtaç", "dağıtım", "şık", "mekanizma", "lokanta", "esrar", "çocuk hırsızı", "işadamı", "güreşçi", "iddia"};
    String[] c2bolum6c1 = {"cin", "falcı", "sahip", "arama konumu", "inmek, düşmek, gözden düşmek", "asteroit", "oluşturmak, şekillendirmek, form", "lafta, sözde", "adanmış", "inç"};
    String[] c2bolum6c2 = {"hava kilidi", "dokunulmazlık", "patlatmak", "sonsuzluk", "harika", "hayrete düşürmek, şaşırmak", "ortaya çıkarmak", "korkak", "yurt", "açmak"};
    String[] c2bolum6c3 = {"haftalık", "yetki vermek", "nötrino", "pezevenk", "kurutma makinesi", "yarık", "memeli", "hippi", "katlanmak", "nazikçe"};
    String[] c2bolum6c4 = {"sarsıntı", "roman", "rakun", "mal, yük", "sanrısal", "sertçe vurmak", "futbol", "sanayi", "kordon", "düzen"};
    String[] c2bolum6c5 = {"ücret", "Bebek Bakımı", "fransa", "aklı başında", "hişt", "kilim", "tahmin edilebilir", "kırk", "zirve", "disiplin"};
    String[] c2bolum6c6 = {"yeniden kazanmak", "hırslı", "kısım", "bundan dolayı", "kürek", "ikinci olarak", "öğrenci", "ilgi, bulaşma, bağlılık", "nafile", "lezzetli"};
    String[] c2bolum7c1 = {"baştan çıkartmak", "ressam", "yükümlülük", "ilham", "tiksinmek", "sayısız", "iğrenç", "savunma", "sefer", "çeşme"};
    String[] c2bolum7c2 = {"peruk", "aksi", "düzensizlik", "bulmaca", "gerekli", "belli", "girişim", "fitnelemek", "merdiven boşluğu", "tahmin"};
    String[] c2bolum7c3 = {"başkan", "diğer adıyla", "yiğit", "çatı katı", "şarkı söyledi", "özel", "saldırmak", "feryat", "kabile", "ortasında"};
    String[] c2bolum7c4 = {"mekanik, otomatik, makineli", "kafasını kesmek", "bakır", "temizlemek", "bir kere", "dondu", "sivri", "tarak", "bakıcılık, çocuk bakmak", "mandıra"};
    String[] c2bolum7c5 = {"akşamdan kalma", "göçük", "bok", "boşaltmak", "uzun süreli", "diş", "göstermek, göz önüne sermek", "kıyılmış", "başarılı olarak", "sempatik"};
    String[] c2bolum7c6 = {"en hızlı", "açılmak", "kötü", "salgın", "şurup", "kadın külodu", "baraj", "gizlilik", "elde etmek", "biyoloji"};
    String[] c2bolum8c1 = {"değiştirmek", "gelir", "terzi", "şifre", "olasılık", "oyun alanı", "ton", "aşı", "buraya gel", "aynasız"};
    String[] c2bolum8c2 = {"fener", "kavramak", "papaya ait", "koğuş", "yaşça büyük", "içeri girmek", "tükenmek", "kim olduğunu biliyorsun", "tıpkısının aynısı", "tarihli"};
    String[] c2bolum8c3 = {"Arjantin", "antibiyotik", "alay", "icat", "dönem", "kasırga", "son tarih", "şehir dışı", "kablosuz", "alkollü, alkolik"};
    String[] c2bolum8c4 = {"kasılma", "şehriye, erişte", "basur", "madam", "gece kulübü", "japonya", "kiler", "kore", "yaygara", "teşekkür ederim"};
    String[] c2bolum8c5 = {"eşek", "derece", "bölme", "eğri", "başarı", "saldırgan", "aslında", "sağduyulu", "işletme", "konserve kutuları"};
    String[] c2bolum8c6 = {"ısırılan", "şaşırtmak", "eğitmen", "misafirperverlik", "eğimli", "lüks", "mülteci", "gürcistan", "aferin sana", "enayi, emici"};
    String[] c2bolum9c1 = {"gölet", "çöp", "pislik", "tüccar", "saygı", "sosis", "tazmin etmek", "devirmek", "vokal", "birleştirmek"};
    String[] c2bolum9c2 = {"soruşturma", "üzülmek", "hassas", "katkı", "en güzel", "oskar", "baharatlı", "evrim", "bağlamak", "bitmemiş"};
    String[] c2bolum9c3 = {"sığ", "yükümlülük", "suikast", "göğe yükselme", "vinç", "tahammül", "ada", "taşıma", "alkış", "ihanet"};
    String[] c2bolum9c4 = {"bozulma", "gösteri", "vaaz vermek, tavsiye etmek", "dantel", "hep beraber", "vermek", "ayet", "göze çarpan, seçkin", "sezar", "taklit etmek, maymun"};
    String[] c2bolum9c5 = {"rezerv", "hiciv, alay, ince alay", "bel", "paralel", "pulluk", "torunlar", "nötr", "esasen", "termal", "dernek"};
    String[] c2bolum9c6 = {"projeksiyon", "kertenkele", "eylül", "en yaşlı", "tehlike", "yalvarmak", "sarhoş", "yeterli", "kıç, anüs", "hangisi"};
    String[] c2bolum10c1 = {"merhametli", "eğlendirmek", "dikişler", "yerleşme", "üretmek", "aile ocağı", "kanepe", "sesli mesaj", "ateş gücü", "takılmak"};
    String[] c2bolum10c2 = {"penguen", "garantili", "oryantasyon", "siber", "çiçek açmak", "volkan", "motivasyon", "ponpon kız", "yat", "uzman"};
    String[] c2bolum10c3 = {"afyon", "havayolu", "izin, ödenek, harçlık", "çağırıldı", "büyülü", "bileklik", "değiştirilir", "reddeden", "uzak dur", "uyumak"};
    String[] c2bolum10c4 = {"a aa", "yukarı git", "geçmek, incelemek", "yayılmak", "vızıltı, vızıldamak, telefon etmek", "eşcinsel", "kurtulmak", "emeklilik", "orak", "ihlal"};
    String[] c2bolum10c5 = {"yalan makinesi", "ayçiçeği", "hane", "katalog", "potansiyel", "herif", "burs", "i·sviçre", "kırıntı", "çıplak"};
    String[] c2bolum10c6 = {"giysi dolabı", "ilginç", "psikiyatrik", "bakirelik", "vize", "rulman", "kömür", "değirmen", "tecavüzcü, çapulcu", "atışları"};


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
        textToSpeech = new TextToSpeech(kelime3.this, new TextToSpeech.OnInitListener() {
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
            Intent intent = new Intent(kelime3.this,kelime3.class);
            startActivity(intent);
            finish();
        });

        mView.findViewById(R.id.next).setOnClickListener(v -> {
            if (Objects.equals(sev, "C1bölüm1s1")){
                sharedPreferences.edit().putString("seviye1","C1bölüm1s2").apply();
            } else if (Objects.equals(sev, "C1bölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm1s3").apply();
            }else if (Objects.equals(sev, "C1bölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm1s4").apply();
            }else if (Objects.equals(sev, "C1bölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm1s5").apply();
            }else if (Objects.equals(sev, "C1bölüm1s5")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm1s6").apply();
            }else if (Objects.equals(sev, "C1bölüm1s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1 Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }  if (Objects.equals(sev, "C1bölüm3s1")){
                sharedPreferences.edit().putString("seviye1","C1bölüm3s2").apply();
            } else if (Objects.equals(sev, "C1bölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm3s3").apply();
            }else if (Objects.equals(sev, "C1bölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm3s4").apply();
            }else if (Objects.equals(sev, "C1bölüm3s4")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm3s5").apply();
            }else if (Objects.equals(sev, "C1bölüm3s5")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm3s6").apply();
            }else if (Objects.equals(sev, "C1bölüm3s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            } if (Objects.equals(sev, "C1bölüm2s1")){
                sharedPreferences.edit().putString("seviye1","C1bölüm2s2").apply();
            } else if (Objects.equals(sev, "C1bölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm2s3").apply();
            }else if (Objects.equals(sev, "C1bölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm2s4").apply();
            }else if (Objects.equals(sev, "C1bölüm2s4")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm2s5").apply();
            }else if (Objects.equals(sev, "C1bölüm2s5")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm2s6").apply();
            }else if (Objects.equals(sev, "C1bölüm2s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "C1bölüm4s1")){
                sharedPreferences.edit().putString("seviye1","C1bölüm4s2").apply();
            } else if (Objects.equals(sev, "C1bölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm4s3").apply();
            }else if (Objects.equals(sev, "C1bölüm4s3")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm4s4").apply();
            }else if (Objects.equals(sev, "C1bölüm4s4")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm4s5").apply();
            }else if (Objects.equals(sev, "C1bölüm4s5")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm4s6").apply();
            }else if (Objects.equals(sev, "C1bölüm4s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "C1bölüm5s1")){
                sharedPreferences.edit().putString("seviye1","C1bölüm5s2").apply();
            } else if (Objects.equals(sev, "C1bölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm5s3").apply();
            }else if (Objects.equals(sev, "C1bölüm5s3")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm5s4").apply();
            }else if (Objects.equals(sev, "C1bölüm5s4")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm5s5").apply();
            }else if (Objects.equals(sev, "C1bölüm5s5")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm5s6").apply();
            }else if (Objects.equals(sev, "C1bölüm5s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "C1bölüm6s1")){
                sharedPreferences.edit().putString("seviye1","C1bölüm6s2").apply();
            } else if (Objects.equals(sev, "C1bölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm6s3").apply();
            }else if (Objects.equals(sev, "C1bölüm6s3")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm6s4").apply();
            }else if (Objects.equals(sev, "C1bölüm6s4")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm6s5").apply();
            }else if (Objects.equals(sev, "C1bölüm6s5")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm6s6").apply();
            }else if (Objects.equals(sev, "C1bölüm6s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "C1bölüm7s1")){
                sharedPreferences.edit().putString("seviye1","C1bölüm7s2").apply();
            } else if (Objects.equals(sev, "C1bölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm7s3").apply();
            }else if (Objects.equals(sev, "C1bölüm7s3")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm7s4").apply();
            }else if (Objects.equals(sev, "C1bölüm7s4")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm7s5").apply();
            }else if (Objects.equals(sev, "C1bölüm7s5")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm7s6").apply();
            }else if (Objects.equals(sev, "C1bölüm7s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "C1bölüm8s1")){
                sharedPreferences.edit().putString("seviye1","C1bölüm8s2").apply();
            } else if (Objects.equals(sev, "C1bölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm8s3").apply();
            }else if (Objects.equals(sev, "C1bölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm8s4").apply();
            }else if (Objects.equals(sev, "C1bölüm8s4")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm8s5").apply();
            }else if (Objects.equals(sev, "C1bölüm8s5")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm8s6").apply();
            }else if (Objects.equals(sev, "C1bölüm8s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "C1bölüm9s1")){
                sharedPreferences.edit().putString("seviye1","C1bölüm9s2").apply();
            } else if (Objects.equals(sev, "C1bölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm9s3").apply();
            }else if (Objects.equals(sev, "C1bölüm9s3")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm9s4").apply();
            }else if (Objects.equals(sev, "C1bölüm9s4")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm9s5").apply();
            }else if (Objects.equals(sev, "C1bölüm9s5")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm9s6").apply();
            }else if (Objects.equals(sev, "C1bölüm9s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "C1bölüm10s1")){
                sharedPreferences.edit().putString("seviye1","C1bölüm10s2").apply();
            } else if (Objects.equals(sev, "C1bölüm10s2")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm10s3").apply();
            }else if (Objects.equals(sev, "C1bölüm10s3")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm10s4").apply();
            }else if (Objects.equals(sev, "C1bölüm10s4")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm10s5").apply();
            }else if (Objects.equals(sev, "C1bölüm10s5")) {
                sharedPreferences.edit().putString("seviye1","C1bölüm10s6").apply();
            }else if (Objects.equals(sev, "C1bölüm10s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 10. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "C2bölüm1s1")){
                sharedPreferences.edit().putString("seviye1","C2bölüm1s2").apply();
            } else if (Objects.equals(sev, "C2bölüm1s2")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm1s3").apply();
            }else if (Objects.equals(sev, "C2bölüm1s3")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm1s4").apply();
            }else if (Objects.equals(sev, "C2bölüm1s4")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm1s5").apply();
            }else if (Objects.equals(sev, "C2bölüm1s5")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm1s6").apply();
            }else if (Objects.equals(sev, "C2bölüm1s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 1. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "C2bölüm2s1")){
                sharedPreferences.edit().putString("seviye1","C2bölüm2s2").apply();
            } else if (Objects.equals(sev, "C2bölüm2s2")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm2s3").apply();
            }else if (Objects.equals(sev, "C2bölüm2s3")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm2s4").apply();
            }else if (Objects.equals(sev, "C2bölüm2s4")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm2s5").apply();
            }else if (Objects.equals(sev, "C2bölüm2s5")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm2s6").apply();
            }else if (Objects.equals(sev, "C2bölüm2s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 2. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if (Objects.equals(sev, "C2bölüm3s1")){
                sharedPreferences.edit().putString("seviye1","C2bölüm3s2").apply();
            } else if (Objects.equals(sev, "C2bölüm3s2")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm3s3").apply();
            }else if (Objects.equals(sev, "C2bölüm3s3")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm3s4").apply();
            }else if (Objects.equals(sev, "C2bölüm3s4")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm3s5").apply();
            }else if (Objects.equals(sev, "C2bölüm3s5")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm3s6").apply();
            }else if (Objects.equals(sev, "C2bölüm3s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 3. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }



            if (Objects.equals(sev, "C2bölüm4s1")){
                sharedPreferences.edit().putString("seviye1","C2bölüm4s2").apply();
            } else if (Objects.equals(sev, "C2bölüm4s2")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm4s3").apply();
            }else if (Objects.equals(sev, "C2bölüm4s3")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm4s4").apply();
            }else if (Objects.equals(sev, "C2bölüm4s4")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm4s5").apply();
            }else if (Objects.equals(sev, "C2bölüm4s5")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm4s6").apply();
            }else if (Objects.equals(sev, "C2bölüm4s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 4. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "C2bölüm5s1")){
                sharedPreferences.edit().putString("seviye1","C2bölüm5s2").apply();
            } else if (Objects.equals(sev, "C2bölüm5s2")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm5s3").apply();
            }else if (Objects.equals(sev, "C2bölüm5s3")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm5s4").apply();
            }else if (Objects.equals(sev, "C2bölüm5s4")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm5s5").apply();
            }else if (Objects.equals(sev, "C2bölüm5s5")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm5s6").apply();
            }else if (Objects.equals(sev, "C2bölüm5s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 5. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }

            if (Objects.equals(sev, "C2bölüm6s1")){
                sharedPreferences.edit().putString("seviye1","C2bölüm6s2").apply();
            } else if (Objects.equals(sev, "C2bölüm6s2")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm6s3").apply();
            }else if (Objects.equals(sev, "C2bölüm6s3")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm6s4").apply();
            }else if (Objects.equals(sev, "C2bölüm6s4")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm6s5").apply();
            }else if (Objects.equals(sev, "C2bölüm6s5")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm6s6").apply();
            }else if (Objects.equals(sev, "C2bölüm6s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 6. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "C2bölüm7s1")){
                sharedPreferences.edit().putString("seviye1","C2bölüm7s2").apply();
            } else if (Objects.equals(sev, "C2bölüm7s2")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm7s3").apply();
            }else if (Objects.equals(sev, "C2bölüm7s3")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm7s4").apply();
            }else if (Objects.equals(sev, "C2bölüm7s4")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm7s5").apply();
            }else if (Objects.equals(sev, "C2bölüm7s5")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm7s6").apply();
            }else if (Objects.equals(sev, "C2bölüm7s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 7. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "C2bölüm8s1")){
                sharedPreferences.edit().putString("seviye1","C2bölüm8s2").apply();
            } else if (Objects.equals(sev, "C2bölüm8s2")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm8s3").apply();
            }else if (Objects.equals(sev, "C2bölüm8s3")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm8s4").apply();
            }else if (Objects.equals(sev, "C2bölüm8s4")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm8s5").apply();
            }else if (Objects.equals(sev, "C2bölüm8s5")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm8s6").apply();
            }else if (Objects.equals(sev, "C2bölüm8s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 8. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }




            if (Objects.equals(sev, "C2bölüm9s1")){
                sharedPreferences.edit().putString("seviye1","C2bölüm9s2").apply();
            } else if (Objects.equals(sev, "C2bölüm9s2")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm9s3").apply();
            }else if (Objects.equals(sev, "C2bölüm9s3")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm9s4").apply();
            }else if (Objects.equals(sev, "C2bölüm9s4")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm9s5").apply();
            }else if (Objects.equals(sev, "C2bölüm9s5")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm9s6").apply();
            }else if (Objects.equals(sev, "C2bölüm9s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 9. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }
            if (Objects.equals(sev, "C2bölüm10s1")){
                sharedPreferences.edit().putString("seviye1","C2bölüm10s2").apply();
            } else if (Objects.equals(sev, "C2bölüm10s2")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm10s3").apply();
            }else if (Objects.equals(sev, "C2bölüm10s3")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm10s4").apply();
            }else if (Objects.equals(sev, "C2bölüm10s4")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm10s5").apply();
            }else if (Objects.equals(sev, "C2bölüm10s5")) {
                sharedPreferences.edit().putString("seviye1","C2bölüm10s6").apply();
            }else if (Objects.equals(sev, "C2bölüm10s6")) {
                alertDialog.dismiss();
                i++;
                Toast.makeText(this, "Bölüm 10. Bitmiştir Tebrikler.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(kelime3.this,MainActivity5.class);
                startActivity(intent);
                finish();
            }


            if(i == 0){
                alertDialog.dismiss();
                Intent intent = new Intent(kelime3.this, kelime3.class);
                startActivity(intent);
                finish();
            }
        });
        mView.findViewById(R.id.anamenu).setOnClickListener(v -> {
            alertDialog.dismiss();
            Intent intent = new Intent(kelime3.this,MainActivity5.class);
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
                    mInterstitialAd.show(kelime3.this);
                }
            ShowDialogBox();
            if (sev.contains("C1bölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C1bölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C1bölüm1'");
            }
            if (sev.contains("C1bölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C1bölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C1bölüm2'");
            }
            if (sev.contains("C1bölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C1bölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C1bölüm3'");
            }
            if (sev.contains("C1bölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C1bölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C1bölüm4'");
            }
            if (sev.contains("C1bölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C1bölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C1bölüm5'");
            }
            if (sev.contains("C1bölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C1bölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C1bölüm6'");
            }
            if (sev.contains("C1bölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C1bölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C1bölüm7'");
            }
            if (sev.contains("C1bölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C1bölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C1bölüm8'");
            }
            if (sev.contains("C1bölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C1bölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C1bölüm9'");
            }
            if (sev.contains("C1bölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C1bölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C1bölüm10'");
            }
            if (sev.contains("C2bölüm1")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C2bölüm1'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C2bölüm1'");
            }
            if (sev.contains("C2bölüm2")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C2bölüm2'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C2bölüm2'");
            }
            if (sev.contains("C2bölüm3")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C2bölüm3'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C2bölüm3'");
            }
            if (sev.contains("C2bölüm4")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C2bölüm4'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C2bölüm4'");
            }
            if (sev.contains("C2bölüm5")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C2bölüm5'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C2bölüm5'");
            }
            if (sev.contains("C2bölüm6")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C2bölüm6'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C2bölüm6'");
            }
            if (sev.contains("C2bölüm7")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C2bölüm7'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C2bölüm7'");
            }
            if (sev.contains("C2bölüm8")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C2bölüm8'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C2bölüm8'");
            }
            if (sev.contains("C2bölüm9")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C2bölüm9'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C2bölüm9'");
            }
            if (sev.contains("C2bölüm10")) {
                database.execSQL("UPDATE A SET dogru=dogru+" + sorudogru + " WHERE bolum='C2bölüm10'");
                database.execSQL("UPDATE A SET yanlis=yanlis+" + soruyanlis + " WHERE bolum='C2bölüm10'");
            }
            database.execSQL("UPDATE P SET puan=puan+" + sorudogru * 2 + "");


            if (sev.equals("C1bölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm1s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm1s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm1s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm1s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm1s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm1s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm1s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm1s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm2s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm2s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm2s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm2s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm2s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm2s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm2s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm2s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm3s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm3s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm3s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm3s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm3s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm3s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm3s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm3s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm4s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm4s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm4s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm4s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm4s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm4s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm4s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm4s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm4s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm4s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm4s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm4s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm5s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm5s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm5s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm5s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm5s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm5s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm5s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm5s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm5s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm5s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm5s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm5s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm6s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm6s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm6s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm6s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm6s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm6s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm6s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm6s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm6s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm6s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm6s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm6s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm7s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm7s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm7s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm7s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm7s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm7s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm7s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm7s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm7s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm7s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm7s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm7s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm8s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm8s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm8s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm8s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm8s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm8s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm8s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm8s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm9s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm9s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm9s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm9s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm9s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm9s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm9s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm9s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm9s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm9s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm9s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm9s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm9s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm10s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm10s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm10s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm10s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm10s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm10s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm10s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm10s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm10s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm10s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm10s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm10s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm10s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm10s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm10s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm10s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm10s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm10s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm10s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm10s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C1bölüm10s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C1bölüm10s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C1bölüm10s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C1bölüm10s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm1s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm1s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm1s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm1s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm1s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm1s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm1s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm1s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm1s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm1s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm1s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm1s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm1s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm1s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm1s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm1s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm1s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm1s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm1s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm1s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm1s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm1s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm1s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm1s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm2s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm2s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm2s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm2s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm2s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm2s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm2s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm2s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm2s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm2s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm2s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm2s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm2s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm2s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm2s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm2s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm2s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm2s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm2s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm2s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm2s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm2s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm2s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm2s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm3s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm3s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm3s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm3s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm3s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm3s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm3s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm3s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm3s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm3s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm3s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm3s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm3s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm3s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm3s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm3s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm3s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm3s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm3s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm3s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm3s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm3s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm3s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm3s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm4s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm4s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm4s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm4s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm4s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm4s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm4s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm4s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm4s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm4s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm4s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm4s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm4s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm4s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm4s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm4s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm4s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm4s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm4s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm4s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm4s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm4s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm4s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm4s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm5s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm5s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm5s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm5s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm5s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm5s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm5s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm5s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm5s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm5s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm5s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm5s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm5s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm5s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm5s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm5s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm5s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm5s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm5s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm5s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm5s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm5s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm5s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm5s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm6s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm6s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm6s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm6s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm6s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm6s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm6s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm6s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm6s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm6s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm6s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm6s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm6s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm6s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm6s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm6s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm6s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm6s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm6s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm6s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm6s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm6s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm6s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm6s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm7s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm7s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm7s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm7s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm7s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm7s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm7s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm7s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm7s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm7s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm7s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm7s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm7s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm7s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm7s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm7s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm7s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm7s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm7s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm7s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm7s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm7s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm7s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm7s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm8s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm8s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm8s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm8s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm8s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm8s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm8s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm8s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm8s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm8s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm8s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm8s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm8s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm8s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm8s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm8s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm8s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm8s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm8s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm8s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm8s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm8s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm8s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm8s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm9s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm9s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm9s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm9s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm9s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm9s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm9s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm9s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm9s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm9s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm9s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm9s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm9s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm9s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm9s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm9s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm9s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm9s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm9s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm9s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm9s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm9s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm9s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm9s6yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm10s1")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm10s1yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm10s1yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm10s1yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm10s2")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm10s2yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm10s2yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm10s2yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm10s3")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm10s3yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm10s3yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm10s3yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm10s4")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm10s4yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm10s4yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm10s4yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm10s5")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm10s5yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm10s5yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm10s5yildiz", "2").apply();
                }
            }
            if (sev.equals("C2bölüm10s6")) {
                if (sorudogru <= 4) {
                    sharedPreferences.edit().putString("C2bölüm10s6yildiz", "0").apply();
                } else if (sorudogru <= 7) {
                    sharedPreferences.edit().putString("C2bölüm10s6yildiz", "1").apply();
                } else if (sorudogru <= 10) {
                    sharedPreferences.edit().putString("C2bölüm10s6yildiz", "2").apply();
                }
            }


            // SORU EKRANI

        } else if (Objects.equals(sev, "C1bölüm1s1")) {
            soru1 = new Soru(c1bolum1s1[sorusay], c1bolum1c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();

        }else if (Objects.equals(sev, "C1bölüm1s2")){
            soru1 = new Soru(c1bolum1s2[sorusay], c1bolum1c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm1s3")){
            soru1 = new Soru(c1bolum1s3[sorusay], c1bolum1c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm1s4")){
            soru1 = new Soru(c1bolum1s4[sorusay], c1bolum1c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm1s5")){
            soru1 = new Soru(c1bolum1s5[sorusay], c1bolum1c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm1s6")){
            soru1 = new Soru(c1bolum1s6[sorusay], c1bolum1c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev,"C1bölüm2s1")){
            soru1 = new Soru(c1bolum2s1[sorusay], c1bolum2c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm2s2")){
            soru1 = new Soru(c1bolum2s2[sorusay], c1bolum2c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm2s3")){
            soru1 = new Soru(c1bolum2s3[sorusay], c1bolum2c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm2s4")){
            soru1 = new Soru(c1bolum2s4[sorusay], c1bolum2c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm2s5")){
            soru1 = new Soru(c1bolum2s5[sorusay], c1bolum2c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm2s6")){
            soru1 = new Soru(c1bolum2s6[sorusay], c1bolum2c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm3s1")){
            soru1 = new Soru(c1bolum3s1[sorusay], c1bolum3c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm3s2")){
            soru1 = new Soru(c1bolum3s2[sorusay], c1bolum3c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm3s3")){
            soru1 = new Soru(c1bolum3s3[sorusay], c1bolum3c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm3s4")){
            soru1 = new Soru(c1bolum3s4[sorusay], c1bolum3c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm3s5")){
            soru1 = new Soru(c1bolum3s5[sorusay], c1bolum3c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm3s6")){
            soru1 = new Soru(c1bolum3s6[sorusay], c1bolum3c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm4s1")){
            soru1 = new Soru(c1bolum4s1[sorusay], c1bolum4c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm4s2")){
            soru1 = new Soru(c1bolum4s2[sorusay], c1bolum4c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm4s3")){
            soru1 = new Soru(c1bolum4s3[sorusay], c1bolum4c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm4s4")){
            soru1 = new Soru(c1bolum4s4[sorusay], c1bolum4c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm4s5")){
            soru1 = new Soru(c1bolum4s5[sorusay], c1bolum4c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm4s6")){
            soru1 = new Soru(c1bolum4s6[sorusay], c1bolum4c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm5s1")){
            soru1 = new Soru(c1bolum5s1[sorusay], c1bolum5c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm5s2")){
            soru1 = new Soru(c1bolum5s2[sorusay], c1bolum5c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm5s3")){
            soru1 = new Soru(c1bolum5s3[sorusay], c1bolum5c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm5s4")){
            soru1 = new Soru(c1bolum5s4[sorusay], c1bolum5c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm5s5")){
            soru1 = new Soru(c1bolum5s5[sorusay], c1bolum5c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm5s6")){
            soru1 = new Soru(c1bolum5s6[sorusay], c1bolum5c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm6s1")){
            soru1 = new Soru(c1bolum6s1[sorusay], c1bolum6c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm6s2")){
            soru1 = new Soru(c1bolum6s2[sorusay], c1bolum6c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm6s3")){
            soru1 = new Soru(c1bolum6s3[sorusay], c1bolum6c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm6s4")){
            soru1 = new Soru(c1bolum6s4[sorusay], c1bolum6c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm6s5")){
            soru1 = new Soru(c1bolum6s5[sorusay], c1bolum6c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm6s6")){
            soru1 = new Soru(c1bolum6s1[sorusay], c1bolum6c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm7s1")){
            soru1 = new Soru(c1bolum7s1[sorusay], c1bolum7c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm7s2")){
            soru1 = new Soru(c1bolum7s2[sorusay], c1bolum7c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm7s3")){
            soru1 = new Soru(c1bolum7s3[sorusay], c1bolum7c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm7s4")){
            soru1 = new Soru(c1bolum7s4[sorusay], c1bolum7c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm7s5")){
            soru1 = new Soru(c1bolum7s5[sorusay], c1bolum7c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm7s6")){
            soru1 = new Soru(c1bolum7s6[sorusay], c1bolum7c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm8s1")){
            soru1 = new Soru(c1bolum8s1[sorusay], c1bolum8c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm8s2")){
            soru1 = new Soru(c1bolum8s2[sorusay], c1bolum8c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm8s3")){
            soru1 = new Soru(c1bolum8s3[sorusay], c1bolum8c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm8s4")){
            soru1 = new Soru(c1bolum8s4[sorusay], c1bolum8c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm8s5")){
            soru1 = new Soru(c1bolum8s5[sorusay], c1bolum8c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm8s6")){
            soru1 = new Soru(c1bolum8s6[sorusay], c1bolum8c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm9s1")){
            soru1 = new Soru(c1bolum9s1[sorusay], c1bolum9c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm9s2")){
            soru1 = new Soru(c1bolum9s2[sorusay], c1bolum9c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm9s3")){
            soru1 = new Soru(c1bolum9s3[sorusay], c1bolum9c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm9s4")){
            soru1 = new Soru(c1bolum9s4[sorusay], c1bolum9c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm9s5")){
            soru1 = new Soru(c1bolum9s5[sorusay], c1bolum9c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm9s6")){
            soru1 = new Soru(c1bolum9s6[sorusay], c1bolum9c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm10s1")){
            soru1 = new Soru(c1bolum10s1[sorusay], c1bolum10c1[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm10s2")){
            soru1 = new Soru(c1bolum10s2[sorusay], c1bolum10c2[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm10s3")){
            soru1 = new Soru(c1bolum10s3[sorusay], c1bolum10c3[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm10s4")){
            soru1 = new Soru(c1bolum10s4[sorusay], c1bolum10c4[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm10s5")){
            soru1 = new Soru(c1bolum10s5[sorusay], c1bolum10c5[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C1bölüm10s6")){
            soru1 = new Soru(c1bolum10s6[sorusay], c1bolum10c6[sorusay], yanlislar3, yanlislar4);
            sorusay++;
            soru();
            sure();
            sorudegis();
        }else if (Objects.equals(sev, "C2bölüm1s1")){
        soru1 = new Soru(c2bolum1s1[sorusay], c2bolum1c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm1s2")){
        soru1 = new Soru(c2bolum1s2[sorusay], c2bolum1c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm1s3")){
        soru1 = new Soru(c2bolum1s3[sorusay], c2bolum1c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm1s4")){
        soru1 = new Soru(c2bolum1s4[sorusay], c2bolum1c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm1s5")){
        soru1 = new Soru(c2bolum1s5[sorusay], c2bolum1c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm1s6")){
        soru1 = new Soru(c2bolum1s6[sorusay], c2bolum1c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm2s1")){
        soru1 = new Soru(c2bolum2s1[sorusay], c2bolum2c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm2s2")){
        soru1 = new Soru(c2bolum2s2[sorusay], c2bolum2c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm2s3")){
        soru1 = new Soru(c2bolum2s3[sorusay], c2bolum2c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm2s4")){
        soru1 = new Soru(c2bolum2s4[sorusay], c2bolum2c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm2s5")){
        soru1 = new Soru(c2bolum2s5[sorusay], c2bolum2c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm2s6")){
        soru1 = new Soru(c2bolum2s6[sorusay], c2bolum2c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm3s1")){
        soru1 = new Soru(c2bolum3s1[sorusay], c2bolum3c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm3s2")){
        soru1 = new Soru(c2bolum3s2[sorusay], c2bolum3c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm3s3")){
        soru1 = new Soru(c2bolum3s3[sorusay], c2bolum3c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm3s4")){
        soru1 = new Soru(c2bolum3s4[sorusay], c2bolum3c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm3s5")){
        soru1 = new Soru(c2bolum3s5[sorusay], c2bolum3c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm3s6")){
        soru1 = new Soru(c2bolum3s6[sorusay], c2bolum3c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm4s1")){
        soru1 = new Soru(c2bolum4s1[sorusay], c2bolum4c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm4s2")){
        soru1 = new Soru(c2bolum4s2[sorusay], c2bolum4c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm4s3")){
        soru1 = new Soru(c2bolum4s3[sorusay], c2bolum4c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm4s4")){
        soru1 = new Soru(c2bolum4s4[sorusay], c2bolum4c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm4s5")){
        soru1 = new Soru(c2bolum4s5[sorusay], c2bolum4c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm4s6")){
        soru1 = new Soru(c2bolum4s6[sorusay], c2bolum4c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm5s1")){
        soru1 = new Soru(c2bolum5s1[sorusay], c2bolum5c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm5s2")){
        soru1 = new Soru(c2bolum5s2[sorusay], c2bolum5c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm5s3")){
        soru1 = new Soru(c2bolum5s3[sorusay], c2bolum5c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm5s4")){
        soru1 = new Soru(c2bolum5s4[sorusay], c2bolum5c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm5s5")){
        soru1 = new Soru(c2bolum5s5[sorusay], c2bolum5c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm5s6")){
        soru1 = new Soru(c2bolum5s6[sorusay], c2bolum5c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm6s1")){
        soru1 = new Soru(c2bolum6s1[sorusay], c2bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm6s2")){
        soru1 = new Soru(c2bolum6s2[sorusay], c2bolum6c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm6s3")){
        soru1 = new Soru(c2bolum6s3[sorusay], c2bolum6c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm6s4")){
        soru1 = new Soru(c2bolum6s4[sorusay], c2bolum6c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm6s5")){
        soru1 = new Soru(c2bolum6s5[sorusay], c2bolum6c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm6s6")){
        soru1 = new Soru(c2bolum6s1[sorusay], c2bolum6c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm7s1")){
        soru1 = new Soru(c2bolum7s1[sorusay], c2bolum7c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm7s2")){
        soru1 = new Soru(c2bolum7s2[sorusay], c2bolum7c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm7s3")){
        soru1 = new Soru(c2bolum7s3[sorusay], c2bolum7c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm7s4")){
        soru1 = new Soru(c2bolum7s4[sorusay], c2bolum7c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm7s5")){
        soru1 = new Soru(c2bolum7s5[sorusay], c2bolum7c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm7s6")){
        soru1 = new Soru(c2bolum7s6[sorusay], c2bolum7c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm8s1")){
        soru1 = new Soru(c2bolum8s1[sorusay], c2bolum8c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm8s2")){
        soru1 = new Soru(c2bolum8s2[sorusay], c2bolum8c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm8s3")){
        soru1 = new Soru(c2bolum8s3[sorusay], c2bolum8c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm8s4")){
        soru1 = new Soru(c2bolum8s4[sorusay], c2bolum8c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm8s5")){
        soru1 = new Soru(c2bolum8s5[sorusay], c2bolum8c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm8s6")){
        soru1 = new Soru(c2bolum8s6[sorusay], c2bolum8c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm9s1")){
        soru1 = new Soru(c2bolum9s1[sorusay], c2bolum9c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm9s2")){
        soru1 = new Soru(c2bolum9s2[sorusay], c2bolum9c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm9s3")){
        soru1 = new Soru(c2bolum9s3[sorusay], c2bolum9c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm9s4")){
        soru1 = new Soru(c2bolum9s4[sorusay], c2bolum9c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        } else if (Objects.equals(sev, "C2bölüm9s5")){
        soru1 = new Soru(c2bolum9s5[sorusay], c2bolum9c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm9s6")){
        soru1 = new Soru(c2bolum9s6[sorusay], c2bolum9c6[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm10s1")){
        soru1 = new Soru(c2bolum10s1[sorusay], c2bolum10c1[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm10s2")){
        soru1 = new Soru(c2bolum10s2[sorusay], c2bolum10c2[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm10s3")){
        soru1 = new Soru(c2bolum10s3[sorusay], c2bolum10c3[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm10s4")){
        soru1 = new Soru(c2bolum10s4[sorusay], c2bolum10c4[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm10s5")){
        soru1 = new Soru(c2bolum10s5[sorusay], c2bolum10c5[sorusay], yanlislar3, yanlislar4);
        sorusay++;
        soru();
        sure();
        sorudegis();
        }else if (Objects.equals(sev, "C2bölüm10s6")){
        soru1 = new Soru(c2bolum10s6[sorusay], c2bolum10c6[sorusay], yanlislar3, yanlislar4);
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
