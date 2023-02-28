package dao;

import jakarta.persistence.EntityManager;
import model.sections.sectiona.CommunicationIssue;
import model.sections.sectionb.SectionB;


public interface ISectionBDao {
     void save(SectionB sectionB, EntityManager entityManager);

}
