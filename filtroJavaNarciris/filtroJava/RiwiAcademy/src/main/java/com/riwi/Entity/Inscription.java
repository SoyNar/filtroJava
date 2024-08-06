package com.riwi.Entity;

public class Inscription {
    private int id;
    private int courseID;
    private int studentId;

    // constructor


    public Inscription(int id, int courseID, int studentId) {
        this.id = id;
        this.courseID = courseID;
        this.studentId = studentId;
    }

    public Inscription(){}

    public Inscription(int courseID, int studentId) {
        this.courseID = courseID;
        this.studentId = studentId;
    }

    // getter and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "id: " + id +
                " course id: " +  courseID +
                " student id : " + studentId;
    }
}
