package com.riwi.Controller;

import com.riwi.Entity.Course;
import com.riwi.Model.CoursesModel;
import com.riwi.Persistence.IModel.ICourses;

import java.util.List;

public class CourseController {
    ICourses iCourses = new CoursesModel();
    public Course create(Course course){
        return this.iCourses.create(course);

    }

    public boolean deleteCourse(Integer id){
        boolean deleted = this.iCourses.delete(id);
        if(deleted){
            System.out.println(" deleted");
        }
        return false;
    }

    public void read(){
        List<Course> listCorse = this.iCourses.read();
        listCorse.forEach(System.out::println);
    }
}
