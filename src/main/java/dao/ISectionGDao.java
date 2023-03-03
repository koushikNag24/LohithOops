package dao;

import jakarta.persistence.EntityManager;
import model.sections.sectiong.SectionG;

public interface ISectionGDao {
    void save(SectionG sectionG, EntityManager entityManager);

}
