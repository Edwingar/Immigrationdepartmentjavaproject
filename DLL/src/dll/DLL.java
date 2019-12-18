/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dll;

import Database.Database;

/**
 *
 * @author garce
 */
public class DLL {

    /**
     * @param args the command line arguments
     */
    public static Database db = new Database();

    public static void main(String[] args) {
        // TODO code application logic here

        new DLL();

    }

    public DLL() {

        db.load();

    }

}
