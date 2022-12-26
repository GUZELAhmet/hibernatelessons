package Threds;
// hangi durumlarda Deadlock oluşur
public class DeadLockDemo {
    public static void main(String[] args) {
        final String lock1="lock1";
        final String lock2="lock2";

        //Thred1
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("thread1, lock1 değişkenini kilitledi");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock2) {
                        System.out.println("Thread1, lock2 değişkenini kilitledi");
                    }

                }
            }
        });
        thread1.start();


        //Thred2
        Thread thread2=new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("thread2, lock1 değişkenini kilitledi");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock2) {
                        System.out.println("Thread2, lock2 değişkenini kilitledi");
                    }

                }
            }

        });
        thread2.start();
    }

}
