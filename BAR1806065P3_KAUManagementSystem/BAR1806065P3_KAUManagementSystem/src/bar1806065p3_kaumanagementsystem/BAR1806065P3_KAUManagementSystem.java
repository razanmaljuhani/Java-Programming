/* Hi teatcher , I hope you'r alawys happy >> Here The solving of Assignment3 in Java language . 
The Date of Sending :  Sunday, 17-03-2019 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p3_kaumanagementsystem;

import java.io.*;
import java.util.*;

public class BAR1806065P3_KAUManagementSystem {

    public static void main(String args[]) throws Exception {

        File inputFile = new File("input.txt");

        //checking if the file exists :
        if (!(inputFile.exists())) {
            System.out.println("The File does not exists");
            System.exit(0);
        }
        Scanner fileScan = new Scanner(inputFile);
        PrintWriter StudentWrite = new PrintWriter("StudentWrite.txt");

        //Declearation  Arrays :
        Teacher teacher[];
        Invigilator[] invigilator;
        ExamVenue[] examV;
        CourseLab[] cLap;
        Course[] course;
        Student[] stu;
        //initializing Arrays : 
        teacher = new Teacher[fileScan.nextInt()];
        invigilator = new Invigilator[fileScan.nextInt()];
        examV = new ExamVenue[fileScan.nextInt()];
        cLap = new CourseLab[fileScan.nextInt()];
        course = new Course[fileScan.nextInt()];
        stu = new Student[fileScan.nextInt()];

        StudentWrite.println("--------------- Welcome to KAU Management System ---------------");
        int t = 0, I = 0, eV = 0, cL = 0, c = 0, st = 0;
        String command = "";
        while (fileScan.hasNext()) {
            command = fileScan.next();
            //Command: Quit
            if (command.equals("Quit")) {
                StudentWrite.println("Thank you for using KAU Management System, Good Bye!");
                break;
                //1.1 Command: Add_Teacher 
            } else if (command.equals("Add_Teacher")) {
                teacher[t] = getTeacher(fileScan);
                StudentWrite.println("Command Add_Teacher: Add a new doctor record in the System");
                StudentWrite.println(teacher[t].toString());
                StudentWrite.println("----------------------------------------------------------------");
                t++;
                //1.2 Command: Add_Invigilator
            } else if (command.equals("Add_Invigilator")) {
                invigilator[I] = getInvigilator(fileScan);
                StudentWrite.println("Command Add_Invigilator: Add a new invigilator record in the System");
                StudentWrite.println(invigilator[I].toString());
                StudentWrite.println("----------------------------------------------------------------");
                I++;
                //1.3 Command: Add_ ExamVenue
            } else if (command.equals("Add_ExamVenue")) {
                examV[eV] = getExamVenue(fileScan);
                StudentWrite.println("Command Add_ExamVenue: Add a new exam venue record in the System");
                StudentWrite.println(examV[eV].toString());
                StudentWrite.println("----------------------------------------------------------------");
                eV++;
                //1.4 Command: Add_CourseLab
            } else if (command.equals("Add_CourseLab")) {
                cLap[cL] = getCourseLab(fileScan);
                StudentWrite.println("Command Add_CourseLab: Add a new course lab record in the System");
                StudentWrite.println(cLap[cL].toString());
                StudentWrite.println("----------------------------------------------------------------");
                cL++;
                //1.5 Command: Add_ Course
            } else if (command.equals("Add_Course")) {
                course[c] = getCourseRecord(fileScan);
                StudentWrite.println("Command Add_Course: Add a new course record in the System");
                StudentWrite.println(course[c].toString());
                StudentWrite.println("----------------------------------------------------------------");
                c++;
                //1.6 Command: Add_Student
            } else if (command.equals("Add_Student")) {
                stu[st] = getStudentRecord(fileScan);
                StudentWrite.println("Command Add_Student: Add a new Student record in the System");
                StudentWrite.println(stu[st].toString());
                StudentWrite.println("----------------------------------------------------------------");
                st++;
                //1.7 Command: Assign_Teacher_Student
            } else if (command.equals("Assign_Teacher_Student")) {
                Assign_Teacher_Student(fileScan, stu, teacher, StudentWrite);
                //1.8 Command: Assign_ExamVenue_Student 
            } else if (command.equals("Assign_ExamVenue_Student")) {
                Assign_Examvenue_Student(fileScan, stu, examV, StudentWrite);
                //1.9 Command: Assign_Invigilator_Student 
            } else if (command.equals("Assign_Invigilator_Student")) {
                Assign_Invigilator_Student(fileScan, stu, invigilator, StudentWrite);
                //1.10 Command: Assign_CourseLab_Student 
            } else if (command.equals("Assign_CourseLab_Student")) {
                int stuID = fileScan.nextInt();
                //Add stuent
                for (int i = 0; i < stu.length; i++) {
                    if (stu[i].getId() == stuID) {
                        StudentWrite.println("Command Assign_CourseLab_Student: Successfully Processed by the System,Following are the details ");
                        StudentWrite.println("Student: " + stu[i].getName());
                        //Add courses to student
                        for (int j = 0; j < stu[i].getCourseLab().length; j++) {
                            stu[i].getCourseLab()[j] = SearchCourseLab(cLap, fileScan.nextInt());
                            StudentWrite.println(stu[i].getCourseLab()[j].toString());
                        }
                        StudentWrite.println("----------------------------------------------------------------");
                    }
                }
                //1.11 Command: Assign_Course_Student 
            } else if (command.equals("Assign_Course_Student")) {
                int stuID = fileScan.nextInt();
                //Add stuent
                for (int i = 0; i < stu.length; i++) {
                    if (stu[i].getId() == stuID) {
                        StudentWrite.println("Command Assign_Course_Student: Successfully Processed by the System,Following are the details : ");
                        StudentWrite.println("Student: " + stu[i].getName());
                        //Add courses to student
                        for (int j = 0; j < stu[i].getCourse().length; j++) {
                            stu[i].getCourse()[j] = SearchCourse(course, fileScan.nextInt());
                            StudentWrite.println(stu[i].getCourse()[j].toString());
                        }
                        StudentWrite.println("----------------------------------------------------------------");
                    }
                }
                //1.12 Command: Print_Report
            } else if (command.equals("Print_Report")) {
                for (int i = 0; i < stu.length; i++) {
                    File student = new File("AllReportsFor25Students/" + stu[i].getName().substring(0, 2) + "" + stu[i].getId() + "_Student_Report.txt");
                    PrintWriter report = new PrintWriter(student);
                    report.println(stu[i].printStudentBasicInfo());
                    report.close();
                }

            }
        }
        StudentWrite.close();
        fileScan.close();
    }

    //^-^ Method 1 Teacher info:
    private static Teacher getTeacher(Scanner input) {
        String degree = input.next();
        String department = input.next();
        double teachingHours = input.nextDouble();
        String jobTitle = input.next();
        int officeNumber = input.nextInt();
        boolean onLeave = input.nextBoolean();
        int id = input.nextInt();
        String name = input.next();
        String nationality = input.next();
//Date Info.
        int year = input.nextInt();
        int month = input.nextInt();
        int day = input.nextInt();
        Date dateT = new Date(year, month, day);

        char gender = input.next().charAt(0);
        int phone = input.nextInt();
        String adress = input.next();
//object
        Teacher tech = new Teacher(degree, department, teachingHours, jobTitle, officeNumber, onLeave, id, name, nationality, dateT, gender, phone, adress);
        return tech;
    }

    //^-^ Method 2 Invigilator info.
    private static Invigilator getInvigilator(Scanner input) {

        int invigilatorExperienceYears = input.nextInt();
        String invigilatorSkill = input.next();

        String jobTitle = input.next();
        int officeNumber = input.nextInt();
        boolean onLeave = input.nextBoolean();
        int id = input.nextInt();
        String name = input.next();
        String nationality = input.next();
//Date Info.
        int year = input.nextInt();
        int month = input.nextInt();
        int day = input.nextInt();
        Date dateI = new Date(year, month, day);

        char gender = input.next().charAt(0);
        int phone = input.nextInt();
        String adress = input.next();
//object
        Invigilator invigi = new Invigilator(invigilatorExperienceYears, invigilatorSkill, jobTitle, officeNumber, onLeave, id, name, nationality, dateI, gender, phone, adress);
        return invigi;
    }

    //^-^ Method 3 ExamVenue info.
    private static ExamVenue getExamVenue(Scanner input) {

        int examvenueNo = input.nextInt();
        String floor = input.next();
        int buildingNo = input.nextInt();
        //object
        ExamVenue examV = new ExamVenue(examvenueNo, floor, buildingNo);
        return examV;

    }

    //^-^ Method 4 CourseLab info.
    private static CourseLab getCourseLab(Scanner input) {

        int labID = input.nextInt();
        String labName = input.next();
        double hours = input.nextDouble();
        //object
        CourseLab cLap = new CourseLab(labID, labName, hours);
        return cLap;

    }

    //^-^ Method 5 Course info.
    private static Course getCourseRecord(Scanner input) {

        int courseCode = input.nextInt();
        String courseTitle = input.next();
        double hours = input.nextDouble();
        //object
        Course c = new Course(courseCode, courseTitle, hours);
        return c;

    }

    //^-^ Method 6 Student info. 
    private static Student getStudentRecord(Scanner input) {

        String dep = input.next();
        int sem = input.nextInt();
        double cgpa = input.nextDouble();
        //Date1 Info.
        int year1 = input.nextInt();
        int month1 = input.nextInt();
        int day1 = input.nextInt();
        Date date1 = new Date(year1, month1, day1);

        int id = input.nextInt();
        String name = input.next();
        String nationality = input.next();

//Date2 Info.
        int year2 = input.nextInt();
        int month2 = input.nextInt();
        int day2 = input.nextInt();
        Date date2 = new Date(year2, month2, day2);

        char gender = input.next().charAt(0);
        int phone = input.nextInt();
        String adress = input.next();

        int totCourse = input.nextInt();
        int totCourseLap = input.nextInt();
//object
        Student stu = new Student(dep, sem, cgpa, date1, id, name, nationality, date2, gender, phone, adress, totCourse, totCourseLap);
        return stu;
    }

    //^-^ Method 7 Assign_Teacher_Student :
    public static void Assign_Teacher_Student(Scanner input, Student[] stu, Teacher[] teach, PrintWriter print) {

        int teacherID = input.nextInt();
        int studentID = input.nextInt();

        //Method 1 return teacher info.
        Teacher teacher = SearchTeacher(teach, teacherID);
        //Method 2 return Student info.
        Student student = SearchStudent(stu, studentID);

        //Add teachers in thier student .
        student.setTeacher(teacher);
        print.println("Command Assign_Teacher_Student: Successfully Processed by the System,Following are the details  :");
        print.println("Student: " + student.getName());
        print.println("Assigned to Teacher: " + teacher.getName());
        print.println("----------------------------------------------------------------");
    }

    //^-^ Method 8 SearchTeacher :
    public static Teacher SearchTeacher(Teacher[] teach, int teacherID) {
        for (int i = 0; i < teach.length; i++) {
            if (teach[i].getId() == teacherID) {
                return teach[i];
            }
        }
        return null;
    }

    //^-^ Method 9 SearchStudent :
    public static Student SearchStudent(Student[] stu, int studentID) {
        for (int i = 0; i < stu.length; i++) {
            if (stu[i].getId() == studentID) {
                return stu[i];
            }
        }
        return null;
    }

    //^-^ Method 10 Assign_Examvenue_Student :
    public static void Assign_Examvenue_Student(Scanner input, Student[] stu, ExamVenue[] examV, PrintWriter print) {
        int examId = input.nextInt();
        int stuId = input.nextInt();
        ExamVenue examVenue = SearchExamVenue(examV, examId);
        Student student = SearchStudent(stu, stuId);
        student.setExamVenue(examVenue);

        print.println("Command Assign_ExamVenue_Student: Successfully Processed by the System,Following are the details : ");
        print.println("Student: " + student.getName());
        print.println("Assigned ExamVenue: Exam Venue Details are as follows: " + examVenue.toString());
        print.println("----------------------------------------------------------------");
    }

    //^-^ Method 11 SearchExamVenue :
    public static ExamVenue SearchExamVenue(ExamVenue[] examV, int examVID) {
        for (int i = 0; i < examV.length; i++) {
            if (examV[i].getRoomNo() == examVID) {
                return examV[i];
            }
        }
        return null;
    }

    //^-^ Method 12 Assign_Invigilator_Student :
    public static void Assign_Invigilator_Student(Scanner input, Student[] stu, Invigilator[] invigi, PrintWriter print) {

        int invigilatorID = input.nextInt();
        int studentID = input.nextInt();

        Invigilator invigilator = SearchInvigilator(invigi, invigilatorID);
        Student student = SearchStudent(stu, studentID);

        student.setInvigilator(invigilator);

        print.println("Command Assign_Invigilator_Student: Successfully Processed by the System,Following are the details        : ");
        print.println("Student: " + student.getName());
        print.println("Assigned to Invigilator: " + invigilator.getName());
        print.println("----------------------------------------------------------------");

    }

    //^-^ Method 13 SearchInvigilator :
    public static Invigilator SearchInvigilator(Invigilator[] invigi, int invigiID) {
        for (int i = 0; i < invigi.length; i++) {
            if (invigi[i].getId() == invigiID) {
                return invigi[i];
            }
        }
        return null;

    }

    //^-^ Method 14 SearchCourseLab :
    public static CourseLab SearchCourseLab(CourseLab[] cLab, int courseLapID) {

        for (int i = 0; i < cLab.length; i++) {
            if (cLab[i].getLabID() == courseLapID) {
                return cLab[i];
            }
        }
        return null;
    }

    //^-^ Method 15 SearchCourse :
    public static Course SearchCourse(Course[] course, int courseID) {

        for (int i = 0; i < course.length; i++) {
            if (course[i].getCourseCode() == courseID) {
                return course[i];
            }
        }
        return null;
    }

    //^-^ Method 16  print_Report :
    private static void print_Report(Student stud, File file) throws FileNotFoundException {

    }
}
