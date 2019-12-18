/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import dll.ListNode;
import dll.people.person;

/**
 *
 * @author garce
 */
public interface actions {

    /**
     * this method checks if the linked list is full or empty
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * this method returnsthe length of the linked list
     *
     * @return
     */
    public int length();

    /**
     * this method returns a Id of the customer by providing a passport number
     *
     * @param passport
     * @return
     */
    public String FetchId(String passport);

    /**
     * this method deletes the first person in the doubly linked list
     *
     * @return
     */
    public ListNode deletefirst();

    /**
     * this person deletes the last person in the doubly linked list
     *
     * @return
     */
    public ListNode deletelast();

    /**
     * this method allow the user to delete any amount of customer from the back
     * of the queue
     *
     * @param n
     */
    public void deleteN(int n);

    /**
     * This method saves a user on to the linked list as well as the data base
     *
     * @param newperson
     */
    public void saveuser(person newperson);

    /**
     * this method add a node to the beggining of the linked list
     *
     * @param newperson
     */
    public void addtobeginning(person newperson);

    /**
     * his method add a node to the end of the linked list
     *
     * @param newperson
     */
    public void addtotheend(person newperson);

    /**
     * This method serahc for a person by providing an id
     *
     * @param id
     * @return
     */
    public ListNode searchforpersonbyid(String id);

    /**
     * This method takes an old user form the data base and loads it to the
     * linked list
     *
     * @param name
     * @param secondname
     * @param date
     * @param passport
     * @param priority
     * @param ID
     */
    public void Fetcholduser(String name, String secondname, String date, String passport, String priority, String ID);

}
