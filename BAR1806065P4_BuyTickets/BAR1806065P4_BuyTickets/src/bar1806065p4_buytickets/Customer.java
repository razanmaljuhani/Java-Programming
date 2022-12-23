/* Hi teatcher , I hope you'r alawys happy >> Here The solving of Assignment4 in Java language . 
The Date of Sending :  Sunday, 1-04-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p4_buytickets;
//Customer Class 
////////////////////////////////////////////////////////////////////

import java.util.Date;
import java.text.*;

public class Customer {

    private String CustomerID;
    private String name;
    private char Gender;
    private String email;
    private Date DateofBirth;

    public Customer(String CID, String name, char Gender, String email, Date DOB) {
        this.CustomerID = CID;
        this.name = name;
        this.Gender = Gender;
        this.email = email;
        this.DateofBirth = DOB;
    }

    public String getID() {
        return CustomerID;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public Date getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(Date DateofBirth) {
        this.DateofBirth = DateofBirth;
    }

    public void setID(String CID) {
        this.CustomerID = CID;
    }

    @Override
    public String toString() {
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        String dateBirth = dateformat.format(DateofBirth);
        return "AddingCustomer{" + "Customer Number:" + CustomerID + ", Name:" + name
                + ",Email: " + email + " , DateofBirth: " + dateBirth + " }  was successfully completed ";
    }
}
