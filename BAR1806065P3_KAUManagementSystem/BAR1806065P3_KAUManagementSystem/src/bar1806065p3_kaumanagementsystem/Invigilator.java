// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
//Invigilator Class
package bar1806065p3_kaumanagementsystem;

import java.util.*;

//The second subClass from Employee Class
public class Invigilator extends Employee {

    private int invigilatorExperienceYears;
    private String invigilatorSkill;

    public Invigilator(int invigilatorExperienceYears, String invigilatorSkill, String jobTitle, int officeNumber, boolean onLeave,
            int id, String name, String nationality, Date dateOfBirth, char gender, int phone, String address) {
        super(jobTitle, officeNumber, onLeave, id, name, nationality, dateOfBirth, gender, phone, address);
        this.invigilatorExperienceYears = invigilatorExperienceYears;
        this.invigilatorSkill = invigilatorSkill;
    }

    public int getInvigilatorExperienceYears() {
        return invigilatorExperienceYears;
    }

    public void setInvigilatorExperienceYears(int invigilatorExperienceYears) {
        this.invigilatorExperienceYears = invigilatorExperienceYears;
    }

    public String getInvigilatorSkill() {
        return invigilatorSkill;
    }

    public void setInvigilatorSkill(String invigilatorSkill) {
        this.invigilatorSkill = invigilatorSkill;
    }

    @Override
    public String toString() {
        return super.toString() + ", Year(s) of Invigilaton Experience: " + invigilatorExperienceYears + ", Invigilaton Expertise: " + invigilatorSkill;
    }
}
