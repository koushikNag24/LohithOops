//package dao;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityTransaction;
//
//import model.sections.sectionb.SectionB;
//import model.sections.sectione.SectionE;
//import org.apache.log4j.Logger;
//
//public class SectionEDao implements ISectionEDao{
//    final static Logger logger = Logger.getLogger(SectionEDao.class);
//    public void save(SectionE sectionE, EntityManager entityManager){
//        EntityTransaction tx = null;
//        try {
//            tx= entityManager.getTransaction();
//            tx.begin();
//
//            entityManager.persist(sectionE);
//            tx.commit();
//        }catch (RuntimeException e){
//            if(tx!=null){
//                tx.rollback();
//            }
//
//
//            throw e;
//        }
//        logger.info("saved  : "+sectionE.getId());
//    }
//
//
//}
