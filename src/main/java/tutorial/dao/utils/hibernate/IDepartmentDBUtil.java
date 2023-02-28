package tutorial.dao.utils.hibernate;

import jakarta.persistence.EntityManager;
import tutorial.dao.utils.jpahibernate.model.Department;
import tutorial.dao.utils.jpahibernate.model.Student;

import java.util.List;

public interface IDepartmentDBUtil {
    public void save(Department department);
    public List<Student> getStudents(Long[] ids, EntityManager entityManager);

}
