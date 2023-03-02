package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.sections.sectiona.SectionA;
import model.sections.sectionc.SectionC;
import model.sections.sectiond.SchemacsHealth;
import model.sections.sectiond.SectionD;
import org.apache.log4j.Logger;

public class SectionCDao implements ISectionCDao{
    final static Logger logger = Logger.getLogger(SectionCDao.class);
    public void save(SectionC sectionC, EntityManager entityManager) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(sectionC);



            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }

    }

}