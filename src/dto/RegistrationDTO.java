package dto;

public class RegistrationDTO {
    private String RegID;
    private String RegFee;
    private String RegDate;
    private StudentDTO studentDTO;
    private CourseDTO courseDTO;

    public RegistrationDTO() {

    }

    public RegistrationDTO(String regID, String regFee, String regDate, StudentDTO studentDTO, CourseDTO courseDTO) {
        RegID = regID;
        RegFee = regFee;
        RegDate = regDate;
        this.studentDTO = studentDTO;
        this.courseDTO = courseDTO;
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

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "RegID='" + RegID + '\'' +
                ", RegFee='" + RegFee + '\'' +
                ", RegDate='" + RegDate + '\'' +
                ", studentDTO=" + studentDTO +
                ", courseDTO=" + courseDTO +
                '}';
    }
}
