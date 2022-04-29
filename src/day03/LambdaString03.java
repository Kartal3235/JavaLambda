package day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaString03 {
    public static void main(String[] args) {
        List<String> yemek=new ArrayList<>(Arrays.asList("küşleme","adana","trileçe","havuçDilim","buryan",
                "yaglama","kokoreç","arabaşı","güveç"));
        System.out.println("\n  ****  ");
        alfBykTekrrsz(yemek);
        System.out.println("\n  ****  ");
        chrSayisiTersSiralı(yemek);
        System.out.println("\n  ****  ");
        chrSayisiBkSirala(yemek);
        System.out.println("\n  ****  ");
        sonHrfBkSirala(yemek);
        System.out.println("\n  ****  ");
        ListElKrtYediAz(yemek);
        System.out.println("\n  ****  ");
        ListElWBas(yemek);
        System.out.println("\n  ****  ");
        ListElXBtn(yemek);
    }
    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrrsz(List<String> yemek){

        yemek.//akış kaynağı
                stream().// akışa girdi
                //map(t->t.toUpperCase()).//Lambda Exp. elemanlar büyük harf update edildi.
                map(String::toUpperCase).//Meth Ref.edilerek yapıldı
                sorted().//alfabetik(natural doğal) sıra yapıldı
                distinct().//tekrarsız hale getirildi
                forEach(t-> System.out.print(t+ " "));//print edildi.

        //distinct() => Bu method tekrarlı elemanları sadece bir kere yazdırır.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.

    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersSiralı(List<String> yemek){
        yemek.
                stream().
                //map(t->t.length()).
                map(String::length). //elemanlar karakter sayısına update edildi
                sorted(Comparator.reverseOrder()).// ters sıra yapıldı
                distinct().// benzersiz yapıldı
                forEach(t-> System.out.print(t+" "));//print edildi.

    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
public static void chrSayisiBkSirala(List<String> yemek){
        yemek.
                stream().
                sorted(Comparator.
                        comparing(String::length)).
                forEach(t-> System.out.print(t+" "));
}

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHrfBkSirala(List<String> yemek){
        yemek.
                stream().
                sorted(Comparator.
                        comparing(t->t.toString().// toString yaparak null un önüne geçiyoruz,çünkü yemeğin içinde boş kısımda olabilir.boş kısım null verir
                                charAt(t.toString().length()-1)).
                        reversed()).
                forEach(t-> System.out.print(t+" "));
    }


    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void ListElKrtYediAz(List<String> yemek){
        yemek.stream().map(String::length).filter(t->t<=7).forEach(t-> System.out.print(t+" "));

    }

    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void ListElWBas(List<String> yemek){
        yemek.stream().map(t->t.startsWith("W")).forEach(t-> System.out.print(t+" "));
    }
    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void ListElXBtn(List<String> yemek){
        yemek.stream().map(t->t.endsWith("X")).forEach(t-> System.out.print(t+" "));
    }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

}
