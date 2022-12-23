/* Hi teatcher , I hope you'r alawys happy >> Here The solving of Assignment4 in Java language . 
The Date of Sending :  Sunday, 1-04-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p4_buytickets;

//Booking.java
import java.util.*;
import java.text.*;

public class Booking {

    private String BookingID;
    private Customer Customer;
    private ArrayList<Event> Events;
    private double discount;
    private double finaltotalPrice;

    public Booking(String BookingID, Customer Customer, ArrayList<Event> Events) {
        this.BookingID = BookingID;
        this.Customer = Customer;
        this.Events = Events;
    }

    public ArrayList<Event> getEvents() {
        return Events;
    }

    public void setEvents(ArrayList<Event> Events) {
        this.Events = Events;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer Customer) {
        this.Customer = Customer;
    }

    public String getBookingID() {
        return BookingID;
    }

    public void setBookingID(String BookingID) {
        this.BookingID = BookingID;
    }

    //0000000000000**Method 1 : return the final price of all the items after applying discount .
    public double calculateFinalPrice() {
        double finalPrice = 0;
        for (int i = 0; i < this.Events.size(); i++) {
            finalPrice = finalPrice + this.getFinalPrice(Events.get(i));
        }
        return finalPrice;
    }

    //0000000000000**Method 2 :  return the total price of all the items before the discount .
    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < this.Events.size(); i++) {
            totalPrice = totalPrice + this.Events.get(i).getPrice();
        }
        return totalPrice;
    }

    //0000000000000**Method 3 : calculate the age of the customers and return the dicount amount for the customer in the booking object .
    public double getDiscount() {
        Date date = new Date();
        if (ageCal(date) <= 3) {
            //100% discount
            discount = 1 * 100;
        } else if (ageCal(date) <= 15) {
            //50% discount
            discount = 0.5 * 100;
        } else if (ageCal(date) > 15) {
            discount = 0 * 100;
        }
        return discount;
    }

    //00000000000000**Method 4 : calculate Age  .
    public int ageCal(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        int dateOfBirth = Integer.parseInt(dateFormat.format(this.Customer.getDateofBirth()));
        int dateNow = Integer.parseInt(dateFormat.format(date));
        int age = (dateNow - dateOfBirth) / 10000;
        return age;
    }

    //00000000000000000**Method 5 : takes an event and return the discount amount for thet spicific event .
    public double getDiscount(Event event) {
        double discountA;
        if (event instanceof Festival) {
            discountA = getDiscount();
        } else {
            discountA = 0.0;
        }
        return discountA;
    }

    //00000000000**Method 6 : takes an event and return the Final Price for thet spicific event after applying the discount .
    public double getFinalPrice(Event event) {
        //400 - (400*0.5) = 400 - 200 = 200
        double finalP = ((event.getPrice()) - (event.getPrice() * getDiscount(event)) / 100);
        return finalP;
    }

    //00000000000**Method 7 : return number of discounted events .
    public int getNumberOfDiscountEvents() {
        int numOfDiscounEvent = 0;
        for (int i = 0; i < this.Events.size(); i++) {
            if (this.getDiscount(Events.get(i)) > 0) {
                numOfDiscounEvent++;
            }
        }
        return numOfDiscounEvent;
    }

    //00000000000**Method 8 : return the total saving amount.
    public double getSavingAmount() {
        double totalSaving = 0;
        for (int i = 0; i < Events.size(); i++) {
            if (this.getDiscount(Events.get(i)) > 0) {
                totalSaving = totalSaving + (this.Events.get(i).getPrice() * this.getDiscount(Events.get(i)));
            }
        }
        return totalSaving;
    }
}
