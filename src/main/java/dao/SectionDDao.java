package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.sections.base.BaseIssues;
import model.sections.sectiond.SchemacsHealth;
import model.sections.sectiond.SectionD;
import org.apache.log4j.Logger;

public class SectionDDao implements ISectionDDao{
    final static Logger logger = Logger.getLogger(SectionDDao.class);
    public void save(SectionD sectionD, EntityManager entityManager) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(sectionD);


            for (SchemacsHealth health : sectionD.getSchemacsHealths()) {
                entityManager.persist(health);
            }

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        logger.info("saved: " + sectionD.getId());
    }

}
