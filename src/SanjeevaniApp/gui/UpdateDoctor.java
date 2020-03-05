/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanjeevaniApp.gui;

import SanjeevaniApp.dao.DoctorsDao;
import SanjeevaniApp.dao.UserDao;
import SanjeevaniApp.dbutil.DBConnection;
import SanjeevaniApp.pojo.DoctorsPojo;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Vision
 */
public class UpdateDoctor extends javax.swing.JFrame {

    /**
     * Creates new form UpdateDoctor
     */
     HashMap<String,String>doctorlist;
     String password;
    public UpdateDoctor() 
    {
        initComponents();
        setLocationRelativeTo(null);
        loadDoctorsList();

    }
    private void closeFrame(){
         int ans;
        ans=JOptionPane.showConfirmDialog(null,"Are you sure","Quiting",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(ans==JOptionPane.YES_OPTION)
        {
            DBConnection.closeConnection();
            System.exit(0);
        }
}
            public void loadDoctorsList()
{
    try
    {
        doctorlist = DoctorsDao.getAllDoctorsList();
    if(doctorlist.size()==0){
           JOptionPane.showMessageDialog(null, "No registered Receptionist present");
           //RegisterButton.setEnabled(false);
           return;
    }
       // RegisterButton.setEnabled(true);
       Set<String> rid= doctorlist.keySet();
       // Iterator <String> it = keys.iterator();
        //jcEmpId.removeAllItems();
        for(String id:rid)
        {
            jcReceptionistId.addItem(id);
        }
    }
    catch(Exception e)
    {
       // JOptionPane.showMessageDialog(null, "SQL me dikkat ","error",JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
    }
}
              public boolean validateInput()
   {
        char[] pwd = txtPassword.getPassword();
        char[] repass = rePassword.getPassword();
        if(pwd.length==0||repass.length==0)
        {
            JOptionPane.showMessageDialog(null,"plz enter both password field","Error",JOptionPane.ERROR_MESSAGE);
        
        return false;
        }
      password=String.valueOf(pwd);
       String rePassword=String.valueOf(repass);
       if(!password.equals(rePassword))
       {
              JOptionPane.showMessageDialog(null, "Password do not match","error",JOptionPane.ERROR_MESSAGE);
              return false;
       }
       return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUpdatePassword = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtReceptionistName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcReceptionistId = new javax.swing.JComboBox<>();
        txtPassword = new javax.swing.JPasswordField();
        rePassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));

        btnLogout.setText("logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Change Password");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnLogout))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jLabel1.setText("User id");

        jLabel2.setText("Doctor Name");

        jLabel3.setText("password");

        btnUpdatePassword.setText("Update Password");
        btnUpdatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePasswordActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtReceptionistName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReceptionistNameActionPerformed(evt);
            }
        });

        jLabel5.setText("Re-Password");

        jcReceptionistId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcReceptionistIdItemStateChanged(evt);
            }
        });
        jcReceptionistId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcReceptionistIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtReceptionistName)
                                    .addComponent(jcReceptionistId, 0, 100, Short.MAX_VALUE)
                                    .addComponent(txtPassword)
                                    .addComponent(rePassword)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(btnUpdatePassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)))
                        .addGap(94, 94, 94)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcReceptionistId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtReceptionistName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdatePassword)
                    .addComponent(btnBack))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int ans;
        LoginFrame l = new LoginFrame();
        ans = JOptionPane.showConfirmDialog(null, "Are you sure u want to logout", "Logout",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (ans== JOptionPane.YES_OPTION){
            l.setVisible(true);

        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnUpdatePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePasswordActionPerformed
        if (validateInput()==false)
        {
            JOptionPane.showMessageDialog(null, "Invalid input","error",JOptionPane.ERROR_MESSAGE);
            return ;
        }

        try
        {
            boolean result=UserDao.changePassword(jcReceptionistId.getSelectedItem().toString(),password);
            /*   String eno = txtEmpid.getText();
            String job = jcbJob.getSelectedItem().toString();
            String jobuper=job.toUpperCase();
            String ename = txtEmpName.getText();
            double sal = Double.parseDouble(TxtSal.getText());
            EmpPojo e = new EmpPojo();

            e.setEmpid(eno);
            e.setEmpname(ename);
            e.setJob(jobuper);
            e.setSal(sal);
            boolean result =EmpDao.addEmployee(e);*/
            if(!result)
            {
                JOptionPane.showMessageDialog(null,"Record unchanged","Error",JOptionPane.ERROR_MESSAGE);

            }
            else
            {
                JOptionPane.showMessageDialog(null,"password changed","wooh!",JOptionPane.INFORMATION_MESSAGE);

            }
        }
        catch(Exception e)
        {
            // JOptionPane.showMessageDialog(null,"SQL me dikkat h","error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnUpdatePasswordActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        ManageDoctors mef = new ManageDoctors();
        mef.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void jcReceptionistIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcReceptionistIdItemStateChanged
        //  if (jcReceptionistId.getItemCount()==0) return;
        txtReceptionistName.setText(doctorlist.get(jcReceptionistId.getSelectedItem().toString()));
    }//GEN-LAST:event_jcReceptionistIdItemStateChanged

    private void jcReceptionistIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcReceptionistIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcReceptionistIdActionPerformed

    private void txtReceptionistNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReceptionistNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReceptionistNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUpdatePassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> jcReceptionistId;
    private javax.swing.JPasswordField rePassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtReceptionistName;
    // End of variables declaration//GEN-END:variables
}