package business.custom.impl;

import business.custom.StudentBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAOImpl studentDAO= DAOFactory.getInstance().getDAO(DAOType.Student);

    @Override
    public boolean add(StudentDTO studentDTO) throws Exception {
        return studentDAO.add(new Student(
                studentDTO.getStudentID(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getAge()
        ));
    }

    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(
                studentDTO.getStudentID(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getAge()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public List<StudentDTO> findAll() throws Exception {
        List<Student> all = studentDAO.findAll();
        ArrayList<StudentDTO> dtoList = new ArrayList<>();

        StudentDTO studentDTO=null;

        for (Student student:all) {
            dtoList.add(new StudentDTO(
                    student.getStudentID(),
                    student.getName(),
                    student.getAddress(),
                    student.getAge()
            ));
        }
        return dtoList;
    }

    @Override
    public StudentDTO get(String id) throws Exception {
        Student student = studentDAO.find(id);
        return new StudentDTO(
                student.getStudentID(),
                student.getName(),
                student.getAddress(),
                student.getAge()
                );
    }
}
