package com.hb12.caching;

import com.hb11.criteriaapi.Student11;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch12 {
    public static void main(String[] args) {


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //1--
        System.out.println("ilk get işlemi 1 id li öğrenci için*************************");
        Student12 student1=session.get(Student12.class,1L);
       // System.out.println(student1.getName());
       // session.clear();// cache içini sıfırladık


//        System.out.println("2. get işlemi 1 id li öğrenci için*************************");
//        Student12 student2=session.get(Student12.class,1L);



        tx.commit();
        session.close();
        // first level cache mekanizmasında alt satırdaki kodlar için yeni bir query oluşturulur
        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();
        System.out.println("session close sonrası get işlemi 1 id li öğrenci için : ");
        Student12 student3 = session2.get(Student12.class,1L);

        tx2.commit();
        session2.close();
        sf.close();
    }
}