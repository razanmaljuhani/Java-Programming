/* Hi teatcher , I hope you'r alawys happy >> Here The solving of assignment2 in Java language . 
The Date of Sending :  Sunday, 2-03-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p2_easyrent;
//Car Class

public class Car {

    private String Brand;
    private String CarType;
    private int Year_of_construction;
    private double Car_rate;
    private boolean Transmission_Manual;
    private boolean Convertible;

    public Car(String type,String brand, int year, double rate, boolean Transmission,  boolean convertible) {
        this.Brand = brand;
        this.Year_of_construction = year;
        this.Car_rate = rate;
        this.Transmission_Manual = Transmission;
        this.CarType = type;
        this.Convertible = convertible;
    }

    public void SetBrand(String brand) {
        this.Brand = brand;
    }

    public String GetBrand() {
        return Brand;
    }

    public void SetCarType(String type) {
        this.CarType = type;
    }

    public String GetCarType() {
        return CarType;
    }

    public void SetYearOfConstruction(int year) {
        this.Year_of_construction = year;
    }

    public int GetYearOfConstruction() {
        return Year_of_construction;
    }

    public void SetCarrate(double rate) {
        this.Car_rate = rate;
    }

    public double GetCarrate() {
        return Car_rate;
    }

    public void SetTransmission(boolean Transmission) {
        this.Transmission_Manual = Transmission;
    }

    public boolean GetTransmission() {
        return Transmission_Manual;
    }

    public void SetConvertible(boolean Convertible) {
        this.Convertible = Convertible;
    }

    public boolean IsConvertible() {
        return Convertible;
    }

    @Override
    public String toString() {
        return "car{" + "Brand=" + Brand + ", CarType=" + CarType + ", Year_of_construction=" + Year_of_construction
                + ", Car_rate=" + Car_rate + ", Transmission_Manual=" + Transmission_Manual + ", Convertible=" + Convertible + '}';
    }

    public double CalculateFinalPrice() {
        if (CarType.equals("Luxury")) {
            Car_rate = Car_rate + Car_rate * 0.1;
        }
        return Car_rate;
    }

}
