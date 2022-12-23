/* Hi teatcher , I hope you'r alawys happy >> Here The solving of Assignment5 in Java language . 
The Date of Sending :  Sunday, 7-04-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar_1806065_p5_bookbanksystem;
//Article Class
//DON'T MAKE ANY CHANGE IN THIS FILE.

public class Article extends Materials {

    private String author;
    private int volume;
    private String journalName;
    private String pages;

    // Book full-arg constructor
    Article(String title, String author, int volume, String pages, String journalName) {
        this.title = title;
        this.author = author;
        this.volume = volume;
        this.pages = pages;
        this.journalName = journalName;
    }

    // Getters
    public String getAuthor() {
        return author;
    }

    public int getVolume() {
        return volume;
    }

    public String getJournalName() {
        return journalName;
    }

    public String getPages() {
        return pages;
    }

    public boolean isAvailable(){
        return available;
    }
    
    public void borrow() { 
        available = false;
    }

    public String toString() {
        return "Title: " + getTitle() + "\r\nAuthor: " + getAuthor() + " Journal Name: " + getJournalName() + "\r\nPages: " + getPages() + " Volume " + getVolume();
    }

}
