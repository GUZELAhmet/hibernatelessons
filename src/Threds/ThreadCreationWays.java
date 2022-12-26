package Threds;

public class ThreadCreationWays {

    public static void main(String[] args) {
        //ilk çalışan thread main thread i
        System.out.println("current thread : " + Thread.currentThread().getName());//şu anda çalışan thread ismin getirir
        MyThread thread = new MyThread();
       //thread.run();//thread oluşmadan sadece methodu çalıştırır
        thread.start();//thread sınıfında run() methodunda yazılanlar işleme alınır
        // thread sınıfında run() metodunda yazılanlar işlenmeye başlar
// run() diyerekte çağırdığımızda method yine çalışıyor , start() ile çağırmamız
        // arasındaki fark : run() ile çağırıldığında thread değişmez sadece methos çalışır
        // start() da ise önce thread ayağa kalkar daha sonra içindeki run() metodu çalışır
        Myrunnable runnable = new Myrunnable();
        Thread thread2= new Thread(runnable);
        thread2.start();
         // !!! isimsiz olarak thread oluşturma , annonymous (interface)
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Current thread:" + Thread.currentThread().getName());
                System.out.println("bu isimsiz class yoluyla oluşturulan iş parçacığı");
            }         });
        thread3.setName("thread3");//thread  3  isim verdik*************
        thread3.start();

        // isimsiz olarak thread oluşturalım 2. yol
        Thread thread4 = new Thread(()-> {
            System.out.println( "lambda ile yazıldı");
        });
        thread4.start();
        System.out.println("bu yazı nezaman çıkar");
        Thread thread5 = new Thread(()-> {
            System.out.println("lambda ile yazılan 2. thread thread 5 çalıştı");
        });
        thread5.start();
    }   }
//1.yol  : thread classını extend ederek********************************
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread threadı  çalışıyor");
    }  }
//2.yol Runnable Interface i implement ederek**********************************
 class Myrunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable interface den türetilen  thread  çalıştı");
    }  }


