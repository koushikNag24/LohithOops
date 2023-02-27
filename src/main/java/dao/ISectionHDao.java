package dao;

import jakarta.persistence.EntityManager;
import model.sections.base.BaseIssues;
import model.sections.sectionh.SectionH;

public interface ISectionHDao {
    void save(SectionH sectionH, EntityManager entityManager);

}
