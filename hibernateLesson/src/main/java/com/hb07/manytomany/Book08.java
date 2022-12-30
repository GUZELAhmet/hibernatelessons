package com.hb07.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book08 {
    @Id
    private  int id;

    private String name;

    @ManyToMany(mappedBy = "booklist")
        private List<Student08>  student = new ArrayList<>();

    // getter setter


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

    public List<Student08> getStudent() {
        return student;
    }

    public void setStudent(List<Student08> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
