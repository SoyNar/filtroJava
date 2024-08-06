package com.riwi.Model;

import com.riwi.Entity.Student;
import com.riwi.Persistence.Conexion.Conexion;
import com.riwi.Persistence.IModel.IStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel implements IStudent {
    @Override
    public Student create(Student object) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = " INSERT INTO student (name, lastname,active_student, email,cc) VALUES (? , ? , ? , ?, ?)";
        try{
            ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,object.getName());
            ps.setString(2,object.getLastname());
            ps.setBoolean(3,object.isStatus());
            ps.setString(4,object.getEmail());
            ps.setString(5, object.getDocument());

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
        }
        return object;
    }

    @Override
    public boolean delete(Integer id) {

        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "DELETE FROM student WHERE id = ?";

        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);

            int delete = ps.executeUpdate();
            if(delete >0){
                System.out.println(" deleted");
            }
        } catch (SQLException e){
            System.out.println(" error to delete student " + e.getMessage());
        } finally {
            try{
                Conexion.closedConnection();
            }catch (Exception e){
                System.out.println(" error closed connection " + e.getMessage());
            }
        }
 return false;

    }

    @Override
    public List<Student> read() {

        List<Student> listStudent = new ArrayList<>();
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "SELECT * FROM student";

        try{
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Student object = new Student();
                object.setId(resultSet.getInt("id"));
                object.setName(resultSet.getString("name"));
                object.setLastname(resultSet.getString("lastname"));
                object.setEmail(resultSet.getString("email"));
                object.setStatus(resultSet.getBoolean("active_student"));
                object.setDocument(resultSet.getString("cc"));
                listStudent.add(object);
            }

        }catch (SQLException e){
            System.out.println(" error read student " +e.getMessage());
        } finally {
            try{
                Conexion.closedConnection();
            }catch (Exception e){
                System.out.println( " error closed database" + e.getMessage());
            }
        }
        return listStudent;
    }

    @Override
    public Student update(Student object) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "UPDATE student SET name = ?, email = ? WHERE id = ?";

        try{
            ps = connection.prepareStatement(query);
            ps.setString(1,object.getName());
            ps.setString(2, object.getEmail());
            ps.setInt(3,object.getId());

            int update = ps.executeUpdate();
            if(update > 0){
                System.out.println(" updated");
            }
        }catch (SQLException e){
            System.out.println(" error to update" + e.getMessage());
        } finally {
            try{
                Conexion.closedConnection();
            }catch (Exception e){
                System.out.println(" error to closed database " +e.getMessage());
            }
        }
        return null;
    }
}
