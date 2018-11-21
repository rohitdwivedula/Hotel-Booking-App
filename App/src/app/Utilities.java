/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import static app.DBConnection.getResult;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rohit
 */
public class Utilities {
    
    /**
     *
     * @param date date in java.util.Date format
     * @return date in java.sql.date format
     */
    public static java.sql.Date convertDate(java.util.Date date)
    {
        return new java.sql.Date(date.getTime());
    }
    /**
     *
     * @param A first date
     * @param B second date
     * @return (A-B)
     */
    public static int getDateDifference(java.sql.Date A, java.sql.Date B){
        String query = "DATEDIFF(\"" + A + "\", \"" + B + "\")";
        ResultSet rs;
        int n = 0;
        try {
            rs = getResult("SELECT " + query+";");
            rs.next();
            n = rs.getInt(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    /**
     * @param HID Hotel ID
     * @param DateIn Date of Check In
     * @param DateOut Date of Check Out
     * @return number of rooms available on the date range
     */
    public static int checkAvailability(int HID, java.sql.Date DateIn, java.sql.Date DateOut){
        int n = getDateDifference(DateOut, DateIn);
        if(n < 0){
            return -1; //indicates an error in date formatting
        }
        int [] days = new int[n+1]; //array representing days starting from DateIn to DateOut, both inclusive
        for(int i=0;i<=n;i++){
            days[i] = 0;
        }
        ResultSet rs;
        String query = "SELECT rooms_confirmed FROM booking_info WHERE (Status=0 OR STATUS = 1) AND Hotel_ID = " + HID;
        try{
            //CASE 1
            rs = getResult(query + " AND Date_In < " + DateIn + " AND Date_Out > " + DateOut + ";");
            while(rs.next()){
                for(int i=0;i<=n;i++){
                    days[i] += 1;
                }
            }
            //CASE 2
            rs = getResult(query + " AND Date_In >= " + DateIn + " AND Date_Out <= " + DateOut + ";");
            while(rs.next()){
                int i,j;
                i = getDateDifference(rs.getDate("Date_In"), DateIn);
                j = n - getDateDifference(DateOut, rs.getDate("Date_Out"));
                for(int k=i;k<=j;k++){
                    days[k]++;
                }
                for(int k=i;k<=j;k++){
                    days[k]++;
                }
            }
            //CASE 3
            rs = getResult(query + " AND Date_In >= " + DateIn + " AND Date_In <= " + DateOut + " AND Date_Out > " + DateOut + ";");
            while(rs.next()){
                int i,j;
                j = n;
                i = getDateDifference(rs.getDate("Date_In"), DateIn);
                for(int k=i;k<=j;k++){
                    days[k]++;
                }
            }
            //CASE 4
            rs = getResult(query + " AND Date_In < " + DateIn + " AND Date_Out <= " + DateOut + " AND Date_Out >= " + DateIn + ";");
            while(rs.next()){
                int i,j;
                i = 0;
                j = n - getDateDifference(DateOut, rs.getDate("Date_Out"));
                for(int k=i;k<=j;k++){
                    days[k]++;
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        int rooms = days[0];
        for(int i=0;i<=n;i++){
            if(days[i] > rooms)
                rooms = days[i];
        }
        rs = getResult("SELECT Number_of_rooms FROM room_info WHERE Hotel_ID = " + HID +";");
        try {
            rs.next();
            rooms = rs.getInt("Number_of_rooms") - rooms;
        } catch (SQLException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rooms;
    }
}
