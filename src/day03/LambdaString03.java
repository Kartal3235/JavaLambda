package day03;

import day01.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaString03 {
    public static void main(String[] args) {
        List<String> yemek=new ArrayList<>(Arrays.asList("küşleme","adana","trileçe","havuçDilim","buryan",
                "yaglama","kokoreç","arabaşı","güveç","cacix"));
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
        System.out.println("\n  ****  ");
        KrktrSayisiEnBuyuk(yemek);
        System.out.println("\n  ****  ");
        ListElSonhrfSiralaİlkHrcKlnElnPrint(yemek);
        System.out.println("\n  ****  ");
        ListKrkÇftPrint(yemek);
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
    public static void ListKrkÇftPrint(List<String> yemek){

        yemek.stream().
                map(t->t.length()*t.length()).//akışdaki string elemanları boyutlarının karesine update edildi.
                filter(Lambda01::ciftBul).//çift elemanlar filtrelendi
                distinct().//tekrarsız yapıldı
                sorted(Comparator.reverseOrder()).//ters b->k sıralandı
                forEach(System.out::print);//print edildi.
    }


    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void ListElKrtYediAz(List<String> yemek){

        // amele code
        boolean kontrol=yemek.stream().allMatch(t->t.length()<=7);
        if(kontrol){
            System.out.println("list elemanları 7 ve daha az harften oluşuyor");
        }else System.out.println("list elemanları 7 harften büyük ");

        //cincix code
        System.out.println("cincix code");
        System.out.println(yemek.
                stream().
                allMatch(t -> t.length() <= 7) ? "list elemanları 7 ve daha az harften olusuyor" : "list elemanları 7 harften  buyuk");
    }

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.



    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void ListElWBas(List<String> yemek){
        System.out.println(yemek.stream().
                noneMatch(t -> t.startsWith("w")) ? "agam w ile başlayan yemahh olu mu ?" :
                "agam  wenemen ne menen bi şey  ?");

    }
    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void ListElXBtn(List<String> yemek){
        System.out.println(yemek.
                stream().
                anyMatch(t->t.endsWith("x"))?"agam senden bi cacık olmaz":"agam x ile biten yok ki");
    }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void KrktrSayisiEnBuyuk(List<String> yemek){

        Stream<String> sonIsım=yemek.
                stream().
                sorted(Comparator.comparing(t->t.toString().length()).
                        reversed()).
                //findFirst());// ilk eleman alındı
                limit(1);////limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır
        /*
       sonIsim.toArray()--> limit() meth return dan dolayı  stream type olan sonIsim toArray() method ile array type convert edildi
         */

        System.out.println(Arrays.toString(sonIsım.toArray()));//arraya cevrilen sonIsim stream print edildi
        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder. Stream return eder.

         /*
  TRİCK : •    Stream'ler ekrana direk yazdırılamaz. Stream'i toArray() ile Array'e çeviririz. Array'i de Arrays.toString() 'in içine alıp yazdırabiliriz.
•  Ör; System.out.println(Arrays.toString(***.toArray())); veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir.

   */

    }

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ListElSonhrfSiralaİlkHrcKlnElnPrint(List<String> yemek){

        yemek.
                stream().//akışa alındı
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).// son harfe göre sıralandı
                skip(1).// ilk eleman atlandı
                forEach(t-> System.out.print(t+" "));//print edildi.


        //skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
        // Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
        //skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.

    }

}
