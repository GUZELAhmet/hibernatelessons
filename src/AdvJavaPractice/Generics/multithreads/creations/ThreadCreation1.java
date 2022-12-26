package AdvJavaPractice.Generics.multithreads.creations;
/*

1) Multithreading Programlama nedir?
    Aynı processde iki veya daha fazla iş parçacığının(thread) aynı anda çalışma süreci

2) Threadler 2 şekilde oluşturulur:

        --Thread sınıfından extend eden alt sınıf oluşturup, onun run metodu override edilir.

         --Runnable interfaceini implement eden bir alt sınıf oluşturup run metodu override edilir,
         ardından Thread sınıfının constructorına nesne olarak gönderilir.
2a) Hangi yöntem daha kullanışlı?
    Genellikle Runnable interfaceini implement ederek oluşturmak daha çok tercih
    edilir çünkü Javada sadece bir class extend edebiliriz bu hakkımızı Thread ile
    harcamak istemeyiz.

3) Run metodunu doğrudan Main metodundan çağırabilir miyiz?

   Evet, ancak thread oluşturulmaz.

4) Javada herhangi bir thread oluşturmazsak uygulamalar nerde/nasıl çalışır?

   Java varsayılan olarak tüm uygulamalarda main threadini  kullanılır.


*/
public class ThreadCreation1 {

    //Task1: Thread sınıfını extend eden Sayac isminde sınıf oluşturup
// bu sınıftan sayıları 1 den 100 e kadar yazdıran iki tane thread oluşturunuz.

    public static void main(String[] args) {
        Sayac say1=new Sayac("abc");
        say1.start();
        Sayac say2=new Sayac("def");
        say2.start();
    }

}
class Sayac extends Thread {
    private String name;

    public Sayac(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name+" başladı.");
        for (int i=1;i<=100;i++){
            System.out.println(this.name+ " - "+i);
        }
        System.out.println(this.name+" bitirdi.");
    }
}
