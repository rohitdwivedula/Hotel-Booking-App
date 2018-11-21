/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

/**
 *
 * @author rohit
 */
import static app.Utilities.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.UIManager;

public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Date DateIn = null, DateOut = null;
        try{
            DateIn = (Date) convertDate(sdf1.parse("21-03-2019"));
            DateOut = (Date) convertDate(sdf1.parse("24-03-2018"));
        }catch(ParseException ex){
            ex.printStackTrace();
        }
        new Login().setVisible(true);
    }
    
}