package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

    public static void main(String[] args) {
        Student01 student01=    new Student01();
        student01.setId(1001);
        student01.setName("Samet Güler");
        student01.setGrade(90);
        //intamce variable oluşturuduk


        Student01 student02= new Student01();
        student02.setId(1002);
        student02.setName("Tarık");
        student02.setGrade(90);


        Student01 student03= new Student01();
        student03.setId(1003);
        student03.setName("Miraç");
        student03.setGrade(70);



        Configuration  con =new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        //Hibernate Configuration dosyamı ve entity clasımı bildiridim

        SessionFactory sf =con.buildSessionFactory();
        //2. adım sesion factory oluşturmak
       Session session= sf.openSession();
       //3. adım   sesion açılacak
       Transaction tx= session.beginTransaction();
       //4. adım tansaction  başlatılacak

       //session.save(student01); // database oluşturmak için yaz
      // session.save(student02); // database oluşturmak için yaz
     // session.save(student03); // database oluşturmak için yaz



       tx.commit();   // DB ye bilgilerimiz gitmez
       session.close();
       sf.close();



    }
}
