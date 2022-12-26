package Threds;

public class WaitNotify {
    public static  int balance=0;

    public static void main(String[] args) {
   WaitNotify obj = new WaitNotify();
   //thread1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.wirhdraw(800);
            }
        });
            thread1.setName("whithdraw thread");
            thread1.start();

            //thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
            }
        });
        thread2.setName("deposit thread");
        thread2.start();
    }

    //para çekme methodu
    public void wirhdraw(int amount){
        synchronized ( this){
            if (balance<=0 || balance<amount){
                System.out.println("balance değeri değişinceye kadar bekliyoruz");
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }//synchronized blok sonu
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //wait işlemi bittikten sonra veya balance değeri yeterli ise
        balance=balance-amount;
        System.out.println("para çekme işlemi başarı ile gerçekleştirildi");
    }


    //para yatırma  methodu
    public void deposit(int amount){
        balance=balance+amount;
        System.out.println("para yatırma işleminiz başarıyla gerçekleşmiştir");
        synchronized (this){
            notify();
        }
    }
}


