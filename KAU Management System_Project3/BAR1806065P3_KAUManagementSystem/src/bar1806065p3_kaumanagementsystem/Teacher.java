// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
//Teacher Class
package bar1806065p3_kaumanagementsystem;

import java.util.*;

//The first subClass from Employee Class

public class Teacher extends Employee {

    private String degree;
    private String department;
    private double teachingHours;

    public Teacher(String degree, String department, double teachingHours, String jobTitle, int officeNumber, boolean onLeave, int id,
            String name, String nationality, Date dateOfBirth, char gender, int phone, String address) {
        super(jobTitle, officeNumber, onLeave, id, name, nationality, dateOfBirth, gender, phone, address);
        this.degree = degree;
        this.department = department;
        this.teachingHours = teachingHours;
    }

    public String getDegree() {
        return degree;

    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(double teachingHours) {
        this.teachingHours = teachingHours;
    }

    @Override
    public String toString() {
        return super.toString() + ", Degree: " + degree + ", Department: " + department + ",Teaching Hours : " + teachingHours;
    }
}
