package com.hb11.criteriaapi;

import javax.persistence.*;

@Entity
public class Student11 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name="student_name", nullable = false)
    private String name;

    private  int grade;

    //*****gettter setter


    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
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
        return "Student11{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
