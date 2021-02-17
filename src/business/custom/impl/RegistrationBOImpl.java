package business.custom.impl;

import business.custom.RegistrationBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.RegistrationDAOImpl;
import dto.CourseDTO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import entity.Course;
import entity.Registration;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {

    RegistrationDAOImpl registrationDAO= DAOFactory.getInstance().getDAO(DAOType.Registration);



    @Override
    public boolean add(RegistrationDTO registrationDTO) throws Exception {

        StudentDTO studentDTO = registrationDTO.getStudentDTO();

        Student student = new Student(
                studentDTO.getStudentID(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getAge()
        );
        CourseDTO courseDTO= registrationDTO.getCourseDTO();

        Course course = new Course(
                courseDTO.getProgramID(),
                courseDTO.getProgram(),
                courseDTO.getDuration(),
                courseDTO.getFee()
        );

        return registrationDAO.add(new Registration(
           registrationDTO.getRegID(),
           registrationDTO.getRegFee(),
           registrationDTO.getRegDate(),
           student,
           course
        ));
    }

    @Override
    public boolean update(RegistrationDTO registrationDTO) throws Exception {
        return registrationDAO.update(new Registration(
               /* registrationDTO.getRegID(),
                registrationDTO.getRegFee(),
                registrationDTO.getRegDate(),
                registrationDTO.getStudentID(),
                registrationDTO.getProgramID()*/
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return registrationDAO.delete(id);
    }

    @Override
    public List<RegistrationDTO> findAll() throws Exception {
        List<Registration> all = registrationDAO.findAll();
        List<RegistrationDTO> regDTOS=new ArrayList<>();
        for (Registration registration:all) {

            Student student=registration.getStudentID();
            Course course=registration.getProgramID();

            StudentDTO studentDTO=new StudentDTO(
                    student.getStudentID(),
                    student.getName(),
                    student.getAddress(),
                   student.getAge()
            );

            CourseDTO courseDTO=new CourseDTO(
                    course.getProgramID(),
                    course.getProgram(),
                    course.getFee(),
                    course.getDuration()
            );

            regDTOS.add(new RegistrationDTO(
                    registration.getRegID(),
                    registration.getRegFee(),
                    registration.getRegFee(),
                    studentDTO,
                    courseDTO
            ));
        }
        return regDTOS;
    }

    @Override
    public RegistrationDTO get(String id) throws Exception {
       return null;

    }

    @Override
    public String getRID() throws Exception {
        String rid = registrationDAO.getRID();
        if(rid==null){
            return "R1";
        }

        else{
            int newID=Integer.parseInt(rid.substring(1,4)) +1;
            return "R" + newID;
        }
    }
}
