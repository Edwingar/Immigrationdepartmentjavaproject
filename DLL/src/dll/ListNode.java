/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dll;

import dll.people.person;

/**
 *
 * @author garce
 */
public class ListNode {

    public person people=null;
    public ListNode next=null;
    public ListNode Previous=null;

    public ListNode(person p) {
        this.people = p;
    }

}
