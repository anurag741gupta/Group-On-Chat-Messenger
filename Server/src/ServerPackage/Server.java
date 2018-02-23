/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerPackage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anurag Gupta
 */
public  class Server { 
       private ServerSocket serverSocket;
       public static int count=0;  
       public Server() throws UnknownHostException
       {
           String str="192.168.43.107";
           InetAddress addr;
           addr = InetAddress.getByName(str);
           try {
               serverSocket= new ServerSocket(5910, count,addr);
           } catch (IOException ex) {
               Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
           }      
        }
      public void connection()
      {
          while(true)
          {
              try {
                   System.out.println("Waiting for client to connect....");
                   Socket sock = serverSocket.accept();
                   System.out.println("Client No."+(count+1)+" connected");
                   String p="Client"+(++count);
                   ServerThread newClient=new ServerThread(sock,new DatabaseManager());
                   Thread mythread=new Thread(newClient);
                   mythread.start();
              } catch (IOException ex) {
                  Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
              }
          
          }
      }
     public static void main(String[] args) throws IOException
     {
         Server myServer= new Server();
         myServer.connection();
     }
   
    
}
