package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import model.sections.sectionb.SectionB;
import org.apache.log4j.Logger;

 public class SectionBDao implements ISectionBDao{
    final static Logger logger = Logger.getLogger(SectionBDao.class);
    public void save(SectionB sectionB, EntityManager entityManager) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(sectionB);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        logger.info("saved: " + sectionB.getId());
    }
}
