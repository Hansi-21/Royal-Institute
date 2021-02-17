package dao.custom;

import dao.CrudDAO;
import dao.SuperDAO;
import entity.Registration;

public interface RegistrationDAO extends CrudDAO<Registration,String> {
    public String getRID()throws Exception;
}
