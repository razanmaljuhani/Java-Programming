/* Hi teatcher , I hope you'r alawys happy >> Here The solving of assignment1 in Java language . 
The Date of Sending :  Sunday, 10-02-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package project_1_razan_aljohani_1806065;

import java.util.*;
import java.io.*;

public class Project_1_Razan_Aljohani_1806065 {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        File fileInput = new File("input.txt");
        Scanner fileScan = new Scanner(fileInput);
        //checking if the file exists :
        if (!(fileInput.exists())) {
            System.out.println("The File does not exists");
            System.exit(0);
        }
        PrintWriter filePrint = new PrintWriter("print.txt");

        // create 1 D city  array  - 3 city 
        String[] city = new String[fileScan.nextInt()];

        //create 2 D branches array  
        String[][] branches = new String[city.length][];
        //storing num of col. in each 3 rows - 6 col. , 5 col. and 3 col. .
        for (int i = 0; i < branches.length; i++) {
            branches[i] = new String[fileScan.nextInt()];
        }
        //create 1 D  month array - 12 month 
        String[] month = new String[fileScan.nextInt()];

        //create 3 D sales array 
        int[][][] sales = new int[city.length][][];
        //3 cities , 14 branches and 12 months 
        for (int i = 0; i < sales.length; i++) {
            sales[i] = new int[branches[i].length][month.length];
        }

        //Start The Storing Info. in Print.txt File
        filePrint.println("	Welcome to Toyota Sales Analysis App!");
        filePrint.println("");
        //COMMAND1: ADD_CITY
        if (fileScan.next().equals("Add_City")) {
            city = readingCityName(fileScan, city);

            filePrint.println("COMMAND: ADD_CITY");
            filePrint.println("***Following City names are recorded in the system - Toyota Car Sale App - ***");
            filePrint.println("");
            filePrint.println(" City Names: ");
            for (int i = 0; i < city.length; i++) {
                filePrint.print("        " + city[i].toUpperCase() + "  ");
            }
            filePrint.println("");
            filePrint.println("-------------------------------------------------------------------------------------------------------");
            filePrint.println("");
        }
        //COMMAND2: ADD_BRANCH
        if (fileScan.next().equals("Add_City_Branch")) {
            branches = readingCityBranches(fileScan, branches);

            filePrint.println("COMMAND: ADD_BRANCH");
            filePrint.println("***Following branch names are recorded in the system  - Toyota Sales Analysis App - ***");
            filePrint.println("");
            for (int i = 0; i < branches.length; i++) {
                filePrint.println(city[i].toUpperCase());
                for (int j = 0; j < branches[i].length; j++) {
                    filePrint.print("    " + branches[i][j].toUpperCase());
                }
                filePrint.println();
            }
            filePrint.println("");
            filePrint.println("-------------------------------------------------------------------------------------------------------");
            filePrint.println("");
        }
        //COMMAND3: ADD_MONTH
        if (fileScan.next().equals("Add_Month")) {
            month = readingMonthName(fileScan, month);

            filePrint.println("COMMAND: ADD_MONTH");
            filePrint.println("***Following month names are recorded in the system - Toyota Sales Analysis App - ***");
            filePrint.println("");
            filePrint.println(" Month Names: ");
            for (int i = 0; i < month.length; i++) {
                filePrint.print(month[i].toUpperCase() + ",  ");
            }
            filePrint.println("");
            filePrint.println("-------------------------------------------------------------------------------------------------------");
            filePrint.println("");
        }
        //COMMAND4: ADD_SALES
        if (fileScan.next().equals("Add_Sales")) {
            sales = readingSales(fileScan, sales);

            filePrint.println("COMMAND: ADD_SALES");
            filePrint.println("***Following Sales Figures are recorded in the system - Toyota Sales Analysis App - ***");
            filePrint.println("");
            filePrint.println("-------------------------------------------------------------------------------------------------------");
            filePrint.println("");
            for (int i = 0; i < sales.length; i++) {
                filePrint.println("***For the City : " + city[i] + "***");
                filePrint.println("");
                for (int j = 0; j < sales[i].length; j++) {
                    filePrint.println("Branch( " + branches[i][j] + " )");
                    for (int k = 0; k < sales[i][j].length; k++) {
                        filePrint.println("\tMonth\t(\t" + month[k] + ") :  \t" + sales[i][j][k]);
                    }
                }
                filePrint.println("-------------------------------------------------------------------------------------------------------");
                filePrint.println("");
            }
        }
        //COMMAND5 : PRINT_TOTAL_SALES_BRANCH
        if (fileScan.next().equals("Print_Total_Sales_Branch")) {
            filePrint.println("");
            filePrint.println("COMMAND: PRINT_TOTAL_SALES_BRANCH");
            filePrint.println("***Following is  Total Sales Figures based on branches recorded in the system - Toyota Sales Analysis App - ***");
            filePrint.println("");
            filePrint.println("-------------------------------------------------------------------------------------------------------");
            totalSalesBranches(filePrint, sales, branches, city);
        }
        //COMMAND6 : PRINT_TOTAL_SALES_MONTH
        if (fileScan.next().equals("Print_Total_Sales_Month")) {
            filePrint.println("");
            filePrint.println("");
            filePrint.println("COMMAND: PRINT_TOTAL_SALES_MONTH");
            filePrint.println("***Following is Monthly Sales Figures recorded in the system - Toyota Sales Analysis App - ***");
            filePrint.println("-------------------------------------------------------------------------------------------------------");
            filePrint.println("");
            totalSalesMonth(filePrint, sales, month, city);
        }
        //COMMAND7 : PRINT_MAX_SALE_BRANCH
        if (fileScan.next().equals("Print_Max_Sale_Branch")) {
            filePrint.println("");
            filePrint.println("");
            filePrint.println("COMMAND: PRINT_MAX_SALE_BRANCH");
            filePrint.println("***Following Max Sales Figures for Branches recorded in the system - Toyota Sales Analysis App - ***");
            filePrint.println("-------------------------------------------------------------------------------------------------------");
            filePrint.println("");
            maxSalesBranches(filePrint, sales, branches, month, city);
        }
        //COMMAND8 : PRINT_MAX_SALE_MONTH
        if (fileScan.next().equals("Print_Max_Sale_Month")) {
            filePrint.println("");
            filePrint.println("");
            filePrint.println("COMMAND: PRINT_MAX_SALE_MONTH");
            filePrint.println("***Following Max Sales Figures for Months recorded in the system - Toyota Sales Analysis App - ***");
            filePrint.println("-------------------------------------------------------------------------------------------------------");
            filePrint.println("");
            maxSalesMonth(filePrint, sales, branches, month, city);
        }
        //COMMAND9 : PRINT_AVERAGE_SALES_BRANCH
        if (fileScan.next().equals("Print_Average_Sales_Branch")) {
            filePrint.println("");
            filePrint.println("");
            filePrint.println("COMMAND: PRINT_AVERAGE_SALES_BRANCH");
            filePrint.println("***Following Average Sales Figures based on Branches  recorded in the system - Toyota Sales Analysis App - ***");
            filePrint.println("");
            filePrint.println("-------------------------------------------------------------------------------------------------------");
            filePrint.println("");
            average1(filePrint, sales, branches, city);
        }
        //COMMAND10 : PRINT_AVERAGE_SALES_MONTH
        if (fileScan.next().equals("Print_Average_Sales_Month")) {
            filePrint.println("");
            filePrint.println("");
            filePrint.println("COMMAND: PRINT_AVERAGE_SALES_MONTH");
            filePrint.println("***Following Average Sales Figures based on Months  recorded in the system - Toyota Sales Analysis App - ***");
            filePrint.println("-------------------------------------------------------------------------------------------------------");
            filePrint.println("");
            average2(filePrint, sales, month, city);
        }
        if (fileScan.next().equals("Quit")) {
            filePrint.println("");
            filePrint.println("Thank you for using Toyota Sales Analysis App, Good Bye!");
        }
        fileScan.close();
        filePrint.close();
    }
    //Method 1 - must be Static because the main is Static , it is return city name .

    public static String[] readingCityName(Scanner file, String[] city) {
        for (int i = 0; i < city.length; i++) {
            city[i] = file.next();
        }
        return city;
    }

    //Method 2  - return the branches names of each city .
    public static String[][] readingCityBranches(Scanner file, String[][] city) {
        for (int row = 0; row < city.length; row++) {
            for (int col = 0; col < city[row].length; col++) {
                city[row][col] = file.next();
            }
        }
        return city;
    }

    //Method 3  - return the month name . 
    public static String[] readingMonthName(Scanner file, String[] city) {
        for (int i = 0; i < city.length; i++) {
            city[i] = file.next();
        }
        return city;
    }

    //Method 4  - return sales of each branch .
    public static int[][][] readingSales(Scanner file, int[][][] city) {
        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city[i].length; j++) {
                for (int k = 0; k < city[i][j].length; k++) {
                    city[i][j][k] = file.nextInt();
                }
            }
        }
        return city;
    }

    //Method 5  - print the total of sales in each 3 cities to each branches .
    public static void totalSalesBranches(PrintWriter filePrint, int[][][] sales, String[][] branches, String[] city) {
        int sumBranches;
        for (int i = 0; i < sales.length; i++) {
            filePrint.println("***Total Sales Figures For the City : " + city[i] + "***");
            filePrint.println("");
            for (int j = 0; j < sales[i].length; j++) {
                sumBranches = 0;
                for (int k = 0; k < sales[i][j].length; k++) {
                    sumBranches += sales[i][j][k];
                }
                filePrint.println(" \t\t\t" + branches[i][j] + ":\t\t" + sumBranches + " SR");
            }
            filePrint.println("-------------------------------------------------------------------------------------------------------");
        }
    }

    //Method 6  - print the total of sales in each 3 cities to each month .
    public static void totalSalesMonth(PrintWriter filePrint, int[][][] sales, String[] month, String[] city) {
        int sumMonths;
        //Summing colume by colume :
        for (int i = 0; i < sales.length; i++) {
            filePrint.println("");
            filePrint.println("Total Sales Figures For the City : " + city[i]);
            filePrint.println("");
            for (int col = 0; col < month.length; col++) {
                sumMonths = 0;
                for (int j = 0; j < sales[i].length; j++) {
                    sumMonths += sales[i][j][col];
                }
                filePrint.println("\t\t\tMonth :\t " + month[col] + "  : \t (" + sumMonths + " SR)");
            }
            filePrint.println("-------------------------------------------------------------------------------------------------------");
        }
    }

    //Method 7  - print the max of sales in each 3 cities to each branches .
    public static void maxSalesBranches(PrintWriter filePrint, int[][][] sales, String[][] branches, String[] month, String[] city) {
        int maxBranches;
        int maxMonth;
        for (int i = 0; i < sales.length; i++) {
            filePrint.println("Max Sales Figures For the City : " + city[i]);
            filePrint.println("");
            for (int j = 0; j < sales[i].length; j++) {
                maxBranches = sales[i][j][0];
                maxMonth = 0;
                for (int k = 0; k < sales[i][j].length; k++) {
                    if (sales[i][j][k] > maxBranches) {
                        maxBranches = sales[i][j][k];
                        maxMonth = k;
                    }
                }
                filePrint.println("");
                filePrint.println(" \t\t" + branches[i][j] + ":\t\t (" + maxBranches + " SR) for the month " + "    \t" + month[maxMonth].toUpperCase());
            }
            filePrint.println("-------------------------------------------------------------------------------------------------------");
        }
    }

    //Method 8  - print the max of sales in each 3 cities to each month .
    public static void maxSalesMonth(PrintWriter filePrint, int[][][] sales, String[][] branches, String[] month, String[] city) {
        int maxMonths;
        int maxBranches;
        //Summing colume by colume :
        for (int i = 0; i < sales.length; i++) {
            filePrint.println("");
            filePrint.println("Max Sales Figures For the City : " + city[i]);
            filePrint.println("");
            for (int k = 0; k < month.length; k++) {
                maxMonths = sales[i][0][0];
                maxBranches = 0;
                for (int j = 0; j < sales[i].length; j++) {
                    if (sales[i][j][k] > maxMonths) {
                        maxMonths = sales[i][j][k];
                        maxBranches = j;
                    }
                }
                filePrint.println("\t Month :\t " + month[k] + "     \t( " + maxMonths + " SR )" + " for the branch \t \t" + branches[i][maxBranches].toUpperCase());
            }
            filePrint.println("-------------------------------------------------------------------------------------------------------");
        }
    }

    //Method 9  - print the Average of sales in each 3 cities to each branches .
    public static void average1(PrintWriter filePrint, int[][][] sales, String[][] branches, String[] city) {
        float sumBranches;
        float average1;
        for (int i = 0; i < sales.length; i++) {
            filePrint.println("***Average Sales Figures For the City : " + city[i] + "***");
            filePrint.println("");
            for (int j = 0; j < sales[i].length; j++) {
                sumBranches = 0;
                average1 = 0;
                for (int k = 0; k < sales[i][j].length; k++) {
                    sumBranches += sales[i][j][k];

                }
                average1 = sumBranches / sales[i][j].length;
                filePrint.printf("\tBranch :%25s  (%.2f SR)\r\n ", branches[i][j], average1);

            }
            filePrint.println("-------------------------------------------------------------------------------------------------------");
        }
    }

    //Method 10  - print the average of sales in each 3 cities to each month .
    public static void average2(PrintWriter filePrint, int[][][] sales, String[] month, String[] city) {
        float sumMonths;
        float average2;
        //Summing colume by colume :
        for (int i = 0; i < sales.length; i++) {
            filePrint.println("Total Average Sales Figures For the City : " + city[i]);
            filePrint.println("");
            for (int col = 0; col < month.length; col++) {
                sumMonths = 0;
                average2 = 0;
                for (int j = 0; j < sales[i].length; j++) {
                    sumMonths += sales[i][j][col];
                }
                average2 = sumMonths / sales[i].length;
                filePrint.printf("\tMonth : %14s    (%.2f SR)\r\n", month[col], average2);
            }
            filePrint.println("-------------------------------------------------------------------------------------------------------");
        }
    }
}
