package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.sections.sectiona.SectionA;
import model.sections.sectiond.SchemacsHealth;
import model.sections.sectiond.SectionD;
import org.apache.log4j.Logger;

public class SectionADao implements ISectionADao{
    final static Logger logger = Logger.getLogger(SectionADao.class);
    public void save(SectionA sectionA, EntityManager entityManager) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(sectionA);



            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        logger.info("saved: " + sectionA.getId());
    }

}