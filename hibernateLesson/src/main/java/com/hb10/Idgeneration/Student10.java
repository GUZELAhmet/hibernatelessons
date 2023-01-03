package com.hb10.Idgeneration;

import javax.persistence.*;

@Entity
public class Student10 {

    /*
   Oracle DB - PostgreSQL ---> Sequence ( kontrolü developera bırakır, Id üretilirken başlangıç değeri veya kaç tane id cachelenecek bu gibi bilgileri developer setliyebilir)
   MySQL - Microsoft SQL   ---> IDENTITY ( kontrol DB de , kendi yapısına göre ıd oluşturur, içlerindeki en basitidir)

   GenerationType.AUTO ---> Hibernate otomatik olarak stratejiyi belirler
   GenerationType.TABLE ---> En yavaşı , oyüzden çok kullanılmıyor, çünkü id
    üretmek için ekstra tablo oluşturuyor
 */

    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence", sequenceName ="student_seq",initialValue = 1000,allocationSize = 10)
    @Id
    private  int id;
    @Column(name = "student_name",nullable = false)
    private String name;
    private  int grade;

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
