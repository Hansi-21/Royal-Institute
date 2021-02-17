package business.custom;

import business.SuperBO;
import dto.CourseDTO;
import dto.RegistrationDTO;

import java.util.List;

public interface RegistrationBO extends SuperBO {
    public boolean add(RegistrationDTO registrationDTO) throws Exception;
    public boolean update(RegistrationDTO registrationDTO) throws Exception;
    public boolean delete(String id)throws Exception;
    public List<RegistrationDTO> findAll() throws Exception;
    public RegistrationDTO get(String id) throws Exception;
    public String getRID()throws Exception;
}
