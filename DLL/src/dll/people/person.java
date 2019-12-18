/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dll.people;

/**
 *
 * @author garce
 */
public class person {

    private String fname;
    private String sname;
    private String DofArrival;
    private String passport;
    private int prioritynumber;
    private String Id;

    // constructor to create a new person  to be added to the queue
    public person(String Firstname, String Secondname, String ArrivalDate, String PassportN, int Priorityn, String id) {

        this.setFname(Firstname);
        this.setSname(Secondname);
        this.setDofarrival(ArrivalDate);
        this.setPassport(PassportN);
        this.setPriority(Priorityn);
        this.setId(id);

        // i need to make it unique
    }

    //setters
    public void setFname(String Fname) {
        this.fname = Fname;
    }

    public void setSname(String Sname) {
        this.sname = Sname;
    }

    public void setDofarrival(String Dofarrival) {
        this.DofArrival = Dofarrival;
    }

    public void setPassport(String Passport) {
        this.passport = Passport;
    }

    public void setPriority(int priority) {
        this.prioritynumber = priority;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    //getters
    public String getFname() {
        return this.fname;
    }

    public String getsname() {
        return this.sname;
    }

    public String getdofarrival() {
        return this.DofArrival;
    }

    public String getpassport() {
        return this.passport;
    }

    public int getPriority() {
        return this.prioritynumber;
    }

    public String getId() {
        return Id;
    }

}
