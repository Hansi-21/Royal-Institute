/*
package dao.custom.impl;

import dao.QuaryDAO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

public class QuaryDAOImpl implements QuaryDAO {

    @Override
    public String getLastestStudnetID() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT StudentID  FROM Student ORDER BY StudentID  DESC ");
        Student student = new Student();
        String studentID = student.getStudentID();

        transaction.commit();
        session.close();
        return studentID;
    }
}
*/
