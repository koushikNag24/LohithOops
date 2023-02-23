package tutorial.dao.utils.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tutorial.dao.utils.jpahibernate.model.DepartmentTable;

import java.util.TimeZone;

public class HibernateDB implements IDepartmentDBUtil {
    @Override
    public void save(DepartmentTable departmentTable) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session=sessionFactory.withOptions()
                .jdbcTimeZone( TimeZone.getTimeZone( "UTC" ) ).openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

           session.save(departmentTable);

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


}
