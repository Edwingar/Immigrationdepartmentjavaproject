/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dll;

import Interfaces.actions;
import static Controller.Immigrationviewcontroller.dll;
import static dll.DLL.db;
import dll.people.Highpriority;
import dll.people.Lowpriority;
import dll.people.Mediumpriority;
import dll.people.person;

import javax.swing.JOptionPane;

/**
 *
 * @author garce
 */
public class DoublyLinkedList implements actions {

    private ListNode Head;
    private ListNode Tail;
    private int length;
    // number of high priority already registered
    private static int numofpriority = 0;
    // this 2d array stores the users to be displayed in the table
   
    public  static String[][] users =new String[30][6];

    public DoublyLinkedList() {
        this.Head = null;
        this.Tail = null;
        this.length = 0;

    }

    /**
     *
     * @return a boolean to say it's empty or no
     */
    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int length() {
        return this.length;
    }

    /**
     * deleting first item from the doubly linked list
     *
     * @return
     */
    @Override
    public ListNode deletefirst() {

        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "Empty queue");
        }

        ListNode temp = Head;
        if (Head == Tail) {
            Tail = null;
        } else {
            Head.next.Previous = null;
        }

        Head = Head.next;
        db.drop(temp.people.getId());
        temp.next = null;
        length--;

        return temp;
    }

    public ListNode deleteany(int position) {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "Empty queue");
        }
        ListNode temp = Head;

        for (int i = 0; i < position; i++) {
            if (i == position - 1) {
                if (temp.next != null && temp.Previous != null) {
                    temp.Previous.next = temp.next;
                    temp.next.Previous = temp.Previous;
                    //deleting the record from the data base
                    db.drop(temp.people.getId());
                    temp = null;
                    length--;
                } else if (temp.next == null) {
                    deletelast();

                } else if (temp.Previous == null && temp.next != null) {
                    deletefirst();

                } else if (temp.Previous == null && temp.next == null) {
                    Head = null;
                    Tail = null;
                    length--;
                }

            } else {
                temp = temp.next;
            }
        }

        return temp;
    }

    /**
     * Delete last node from the Doubly Linked list
     *
     * @return
     */
    @Override
    public ListNode deletelast() {

        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "Empty queue");
        }

        ListNode temp = Tail;
        if (Head == Tail) {
            Head = null;
        } else {
            Tail.Previous.next = null;
        }

        Tail = Tail.Previous;
        //deleting the record from the data base
        db.drop(temp.people.getId());
        temp.Previous = null;
        length--;

        return temp;
    }

    /**
     * this method takes a determin number of people and delete them from the
     * back of the doubly linked list
     *
     * @param n
     */
    @Override
    public void deleteN(int n) {

        for (int i = 0; i < n; i++) {
            deletelast();
        }
    }

    /**
     * This method will add a node to the start, middle or the last position of
     * the Doubly linked list, depending on their priority
     *
     * @param newperson
     */
    @Override
    public void saveuser(person newperson) {
        ListNode newn = new ListNode(newperson);
        ListNode current;
        current = Head;

        if (isEmpty()) {
            addtobeginning(newperson);
        } else if (newn.people.getClass().toString().equals("class dll.people.Highpriority")) {

            if (current.people.getClass().toString().equals("class dll.people.Highpriority")) {
                while (current.next.people.getClass().toString().equals("class dll.people.Highpriority")) {
                    System.out.println(current.people.getClass() + current.people.getFname());

                    current = current.next;
                }
                if (current.next.people.getClass().toString().equals("class dll.people.Lowpriority") || current.next.people.getClass().toString().equals("class dll.people.Mediumpriority")) {
                    newn.next = current.next;
                    newn.Previous = current;
                    current.next = newn;
                    newn.next.Previous = newn;

                    numofpriority = numofpriority + 1;
                }
            } else {
                addtobeginning(newperson);
            }

        } else if (newn.people.getClass().toString().equals("class dll.people.Mediumpriority")) {

            if (numofpriority > 0) {

                for (int i = 0; i < numofpriority; i++) {

                    current = current.next;
                }

                if (current.next.people.getClass().toString().equals("class dll.people.Lowpriority") || current.next == null) {

                    lowornull(current, newn, newperson);

                } else if (current.next.people.getClass().toString().equals("class dll.people.Mediumpriority")) {

                    while (current.next.people.getClass().toString().equals("class dll.people.Mediumpriority")) {

                        current = current.next;
                    }

                    if (current.next.people.getClass().toString().equals("class dll.people.Lowpriority") || current.next == null) {

                        lowornull(current, newn, newperson);

                    }

                }

            } else {

                if (current.people.getClass().toString().equals("class dll.people.Mediumpriority")) {

                    while (current.next.people.getClass().toString().equals("class dll.people.Mediumpriority")) {
                        System.out.println(current.people.getClass() + current.people.getFname());

                        current = current.next;
                    }
                    if (current.next.people.getClass().toString().equals("class dll.people.Lowpriority") || current.next == null) {

                        lowornull(current, newn, newperson);

                    }

                } else {
                    addtobeginning(newperson);
                }
            }

        } else {
            addtotheend(newperson);
        }

        length++;
        
    }

    /**
     * this method adds a node to the beginning of the doublyLinkedList, it
     * takes a paramether of a person class
     *
     * @param newperson
     */
    @Override
    public void addtobeginning(person newperson) {

        ListNode newn = new ListNode(newperson);

        if (isEmpty()) {
            Tail = newn;
        } else {
            Head.Previous = newn;
        }
        newn.next = Head;
        Head = newn;
        length++;

    }

    // this method adds a node to the end of the doublyLinkedList
    @Override
    public void addtotheend(person newperson) {

        ListNode newn = new ListNode(newperson);
        if (isEmpty()) {
            Head = newn;
        } else {
            Tail.next = newn;
            newn.Previous = Tail;
        }
        Tail = newn;
        length++;

    }

    /**
     * this method will print the doubly linked list from the first to the last
     * node
     *
     * @param Passport
     * @return
     */
    @Override
    public String FetchId(String Passport) {
        if (Head == null) {
            return null;

        }

        ListNode temp = Head;

        while (temp != null) {
            if (temp.people.getpassport().equals(Passport)) {
                return temp.people.getId();
            }
            temp = temp.next;

        }
        return null;
    }

    /**
     * this method will return a ListNode object by previously providing a Id,
     * if it finds it i will return a value, if no it will just be null
     *
     * @param id
     * @return
     */
    @Override
    public ListNode searchforpersonbyid(String id) {

        id = id.trim();

        ListNode current;

        current = Head;

        for (int i = 0; i < length(); i++) {
            if (current.people.getId().equals(id)) {
                current.people.setPriority(i + 1);
                return current;

            } else {
                current = current.next;
            }

        }
        // a null result is returned is the user does not exist
        return null;
    }

    /**
     * this method is called when working with the medium priority or category
     * and next node is low or null
     *
     * @param current
     * @param newn
     * @param newperson
     */
    public void lowornull(ListNode current, ListNode newn, person newperson) {
        if (current.next.people.getClass().toString().equals("class dll.people.Lowpriority")) {

            newn.next = current.next;
            newn.Previous = current;
            current.next = newn;
            newn.next.Previous = newn;

        } else if (current.next == null) {
            addtotheend(newperson);

        }

    }

    @Override
    public void Fetcholduser(String name, String secondname, String date, String passport, String priority, String ID) {

        if (priority.equals("Low")) {

            dll.saveuser(new Lowpriority(name, secondname, date, passport, 0, ID));
        } else if (priority.equals("Medium")) {

            dll.saveuser(new Mediumpriority(name, secondname, date, passport, 0, ID));

        } else if (priority.equals("High")) {
            dll.saveuser(new Highpriority(name, secondname, date, passport, 0, ID));

        }
    }

    // this is to be able to access the first person on the linked list
    public ListNode getHead() {
        return Head;
    }

    public String[][] getUsers() {
        return users;
    }

    
    /**
     * This method gets a table load with all the people on the queue
     */
    public void load() {

        ListNode temp = Head;

        int num = 1;
        
      
        while (temp != null) {
            
            users[num][0]=Integer.toString(num);
            users[num][1] = temp.people.getFname();
            users[num][2] = temp.people.getsname();
            users[num][3] =temp.people.getpassport();
            users[num][4] =temp.people.getId();
            users[num][5] =temp.people.getClass().getName().replace("dll.people.", "");

            temp = temp.next;

            num++;
            
        }

    }
}
