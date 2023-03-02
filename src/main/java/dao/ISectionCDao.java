package dao;

import jakarta.persistence.EntityManager;

import model.sections.sectionc.SectionC;


public interface ISectionCDao {
    void save(SectionC sectionC, EntityManager entityManager);

}
