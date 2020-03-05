/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevaniApp.pojo;

import java.sql.Date;


/**
 *
 * @author Vision
 */
public class PatientPojo {
    private String opd;
      private String doctor_id;
        private String f_name;
          private String s_name;
          private int age;
            private String p_id;
              private String gender;
                private String m_status;
                  private String address;
                    private String city;
                      private String mno;
                      private Date date;
                      private String ward_no;
                      private String bed_no;
                      

    public String getWard_no() {
        return ward_no;
    }

    public void setWard_no(String ward_no) {
        this.ward_no = ward_no;
    }

    public String getBed_no() {
        return bed_no;
    }

    public void setBed_no(String bed_no) {
        this.bed_no = bed_no;
    }
                      

   public PatientPojo() {
    }

    public PatientPojo(String opd, String doctor_id, String f_name, String s_name, int age, String p_id, String gender, String m_status, String address, String city, String mno, Date date,String ward_no,String bed_no) {
        this.opd = opd;
        this.doctor_id = doctor_id;
        this.f_name = f_name;
        this.s_name = s_name;
        this.age = age;
        this.p_id = p_id;
        this.gender = gender;
        this.m_status = m_status;
        this.address = address;
        this.city = city;
        this.mno = mno;
        this.date = date;
        this.ward_no=ward_no;
        this.bed_no=bed_no;
        
    }
                      

    @Override
    public String toString() {
        return "PatientPojo{" + "opd=" + opd + ", doctor_id=" + doctor_id + ", f_name=" + f_name + ", s_name=" + s_name + ", age=" + age + ", p_id=" + p_id + ", gender=" + gender + ", m_status=" + m_status + ", address=" + address + ", city=" + city + ", mno=" + mno + ", date=" + date + '}';
    }

    public String getOpd() {
        return opd;
    }

    public void setOpd(String opd) {
        this.opd = opd;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getM_status() {
        return m_status;
    }

    public void setM_status(String m_status) {
        this.m_status = m_status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
                      
                      
    
    
}
