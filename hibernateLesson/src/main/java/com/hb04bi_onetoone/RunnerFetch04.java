package com.hb04bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);
        SessionFactory sf =  con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx =  session.beginTransaction();

       //belli br ıd ile studenti getirleim
        Student04 student= session.get(Student04.class,1001);
        //diary gt edelim
        Diary04 diary= session.get(Diary04.class,101);
        System.out.println(student);
        System.out.println("****************************************************************");
        System.out.println(diary);
        System.out.println("****************************************************************");
        System.out.println(diary.getStudent());
        System.out.println(student.getDiary());

        String hqlQuery="SELECT s.name, d.name FROM Student04 s inner join fetch Diary04 d on s.id=d.student";

        List<Object[]> resultList=session.createQuery(hqlQuery).getResultList();
        for(Object[] result : resultList){
            System.out.println(Arrays.toString(result));
        }

//        resultList.forEach(oa->{
//            System.out.println(Arrays.toString(oa);
//        });

        //left join
        //kısaca bütün öğrenciler ve kitabı olan öğrencileri istiyorum
        String hqlQuery2=
                "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Diary04 d on s.id=d.student";
       List<Object[]>  resultList2= session.createQuery(hqlQuery2).getResultList();

       resultList2.forEach(oa->{
                   System.out.println(Arrays.toString(oa));
               }

       );

       //right join
        //

        String hqlQuery3=
                "SELECT s.name, d.name FROM Student04 s right JOIN FETCH Diary04 d on s.id=d.student";
        List<Object[]>  resultList3= session.createQuery(hqlQuery3).getResultList();

        resultList3.forEach(oa->{
                    System.out.println(Arrays.toString(oa));
                }

        );

        // !!!  HQL FULL JOIN
        String hqlQuery4="SELECT s.name, d.name FROM Student04 s FULL JOIN FETCH Diary04 d on s.id=d.student.id";
        List<Object[]>  resultList4= session.createQuery(hqlQuery4).getResultList();

        resultList4.forEach(oa->{
                    System.out.println(Arrays.toString(oa));
                }

        );



        tx.commit();
        session.close();
        sf.close();
    }


}
