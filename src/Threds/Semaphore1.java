package Threds;
import java.util.concurrent.Semaphore;

public class Semaphore1 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(4);
        Thread.sleep(2000);

        System.out.println("toplam par edebilecek yer sayısı :  "+sem.availablePermits());

        Car car1   =new Car("Car1",sem);
        car1.start();
        Car car2   =new Car("Car2",sem);
        car2.start();
        Car car3   =new Car("Car3",sem);
        car3.start();
        Car car4   =new Car("Car4",sem);
        car4.start();
        Car car5   =new Car("Car5",sem);
        car5.start();
        Car car6   =new Car("Car6",sem);
        car6.start();




    } // main sonu
} // public class sonu

class Car extends Thread {
    private String name;
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
            for (int i = 1; i <= 4; i++) {
                System.out.println(name + " parkda " + i + " saattir bekliyor");
                Thread.sleep(10000);
            }
            System.out.println(name + " park yerinden ayrıldı");
            semaphore.release(); // park yerinden çıktı
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}