package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // get methodu
        Student07 student1=session.get(Student07.class,1001);
//        student1.getBookList().forEach(a->{
//            System.out.println(a);
//        });
        student1.getBookList().forEach(System.out::println);// method referans

        //sql ile öğrenci bilgilerini alalım
        String sqlQuery = "SELECT s.student_name, b.name FROM student07 as s inner  join book07 as b on s.id = b.student_id";

       List<Object[]> resultList1=  session.createSQLQuery(sqlQuery).getResultList();
       resultList1.forEach(a->{
           System.out.println(Arrays.toString(a));
       });


//        // !!! SQL ile öğrenci bilgilerini alalım ( öğrenci ismi ve kitap ismi )
//        String sqlQuery =
//                "SELECT s.student_name,b.name FROM student07 s INNER JOIN book07 b ON s.id=b.student_id";
//        List<Object[]> resulList1 = session.createSQLQuery(sqlQuery).getResultList();
//        for (Object[] object: resulList1) {
//            System.out.println(Arrays.toString(object));
//        }

        // !!! yukardaki sorguyu HQL ile yazalım
        String hqlQuery =
                "SELECT s.name,b.name FROM Student07 s INNER JOIN FETCH Book07 b ON s.id=b.student.id";
        List<Object[]> resultList2 = session.createQuery(hqlQuery).getResultList();
        resultList2.forEach(oa->System.out.println(Arrays.toString(oa)));



        tx.commit();
        session.close();
        sf.close();




    }
}

