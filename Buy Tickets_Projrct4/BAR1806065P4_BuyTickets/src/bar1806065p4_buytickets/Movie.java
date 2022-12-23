/* Hi teatcher , I hope you'r alawys happy >> Here The solving of Assignment4 in Java language . 
The Date of Sending :  Sunday, 1-04-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p4_buytickets;
//Movie Class
////////////////////////////////////////////////////////////////////

import java.util.Date;

public class Movie extends Event {

    private String Language;
    private double Rating;
    private String Genre;
    private Actor Actor;

    public Movie(String Name, Date SDate, Date EDate, double price, String City, String Address, String Language,
            String TargetedAudience, double Rating, int AvailableTickets, String Genre, Actor Actor) {
        //The super constructor from Evant class (super class of Movie)
        super(Name, SDate, EDate, price, City, Address, TargetedAudience, AvailableTickets);
        this.Language = Language;
        this.Rating = Rating;
        this.Genre = Genre;
        this.Actor = Actor;
    }

    public double getRating() {
        return Rating;
    }

    public String getGenre() {
        return Genre;
    }

    public Actor getActor() {
        return Actor;
    }

    public String getLanguage() {
        return Language;
    }

    public void setRating(double Rating) {
        this.Rating = Rating;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public void setActor(Actor Actor) {
        this.Actor = Actor;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    @Override
    public String toString() {

        return "Adding Movie{ " + super.toString() + ", Rating:" + Rating + ","
                + "\r\nLanguage:" + Language + ", Genre:" + Genre + ", Actor:" + Actor.getName() + " } was successfully completed ";
    }

    @Override
    //Method in Comparable interface , that implements by Event class
    //this method arrange the movies in decinding order .
    public int compareTo(Event o) {
        int orderR;
        //its important > Casting by movie to convert from Event to Movie
        if (Rating > (((Movie) o).Rating)) {
            orderR = -1;
        } else if (Rating == (((Movie) o).Rating)) {
            orderR = 0;
        } else {
            orderR = 1;
        }
        return orderR;
    }
}
