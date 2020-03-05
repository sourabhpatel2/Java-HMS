/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevaniApp.dao;

import SanjeevaniApp.dbutil.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import SanjeevaniApp.pojo.EmpPojo;

/**
 *
 * @author HP
 */
public class EmpDao {
    public static String getNewId() throws SQLException//FOR ADD EMPLOYEE FRAME
    {
        Connection conn= DBConnection.getConnection();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("select max(empid) from employees");
        int id = 1;
        rs.next();
        
            String empid =rs.getString(1);
            int eno = Integer.parseInt(empid.substring(1));
            id=id + eno;
        
        String st ="E"+id;
        //System.out.println(st);
        return st;
        
    }
    public static boolean addEmployee(EmpPojo emp) throws SQLException//FOR ADD EMPLOYEE FRAME
    {
        
        Connection conn= DBConnection.getConnection();
        String qry = "insert into employees values(?,?,?,?)";
        PreparedStatement ps;
        ps = conn.prepareStatement(qry);
        ps.setString(1,emp.getEmpid());
        ps.setString(2,emp.getEmpname());
        ps.setDouble(4,emp.getSal());
        ps.setString(3,emp.getJob());
        
       int x = ps.executeUpdate();
       return x==1;
    }
    public static ArrayList <EmpPojo> getAllEmp() throws SQLException//FOR VIEW ALL EMPLOYEE FRAME
    {
        Connection conn= DBConnection.getConnection();
        Statement s = conn.createStatement();
         ResultSet rs = s.executeQuery("select * from employees");
         ArrayList<EmpPojo>empList = new ArrayList();
         
         while (rs.next())
         {
             EmpPojo e = new EmpPojo();
             e.setEmpid(rs.getString(1));
             e.setEmpname(rs.getString(2));
             e.setJob(rs.getString(3));
             e.setSal(rs.getDouble(4));
             empList.add(e);
         }
        
    
         return empList;
    
    }
        public static HashMap <String,EmpPojo> getAllEmpList() throws SQLException//FOR REMOVE EMPLOYEE
    {
        Connection conn= DBConnection.getConnection();
        Statement s = conn.createStatement();
         ResultSet rs = s.executeQuery("select * from employees");
         HashMap<String,EmpPojo>emplist = new HashMap();
         
         while (rs.next())
         {
             EmpPojo e = new EmpPojo();
             e.setEmpid(rs.getString(1));
             e.setEmpname(rs.getString(2));
             e.setJob(rs.getString(3));
             e.setSal(rs.getDouble(4));
             String empid=rs.getString(1);
             emplist.put(empid, e);
         }
        
    
         return emplist;
    
    }
    
    public static boolean removeEmployee(EmpPojo emp) throws SQLException
    {
         Connection conn= DBConnection.getConnection();
         String qry = "delete from employees where empid=?";
        PreparedStatement ps;
        ps = conn.prepareStatement(qry);
        ps.setString(1,emp.getEmpid());
       
       int x = ps.executeUpdate();
       return x==1;
    }
 public static HashMap <String ,String> getNonRegisteredReceptionistList() throws SQLException//FOR ADD RECEPTIONIST FRAME
 {
     Connection conn = DBConnection.getConnection();
     String qry = "select empid,empname from employees where role = 'RECEPTIONIST' and empid not in (select empid from users where usertype = 'RECEPTIONIST')";
     Statement st = conn.createStatement();
     ResultSet rs = st.executeQuery(qry);
     HashMap<String ,String> receptionist = new HashMap();
     while(rs.next())
     {
         String id = rs.getString(1);
         String name = rs.getString(2);
         receptionist.put(id,name);
     }
     return receptionist;
 }
    public static boolean updateEmployee(EmpPojo e) throws SQLException
    {
              Connection conn= DBConnection.getConnection();
        String qry = "update employees set empname=?,role=?,sal=? where empid=?";
        PreparedStatement ps;
        ps = conn.prepareStatement(qry);
     
        ps.setString(1,e.getEmpname());
          ps.setString(2,e.getJob());
        ps.setDouble(3,e.getSal());
          ps.setString(4,e.getEmpid());
      
        
       int x = ps.executeUpdate();
       return x==1;
    }
     public static HashMap <String ,String> getNonRegisteredDoctortList() throws SQLException//FOR ADD RECEPTIONIST FRAME
 {
     Connection conn = DBConnection.getConnection();
     String qry = "select empid,empname from employees where role = 'DOCTOR' and empid not in (select empid from users where usertype = 'DOCTOR')";
     Statement st = conn.createStatement();
     ResultSet rs = st.executeQuery(qry);
     HashMap<String ,String> doctors = new HashMap();
     while(rs.next())
     {
         String id = rs.getString(1);
         String name = rs.getString(2);
         doctors.put(id,name);
     }
     return doctors;
 }
}


