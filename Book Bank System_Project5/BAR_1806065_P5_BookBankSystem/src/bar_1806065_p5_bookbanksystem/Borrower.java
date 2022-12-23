/* Hi teatcher , I hope you'r alawys happy >> Here The solving of Assignment5 in Java language . 
The Date of Sending :  Sunday, 7-04-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar_1806065_p5_bookbanksystem;
// Change as per the description in the given specification file and comments

import java.util.ArrayList;
import java.util.Date;

public abstract class Borrower implements Payable {

    protected int ID;
    protected String name;
    protected char gender;
    protected int phone;
    protected int borrowDuration;
    protected int ActualBorrowDuration = 0;

    protected ArrayList<Materials> borrowedItems = new ArrayList<>();

    Borrower(int ID, String name, char gender, int phone, Materials material, int borrowDuration) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.borrowDuration = borrowDuration;
        this.borrowedItems.add(material);
    }

    public void setId(int id) {
        this.ID = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setBorrowDuration(int borrowDuration) {
        this.borrowDuration = borrowDuration;
    }

    public void setActualBorrowDuration(int ActualBorrowDuration) {
        this.ActualBorrowDuration = ActualBorrowDuration;
    }

    public int getId() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getPhone() {
        return phone;
    }

    public int getBorrowDuration() {
        return borrowDuration;
    }

    public String BorrowerInfo(String title) {
        return "Name: " + getName() + " with id " + getId() + " borrowed " + title + "\n";
    }

    public int getActualBorrowDuration() {
        return ActualBorrowDuration;
    }

}
//-----------------------------------------------------

class Student extends Borrower {

    private String major;

    Student(int ID, String name, char gender, int phone, String major, Materials material, int borrowDuration) {
        super(ID, name, gender, phone, material, borrowDuration);
        setMajor(major);

    }

    public void setMajor(String major) {
        this.major = major;
    }

    //TODO
    //  Override the getFees() method to get the fees
    public double getFees() {
        int m = this.ActualBorrowDuration - this.borrowDuration;

        return m * 5;
    }
}
    class Staff extends Borrower {

        private String job;

        Staff(int ID, String name, char gender, int phone, String job, Materials material, int borrowDuration) {
            super(ID, name, gender, phone, material, borrowDuration);
            setJob(job);

        }

        public void setJob(String job) {
            this.job = job;
        }

        //TODO
        //  Override the getFees() method to get the fees
        public double getFees() {
            int m = this.ActualBorrowDuration - this.borrowDuration;
            return m * 7;
        }
    }

