package ServerPackage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anurag Gupta
 */
public class DatabaseManager {
    private static HashMap<String,Socket> clientList=new HashMap<>();
    
        public void createTable(String query)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            @SuppressWarnings("UnusedAssignment")
            Connection connect = null;
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");// connecting to database
            System.out.println("connected");
            @SuppressWarnings("UnusedAssignment")
            PreparedStatement stmt = null;
            stmt = connect.prepareStatement(query);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void createGroup(String query)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            Connection connect = null;
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_data","root","");// connecting to database
            System.out.println("connected");
            PreparedStatement stmt = null;
            stmt = connect.prepareStatement(query);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void groups(DefaultListModel model)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            System.out.println("Connecting to database...");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_data","root","");// connecting to database
            System.out.println("connected");
            
             PreparedStatement stmt = null;
                String insertSql = "INSERT INTO `groups`(`groupname`,`creator`) VALUES(?,?)";
            stmt = conn.prepareStatement(insertSql);
            stmt.setString(1, model.elementAt(0).toString());
            stmt.setString(2, model.elementAt(1).toString());
            stmt.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public ResultSet utilityGroup(String query)
   {
       ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_data","root","");           
            System.out.println("connected");
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
   }

    public void updateTable(DefaultListModel model)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            System.out.println("Connecting to database...");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");// connecting to database
            System.out.println("connected");
            
             PreparedStatement stmt = null;
                String insertSql = "INSERT INTO `User_data`( `First_Name`,`Last_Name`,`Gender`,`Date_Of_Birth`,`Username`,`Password`,`Question`,`Answer`) VALUES(?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(insertSql);
            stmt.setString(1, model.elementAt(1).toString());
            stmt.setString(2, model.elementAt(2).toString());
            stmt.setString(3, model.elementAt(3).toString());
            stmt.setString(4, model.elementAt(4).toString());
            stmt.setString(5, model.elementAt(5).toString());
            stmt.setString(6, model.elementAt(6).toString());
            stmt.setString(7, model.elementAt(7).toString());
            stmt.setString(8, model.elementAt(8).toString());
            stmt.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   public ResultSet utility(String query,int i,String username)
   {
       ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");           
            System.out.println("connected");
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement(query);
            if(i==1)
            stmt.setString(1,username);
            rs = stmt.executeQuery();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
   }

    void handlerFunction(DefaultListModel model, Socket sock) {
         DefaultListModel arr[]=new DefaultListModel[100];
         int i=0;
         DefaultListModel ansmodel=new DefaultListModel();
         
        if(model.elementAt(0).toString().equals("CHECK"))
        {
            try
            {    
            ansmodel.addElement("CHECK");
            String selectSql = "SELECT Username,Password FROM User_data";
            boolean x=false;
            ResultSet rs = utility(selectSql,0,model.elementAt(1).toString());
            while(rs.next())
            {
                
                String check = rs.getString("Username");
                if(check.equals(model.elementAt(1).toString()))
                {
                    x=true;
                    String pswd = rs.getString("Password");
                    if(pswd.equals(model.elementAt(2).toString()))
                    {
                        ansmodel.addElement("SUCCESS");
                        break;
                    }
                    else
                    {
                        ansmodel.addElement("WRONGP");
                        break;
                    }
                }    
            }
            System.out.println("sdjcjhsdgfcvnbvccwegsfdcvsdvjhs");
            if(x==false)
            {
               ansmodel.addElement("WRONGU");
            }
            sender(ansmodel,sock);
                  
            
        }  catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        
        else if(model.elementAt(0).toString().equals("LOGIN"))
       {
           try
           {
             String search = "Select * From User_data Where Username=?";
             ResultSet rs = utility(search, 1, model.elementAt(1).toString());
             ansmodel.addElement("LOGIN");
             System.out.println("hwsdgchj");
             
                while(rs.next())
                {
                String name1=rs.getString("First_Name");
                String name2=rs.getString("Last_Name");
                String myname=name1+" "+name2;
                ansmodel.addElement(myname);
                }
                System.out.println(ansmodel.elementAt(1).toString());
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
                  clientList.put(model.elementAt(1).toString(),sock);
              
              String search2 = "SELECT * FROM "+model.elementAt(1).toString();
              ResultSet rs2 = utility(search2, 0, model.elementAt(1).toString());
            try {
                while(rs2.next())
                {
                    DefaultListModel newmodel=new DefaultListModel();
                    String user=rs2.getString("username");
                    String name2 = rs2.getString("firstname")+" "+rs2.getString("lastname");
                    int index = Integer.parseInt(rs2.getString("index"));
                    String status=rs2.getString("status");
                    boolean islogin= rs2.getBoolean("islogin");
                    newmodel.addElement(user);
                    newmodel.addElement(name2);
                    newmodel.addElement(status);
                    newmodel.addElement(islogin);
                    arr[index-1]=newmodel;
                        i++;
                }
                
                    DefaultListModel friend=new DefaultListModel();
                    for(int j=0;j<i;j++)
                  {
                      friend.add(j,arr[j]);
                  }
                    
                ansmodel.addElement(friend);
                  
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("FRIEND COMPLETE");
             String search3 = "SELECT * FROM "+model.elementAt(1).toString();
              ResultSet rs3 = utilityGroup(search3);
              DefaultListModel arr2[]=new DefaultListModel[100];
              i=0;
            try {
                while(rs3.next())
                {
                    DefaultListModel newmodel2=new DefaultListModel();
                    String name2 = rs3.getString("groupname");
                    int index = Integer.parseInt(rs3.getString("index"));
                    String status=rs3.getString("status");
                    newmodel2.addElement(name2);
                    newmodel2.addElement(status);
                    arr2[index-1]=newmodel2;
                        i++;
                        System.out.println(i);
                }
                
                    DefaultListModel group=new DefaultListModel();
                    for(int j=0;j<i;j++)
                  {
                      group.add(j,arr2[j]);
                  }
                    System.out.println("GROUP COMPLETED");
                ansmodel.addElement(group);
                sender(ansmodel,sock);
                  
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       else if(model.elementAt(0).toString().equals("FRIEND_INFO"))
       {
             try {
                // String query = "SELECT * FROM "+model.elementAt(1).toString()+" WHERE `index`=?";
                 // ResultSet rs2 = utility(query, 0, model.elementAt(1).toString());
                 Class.forName("com.mysql.jdbc.Driver");
                 
                 System.out.println("Connecting to database...");
                 Connection conn = null;
                 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");// connecting to database
                 System.out.println("connected");
                 PreparedStatement pst=null;
                 System.out.println(model.elementAt(1).toString());
                 String searchSql="select  * from " + model.elementAt(1).toString()+" where `index`=?";
                 pst=conn.prepareStatement(searchSql);
                 pst.setInt(1,(int)model.elementAt(2)+1);
                 ResultSet rs=pst.executeQuery();
                 DefaultListModel friend2=new DefaultListModel();
                 friend2.addElement("FRIEND_INFO");
                     while (rs.next()) {
                         String name= rs.getString("firstname")+" "+rs.getString("lastname");
                         String status=rs.getString("status");
                         boolean isLogin=rs.getBoolean("islogin");
                         friend2.addElement(name);
                         friend2.addElement(status);
                         friend2.addElement(isLogin);
                         
                     }
                    sender(friend2,sock);
                
                    
             }           catch (ClassNotFoundException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       else if(model.elementAt(0).toString().equals("REGISTER"))
       {
           updateTable(model);
           createTable(model.elementAt(9).toString());
       }
       else if(model.elementAt(0).toString().equals("FORGOT_PASSWORD"))
       {
           DefaultListModel model2=new DefaultListModel();
           model2.addElement("FORGOT_PASSWORD");
           boolean find=false;
           ResultSet rs=utility(model.elementAt(2).toString(),0,null);
             try {
                 while(rs.next())
                 {
                     String username=rs.getString("Username");
                     String qus=rs.getString("Question");
                     String ans=rs.getNString("Answer");
                     if(username.equals(model.elementAt(1).toString()))
                     {
                         model2.addElement("CORRECT");
                         model.addElement(username);
                         model.addElement(qus);
                         model.addElement(ans);
                         find=true;
                         break;   
                     }
                 }
                   if(find==false)
                   {
                       model2.addElement("WRONG");
                   }
                 
                  } catch (SQLException ex) {
                 Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
             }
             sender(model2,sock);
       }
       else if(model.elementAt(0).toString().equals("RESET_MODEL"))
       {
           utility(model.elementAt(1).toString(),0,null);
       }
       else if(model.elementAt(0).toString().equals("MESSAGE"))
       {
           if(model.elementAt(1).toString().equals("FRIEND"))
           {
               String receiver=model.elementAt(3).toString();
               Socket mysock=clientList.get(receiver);
               sender(model,mysock);
           }
           else if(model.elementAt(1).toString().equals("GROUP"))
           {
               
           }
       }
       else if(model.elementAt(0).toString().endsWith("FILE"))
       {
           if(model.elementAt(1).toString().equals("FRIEND"))
           {
               DefaultListModel model2=new DefaultListModel();
               model2.addElement("FILE");
               model2.addElement("FRIEND");
               String user=model.elementAt(3).toString();
               Socket mysock=clientList.get(user);
               model2.addElement(user);
               model2.addElement(model.elementAt(2).toString());
               byte[] buffer = (byte[]) model.getElementAt(4);
               System.out.println("FILE WILL SEND TO "+user+" "+buffer.length);
               model2.addElement(buffer);
               sender(model2,mysock);
           }
           else if(model.elementAt(1).toString().equals("GROUP"))
           {
               
           }
       }
        
        else if(model.elementAt(0).toString().equals("UNIQUE"))
        {
             DefaultListModel obj=new DefaultListModel();
            try
            {
            boolean x=false;
            String user = model.elementAt(1).toString();
             //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");// connecting to database
            PreparedStatement stmt = null;
            String selectSql = "SELECT Username FROM User_data";
            stmt = conn.prepareStatement(selectSql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                String check = rs.getString("Username");
                if(check.equals(user))
                {
                    x=true;
                    break;
                }
            }
            if(x==true)
            {
                obj.addElement("PRESENT");
            }
            else obj.addElement("TEMP");
              sender(obj,sock);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        else if(model.elementAt(0).toString().equals("SEARCH FRIEND"))
        {
            DefaultListModel obj=new DefaultListModel();
            String name=model.elementAt(1).toString();
             try {
            String query = "SELECT First_Name,Last_Name,Username FROM User_data";
            ResultSet rs=utility(query, 0, name);
            while(rs.next())
            {
                String first=rs.getString("First_Name");
                String surname = rs.getString("Last_Name");
                String x=first+" "+surname;
                if(x.equalsIgnoreCase(name))
                {
                    obj.addElement(rs.getString("Username"));
                }
            }
              sender(obj,sock);
             
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }  
        }
        else if(model.elementAt(0).toString().equals("FETCH"))
        {
            DefaultListModel obj = new DefaultListModel();
            String query = "SELECT Gender,Date_Of_Birth FROM User_data WHERE `Username`='"+model.elementAt(1).toString()+"'";
            ResultSet rs = utility(query, 0, model.elementAt(1).toString());
             try {
                 while(rs.next())
                 {
                     System.out.println("xyz");
                     obj.addElement(rs.getString("Gender"));
                     obj.addElement(rs.getString("Date_Of_Birth"));
                     
                 }
                  sender(obj,sock);
             } catch (SQLException ex) {
                 Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        else if(model.elementAt(0).toString().equals("CREATE GROUP"))
        {
            
            groups((DefaultListModel) model.elementAt(2));
            createGroup(model.elementAt(1).toString());
        }
        else if(model.elementAt(0).toString().equals("SEARCH GROUP"))
        {
            DefaultListModel obj=new DefaultListModel();
            String name=model.elementAt(1).toString();
             try {
            String query = "SELECT groupname,creator FROM groups";
            ResultSet rs=utilityGroup(query);
            while(rs.next())
            {
                String gname=rs.getString("groupname");
                String admin = rs.getString("creator");
                if(gname.equalsIgnoreCase(name))
                {
                    obj.addElement(gname+" creator is - "+admin);
                }
            }
            sender(obj,sock);
             
             
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }  
        }
                
        else if(model.elementAt(0).toString().equals("INVITE"))
        {
            
            
        }
    
}
    public void sender(DefaultListModel model,Socket socket)
    {
        try {
                  OutputStream out = socket.getOutputStream();
                  ObjectOutputStream oos = new ObjectOutputStream(out);
                  oos.writeObject(model);
              } catch (IOException ex) {
                  Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
              }
    }
}
