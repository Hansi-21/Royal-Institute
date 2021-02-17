package business.custom.impl;

import business.custom.CourseBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.CourseDAOImpl;
import dto.CourseDTO;
import entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {

    CourseDAOImpl courseDAO= DAOFactory.getInstance().getDAO(DAOType.Course);

    @Override
    public boolean add(CourseDTO courseDTO) throws Exception {
        return courseDAO.add(new Course(
                courseDTO.getProgramID(),
                courseDTO.getProgram(),
                courseDTO.getDuration(),
                courseDTO.getFee()
        ));
    }

    @Override
    public boolean update(CourseDTO courseDTO) throws Exception {
        return courseDAO.update(new Course(
                courseDTO.getProgramID(),
                courseDTO.getProgram(),
                courseDTO.getDuration(),
                courseDTO.getFee()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return courseDAO.delete(id);
    }

    @Override
    public List<CourseDTO> findAll() throws Exception {
        List<Course> all = courseDAO.findAll();
        ArrayList<CourseDTO> dtoList = new ArrayList<>();

        CourseDTO courseDTO=null;

        for (Course course:all) {
            dtoList.add(new CourseDTO(
                    course.getProgramID(),
                    course.getProgram(),
                    course.getDuration(),
                    course.getFee()
            ));
        }
        return dtoList;
    }

    @Override
    public CourseDTO get(String id) throws Exception {
        Course course = courseDAO.find(id);
        return new CourseDTO(
                course.getProgramID(),
                course.getProgram(),
                course.getDuration(),
                course.getFee()
                );
    }
}
