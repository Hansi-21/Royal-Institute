package view.tm;

import javafx.scene.control.Button;

public class StudentTM {
    String StudentID;
    String Name;
    String Address;
    String Age;
    Button btn;

    public StudentTM() {
    }

    public StudentTM(String studentID, String name, String address, String age, Button btn) {
        StudentID = studentID;
        Name = name;
        Address = address;
        Age = age;
        this.btn = btn;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "StudentID='" + StudentID + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Age='" + Age + '\'' +
                ", btn=" + btn +
                '}';
    }
}
