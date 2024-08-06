package com.riwi.Controller;

import com.riwi.Entity.Student;
import com.riwi.Model.StudentModel;
import com.riwi.Persistence.IModel.IStudent;

import java.util.List;

public class StudentController {
    IStudent iStudent = new StudentModel();
    public void create(Student student){
        this.iStudent.create(student);

    }

    public void read(){
        List<Student> listStudent = this.iStudent.read();
        listStudent.forEach(System.out::println);
    }

    public  void update(Student student){
        this.iStudent.update(student);
    }

    public void  delete(Integer id){
        this.iStudent.delete(id);
    }
}
