/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerPackage;
import ServerPackage.Server;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Anurag Gupta
 */
public class ServerThread implements Runnable{
    
     private Socket sock;
     private DatabaseManager dbmanager;
     static int i=0;
    public ServerThread(Socket sock,DatabaseManager dbmanager)
    {
       this.sock=sock;
       this.dbmanager=dbmanager; 
    }
    @Override
     @SuppressWarnings("null")
    public void run()
    {
        while(true)
        {
         try {
            InputStream is = sock.getInputStream();
            ObjectInputStream ois= new ObjectInputStream(is);
            DefaultListModel model = new DefaultListModel();
             try {
                 model=(DefaultListModel) ois.readObject();
                 this.dbmanager.handlerFunction(model,this.sock);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
             }
         } catch (IOException ex) {
             Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    }   
            
}       
      /*   for(ServerThread st : Server.clientList)
        {

            if(st.username.equals(username))
            {
                Socket mysock=st.sock;
                OutputStream sout=null;
                try {
                   sout=mysock.getOutputStream();
                } catch (IOException ex) {
                    Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                ObjectOutputStream oos=null;
                try {
                  oos= new ObjectOutputStream(sout);
                } catch (IOException ex) {
                    Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                DefaultListModel model2 =new DefaultListModel();
                model2.addElement("MESSAGE");
                model2.addElement(username2);
                model2.addElement(mysock.getPort());
                model2.addElement(message);
                model2.addElement(username);
                System.out.println("Server : "+ message);
                try {
                    oos.writeObject(model);
                    oos.flush();
                } catch (IOException ex) {
                    Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
            }
        }    
      */
