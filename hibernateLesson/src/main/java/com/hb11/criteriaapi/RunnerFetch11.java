package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.List;

public class RunnerFetch11 {
    public static void main(String[] args) {
/*
    CRUD (Create, Read, Update, Delete)
        C --> session.save
        R --> session.get, HQL, SQL
        U --> session.update, updateQuery
        D --> session.delete, HQL, SQL
 */

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
//        Student11 student =session.get(Student11.class,1L);
//            session.update(student);

       // Bu sorgu, veritabanında "Student11" tablosunun "mathGrade" sütununda bulunan verileri güncellemek için kullanılır. "SET s.mathGrade=:sMath" ifadesi, "s.mathGrade" değerini ":sMath" değerine eşitler. "WHERE s.mathGrade<:lMath" ifadesi ise, "s.mathGrade" değerinin ":lMath" değerinden küçük olduğu satırları seçer. Bu sorguda, ":sMath" ve ":lMath" gibi etiketler girdi olarak kullanılmaktadır ve kullanıcı tarafından belirli değerlerle değiştirilmelidir.
        // !!! Değişken tanımla
        int sMathGrade = 80 ;
        int lMathGrade = 75 ;

//        String hqlQuery = "UPDATE Student11 s SET s.grade=:sMath WHERE s.grade<:lMath";
//        Query query = session.createQuery(hqlQuery);
//
//        query.setParameter("sMath", sMathGrade);
//        query.setParameter("lMath" , lMathGrade);
//        int numOfRecords = query.executeUpdate();
//        System.out.println("Değiştirilen kayıt sayısı : " + numOfRecords);


        ///critera API
        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery=cb.createQuery(Student11.class);
        Root<Student11> root=criteriaQuery.from(Student11.class);

        //1. örnek
//        criteriaQuery.select(root);
//        Query<Student11> query1=session.createQuery(criteriaQuery);
//        List<Student11> students=query1.getResultList();
//        students.forEach(System.out::println);

        //2. örnek
//        criteriaQuery.select(root).
//                where(cb.equal(root.get("name"),"Student name .. 14"));
//        Query<Student11> query2=session.createQuery(criteriaQuery);
//        List<Student11> students2=query2.getResultList();
//        students2.forEach(System.out::println);
//
        //3. örnek grade notu 80 den fazla olanları görüntğle

//        criteriaQuery.select(root).where(cb.greaterThan(root.get("grade"),80));
//        Query<Student11> query2=session.createQuery(criteriaQuery);
//        List<Student11> students3=query2.getResultList();
//        students3.forEach(System.out::println);

        //4. örnek grade notu 95 den küçük  olanları gör
//        criteriaQuery.select(root).where(cb.lessThan(root.get("grade"),95));
//        Query<Student11> query3=session.createQuery(criteriaQuery);
//
//        List<Student11> students4=query3.getResultList();
//        students4.forEach(System.out::println);

        //5.örnek  id si 1 veya mathgrade i 75 den büyük olan recerdu bualım

        Long id =1L;

        Predicate predicateForId =cb.equal(root.get("id"),id);
        Predicate predicateForMathGrade= cb.greaterThan(root.get("grade"),75);
        Predicate predicateQuery=cb.or(predicateForMathGrade,predicateForId);

        criteriaQuery.where(predicateQuery).groupBy(root.get("grade"));
        Query<Student11> query5=session.createQuery(criteriaQuery);
        List<Student11> resultList6=query5.getResultList();
        resultList6.forEach(System.out::println);



        tx.commit();
        session.close();
        sf.close();
    }
}

