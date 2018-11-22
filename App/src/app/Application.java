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
        new Login().setVisible(true);
    }
    
}