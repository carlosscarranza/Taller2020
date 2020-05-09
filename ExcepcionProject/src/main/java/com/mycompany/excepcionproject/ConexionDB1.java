/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.excepcionproject;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author axter
 */
public class ConexionDB1 {
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mariadb://localhost:3306/inventario";
    private Connection connection;
    private Statement statement;
    
    public ConexionDB1(){
        try { 
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "root");
            statement = (Statement) connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM empleado");
            StringBuffer results = new StringBuffer();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColuns = metaData.getColumnCount();
            for(int i = 1; i <= numberOfColuns; i++){
                results.append(metaData.getColumnName(i) + "\t");
            }
            results.append("\n");
            
            while(resultSet.next()){
                for(int i = 1; i <= numberOfColuns; i++){
                    results.append(resultSet.getObject(i) + "\t");
                }
                results.append("\n");
            }
            System.out.println(results.toString());
        }
        catch(SQLException sqLException){ //Esta excepcion es lanzada cuando no tenemos conexion a la base de datos cuando intentemos agregar un registro
            JOptionPane.showMessageDialog(null, sqLException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        catch(ClassNotFoundException classNotFound){ //Esta excepcion es lanzada cuando no se encuentra la clase a la quq queremos acceder
            JOptionPane.showMessageDialog(null, classNotFound.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        finally{
            try{
                statement.close();
                connection.close();
            }
            catch(SQLException sqLException){ //Esta excepcion es lanzada cuando no tenemos conexion a la base de datos 
            JOptionPane.showMessageDialog(null, sqLException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
            }
        }
    }
    
    public static void main(String[] args){
        ConexionDB1 solucion = new ConexionDB1();
    }
}
