package com.hb13.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*
   get() ---> gerçek nesneyi döndürür ,
               nesne yoksa null döner
               nesnenin olduğundan emin değilseniz get() kullanın
               dönen nesneye hemen kullanacaksam get() kullanılmalı
   load() --> proxy nesne döndürür, gerçek nesnenin gölgesi ,
               nesne yoksa exception fırlatır
               dönen nesne üzerinde delete yapılacaksa kullanılabilir
 */

public class RunnerFetch13 {

    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Get methodu başladı");
Student13 student1=session.get(Student13.class,1L);
        System.out.println("get methodu bitti");
        System.out.println("student id: "+student1.getId());
        System.out.println("student1.getName() = " + student1.getName());


        System.out.println("**************************************************************");

        // yukardaki örneği load methodu ile yapalım

        System.out.println("Load methodu başladı");
        Student13 student2=session.load(Student13.class,2L);
        System.out.println("Load methodu bitti");
        System.out.println("student id: "+student2.getId());
        System.out.println("student1.getName() = " + student2.getName());


        //DB de olmayan Id  çağrırısak ne olut
        System.out.println("get medhotu olmayan ıd için çalışmaya başladı");
        Student13 student3=session.get(Student13.class,10L);
        System.out.println("get medhotu olmayan ıd için çalışması bitti");
       if(student3!=null) {
           System.out.println("get name:   " + student3);
       }
      System.out.println("load medhotu olmayan ıd için çalışmaya başladı");
      Student13 student4=session.load(Student13.class,10L);

        System.out.println("load medhotu olmayan ıd için çalışması bitti");
      if(student4!=null) {
          System.out.println("get name:   " + student4);
      }

      //!!! peki load Methodu niye kullanılır
        Student13 student5=session.load(Student13.class,1L);
      session.delete(student5);
      // load methodu ile obje referansı alınır ve sonra delete çağrılır
        //get methodu çağrılmayarak  DB ye hit engellenmiş olur
        Student13 student6=session.load(Student13.class,1L);
        session.delete(student6);



        tx.commit();
        session.close();
        sf.close();
    }
}
