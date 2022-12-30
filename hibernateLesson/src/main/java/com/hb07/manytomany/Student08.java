package com.hb07.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student08 {
    @Id
    private  int id;
    @Column(name = "student_name",nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "student08_book08",
    joinColumns = @JoinColumn(name = "std_id"),
    inverseJoinColumns = {@JoinColumn(name = "book_id")})

    private List<Book08> bookList=new ArrayList<>();

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

    public List<Book08> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book08> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
