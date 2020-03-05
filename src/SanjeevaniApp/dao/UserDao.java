/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevaniApp.dao;


import SanjeevaniApp.dbutil.DBConnection;
import SanjeevaniApp.pojo.EmpPojo;
import SanjeevaniApp.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Vision
 */
public class UserDao {
    public static String validateUser(UserPojo user)throws SQLException//FOR LOGIN FRAME
    {
        System.out.println(user);    
   PreparedStatement ps=DBConnection.getConnection().prepareStatement("select username from users where userid=?and password=?and usertype=?");
   
   
        
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType());
        ResultSet rs=ps.executeQuery();
        String username=null;
        if(rs.next())
        {
            username=rs.getString(1);
            
        }
        return username;
        
    }
public static boolean changePassword(String userid,String pwd) throws SQLException//FOR UPADTE PASSSWORD OF RECEPTIONIST
{
      PreparedStatement ps=DBConnection.getConnection().prepareStatement("update users set password=? where userid=?");
      
   
   
        
        ps.setString(1,pwd);
        ps.setString(2,userid);
        return (ps.executeUpdate()!=0);
}
public static HashMap<String,String> getReceptionistList() throws SQLException //FOR UPDATE RECEPTIONIST
{
    HashMap<String,String> receptionistList=new HashMap<>();
    Connection conn= DBConnection.getConnection();
        Statement s = conn.createStatement();
         ResultSet rs = s.executeQuery("select userid,username from users where usertype='RECEPTIONIST'");
       while(rs.next())
       {
           receptionistList.put(rs.getString(1), rs.getString(2));
       }
       return receptionistList;
}
    public static boolean deleteReceptionist(String rid) throws SQLException
    {
         Connection conn= DBConnection.getConnection();
         String qry = "delete from users where userid =?";
        PreparedStatement ps;
        ps = conn.prepareStatement(qry);
        ps.setString(1,rid);
       
       int x = ps.executeUpdate();
       return x==1;
    }  
       public static boolean deleteDoctor(String rid) throws SQLException
    {
         Connection conn= DBConnection.getConnection();
         String qry = "update doctors set active='N' where doctorid =?";
        PreparedStatement ps;
        ps = conn.prepareStatement(qry);
        ps.setString(1,rid);
       
       int x = ps.executeUpdate();
       return x==1;
    } 
    
}
