package AdvJavaPractice.Generics.multithreads.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class AppointmentApp {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        String[] users ={"Tolstoy","c.Dikmens"," v.hugo"};

        AppointmentCenter center = new AppointmentCenter();
        for (String user : users) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Randevu tarihiniz  "+center.getAppointmentDate());
                }
            });
            thread.start();
        }

        Worker worker1  = new Worker("A",latch);
        Worker worker2  = new Worker("B",latch);
        Worker worker3  = new Worker("C",latch);
        worker1.start();
        worker2.start();
        worker3. start();



    }

}

