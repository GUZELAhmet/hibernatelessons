package Threds;

public class MultiThreading04 {
    public static void main(String[] args) throws InterruptedException {
   Brackets2 brackets2= new Brackets2();
   Long startsTimee=System.currentTimeMillis();

   Thread thread1 =new Thread(new Runnable() {
       @Override
       public void run() {

           for (int i = 0; i <=7; i++) {

               brackets2.generateBracket(1);

           }        }    });

   //thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <=7 ; i++) {

                    brackets2.generateBracket(2);


                }            }        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        Long endTime = System.currentTimeMillis();
        System.out.println("toplam geçen süre= "+(endTime-startsTimee));
    }
}

class Brackets2{
    public     void generateBracket(int a){
        synchronized(this) {
            System.out.println(a + " syn");
            // methodun belirli bir kısmını sencron yapar
            for (int i = 0; i <= 10; i++) {
                if (i <= 5) System.out.print("[");
                else System.out.print("]");
            }
            System.out.println("");
        }
        System.out.println(a + " syn not");
        for (int i = 0; i <=5 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }     }  }
