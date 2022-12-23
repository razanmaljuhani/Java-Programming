
package javaapplication30;

import java.util.Scanner;


public class JavaApplication30 {

    public static void main(String[] args) {
Scanner input = new Scanner(System.in);
char clinicType ='k';
String clinic = ""; 
int time = 0 ;
int fee = 0 ;
int timeOfIcu = 800 ;
int timeOfRadiology = 900 ;
int timeOfSurgery  = 930 ;
int timeOfDentistry  = 1000 ;
String add = "add";
String book = "book";
String exit = "exit ";
         
//Start of loop
 while(true) {  
   displayMainMenu();   
String selection = input.nextLine();
selection = selection.toUpperCase();
if (selection.equalsIgnoreCase(book)||selection.equalsIgnoreCase(add)||selection.equalsIgnoreCase(exit)){
    
 //_______________________________________________________________________________________________________________________
 //book department
  if (selection.equalsIgnoreCase(book)){
        do { printMsg("departmentsClinic");
          clinicType = input.nextLine().charAt(0);
          clinicType = Character.toUpperCase(clinicType); 
          clinicType = readAndVerify(clinicType);
  }while (clinicType == 'W'); 
         
                 
             System.out.println("");
             System.out.print("  Enter the name (first and last): ");
         String name = input.nextLine();
             System.out.print("  Enter the national ID number: ");
         int id = Integer.parseInt(input.nextLine());
             System.out.print("  The appointment will be at ");     
           switch(clinicType) {
               case 'I' :
                   time = timeOfIcu ;
                   fee = 1000 ;
                   clinic = "ICU";
                   break ;
               case 'R' :
                   time = timeOfRadiology ;
                   fee = 200 ;
                   clinic = "Radiology";
                   break ;
               case 'S' :
                   time = timeOfSurgery ;
                   fee = 3000 ;
                   clinic  = "Surgery";
                   break ;
               case 'D' :
                   time = timeOfDentistry ;
                   fee = 150 ;
                   clinic = "Dentistry";
              break ;
             
         }    System.out.println(displayTime(time));  
              System.out.print("  Press 1 to confirm, 2 to cancel : ");
         int confirm = Integer.parseInt(input.nextLine());
if ( confirm == 1){
 displayInfo (id, name, time, clinic,  fee );
               System.out.println("");
          switch(clinicType) {
               case 'I' :
                 timeOfIcu = timeOfIcu + 100 ;
                   break ;
               case 'R' :
                 timeOfRadiology = 100 + timeOfRadiology ;
                   break ;
               case 'D' :
                 timeOfDentistry = timeOfDentistry + 100 ;
              break ;
               case 'S' :
                 timeOfSurgery = timeOfSurgery + 100 ;
                   break ;
           }}                 
printMsg("Redirect");  
  }  
  
 //_______________________________________________________________________________________________________________________
 //add department 
  else if (selection.equalsIgnoreCase(add)){
        do { printMsg("departmentsClinic");
          clinicType = input.nextLine().charAt(0);
          clinicType = Character.toUpperCase(clinicType); 
          clinicType = readAndVerify(clinicType);
  }while (clinicType == 'W'); 
        System.out.println("");
         System.out.println("");

         System.out.print("  Enter the name (first and last): ");
     String name = input.nextLine();
         System.out.print("  Enter the national ID number: ");
     int id = Integer.parseInt(input.nextLine());
         System.out.print("  Enter your age: ");
     int age = Integer.parseInt(input.nextLine());
         System.out.print("  Enter your mobile number (###-###-####):  ");
      String phone = input.nextLine();
         System.out.print("  Enter your weight in Kilogram: ");
      double weight = input.nextDouble();
         System.out.print("  Enter your height in Centimeter: ");
      double height = input.nextDouble();
      
           switch(clinicType) {
               case 'I' :
                   clinic = "ICU";
                   break ;
               case 'R' :
                   clinic = "Radiology";
                   break ;
               case 'S' :
                   clinic  = "Surgery";
                   break ;
               case 'D' :
                   clinic = "Dentistry";
              break ;
             }    
           displayInfo  ( id,  name, age,  phone,clinic,weight, height );
           printMsg("Redirect");  
             
   } 
   
//_____________________________________________________________________________________________________________________
//Slect Anther Department and anther servece . 
          else if (selection.equalsIgnoreCase(exit)){
          System.exit(0); }
    
//_______________________________________________________________________________________________________________________
//Slect Anther Department and anther servece .
}
else {
    printMsg("SelectAntherServece");
   }
      }}
   
   
   
   
//*****************
//Method 1 void mainMenu .
    public static void displayMainMenu() { 
    System.out.println("----------------------------------------------------------------");
    System.out.println("	Welcome to the Jeddah National Hospital Administration");
    System.out.println("----------------------------------------------------------------");
    System.out.println("	Enter \"Book\" to book a new appointment");
    System.out.println("	Enter \"Add\" to add a new patient");
    System.out.println("	Enter \"Exit\" to exit the program");
    System.out.print("Enter your Choice: ");
   
   }
   
   
//*****************
//Method 2 char readAndVerify .
   public static char readAndVerify( char clinicsssss) {
       String allClinics = "SRID";
     if(allClinics.contains(clinicsssss + "")){
      return clinicsssss ;
     } else {
         printMsg ("SelectAntherClinic");
                         
   }return 'W' ;}
  

   
//*****************
//Method 4  void  printMsg .
   public static void  printMsg (String menu ) {
switch(menu){
    case "SelectAntherServece" :
            System.out.println("");
            System.out.println("	Wrong Selection of Service Type!");
            System.out.println("");
            return ;
    case "departmentsClinic" :
            System.out.println("	-------------------------------------------------");
            System.out.println("	DEPARTMENT: please select the correct department:");
            System.out.println("	-------------------------------------------------");
            System.out.println("	Enter I or i for ICU:");
            System.out.println("	Enter R or r for Radiology:");
            System.out.println("        Enter S or s for Surgery:");
            System.out.println("	Enter D or d for Dentistry:");
            System.out.print("Enter your Choice: ");
            return ;
    case "SelectAntherClinic" :
            System.out.println(""); 
            System.out.println("	Wrong Selection of clinic... try again!");
            System.out.println(""); 
            return;
    case "Redirect"  :  
            System.out.println("---------------------------------------------------------------------------------------------------"); 
            System.out.println("---------------------------Redirect to the main menu-----------------------------------------------"); 
            System.out.println(""); 
        
    }
   
   }
   
   
//*****************
//Method 5  void  display info 1  . 
   public static void displayInfo (int id, String name, int time, String clinic, int fee ) {
             System.out.println("");
             System.out.println("");
             System.out.println("");
             System.out.println("			-------------------------------------------------");
             System.out.println("			    Information Details for Booking Appointment");
             System.out.println("			-------------------------------------------------");
             System.out.println("Name                    : " + name.toUpperCase() + "           National ID Number         : " + id);
             System.out.println("Clinic                  : " + clinic.toUpperCase() + "              Appointment Time           : " + displayTime(time));
             System.out.println("Appointment fee         : " + fee + " SR");


   }
   

//*****************
//Method 6  void  display info 2  .    
   public static void displayInfo  (int id, String name, int age, String phone, String clinic, double weight, double height ){
         System.out.println("");
         System.out.println("");
         System.out.println("			-------------------------------------------------");
         System.out.println("			    Information Details for Adding Patient");
         System.out.println("			-------------------------------------------------");
         System.out.println("Name                      : " + name.toUpperCase() + "             National ID Number        : " + id);
         System.out.println("Age                       : " + age    + "                 Phone number                : " + phone);
    String unitkg = "kg";
    String weightt = "weight";
         System.out.printf("Clinic                   : %16s %11s                                   :  %5.2f %2s%n",clinic.toUpperCase(),weightt,weight,unitkg);
    String bmi = bmimethod(weight, height) ;
    String unitCm = " cm";
    String heightt = "height";
    String bmii = "bmi";
         System.out.printf("%s                      : %9s %20s                                    : %5.2f%2s%n",bmii.toUpperCase(),bmi,heightt,height,unitCm);

   }
   
   
//*****************
//Method that calculate bmi (not foundmental method in assignment) . 
   public static String bmimethod (double weight, double height){
   height = height / 100 ;
   double bmi = weight / (height*height);
    if (bmi <= 18.5){
       return "Underweight";}
  else if (bmi <= 25) {
       return "Normal"; 
   }
  else if  (bmi <= 30 ) {
       return "Overweight";
   }
   else {
       return "Obese";
   }
   }
   
   
//*****************
//Method that display time (not foundmental method in assignment) .
   public static String displayTime (int time){
       String hours = "";
       String menits = "";
       String appTime = " AM";
    if (time >= 1300){
      appTime = " PM";
        time = time % 1200 ;
   } else if (time>=1200){
      appTime = " PM";
   }
    hours = time/100 + "" ; 
    menits = time%100 + "" ; 
    if ( menits.length() < 2)
        menits = "0" + menits ;
        return hours + ":" + menits + "" + appTime ;
                }
   
   
   
}
