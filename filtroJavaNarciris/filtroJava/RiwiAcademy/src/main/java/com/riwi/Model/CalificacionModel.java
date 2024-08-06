package com.riwi.Model;

import com.riwi.Entity.Calificacion;
import com.riwi.Entity.Inscription;
import com.riwi.Persistence.Conexion.Conexion;
import com.riwi.Persistence.IModel.ICalificacion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalificacionModel implements ICalificacion {
    @Override
    public Calificacion create(Calificacion object) {
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = " INSERT INTO calificacion (nota, description, course_id, student_id) VALUES (? , ?, ? , ?)";
        try{
            ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,object.getNota());
            ps.setString(2,object.getDescription());
            ps.setInt(3,object.getCourdeId());
            ps.setInt(4,object.getStudentId());


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
        String query = "DELETE FROM calificacion WHERE id = ?";

        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);

            int delete = ps.executeUpdate();
            if(delete >0){
                JOptionPane.showMessageDialog(null," deleted");
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
    public List<Calificacion> read() {
        List<Calificacion> listCalificacion = new ArrayList<>();
        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "SELECT * FROM calificacion";

        try{
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Calificacion object = new Calificacion();
                object.setStudentId(resultSet.getInt("student_id"));
                object.setCourdeId(resultSet.getInt("course_id"));
                object.setDescription(resultSet.getString("description"));
                object.setNota(resultSet.getInt("nota"));
                object.setId(resultSet.getInt("id"));

                listCalificacion.add(object);
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

        return listCalificacion;
    }

    @Override
    public Calificacion update(Calificacion object) {

        PreparedStatement ps;
        Connection connection = Conexion.getConnection();
        String query = "UPDATE calificacion SET nota = ?, description = ? WHERE id = ?";

        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,object.getNota());
            ps.setString(2, object.getDescription());


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
