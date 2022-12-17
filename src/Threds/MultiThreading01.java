package Threds;

import org.w3c.dom.css.Counter;

public class MultiThreading01 {
    public static void main(String[] args) throws InterruptedException {
       Long startTime= System.currentTimeMillis();
        CounterWithoutMultiThread counter1 = new CounterWithoutMultiThread(1);
        CounterWithoutMultiThread counter2 = new CounterWithoutMultiThread(2);
        counter1.countMe();
        System.out.println("------------------------");
        counter2.countMe();
        Long endTime = System.currentTimeMillis();
        System.out.println("WithoutMultiThread ile geçen süre "+(endTime-startTime));
        System.out.println("************************************************************");
        Long startTime2= System.currentTimeMillis();
        CounterWithMultiThread counter3 = new CounterWithMultiThread(1);
        CounterWithMultiThread counter4 = new CounterWithMultiThread(2);
        counter3.start();
        System.out.println("----------------------");
        counter4.start();
        counter3.join();//
        counter4.join();// bu thread geçmeden alt satıra geçme
        Long endTime2= System.currentTimeMillis();
        System.out.println("MultiThread ile geçen süre "+(endTime2-startTime2));




    }


}

class CounterWithoutMultiThread {
    private int threadNum;

    //constructor
    public CounterWithoutMultiThread(int threadNum) {
        this.threadNum = threadNum;

    }

    public void countMe() throws InterruptedException {
        for (int i = 0; i <= 10; i++) {
            //Thread.sleep(500);// 0.5 saniye yavaşlasın
            System.out.println("i = " + i + "thread number" + threadNum);

        }
    }
}

class CounterWithMultiThread  extends Thread{
    private  int threadNum;

    public CounterWithMultiThread(int threadNum) {
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        try {
            countMe();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void countMe() throws InterruptedException {
        for (int i = 0; i <= 10; i++) {
          //  Thread.sleep(500);// 0.5 saniye yavaşlasın
            System.out.println("i = " + i + "thread number" + threadNum);

        }
    }
}
