package com.riwi;

import com.riwi.Controller.CalificacionController;
import com.riwi.Controller.CourseController;
import com.riwi.Controller.InscriptionController;
import com.riwi.Controller.StudentController;
import com.riwi.Entity.Calificacion;
import com.riwi.Entity.Course;
import com.riwi.Entity.Inscription;
import com.riwi.Entity.Student;
import com.riwi.Model.CoursesModel;
import com.riwi.Persistence.IModel.ICourses;

import javax.swing.*;
import java.text.ParseException;

public class Main {





    public static void course(){
        CourseController courseController = new CourseController();
        Course course = null;

        int option;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(
                    "Insert option\n" +
                            "1. create course \n" +
                            "2. List course  \n" +
                            "3. Update course  \n" +
                            "4. Delete course  \n" +
                            "5. exit"));
            switch (option){
                case 1:
                    String name = JOptionPane.showInputDialog(" insert name course");
                    String description = JOptionPane.showInputDialog(" insert description course");
                    course.setName(name);
                    course.setDescription(description);
                    courseController.create(course);
                    break;

                case 2:
                    courseController.read();
                    break;
                case 3:
                    break;
                case 4:
                    int courseId = Integer.parseInt(JOptionPane.showInputDialog("insert id course"));
                    course.setId(courseId);
                    break;
                case 5:
                    break;

                default:
                    JOptionPane.showInputDialog(" option invalid");
            }

        }while (option !=5);

    }





    public  static void student(){

        StudentController studentController =  new StudentController();
        Student student = null;
        int option;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(
                    "Insert option\n" +
                            "1. create student \n" +
                            "2. List student  \n" +
                            "3. Update student  \n" +
                            "4. Delete student  \n" +
                            "5. exit"));
            switch (option){
                case 1:
                    String name = JOptionPane.showInputDialog(" insert your name");
                 String lastName = JOptionPane.showInputDialog(" insert your last name");
                 String document = JOptionPane.showInputDialog(" insert your id");
                 String email = JOptionPane.showInputDialog(" insert you email");
                 Student student1 = new Student(name,lastName,document,email);
                    studentController.create(student1);
                    break;

                case 2:
                    studentController.read();
                    break;
                case 3:
                    int idStudent = Integer.parseInt(JOptionPane.showInputDialog(" insert id student"));
                    String nameStuden = JOptionPane.showInputDialog(" insert your name");
                    String emailStuden = JOptionPane.showInputDialog(" insert your email");
                    Student student11 = new Student();
                    studentController.update(student11);
                    break;
                case 4:
                    int idStudent3 = Integer.parseInt(JOptionPane.showInputDialog("insert id student"));
                    student.setId(idStudent3);
                    break;
                case 5:
                    break;

                default:
                    JOptionPane.showInputDialog(" option invalid");
                    break;
            }

        }while (option !=5);
    }




    public static void inscription() {

        InscriptionController inscriptionController = new InscriptionController();


        int option;

        do {

            option = Integer.parseInt(JOptionPane.showInputDialog(
                    "Insert option\n" +
                            "1. create inscription \n" +
                            "2. List inscription  \n" +
                            "3. Update inscription  \n" +
                            "4. Delete inscriptoin  \n" +
                            "5. exit"));


            switch (option){
                case 1:
                    int idStudent = Integer.parseInt(JOptionPane.showInputDialog(" insert id student"));
                    int idCourse = Integer.parseInt(JOptionPane.showInputDialog(" insert id course"));
                    Inscription inscription1 = new Inscription(idStudent,idCourse);
                    inscriptionController.create(inscription1);
                    break;

                case 2:
                    inscriptionController.read();
                    break;
                case 3:
                    int idUPdate = Integer.parseInt(JOptionPane.showInputDialog(" insert id student"));
                    int idCourseU = Integer.parseInt(JOptionPane.showInputDialog(" insert id course"));
                    Inscription inscription2 = new Inscription(idUPdate, idCourseU);
                    inscriptionController.update(inscription2);
                    break;

                case 4:
                    int idDelete = Integer.parseInt(JOptionPane.showInputDialog(" insert id inscription"));
                    inscriptionController.delete(idDelete);;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"invalid option");
                    break;
            }

        }while(option !=5);
    }

    public static void calificacion() {

        CalificacionController calificacionController = new CalificacionController();


        int option;

        do {

            option = Integer.parseInt(JOptionPane.showInputDialog(
                    "Insert option\n" +
                            "1. create calificacion \n" +
                            "2. List calificacion  \n" +
                            "3. Update calificacion  \n" +
                            "4. Delete calificacion  \n" +
                            "5. exit"));


            switch (option){
                case 1:
                    int calificacion = Integer.parseInt(JOptionPane.showInputDialog(" insert calificacion"));
                    String descripcion = JOptionPane.showInputDialog(" insert description ");
                    int idCourse = Integer.parseInt(JOptionPane.showInputDialog(" insert id course"));
                    int idStudent = Integer.parseInt(JOptionPane.showInputDialog(" insert id student"));
                    Calificacion calificacion1 = new Calificacion(calificacion,descripcion,idCourse,idStudent);
                    calificacionController.create(calificacion1);
                    break;

                case 2:
                    calificacionController.read();
                    break;
                case 3:
                   int nota = Integer.parseInt(JOptionPane.showInputDialog(" insert nota"));
                   String description = JOptionPane.showInputDialog(" insert description");
                    Calificacion calificacion2 = new Calificacion(nota, description);
                    calificacionController.update(calificacion2);
                    break;

                case 4:
                    int idDelete = Integer.parseInt(JOptionPane.showInputDialog(" insert id inscription"));
                    calificacionController.delete(idDelete);
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"invalid option");
                    break;
            }

        }while(option !=5);
    }




    public static void main(String[] args) throws ParseException {

        int option;

        do {

            option = Integer.parseInt(JOptionPane.showInputDialog(
                    "Insert option\n" +
                    "1. student \n" +
                    "2. courses  \n" +
                    "3. inscription  \n" +
                    "4. calificacion  \n" +
                    "5. exit"));


            switch (option) {
                case 1:
                    student();
                    break;
                case 2:
                    course();
                    break;
                case 3:
                    inscription();
                    break;
                case 4:
                    calificacion();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "exiting the system");
                    break;

                default:
                    break;
            }

        } while (option != 5);


      }
}