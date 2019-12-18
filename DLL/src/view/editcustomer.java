/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.CustomerInformationcontroller;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static view.Immigrationview.centreWindow;
import static view.Immigrationview.setitlesfonts;

/**
 *
 * @author garce
 */
public class editcustomer extends JFrame {

    private CustomerInformationcontroller controllerFromOutside;
    private JTextField editName;
    private JTextField editSecondname;
    private JTextField editpassport;

    public editcustomer(CustomerInformationcontroller controllerFromOutside, String fname, String sname, String Passport, String custId) {

        // Setting the controller into the 
        // internal reference
        this.controllerFromOutside = controllerFromOutside;

        // Calling methods to set the whole windows
        this.settings();
        this.painting(fname, sname, Passport, custId);

    }

    /**
     * setting the setting for the window
     */
    public void settings() {
        this.setVisible(true);
        this.setSize(400, 400);
        // centering the windows
        centreWindow(this);
    }

    /**
     * creating the whole frame with all the items needed
     *
     * @param fname
     * @param sname
     * @param Passportno
     * @param custId
     *
     */
    public void painting(String fname, String sname, String Passportno, String custId) {

        this.setLayout(new GridLayout(0, 1));
        /**
         * panel to hold the labels
         */
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        panel.setPreferredSize(new Dimension(380, 400));

        /**
         * panel to hold the buttons
         */
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(0, 2));
        panel2.setPreferredSize(new Dimension(380, 100));
        panel2.setLayout(new FlowLayout());

        JLabel name = new JLabel("Name");
        setitlesfonts(name, 35);
        editName = new JTextField(25);
        editName.setText(fname);
        JLabel Secondname = new JLabel("Surname");
        setitlesfonts(Secondname, 35);
        editSecondname = new JTextField(25);
        editSecondname.setText(sname);
        JLabel Passport = new JLabel("Passport");
        setitlesfonts(Passport, 35);
        editpassport = new JTextField(25);
        editpassport.setText(Passportno);

        JButton Save = new JButton("Save");
        Save.addActionListener(controllerFromOutside);
        Save.setActionCommand("Save");

        /**
         * adding all the labels and the text fields to the frame
         */
        panel.add(name);
        panel.add(editName);
        panel.add(Secondname);
        panel.add(editSecondname);
        panel.add(Passport);
        panel.add(editpassport);

        panel2.add(Save);

        /**
         * adding the 2 panels to the frame
         */
        this.add(panel);
        this.add(panel2);

        this.validate();
        this.repaint();
    }

    /**
     * All the getters for the private variables
     * @return 
     */
    public String getEditName() {
        return editName.getText();
    }

    public String getEditSecondname() {
        return editSecondname.getText();
    }

    public String getEditpassport() {
        return editpassport.getText();
    }

}
