/* Hi teatcher , I hope you'r alawys happy >> Here The solving of Assignment4 in Java language . 
The Date of Sending :  Sunday, 1-04-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p4_buytickets;
//////////////////////////////////////////////
//Actor Class

public class Actor {

    private String Name;
    private char Gender;
    private int Birthyear;

    public Actor(String Name, char Gender, int Birthyear) {
        this.Name = Name;
        this.Gender = Gender;
        this.Birthyear = Birthyear;
    }

    public String getName() {
        return Name;
    }

    public char getGender() {
        return Gender;
    }

    public int getBirthyear() {
        return Birthyear;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public void setBirthyear(int Birthyear) {
        this.Birthyear = Birthyear;
    }

    @Override
    public String toString() {
        return "Actor{" + "Name=" + Name + ", Gender=" + Gender + ", Birthyear=" + Birthyear + '}';
    }

}
