package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.NavicPerformanceDetails;
import org.apache.log4j.Logger;

public class NavicPerformanceDao implements INavicPerformanceDao {

    final static Logger logger = Logger.getLogger(NavicPerformanceDao.class);
    public void save(NavicPerformanceDetails navicPerformanceDetails, EntityManager entityManager){
        EntityTransaction tx = null;
        try {
            tx= entityManager.getTransaction();
            tx.begin();

            entityManager.persist(navicPerformanceDetails);

            tx.commit();
        }catch (RuntimeException e){
            if(tx!=null){
                tx.rollback();
            }


            throw e;
        }
        logger.info("saved  : "+navicPerformanceDetails.getId());
    }
}
