package business.custom;

import business.SuperBO;
import dto.CourseDTO;
import dto.StudentDTO;

import java.util.List;

public interface CourseBO extends SuperBO {
    public boolean add(CourseDTO courseDTO) throws Exception;
    public boolean update(CourseDTO courseDTO) throws Exception;
    public boolean delete(String id)throws Exception;
    public List<CourseDTO> findAll() throws Exception;
    public CourseDTO get(String id) throws Exception;
}
