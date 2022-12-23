/* Hi teatcher , I hope you'r alawys happy >> Here The solving of assignment2 in Java language . 
The Date of Sending :  Sunday, 2-03-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p2_easyrent;

//because I want to use Date Class >
import java.util.*;

public class Reservation {

    private String Reservation_code;
    private String pick_up_location;
    private String drop_of_location;
    private Date Pick_up;
    private Date Drop_of;
    private Date Date_of_reservation;
    private Customer customer;
    private Car car;
    private Service additional_service;

    public Reservation(String pickup, String dropof, Date Dpickup, Date Ddropof, Customer customer, Car car) {
        this.pick_up_location = pickup;
        this.drop_of_location = dropof;
        this.Pick_up = Dpickup;
        this.Drop_of = Ddropof;
        this.customer = customer;
        this.car = car;

    }

    public void SetReservationnCode(String code) {
        this.Reservation_code = code;
    }

    public String GetReservationCode() {
        char c1 = customer.getFirstName().charAt(0);
        char c2 = customer.getFirstName().charAt(0);
        Random r = new Random();
        return c1 + "" + c2 + "_" + r.nextInt(1000) + "_" + this.getCar().GetYearOfConstruction();
    }

    public void addservice(Service currentService) {
        this.additional_service = currentService;
    }

    public Service getservice() {
        return additional_service;
    }

    public void SetPickUp(String pickup) {
        this.pick_up_location = pickup;
    }

    public String GetPickUp() {
        return pick_up_location;
    }

    public void SetDropof(String dropof) {
        this.drop_of_location = dropof;
    }

    public String GetDropof() {
        return drop_of_location;
    }

    public void setPickup(Date Pick_up) {
        this.Pick_up = Pick_up;
    }

    public Date getPick_up() {
        return Pick_up;
    }

    public void setDropof(Date Drop_of) {
        this.Drop_of = Drop_of;
    }

    public Date getDrop_of() {
        return Drop_of;
    }

    public Date getDateofreservation() {
        return Date_of_reservation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCar(Car anther) {
        this.car = anther;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Reservation{" + "Reservation_code=" + Reservation_code + ", pick_up_location=" + pick_up_location
                + ", drop_of_location=" + drop_of_location + ", Pick_up=" + Pick_up + ", Drop_of=" + Drop_of
                + ", Date_of_reservation=" + Date_of_reservation
                + ", customer=" + customer + ", car=" + car + ", Service=" + additional_service + '}';
    }

}
