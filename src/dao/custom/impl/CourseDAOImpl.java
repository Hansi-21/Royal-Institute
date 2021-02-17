package dao.custom.impl;

import dao.custom.CourseDAO;
import entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;


public class CourseDAOImpl implements CourseDAO {

    @Override
    public boolean add(Course course) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(course);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Course course) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(course);

        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class, s);

        session.delete(course);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Course find(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class, s);
        transaction.commit();
        session.close();
        return course;
    }

    @Override
    public List<Course> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query from_course_ = session.createQuery("from Course ");
        List <Course> list = from_course_.list();

        transaction.commit();
        session.close();
        return list;
    }
}
