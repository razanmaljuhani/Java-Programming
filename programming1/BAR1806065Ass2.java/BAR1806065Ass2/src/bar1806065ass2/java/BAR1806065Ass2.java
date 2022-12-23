/* Hi teatcher , I hope you'r alawys happy >> Here The solving of assignment2 in Java language . 
The Date of sending :  Monday , October 29th , 2018 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .\

package bar1806065ass2.java;
import java.util.Scanner;
public class BAR1806065Ass2 {
     public static void main(String[] args ) {
       Scanner input = new Scanner(System.in);
       
System.out.println("------------------------------------------------------------");
System.out.println("		Welcome to Red Sea Logistics Cargo Rate System");
System.out.println("------------------------------------------------------------");
System.out.println("	Enter \"Nat\" for National Cargo");
System.out.println("	Enter \"Int\" for International  Cargo");  
System.out.println("	Enter \"Exit\" for Exiting the Program");
System.out.print("Enter the Choice: ");
       String choice = input.nextLine() ;
       String nat = "nat" ;
       String Int ="Int" ;
       String exit = "exit" ;
  if (choice.equalsIgnoreCase(nat)||choice.equalsIgnoreCase(Int)||choice.equalsIgnoreCase(exit)){
     
     //exit department
        if (choice.equalsIgnoreCase(exit)){
                 System.out.println("                              *** Thank you for using this Application ***");
                 System.exit(0);}
      
    //nat department    
           else if (choice.equalsIgnoreCase(nat)){
                System.out.println("************************");
                System.out.println("Enter personal details : ");
                System.out.println("");
                System.out.print("         Enter the name (first and last): ");
        String name1 = input.nextLine() ;
                System.out.print("         Enter Your Contact Number: ");
        String conactNumber1 = input.nextLine();
                System.out.print("         Enter Your Address: ");
        String address1 = input.nextLine() ;
                System.out.println("************************");
                System.out.println("Select Freight type ");
                System.out.println("");
                System.out.println("	Press R or r for Road freight  ");
                System.out.println("	Press A or a for Air freight");
        
                System.out.print("Enter the Choice: ");
        String freight1 = input.next();
        String r = "r";
        String a = "a";
           if (freight1.equalsIgnoreCase(r)||freight1.equalsIgnoreCase(a)){         
              if (freight1.equalsIgnoreCase(r)){
                System.out.print("Enter the weight for cargo : ");
                double weight1 = input.nextDouble();
                  if (weight1==0) {
                System.out.println("           Wrong input... Weight should be greater than zero ");
                System.exit(0); }
                  else if (weight1 < 0){
                 System.out.println("          Sorry! Wrong input!");
                 System.exit(0);}
                  
                                                
        else if (weight1 >= 1 && weight1 <= 5 ){
                 System.out.println("");
                 System.out.println("");
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("			    Information Details for NATIONAL Shipment");      
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("");      
                 System.out.println("===========================================================================================================================");      
                 System.out.print("Name                        : " + name1.toUpperCase());
                 System.out.print("              Contact Number:" + conactNumber1);
                 System.out.print("                      Address:     "+ address1);
                 System.out.println("");
                 System.out.println("Freight Type               : ROAD FREIGHT                ");
                 System.out.println("");
            String weight = "weight" ;   
            String massU = "KGs";         
            System.out.printf ("%51s%20.1f%4s%n",weight,weight1,massU);
            
            String shipmentCost = "Shipment Cost" ;
            double shipmentC = weight1 * 10.0  ;
            System.out.printf ("%58s%14.2f%n",shipmentCost,shipmentC);
            
            String tax = "Tax" ;
            double taxN = shipmentC * 0.05 ;
            System.out.printf ("%48s%23.2f%n",tax,taxN);
            
            String insurance  = "Insurance" ;     
            final double insuranceN = 8 ;
            System.out.printf ("%54s%16.1f%n",insurance,insuranceN);
            System.out.println("");

            
            System.out.println("					------------------------------------");
            String totalCost  = "Total Cost" ;     
            double totalCost1 = taxN + shipmentC + insuranceN ;
            int totatCost11 = (int)(Math.round(totalCost1));
            String ryals =  "SAR ";
            System.out.printf ("%55s%14d%5s%n",totalCost,totatCost11,ryals);
            System.out.println("");
            System.out.println("");
            System.out.println("==========================================================================================================================");
            System.out.println("			      *** Thank you for using this Application ***");
            System.out.println("");
            System.exit(0);}
            
        else if (weight1 > 5 && weight1 <= 10 ){
                 System.out.println("");
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("			    Information Details for NATIONAL Shipment");      
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("");      
                 System.out.println("===========================================================================================================================");      
                 System.out.print("Name                        : " + name1.toUpperCase());
                 System.out.print("              Contact Number:" + conactNumber1);
                 System.out.print("                   Address:     " + address1);
                 System.out.println("");
                 System.out.println("Freight Type               : ROAD FREIGHT                ");
                 System.out.println("");
            String weight = "weight" ;   
            String massU = "KGs";         
            System.out.printf ("%51s%20.1f%4s%n",weight,weight1,massU);

            String shipmentCost = "Shipment Cost" ;
            double shipmentC = weight1 * 8.5  ;
            System.out.printf ("%58s%14.2f%n",shipmentCost,shipmentC);
            
            String tax = "Tax" ;
            double taxN = shipmentC * 0.05 ;
            System.out.printf ("%48s%23.2f%n",tax,taxN);
            
            String insurance  = "Insurance" ;     
            final double insuranceN = 8 ;
            System.out.printf ("%54s%16.1f%n",insurance,insuranceN);
            System.out.println("");

            System.out.println("					------------------------------------");
            String totalCost  = "Total Cost" ;     
            double totalCost1 = taxN + shipmentC + insuranceN ;
            int totatCost11 = (int)(Math.round(totalCost1));
            String ryals =  "SAR ";
            System.out.printf ("%55s%14d%5s%n",totalCost,totatCost11,ryals);
            System.out.println("");
            System.out.println("");
            System.out.println("==========================================================================================================================");
            System.out.println("			      *** Thank you for using this Application ***");
            System.out.println("");
            System.exit(0);}
        
       else if (weight1 > 10 && weight1 <= 50 ){
                 System.out.println("");
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("			    Information Details for NATIONAL Shipment");      
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("");      
                 System.out.println("===========================================================================================================================");      
                 System.out.print("Name                        : " + name1.toUpperCase());
                 System.out.print("              Contact Number:" + conactNumber1);
                 System.out.print("                       Address:     "+ address1);
                 System.out.println("");
                 System.out.println("Freight Type               : ROAD FREIGHT                ");
                 System.out.println("");
            String weight = "weight" ;   
            String massU = "KGs";         
            System.out.printf ("%51s%20.1f%4s%n",weight,weight1,massU);
            
            String shipmentCost = "Shipment Cost" ;
            double shipmentC = weight1 * 5.5  ;
            System.out.printf ("%58s%14.2f%n",shipmentCost,shipmentC);
            
            String tax = "Tax" ;
            double taxN = shipmentC * 0.05 ;
            System.out.printf ("%48s%23.2f%n",tax,taxN);
            
            String insurance  = "Insurance" ;     
            final double insuranceN = 8 ;
            System.out.printf ("%54s%16.1f%n",insurance,insuranceN);
            System.out.println("");
            
            System.out.println("					------------------------------------");
            String totalCost  = "Total Cost" ;     
            double totalCost1 = taxN + shipmentC + insuranceN ;
            int totatCost11 = (int)(Math.round(totalCost1));
            String ryals =  "SAR ";
            System.out.printf ("%55s%14d%5s%n",totalCost,totatCost11,ryals);
            System.out.println("");
            System.out.println("");
            System.out.println("==========================================================================================================================");
            System.out.println("			      *** Thank you for using this Application ***");
            System.out.println("");
            System.exit(0);}
       
      else if (weight1 > 50 ){
                 System.out.println("");
                 System.out.println("");
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("			    Information Details for NATIONAL Shipment");      
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("");      
                 System.out.println("===========================================================================================================================");      
                 System.out.print("Name                        : " + name1.toUpperCase());
                 System.out.print("                  Contact Number: " + conactNumber1);
                 System.out.print("                Address:     "      + address1);
                 System.out.println("");
                 System.out.println("Freight Type                : ROAD FREIGHT                ");
                 System.out.println("");
            String weight = "weight" ;   
            String massU = "KGs";         
            System.out.printf ("%51s%20.1f%4s%n",weight,weight1,massU);

            String shipmentCost = "Shipment Cost" ;
            double shipmentC = weight1 * 2.5  ;
            System.out.printf ("%58s%14.2f%n",shipmentCost,shipmentC);
            
            String tax = "Tax" ;
            double taxN = shipmentC * 0.05 ;
            System.out.printf ("%48s%23.2f%n",tax,taxN);
            
            String insurance  = "Insurance" ;     
            final double insuranceN = 15 ;
            System.out.printf ("%54s%16.1f%n",insurance,insuranceN);
            System.out.println("");
            
            System.out.println("					------------------------------------");
            String totalCost  = "Total Cost" ;     
            double totalCost1 = taxN + shipmentC + insuranceN ;
            int totatCost11 = (int)(Math.round(totalCost1));
            String ryals =  "SAR ";
            System.out.printf ("%55s%14d%5s%n",totalCost,totatCost11,ryals);
            System.out.println("");
            System.out.println("");
            System.out.println("==========================================================================================================================");
            System.out.println("			      *** Thank you for using this Application ***");
            System.out.println("");  
            System.exit(0); }
                 }
  
                if (freight1.equalsIgnoreCase(a)){
                 System.out.print("Enter the weight for cargo : ");
                   double weight2 = input.nextDouble();
                     if (weight2 == 0) {    
                  System.out.println("      Wrong input... Weight should be greater than zero ");
                  System.exit(0);}
            else if (weight2 < 0){
                  System.out.println("      Sorry! Wrong input! ");
                  System.exit(0);}
        
            else if (weight2 >= 1 && weight2 <= 5 ){
                 System.out.println("");
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("			    Information Details for NATIONAL Shipment");      
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("");      
                 System.out.println("===========================================================================================================================");      
                 System.out.print("Name                        : " + name1.toUpperCase());
                 System.out.print("                     Contact Number:" + conactNumber1);
                 System.out.print("                       Address:     "+ address1);
                 System.out.println("");
                 System.out.println("Freight Type               : AIR FREIGHT               ");
                 System.out.println("");
            String weight = "weight" ;   
            String massU = "KGs";         
            System.out.printf ("%51s%20.1f%4s%n",weight,weight2,massU);
            
            String shipmentCost = "Shipment Cost" ;
            double shipmentC = weight2 * 16  ;
            System.out.printf ("%58s%14.2f%n",shipmentCost,shipmentC);
            
            String tax = "Tax" ;
            double taxN = shipmentC * 0.05 ;
            System.out.printf ("%48s%23.2f%n",tax,taxN);
            
            String insurance  = "Insurance" ;     
            final double insuranceN = 8 ;
            System.out.printf ("%54s%16.1f%n",insurance,insuranceN);
            System.out.println("");

            
            System.out.println("					------------------------------------");
            String totalCost  = "Total Cost" ;     
            double totalCost1 = taxN + shipmentC + insuranceN ;
            int totatCost11 = (int)(Math.round(totalCost1));
            String ryals =  "SAR ";
            System.out.printf ("%55s%14d%5s%n",totalCost,totatCost11,ryals);
            System.out.println("");
            System.out.println("");
            System.out.println("==========================================================================================================================");
            System.out.println("			      *** Thank you for using this Application ***");
            System.out.println("");
            System.exit(0);}
            
        else if (weight2 > 5 && weight2 <= 10 ){
                 System.out.println("");
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("			    Information Details for NATIONAL Shipment");      
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("");      
                 System.out.println("===========================================================================================================================");      
                 System.out.print("Name                        : " + name1.toUpperCase());
                 System.out.print("                 Contact Number:" + conactNumber1);
                 System.out.print("                      Address:     "+ address1);
                 System.out.println("");
                 System.out.println("Freight Type                : AIR FREIGHT                ");
                 System.out.println("");
            String weight = "weight" ;   
            String massU = "KGs";         
            System.out.printf ("%51s%20.1f%4s%n",weight,weight2,massU);

            String shipmentCost = "Shipment Cost" ;
            double shipmentC = weight2 * 13.5  ;
            System.out.printf ("%58s%14.2f%n",shipmentCost,shipmentC);
            
            String tax = "Tax" ;
            double taxN = shipmentC * 0.05 ;
            System.out.printf ("%48s%23.2f%n",tax,taxN);
            
            String insurance  = "Insurance" ;     
            final double insuranceN = 8 ;
            System.out.printf ("%54s%16.1f%n",insurance,insuranceN);
            System.out.println("");

            System.out.println("					------------------------------------");
            String totalCost  = "Total Cost" ;     
            double totalCost1 = taxN + shipmentC + insuranceN ;
            int totatCost11 = (int)(Math.round(totalCost1));
            String ryals =  "SAR ";
            System.out.printf ("%55s%14d%5s%n",totalCost,totatCost11,ryals);
            System.out.println("");
            System.out.println("");
            System.out.println("==========================================================================================================================");
            System.out.println("			      *** Thank you for using this Application ***");
            System.out.println("");
            System.exit(0);}
        
       else if (weight2 > 10 && weight2 <= 50 ){
                 System.out.println("");
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("			    Information Details for NATIONAL Shipment");      
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("");      
                 System.out.println("===========================================================================================================================");      
                 System.out.print("Name                        : " + name1.toUpperCase());
                 System.out.print("                   Contact Number:" + conactNumber1);
                 System.out.print("             Address:     "+ address1);
                 System.out.println("");
                 System.out.println("Freight Type                : AIR FREIGHT                ");
                 System.out.println("");
            String weight = "weight" ;   
            String massU = "KGs";         
            System.out.printf ("%51s%20.1f%4s%n",weight,weight2,massU);
            
            String shipmentCost = "Shipment Cost" ;
            double shipmentC = weight2 * 10.5  ;
            System.out.printf ("%58s%15.2f%n",shipmentCost,shipmentC);
            
            String tax = "Tax" ;
            double taxN = shipmentC * 0.05 ;
            System.out.printf ("%48s%24.2f%n",tax,taxN);
            
            String insurance  = "Insurance" ;     
            final double insuranceN = 8 ;
            System.out.printf ("%54s%16.1f%n",insurance,insuranceN);
            System.out.println("");
            
            System.out.println("					------------------------------------");
            String totalCost  = "Total Cost" ;     
            double totalCost1 = taxN + shipmentC + insuranceN ;
            int totatCost11 = (int)(Math.round(totalCost1));
            String ryals =  "SAR ";
            System.out.printf ("%55s%15d%5s%n",totalCost,totatCost11,ryals);
            System.out.println("");
            System.out.println("");
            System.out.println("==========================================================================================================================");
            System.out.println("			      *** Thank you for using this Application ***");
            System.out.println("");
            System.exit(0);}
       else if(weight2 > 50)  { 
            System.out.println("");
            System.out.println("	Sorry! National Air freight is not available for more than 50KGs!");
            System.exit(0);} 
                }               
                
               
           } else { 
     System.out.println("");
     System.out.println("	Wrong Selection of Freight type!");}
     System.exit(0); }
                     
   
           
           
   //int department
        else if (choice.equalsIgnoreCase(Int)){
                System.out.println("************************");
                System.out.println("Enter personal details : ");
                System.out.println("");
                System.out.print("         Enter the name (first and last): ");
        String name1 = input.nextLine() ;
                System.out.print("         Enter Your Contact Number: ");
        String conactNumber2 = input.nextLine();
                System.out.print("         Enter Your Address: ");
        String address2 = input.next() ;
                System.out.println("************************");
                System.out.println("Select Freight type ");
                System.out.println("");
                System.out.println("	Press S or s for Sea freight");
                System.out.println("	Press A or a for Air freight");
        
                System.out.print("Enter the Choice: ");
        String freight2 = input.next();
        String s = "s";
        String A1 = "A";
           if (freight2.equalsIgnoreCase(s)||freight2.equalsIgnoreCase(A1)){
               if (freight2.equalsIgnoreCase(s)){
                System.out.print("Enter the weight for cargo : ");
                  double weight2 = input.nextDouble();
                  if (weight2 == 0) {
                System.out.println("           Wrong input... Weight should be greater than zero ");
                System.exit(0); }
            else if (weight2 < 0){
                System.out.println("          Sorry! Wrong input!");
                System.exit(0);}
          
             else if (weight2 >= 1 && weight2 <= 100 ) {
                 System.out.println("");
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("			    Information Details for NATIONAL Shipment");      
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("");      
                 System.out.println("===========================================================================================================================");      
                 System.out.print("Name                        : " + name1.toUpperCase());
                 System.out.print("                  Contact Number:" + conactNumber2);
                 System.out.print("                     Address:     "+ address2);
                 System.out.println("");
                 System.out.println("Freight Type               : SEA FREIGHT                ");
                 System.out.println("");
            String weight = "weight" ;   
            String massU1 = "KGs";         
            System.out.printf ("%50s%15.1f%7s%n",weight,weight2,massU1);
    
            String shipmentCost = "Shipment Cost" ;
            double shipmentC = weight2 * 5.5 ;
            System.out.printf ("%50s%13.2f%n",shipmentCost,shipmentC);
 
            String tax = "Tax" ;
            double taxN = shipmentC * 0.065 ;
            System.out.printf ("%50s%13.2f%n",tax,taxN);
            
            String insurance  = "Insurance" ;     
            final double insuranceN = 50 ;
            System.out.printf ("%50s%13.1f%n",insurance,insuranceN);
            System.out.println("");
            
            System.out.println("					------------------------------------");
            String totalCost  = "Total Cost" ;     
            double totalCost1 = taxN + shipmentC + insuranceN ;
            int totatCost11 = (int)(Math.round(totalCost1));
            String ryals =  "SAR ";
            System.out.printf ("%55s%14d%5s%n",totalCost,totatCost11,ryals);
            System.out.println("");
            System.out.println("");
            System.out.println("==========================================================================================================================");
            System.out.println("			      *** Thank you for using this Application ***");
            System.out.println("");
            System.exit(0);
             }
             
       else if (weight2 > 100 && weight2 <= 10000 ) {
                 System.out.println("");
                 System.out.println("");
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("			    Information Details for NATIONAL Shipment");      
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("");      
                 System.out.println("===========================================================================================================================");      
                 System.out.print("Name                        : " + name1.toUpperCase());
                 System.out.print("             Contact Number:" + conactNumber2);
                 System.out.print("               Address:     "+ address2);
                 System.out.println("");
                 System.out.println("Freight Type                : SEA FREIGHT                ");
                 System.out.println("");
            String weight = "weight" ;   
            String massU1 = "KGs";         
            System.out.printf ("%50s%15.1f%4s%n",weight,weight2,massU1);
            
            String shipmentCost = "Shipment Cost" ;
            double shipmentC = weight2 * 4 ;
            System.out.printf ("%57s%9.2f%n",shipmentCost,shipmentC);
            
            String tax = "Tax" ;
            double taxN = shipmentC * 0.065 ;
            System.out.printf ("%47s%18.2f%n",tax,taxN);
            
            String insurance  = "Insurance" ;     
            final double insuranceN = 50 ;
            System.out.printf ("%53s%11.1f%n",insurance,insuranceN);
            System.out.println("");
            
            System.out.println("					------------------------------------");
            String totalCost  = "Total Cost" ;     
            double totalCost1 = taxN + shipmentC + insuranceN ;
            int totatCost11 = (int)(Math.round(totalCost1));
            String ryals =  "SAR ";
            System.out.printf ("%54s%9d%5s%n",totalCost,totatCost11,ryals);
            System.out.println("");
            System.out.println("");
            System.out.println("==========================================================================================================================");
            System.out.println("			      *** Thank you for using this Application ***");
            System.out.println("");      
            System.exit(0); 
       } 
         
   else if (weight2 > 10000 ) {
                 
                 System.out.println("");
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("			    Information Details for NATIONAL Shipment");      
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("");      
                 System.out.println("===========================================================================================================================");      
                 System.out.print("Name                        : " + name1.toUpperCase());
                 System.out.print("                Contact Number:" + conactNumber2);
                 System.out.print("            Address:     "+ address2);
                 System.out.println("");
                 System.out.println("Freight Type                : SEA FREIGHT                ");
                 System.out.println("");
     
            String weight = "weight" ;   
            String massU1 = "KGs";         
            System.out.printf ("%50s%21.1f%4s%n",weight,weight2,massU1);
            
            String shipmentCost = "Shipment Cost" ;
            final double shipmentC = 6250 ;
            System.out.printf ("%57s%14.2f%n",shipmentCost,shipmentC);
            
            String tax = "Tax" ;
            double taxC = shipmentC * 0.08 ;
            System.out.printf ("%47s%23.2f%n",tax,taxC);
            
            String insurance  = "Insurance" ;     
            final double insuranceC = 450 ;
            System.out.printf ("%53s%16.1f%n",insurance,insuranceC);
            
            double container = Math.ceil(weight2 / 25000);
            String CONTIANER  = "No of contianer(s)" ;     
            System.out.printf ("%62s%3.0f%n",CONTIANER,container);
            System.out.println("");
            
            System.out.println("");
            System.out.println("					------------------------------------");
            String totalCost  = "Total Cost" ; 
            double totalContianer = ((shipmentC + taxC + insuranceC )* (container)) ;
            String ryals =  "SAR ";
            System.out.printf ("%55s%14.0f%5s%n",totalCost,totalContianer,ryals);
            System.out.println("");
            System.out.println("");
            System.out.println("==========================================================================================================================");
            System.out.println("			      *** Thank you for using this Application ***");
            System.out.println("");
            System.exit(0);
   }}
            
         if (freight2.equalsIgnoreCase(A1)){
                System.out.print("Enter the weight for cargo : ");
                double weight3 = input.nextDouble();
               if (weight3 == 0) {
                System.out.println("           Wrong input... Weight should be greater than zero ");
                System.exit(0); }
        else if (weight3 < 0){
                System.out.println("           Sorry! Wrong input!");
                System.exit(0); }
         else if (weight3 >= 1 && weight3 <= 100 ) {
                 System.out.println("");
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("			    Information Details for NATIONAL Shipment");      
                 System.out.println("			---------------------------------------------------------");      
                 System.out.println("");      
                 System.out.println("===========================================================================================================================");      
                 System.out.print("Name                        : " + name1.toUpperCase());
                 System.out.print("               Contact Number:" + conactNumber2);
                 System.out.print("                  Address:     "+ address2);
                 System.out.println("");
                 System.out.println("Freight Type               : AIR FREIGHT              ");
                 System.out.println("");
            String weight = "weight" ;   
            String massU1 = "KGs";         
            System.out.printf ("%50s%15.1f%7s%n",weight,weight3,massU1);

            String shipmentCost = "Shipment Cost" ;
            double shipmentC = weight3 * 12.5 ;
            System.out.printf ("%50s%13.2f%n",shipmentCost,shipmentC);

            String tax = "Tax" ;
            double taxN = shipmentC * 0.065 ;
            System.out.printf ("%50s%13.2f%n",tax,taxN);

            String insurance  = "Insurance" ;     
            final double insuranceN = 50 ;
            System.out.printf ("%50s%13.1f%n",insurance,insuranceN);
            System.out.println("");
               
            System.out.println("					------------------------------------");
            String totalCost  = "Total Cost" ;     
            double totalCost1 = taxN + shipmentC + insuranceN ;
            int totatCost11 = (int)(Math.round(totalCost1));
            String ryals =  "SAR ";
            System.out.printf ("%55s%14d%5s%n",totalCost,totatCost11,ryals);
                        
            System.out.println("");
            System.out.println("");
            System.out.println("==========================================================================================================================");
            System.out.println("			      *** Thank you for using this Application ***");
            System.out.println(""); 
            System.exit(0); }     
        else 
             { 
           System.out.println("");
           System.out.println("	     Sorry! International Air freight is not available for more than 100KGs!");
           System.exit(0);}
              }} else { 
     System.out.println("");
     System.out.println("	Wrong Selection of Freight type!");}
     System.exit(0); 
  }}
                    
  else { 
     System.out.println("");
     System.out.println("	Wrong Selection of shipment scope! ");}
     System.exit(0); 
    
  }}
