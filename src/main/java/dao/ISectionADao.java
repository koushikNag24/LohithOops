package dao;

import jakarta.persistence.EntityManager;
import model.sections.sectiona.SectionA;
import model.sections.sectiond.SectionD;

public interface ISectionADao {
    void save(SectionA sectionA, EntityManager entityManager);
}
