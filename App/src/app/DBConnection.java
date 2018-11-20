/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rohit
 */
public class DBConnection {
    public static ResultSet getResult(String S){
        try{
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/hotel_booking_app", "root", "123456789");
                Statement stat = conn.createStatement();
            ResultSet RSet = stat.executeQuery(S);
            return RSet;
        }catch(SQLException se){
            se.printStackTrace();
        }
        return null;
    }
}
