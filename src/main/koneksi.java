/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pongo
 */
public class koneksi {
    private static Connection mysqlconfig;
    
    //Method static untuk membuka koneksi ke database MySQL
    public static Connection konek() {
        
        try {
            String url = "jdbc:mysql://localhost:3306/toko_ulfa";
            String user = "root";
            String pass = "";
            mysqlconfig=DriverManager.getConnection(url, user, pass);
        } catch (SQLException sQLException) {
            System.err.println(sQLException.getMessage());
        }
        return mysqlconfig;
    } 
}
