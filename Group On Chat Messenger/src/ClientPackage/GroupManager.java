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
public class GroupManager {
    public ArrayList<DefaultListModel> grouplist;
    private ChatFrame myframe;
    public GroupManager(ChatFrame myframe)
    {
        grouplist=new ArrayList<>();
        this.myframe=myframe;
    }
    
    
}
