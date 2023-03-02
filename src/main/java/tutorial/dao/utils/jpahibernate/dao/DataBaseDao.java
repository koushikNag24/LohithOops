package tutorial.dao.utils.jpahibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.apache.log4j.Logger;
import org.junit.Assert;
import tutorial.dao.utils.jpahibernate.model.AdharCard;
import tutorial.dao.utils.jpahibernate.model.Student;

import java.util.Set;

public class DataBaseDao implements IDataBaseDao {
    final static Logger logger = Logger.getLogger(Logger.class);
    @Override
    public Student fetchStudentById(EntityManagerFactory factory, Long id){
        EntityManager entityManager=null;
        EntityTransaction transaction=null;
        Student student=null;
        try{
            entityManager=factory.createEntityManager();
            transaction=entityManager.getTransaction();
            transaction.begin();
             student=entityManager.find(Student.class,id);
            transaction.commit();
        }catch (RuntimeException e){
            rollbackTransaction(transaction, e);
        }finally {
            cleanupEntityManager(entityManager);
        }
        return student;
    }
    @Override
    public Student fetchStudentViaQuery(EntityManagerFactory factory, Long id){

        EntityManager entityManager=null;
        EntityTransaction transaction=null;
        Student student=null;
        try{
            entityManager=factory.createEntityManager();
            transaction=entityManager.getTransaction();
            transaction.begin();
          student =  entityManager.createQuery(
                    "select s " +
                            "from Student s " +
                            "where s.id=:id",Student.class)
                      .setParameter("id",id)
                      .getSingleResult();

            transaction.commit();
        }catch (RuntimeException e){
            rollbackTransaction(transaction, e);
        }finally {
            cleanupEntityManager(entityManager);
        }
        return student;
    }

    @Override
    public int fetchStudentPocketMoney(EntityManagerFactory factory, Long id){

        EntityManager entityManager=null;
        EntityTransaction transaction=null;
        Integer pocketMoney=0;
        try{
            entityManager=factory.createEntityManager();
            transaction=entityManager.getTransaction();
            transaction.begin();
            pocketMoney =  entityManager.createQuery(
                            "select s.pocketMoney " +
                                    "from Student s " +
                                    "where s.id=:id",Integer.class)
                    .setParameter("id",id)
                    .getSingleResult();

            transaction.commit();
        }catch (RuntimeException e){
            rollbackTransaction(transaction, e);
        }finally {
            cleanupEntityManager(entityManager);
        }
        return pocketMoney;
    }

    @Override
    public Student fetchStudentAdharCard(EntityManagerFactory factory, Long id){

        EntityManager entityManager=null;
        EntityTransaction transaction=null;
        Student student=null;
        try{
            entityManager=factory.createEntityManager();
            transaction=entityManager.getTransaction();
            transaction.begin();
            student  =  entityManager.createQuery(
                            "select s " +
                             "from Student s " +
                             " left join fetch s.inActiveAdharCards "+
                              "where " +
                              "s.id=:id",Student.class)
                    .setParameter("id",id)
                    .getSingleResult();

            transaction.commit();
        }catch (RuntimeException e){
            rollbackTransaction(transaction, e);
        }finally {
            cleanupEntityManager(entityManager);
        }
        return student;
    }

    @Override
    public Student fetchStudentViaCriteria(EntityManagerFactory factory, Long id){

        EntityManager entityManager=null;
        EntityTransaction transaction=null;
        Student student=null;
        try{
            entityManager=factory.createEntityManager();
            transaction=entityManager.getTransaction();
            transaction.begin();
            CriteriaBuilder builder=entityManager.getCriteriaBuilder();
            CriteriaQuery<Student> query=builder.createQuery(Student.class);
            Root<Student> root= query.from(Student.class);
            root.fetch("inActiveAdharCards", JoinType.LEFT);
            query.select(root).where(
                    builder.and(
                            builder.equal(root.get("id"),id)
                    )
            );
             student=entityManager.createQuery(query).getSingleResult();
            transaction.commit();
        }catch (RuntimeException e){
            rollbackTransaction(transaction, e);
        }finally {
            cleanupEntityManager(entityManager);
        }
        return student;
    }


    @Override
    public void save(EntityManagerFactory factory, Student student){

        EntityManager entityManager=null;
        EntityTransaction transaction=null;

        try{
            entityManager=factory.createEntityManager();
            transaction=entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(student);
            transaction.commit();
        }catch (RuntimeException e){
            rollbackTransaction(transaction, e);
        }finally {
            cleanupEntityManager(entityManager);
        }
        return ;
    }


    @Override
    public void cleanupEntityManager(EntityManager entityManager) {
        if(entityManager !=null){
            entityManager.close();
        }

    }

    @Override
    public void rollbackTransaction(EntityTransaction transaction, RuntimeException e) {
        if(transaction !=null && transaction.isActive()){
            transaction.rollback();
            logger.error("Transaction rolled back");
            throw e;
        }
    }
}
