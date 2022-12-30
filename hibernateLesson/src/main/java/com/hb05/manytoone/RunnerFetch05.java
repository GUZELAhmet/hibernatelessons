package com.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {

    public static void main(String[] args) {



    Configuration con = new Configuration().configure("hibernate.cfg.xml");
    // addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);
    SessionFactory sf = con.buildSessionFactory();
    Session session = sf.openSession();
    Transaction tx = session.beginTransaction();
    //get methodu
    Student06 student1=session.get(Student06.class,1001);
        System.out.println(student1.getUniversity());
        System.out.println(student1);

        //1 id  universiteye giden tüm öğrencileri getirinS

        String hqlQuery="From Student05 s where s.university.id=1";
        List<Student06> resultList=  session.createQuery(hqlQuery, Student06.class).getResultList();
     resultList.forEach(oa->{
         System.out.println(oa);
     });

        tx.commit();
        session.close();
        sf.close();
}
}