package tutorial.dao.utils.jpahibernate;

import jakarta.persistence.EntityManager;
import tutorial.dao.utils.jpahibernate.model.Department;

public interface IJpaHibernateUtil {
    void save(Department department, EntityManager entityManager);

    void remove(Department department1);
}
