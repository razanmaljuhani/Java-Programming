/* Hi teatcher , I hope you'r alawys happy >> Here The solving of Assignment5 in Java language . 
The Date of Sending :  Sunday, 7-04-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar_1806065_p5_bookbanksystem;

import java.io.*;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class BookBank extends javax.swing.JFrame {

    static ArrayList<Borrower> borrowers = new ArrayList<>();

    //########################AddBook################################
    private static void AddBook(Scanner input, PrintWriter output, ArrayList<Materials> materials) {

        Book b = new Book(input.next(), input.next(), input.next(), input.nextInt(), input.nextInt(), input.nextInt());
        materials.add(b);
        output.println("***************************************");
        output.println("COMMAND: Add_Book");
        //output.println("***************************************");
        output.println("Success: " + "\r\n" + b);
    }

    //########################Add Tape################################
    private static void AddTape(Scanner input, PrintWriter output, ArrayList<Materials> materials) {
        String title = input.next();
        int year = input.nextInt();

        Tapes t = new Tapes(title, year);
        materials.add(t);
        output.println("***************************************");
        output.println("COMMAND: Add_Tape");
        //output.println("***************************************");
        output.println("Success: " + t + "\n");
    }

    //########################Add Article################################
    private static void addArticle(Scanner input, PrintWriter output, ArrayList<Materials> materials) {
        String title = input.next();
        String author = input.next();
        int volume = input.nextInt();
        String pages = input.next();
        String journalName = input.next();

        Article j = new Article(title, author, volume, pages, journalName);
        materials.add(j);
        output.println("***************************************");
        output.println("COMMAND: Add_Article");
        //output.println("***************************************");
        output.println("Success: " + j + "\n");

    }

    //########################Add Student################################
    private static void addStudent(Scanner input, PrintWriter output, ArrayList<Materials> materials) throws MaterialNotFoundException {
        output.println("***************************************");
        output.println("COMMAND: Add_borrower_Student");
        // TODO 
        // Complete the method as per the description in the given specification file 
        int studentID = input.nextInt();
        String studentName = input.next();
        char studentGender = input.next().charAt(0);
        int studentPhone = input.nextInt();
        String studentMajor = input.next();
        String materialsTypes = input.next();
        int nDays = input.nextInt();

        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getTitle().equals(materialsTypes)) {

                //Book Type :
                if (materials.get(i) instanceof Book) {
                    if (materials.get(i).isAvailable()) {
                        Student studentObj = new Student(studentID, studentName, studentGender, studentPhone, studentMajor, (Book) materials.get(i), nDays);
                        materials.get(i).borrow();
                        materials.get(i).addNewBorrower(studentObj);
                        borrowers.add(studentObj);
                        output.println(materials.get(i).getTitle() + " book is found! The remaining number of Copies "
                                + ((Book) materials.get(i)).getNoOfCopies());
                        output.println("Success: " + studentObj.BorrowerInfo(materialsTypes));
                        return; //stop loop
                    } else if (!(materials.get(i).isAvailable())) {
                        output.println(" Error: " + materials.get(i).getTitle() + " is Not avaliable!");
                        return; //stop loop
                    }
                }

                //Article Type :
                if (materials.get(i) instanceof Article) {
                    if (materials.get(i).isAvailable()) {
                        Student studentObj = new Student(studentID, studentName, studentGender, studentPhone, studentMajor, (Article) materials.get(i), nDays);
                        materials.get(i).borrow();
                        materials.get(i).addNewBorrower(studentObj);
                        borrowers.add(studentObj);
                        output.println(materials.get(i).getTitle() + " Article is found!");
                        output.println("Success: " + studentObj.BorrowerInfo(materialsTypes));
                        return;
                    } else if (!(materials.get(i).isAvailable())) {
                        output.println(" Error: " + materials.get(i).getTitle() + " is Not avaliable!");
                        return;
                    }
                }
                //Tapes Type :
                if (materials.get(i) instanceof Tapes) {
                    if (materials.get(i).isAvailable()) {
                        Student st = new Student(studentID, studentName, studentGender, studentPhone, studentMajor, (Tapes) materials.get(i), nDays);
                        materials.get(i).borrow();
                        materials.get(i).addNewBorrower(st);
                        borrowers.add(st);
                        output.println(materials.get(i).getTitle() + " Tape is found!");
                        output.println("Success: " + st.BorrowerInfo(materialsTypes));
                        return;
                    } else if (!(materials.get(i).isAvailable())) {
                        output.println(" Error: " + materials.get(i).getTitle() + " is Not avaliable!");
                        return;
                    }
                }
            }
            throw new MaterialNotFoundException(materialsTypes);
        }
    }
    //########################Add Staff################################

    private static void addStaff(Scanner input, PrintWriter output, ArrayList<Materials> materials) throws MaterialNotFoundException {
        output.println("***************************************");
        output.println("COMMAND: Add_Borrower_Staff");

        // TODO 
        // Complete the method as per the description in the given specification file 
        int StID = input.nextInt();
        String Sname = input.next();
        char Sgender = input.next().charAt(0);
        int Sphone = input.nextInt();
        String Sjob = input.next();
        String Mtitle = input.next();

        int nDays = input.nextInt();

        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getTitle().equals(Mtitle)) {
                if (materials.get(i) instanceof Book) {
                    if (!materials.get(i).isAvailable()) {
                        output.println(" Error: " + materials.get(i).getTitle() + " is Not avaliable!");
                        return;
                    } else {
                        Staff st = new Staff(StID, Sname, Sgender, Sphone, Sjob, (Book) materials.get(i), nDays);
                        materials.get(i).borrow();
                        materials.get(i).addNewBorrower(st);
                        borrowers.add(st);

                        output.println(materials.get(i).getTitle() + " book is found! The remaining number of Copies " + ((Book) materials.get(i)).getNoOfCopies());
                        output.println("Success: " + st.BorrowerInfo(Mtitle));
                        return;
                    }
                }
                if (materials.get(i) instanceof Article) {
                    if (!materials.get(i).isAvailable()) {
                        output.println(" Error: " + materials.get(i).getTitle() + " is Not avaliable!");
                        return;
                    }
                    Staff st = new Staff(StID, Sname, Sgender, Sphone, Sjob, (Article) materials.get(i), nDays);
                    materials.get(i).borrow();
                    materials.get(i).addNewBorrower(st);
                    borrowers.add(st);
                    output.println(materials.get(i).getTitle() + " Article is found!");
                    output.println("Success: " + st.BorrowerInfo(Mtitle));
                    return;
                }

                if (materials.get(i) instanceof Tapes) {
                    if (!materials.get(i).isAvailable()) {

                        output.println(" Error: " + materials.get(i).getTitle() + " is Not avaliable!");
                        return;
                    }
                    Staff st = new Staff(StID, Sname, Sgender, Sphone, Sjob, (Tapes) materials.get(i), nDays);
                    materials.get(i).borrow();
                    materials.get(i).addNewBorrower(st);

                    borrowers.add(st);

                    output.println(materials.get(i).getTitle() + " Tape is found!");
                    output.println("Success: " + st.BorrowerInfo(Mtitle));

                    return;
                }
            }
        }
        throw new MaterialNotFoundException(Mtitle);
    }
//######################## check Status ################################

    private static void checkStatus(Scanner input, PrintWriter output, ArrayList<Materials> materials) throws MaterialNotFoundException {
        output.println("***************************************");
        output.println("COMMAND: Check_Item_Status");
        // TODO 
        // Complete the method as per the description in the given specification file 
        String Mtitle = input.next();
        for (int i = 0; i < materials.size(); i++) {

            if (materials.get(i).getTitle().equals(Mtitle)) {

                if (materials.get(i) instanceof Book) {
                    if (((Book) materials.get(i)).isAvailable() == false) {
                        output.println("Error: " + materials.get(i).getTitle()
                                + " book is Not found! No more availabe Copies!");
                        materials.get(i).getItemOwners(output);
                        output.println();
                        return;
                    } else {
                        output.println("Success: " + materials.get(i).getTitle()
                                + " book is found! The remaining number of Copies " + ((Book) materials.get(i)).getNoOfCopies());
                        materials.get(i).getItemOwners(output);
                        output.println();
                        return;
                    }
                }

                if (materials.get(i) instanceof Article) {
                    if (((Article) materials.get(i)).isAvailable() == false) {
                        output.println("Error: " + materials.get(i).getTitle() + " Article is Borrowed!");
                        materials.get(i).getItemOwners(output);
                        output.println();

                        return;

                    } else {
                        output.println("Success: " + materials.get(i).getTitle() + " Article is found!");
                        output.println();
                        return;
                    }
                }
                if (materials.get(i) instanceof Tapes) {
                    if (((Tapes) materials.get(i)).isAvailable() == false) {
                        output.println("Error: " + materials.get(i).getTitle() + " Tape is Not found!");
                        materials.get(i).getItemOwners(output);
                        output.println();
                        return;

                    } else {
                        output.println("Success: " + materials.get(i).getTitle() + " Tape is found!");
                        output.println();
                        return;
                    }
                }

            }
        }
        throw new MaterialNotFoundException(Mtitle);
    }

    //######################## Display Books  ################################
    private static void displayBooks(PrintWriter outputReport, ArrayList<Materials> materials) {
        outputReport.println("***************************************");
        outputReport.println("COMMAND: Display_Available_Books");
        outputReport.println("***************************************");
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i) instanceof Book) {
                if (((Book) materials.get(i)).isAvailable()) {
                    outputReport.println(((Book) materials.get(i)) + "\n");
                    outputReport.println("-------------------");
                }
            }
        }
    }
    //######################## Display Tapes  ################################

    private static void displayTapes(PrintWriter outputReport, ArrayList<Materials> materials) {
        outputReport.println("***************************************");
        outputReport.println("COMMAND: Display_Available_Tapes");

        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i) instanceof Tapes) {
                if (((Tapes) materials.get(i)).isAvailable()) {

                    outputReport.println(((Tapes) materials.get(i)) + "\n");
                    outputReport.println("-------------------");
                }
            }
        }
    }
//########################Diplay Articles################################

    private static void displayArticles(PrintWriter outputReport, ArrayList<Materials> materials) {
        outputReport.println("***************************************");
        outputReport.println("COMMAND: Display_Available_Article");

        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i) instanceof Article) {
                if (((Article) materials.get(i)).isAvailable()) {

                    outputReport.println(((Article) materials.get(i)) + "\n");
                    outputReport.println("-------------------");
                }
            }
        }
    }
//########################Diplay Borrowed Books################################

    private static void displayBorrowedBooks(PrintWriter outputReport, ArrayList<Materials> materials) {
        outputReport.println("***************************************");
        outputReport.println("COMMAND: Display_Borrowed_Books:");

        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i) instanceof Book) {
                if (((Book) materials.get(i)).isAvailable() == false) {
                    outputReport.print("Book \" " + materials.get(i).getTitle() + " \" ");
                    materials.get(i).getItemOwners(outputReport);
                    outputReport.println();
                }
            }
        }
    }
//########################Diplay Borrowed Tapes################################

    private static void displayBorrowedTapes(PrintWriter outputReport, ArrayList<Materials> materials) {
        outputReport.println("***************************************");
        outputReport.println("COMMAND: Display_Borrowed_Tapes:");

        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i) instanceof Tapes) {
                if (((Tapes) materials.get(i)).isAvailable() == false) {
                    outputReport.print("Tape \" " + materials.get(i).getTitle() + " \" ");
                    materials.get(i).getItemOwners(outputReport);
                    outputReport.println();
                }
            }
        }
    }
    //######################## Display Borrowed Article  ################################

    private static void displayBorrowedArticle(PrintWriter outputReport, ArrayList<Materials> materials) {
        outputReport.println("***************************************");
        outputReport.println("COMMAND: Display_Borrowed_Article:");

        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i) instanceof Article) {
                if (((Article) materials.get(i)).isAvailable() == false) {
                    outputReport.print("Article \" " + materials.get(i).getTitle() + " \" ");
                    materials.get(i).getItemOwners(outputReport);
                    outputReport.println();
                }
            }
        }
    }
    //######################## Display Fees  ################################

    private static void displayFees(PrintWriter outputReport) {
        // TODO 
        // Complete the method as per the description in the given specification file 
        outputReport.println("***************************************");
        outputReport.println("COMMAND: Display_Fees:");
        for (int i = 0; i < borrowers.size(); i++) {
            if (borrowers.get(i).getFees() > 0) {
                outputReport.println("Total fees for " + borrowers.get(i).getName()
                        + " should pay " + borrowers.get(i).getFees());
            } else {
                outputReport.println("the borrower " + borrowers.get(i).getName()
                        + " does not have any fees to pay  . ");
            }
        }
    }
    //######################## Return Item  ################################

    private static void ReturnItem(Scanner input, PrintWriter output, ArrayList<Materials> materials) {
        // TODO 
        // Complete the method as per the description in the given specification file 
        output.println("***************************************");
        output.println("COMMAND: Return_Item:");

        int stID = input.nextInt();
        String Mtitle = input.next();
        int Bdur = input.nextInt();

        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getTitle().equals(Mtitle)) {
                materials.get(i).ReturnItem(output, stID, Bdur);

                for (int j = 0; j < borrowers.size(); j++) {
                    if (borrowers.get(j).getId() == stID) {
                        borrowers.get(j).setActualBorrowDuration(Bdur);
                    }

                }
                if (materials.get(i) instanceof Book) {
                    ((Book) materials.get(i)).increaseNoOfCopies();
                }
                return;
            }
        }
    }

    /**
     * Creates new form MainForm
     */
    public BookBank() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbSearch = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        jbSearch1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextName = new javax.swing.JTextField();
        jTextFee = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Bank Management System");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("Welcome to Book Bank System");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Borrower Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 51, 51))); // NOI18N

        jTextID.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Borrower ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addGap(38, 38, 38)
                                .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 51, 51))); // NOI18N

        jbSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbSearch.setText("Search");
        jbSearch.setToolTipText("Click to search record from the file!");
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        jbExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbExit.setText("Exit");
        jbExit.setToolTipText("Click to Exit from the program!");
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

        jbSearch1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbSearch1.setText("Clear");
        jbSearch1.setToolTipText("Click to search record from the file!");
        jbSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearch1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbSearch)
                                        .addComponent(jbExit)
                                        .addComponent(jbSearch1))
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fee Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setText("Borrower Name");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("Requiered Fee");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFee, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(138, 138, 138)
                                                .addComponent(jLabel1)))
                                .addGap(0, 44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Item Search");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jbExitActionPerformed

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed
// TODO 
// Complete the method as per the description in the given specification file 
        int BID = Integer.parseInt(jTextID.getText());
        for (int i = 0; i < borrowers.size(); i++) {
            if (borrowers.get(i).getId() == BID) {
                jTextName.setText(borrowers.get(i).getName());
                jTextFee.setText(String.valueOf(borrowers.get(i).getFees()));
                return;
            }

        }
        JOptionPane.showMessageDialog(null,
                "Borrower Not found",
                "Warning!",
                JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jbSearchActionPerformed

    private void jbSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearch1ActionPerformed
// TODO 
// Complete the method as per the description in the given specification file 
        jTextID.setText("");
        jTextName.setText("");
        jTextFee.setText("");

    }//GEN-LAST:event_jbSearch1ActionPerformed
//______________________________________________________
//##################Main Method############################
//______________________________________________________

    public static void main(String args[]) throws Exception {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }
        //</editor-fold>
        // OPEN FILES
        // Input File:
        File inputFile = new File("in.txt");// reading data 
        if (!inputFile.exists()) {
            System.out.println("Input file, " + inputFile + ", does not exist.");
            System.exit(0);
        }
        File outputFile = new File("output.txt");// file pointer to Write file
        PrintWriter output = new PrintWriter(outputFile); // creating Object to write data in file

        File outputFileReport = new File("report.txt");// file pointer to Write file
        PrintWriter outputReport = new PrintWriter(outputFileReport); // creating Object to write data in file
        // Make Scanner for input 
        Scanner input = new Scanner(inputFile);
        String command;
//creating the arrays
        ArrayList<Materials> materials = new ArrayList<>();

        output.println("*** Welcome to Book Bank System ***\r\n");

        do {

            command = input.next();
            try {

                if (command.equalsIgnoreCase("Add_Book")) {

                    AddBook(input, output, materials);

                } else if (command.equalsIgnoreCase("Add_Tape")) {
                    AddTape(input, output, materials);

                } else if (command.equalsIgnoreCase("Add_Article")) {
                    addArticle(input, output, materials);

                } else if (command.equalsIgnoreCase("Add_borrower_Student")) {
                    addStudent(input, output, materials);

                } else if (command.equalsIgnoreCase("Add_Borrower_Staff_member")) {
                    addStaff(input, output, materials);

                } else if (command.equalsIgnoreCase("Check_Item_Status")) {
                    checkStatus(input, output, materials);

                } else if (command.equalsIgnoreCase("Display_Available_Books")) {
                    Collections.sort(materials);
                    displayBooks(outputReport, materials);

                } else if (command.equalsIgnoreCase("Display_Available_Tapes")) {
                    displayTapes(outputReport, materials);

                } else if (command.equalsIgnoreCase("Display_Available_Article")) {
                    displayArticles(outputReport, materials);

                } else if (command.equalsIgnoreCase("Display_Borrowed_Books")) {
                    displayBorrowedBooks(outputReport, materials);

                } else if (command.equalsIgnoreCase("Display_Borrowed_Tapes")) {
                    displayBorrowedTapes(outputReport, materials);

                } else if (command.equalsIgnoreCase("Display_Borrowed_Article")) {
                    displayBorrowedArticle(outputReport, materials);

                } else if (command.equalsIgnoreCase("Display_Fees")) {
                    displayFees(outputReport);

                } else if (command.equalsIgnoreCase("Return_Item")) {
                    ReturnItem(input, output, materials);
                }

            } catch (Exception ex) {
                output.println(ex);
            }
        } while (!command.equalsIgnoreCase("Quit"));//end while

        input.close();
        output.close();
        outputReport.close();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookBank().setVisible(true);
            }
        });
    }//end main

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFee;
    private javax.swing.JTextField jTextID;
    private javax.swing.JTextField jTextName;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbSearch;
    private javax.swing.JButton jbSearch1;
    // End of variables declaration//GEN-END:variables
}
