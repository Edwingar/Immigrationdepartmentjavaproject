/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static Controller.Immigrationviewcontroller.dll;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static view.Immigrationview.centreWindow;

/**
 *
 * @author garce
 */
public class users extends JFrame{
    
    
    
    
public users(){

settings();
painting();


}    

public void settings(){
this.setVisible(true);
this.setLayout(new FlowLayout());
this.setSize(800, 400);
centreWindow(this);
}

public void painting(){
String[] headers = {"Position", "Name", "Surname", "Passport", "Code", "Priority"};

      JTable viewtable= new JTable(dll.getUsers(),headers);
      JScrollPane jsp= new JScrollPane(viewtable);
      viewtable.setPreferredScrollableViewportSize(new Dimension(700,300));
      this.add(jsp);
      
      
      dll.load();

}
}
