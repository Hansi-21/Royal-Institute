package view.tm;

import javafx.scene.control.Button;

public class CourseTM {
    String ProgramID;
    String Program;
    String Duration;
    String Fee;
    Button btn;

    public CourseTM() {
    }

    public CourseTM(String programID, String program, String duration, String fee, Button btn) {
        ProgramID = programID;
        Program = program;
        Duration = duration;
        Fee = fee;
        this.btn = btn;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "CourseTM{" +
                "ProgramID='" + ProgramID + '\'' +
                ", Program='" + Program + '\'' +
                ", Duration='" + Duration + '\'' +
                ", Fee='" + Fee + '\'' +
                ", btn=" + btn +
                '}';
    }
}
