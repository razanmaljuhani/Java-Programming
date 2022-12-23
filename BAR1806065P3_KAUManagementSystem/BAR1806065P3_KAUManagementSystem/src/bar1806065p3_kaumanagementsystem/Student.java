// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
//Student Class
package bar1806065p3_kaumanagementsystem;

import java.util.*;

//The second subClass from Person Class
public class Student extends Person {

    private String department;
    private int semester;
    private double cgpa;
    private Teacher teacher;
    private Invigilator invigilator;
    private Course[] course;
    private CourseLab[] courseLab;
    private ExamVenue examVenue;
    private Date enrollDate;

    public Student(String department, int semester, double cgpa, Date enrollDate, int id,
            String name, String nationality, Date dateOfBirth, char gender, int phone, String address, int totCourse, int totCourseLab) {
        super(id, name, nationality, dateOfBirth, gender, phone, address);
        this.department = department;
        this.semester = semester;
        this.cgpa = cgpa;
        this.enrollDate = enrollDate;
        this.course = new Course[totCourse];
        this.courseLab = new CourseLab[totCourseLab];
    }

    public int getTotalCourseHrs() {
        return course.length;
    }

    public int getTotalCourseLabHrs() {
        return courseLab.length;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Invigilator getInvigilator() {
        return invigilator;
    }

    public void setInvigilator(Invigilator invigilator) {
        this.invigilator = invigilator;
    }

    public Course[] getCourse() {
        return course;
    }

    public void setCourse(Course[] course) {
        this.course = course;
    }

    public CourseLab[] getCourseLab() {
        return courseLab;
    }

    public void setCourseLab(CourseLab[] courseLab) {
        this.courseLab = courseLab;
    }

    public ExamVenue getExamVenue() {
        return examVenue;
    }

    public void setExamVenue(ExamVenue examVenue) {
        this.examVenue = examVenue;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

//Calculate The total Hours of Course & CorseLap
    public double calTotalHours() {
        double total = 0;
        for (CourseLab hrsCL : courseLab) {
            total += hrsCL.getHours();
        }
        for (Course hrsC : course) {
            total += hrsC.getHours();
        }
        return total;
    }

//This Method Print the informaion of all 25 Studunt 
    public String printStudentBasicInfo() {
        return "\n--------------- Welcome to KAU Management System ---------------\n"
                + "\n--------- Current Date : " + new Date().toString() + "--------"
                + "\nCommand: Print_Report"
                + "\n--- Student Detail are as Follows: ---"
                + this.toString()
                + "\n----------------------------------"
                + "--- Teacher Detail are as Follows: ---"
                + this.getTeacher().toString()
                + "\n----------------------------------"
                + "\n--- Invigilator Detail are as Follows: ---"
                + this.getInvigilator().toString()
                + "\n----------------------------------"
                + "\n------ Course Lab Details are as follows: ---"
                + Arrays.toString(getCourseLab())
                + "\n----------------------------------"
                + "\n------ Course Details are as follows: ---"
                + Arrays.toString(getCourse())
                + "\n----------------------------------"
                + "\n-----Exam Venue Details are as follows: "
                + this.getExamVenue().toString()
                + "\n----------Total Hours : " + this.calTotalHours() + "--------";
    }

    @Override
    public String toString() {
        return super.toString()
                + "----------------------------------------------------------------------------------------"
                + "\n, Department : " + department + ",Semester = " + semester
                + "\n\t, CGPA:        " + cgpa
                + "\n, Enrollment Date : " + enrollDate.toString();
    }
}
