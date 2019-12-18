/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.Immigrationviewcontroller.dll;
import static Controller.Immigrationviewcontroller.ln;
import static dll.DLL.db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import validations.validations;
import view.Customerinformation;
import view.editcustomer;

/**
 *
 * @author garce
 */
public class CustomerInformationcontroller implements ActionListener {

    Customerinformation custInfo = null;
    editcustomer editcust = null;
    int position;

    public void setposition(int id) {
        this.position = id;
    }

    // this constructor opens a windows to only see the customer information
    public CustomerInformationcontroller(String name, String sname, String passport, String id, int priority) {

        custInfo = new Customerinformation(this, name, sname, passport, id, priority);
        setposition(priority);
    }

    // this constructor creates an instance of the class editcustomer
    public CustomerInformationcontroller(String name, String sname, String passport, String id) {

        editcust = new editcustomer(this, name, sname, passport, id);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Deletecustomer")) {
            int answer = JOptionPane.showConfirmDialog(custInfo, "Are you sure you want to delete this person from the queue?");
            if (answer == 0) {

                try {
                    dll.deleteany(position);
                } catch (Exception ex) {
                }

            } else {

            }

        }

        // this is to edit the customer information
        if (e.getActionCommand().equals("editcustomer")) {

            custInfo.setVisible(false);

            new CustomerInformationcontroller(ln.people.getFname(), ln.people.getsname(), ln.people.getpassport(), ln.people.getId());

        }

        // this will be executed when the button to update a customer information gets clicked
        if (e.getActionCommand().equals("Save")) {
            validations validate = new validations();
            boolean validated = false;
            validated = validate.validateupdate(editcust.getEditName(), editcust.getEditSecondname(), editcust.getEditpassport());
            if (validated == true) {

                ln.people.setFname(editcust.getEditName());
                ln.people.setSname(editcust.getEditSecondname());
                ln.people.setPassport(editcust.getEditpassport());

                // the database gets updated here
                db.update(ln.people.getId(), editcust.getEditName(), editcust.getEditSecondname(), editcust.getEditpassport());

                JOptionPane.showMessageDialog(editcust, "Your information have been succesfully changed");
                editcust.setVisible(false);
            }

        }

//To change body of generated methods, choose Tools | Templates.
    }

}
