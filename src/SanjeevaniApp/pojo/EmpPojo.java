/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevaniApp.pojo;

/**
 *
 * @author HP
 */
public class EmpPojo {

    public String getEmpid() {
        return empid;
    }

    @Override
    public String toString() {
        return "EmpPojo{" + "empid=" + empid + ", empname=" + empname + ", job=" + job + ", sal=" + sal + '}';
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
    private String empid , empname , job;
    private double sal; 
    
}
