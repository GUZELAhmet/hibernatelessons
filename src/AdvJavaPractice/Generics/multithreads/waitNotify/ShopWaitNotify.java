package AdvJavaPractice.Generics.multithreads.waitNotify;
/*
TASK: Bir marketteki stok miktarını takip eden bir uygulama tasarlayınız.
      Markette yeterli ürün yoksa yeni ürün gelmesi beklensin.
      Yeni ürün eklenince ürün satışı gerçekleşsin.
*/
public class ShopWaitNotify {
    public volatile  static  int stock=3;

    public static void main(String[] args) {

        ShopWaitNotify shop=new ShopWaitNotify();
        Thread consumerThread=new Thread(new Runnable() {

            @Override
            public void run() {
                shop.consumeProduct(3);

            }
        });
        consumerThread.setName("Tüketici");
        consumerThread.start();
        Thread producerThread=new Thread(new Runnable() {
            @Override
            public void run() {
                shop.produeProduct(5);
            }
        });

        producerThread.setName("üretici");
        producerThread.start();






    }
    public synchronized void consumeProduct(int amount ){
        if (amount>stock){
            System.out.println();
            System.out.println(Thread.currentThread().getName() +"ürün satın almak istiyor");
            System.out.println("yeterli ürün yok ,güncel ürün stoğu: " +stock);
            System.out.println("tüketici ürüngirişi yapılmaını bekliyor");
            try {
                wait();
            } catch (InterruptedException ignored) {



        }
        if (amount<stock){
            System.out.println();
            System.out.println(Thread.currentThread().getName()+" ürün satın almak istiyor");
            System.out.println("ürün satın alındı stocktan düşülüyor");
            stock=stock-amount;
            System.out.println("güncel stok: "+stock);
        }

    }
}

public synchronized void produeProduct(int amount){
    System.out.println();
    System.out.println((Thread.currentThread().getName()+ " ürün eklemek istiyor"));
    System.out.println("yeni ürünler eklendi stock güncelleniyor");
    stock=stock+amount;
    System.out.println("güncel stok "+stock);
    notify();
}


}
