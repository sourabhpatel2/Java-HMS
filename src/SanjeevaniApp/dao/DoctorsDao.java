/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevaniApp.dao;

import SanjeevaniApp.dbutil.DBConnection;
import SanjeevaniApp.pojo.DoctorsPojo;
import SanjeevaniApp.pojo.UserDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Vision
 */
public class DoctorsDao {
    public static ArrayList<String> getAllDoctorsId() throws SQLException
    {
        ArrayList<String> docid=new ArrayList<>();
        ResultSet rs=DBConnection.getConnection().createStatement().executeQuery("select doctorid from doctors");
        while(rs.next())
        {
            docid.add(rs.getString(1));
        }
        return docid;
    }
   public static boolean addDoctors(UserDetails user) throws SQLException
   {
       Connection conn=DBConnection.getConnection();
       String qry="insert into users values(?,?,?,?,?)";
       PreparedStatement ps=conn.prepareStatement(qry);
       ps.setString(1, user.getUserid());
       ps.setString(2, user.getUserName());
          ps.setString(3, user.getEmpId());
       ps.setString(1, user.getUserid());
      
       ps.setString(4, user.getPassword());
       ps.setString(5, user.getUserType().toUpperCase());
       int x=ps.executeUpdate();
       if(x>0)
       {
           return true;
       }
       else
       {
           return false;
       }
   }
     public static boolean addDoctorsTable(DoctorsPojo d) throws SQLException
   {
       Connection conn=DBConnection.getConnection();
       String qry="insert into doctors values(?,?,?,?,'Y')";
       PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, d.getUserid());
        ps.setString(2, d.getDoctorid());
        ps.setString(3, d.getQualification());
       ps.setString(4, d.getSpecialist());
      
      
       int x=ps.executeUpdate();
       if(x>0)
       {
           return true;
       }
       else
       {
           return false;
       }
   }
        public static String getNewDoctorsId() throws SQLException
    {
              Connection conn= DBConnection.getConnection();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("select max(doctorid) from doctors");
        int id = 1;
       if( rs.next())
       {
            String empid =rs.getString(1);
            System.out.println(empid.substring(1));
            int eno = Integer.parseInt(empid.substring(1));
            id=id + eno;
        
        String sr ="D"+id;
        //System.out.println(sr);
        return sr;
       }
       else 
           return "D101";
    }
                public static ArrayList<DoctorsPojo> getAllDoctors() throws SQLException//VIEW RECEPTIONIST
    {
        Connection conn= DBConnection.getConnection();
        Statement s = conn.createStatement();
         ResultSet rs = s.executeQuery("select * from doctors where active='Y'");
         ArrayList<DoctorsPojo>doctorlist = new ArrayList();
         
         while (rs.next())
         {
             DoctorsPojo d= new DoctorsPojo();
               d.setUserid(rs.getString(1));
             d.setDoctorid(rs.getString(2));
               d.setQualification(rs.getString(3));
                d.setSpecialist(rs.getString(4));
           
             doctorlist.add(d);
         }
        
    
         return doctorlist;
    
    }
     public static HashMap<String,String> getAllDoctorsList() throws SQLException//VIEW RECEPTIONIST
    {
        Connection conn= DBConnection.getConnection();
        Statement s = conn.createStatement();
         ResultSet rs = s.executeQuery("select userid,username from users where usertype='DOCTOR'");
         HashMap<String,String>doctorlist = new HashMap();
         
         while (rs.next())
         {
         doctorlist.put(rs.getString(1),rs.getString(2));
         }
        
    
         return doctorlist;
    
    }
    
    
}
