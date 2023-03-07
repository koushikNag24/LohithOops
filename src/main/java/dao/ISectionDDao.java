package dao;

import jakarta.persistence.EntityManager;
import model.sections.base.BaseIssues;
import model.sections.sectiond.SectionD;
import model.sections.sectionh.SectionH;

public interface ISectionDDao {
    void save(SectionD sectionD, EntityManager entityManager);

}
