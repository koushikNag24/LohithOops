package dao;

import jakarta.persistence.EntityManager;
import model.sections.base.BaseIssues;

public interface ISectionGDao {
    void save(BaseIssues sectionG, EntityManager entityManager);

}
