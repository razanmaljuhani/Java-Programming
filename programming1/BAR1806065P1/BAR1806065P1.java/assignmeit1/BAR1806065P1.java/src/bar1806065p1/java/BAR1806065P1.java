/* Hi teatcher , I hope you'r alawys happy >> Here The solving of assignment1 in Java language . 
Date of sending :  Wednesday,October 3th,2018 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p1.java;
     import java.util.Scanner;
public class BAR1806065P1 {

public static void main(String[] args) {
//I defined the Scanner for allow the user to enter the data .
     Scanner input = new Scanner(System.in);
//I wrote some sentences for printing of the different departments ,and I defined the Int. to make the user to enter the numbers .
System.out.println("THIS PROGRAM CALCULATES THE OVERTIME PAYMENT OF A COMPANY WITH THREE DIFFERENT DEPARTMENTS."); 
//1- HR department >
System.out.println("Please enter the information for HR department:");
System.out.print("      Number of employees who have worked overtime       :");
     int hrEmployees = input.nextInt();
System.out.print("      Total number of worked overtime hours per employee :");
     int hrTotal_overtime = input.nextInt();
System.out.println(" ");
System.out.println(" ");

//2- PA department >
System.out.println("Please enter the information for PA department:");
System.out.print("      Number of employees who have worked overtime       :");
     int paEmployees = input.nextInt();
System.out.print("      Total number of worked overtime hours per employee :");
     int paTotal_overtime = input.nextInt();
System.out.println(" ");
System.out.println(" ");

//3- FD department >
System.out.println("Please enter the information for FD department:");
System.out.print("      Number of employees who have worked overtime       :");
     int fdEmployees = input.nextInt();
System.out.print("      Total number of worked overtime hours per employee :");
     int fdTotal_overtime =input.nextInt();
System.out.println(" ");
System.out.println(" ");

// here I wrote the data for the table .
System.out.println("Detailed Report of the Overtime Payment System for all three Department");
System.out.println("--------------------------------------------------------------------------------------------------");
System.out.println("Dept.  #of Emp.  Rate/hour   #of working Emp.  Total overtime hours   Total Payment   Percentage");
System.out.println("**************************************************************************************************");

/*HR department by printf for write it in the table :*/
     final int NUM_EMP_HR = 30;
     final int COST_OF_HR = 150;
     double hrPayment= COST_OF_HR*hrEmployees*hrTotal_overtime ;
     double hrPercentage = hrEmployees *100.00 / NUM_EMP_HR ;
     String HR =("HR");
     String precentage1 = ("%");
System.out.printf("%-8s%-12d%-11d%-21d%-22d%-13.2f%-2.2f%s%n",HR,NUM_EMP_HR,COST_OF_HR,hrEmployees,hrTotal_overtime,hrPayment,hrPercentage ,precentage1);
   
/*PA department by printf for write it in the table:*/
     final int NUM_EMP_PA = 50;
     final int COST_OF_PA = 120;
     double paPayment= COST_OF_PA*paEmployees*paTotal_overtime ;
     double paPercentage = paEmployees*100.00/NUM_EMP_PA;
     String PA =("PA");
     String PRECENTAGE2=("%");
System.out.printf("%-8s%-12d%-11d%-21d%-22d%-13.2f%-2.2f%s%n",PA,NUM_EMP_PA,COST_OF_PA,paEmployees,paTotal_overtime,paPayment,paPercentage,PRECENTAGE2);

/*FD department by printf for write it in the table :*/
     final int NUM_EMP_FD = 10;
     final int COST_OF_FD = 170;
     double fdPayment = COST_OF_FD*fdEmployees*fdTotal_overtime ;
     double fdPercentage =fdEmployees *100.00/ NUM_EMP_FD ;
     String FD =("FD");
     String PRECENTAGE3 = ("%");
System.out.printf("%-8s%-12d%-11d%-21d%-22d%-13.2f%-2.2f%s%n",FD,NUM_EMP_FD,COST_OF_FD,fdEmployees,fdTotal_overtime,fdPayment,fdPercentage,PRECENTAGE3); 

System.out.println("**************************************************************************************************");

// Total Calculation by printf
    String tCompany = ("Total Overtime Payment of the company = ");
    double answer = hrPayment+paPayment+fdPayment ; 
    String currency =("Riyal.");
System.out.printf("%-5s%-9.2f%-9s%n",tCompany,answer,currency);

 }

}