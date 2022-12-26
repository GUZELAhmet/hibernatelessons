package AdvJavaPractice.Generics.multithreads.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Thread yaratmak cidden maliyetli bir olaydır. Her Thread için sistemde belli bir kaynak ayrılır.
Bu kaynaklar CPU, Hafıza gibi önemli olanlardır. Uygulamamız çalışırken belli miktarda bir Thread
ile sınırlandırmak isteyebiliriz.

Bu nedenle Thread havuzu oluşturup bu havuzu önceden oluşturulmuş ve kullanıma hazır Thread nesneleri
ile doldururuz. Böylece, performans kazanımı ve sistem kaynaklarının verimli kullanımını sağlayabiliriz.

Task: Bir randevu oluşturma uygulaması tasarlayınız.(AppoinmentCenter)
      Uygulama herbir talep için bir gün sonrasına tarih
      vermelidir. 5 kişi için randevu alınmak isteniyor.
      Thread havuzu oluşturup işleri 3 threade yaptırınız.
*/
public class AppoinmentApp2 {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(3);
        String[] users ={"Tolstoy","Balzac","VictorHugo","C.Dickens","Dostoyevski"};
        AppoinmentCenter2 appoinmentCenter =new AppoinmentCenter2();
        for (String user : users){
            MyThread thread=new MyThread(appoinmentCenter);
            service.execute(thread);
        }
        service.shutdown();

    }


}

class MyThread extends Thread {
    private  AppoinmentCenter2  appoinmentCenter;

    public MyThread(AppoinmentCenter2 appoinmentCenter) {
        this.appoinmentCenter = appoinmentCenter;
    }

    @Override
    public void run() {
        String tName =Thread.currentThread().getName();
        System.out.println(tName+ "  başladı");
        System.out.println("Randevu tarihiniz  "+appoinmentCenter.getAppointmentDate());
        System.out.println(".."+tName+" bitti.");

    }
}
