/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validations;

import javax.swing.JOptionPane;

/**
 *
 * @author garce
 */
public class validations {

    /**
     * This method validates the sign up form
     *
     * @param name
     * @param secondname
     * @param date
     * @param passport
     * @return
     */
    public Boolean validatesignupform(String name, String secondname, String date, String passport) {
        boolean details = false;

        boolean fname = validatenames(name);
        boolean sname = validatenames(secondname);
        boolean arrivaldate = validatedateofarrival(date);
        boolean validpasssport = validatepassport(passport);

        if (fname == true && sname == true && arrivaldate == true && validpasssport == true) {
            details = true;
            return details;

        } else if (fname == false || sname == false || arrivaldate == false || validpasssport == false) {
            details = false;
            if (fname == false) {
                JOptionPane.showMessageDialog(null, "Invalid first name please try again", "Error", JOptionPane.ERROR_MESSAGE);

            } else if (sname == false) {
                JOptionPane.showMessageDialog(null, "Invalid second name please try again", "Error", JOptionPane.ERROR_MESSAGE);

            } else if (arrivaldate == false) {
                JOptionPane.showMessageDialog(null, "Invalid date please try again", "Error", JOptionPane.ERROR_MESSAGE);

            } else if (validpasssport == false) {
                JOptionPane.showMessageDialog(null, "Invalid passport please try again", "Error", JOptionPane.ERROR_MESSAGE);

            }
            return details;
        }

        return details;
    }

    public boolean validateupdate(String newname, String newsecondname, String newpassport) {

        boolean details = false;

        boolean fname = validatenames(newname);
        boolean sname = validatenames(newsecondname);

        boolean validpasssport = validatepassport(newpassport);

        if (fname == true && sname == true && validpasssport == true) {
            details = true;
            return details;

        } else if (fname == false || sname == false || validpasssport == false) {
            details = false;
            if (fname == false) {
                JOptionPane.showMessageDialog(null, "Invalid first name please try again", "Error", JOptionPane.ERROR_MESSAGE);

            } else if (sname == false) {
                JOptionPane.showMessageDialog(null, "Invalid second name please try again", "Error", JOptionPane.ERROR_MESSAGE);

            } else if (validpasssport == false) {
                JOptionPane.showMessageDialog(null, "Invalid passport please try again", "Error", JOptionPane.ERROR_MESSAGE);

            }
            return details;
        }

        return details;

    }

// validating the passports
    public static boolean validatepassport(String inputpassport) {
        inputpassport = inputpassport.trim();
        return inputpassport.matches("^(?!^0+$)[a-zA-Z0-9]{3,20}$");
    }
// this will be used to validate the name and the second name 

    public static boolean validatenames(String name) {
        name = name.trim();
        return name.matches("[a-zA-Z ,]+");// this is mostly used for names and surnames
    }
// validating the date of arrival

    public static boolean validatedateofarrival(String date) {
        date = date.trim();

        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

}
