package entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registration implements SuperEntity{
    @Id
    private String RegID;
    private String RegFee;
    private String RegDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Student StudentID;
    @ManyToOne(fetch = FetchType.LAZY)
    private Course ProgramID;

    public Registration() {

    }

    public Registration(String regID, String regFee, String regDate, Student studentID, Course programID) {
        RegID = regID;
        RegFee = regFee;
        RegDate = regDate;
        StudentID = studentID;
        ProgramID = programID;
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

    public Student getStudentID() {
        return StudentID;
    }

    public void setStudentID(Student studentID) {
        StudentID = studentID;
    }

    public Course getProgramID() {
        return ProgramID;
    }

    public void setProgramID(Course programID) {
        ProgramID = programID;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "RegID='" + RegID + '\'' +
                ", RegFee='" + RegFee + '\'' +
                ", RegDate='" + RegDate + '\'' +
                ", StudentID=" + StudentID +
                ", ProgramID=" + ProgramID +
                '}';
    }
}
