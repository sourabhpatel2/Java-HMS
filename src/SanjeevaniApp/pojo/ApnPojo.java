/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevaniApp.pojo;

/**
 *
 * @author Vision
 */
public class ApnPojo {
    private String p_id;
      private String f_name;
        private String opd;

    @Override
    public String toString() {
        return "ApnPojo{" + "p_id=" + p_id + ", p_name=" + f_name + ", opd=" + opd + '}';
    }
        

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getOpd() {
        return opd;
    }

    public void setOpd(String opd) {
        this.opd = opd;
    }
        
    
}
