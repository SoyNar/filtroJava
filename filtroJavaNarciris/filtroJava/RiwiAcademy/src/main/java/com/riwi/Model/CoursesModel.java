package com.riwi.Model;

import com.riwi.Entity.Course;
import com.riwi.Persistence.Conexion.Conexion;
import com.riwi.Persistence.IModel.ICourses;

import javax.print.DocFlavor;
import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

public class CoursesModel implements ICourses {

    @Override
    public Course create(Course object) {

        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = " INSERT INTO course (name, description) VALUES (? , ?)";
        try{
            ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,object.getName());
            ps.setString(2,object.getDescription());


            int create = ps.executeUpdate();
            if(create > 0){
                ResultSet resultSet = ps.getGeneratedKeys();
                if(resultSet.next()){
                    object.setId(resultSet.getInt(1));
                    System.out.println("created");
                }
            }

        }catch (SQLException e){
            System.out.println(" error " + e.getMessage());
        }finally {
            try{
                Conexion.closedConnection();
            }catch (Exception e){
                System.out.println(" error closed conexion " + e.getMessage());
            }
        }
        return object;

    }

    @Override
    public boolean delete(Integer id) {

        PreparedStatement ps;
        Connection connection = Conexion.getConnection();


        boolean busy = isbusy(id);

        if(busy){
            System.out.println("no se puede eliminar");
            return false;
        }

        String query =  " DELETE FROM course WHERE id = ?";
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);

            int delete = ps.executeUpdate();
            if(delete>0){
                System.out.println("deleted");
            } else{
                System.out.println(" id no found");
            }

        }catch (SQLException e){
            System.out.println(" error " + e.getMessage());
        }finally {
            try {
                Conexion.closedConnection();
            }catch (Exception e){
                System.out.println(" error close conexion " + e.getMessage());
            }
        }

        return  false;
    }

    public boolean isbusy(int id){
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "SELECT COUNT(*)FROM inscription WHERE course_id = ?";
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                return  resultSet.next();
            }

        }catch (SQLException e){
            System.out.println("error " + e.getMessage());
        } finally {
            try{
                Conexion.closedConnection();
            }catch (Exception e){
                System.out.println(" error closed database " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public List<Course> read() {
        List<Course> listCourse = new ArrayList<>();
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "SELECT * FROM course";

        try{
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                 Course course = new Course();
                 course.setName(resultSet.getString("name"));
                 course.setId(resultSet.getInt("id"));
                 course.setDescription(resultSet.getString("description"));
                 listCourse.add(course);
            }
        }catch (SQLException e){
            System.out.println(" error " + e.getMessage());
        }
        return listCourse;
    }

    @Override
    public Course update(Course object) {
        return null;
    }
}
