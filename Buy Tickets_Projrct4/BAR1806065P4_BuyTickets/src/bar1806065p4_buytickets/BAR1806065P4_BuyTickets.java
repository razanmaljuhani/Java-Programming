/* Hi teatcher , I hope you'r alawys happy >> Here The solving of Assignment4 in Java language . 
The Date of Sending :  Sunday, 1-04-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p4_buytickets;

import java.util.*;
import java.io.*;
import java.text.*; //format Date

public class BAR1806065P4_BuyTickets {

    public static void main(String args[]) throws Exception {
        File inputFile = new File("input.txt");
        //checking if the file exists :
        if (!(inputFile.exists())) {
            System.out.println("The File does not exists");
            System.exit(0);
        }
        Scanner fileScan = new Scanner(inputFile);
        PrintWriter output = new PrintWriter("output.txt");

        //Creation ArrayList
        ArrayList<Event> currentEventArr = new ArrayList<Event>();
        ArrayList<Customer> customerArr = new ArrayList<Customer>();
        // if find the customer then bookEvent using booking class
        ArrayList<Event> BookEventArr = new ArrayList<Event>();

        //declearation object of booking
        Booking bookObj;
        Random random = new Random();
        output.println("");
        output.println("########################################################################################################");
        output.println("############################# Welcome to Entertainment Booking System ##################################");
        output.println("########################################################################################################");
        output.println("");
        output.println("");

        String space = "";
        String temp;//to split spase 
        String[] reading;//to storing split  
        int customerID = 0;
        int ticket = 0;
        while (fileScan.hasNext()) {
            space = fileScan.nextLine();
            temp = space.replaceAll("[,--]", " ");
            reading = temp.split("  ");

            //Command : AddMovie 
            if (reading[0].equals("AddMovie")) {
                Movie movieObj = AddMovie(reading);
                output.println(movieObj.toString());
                currentEventArr.add(movieObj);

            } //Command: AddFestival
            else if (reading[0].equals("AddFestival")) {
                Festival festivalObj = AddFestival(reading);
                output.println(festivalObj.toString());
                currentEventArr.add(festivalObj);

            } //Command: AddConcert
            else if (reading[0].equals("AddConcert")) {
                Concert concertObj = AddConcert(reading);
                output.println(concertObj.toString());
                currentEventArr.add(concertObj);

            } //Command: AddCustomer
            else if (reading[0].equals("AddCustomer")) {
                customerID++;
                String CID = "";
                int lenghtID = Integer.toString(customerID).length();
                switch (lenghtID) {
                    case 1:
                        CID = "00000" + customerID;
                        break;
                    case 2:
                        CID = "0000" + customerID;
                        break;
                    case 3:
                        CID = "000" + customerID;
                        break;
                    case 4:
                        CID = "00" + customerID;
                        break;
                    case 5:
                        CID = "0" + customerID;
                        break;
                    case 6:
                        CID = "" + customerID;
                        break;
                    default:
                        break;
                }
                Customer customerObj = AddCustomer(reading, CID);
                output.println(customerObj.toString());
                customerArr.add(customerObj);

            } //Step 3: Buying a Ticket 
            //Command: BuyTicket 
            else if (reading[0].equals("BuyTicket")) {
                Event eventName = SearchNameOfEvent(currentEventArr, reading[1]);
                Date eventDate = new SimpleDateFormat("dd/MM/yyyy").parse(reading[2]);
                Event dateOfEvent = searchDateOfEvent(currentEventArr, eventDate);

                if (eventName == null) {
                    output.println("The event the help is not found");
                } else if (dateOfEvent == null) {
                    output.println("The requested event " + reading[1] + " is not available in the selected date");
                    output.println("Ticket not successfully added to the ShoppingCart: Cart Size -> " + ticket);
                } else if (eventName != null && dateOfEvent != null) {
                    ticket++;
                    output.println("The requested event " + reading[1] + " is available in the selected date");
                    output.println("Ticket is successfully added to the ShoppingCart: Cart Size ->" + ticket);
                    BookEventArr.add(eventName); //storing name of event in bookEventArr 
                }

            } //"For" of Command BuyTicket
            else if (reading[0].equals("For")) {
                Customer custName = searchCustomer(customerArr, reading[1]);
                if (custName == null) {
                    output.println("The customer " + reading[1] + " is not found");
                    output.println("**Buying Ticket for " + reading[1] + " was not successfully completed");
                    BookEventArr.clear();
                } else if (!(custName == null)) {   //if customer is exsist
                    output.println("**Buying Ticket for " + reading[1] + " was successfully completed");

                    int randomDigit = random.nextInt((900) + 100);
                    String BookingID = custName.getID() + randomDigit;
                    bookObj = new Booking(BookingID, custName, BookEventArr);
                    currentEventArr = reduceTickets(currentEventArr, BookEventArr);

                    //Step 4: Print information 
                    print_invoice(bookObj, output); //print booked ticket
                    BookEventArr.clear();
                    bookObj = null;
                    ticket = 0;
                }
            } //1. Print Sorted Available Events 
            //Command: PrintSortMovie
            else if (reading[0].equals("PrintSortMovies")) {
                PrintMovies(currentEventArr, output);
            } //Command: PrintSortFestivals
            else if (reading[0].equals("PrintSortFestivals")) {
                PrintSortFestivals(currentEventArr, output);
            }
        }
        fileScan.close();
        output.close();
    }

////////////////////////////////////////////////////////////////////////////////////
//*** Method1 : addMovie
    public static Movie AddMovie(String[] reading) throws Exception {

        //Constructor of Movie class
/*Movie(String Name, Date SDate, Date EDate, double price, String City, String Address, String Language,
String TargetedAudience, double Rating, int AvailableTickets, String Genre, Actor Actor) {*/
        Date SDate = new SimpleDateFormat("dd/MM/yyyy").parse(reading[2]);
        Date EDate = new SimpleDateFormat("dd/MM/yyyy").parse(reading[3]);
        Actor actor = new Actor(reading[12], reading[13].charAt(0), Integer.parseInt(reading[14]));
        Movie movieObj = new Movie(reading[1], SDate, EDate, Double.parseDouble(reading[4]), reading[5], reading[6], reading[7], reading[8],
                Double.parseDouble(reading[9]), Integer.parseInt(reading[10].trim()), reading[11], actor);
        return movieObj;
    }

////////////////////////////////////////////////////////////////////////////////////
//*** Method2 : addFestival
    public static Festival AddFestival(String[] reading) throws Exception {

        //Constructor of Festival class
/*Festival(String Name, Date SDate, Date EDate, double price, String City, String Address,
String TargetedAudience, int AvailableTickets, String[] FoodVenues, String[] KidsActivity)*/
        Date SDate = new SimpleDateFormat("dd/MM/yyyy").parse(reading[2]);
        Date EDate = new SimpleDateFormat("dd/MM/yyyy").parse(reading[3]);
        String[] FoodVenues = reading[9].split(" ");
        String[] KidsActivity = reading[10].split(" ");

        Festival festivalObj = new Festival(reading[1], SDate, EDate, Double.parseDouble(reading[4]), reading[5], reading[6],
                reading[7], Integer.parseInt(reading[8].trim()), FoodVenues, KidsActivity);
        return festivalObj;
    }

////////////////////////////////////////////////////////////////////////////////////
//**Method3 : addConcert
    public static Concert AddConcert(String[] reading) throws Exception {

        //Constructor of Concert class
/*Concert(String Name, Date SDate, Date EDate, String City, String Address, double price,
            int AvailableTickets, String TargetedAudience, String performers)*/
        Date SDate = new SimpleDateFormat("dd/MM/yyyy").parse(reading[2]);
        Date EDate = new SimpleDateFormat("dd/MM/yyyy").parse(reading[3]);

        Concert concertObj = new Concert(reading[1], SDate, EDate, reading[4], reading[5], Double.parseDouble(reading[6].trim()),
                Integer.parseInt(reading[7].trim()), reading[8], reading[9]);

        return concertObj;
    }

/////////////////////////////////////////////////////////////////////////////////////
//**Method4 : addCustomers
    public static Customer AddCustomer(String[] reading, String CID) throws Exception {

        // Constructor of Customer Class
        //Customer(String CID, String name, char Gender, String email, Date DOB)
        Date DOB = new SimpleDateFormat("dd/MM/yyyy").parse(reading[3]);
        Customer customerObj = new Customer(CID, reading[1], reading[2].charAt(0), reading[4], DOB);
        return customerObj;
    }

////////////////////////////////////////////////////////////////////////////////////
//**Method5 : SearchNameOfEvent
    public static Event SearchNameOfEvent(ArrayList<Event> event, String name) {
        for (int i = 0; i < event.size(); i++) {
            if (event.get(i).getName().equals(name)) {
                return event.get(i);
            }
        }
        return null;
    }

////////////////////////////////////////////////////////////////////////////////////
//**Method6 : searchDateOfEvent
    public static Event searchDateOfEvent(ArrayList<Event> event, Date choosDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Convert from Date to String
        String currentDate = dateFormat.format(choosDate);

        for (int i = 0; i < event.size(); i++) {
            //Range >> 
            //if the date between Starting & Ending the event 
            if ((choosDate.after(event.get(i).getSDate()) && (choosDate.before(event.get(i).getEDate())))
                    // or choosDate in the same date of starting event
                    || (currentDate.equals(dateFormat.format(event.get(i).getSDate()))
                    // or choosDate in the same date of Ending event
                    || currentDate.equals(dateFormat.format(event.get(i).getEDate())))) {
                return event.get(i);
            }
        }
        return null;
    }

////////////////////////////////////////////////////////////////////////////////////
//**Method7 : searchCustomer
    public static Customer searchCustomer(ArrayList<Customer> customer, String name) {
        for (int i = 0; i < customer.size(); i++) {
            if (customer.get(i).getName().equals(name)) {
                return customer.get(i);
            }
        }
        return null;
    }

////////////////////////////////////////////////////////////////////////////////////
//**Method8 : reduceTickets
    public static ArrayList<Event> reduceTickets(ArrayList<Event> eventArr, ArrayList<Event> bookEventArr) {
        for (int i = 0; i < bookEventArr.size(); i++) {
            Event searchEvent = SearchNameOfEvent(bookEventArr, eventArr.get(i).getName());
            if (searchEvent != null) {
                eventArr.get(i).setAvailableTickets(eventArr.get(i).getAvailableTickets() - 1);

            }
        }
        return eventArr;
    }

////////////////////////////////////////////////////////////////////////////////////
//**Method9 : print_invoice
    public static void print_invoice(Booking bookTicket, PrintWriter output) {
        output.println("");
        output.println("------------------------- Invoice Details -------------------------");
        output.println("Booking# " + bookTicket.getBookingID());
        output.println("Customer #: " + bookTicket.getCustomer().getID());
        output.println("-------------------------------------------------------------------");
        output.println("Event   \t\tPrice  \t\tDiscount   \tFinal_price");
        String p = "%";
        for (int i = 0; i < bookTicket.getEvents().size(); i++) {
            output.printf("%s\r%15.2f\r%18.1f%2s%17.2f\r\n", bookTicket.getEvents().get(i).getName(), bookTicket.getEvents().get(i).getPrice(),
                    bookTicket.getDiscount(bookTicket.getEvents().get(i)), p, bookTicket.getFinalPrice(bookTicket.getEvents().get(i)));
        }
        output.println("-------------------------------------------------------------------");
        output.println("Number of discount items: " + bookTicket.getNumberOfDiscountEvents());
        output.printf("- Total Price:  %.2f%n", bookTicket.getTotalPrice());
        output.printf("- Final Price:  %.2f%n", bookTicket.calculateFinalPrice());
        output.printf("- Saving Amount:  %.2f%n", bookTicket.getSavingAmount());
        output.println("-------------------------------------------------------------------");
        output.println("");
        output.println("");
    }

////////////////////////////////////////////////////////////////////////////////////
//Method10 : PrintMovies
    public static void PrintMovies(ArrayList<Event> eventArr, PrintWriter output) {
        ArrayList<Movie> movieArr = new ArrayList<Movie>();
        for (int i = 0; i < eventArr.size(); i++) {
            if (eventArr.get(i) instanceof Movie) {
                movieArr.add((Movie) eventArr.get(i));
            }
        }
        output.println("------------------------------------------- Movie Sorted By Rating -------------------------------------------");
        output.println("MovieDates         \r\t\tDate       \t\tActor       \tRatings         \tAvailableTickets");
        output.println("--------------------------------------------------------------------------------------------------------------");
        Collections.sort(movieArr);
        for (Movie movieInfo : movieArr) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String SDate = dateFormat.format(movieInfo.getSDate());
            String EDate = dateFormat.format(movieInfo.getEDate());
            String dash = "-";
            output.printf("%s  \r\t\t%11s%s%s \r\t\t%13s \r\t%12.2f %16d%n", movieInfo.getName(), SDate, dash, EDate, movieInfo.getActor().getName(),
                    movieInfo.getRating(), movieInfo.getAvailableTickets());
        }
    }

////////////////////////////////////////////////////////////////////////////////////
//Method 11 : PrintSortFestivals
    public static void PrintSortFestivals(ArrayList<Event> eventArr, PrintWriter output) {
        ArrayList<Festival> festivalArr = new ArrayList<Festival>();
        for (int i = 0; i < eventArr.size(); i++) {
            if (eventArr.get(i) instanceof Festival) {
                festivalArr.add((Festival) eventArr.get(i));
            }
        }
        output.println("");
        output.println("---------------------------------------- Festival Sorted By Starting Date -----------------------------------------------");
        output.println("Festival             \t\tDate             \tFoodVenues                \tActivities           \tAvailable Tickets");
        output.println("--------------------------------------------------------------------------------------------------------------------------");
        //compareTo of festival.java
        Collections.sort(festivalArr);
        for (Festival festivalInfo : festivalArr) {
            DateFormat dateFormatt = new SimpleDateFormat("dd/MM/yyyy");
            String SDate = dateFormatt.format(festivalInfo.getSDate());
            String EDate = dateFormatt.format(festivalInfo.getEDate());
            String dash = "-";
            output.printf("%s \r\t\t%11s%s%s \r\t\t%12s  \r\t%21s %15d%n", festivalInfo.getName(), SDate, dash, EDate, Arrays.toString(festivalInfo.getFoodVenues()),
                    Arrays.toString(festivalInfo.getActivity()), festivalInfo.getAvailableTickets());
        }
    }
}
