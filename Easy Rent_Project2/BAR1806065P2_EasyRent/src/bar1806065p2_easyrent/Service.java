/* Hi teatcher , I hope you'r alawys happy >> Here The solving of assignment2 in Java language . 
The Date of Sending :  Sunday, 2-03-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p2_easyrent;

//Service Class
public class Service {

    private String servicetype;
    private double serviceprice;

    public Service(String type, double price) {
        this.servicetype = type;
        this.serviceprice = price;
    }

    public String gettype() {
        return servicetype;
    }

    public void setServicetype(String type) {
        this.servicetype = type;
    }

    public double getprice() {
        return serviceprice;
    }

    public void setprice(double price) {
        this.serviceprice = price;
    }

    @Override
    public String toString() {
        return "Service Data : \n Service Type : " + servicetype + "\n Service Price :" + serviceprice;
    }
    
}
