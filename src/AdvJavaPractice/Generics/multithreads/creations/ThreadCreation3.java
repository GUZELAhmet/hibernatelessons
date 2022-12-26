package AdvJavaPractice.Generics.multithreads.creations;

public class ThreadCreation3 {
    //Task4: anonymous class kullanarak thread oluşturunuz.
//       lambda expression kullanarak thread oluşturunuz.
    public static void main(String[] args) {


        Thread thr1=new Thread(new Runnable() {

            @Override
            public void run() {
                Thread.currentThread().setName("Twety");

                for (int i = 0; i <=100; i++) {
                    System.out.println( Thread.currentThread().getName()+"--" +"kaçıyorum");

                }

            }
        });
        thr1.start();
        Thread thr2 = new Thread(()->{
            Thread.currentThread().setName("Slyvvester");
            for (int i = 0; i <=100; i++) {
                System.out.println( Thread.currentThread().getName()+"--" +"yakalayacağım");
            }

        });
        thr2.start();
    }


}
