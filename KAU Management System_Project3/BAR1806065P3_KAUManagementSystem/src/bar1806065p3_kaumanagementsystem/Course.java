// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
//Course Class
package bar1806065p3_kaumanagementsystem;

public class Course {

    private int courseCode;
    private String courseTitle;
    private double hours;

    public Course(int courseCode, String courseTitle, double hours) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.hours = hours;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Course Code : " + courseCode + ", Course Title : " + courseTitle + ", Credit Hours :" + hours;
    }
}
