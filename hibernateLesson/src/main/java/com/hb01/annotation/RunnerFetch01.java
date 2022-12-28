package com.hb01.annotation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {
        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);

        SessionFactory sf=con.buildSessionFactory();

        Session session =sf.openSession();

        Transaction tx=session.beginTransaction();
        // DB den bilgi almak için 3 yol var
        //1) get ()
        //2) SQL
        //3) HQL

        //1 yol   get
//        Student01 student1=session.get(Student01.class,1001);
//
//        Student01 student2=session.get(Student01.class,1002);
//
//        Student01 student3=session.get(Student01.class,1003);
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);
         //2.yol SQL
//            String sqlQery="select * from t_student01;";
//            List<Object[]> resultList=session.createSQLQuery(sqlQery).getResultList();
//
//             for (Object[] row : resultList){
//                 System.out.println(Arrays.toString(row));
//             }

             // 3.yol HQL
        // trick  HQL sorgusunda Fromdan sonra class  isimi kullanılır
        String hqlQuery="From Student01";
        List<Student01> resultList2 =  session.createQuery(hqlQuery, Student01.class).getResultList();
        for (Student01 student01: resultList2 ) {
           System.out.println(student01);
       }


           // DÖNECEK KAYDIN UNİQE (TEKBİR TANE OLDUĞUNDAN EMİNSENİZ UNİQUErESULT() METHODU KULLNAILABİLİR

        String sqlQuery2 ="Select * from t_student01 where student_name='Tarık';";
           Object[] uniqueResult1=(Object[])  session.createSQLQuery(sqlQuery2).uniqueResult();
                System.out.println(Arrays.toString(uniqueResult1));
        //yukarda 1 obje gelecek ama içinde kolonlar olduğu için array türünde obje geldi

        //uniqueResult  with HQL ***********************
        String hqlQuery2 =" from  Student01 where name='Tarık'";
        Student01 uniqueResult2=session.createQuery(hqlQuery2,Student01.class).uniqueResult();
        System.out.println(uniqueResult2);

        // yukarıdaki sorguyu HQL Alias kullanarak yapalım
        String  hqlQuery3="FROM Student01 std WHERE std.name='Miraç'";
        Student01 uniqResult2=session.createQuery(hqlQuery3,Student01.class).uniqueResult();
        System.out.println(uniqResult2);
        //**************************************************************************************
        // grade değeri 90 olan öğrenciyigetirelim
        String hqlQery4="SELECT s.id,s.name FROM Student01 s WHERE s.grade=90 ";
        List<Object[]> ResultList4= session.createQuery(hqlQery4).getResultList();
        for (Object[] s : ResultList4 ) {
            System.out.println(Arrays.toString(s));
        }


        tx.commit();
        session.close();
        sf.close();


    }
}
