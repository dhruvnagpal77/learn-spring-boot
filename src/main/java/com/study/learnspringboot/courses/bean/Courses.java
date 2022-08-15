package com.study.learnspringboot.courses.bean;

public class Courses {

    private long id;
    private String name;
    private String author;

    public Courses(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    // We need public getters(If data members are private) in the Class so that Jackson can convert java objects to json & vice versa.
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

}