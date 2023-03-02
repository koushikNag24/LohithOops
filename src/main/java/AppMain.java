import com.github.javafaker.Faker;
import jakarta.persistence.*;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import tutorial.dao.utils.hibernate.HibernateDB;
import tutorial.dao.utils.hibernate.IDepartmentDBUtil;
import tutorial.dao.utils.jpahibernate.IJpaHibernateUtil;
import tutorial.dao.utils.jpahibernate.JpaHibernateUtilv1;
import tutorial.dao.utils.jpahibernate.dao.CriteriaDao;
import tutorial.dao.utils.jpahibernate.dao.DataBaseDao;
import tutorial.dao.utils.jpahibernate.exception.ArgumentNullException;
import tutorial.dao.utils.jpahibernate.exception.NoMeasurementException;
import tutorial.dao.utils.jpahibernate.model.*;
import tutorial.dao.utils.jpahibernate.model.wrapper.StudentWrapper;
import tutorial.dao.utils.jpahibernate.service.DepartmentService;
import tutorial.dao.utils.jpahibernate.service.SectionService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AppMain {

    final static Logger logger = Logger.getLogger(AppMain.class);
    public static void main(String[] args) {

        Faker faker=new Faker();
        DepartmentService departmentService=new DepartmentService();

        IJpaHibernateUtil jpaHibernateUtil = new JpaHibernateUtilv1();
        DataBaseDao dao=new DataBaseDao();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_JPA");
    /*    String[] cityState= departmentService.getStateCity().split("_");
        String city=cityState[1];
        String state=cityState[0];
        Student student = new Student(faker.harryPotter().character(), city, state, faker.pokemon().name() + "@" + faker.animal().name() + ".com", faker.number().numberBetween(500, 100));
        for(int i=0;i<2;i++){
            Vehicle vehicle=new Vehicle();
            vehicle.setColor(faker.color().name());
            vehicle.setCost(new BigDecimal(faker.commerce().price()));
            student.addVehicle(vehicle);
        }
        dao.save(factory,student); */

      /*  EntityManager entityManager = factory.createEntityManager();
        for(int i = 1; i< 3; i++) {
            Department department = departmentService.getDepartment(faker);

            for (int j = 0; j < 3; j++) {
                String[] cityState= departmentService.getStateCity().split("_");
                String city=cityState[1];
                String state=cityState[0];
                Student student = new Student(faker.harryPotter().character(), city, state, faker.pokemon().name() + "@" + faker.animal().name() + ".com", faker.number().numberBetween(500, 100));
                AdharCard adharCard=departmentService.getAdharCard();
                if(adharCard.isActive()){
                    student.addActiveAdharCard(adharCard);
                }else{
                    student.addInActiveAdharCard(adharCard);
                }

                for(int p=0;p< 2;p++){
                    Course course=new Course();
                    course.setName(faker.app().name());
                    student.addCourse(course);
                }
                department.addStudent(student);
            }
            jpaHibernateUtil.save(department,entityManager);
            logger.info(" saved "+department.toString()+ "-- "+i);
        }

        entityManager.close();*/

//        EntityManager entityManager2 = factory.createEntityManager();
      /*  EntityTransaction   entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        Department department=entityManager.find(Department.class,1L);
        Set<Student> students  = department.getStudents();
        try {

            SectionService.GuardCollectionAgainstNullEmpty(students);
        } catch (NoMeasurementException | ArgumentNullException e) {
            throw new RuntimeException(e);
        }
        entityTransaction.commit();

        EntityManager entityManager1=factory.createEntityManager();
        EntityTransaction   entityTransaction2=entityManager1.getTransaction();
        entityTransaction2.begin();
       Student student=entityManager1.find(Student.class,1L);
        logger.info("removing "+student.toString());
//       department.removeStudent(randomStudent);

//        entityManager1.remove(student);

        entityTransaction2.commit();



        entityManager1.close();

        IDepartmentDBUtil dbUtil=new HibernateDB();
        Long[] ids ={1L,2L,3L};
        EntityManager entityManager2=factory.createEntityManager();
        List<Student>  studentGot=dbUtil.getStudents(ids,entityManager2);

        studentGot.forEach(s->logger.info(s));
        entityManager2.close();

        EntityManager entityManager3=factory.createEntityManager();

        EntityTransaction transaction=entityManager3.getTransaction();
        transaction.begin();
        List<AdharCard> adharCards=entityManager3.createQuery("select a from AdharCard a",AdharCard.class)
                        .getResultList();
        adharCards.forEach(a->logger.info(a));


        transaction.commit();

        entityManager3.close();



        EntityManager entityManager4=factory.createEntityManager();

        EntityTransaction transaction4=entityManager4.getTransaction();
        transaction4.begin();
        Student studentToSearch=entityManager4.find(Student.class,3L);
        logger.info(studentToSearch.getActiveAdharCards());
        logger.info(studentToSearch.getInActiveAdharCards());
        transaction4.commit();

        entityManager4.close();*/

      /*  EntityManager entityManager5=factory.createEntityManager();
       entityManager5
                .unwrap(Session.class)
                .enableFilter("indianStudent").setParameter("state","china");

//        Transaction transaction1= session.getTransaction();
//        transaction1.begin();
       List<Student> indianStudents=entityManager5.createQuery(
               "select s from Student s",Student.class
       ).getResultList();
       logger.info(" Students are ");
        indianStudents.forEach(s->logger.info(s));
//        transaction1.commit();
    entityManager5.close(); */


       /* EntityManager entityManager5=factory.createEntityManager();
        EntityTransaction transaction=entityManager5.getTransaction();
        transaction.begin();
        Department department=entityManager5.find(Department.class,2L);
        logger.info(department.toString());
        department.setName("810");
       entityManager5.persist(department);
       entityManager5.flush();
       transaction.commit();
        entityManager5.close(); */


       /* Student student=dao.fetchStudentById(factory,7L);
        Assert.assertNotNull(student);
        Set<AdharCard> inActiveAdharCards=student.getInActiveAdharCards();
        Assert.assertEquals(2,inActiveAdharCards.size());
        inActiveAdharCards.stream()
                .map(iaa->"id:"+iaa.getId()+" active:"+iaa.isActive()+ " State :"+iaa.getState())
                .forEach(iaa->logger.info(iaa)); */


       /*Student studentViaQuery=dao.fetchStudentViaQuery(factory,7L);
        Assert.assertNotNull(studentViaQuery);
        Set<AdharCard> inActiveAdharCardsViaQuery=studentViaQuery.getInActiveAdharCards();
        Assert.assertEquals(2,inActiveAdharCardsViaQuery.size());
        inActiveAdharCardsViaQuery.stream()
                .map(iaa->"id:"+iaa.getId()+" active:"+iaa.isActive()+ " State :"+iaa.getState())
                .forEach(iaa->logger.info(iaa));*/


       /* int student7PocketMoney=dao.fetchStudentPocketMoney(factory,7L);
        Assert.assertNotNull(student7PocketMoney);

        Assert.assertEquals(258,student7PocketMoney); */


        /*Student studentViaQuery=dao.fetchStudentAdharCard(factory,7L);
        Assert.assertNotNull(studentViaQuery);
        Set<AdharCard> inActiveAdharCardsViaQuery=studentViaQuery.getInActiveAdharCards();
        Assert.assertEquals(2,inActiveAdharCardsViaQuery.size());
        inActiveAdharCardsViaQuery.stream()
                .map(iaa->"id:"+iaa.getId()+" active:"+iaa.isActive()+ " State :"+iaa.getState())
                .forEach(iaa->logger.info(iaa)); */

   /*Student studentViaCriteriaQuery=dao.fetchStudentViaCriteria(factory,7L);
        Assert.assertNotNull(studentViaCriteriaQuery);
        Set<AdharCard> inActiveAdharCardsViaCriteriaQuery=studentViaCriteriaQuery.getInActiveAdharCards();
        Assert.assertEquals(2,inActiveAdharCardsViaCriteriaQuery.size());
        inActiveAdharCardsViaCriteriaQuery.stream()
                .map(iaa->"id:"+iaa.getId()+" active:"+iaa.isActive()+ " State :"+iaa.getState())
                .forEach(iaa->logger.info(iaa)); */
      CriteriaDao criteriaDao=new CriteriaDao();
      String studentName="Magorian";
      /*   Optional<Student> student=criteriaDao.getStudentByName(factory,"Magorian");
        logger.info(student.toString());
        sleep(3);
        Set<AdharCard> inActive=student.get().getInActiveAdharCards();
        inActive.forEach(a->logger.info(a.toString())); */

     /*  List<String> cities=criteriaDao.getStudentCities(factory,studentName);
        cities.
                stream()
                .map(city->city.toUpperCase())
                .forEach(a->logger.info(a));
        Assert.assertEquals("TestMessage",cities.size(),2); */

       /* List<Object[]> objects=criteriaDao.getStudentCityState(factory,studentName);
        objects.stream()
                .filter(o->o[1].toString().toLowerCase().equalsIgnoreCase("jalpaiguri"))
                .map(o->o[0]+"_"+o[1]+"_"+o[2])
                .forEach(o->logger.info(o)); */

        /*List<StudentWrapper> studentWrappers=criteriaDao.fetchStudentWrappers(factory,studentName);
        studentWrappers
                .stream()
                .map(o->o.getId()+"-"+o.getCity()+"-"+o.getState())
                .forEach(o->logger.info(o)); */

        List<Tuple> studentVehicleTuple=criteriaDao.getStudentViaMultipleRoots(factory,"M%","purple");
        Assert.assertEquals(54,studentVehicleTuple.size());
        for (Tuple tuple: studentVehicleTuple){
            logger.info(tuple.get(0));
            logger.info(tuple.get(1));
        }
    }

    private static void sleep(long sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}


