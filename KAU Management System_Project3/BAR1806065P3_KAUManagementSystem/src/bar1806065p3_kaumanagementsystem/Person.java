// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
//Person Class
package bar1806065p3_kaumanagementsystem;

import java.util.*;

//The Super Class

public class Person {

    private int id;
    private String name;
    private String nationality;
    private Date dateOfBirth;
    private char gender;
    private int phone;
    private String address;

    public Person(int id, String name, String nationality, Date dateOfBirth, char gender, int phone, String address) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDateOfBirth(Date dateOfBirthYear) {
        return dateOfBirthYear;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;

    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        String date = dateOfBirth.getYear() + "-" + dateOfBirth.getMonth() + "-" + dateOfBirth.getDate();
        return "ID : " + id + ", Name : " + name + ", Nationality : " + nationality + ", Date Of Birth :" + date + ", Gender:        "
                + gender + "        , Phone:        " + phone + "        , Address: " + address;
    }
}
