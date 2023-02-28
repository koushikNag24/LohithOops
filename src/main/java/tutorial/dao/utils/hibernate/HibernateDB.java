package tutorial.dao.utils.hibernate;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tutorial.dao.utils.jpahibernate.model.Department;
import tutorial.dao.utils.jpahibernate.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class HibernateDB implements IDepartmentDBUtil {
    @Override
    public void save(Department department) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session=sessionFactory.withOptions()
                .jdbcTimeZone( TimeZone.getTimeZone( "UTC" ) ).openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

           session.save(department);

            tx.commit();
        }

        catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            session.close();
        }

    }
    public List<Student> getStudents(Long[] ids,EntityManager entityManager){

        Session session=entityManager.unwrap(Session.class);
        Transaction tx = null;
        List<Student> students=new ArrayList<>();
        try {
            tx = session.beginTransaction();

            students= session.byMultipleIds(Student.class)
                    .multiLoad(ids);

            tx.commit();
        }

        catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            session.close();
        }
    return students;
    }


}
