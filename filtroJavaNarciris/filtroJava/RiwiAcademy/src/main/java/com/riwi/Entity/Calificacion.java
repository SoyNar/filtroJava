package com.riwi.Entity;

public class Calificacion {

    private int id;
    private int nota;
    private String description;

    private int courdeId;
    private int studentId;

    // constructor


    public Calificacion(int id) {
        this.id = id;
    }

    public Calificacion(int nota, String description, int courdeId, int studentId) {
        this.nota = nota;
        this.description = description;
        this.courdeId = courdeId;
        this.studentId = studentId;
    }

    public Calificacion(int nota, String description) {
        this.nota = nota;
        this.description = description;
    }

    public Calificacion(){}

    // gettter and setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCourdeId() {
        return courdeId;
    }

    public void setCourdeId(int courdeId) {
        this.courdeId = courdeId;
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
                " nota :" + nota
                + "description " + description
                + " course id : " + courdeId
                + " studentn id : " + studentId;
    }
}
