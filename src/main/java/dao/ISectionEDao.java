package dao;

import jakarta.persistence.EntityManager;
import model.sections.sectionb.SectionB;
import model.sections.sectione.SectionE;


public interface ISectionEDao {
    void save(SectionE sectionE, EntityManager entityManager);

}
