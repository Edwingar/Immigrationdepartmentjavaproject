/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Controller.Immigrationviewcontroller;
import static Controller.Immigrationviewcontroller.dll;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author garce
 */
public class Database {

    /**
     * details of the connection such as user, pass, paths
     */
    private static Connection con;
    public Statement stmt;
    public ResultSet rs;
    public static final String driver = "com.mysql.cj.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "";
    public static final String url = "jdbc:mysql://localhost:3306/idepartment";

    public Database() {
        con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            if (con != null) {
                System.out.println("conneted");
            }
        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("Connection failed" + e);
        }
    }

    public void load() {
        /**
         * Creating the first instance of the main screen
         */
        Immigrationviewcontroller ivc = new Immigrationviewcontroller();

        /**
         * loading all the information from the users
         */
        String loadusers = "SELECT * FROM PERSON";
        try {
            Statement tocheck = con.createStatement();
            ResultSet checkingresult = tocheck.executeQuery(loadusers);

            while (checkingresult.next()) {
                String name = checkingresult.getString("Name");
                String secondname = checkingresult.getString("Sname");
                String date = checkingresult.getString("DofArrival");
                String passport = checkingresult.getString("PassN");
                String ImmigId = checkingresult.getString("GeneralId");
                String priority = checkingresult.getString("Priority");

                dll.Fetcholduser(name, secondname, date, passport, priority, ImmigId);
                
            }

        } catch (SQLException ex) {

        }

    }

    /**
     * This method save information of people in the data base, it saves
     * everyone information
     *
     * @param name
     * @param secondname
     * @param passport
     * @param Dateofarrival
     * @param priority
     * @param ID
     */
    public void save(String name, String secondname, String passport, String Dateofarrival, String priority, String ID) {

        String sql;
        sql = "INSERT INTO person(Name,Sname,PassN,DofArrival,Priority,GeneralId) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, secondname);
            pre.setString(3, passport);
            pre.setString(4, Dateofarrival);
            pre.setString(5, priority);
            pre.setString(6, ID);

            int n = pre.executeUpdate();

            // it the executeUpdate statement goes true n==1 therefore > than 0
            if (n > 0) {

                System.out.println("saved");

            } else {

                System.out.println("no saved");
            }
        } catch (Exception ex) {
        }

    }

    /**
     * This method deletes a record from the table person in the data base
     *
     * @param id
     */
    public void drop(String id) {

        String sql = "Delete from person where GeneralId='" + id + "'";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException e) {

        }
    }

    public void update(String id, String firstname, String secondname, String passport) {

        String sql = "UPDATE person set Name='" + firstname + "', Sname='" + secondname + "', PassN='" + passport + "'  where GeneralId='" + id + "'";
        try {
            stmt = con.createStatement();
            int rs = stmt.executeUpdate(sql);

        } catch (SQLException ex) {
        }

    }

}
