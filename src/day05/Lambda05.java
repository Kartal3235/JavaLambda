package lambdaTutorial;

import day01.Lambda01;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println("TASK 01 amele topla-->" + toplaAmele(10));
        System.out.println("TASK 01 cincix topla-->" + toplaCincix(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->");
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->");
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->");
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        System.out.println("   ***   ");

        System.out.println("TASK 06 -->");
        System.out.println("   ***   ");

        System.out.println("TASK 07 -->");
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->");
        System.out.println("   ***   ");

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming
    public static int toplaAmele(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }

    //Functional(cincix Programming

    public static int toplaCincix(int x) {
        return IntStream.// int akış sağlar
                range(1, x + 1).// 1 den x'e kadar (x dahil,x+1 hariç) int değerler akısa alındı
                //range(a,b)==>[a,b)
                        sum();//akışdaki int değerler toplandı

    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x) {
        return IntStream.//int değerleri akış sağlar

                rangeClosed(1, x).// 1 den x'e kadar (x dahil) int değerler akısa alındı
                //rangeClosed(a,b)==>[a,b]

                        filter(Lambda01::ciftBul).// akışdaki çift int değerler filtrelendi.
                        sum();//akışdaki int değerler toplandı

    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int toplaİlkCift(int x) {
        return IntStream.//int değerleri akış sağlar

                iterate(2, t -> t + 2).// 2 den sonsuza kadar elemanları 2 artırarak akışa alır-->2,4,6,8,10..

                //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koy

                        limit(x).// akışdaki ilk x int değeri akışa alır.

                        sum();//akışdaki int değerler toplandı

    }


    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int toplaİlkTek(int x) {
        return IntStream.//int değerleri akış sağlar

                iterate(1, t -> t + 2).// 1 den sonsuza kadar elemanları 2 artırarak akışa alır-->1,3,5,7,9,....

                //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koy

                        limit(x).// akışdaki ilk x int değeri akışa alır.

                        sum();//akışdaki int değerler toplandı

    }


    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkxKuvvetPrint(int x) {

        IntStream.
                iterate(2, t -> t * 2).// 2 den sonsuza kadar elemanları 2 ile çarparak akışa alır-->2,4,6,8,32...

                limit(x).// akışdaki ilk x int değeri akışa alır

                forEach(System.out::println);//yazdırıldı.

    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ıstenilenSayİlkxKuvvetiPrint(int istenenSayi, int x) {

        IntStream.
                iterate(istenenSayi, t -> t * istenenSayi).//

                limit(x).// akışdaki ilk x int değeri akışa alır

                forEach(System.out::println);//yazdırıldı.
    }

        //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.

        public static int istenenSayiFactorial(int x) {
            return IntStream.
                    rangeClosed(1, x).
                    //reduce(Math::multiplyExact).
                            reduce(1, (t, u) -> t * u);
        }


        //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.

        public static double xKuvveti(int istenenSayi,int x){

        return IntStream.iterate(istenenSayi,t->t*istenenSayi).limit(x).reduce(0,(t,u)->u);

        //return Math.pow(istenenSayi,x);
        }


}