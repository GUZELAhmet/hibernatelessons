package Threds;

public class WaitInterrupt {
    static public int balance = 0;

    public static void main(String[] args) {
        WaitInterrupt obj = new WaitInterrupt();
        //withdrow  yapsın
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                obj.withdraw(800);
            }
        });
        thread1.setName("withdraw Threadi");
        thread1.start();
        //deposit yapma
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
               thread1.interrupt();

                //thread2 kibarca thread1 sonlandırıyor
            }

        });
        thread2.setName("Deposit Thread");
        thread2.start();


    }

    public void withdraw(int amount) {
        synchronized (this) {
            if (balance <= 0 || balance < amount) {
                System.out.println("bekleme");
                try {
                    wait();
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                    balance = balance - amount;
                    System.out.println("çekme başarılı");
                }
            }
        }// if sonu


    }

    public void deposit(int amount) {
        balance = balance + amount;
        System.out.println("para yatırma başarılı");
    }
}
