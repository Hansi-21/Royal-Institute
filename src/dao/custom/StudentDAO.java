package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import dto.StudentDTO;
import entity.Student;

public interface StudentDAO extends CrudDAO<Student,String> {
}
