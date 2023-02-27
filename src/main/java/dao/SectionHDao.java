package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.sections.sectionh.SectionH;
import model.sections.sectionh.StnLookAngle;
import org.apache.log4j.Logger;

public class SectionHDao implements  ISectionHDao{
    final static Logger logger = Logger.getLogger(SectionHDao.class);
    public void save(SectionH sectionH, EntityManager entityManager){
        EntityTransaction tx = null;
        try {
            tx= entityManager.getTransaction();
            tx.begin();

            entityManager.persist(sectionH);

            for (StnLookAngle stnLookAngle : sectionH.getStnLookAngles()) {
                entityManager.persist(stnLookAngle);
            }
            tx.commit();
        }catch (RuntimeException e){
            if(tx!=null){
                tx.rollback();
            }


            throw e;
        }
        logger.info("saved  : "+sectionH.getId());
    }
}
