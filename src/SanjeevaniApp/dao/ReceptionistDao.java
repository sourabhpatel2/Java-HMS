/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevaniApp.dao;

import SanjeevaniApp.dbutil.DBConnection;
import SanjeevaniApp.pojo.EmpPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import SanjeevaniApp.pojo.UserDetails;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import SanjeevaniApp.pojo.UserDetails;

/**
 *
 * @author HP
 */
public class ReceptionistDao {
    public static boolean addReceptionist(UserDetails user)throws SQLException//ADD RECEPTIONIST FRAME
    {
        Connection conn= DBConnection.getConnection();
        String qry ="insert into users values (?,?,?,?,?)";
        PreparedStatement ps;
        ps = conn.prepareStatement(qry);
        ps.setString(1,user.getUserid());
         ps.setString(2,user.getUserName());
          ps.setString(3,user.getEmpId()); 
          ps.setString(4,user.getPassword());
           ps.setString(5,user.getUserType());
           int x = ps.executeUpdate();
           return x>0;
        
    }
        public static ArrayList <UserDetails> getAllReceptionist() throws SQLException//VIEW RECEPTIONIST
    {
        Connection conn= DBConnection.getConnection();
        Statement s = conn.createStatement();
         ResultSet rs = s.executeQuery("select * from users where usertype='RECEPTIONIST'");
         ArrayList<UserDetails>receptionistList = new ArrayList();
         
         while (rs.next())
         {
             UserDetails u= new UserDetails();
             u.setUserid(rs.getString(1));
             u.setUserName(rs.getString(2));
             u.setEmpId(rs.getString(3));
            u.setPassword(rs.getString(4));
             receptionistList.add(u);
         }
        
    
         return receptionistList;
    
    }
    
}
