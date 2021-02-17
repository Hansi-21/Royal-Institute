package dao.custom.impl;


import dao.custom.RegistrationDAO;
import entity.Registration;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public boolean add(Registration registration) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(registration);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Registration registration) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(registration);

        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Registration registration = session.get(Registration.class, s);

        session.delete(registration);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Registration find(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Registration registration = session.get(Registration.class, s);
        transaction.commit();
        session.close();
        return registration;
    }

    @Override
    public List<Registration> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query register= session.createQuery("from Registration ");
        List <Registration> list = register.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String getRID() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT RegID FROM Registration ORDER BY RegID DESC ");
        String rst = (String) query.uniqueResult();
        transaction.commit();
        return rst;
    }
}
