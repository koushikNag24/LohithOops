package tutorial.dao.utils.jpahibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import tutorial.dao.utils.jpahibernate.model.Student;

public interface IDataBaseDao {
    Student fetchStudentById(EntityManagerFactory factory, Long id);

    Student fetchStudentViaQuery(EntityManagerFactory factory, Long id);

    int fetchStudentPocketMoney(EntityManagerFactory factory, Long id);

    Student fetchStudentAdharCard(EntityManagerFactory factory, Long id);

    Student fetchStudentViaCriteria(EntityManagerFactory factory, Long id);

    void save(EntityManagerFactory factory, Student student);

    void cleanupEntityManager(EntityManager entityManager);

    void rollbackTransaction(EntityTransaction transaction, RuntimeException e);
}
