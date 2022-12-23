/* Hi teatcher , I hope you'r alawys happy >> Here The solving of assignment3 in Java language . 
The Date of sending :  Monday , November 13th , 2018 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .\

package bar1806065ass3;

import java.util.Scanner;

public class BAR1806065Ass3 {

    public static void main(String[] args) {
Scanner input = new Scanner(System.in);
int choice ;
  System.out.println("	        	************************************************");
  System.out.println("		        Welcome to the Numbering System Conversion Quiz!");
  System.out.println("	        	************************************************");
  System.out.println("");
  System.out.println("The quiz consists of 8 random questions on converting between Decimal, Binary, \n" +
"and Hexadecimal numbers. You have a maximum number of 3 trials per question.");
  System.out.println("");
  System.out.print("Please enter 1 to start the quiz or 0 to exit: ");
   choice = input.nextInt();
       long startTime  = System.currentTimeMillis(); 
       int score = 0 ;
  while(choice==1) {
        if(choice ==1){
        int decimal = (int)(Math.random()*256);
   // from hexa to the decimal : 
  
for (int x =1 ; x <=2 ; x++) {
        String hexNumber = "";
        decimal = (int)(Math.random()*256);
        int number1 = decimal ;
        String h = " ";
        while (number1 >= 0 ) {
        int valueHexa = number1 / 16 ;
        number1 = number1 % 16 ;
  if (valueHexa < 16 && valueHexa >= 0) {
      number1 = (char) (valueHexa + '0');
         } 
  else { number1 = (char)(valueHexa-10 + 'A'); }
    hexNumber = number1 + hexNumber ;
    number1 = number1 / 16 ;
        }
    
  if (number1==decimal) {
          System.out.println("     Correct Answer ! ");
          score = score+2 ;
  } else {
  for ( int y = 0 ; y < 2 ; y++ ){
          System.out.println("     Wrong Answer ! ");
   System.out.print("Please enter the equivalent Decimal number of " + hexNumber.toUpperCase() +": ");
    int hexaNum2 = input.nextInt();
    input.nextLine();
    if ( hexaNum2 == decimal){
          System.out.println("     Correct Answer ! ");
          score = score+2 ;
          break ;
     }

  }
  
      if (!(number1==decimal)){
       System.out.println("	Sorry, you have exceeded the maximum number of trials for this question!");            
       System.exit(0);
   
      }
  }}
//...............................................................................................................    
 // from decimal to the hexa : 
for (int x =1 ; x <=2 ; x++) {
        String hexNumber = "";
        decimal = (int)(Math.random()*256);
        int numberDecemal = decimal ;
        while (numberDecemal != 0 ) {
        int valueHexa = numberDecemal / 16 ;
        char hexaChar ;
  if (valueHexa <= 9 && valueHexa >= 0) {
      hexaChar = (char) (valueHexa + '0');
         } 
  else { hexaChar = (char)(valueHexa-10 + 'A'); }
    hexNumber = hexaChar + hexNumber ;
    numberDecemal = numberDecemal / 16 ;
        }
    System.out.print("Please enter the equivalent Decimal number of " + hexNumber.toUpperCase() +": ");
    int hexaNum = input.nextInt();
    input.nextLine();
  if (hexaNum==decimal) {
          System.out.println("     Correct Answer ! ");
           score = score+2 ;
  } else {
  for ( int y = 0 ; y < 2 ; y++ ){
          System.out.println("     Wrong Answer ! ");
    System.out.print("Please enter the equivalent Decimal number of " + hexNumber.toUpperCase() +": ");
    int hexaNum2 = input.nextInt();
    input.nextLine();
    if ( hexaNum2 == decimal){
          System.out.println("     Correct Answer ! ");
          score = score+2 ;
          break ;
      }
  }
      if (!(hexaNum==decimal)){
       System.out.println("	Sorry, you have exceeded the maximum number of trials for this question!");            
       System.exit(0);
   
      }
  }}

//...............................................................................................................  

 // from decimal to the binary : 
for ( int p=1 ; p <= 2 ; p++){
       String binaryNumber = "";
       String binaryValue ="";
        decimal = (int)(Math.random()*256);
  System.out.print("     Please enter the equivalent Binary number of " + decimal+ " : "); 
       binaryNumber = input.nextLine();
        int numberDecemal = decimal ;
        while (numberDecemal != 0 ) {
        binaryValue = (numberDecemal % 2) + binaryValue ;
        numberDecemal = numberDecemal / 2 ;
        }
  if (binaryNumber.equals(binaryValue)) {
        System.out.println("     Correct Answer ! ");
        score = score+2 ;

  } else {
  for ( int u = 0 ; u < 2 ; u++ ){
          System.out.println("     Wrong Answer ! ");
  System.out.print("     Please enter the equivalent Binary number of " + decimal+ " : "); 
        String binaryNum = input.nextLine();
    if ( binaryNum.equals(binaryValue)){
          System.out.println("     Correct Answer ! ");
          score = score+2 ;
          break ;
      }
  }
    if ( !(binaryNumber.equals(binaryValue))){
       System.out.println("	Sorry, you have exceeded the maximum number of trials for this question!");            
       System.exit(0);

}
  }
}


//...............................................................................................................  


 // from binary to the decimal : 
for ( int i=1 ; i <= 2 ; i++){
       String binDec = "" ;
       String binDecValue ="";
        decimal = (int)(Math.random()*256);
        int numberDec = decimal ;
        while (numberDec != 0 ) {
        binDecValue = (numberDec % 2) + binDecValue ;
        numberDec = numberDec / 2 ;
        }
  System.out.print("     Please enter the equivalent Decimal number of " + binDecValue + " : "); 
        binDec = input.nextLine();
        String binToDecimal = " " + decimal ;
        
  if (binDec.equals(binToDecimal)) {
        System.out.println("     Correct Answer ! ");
        score = score+2 ;

  } else {
  for ( int k = 0 ; k < 2 ; k++ ){
          System.out.println("     Wrong Answer ! ");
  System.out.print("     Please enter the equivalent Decimal number of " + binDecValue + " : "); 
        String binDec1 = input.nextLine();
    if ( binDec1.equals(binToDecimal)){
          System.out.println("     Correct Answer ! ");
          score = score+2 ;
          break ;
      }
  }
    if ( !(binDec.equals(binToDecimal))){
       System.out.println("	Sorry, you have exceeded the maximum number of trials for this question!");            
       System.exit(0);

}
  }
}
        long endIime  = System.currentTimeMillis(); 
 System.out.println("************************************");
        long testtime  = System.currentTimeMillis(); 
        long testTime1  = (endIime-startTime)/60000 ; 
        double precent = (score/16.0)*100 ;
        System.out.println("            Time taken to complete the quiz:" + testTime1);
        System.out.println("            Score is: " + precent);
        System.out.println("		Congratulations, you have passed!");
   	System.out.println("************************************");
//...............................................................................................................  

       

}
else if (choice==1) {
     System.out.println("Please enter 1 to re-take the quiz or 0 to exit:  ");
      choice = input.nextInt();
          
     int decimal = (int)(Math.random()*256);
   // from hexa to the decimal : 
  
for (int x =1 ; x <=2 ; x++) {
        String hexNumber = "";
        decimal = (int)(Math.random()*256);
        int number1 = decimal ;
        String h = " ";
        while (number1 >= 0 ) {
        int valueHexa = number1 / 16 ;
        number1 = number1 % 16 ;
  if (valueHexa < 16 && valueHexa >= 0) {
      number1 = (char) (valueHexa + '0');
         } 
  else { number1 = (char)(valueHexa-10 + 'A'); }
    hexNumber = number1 + hexNumber ;
    number1 = number1 / 16 ;
        }
    
  if (number1==decimal) {
          System.out.println("     Correct Answer ! ");
          score = score+2 ;
  } else {
  for ( int y = 0 ; y < 2 ; y++ ){
          System.out.println("     Wrong Answer ! ");
   System.out.print("Please enter the equivalent Decimal number of " + hexNumber.toUpperCase() +": ");
    int hexaNum2 = input.nextInt();
    input.nextLine();
    if ( hexaNum2 == decimal){
          System.out.println("     Correct Answer ! ");
          score = score+2 ;
          break ;
     }

  }
  
      if (!(number1==decimal)){
       System.out.println("	Sorry, you have exceeded the maximum number of trials for this question!");            
       System.exit(0);
   
      }
  }}
//...............................................................................................................    
 // from decimal to the hexa : 
for (int x =1 ; x <=2 ; x++) {
        String hexNumber = "";
        decimal = (int)(Math.random()*256);
        int numberDecemal = decimal ;
        while (numberDecemal != 0 ) {
        int valueHexa = numberDecemal / 16 ;
        char hexaChar ;
  if (valueHexa <= 9 && valueHexa >= 0) {
      hexaChar = (char) (valueHexa + '0');
         } 
  else { hexaChar = (char)(valueHexa-10 + 'A'); }
    hexNumber = hexaChar + hexNumber ;
    numberDecemal = numberDecemal / 16 ;
        }
    System.out.print("Please enter the equivalent Decimal number of " + hexNumber.toUpperCase() +": ");
    int hexaNum = input.nextInt();
    input.nextLine();
  if (hexaNum==decimal) {
          System.out.println("     Correct Answer ! ");
           score = score+2 ;
  } else {
  for ( int y = 0 ; y < 2 ; y++ ){
          System.out.println("     Wrong Answer ! ");
    System.out.print("Please enter the equivalent Decimal number of " + hexNumber.toUpperCase() +": ");
    int hexaNum2 = input.nextInt();
    input.nextLine();
    if ( hexaNum2 == decimal){
          System.out.println("     Correct Answer ! ");
          score = score+2 ;
          break ;
      }
  }
      if (!(hexaNum==decimal)){
       System.out.println("	Sorry, you have exceeded the maximum number of trials for this question!");            
       System.exit(0);
   
      }
  }}

//...............................................................................................................  

 // from decimal to the binary : 
for ( int p=1 ; p <= 2 ; p++){
       String binaryNumber = "";
       String binaryValue ="";
        decimal = (int)(Math.random()*256);
  System.out.print("     Please enter the equivalent Binary number of " + decimal+ " : "); 
       binaryNumber = input.nextLine();
        int numberDecemal = decimal ;
        while (numberDecemal != 0 ) {
        binaryValue = (numberDecemal % 2) + binaryValue ;
        numberDecemal = numberDecemal / 2 ;
        }
  if (binaryNumber.equals(binaryValue)) {
        System.out.println("     Correct Answer ! ");
        score = score+2 ;

  } else {
  for ( int u = 0 ; u < 2 ; u++ ){
          System.out.println("     Wrong Answer ! ");
  System.out.print("     Please enter the equivalent Binary number of " + decimal+ " : "); 
        String binaryNum = input.nextLine();
    if ( binaryNum.equals(binaryValue)){
          System.out.println("     Correct Answer ! ");
          score = score+2 ;
          break ;
      }
  }
    if ( !(binaryNumber.equals(binaryValue))){
       System.out.println("	Sorry, you have exceeded the maximum number of trials for this question!");            
       System.exit(0);

}
  }
}


//...............................................................................................................  


 // from binary to the decimal : 
for ( int i=1 ; i <= 2 ; i++){
       String binDec = "" ;
       String binDecValue ="";
        decimal = (int)(Math.random()*256);
        int numberDec = decimal ;
        while (numberDec != 0 ) {
        binDecValue = (numberDec % 2) + binDecValue ;
        numberDec = numberDec / 2 ;
        }
  System.out.print("     Please enter the equivalent Decimal number of " + binDecValue + " : "); 
        binDec = input.nextLine();
        String binToDecimal = " " + decimal ;
        
  if (binDec.equals(binToDecimal)) {
        System.out.println("     Correct Answer ! ");
        score = score+2 ;

  } else {
  for ( int k = 0 ; k < 2 ; k++ ){
          System.out.println("     Wrong Answer ! ");
  System.out.print("     Please enter the equivalent Decimal number of " + binDecValue + " : "); 
        String binDec1 = input.nextLine();
    if ( binDec1.equals(binToDecimal)){
          System.out.println("     Correct Answer ! ");
          score = score+2 ;
          break ;
      }
  }
    if ( !(binDec.equals(binToDecimal))){
       System.out.println("	Sorry, you have exceeded the maximum number of trials for this question!");            
       System.exit(0);

}
  }
}
        long endIime  = System.currentTimeMillis(); 
 System.out.println("************************************");
        long testtime  = System.currentTimeMillis(); 
        long testTime1  = (endIime-startTime)/60000 ; 
        double precent = (score/16.0)*100 ;
        System.out.println("            Time taken to complete the quiz:" + testTime1);
        System.out.println("            Score is: " + precent);
        System.out.println("		Congratulations, you have passed!");
   	System.out.println("************************************");
//...............................................................................................................  

             
    
    } 
else if (choice==0)
     System.out.println("		*** Thank you for using this Application ***"); 
        System.exit(0);
    
    }}}


    
    
    
     
          