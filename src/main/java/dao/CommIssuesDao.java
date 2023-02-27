package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.sections.sectiona.CommunicationIssue;
import org.apache.log4j.Logger;

 public class CommIssuesDao implements ICommIssuesDao{
    final static Logger logger = Logger.getLogger(CommIssuesDao.class);
    public void save(CommunicationIssue communicationIssue, EntityManager entityManager) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(communicationIssue);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        logger.info("saved: " + communicationIssue.getId());
    }
}
