package day02;

import day01.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));
        ciftKarePrint(sayi);//1156 484 256 400 64 1444
        System.out.println("\n  ******  ");
        tekKupBırFazlaprint(sayi);
        System.out.println("\n  ******  ");
        cıftKarePrint(sayi);
        System.out.println("\n  ******  ");
        maxEl(sayi);
        System.out.println("\n  ******  ");
        ciftKareMaxBullet(sayi);
        System.out.println("\n  ******  ");
        elemanTopla(sayi);
        System.out.println("\n  ******  ");
        cıftElCarpımı(sayi);

    }

    // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi) {

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                forEach(Lambda01::yazdir);

        /*map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya
        üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.
         */

    }
    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi


    public static void tekKupBırFazlaprint(List<Integer> sayi){
        sayi.
                stream().// sayılar akışa alındı
                filter(t->t%2!=0).//tek elemanlar filtrelendi
                map(t->(t*t*t)+1).//tek elemanları küplerin 1 faz<lasına update edildi
                forEach(Lambda01::yazdir);//print edildi.

    }
    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz


    public static void cıftKarePrint(List<Integer>sayi){

    sayi.
            stream().
            filter(Lambda01::ciftBul).
            map(Math::sqrt).// method refere yaptık==>double değer return eder.
            //forEach(Lambda01::yazdir);==> yazdır() methodu int çalıştığı için map den çıkan dataları çalıştırmaz
            forEach(t-> System.out.println(t+" "));
    }
// Task : list'in en buyuk elemanini yazdiriniz

    public static void maxEl(List<Integer>sayi){

      Optional<Integer> maxSayi=sayi.
              stream().
              reduce(Math::max);//akışa giren elemanların action sonrası tek eleman haline getir.

        System.out.println(maxSayi);//15

        /*
       reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
       kullanımı yaygındır pratiktir.
       Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
       bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
       reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
       reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
       İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

 */
    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftKareMaxBullet(List<Integer> sayi){

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Math::max));//36


        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max));//36 specific class daha hızlı run olur.
    }

         // Task : List'teki tum elemanlarin toplamini yazdiriniz.
        //Lambda Expression...
    public static void elemanTopla(List<Integer> sayi){

        int toplam=sayi.stream().reduce(0,(a,b)->a+b);//Lambda Expression...

       /*
       a ilk değerini her zaman atanan değerden (identity) alır
       b değerini her zaman stream()'dan akışdan alır
       a ilk değerinden sonraki her değeri action(işlem)'dan alır.
        */

        Optional<Integer> sayi1=sayi.stream().reduce(Integer::sum); //method ref
        System.out.println(sayi1);//Optional[43]
        System.out.println(toplam);//43
    }
    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void cıftElCarpımı(List<Integer> sayi){

        sayi.stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact);//meth ref
        // Lambda Expression
        sayi.stream().
                filter(Lambda01::ciftBul).
                reduce(1,(a,b)->(a*b));//ilk değeri 1 aldık çünkü çarpım yapıyoruz

        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));//Optional[48]
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(1, (a, b) -> (a * b)));//48

    }

}
