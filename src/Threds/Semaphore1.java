package Threds;
import java.util.concurrent.Semaphore;

public class Semaphore1 {
    public static void main(String[] args) {

    } // main sonu
} // public class sonu

class Car extends Thread {
    private String name ;
    Semaphore semaphore;

    // const
    public Car(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            System.out.println(name + " park etmeye çalışıyor");
            semaphore.acquire(); // park etmeye çalışıyor

            System.out.println(name + " Park etti");

            // park süresi 4 saat
            for(int i = 1 ; i<=4 ; i++ ){
                System.out.println(name + " parkda " + i + " saattir bekliyor");
                Thread.sleep(10000);
            }
            System.out.println(name + " park yerinden ayrıldı");
            semaphore.release(); // park yerinden çıktı
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }