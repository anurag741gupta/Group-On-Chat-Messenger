/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientPackage;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anurag Gupta
 */

public class Client {
    public Socket sock;
    public  ChatFrame myframe;
    public Client(ChatFrame myframe)
    {
        this.myframe=myframe;
         try {
           sock = new Socket("192.168.43.107",5910);
           ReceiveThread myThread =new ReceiveThread(sock,this);
           myThread.start();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Client()
            {
                try {
           sock = new Socket("192.168.43.107",5910);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    public Socket getClientSocket()
    {
        return this.sock;
    }
   
}
