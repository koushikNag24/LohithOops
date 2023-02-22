package tutorial.dao.utils.jpahibernate;

import jakarta.persistence.EntityManager;
import tutorial.dao.utils.jpahibernate.model.Department;
import tutorial.dao.utils.jpahibernate.model.inheritance.BaseHealthNew;

public interface IJpaHibernateUtil {
    void save(Department department, EntityManager entityManager);
    void saveTest(BaseHealthNew department, EntityManager entityManager);

    void remove(Department department1);
}
