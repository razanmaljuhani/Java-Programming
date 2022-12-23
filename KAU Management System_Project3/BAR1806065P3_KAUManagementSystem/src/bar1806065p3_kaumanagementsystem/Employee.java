// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
//Employee Class
package bar1806065p3_kaumanagementsystem;

import java.util.*; 

//The first subClass from Person Class

public class Employee extends Person {

    private String jobTitle;
    private int officeNumber;
    private boolean onLeave;

    public Employee(String jobTitle, int officeNumber, boolean onLeave, int id, String name,
            String nationality, Date dateOfBirth, char gender, int phone, String address) {
        super(id, name, nationality, dateOfBirth, gender, phone, address);
        this.jobTitle = jobTitle;
        this.officeNumber = officeNumber;
        this.onLeave = onLeave;
    }

    public String getJobTitle() {

        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }

    public boolean isOnLeave() {
        return onLeave;
    }

    public void setOnLeave(boolean onLeave) {
        this.onLeave = onLeave;
    }

    @Override
    public String toString() {
        return super.toString() + ", Job Title : " + jobTitle + ", Office Number : " + officeNumber + ", On Leave : " + onLeave;
    }
}
