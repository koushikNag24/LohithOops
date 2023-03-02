//package dao;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityTransaction;
//
//
//import model.sections.sectione.SectionE;
//import model.sections.sectionf.SectionF;
//import org.apache.log4j.Logger;
//
//public class SectionFDao implements ISectionFDao{
//    final static Logger logger = Logger.getLogger(SectionFDao.class);
//    public void save(SectionF sectionF, EntityManager entityManager){
//        EntityTransaction tx = null;
//        try {
//            tx= entityManager.getTransaction();
//            tx.begin();
//
//            entityManager.persist(sectionF);
//            tx.commit();
//        }catch (RuntimeException e){
//            if(tx!=null){
//                tx.rollback();
//            }
//
//
//            throw e;
//        }
//        logger.info("saved  : "+sectionF.getId());
//    }
//
//
//}
