/* Hi teatcher , I hope you'r alawys happy >> Here The solving of Assignment4 in Java language . 
The Date of Sending :  Sunday, 1-04-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p4_buytickets;
/////////////////////////////////
//Event Class 

import java.util.Date;
import java.text.*; //import to write the date in specific format .

public abstract class Event implements Comparable<Event> {

    private String Name;
    private Date SDate;
    private Date EDate;
    private double price;
    private String City;
    private String Address;
    private String TargetedAudience;
    private int AvailableTickets;

    public Event(String Name, Date SDate, Date EDate, double price, String City, String Address, String TargetedAudience, int AvailableTickets) {
        this.Name = Name;
        this.SDate = SDate;
        this.EDate = EDate;
        this.price = price;
        this.City = City;
        this.Address = Address;
        this.TargetedAudience = TargetedAudience;
        this.AvailableTickets = AvailableTickets;
    }

    public String getName() {
        return Name;
    }

    public Date getSDate() {
        return SDate;
    }

    public Date getEDate() {
        return EDate;
    }

    public double getPrice() {
        return price;
    }

    public String getCity() {
        return City;
    }

    public String getAddress() {
        return Address;
    }

    public String getTargetedAudience() {
        return TargetedAudience;
    }

    public int getAvailableTickets() {
        return AvailableTickets;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setSDate(Date SDate) {
        this.SDate = SDate;
    }

    public void setEDate(Date EDate) {
        this.EDate = EDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setTargetedAudience(String TargetedAudience) {
        this.TargetedAudience = TargetedAudience;
    }

    public void setAvailableTickets(int AvailableTickets) {
        this.AvailableTickets = AvailableTickets;
    }

    @Override
    public String toString() {
        //creat obj of DateFormat 
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        String sDate = dateformat.format(SDate);
        String eDate = dateformat.format(EDate);
        return "Name:" + Name + ", Dates:" + sDate + "-" + eDate + ", City:" + City + ", Address:" + Address
                + ", Price:" + price + ", TargetedAudience:" + TargetedAudience + ", Tickets Available:"
                + AvailableTickets;
    }
}
