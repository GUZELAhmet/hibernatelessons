package Threds;
// threadler aynı kaynağa erişmek isterlerse  ne olacak
public class MultiThreading02 {
    public  static  int counter =0;

    public static void main(String[] args) throws InterruptedException {
        // ayrı ikitane trhead oluşturup aynı kaynağa erişmesini sağlayalım
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread1 çalıştı");
            }         });
        thread1.start();

        //2. thread oluşturuyoruz
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread2 çalıştı");
            }           });
       // thread1.join();
        thread2.start();
    }   }

class Counter {
    public synchronized static void count(){// synchronized  bir thread bitmeden diğer thread için methodu çalıştırmaz
       //method içine aynı anda sadece bir thread  girebilecek
        for (int i = 0; i <1000 ; i++) {
            MultiThreading02.counter++;
            }
        System.out.println("MultiThreading02.counter = " + MultiThreading02.counter);
    }   }