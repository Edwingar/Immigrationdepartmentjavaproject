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
import static view.Immigrationview.centreWindow;
import static view.Immigrationview.setitlesfonts;

/**
 *
 * @author garce
 */
public class Customerinformation extends JFrame {

    private CustomerInformationcontroller controllerFromOutside;

    public Customerinformation(CustomerInformationcontroller controllerFromOutside, String fname, String sname, String Passport, String custId, int prioritynum) {

        // Setting the controller into the 
        // internal reference
        this.controllerFromOutside = controllerFromOutside;

        // Calling methods to set the whole windows
        this.settings();
        this.painting(fname, sname, Passport, custId, prioritynum);

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
     * @param priority
     */
    public void painting(String fname, String sname, String Passportno, String custId, int priority) {

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
        JLabel displayname = new JLabel(fname);
        setitlesfonts(displayname, 30);
        JLabel Secondname = new JLabel("Surname");
        setitlesfonts(Secondname, 35);
        JLabel displaySecondname = new JLabel(sname);
        setitlesfonts(displaySecondname, 30);
        JLabel Passport = new JLabel("Passport");
        setitlesfonts(Passport, 35);
        JLabel displayPassport = new JLabel(Passportno);
        setitlesfonts(displayPassport, 30);
        JLabel Id = new JLabel("Id");
        setitlesfonts(Id, 35);
        JLabel displayId = new JLabel(custId);
        setitlesfonts(displayId, 30);

        JLabel priorityn = new JLabel("Priority");
        setitlesfonts(priorityn, 35);
        JLabel displaypriority = new JLabel(Integer.toString(priority));
        setitlesfonts(displaypriority, 30);

        JButton delete = new JButton("Delete");
        delete.addActionListener(controllerFromOutside);
        delete.setActionCommand("Deletecustomer");

        JButton Edit = new JButton("Edit");
        Edit.addActionListener(controllerFromOutside);
        Edit.setActionCommand("editcustomer");

        panel.add(name);
        panel.add(displayname);
        panel.add(Secondname);
        panel.add(displaySecondname);
        panel.add(Passport);
        panel.add(displayPassport);
        panel.add(Id);
        panel.add(displayId);
        panel.add(priorityn);
        panel.add(displaypriority);

        panel2.add(delete);
        panel2.add(Edit);

        /**
         * adding the 2 panels to the frame
         */
        this.add(panel);
        this.add(panel2);

        this.validate();
        this.repaint();
    }

}
