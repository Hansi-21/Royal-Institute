package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Course implements SuperEntity{
    @Id
    private String ProgramID;
    private String Program;
    private String Duration;
    private String Fee;
    @OneToMany(mappedBy="ProgramID",cascade= CascadeType.ALL)
    private List<Registration>registrations;

    public Course() {
    }

    public Course(String programID, String program, String duration, String fee) {
        ProgramID = programID;
        Program = program;
        Duration = duration;
        Fee = fee;
    }

    public String getProgramID() {
        return ProgramID;
    }

    public void setProgramID(String programID) {
        ProgramID = programID;
    }

    public String getProgram() {
        return Program;
    }

    public void setProgram(String program) {
        Program = program;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getFee() {
        return Fee;
    }

    public void setFee(String fee) {
        Fee = fee;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ProgramID='" + ProgramID + '\'' +
                ", Program='" + Program + '\'' +
                ", Duration='" + Duration + '\'' +
                ", Fee='" + Fee + '\'' +
                '}';
    }
}
