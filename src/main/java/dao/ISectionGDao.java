package dao;

import jakarta.persistence.EntityManager;
import model.sections.base.BaseIssues;
import tutorial.dao.utils.jpahibernate.model.Department;
import tutorial.dao.utils.jpahibernate.model.inheritance.BaseHealthNew;

public interface ISectionGDao {
    void save(BaseIssues sectionG, EntityManager entityManager);

}
