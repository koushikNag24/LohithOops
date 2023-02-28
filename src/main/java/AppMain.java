import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.apache.log4j.Logger;
import org.junit.Assert;
import tutorial.dao.utils.hibernate.HibernateDB;
import tutorial.dao.utils.hibernate.IDepartmentDBUtil;
import tutorial.dao.utils.jpahibernate.IJpaHibernateUtil;
import tutorial.dao.utils.jpahibernate.JpaHibernateUtilv1;
import tutorial.dao.utils.jpahibernate.exception.ArgumentNullException;
import tutorial.dao.utils.jpahibernate.exception.NoMeasurementException;
import tutorial.dao.utils.jpahibernate.model.AdharCard;
import tutorial.dao.utils.jpahibernate.model.Course;
import tutorial.dao.utils.jpahibernate.model.Department;
import tutorial.dao.utils.jpahibernate.model.Student;
import tutorial.dao.utils.jpahibernate.service.DepartmentService;
import tutorial.dao.utils.jpahibernate.service.SectionService;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AppMain {

    final static Logger logger = Logger.getLogger(AppMain.class);
    public static void main(String[] args) {

        Faker faker=new Faker();
        DepartmentService departmentService=new DepartmentService();

        IJpaHibernateUtil jpaHibernateUtil = new JpaHibernateUtilv1();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_JPA");
        EntityManager entityManager = factory.createEntityManager();
        for(int i = 1; i< SectionService.getRandomNumber(3,5); i++) {
            Department department = departmentService.getDepartment(faker);

            for (int j = 0; j < SectionService.getRandomNumber(3,7); j++) {
                Student student = new Student(faker.harryPotter().character(), faker.harryPotter().location(), faker.address().cityName(), faker.pokemon().name() + "@" + faker.animal().name() + ".com", faker.number().numberBetween(500, 100));
                AdharCard adharCard=departmentService.getAdharCard();
                if(adharCard.isActive()){
                    student.addActiveAdharCard(adharCard);
                }else{
                    student.addInActiveAdharCard(adharCard);
                }

                for(int p=0;p< SectionService.getRandomNumber(2,4);p++){
                    Course course=new Course();
                    course.setName(faker.cat().name());
                    student.addCourse(course);
                }
                department.addStudent(student);
            }
            jpaHibernateUtil.save(department,entityManager);
            logger.info(" saved "+department.toString()+ "-- "+i);
        }



//        EntityManager entityManager2 = factory.createEntityManager();
        EntityTransaction   entityTransaction=entityManager.getTransaction();
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

        entityManager4.close();


    }




















}


