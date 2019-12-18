/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.Immigrationviewcontroller;
import dll.DoublyLinkedList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 *
 * @author garce
 */
public class Immigrationview extends JFrame {

    // We need a reference to the controller
    private Immigrationviewcontroller controller;

    // Remember that the text fields need to be
    // global so other methods can see them
    private JTextField PersonuniqueId;
    public static JTextField numberofpeople;

    private JTextField firstname;
    private JTextField secondname;
    private JTextField arrival;
    private JTextField passportnumber;
    private JComboBox Categories;

    DoublyLinkedList dll = new DoublyLinkedList();

    int x, y;

    /*
	 * The constructor needs to have get a the
	 * controller from outside
     */
    public Immigrationview(Immigrationviewcontroller controllerFromOutside) {

        // Setting the controller into the 
        // internal reference
        this.controller = controllerFromOutside;

        // Calling methods to set the whole windows
        this.settings();
        this.painting();

    }

    /*
	 * Settings
     */
    private void settings() {
        this.setVisible(true);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        x = (int) (dimension.getWidth());
        x = x / 100;
        x = x * 90;
        y = (int) (dimension.getHeight());
        y = y / 100;
        y = y * 90;
        this.setSize(x, y);
        centreWindow(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

    }

    /*
	 * All the different elements of the frame
     */
    private void painting() {

        JLabel registlables[] = new JLabel[5];
        JTextField regist[] = new JTextField[4];
        JTextField jtextfields[] = new JTextField[2];
        JLabel loginlables[] = new JLabel[2];

        // the following 3 lines is to make the frame 90% the size of the screen
        JPanel panelcentre = new JPanel();
        JPanel paneltop = new JPanel();
        JPanel panelleft = new JPanel();
        JPanel panelright = new JPanel();
        JPanel RegisterPanel = new JPanel();
        JPanel searchpanel = new JPanel();
        JPanel deletepeoplepanel = new JPanel();

        paneltop.setBackground(Color.CYAN);
        panelcentre.setBackground(Color.white);

        RegisterPanel.setLayout(new GridLayout(0, 2, 5, 5));
        searchpanel.setLayout(new GridLayout(0, 2));
        deletepeoplepanel.setLayout(new GridLayout(0, 2));

        paneltop.setPreferredSize(new Dimension(x, 100));
        panelleft.setPreferredSize(new Dimension(450, y));
        panelcentre.setPreferredSize(new Dimension(600, y));
        panelright.setPreferredSize(new Dimension(600, y));

        JLabel image = new JLabel();
        image.setBounds(10, 50, 200, 200);
        /**
         * the path for the image must be change for it to properly work
         */
        ImageIcon img = new ImageIcon("C:\\Users\\garce\\OneDrive\\Documents\\NetBeansProjects\\DLL\\src\\view\\harp.jpg");
        Image I = img.getImage();
        Image newimage = I.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon im = new ImageIcon(newimage);
        image.setIcon(im);

        JLabel title = new JLabel("An roinn dli agus cirt agus comhionannais / Department of Justice an Equality");
        setitlesfonts(title, 30);

// REGISTRATION FORM
        JLabel Registertitle = new JLabel("Register with us");
        setitlesfonts(Registertitle, 30);

        JLabel name = new JLabel("Enter your name");
        registlables[0] = name;
        firstname = new JTextField("Edwin");
        regist[0] = firstname;
        JLabel secondn = new JLabel("Enter your  second name");
        registlables[1] = secondn;
        secondname = new JTextField("Garces");
        regist[1] = secondname;
        JLabel arrivaldate = new JLabel("Arrival Date");
        registlables[2] = arrivaldate;
        arrival = new JTextField("YYYY-MM-DD");
        regist[2] = arrival;
        JLabel passnumber = new JLabel("Passport Number");
        registlables[3] = passnumber;
        passportnumber = new JTextField(25);
        regist[3] = passportnumber;

        JLabel category = new JLabel("Category");
        registlables[4] = category;
        String[] categories = {"Low", "Medium", "High"};
        Categories = new JComboBox(categories);

        JButton register = new JButton("REGISTER");
        register.setActionCommand("signup");
        register.addActionListener(controller);

        customisetextfieldsandlabels(regist, registlables);

//        //view of the users
//        String[] headers = {"Position", "Name", "Surname", "Passport", "Code"};
//
//      JTable viewtable= new JTable(dll.getUsers(),headers);
//      JScrollPane jsp= new JScrollPane(viewtable);
//      dll.load();
//       
      
//viewtable.setPreferredScrollableViewportSize(new Dimension(600,300));
        
//SEARCH FOR CUSTOMERS FORM
        JLabel searchtitle = new JLabel("Search Person By ID Number");
        setitlesfonts(searchtitle, 30);

        JLabel PersonId = new JLabel("Id Number");
        loginlables[0] = PersonId;
        PersonuniqueId = new JTextField(25);
        jtextfields[0] = PersonuniqueId;

        JButton search = new JButton("Search");
        search.setActionCommand("searchperson");
        search.addActionListener(controller);

// Delete few at once from the queue
        JLabel Numberofpeople = new JLabel("Amount of people to delete from the queue");
        setitlesfonts(Numberofpeople, 30);

        JLabel number = new JLabel("Number of people");
        loginlables[1] = number;
        numberofpeople = new JTextField(25);
        jtextfields[1] = numberofpeople;

        JButton Deletenow = new JButton("Delete now");
        Deletenow.setActionCommand("Deletefromqueue");
        Deletenow.addActionListener(controller);
        customisetextfieldsandlabels(jtextfields, loginlables);

        /**
         * test
         */
        JButton loadcurrentqueue = new JButton("Load current queue");
        loadcurrentqueue.setActionCommand("Loadtable");
        loadcurrentqueue.addActionListener(controller);
        
        
        
        
        
        
        paneltop.add(image);
        paneltop.add(title);

        panelleft.setBackground(Color.white);
        panelleft.add(image);

        panelcentre.add(Registertitle);
        RegisterPanel.add(name);

        RegisterPanel.add(firstname);
        RegisterPanel.add(secondn);
        RegisterPanel.add(secondname);
        RegisterPanel.add(arrivaldate);
        RegisterPanel.add(arrival);
        RegisterPanel.add(passnumber);
        RegisterPanel.add(passportnumber);
        RegisterPanel.add(category);
        RegisterPanel.add(Categories);

        panelcentre.add(RegisterPanel);
        panelcentre.add(register);
        
  
        searchpanel.add(PersonId);
        searchpanel.add(PersonuniqueId);

        deletepeoplepanel.add(number);
        deletepeoplepanel.add(numberofpeople);

        /**
         * adding the panel to search for people
         */
        panelright.add(searchtitle);
        panelright.add(searchpanel);
        panelright.add(search);
        /**
         * adding the panel to delete people from the back of the queue
         */
        panelright.add(Numberofpeople);
        panelright.add(deletepeoplepanel);
        panelright.add(Deletenow);
        panelright.add(loadcurrentqueue);
        

        /**
         * adding all the paneles to the frame
         */
        this.add(panelcentre, BorderLayout.CENTER);
        this.add(paneltop, BorderLayout.NORTH);
        this.add(panelright, BorderLayout.EAST);
        this.add(panelleft, BorderLayout.WEST);

        this.validate();
        this.repaint();
    }

    // Because my text fields are private,
    // we need to provide a way to get the 
    // data from them
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

    }

//this method is to add a background image to the frame 
    public static void addbackground(Window frame, int x, int y, String link) {

        JLabel background;
        ImageIcon img = new ImageIcon(link);
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, x, y);
        frame.add(background);

    }

    public static void setitlesfonts(JLabel label, int size) {
        Font f = new Font("Arial", Font.PLAIN, size);
        label.setFont(f);
    }

    public void customisetextfieldsandlabels(JTextField array[], JLabel array1[]) {

        for (int jtf = 0; jtf < array.length; jtf++) {

            array[jtf].setBorder(new MatteBorder(0, 0, 1, 0, Color.black));

        }

        for (int JL = 0; JL < array1.length; JL++) {
            setitlesfonts(array1[JL], 20);

        }

    }

    public String getname() {

        return this.firstname.getText();
    }

    public String getsecondname() {

        return this.secondname.getText();
    }

    public String getDate() {
        return this.arrival.getText();
    }

    public String getpassport() {
        return this.passportnumber.getText();
    }

    public String getcategory() {
        return this.Categories.getSelectedItem().toString();
    }

    public String getid() {
        return this.PersonuniqueId.getText();
    }

    public int getNumberofpeople() {
        return Integer.parseInt(numberofpeople.getText());

    }
}
