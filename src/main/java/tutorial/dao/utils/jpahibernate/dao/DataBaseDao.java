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

public class DataBaseDao {
    final static Logger logger = Logger.getLogger(Logger.class);
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
    public Student fetchStudentViaQuery(EntityManagerFactory factory,  Long id){

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

    public int fetchStudentPocketMoney(EntityManagerFactory factory,  Long id){

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

    public Student fetchStudentAdharCard(EntityManagerFactory factory,  Long id){

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

    public Student fetchStudentViaCriteria(EntityManagerFactory factory,  Long id){

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


    public void save(EntityManagerFactory factory,  Student student){

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


    private void cleanupEntityManager(EntityManager entityManager) {
        if(entityManager !=null){
            entityManager.close();
        }
    }

    private void rollbackTransaction(EntityTransaction transaction, RuntimeException e) {
        if(transaction !=null && transaction.isActive()){
            transaction.rollback();
            throw e;
        }
    }
}
