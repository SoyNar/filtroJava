package com.riwi.Persistence.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static Connection connection = null;
    public static Connection getConnection(){
        String nameDb = "RiwiAcademyDB";
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/" + nameDb;
        String password = "Rlwl2023.";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);

        }catch (Exception e ){
            System.out.println(" error to conec database" + e.getMessage());
        }
        return  connection;
    }

    public static void closedConnection(){

            try {
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(" error closed connection " + e.getMessage());
            }
        }


    }

