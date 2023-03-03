package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.sections.sectiong.SectionG;
import org.apache.log4j.Logger;

public class SectionGDao implements ISectionGDao{
    final static Logger logger = Logger.getLogger(SectionGDao.class);
    public void save(SectionG sectionG, EntityManager entityManager){
        EntityTransaction tx = null;
        try {
            tx= entityManager.getTransaction();
            tx.begin();

            entityManager.persist(sectionG);
            tx.commit();
        }catch (RuntimeException e){
            if(tx!=null){
                tx.rollback();
            }


            throw e;
        }
        logger.info("saved  : "+sectionG.getId());
    }
}
