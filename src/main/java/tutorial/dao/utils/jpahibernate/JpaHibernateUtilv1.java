package tutorial.dao.utils.jpahibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.apache.log4j.Logger;
import tutorial.dao.utils.jpahibernate.model.DepartmentTable;
import tutorial.dao.utils.jpahibernate.model.inheritance.BaseHealthNew;

public class JpaHibernateUtilv1 implements IJpaHibernateUtil {
    final static Logger logger = Logger.getLogger(JpaHibernateUtilv1.class);
    @Override
    public void save(DepartmentTable departmentTable, EntityManager entityManager){


        EntityTransaction tx = null;
        try {
            tx= entityManager.getTransaction();
            tx.begin();

            entityManager.persist(departmentTable);
            tx.commit();
        }catch (RuntimeException e){
            if(tx!=null){
                tx.rollback();
            }
            logger.error("department : "+ departmentTable.getName());
            throw e;
        }
    }

    public void remove(DepartmentTable departmentTable1) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        DepartmentTable d = entityManager.find(DepartmentTable.class, 2);
        entityManager.remove(d);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

    }
    @Override
    public void saveTest(BaseHealthNew baseHealthNew, EntityManager entityManager){


        EntityTransaction tx = null;
        try {
            tx= entityManager.getTransaction();
            tx.begin();

            entityManager.persist(baseHealthNew);
            tx.commit();
        }catch (RuntimeException e){
            if(tx!=null){
                tx.rollback();
            }
            logger.error("baseHealthNew : "+baseHealthNew.getName());
            throw e;
        }
    }
}
