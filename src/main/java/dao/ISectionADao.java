package dao;

import jakarta.persistence.EntityManager;
import model.sections.sectiona.SectionA;

public interface ISectionADao {
    void save(SectionA sectionA, EntityManager entityManager);
}
