/* Hi teatcher , I hope you'r alawys happy >> Here The solving of Assignment5 in Java language . 
The Date of Sending :  Sunday, 7-04-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar_1806065_p5_bookbanksystem;
//Tapes Class
//DON'T MAKE ANY CHANGE IN THIS FILE.
public class Tapes extends Materials {

    private int year;

    // Book full-arg constructor
    Tapes(String title, int year) {
        this.title = title;
        this.year = year;
    }

    private int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        available = false;
    }

    public String toString() {
        return " Title: " + getTitle() + " Year: " + getYear();
    }

}
