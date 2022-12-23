/* Hi teatcher , I hope you'r alawys happy >> Here The solving of Assignment4 in Java language . 
The Date of Sending :  Sunday, 1-04-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p4_buytickets;

//Concert Class 
/////////////////////////////////////////////////////////////
import java.util.Date;

public class Concert extends Event {

    private String performers;

    public Concert(String Name, Date SDate, Date EDate, String City, String Address, double price,
            int AvailableTickets, String TargetedAudience, String performers) {
        //The super constructor from Evant class (super class of Concert)
        super(Name, SDate, EDate, price, City, Address, TargetedAudience, AvailableTickets);
        this.performers = performers;

    }

    public String getPerformers() {
        return performers;
    }

    public void setPerformers(String performers) {
        this.performers = performers;
    }

    @Override
    public String toString() {
        return "AddingConcert{" + super.toString() + ",\r\nPerformers:" + performers + "} was successfully completed ";

    }

    @Override
    //Method in Comparable interface , that implements by Event class
    //this method arrange performers . 
    public int compareTo(Event o) {
        return this.performers.compareTo(((Concert) o).performers);
    }
}
