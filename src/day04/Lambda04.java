package day04;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 arklı obj'den List create ediniz.

               private
               constructor
               getter setter

     */
    public static void main(String[] args) {

        Universite bogazici=new Universite("bogazici","matematik",571,93);
        Universite itu=new Universite("istanbul teknik","matematik",622,81);
        Universite istanbul=new Universite("istanbul","hukuk",1453,71);
        Universite marmara=new Universite("marmara","bilgisayar muh",1071,77);
        Universite ytu=new Universite("yıldız teknik","gemi",333,74);

        List<Universite> unv=new ArrayList<>(Arrays.asList(bogazici,itu,istanbul,marmara,ytu));

        System.out.println(notOrt74BykUnv(unv));
        System.out.println("\n  ****  ");
        System.out.println(ogrnSay110AzOLmd(unv));
        System.out.println("\n  ****  ");
        System.out.println(unvMatDrm(unv));
        System.out.println("\n  ****  ");
        ogrcSayBykKck(unv);
        System.out.println("\n  ****  ");
        notOrtBykKck(unv);
        System.out.println("\n  ****  ");
        ogrnSayenAzUnv(unv);
        System.out.println("\n  ****  ");
        notOrt63BykUnvOgrncSayTopl(unv);
        System.out.println("\n  ****  ");
        ogrnSy130BykUnvnNotOrt(unv);
        System.out.println("\n  ****  ");
        matematikBlmSysPrint(unv);
        System.out.println("\n  ****  ");
        ogrncSy130BykUnvEnBykNortOrt(unv);
        System.out.println("\n  ****  ");
        ogrncSy150KckUnvEnKckNortOrt(unv);
    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
        public static boolean notOrt74BykUnv(List<Universite> unv){


        return unv.
                stream().
                anyMatch(t->t.getNotOrt()>74);
        }

    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.
    public static boolean ogrnSay110AzOLmd(List<Universite> unv){

                        //her birine bak//
        return unv.stream().allMatch(t->t.getOgrcSayisi()>110);
    }


    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean unvMatDrm(List<Universite> unv){

        return unv.stream().anyMatch(t->t.getBolum().equalsIgnoreCase("matematik"));
    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static void ogrcSayBykKck(List<Universite> unv){
        unv.stream().map(t->t.getOgrcSayisi()).sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" "));
    }

        //collect()->akısdaki elamanları istenen sarta gore toplar
        //Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir


    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static List<Universite> notOrtBykKck(List<Universite> unv){

        return unv.stream().
                sorted(Comparator.comparing(Universite::getNotOrt).reversed()).//notOrt'a göre b->k sıralandı
                limit(3).// akısın ilk 3 elemanı alındı
                collect(Collectors.toList());//akışın ilk 3 elemanı liste assign edildi.

        }


    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static void ogrnSayenAzUnv(List<Universite> unv){

        unv.stream().
                sorted(Comparator.comparing(Universite::getOgrcSayisi)).
                limit(2).
                skip(1).
                collect(Collectors.toList());
    }


    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
    public static void notOrt63BykUnvOgrncSayTopl(List<Universite> unv){
        System.out.println(unv.
                stream().
                filter(t -> t.getNotOrt() > 63).// üniversiteler akıyor
                map(t -> t.getOgrcSayisi()).// öğrenci sayıları akıyor
                //reduce(Integer::sum));
                //reduce(Math::addExact));
                reduce(0,(t,u)->t+u));
    }
    public static int notOrt63BykUnvOgrncSayTopla(List<Universite> unv) {

        return unv.
                stream().
                filter(t->t.getNotOrt()>63).
                mapToInt(t->t.getOgrcSayisi()).
                sum();
    }


    //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    public static void ogrnSy130BykUnvnNotOrt(List<Universite> unv){
        System.out.println(unv.stream().
                filter(t -> t.getOgrcSayisi() > 333).//akişdaki elemanlar obje
                mapToInt(Universite::getNotOrt).//(bu satırda sadece ınt akıyor))bu method akışdaki elemanları data type'nı
                                                // parametresindeki değere(Int,double) göre update eder.
                average());//akişdaki elemanların ortalaması alınır.

        // mapToInt() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki() degere göre Int data type update eder
        // mapToInt() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki() degere göre Int data type update eder

        // mapToDouble() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki degere göre dooble data type update eder
    }

    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static void matematikBlmSysPrint(List<Universite> unv){

        System.out.println(unv.
                stream().
                filter(t -> t.getBolum().equalsIgnoreCase("matematik")).
                count());//akışdaki eleman sayısını return eder.

        //count();-->akısdaki elelman sayısını return eder
    }

    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    public static void ogrncSy130BykUnvEnBykNortOrt(List<Universite> unv){
        unv.stream().
                filter(t->t.getOgrcSayisi()>571).//unv obj akışı filtrelendi
                mapToInt(t->t.getNotOrt()).//akışdaki unv obje, notOrt akışı olarak update edildi.
                max();//akışın en buyuk değerini return eder.

    }


    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static OptionalInt ogrncSy150KckUnvEnKckNortOrt(List<Universite> unv){

       return unv.stream().
                filter(t->t.getOgrcSayisi()<1071).
                mapToInt(t->t.getNotOrt()).
                min();

    }
}


