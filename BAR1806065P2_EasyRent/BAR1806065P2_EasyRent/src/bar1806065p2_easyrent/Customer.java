/* Hi teatcher , I hope you'r alawys happy >> Here The solving of assignment2 in Java language . 
The Date of Sending :  Sunday, 2-03-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p2_easyrent;
//Customer Class

public class Customer {

    private String First_name;
    private String Last_name;
    private String email;
    private long Credit_Card;
    private int discount_code;

    public Customer(String firstname, String lastname, String email, long card, int code) {
        this.First_name = firstname;
        this.Last_name = lastname;
        this.email = email;
        this.Credit_Card = card;
        this.discount_code = code;
    }

    public String getFirstName() {
        return First_name;
    }

    public void setFirstName(String firstname) {
        this.First_name = firstname;
    }

    public String getLastName() {
        return Last_name;
    }

    public void setLastName(String lastname) {
        this.Last_name = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCreditCard() {
        return Credit_Card;
    }

    public void setCreditCard(long card) {
        this.Credit_Card = card;
    }

    public int getClientCode() {
        return discount_code;
    }

    public double getDiscountRate() {
        String discount = String.valueOf(discount_code);
        if (discount.charAt(0) == '0' || discount.charAt(0) == '1' || discount.charAt(0) == '2' || discount.charAt(0) == '3') {
            return 0.1;
        } else if (discount.charAt(0) == '4' || discount.charAt(0) == '5' || discount.charAt(0) == '6') {
            return 0.15;
        } else if (discount.charAt(0) == '7' || discount.charAt(0) == '8' || discount.charAt(0) == '9') {
            return 0.2;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Customer{" + "First_name=" + First_name + ", Last_name=" + Last_name
                + ", email=" + email + ", Credit_Card=" + Credit_Card + ", discount_code=" + discount_code + '}';
    }
}
