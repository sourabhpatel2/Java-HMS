/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevaniApp.dbutil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vision
 */
public class DBConnection {
      private static Connection conn;
    static{
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//LENOVO:1521/xe","myhms","student");
            JOptionPane.showMessageDialog(null,"Connection done successfully");
        }
         catch(ClassNotFoundException cnfe)
    {
         JOptionPane.showMessageDialog(null,"Can't load  driver"+cnfe);
    cnfe.printStackTrace();
    }
     catch(SQLException sqle)
    {
         JOptionPane.showMessageDialog(null,"Problem in DB"+sqle);
    
         sqle.printStackTrace();
    }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {    
        try
        {
        if(conn!=null)
        {
        
       
            conn.close();
            JOptionPane.showMessageDialog(null,"Connection close suucessfully");
              
            
        }
        }
         catch(SQLException sqle)
    {
         JOptionPane.showMessageDialog(null,"Problem in closing connection"+sqle);
    
         sqle.printStackTrace();
    }
    }
    
}

