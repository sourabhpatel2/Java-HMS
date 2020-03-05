/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevaniApp.dao;

import SanjeevaniApp.dbutil.DBConnection;
import SanjeevaniApp.pojo.ApnPojo;
import SanjeevaniApp.pojo.EmpPojo;
import SanjeevaniApp.pojo.PatientPojo;
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
public class PatientDao {
    ArrayList<String> doctor;

    
    public static boolean addpatient(PatientPojo p) throws SQLException
    {
    PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    ps.setString(1, p.getP_id());
    ps.setString(2, p.getF_name());
    ps.setString(3, p.getS_name());
    ps.setInt(4, p.getAge());
    ps.setString(5, p.getOpd());
    ps.setString(6, p.getGender());
    ps.setString(7, p.getM_status());
    ps.setDate(8, p.getDate());
    ps.setString(9, p.getAddress());
    ps.setString(10, p.getCity());
    ps.setString(11, p.getMno());
    ps.setString(12, p.getDoctor_id());
     ps.setString(13, p.getWard_no());
      ps.setString(14, p.getBed_no());
    
    return (ps.executeUpdate()!=0);
    }
    public static String getNewId() throws SQLException
    {
              Connection conn= DBConnection.getConnection();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("select max(p_id) from patient");
        int id = 1;
       if( rs.next())
       {
            String empid =rs.getString(1);
            System.out.println(empid.substring(1));
            int eno = Integer.parseInt(empid.substring(1));
            id=id + eno;
        
        String sr ="P"+id;
        //System.out.println(sr);
        return sr;
       }
       else 
           return "P101";
    }
   
          public static ArrayList <ApnPojo> getAllPatient() throws SQLException//FOR VIEW patient FRAME
    {
        Connection conn= DBConnection.getConnection();
        Statement s = conn.createStatement();
         ResultSet rs = s.executeQuery("select p_id,f_name,opd from patient");
         ArrayList<ApnPojo>empList1 = new ArrayList();
         
         while (rs.next())
         {
             ApnPojo e = new ApnPojo();
             e.setP_id(rs.getString(1));
             e.setF_name(rs.getString(2));
             e.setOpd(rs.getString(3));
             empList1.add(e);
         }
        
    
         return empList1;
    
    }
                   public static   HashMap<String,PatientPojo> getAllViewPatient() throws SQLException//FOR VIEW patient FRAME
    {
        Connection conn= DBConnection.getConnection();
        Statement s = conn.createStatement();
         ResultSet rs = s.executeQuery("select * from patient");
        // ArrayList<PatientPojo>empList2 = new ArrayList();
           HashMap<String,PatientPojo> hm=new HashMap();
         while (rs.next())
         {
             PatientPojo e = new PatientPojo();
            e.setP_id(rs.getString(1));
             e.setF_name(rs.getString(2));
             e.setS_name(rs.getString(3));
                  e.setAge(rs.getInt(4));
                       e.setOpd(rs.getString(5));
                            e.setGender(rs.getString(6));
                                      e.setM_status(rs.getString(7));
                                           e.setDate(rs.getDate(8));
                                                e.setAddress(rs.getString(9));
                                                     e.setCity(rs.getString(10));
                                                          e.setMno(rs.getString(11));
                                                               e.setDoctor_id(rs.getString(12));
                                                               e.setWard_no(rs.getString(13));
                                                               e.setBed_no(rs.getString(14));
                                                               
          
             //empList2.add(e);
             hm.put(e.getP_id(), e);
         }
        
    
         return hm;
    
    }
            
          public static     ArrayList<PatientPojo> getAllViewPatientDetails() throws SQLException//FOR VIEW patient FRAME
    {
        Connection conn= DBConnection.getConnection();
        Statement s = conn.createStatement();
         ResultSet rs = s.executeQuery("select * from patient");
        ArrayList<PatientPojo>empList2 = new ArrayList();
       
         while (rs.next())
         {
             PatientPojo e = new PatientPojo();
            e.setP_id(rs.getString(1));
             e.setF_name(rs.getString(2));
             e.setS_name(rs.getString(3));
                  e.setAge(rs.getInt(4));
                       e.setOpd(rs.getString(5));
                            e.setGender(rs.getString(6));
                                      e.setM_status(rs.getString(7));
                                           e.setDate(rs.getDate(8));
                                                e.setAddress(rs.getString(9));
                                                     e.setCity(rs.getString(10));
                                                          e.setMno(rs.getString(11));
                                                               e.setDoctor_id(rs.getString(12));
                                                               e.setWard_no(rs.getString(13));
                                                               e.setBed_no(rs.getString(14));
                                                               
          
             empList2.add(e);
 
         }
        
    
         return empList2;
    
    } 
          public static ArrayList<String>  getAllPatients() throws SQLException//FOR VIEW patient FRAME
    {
        Connection conn= DBConnection.getConnection();
        Statement s = conn.createStatement();
         ResultSet rs = s.executeQuery("select p_id from patient");
       ArrayList<String>Pid= new ArrayList();
         
         while (rs.next())
         {
            // PatientPojo e = new PatientPojo();
            //.setP_id(rs.getString(1));
          
                                                               
          
             Pid.add(rs.getString(1));
         }
        
    
         return Pid;
    
    } 
        
    public static boolean removePatient(String id) throws SQLException
    {
         Connection conn= DBConnection.getConnection();
         String qry = "delete from patient where p_id=?";
        PreparedStatement ps;
        ps = conn.prepareStatement(qry);
        ps.setString(1,id);
       
       int x = ps.executeUpdate();
       return x==1;
    }
       public static boolean UpdatePatient(PatientPojo p) throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="update patient set p_id=?,f_name=?,s_name=?,age=?,opd=?,gender=?,m_status=?,p_date=?,address=?,city=?,phone_no=?,doctor_id=?,ward_no=?,bed_no=? where p_id=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,p.getP_id());
        ps.setString(2,p.getF_name());
        ps.setString(3,p.getS_name());
        ps.setInt(4,p.getAge());
        ps.setString(5,p.getOpd());
        ps.setString(6,p.getGender());
        ps.setString(7,p.getM_status());
        ps.setDate(8,p.getDate());
        ps.setString(9,p.getAddress());
        ps.setString(10,p.getCity());
        ps.setString(11,p.getMno());
        ps.setString(12,p.getDoctor_id());
        ps.setString(13,p.getWard_no());
                ps.setString(14,p.getBed_no());
                  ps.setString(15,p.getP_id());
        int result=ps.executeUpdate();
        if(result==1){
            System.out.println("Update called");
            return true;
        }
          //System.out.println("false returned");
        return false;
    }
    
    
    
}

