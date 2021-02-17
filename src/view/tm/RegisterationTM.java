package view.tm;

import javafx.scene.control.Button;

public class RegisterationTM {
    String RegID;
    String RegFee;
    String RegDate;
    String StudentID;
    String ProgramID;
    Button btn;

    public RegisterationTM(String regID) {
        RegID = regID;
    }

    public RegisterationTM(String regID, String regFee, String regDate, String studentID, String programID, Button btn) {
        RegID = regID;
        RegFee = regFee;
        RegDate = regDate;
        StudentID = studentID;
        ProgramID = programID;
        this.btn = btn;
    }

    public String getRegID() {
        return RegID;
    }

    public void setRegID(String regID) {
        RegID = regID;
    }

    public String getRegFee() {
        return RegFee;
    }

    public void setRegFee(String regFee) {
        RegFee = regFee;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
        RegDate = regDate;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getProgramID() {
        return ProgramID;
    }

    public void setProgramID(String programID) {
        ProgramID = programID;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "RegisterationTM{" +
                "RegID='" + RegID + '\'' +
                ", RegFee='" + RegFee + '\'' +
                ", RegDate='" + RegDate + '\'' +
                ", StudentID='" + StudentID + '\'' +
                ", ProgramID='" + ProgramID + '\'' +
                ", btn=" + btn +
                '}';
    }
}
