package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student implements SuperEntity{
    @Id
    private String StudentID;
    private String Name;
    private String Address;
    private String Age;

    public Student() {

    }

    public Student(String studentID, String name, String address, String age) {
        StudentID = studentID;
        Name = name;
        Address = address;
        Age = age;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentID='" + StudentID + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Age='" + Age + '\'' +
                '}';
    }
}
