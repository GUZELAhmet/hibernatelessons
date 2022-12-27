package com.hb01.annotation;

import javax.persistence.*;
import java.lang.annotation.Target;

//@Entity  annntation u koyduğumuz sınıfta db de bir tablo olarak oluşturur.
@Entity
@Table(name = "t_student01")  //DB de tablo isimim  t_student01 olarak değiştirp
public class Student01 {   //DB de student01 isminde bir tablo oluşturur


    @Id  //primarykey oluşmasını sağlar
  //  @Column(name = "std_id")
    private  int id;


    @Column(name = "student_name",nullable = false,length = 100,unique = false)
    private String name;

   // @Transient // DB deki tabloda grade adında bir sütun oluşmasını engeller
    private  int grade;

   // @Lob       // DB de large object ile büyük boyutlu datalar tutabilir
  //  private byte[] image;

    //getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
