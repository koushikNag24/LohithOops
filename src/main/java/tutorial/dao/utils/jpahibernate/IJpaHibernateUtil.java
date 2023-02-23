package tutorial.dao.utils.jpahibernate;

import jakarta.persistence.EntityManager;
import tutorial.dao.utils.jpahibernate.model.DepartmentTable;
import tutorial.dao.utils.jpahibernate.model.inheritance.BaseHealthNew;

public interface IJpaHibernateUtil {
    void save(DepartmentTable departmentTable, EntityManager entityManager);
    void saveTest(BaseHealthNew department, EntityManager entityManager);

    void remove(DepartmentTable departmentTable1);
}
