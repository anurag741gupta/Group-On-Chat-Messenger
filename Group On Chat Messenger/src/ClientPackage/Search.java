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
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Search extends javax.swing.JFrame {

    private Socket clientSocket;
    private int i=0;
    private String username;
     DefaultListModel model2 = new DefaultListModel();
     
     public Search(String username)
     {
         this.username=username;
         initComponents();
        btnJoin.setVisible(false);
        profileImage.setVisible(false);
        gender.setVisible(false);
        dob.setVisible(false);
        btnAddFriend.setVisible(false);
        genderFixed.setVisible(false);
        dobFixed.setVisible(false);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Client myclient=new Client();
         clientSocket= myclient.getClientSocket();
     }
    public Search() {
        
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
        search = new javax.swing.JTextField();
        searchFriend = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchResult = new javax.swing.JList();
        btnSearchGroup = new javax.swing.JButton();
        profileImage = new javax.swing.JLabel();
        btnAddFriend = new javax.swing.JButton();
        genderFixed = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        dobFixed = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        btnJoin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enter A Name : ");

        search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        search.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        searchFriend.setBackground(new java.awt.Color(0, 204, 204));
        searchFriend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchFriend.setText("Search A Friend");
        searchFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFriendActionPerformed(evt);
            }
        });

        searchResult.setBackground(new java.awt.Color(102, 255, 255));
        searchResult.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchResult.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchResult.setFixedCellHeight(30);
        searchResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchResultMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(searchResult);

        btnSearchGroup.setBackground(new java.awt.Color(255, 255, 0));
        btnSearchGroup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchGroup.setText("Search Groups");
        btnSearchGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchGroupActionPerformed(evt);
            }
        });

        profileImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClientPackage/useprofile.png"))); // NOI18N

        btnAddFriend.setBackground(new java.awt.Color(204, 0, 204));
        btnAddFriend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddFriend.setText("Add Friend");

        genderFixed.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        genderFixed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        genderFixed.setText("Gender");

        gender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        dobFixed.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dobFixed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dobFixed.setText("Date Of Birth");

        dob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnJoin.setBackground(new java.awt.Color(255, 0, 204));
        btnJoin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnJoin.setText("JOIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchFriend)
                        .addGap(70, 70, 70)
                        .addComponent(btnSearchGroup)
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(dobFixed)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(genderFixed)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnJoin)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(gender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(profileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(57, 57, 57))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnAddFriend)
                                                .addGap(64, 64, 64))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchFriend)
                    .addComponent(btnSearchGroup))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(profileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(genderFixed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnJoin)
                                .addGap(31, 31, 31)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dobFixed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddFriend)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void searchFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFriendActionPerformed
       i=1;
       btnJoin.setVisible(false);
        gender.setText(null);
        dob.setText(null);
        profileImage.setVisible(true);
       gender.setVisible(true);
       dob.setVisible(true);
       btnAddFriend.setVisible(true);
       genderFixed.setVisible(true);
        dobFixed.setVisible(true);
       searchResult.setListData(new Vector());
       searchResult.revalidate();
       searchResult.repaint();
       String name = search.getText();
       DefaultListModel model = new DefaultListModel();
       DefaultListModel model3 = new DefaultListModel();
       model.addElement("SEARCH FRIEND");
       model.addElement(name);
       try {
                  OutputStream out = this.clientSocket.getOutputStream();
                  ObjectOutputStream oos = new ObjectOutputStream(out);
                  oos.writeObject(model);
              } catch (IOException ex) {
                  Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
              } 
        try
        {
        InputStream in = this.clientSocket.getInputStream();
        ObjectInputStream iis = new ObjectInputStream(in);
       model2=(DefaultListModel) iis.readObject();
        } catch (IOException ex) {
                  Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
              } catch (ClassNotFoundException ex) { 
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } 
       int len = model2.size();
       if(len>0)
       {
       for(int  i=0;i<len;i++)
           model3.addElement(name);
       searchResult.setModel(model3);
       }
       else
       {
           JOptionPane.showMessageDialog(null, "The Friend You Are Searching For Does Not Have An Account");
           profileImage.setVisible(false);
        gender.setVisible(false);
        dob.setVisible(false);
        btnAddFriend.setVisible(false);
        genderFixed.setVisible(false);
        dobFixed.setVisible(false);
       }
       
    }//GEN-LAST:event_searchFriendActionPerformed

    private void searchResultMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchResultMousePressed
       if(i==1)
       {
        int p = this.searchResult.getMaxSelectionIndex();
        DefaultListModel sender = new DefaultListModel();
        DefaultListModel receive = new DefaultListModel();
        sender.addElement("FETCH");
        sender.addElement(model2.elementAt(p).toString());
        try {
                  OutputStream out = this.clientSocket.getOutputStream();
                  ObjectOutputStream oos = new ObjectOutputStream(out);
                  oos.writeObject(sender);
              } catch (IOException ex) {
                  Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
              } 
        try
        {
        InputStream in = this.clientSocket.getInputStream();
        ObjectInputStream iis = new ObjectInputStream(in);
       receive=(DefaultListModel) iis.readObject();
        } catch (IOException ex) {
                  Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
              } catch (ClassNotFoundException ex) { 
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } 
        gender.setText(receive.elementAt(0).toString());
        dob.setText(receive.elementAt(1).toString());
       }
       else if(i==2)
       {
           
       }
    }//GEN-LAST:event_searchResultMousePressed

    private void btnSearchGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchGroupActionPerformed
        i=2; 
        btnJoin.setVisible(true);
         searchResult.setListData(new Vector());
       searchResult.revalidate();
       searchResult.repaint();
        String name = search.getText();
       DefaultListModel model = new DefaultListModel();
       DefaultListModel model4 = new DefaultListModel();
       DefaultListModel model3 = new DefaultListModel();
       model.addElement("SEARCH GROUP");
       model.addElement(name);
       try {
                  OutputStream out = this.clientSocket.getOutputStream();
                  ObjectOutputStream oos = new ObjectOutputStream(out);
                  oos.writeObject(model);
              } catch (IOException ex) {
                  Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
              } 
        try
        {
        InputStream in = this.clientSocket.getInputStream();
        ObjectInputStream iis = new ObjectInputStream(in);
       model3=(DefaultListModel) iis.readObject();
        } catch (IOException ex) {
                  Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
              } catch (ClassNotFoundException ex) { 
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } 
       if(model3.size()>0)
       {
           int l=model3.size();
       for(int i=0;i<l;i++)
       {
           String a=model3.elementAt(i).toString();
           String check = a.substring(a.lastIndexOf(' ')+1,a.length());
           if(!(check.equalsIgnoreCase(username)))
           {
               model4.addElement(a);
           }
       }
       searchResult.setModel(model4);
       }
       else
       {
           JOptionPane.showMessageDialog(null, "The Group "+name+" Does Not Exist");
          btnJoin.setVisible(false);
       }
        
        
    }//GEN-LAST:event_btnSearchGroupActionPerformed

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
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search().setVisible(true);
            }
        });
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFriend;
    private javax.swing.JButton btnJoin;
    private javax.swing.JButton btnSearchGroup;
    private javax.swing.JLabel dob;
    private javax.swing.JLabel dobFixed;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel genderFixed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel profileImage;
    private javax.swing.JTextField search;
    private javax.swing.JButton searchFriend;
    private javax.swing.JList searchResult;
    // End of variables declaration//GEN-END:variables
}
