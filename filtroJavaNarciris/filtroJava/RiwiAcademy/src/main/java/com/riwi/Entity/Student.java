package com.riwi.Entity;

public class Student {

    private int id;
    private String name;
    private String lastname;
     private  boolean status = true;
    private String document;
    private String email;

    // constructor

    public Student(){}

    public Student(String name, String lastname, String document, String email) {
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.email = email;
    }

    public Student(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
// getter and setter


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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                "name :" + name +
                " lastname: " + lastname +
                " email : " + email +
                 " documento : " + document +
                " status : " + status;
    }
}
