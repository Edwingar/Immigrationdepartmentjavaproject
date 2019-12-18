/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static dll.DLL.db;
import dll.DoublyLinkedList;
import dll.ListNode;
import dll.people.Highpriority;
import dll.people.Lowpriority;
import dll.people.Mediumpriority;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;
import validations.validations;
import view.Immigrationview;
import view.users;

/**
 *
 * @author garce
 */
public class Immigrationviewcontroller implements ActionListener {

    public static DoublyLinkedList dll = new DoublyLinkedList();
    Immigrationview view = null;
    public static ListNode ln;

    public static String showname = "";

    public Immigrationviewcontroller() {
        view = new Immigrationview(this);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

        /**
         * if the signup button gets clicked then this code bellow will be
         * executed
         */
        if (arg0.getActionCommand().equals("signup")) {

            String priority = view.getcategory();
            validations validate = new validations();
            boolean validated = false;
            // an id is gonna be created with a random number
            Random randomid = new Random();
            int num = randomid.nextInt(500);
            String Id = "IDEP" + Integer.toString(num);

            if (priority.equals("Low")) {

                validated = validate.validatesignupform(view.getname(), view.getsecondname(), view.getDate(), view.getpassport());
                if (validated == true) {
                    dll.saveuser(new Lowpriority(view.getname(), view.getsecondname(), view.getDate(), view.getpassport(), 0, Id));
                    db.save(view.getname(), view.getsecondname(), view.getpassport(), view.getDate(), priority, dll.FetchId(view.getpassport()));
                }

            } else if (priority.equals("Medium")) {

                validated = validate.validatesignupform(view.getname(), view.getsecondname(), view.getDate(), view.getpassport());
                if (validated == true) {
                    dll.saveuser(new Mediumpriority(view.getname(), view.getsecondname(), view.getDate(), view.getpassport(), 0, Id));
                    db.save(view.getname(), view.getsecondname(), view.getpassport(), view.getDate(), priority, dll.FetchId(view.getpassport()));
                }

            } else if (priority.equals("High")) {

                validated = validate.validatesignupform(view.getname(), view.getsecondname(), view.getDate(), view.getpassport());
                if (validated == true) {
                    dll.saveuser(new Highpriority(view.getname(), view.getsecondname(), view.getDate(), view.getpassport(), 0, Id));
                    db.save(view.getname(), view.getsecondname(), view.getpassport(), view.getDate(), priority, dll.FetchId(view.getpassport()));
                }

            }

            if (validated) {
                JOptionPane.showMessageDialog(view, "You have registered a new person in the queue" + "  " + dll.FetchId(view.getpassport()));
            }
        } /**
         * this code bellow will be executed when trying to find someone by
         * their code
         */
        else if (arg0.getActionCommand().equals("searchperson")) {
            String id = view.getid();
            // we catch the null point of exception and then we give it a message or an action
            try {
                ln = dll.searchforpersonbyid(id);
                new CustomerInformationcontroller(ln.people.getFname(), ln.people.getsname(), ln.people.getpassport(), ln.people.getId(), ln.people.getPriority());
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(view, "No such Id was found");

            }

        } /**
         * Deleting people from the queue
         */
        else if (arg0.getActionCommand().equals("Deletefromqueue")) {
            // if the user does not enter anything, the field would be empty so an error message will show
            if (view.numberofpeople.getText().equals("")) {

                JOptionPane.showMessageDialog(view, "No number was entered", "error", JOptionPane.ERROR_MESSAGE);
                // only numbers allowed
            } else if (view.numberofpeople.getText().matches("\\d+")) {
                int num = view.getNumberofpeople();

                if (num <= dll.length()) {
                    dll.deleteN(num);
                    JOptionPane.showMessageDialog(view, "You have deleted the last " + " " + num + "people from the queue", "Congratulations", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(view, "The queue have not got this amount of people", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(view, "wrong input, only numbers allowed", "error", JOptionPane.ERROR_MESSAGE);

            }
        }else if (arg0.getActionCommand().equals("Loadtable")) {
        
            users loadtable= new users();
        }
        
        
        

    }

}
