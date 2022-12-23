/* Hi teatcher , I hope you'r alawys happy >> Here The solving of assignment2 in Java language . 
The Date of Sending :  Sunday, 2-03-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p2_easyrent;

import java.util.*;
import java.io.*;

public class BAR1806065P2_EasyRent {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        //Creat File1 (inputCar)
        File fileCar = new File("inputCar.txt");
        if (!fileCar.exists()) {
            System.out.println("***The inputCar file doesn't exists***");
            System.exit(0);
        }
        Scanner f1 = new Scanner(fileCar);
        PrintWriter CarsInfo = new PrintWriter("CarsInfo.txt");

        //creat File2 (ReservationInput)
        File ReservationFile = new File("ReservationInput.txt");
        if (!ReservationFile.exists()) {
            System.out.println("***The ReservationInput file doesn't exists***");
            System.exit(0);
        }
        Scanner f2 = new Scanner(ReservationFile);
        PrintWriter ReservationStatus = new PrintWriter("ReservationStatus.txt");

        //Creat Car And Service Arreies :
        Car[] car = new Car[f1.nextInt()];
        Service[] service = new Service[f1.nextInt()];

        //Loop For inputCar file 
        int counterCar = 0;
        int counterService = 0;
        String command1 = "";
        while (f1.hasNext()) {
            command1 = f1.next();
            if (command1.equals("AddCar")) {
                car[counterCar] = CarsInformation(f1);
                counterCar++;
            } else if (command1.equals("AddService")) {
                service[counterService] = ServiceInformation(f1);
                counterService++;
            } else if (command1.equals("Quit")) {
                break;
            }
        }
        //Creat Reservation Array
        Reservation[] reservation = new Reservation[f2.nextInt()];

        //Loop of ReservationInput file
        int counterReserve = 0;
        String command2 = "";
        while (f2.hasNext()) {
            command2 = f2.next();
            if (command2.equals("Quit")) {
                break;
            } else if (command2.equals("submit")) {
                continue;
            } else if (command2.equals("Reserve")) {
                reservation[counterReserve] = ReservationInfo(f2);
                counterReserve++;
            }
        }
        CarsInfo.println("--------------- Welcome to Car Renting  Data Base ---------------");
        CarsInfo.println("");
        CarsInfo.println("");
        print_CarInfo(car, CarsInfo);

        ReservationStatus.println("--------------- Welcome to Car Renting  Management System ---------------");
        ReservationStatus.println("");
        ReservationStatus.println("");
        ReservationStatus.println("--------------- Display All System Procedures ---------------");
        ReservationStatus.println("");
        ReservationStatus.println("");
        for (int j = 0; j < reservation.length; j++) {
            if (Search_Car(car, reservation[j])) {
                Search_Service(service, reservation[j]);
                Make_Reservation(reservation[j],ReservationStatus );
            } else {
                ReservationStatus.println("SORRY: The reservation is NOT completed ");
                ReservationStatus.println("There is no available Car  ");
            }
        }

        //close files 
        f1.close();
        f2.close();
        CarsInfo.close();
        ReservationStatus.close();

    }

    //method 1 : return info. from Car Class and reading from (inputCar) 
    public static Car CarsInformation(Scanner reading) {
        String brand = reading.next();
        int year = reading.nextInt();
        double rate = reading.nextDouble();
        boolean trans = reading.nextBoolean();
        String type = reading.next();
        boolean convert = reading.nextBoolean();
        String type1 = "";
//creat object and return it .
        Car info = new Car(brand,type1,year, rate, trans, convert);
        return info;
    }

    //method 2  return info. from Service class and reading from (inputCar)
    public static Service ServiceInformation(Scanner reading) {
        String type = reading.next();
        double price = reading.nextDouble();
        //creat object and return it .
        Service info = new Service(type, price);
        return info;
    }

    //method 3 return info. from Reservation Calss and  reading from (ReservationInput)
    public static Reservation ReservationInfo(Scanner reading) {

        //Car Info.
        //1-Transmission
        String brand = reading.next();
        String trans = reading.next();
        boolean isTrans = false;
        boolean isConvert = false;

        if (trans.equals("Manual")) {
            isTrans = true;
        } else if (trans.equals("Automatic")) {
            isTrans = false;
        }
        //2-Convertibility :
        String convert = reading.next();
        if (convert.equals("Convertible")) {
            isConvert = true;
        } else if (convert.equals("Non_Convertible")) {
            isConvert = false;
        }
        int Year_of_construction = 0;
        double Car_rate = 0.0;
        String type = "";
        Car infoCar = new Car("", brand, Year_of_construction, Car_rate, isTrans, isConvert);

        //Reservation Info.
        String pick_up_location = reading.next();
        String drop_of_location = reading.next();
        //Date1
        int firstYear = reading.nextInt();
        int firstMonth = reading.nextInt();
        int firstDay = reading.nextInt();
        Date theFirstDate = new Date(firstYear, firstMonth, firstDay);
        //Date2
        int secondYear = reading.nextInt();
        int secondMonth = reading.nextInt();
        int secondDay = reading.nextInt();
        Date theSecondDate = new Date(secondYear, secondMonth, secondDay);
        //Customer Info. 
        String First_name = reading.next();
        String Last_name = reading.next();
        String email = reading.next();
        long CreditCard = reading.nextLong();
        int CustomerCode = reading.nextInt();
        Customer infoCustomer = new Customer(First_name, Last_name, email, CreditCard, CustomerCode);
        //Service Info.
        String servicetype = reading.next();
        double servicePrice = 0.0;
        Service infoS = new Service(servicetype, servicePrice);
        Reservation infoR = new Reservation(pick_up_location, drop_of_location, theFirstDate, theSecondDate, infoCustomer, infoCar);
        infoR.addservice(infoS);
        return infoR;

    }

    //method 4 print in CarInfo
    public static void print_CarInfo(Car[] c, PrintWriter p) {
        String trans = "";
        String convert = "";

        for (int i = 0; i < c.length; i++) {
            //True >> Manual  ,, False >> Automatic
            if (c[i].GetTransmission()) {
                trans = "Manual";
            } else {
                trans = "Automatic";
            }
            //True >> Convertible ,, False >> Non_Convertible 
            if (c[i].IsConvertible()) {
                convert = "and Convertible";
            } else {
                convert = "";
            }
            p.println("The car Type: " + c[i].GetBrand() + "" + c[i].GetCarType() + ", Year: " + c[i].GetYearOfConstruction() + ", Transmission: " + trans + "" + convert);
            p.println("------------------------------------------------------");
            p.println("");
        }
    }

    //method 5 Search_Car 
    public static boolean Search_Car(Car[] c, Reservation reser) {
        for (int i = 0; i < c.length; i++) {
            if (c[i].GetCarType().equals(reser.getCar().GetCarType()) && (c[i].GetTransmission() == reser.getCar().GetTransmission()) && c[i].IsConvertible() == reser.getCar().IsConvertible()) {
                reser.setCar(c[i]);
                return true;
            }
        }
        return false;
    }

    //method 6 Search_Service 
    public static void Search_Service(Service[] s, Reservation reser) {
        for (int i = 0; i < s.length; i++) {
            if (s[i].gettype().equals(reser.getservice().gettype())) {
                reser.addservice(s[i]);
            }
        }
    }

    //method 7  
    public static void Make_Reservation(Reservation r, PrintWriter p) {
        p.print("");
        p.print("");
        String d1 = r.getPick_up().getDate() + "-" + r.getPick_up().getMonth() + "-" + r.getPick_up().getYear();
        String d2 = r.getDrop_of().getDate() + "-" + r.getDrop_of().getMonth() + "-" + r.getDrop_of().getYear();

        p.println("DONE: The reservation is completed");
        p.println("******Reservation Refrence number :" + r.GetReservationCode());
        p.println("******Customer information : Customer Name: " + r.getCustomer().getFirstName() + "" + r.getCustomer().getLastName() + "Email :" + r.getCustomer().getEmail() + "Code" + r.getCustomer().getClientCode());
        p.println("******Pick up location :" + r.GetPickUp() + "\t******Drop of location : " + r.GetDropof());
        p.println("******Pick up date :" + d1 + "\t******Drop of date : " + d2);
        String t1 = "", t2 = "";
        if (r.getCar().GetTransmission()) {
            t1 = "Manual";
        } else {
            t1 = "Automatic";
        }
        if (r.getCar().IsConvertible()) {
            t2 = " and Convertible";

        } else {
            t2 = "";
        }

        p.println("******Car information : The car Type: " + r.getCar().GetBrand() + "" + r.getCar().GetCarType() + " , Year : " + r.getCar().GetYearOfConstruction() + ", Transmission : " + t1 + "" + t2);
        p.println("******Additional services :" + r.getservice().gettype());
        p.println("--------------- Invoice Details ---------------");
        int n;
        n = r.GetDropof().getDate() - r.GetPickUp().getDate();
        p.println(" Number of reserved days:" + n);
        double price = n * r.getCar().CalculateFinalPrice();
        p.println(" Intial Total: " + price);
        double price2 = price + r.getservice().getprice();
        p.println("--------------- Additional Services Price ---------------");
        p.println(" Total After additional Services  : " + price2);
        double price3 = price2 - price2 * r.getCustomer().getDiscountRate();
        p.println("--------------- Final Payment after Discount ---------------");
        p.println(" Final Total  : " + price3);
        p.println("");

    }

}
