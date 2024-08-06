package com.riwi.Model;

import com.riwi.Entity.Inscription;
import com.riwi.Entity.Student;
import com.riwi.Persistence.Conexion.Conexion;
import com.riwi.Persistence.IModel.IInscription;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

public class InscriptionModel implements IInscription {
    @Override
    public Inscription create(Inscription object) {

        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "INSERT INTO inscription (course_id, student_id) VALUES (?, ? )";
        boolean idCourse = validateCourse(object.getCourseID(), object.getStudentId());

        if(idCourse){
            JOptionPane.showMessageDialog(null," ya esta inscrito");
            return null;
        }


        try{
            ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,object.getCourseID());
            ps.setInt(2, object.getStudentId());

            int update = ps.executeUpdate();
            if(update > 0){
                ResultSet resultSet = ps.getGeneratedKeys();
                if(resultSet.next()){
                    object.setId(resultSet.getInt(1));
                    System.out.println(" created");
                }
            }
        }catch (SQLException e){
            System.out.println(" error " + e.getMessage());
        } finally {
            try{
                Conexion.closedConnection();
            }catch (Exception e){
                System.out.println("error closed database " +e.getMessage());
            }
        }

        return null;
    }

    @Override
    public boolean delete(Integer id) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "DELETE FROM inscription WHERE id = ?";

        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);

            int delete = ps.executeUpdate();
            if(delete >0){JOptionPane.showMessageDialog(null," deleted");
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
    public List<Inscription> read() {
        List<Inscription> listInscription = new ArrayList<>();
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "SELECT * FROM inscription";

        try{
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Inscription object = new Inscription();
                object.setId(resultSet.getInt("student_id"));
                object.setCourseID(resultSet.getInt("course_id"));
                object.setId(resultSet.getInt("id"));

                listInscription.add(object);
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
        return null;

    }

    @Override
    public Inscription update(Inscription object) {

        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "UPDATE inscription SET student_id = ?, course_id = ? WHERE id = ?";

        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,object.getStudentId());
            ps.setInt(2, object.getCourseID());
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


    public boolean validateCourse(int idStudent, int idCOurse){
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "SELECT COUNT(*) FROM inscription WHERE course_id = ? AND student_id = ?";
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,idStudent);
            ps.setInt(2,idCOurse);

            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                return  resultSet.getInt(1) > 0;
            }
        }catch (SQLException e){
            System.out.println(" error  create" + e.getMessage());
        }
        return false;

    }
}
