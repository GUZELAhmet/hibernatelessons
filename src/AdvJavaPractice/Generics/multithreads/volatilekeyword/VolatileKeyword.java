package AdvJavaPractice.Generics.multithreads.volatilekeyword;
/*
Birden fazla thread kullanılan bir uygulamada ,değişkenler performans nedeniyle CPU cache'inde tutulabilir.
Bilgisayarın birden fazla CPU'su(çekirdek) olduğunu düşünürsek her thread farklı CPU üzerinde çalısabilir
bu nedenle her thread değişkenlerin değerini CPU cache'ine farklı değerde yazabilir.

"volatile" keywordü değişken üzerinde bir değişiklik olduğunda diğer threadler tarafından görünmesini garanti eder.
"volatile" bir değişken CPU cache yerine bilgisayarın main memory'sinden okunur ve CPU cache yerine main memory'sine yazılır.
non-volatile değişkenler için böyle bir garanti yoktur.

TASK: Banka/Hastahane işlemleri için sıra numarası veren bir uygulama(Numerator) tasarlayınız.
      Uygulama her talep için bir sonraki sırayı vermeli.
*/
public class VolatileKeyword {
    public static void main(String[] args) {
        Numerator n = new Numerator();
        Thread  thread= new Thread(new Runnable(
        ) {
            @Override
            public void run() {
                n.getOrder();

            }
        });
        thread.setName("Ali");
        thread.start();
        Thread  thread2= new Thread(new Runnable(
        ) {
            @Override
            public void run() {
                n.getOrder();

            }
        });
        thread2.setName("Veli");
        thread2.start();
        Thread  thread3= new Thread(new Runnable(
        ) {
            @Override
            public void run() {
                n.getOrder();

            }
        });
        thread3.setName("Ayşe");
        thread3.start();
    }
}
