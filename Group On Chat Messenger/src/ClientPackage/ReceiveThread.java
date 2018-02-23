/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientPackage;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
/**
 *
 * @author Anurag Gupta
 */
public class ReceiveThread extends Thread {
    private Socket sock;
    private Client client;
    public ReceiveThread(Socket sock, Client client)
    {
        this.sock=sock;
        this.client=client;
    }
    @Override
    public void run() {
      try {
            //To change body of generated methods, choose Tools | Templates.

               InputStream sin = sock.getInputStream();
               
               while(true)
               {
                   try {  
                        ObjectInputStream ois=new ObjectInputStream(sin);
                        DefaultListModel model=(DefaultListModel) ois.readObject(); 
                        client.myframe.handler(model);      
                   } catch (ClassNotFoundException ex) {
                       Logger.getLogger(ReceiveThread.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           } catch (IOException ex) {
               Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
  
    
    
}
