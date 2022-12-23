// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
//Courselab Class
package bar1806065p3_kaumanagementsystem;

public class CourseLab {

    private int labID;
    private String labName;
    private double hours;

    public CourseLab(int labID, String labName, double hours) {
        this.labID = labID;
        this.labName = labName;
        this.hours = hours;
    }

    public int getLabID() {
        return labID;
    }

    public void setLabID(int labID) {
        this.labID = labID;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    
    public String toString() {
        return "Labe Code : " + labID + ", Lab Name : " + labName + ", Credit Hour : " + hours;
    }

}
