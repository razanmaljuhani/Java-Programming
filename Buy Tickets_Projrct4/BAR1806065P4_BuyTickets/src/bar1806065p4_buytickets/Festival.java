/* Hi teatcher , I hope you'r alawys happy >> Here The solving of Assignment4 in Java language . 
The Date of Sending :  Sunday, 1-04-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p4_buytickets;
//Festival Class
/////////////////////////////////////////////////////////////////////////////

import java.util.Date;
import java.util.Arrays;

public class Festival extends Event {

    private String[] FoodVenues;
    private String[] Activity;

    public Festival(String Name, Date SDate, Date EDate, double price, String City, String Address,
            String TargetedAudience, int AvailableTickets, String[] FoodVenues, String[] KidsActivity) {
        //The super constructor from Evant class (super class of Festival)
        super(Name, SDate, EDate, price, City, Address, TargetedAudience, AvailableTickets);
        this.FoodVenues = FoodVenues;
        this.Activity = KidsActivity;
    }

    public String[] getFoodVenues() {
        return FoodVenues;
    }

    public String[] getActivity() {
        return Activity;
    }

    public void setFoodVenues(String[] FoodVenues) {
        this.FoodVenues = FoodVenues;
    }

    public void setActivity(String[] KidsActivity) {
        this.Activity = KidsActivity;
    }

    @Override
    public String toString() {
        return "AddingFestival{" + super.toString() + ",\r\nFoodVenues:" + Arrays.toString(FoodVenues)
                + ", Activities:" + Arrays.toString(Activity) + "} was successfully completed ";
    }

    @Override
    //Method in Comparable interface , that implements by Event class
    //this method arrange the Festival in ascending order . 
    public int compareTo(Event o) {
        //just Override compareTo in date class   .
        return this.getSDate().compareTo(o.getSDate());
    }
}
