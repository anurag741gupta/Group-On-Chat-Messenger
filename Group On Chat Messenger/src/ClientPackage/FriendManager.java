/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientPackage;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Anurag Gupta
 */
public class FriendManager {
    private ChatFrame myframe;
 public ArrayList<DefaultListModel> friendlist;
 public  FriendManager(ChatFrame myframe)
 {
     friendlist=new ArrayList<>();
     this.myframe=myframe;
 }
}  
 