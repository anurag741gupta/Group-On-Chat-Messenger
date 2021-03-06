/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Forget_Password extends javax.swing.JFrame {
   private final Client myclient;
   private String user,ans;
   boolean x = false;
    /**
     * Creates new form Forget_Password
     */
    public Forget_Password() {
        
        initComponents();
         this.myclient=new Client();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        labelQues = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAnswer = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnQuestion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enter Username : ");

        txtUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Question : ");

        labelQues.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelQues.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Answer : ");

        txtAnswer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAnswer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnSubmit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubmitMouseClicked(evt);
            }
        });

        btnQuestion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQuestion.setText("Show Security Question");
        btnQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuestionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelQues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAnswer))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubmit)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelQues, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmit)
                    .addComponent(btnQuestion))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseClicked
        
           
             try {
                  InputStream in = this.myclient.sock.getInputStream();
                  ObjectInputStream ois = new ObjectInputStream(in);
                  DefaultListModel model=(DefaultListModel) ois.readObject();
                  if(model.elementAt(0).toString().equals("FORGOT_PASSWORD"))
                  {
                      if(model.elementAt(1).toString().equals("CORRECT"))
                      { 
                        this.labelQues.setText(model.elementAt(3).toString());
                        String ans = txtAnswer.getText();   
                      if(model.elementAt(4).toString().equals(ans))
                            {
                               while(true)
                                {
                                  String newPass = JOptionPane.showInputDialog("Enter New Password : ");
                                    if(newPass.length()>=8)
                                      {
                                        String insertSql = "UPDATE `User_data` SET `Password`='"+newPass+"' WHERE `Username`='"+user+"'";
                                        this.setVisible(false);
                                        DefaultListModel model2=new DefaultListModel();
                                        model2.addElement("RESET_PASSWORD");
                                        model2.addElement(insertSql);
                                        try {
                                            OutputStream out = myclient.sock.getOutputStream();
                                            ObjectOutputStream oos = new ObjectOutputStream(out);
                                            oos.writeObject(model);
                                           } catch (IOException ex) {
                                            Logger.getLogger(Forget_Password.class.getName()).log(Level.SEVERE, null, ex);
                                           }
                                        try {
                                            myclient.sock.close();
                                           } catch (IOException ex) {
                                             Logger.getLogger(Forget_Password.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        break;
                                      }
                                    else
                                       {
                                         JOptionPane.showMessageDialog(null, "Password have atleast 8 characters\nPlease Re-enter");
                                        }
                                }
                            }
                        else
                            {
                              JOptionPane.showMessageDialog(null,"Wrong Answer \n Re-Enter");
                              txtAnswer.setText(null);
                            }
                      }
                      else if(model.elementAt(1).toString().equals("WRONG"))
                      {
                          JOptionPane.showMessageDialog(null,"Username does not exist");
                           txtUsername.setText(null);
                           labelQues.setText(null);
                      }
                   }
              } catch (IOException ex) {
                  Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
              } catch (ClassNotFoundException ex) {     
                Logger.getLogger(Forget_Password.class.getName()).log(Level.SEVERE, null, ex);
             }
             
    }//GEN-LAST:event_btnSubmitMouseClicked

    private void btnQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuestionMouseClicked
             user = txtUsername.getText();
             DefaultListModel model =new DefaultListModel();
             model.addElement("FORGOT_PASSWORD");
             model.addElement(user);
             String selectSql = "SELECT Username,Question,Answer FROM User_data";
             model.addElement(selectSql);
                 try {
                  OutputStream out = myclient.sock.getOutputStream();
                  ObjectOutputStream oos = new ObjectOutputStream(out);
                  oos.writeObject(model);
              } catch (IOException ex) {
                  Logger.getLogger(Forget_Password.class.getName()).log(Level.SEVERE, null, ex);
              }
       
    }//GEN-LAST:event_btnQuestionMouseClicked

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
            java.util.logging.Logger.getLogger(Forget_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Forget_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Forget_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forget_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Forget_Password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuestion;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelQues;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
