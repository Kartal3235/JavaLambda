package lambdaTutorial;

import day01.Lambda01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda06 {

    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");

        Path haluk= Path.of("src/haluk.txt");// path haluk obj atandı
        Stream<String> akıs=Files.lines(haluk);// haluk.txt dataları akıs stream'e atandı


        //1.yol
        Files. lines(haluk).
                //Files classdan lines() method call edilerek
                // data çekilecek dosya yolu (path)parametre
                // girilerek path deki dosyanın datları akışa alındı

                forEach(System.out::println);// akışdaki datalar (her satırdaki string)yazıldı.

        //2.yol
        akıs.forEach(System.out::println);

        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");

        Files. lines(Paths.get("src/haluk.txt")).

                map(String::toUpperCase).// akışdaki datalar buyuk harfe update edildi.

                        forEach(System.out::println);// akışdaki datalar (her satırdaki string)yazıldı

        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");

        Files. lines(haluk).

                limit(1).// ilk satırı yazdır
                //findFirst();==> ile de yapılır

                map(String::toLowerCase).// akışdaki datalar kucuk  harfe update edildi

                forEach(System.out::println);// akışdaki datalar (her satırdaki string)yazıldı



        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");

        System.out.println(Files.lines(haluk).map(String::toLowerCase).filter(t -> t.contains("basari")).count());


        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");

        /*
        Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
        fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
        Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.

        Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
        Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
        flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
        ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.

        */

        System.out.println(Files.lines(haluk).
                map(t -> t.split(" ")).// satırlardaki elemanlar akışa alındı
                flatMap(Arrays::stream).//2D arraydaki elemanlar tek eleman olarak akısa alındı
                distinct().//akışdaki elemanlar tekrarsız yapıldı
                collect(Collectors.toList()));//akışdaki tekrarsız elemanlar liste atandı

        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        Files.lines(haluk).
                map(t -> t.split(" ")).//satırlardaki kelimeler arraya atandı
                flatMap(Arrays::stream).// 2D arraydaki elemanlar tek eleman olarak akısa alındı
                sorted().//harf sıreası yapıldı
                forEach(System.out::println);//print edildi.


        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");

        System.out.println(Files.lines(haluk).

                map(t -> t.toLowerCase().split(" ")).flatMap(Arrays::stream).filter(t -> t.contains("basari")).count());

        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");


        System.out.println(Files.lines(haluk).
                map(t -> t.toLowerCase().split(" ")).//satırlar akısa alındı
                flatMap(Arrays::stream).// her satırdaki her kelime akışa alındı
                filter(t -> t.contains("a")).// a bulunduran kelimeler filtrelendi
                count());// a bulundurulan kelimeler sayıldı

        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");

        System.out.println(Files.lines(haluk).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).
                collect(Collectors.toList()));

        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(haluk).
                map(t -> t.replaceAll("\\W","").// satırlar \\W ifadesi a-z A_Z 0-9 dışındaki kapsar
                        replaceAll("\\d","").//rakamları hiçlik yapar
                        split("")).// boşluk bırakırsak kelimeleri sayar,"" hiçlik yaparsak harfleri sayar
                flatMap(Arrays::stream).
                distinct().
                count());


        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");

        System.out.println(Files.lines(haluk).
                map(t -> t.replaceAll("\\W", "").
                        replaceAll("\\d", "").
                        split(" ")).// kelimeler akışa alındı
                        flatMap(Arrays::stream).
                distinct().
                count());

        //TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz
        System.out.println("\nTASK 12 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        Files.lines(haluk).
                map(t -> t.replaceAll("[.!,:)\\-]", "").
                        split(" ")).//kelime akısı saglanır
                flatMap(Arrays::stream).
                distinct().forEach(System.out::println);

    }
}
