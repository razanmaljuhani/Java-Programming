/* Hi teatcher , I hope you'r alawys happy >> Here The solving of Assignment5 in Java language . 
The Date of Sending :  Sunday, 7-04-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar_1806065_p5_bookbanksystem;
//Book Class
//DON'T MAKE ANY CHANGE IN THIS FILE.

public class Book extends Materials {

    // Book private data fields
    private String isbn;
    private String author;
    private int version;
    private int year;
    private int noOfCopies;


    // Book full-arg constructor
    Book(String isbn, String title, String author, int version,int noOfCopies, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.version = version;
        this.noOfCopies = noOfCopies;
        this.year=year;
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public int getVersion() {
        return version;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }
	
    public void increaseNoOfCopies() {
        this.noOfCopies++;
    }

    public boolean isAvailable() {
        if (noOfCopies > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void borrow() { 
        noOfCopies--;
	if (noOfCopies > 0)
            available = true;
	else
            available = false;
    }
	
    public String toString() {
        return "Isbn: " + getIsbn() + " Title: " + getTitle() + "\r\n"+"Author: " + getAuthor() + " Version: " + getVersion() + " Number of available Copies: " + getNoOfCopies()+" Issue year: "+getYear();
    }
}


