import com.github.javafaker.Faker;
import jakarta.persistence.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.hibernate.envers.query.criteria.AuditCriterion;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.SelectionQuery;
import tutorial.dao.utils.jpahibernate.IJpaHibernateUtil;
import tutorial.dao.utils.jpahibernate.JpaHibernateUtilv1;
import tutorial.dao.utils.jpahibernate.dao.CriteriaDao;
import tutorial.dao.utils.jpahibernate.dao.DataBaseDao;
import tutorial.dao.utils.jpahibernate.model.*;
import tutorial.dao.utils.jpahibernate.model.revision.EmployeeRevision;
import tutorial.dao.utils.jpahibernate.service.DepartmentService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppMain {

    final static Logger logger = Logger.getLogger(AppMain.class);
    public static void main(String[] args) {

        Faker faker = new Faker();
        DepartmentService departmentService = new DepartmentService();

        IJpaHibernateUtil jpaHibernateUtil = new JpaHibernateUtilv1();
        DataBaseDao dao = new DataBaseDao();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_JPA");
   /*     String[] cityState= departmentService.getStateCity().split("_");
        String city=cityState[1];
        String state=cityState[0];
        Student student = new Student(faker.harryPotter().character(), city, state, faker.pokemon().name() + "@" + faker.animal().name() + ".com", faker.number().numberBetween(500, 100));
        for(int i=0;i<1;i++){
            Vehicle vehicle=new Vehicle();
            vehicle.setColor(faker.color().name());
            vehicle.setCost(new BigDecimal(faker.commerce().price()));
            student.addVehicle(vehicle);
        }
        dao.save(factory,student);

        EntityManager entityManager = factory.createEntityManager();
        for(int i = 1; i< 3; i++) {
            Department department = departmentService.getDepartment(faker);

            for (int j = 0; j < 3; j++) {
                 cityState= departmentService.getStateCity().split("_");
                 city=cityState[1];
                 state=cityState[0];
                 student = new Student(faker.harryPotter().character(), city, state, faker.pokemon().name() + "@" + faker.animal().name() + ".com", faker.number().numberBetween(500, 100));
                AdharCard adharCard=departmentService.getAdharCard();
                if(adharCard.isActive()){
                    student.addActiveAdharCard(adharCard);
                }else{
                    student.addInActiveAdharCard(adharCard);
                }

                for(int p=0;p< 1;p++){
                    Course course=new Course();
                    course.setName(faker.app().name());
                    student.addCourse(course);
                }
                department.addStudent(student);
            }
            jpaHibernateUtil.save(department,entityManager);
            logger.info(" saved "+ department + "-- "+i);
        }

        entityManager.close();  */

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


//        updateDepartment(factory,"new_name"+ LocalDateTime.now().getSecond());


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
        CriteriaDao criteriaDao = new CriteriaDao();
        String studentName = "Magorian";
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

        /*List<Tuple> studentVehicleTuple=criteriaDao.getStudentViaMultipleRoots(factory,"M%","pink");
        Assert.assertEquals(2,studentVehicleTuple.size());
        for (Tuple tuple: studentVehicleTuple){
            logger.info(tuple.get(0));
            logger.info(tuple.get(1));
        } */

    /* List<Vehicle> vehiclesViaJoin=criteriaDao.getVehiclesViaCriteriaJoin(factory,"Bamity");
        logger.info(vehiclesViaJoin.size());
        vehiclesViaJoin.forEach(v->logger.info(v.getStudent()));

        logger.info(" will trigger Criteria Fetch");
        sleep(15);

        List<Vehicle> vehicles=criteriaDao.getVehiclesViaCriteriaFetch(factory,"purple");

        vehicles.forEach(v->logger.info(v.getStudent()));
    */
      //  List<Vehicle> vehiclesViaParameter=criteriaDao.getVehicleUsingParameter(factory,"purple");


      /*  List<Tuple> departmentTuplesGroupByCity=criteriaDao.fetchGroupBy(factory);
        for(Tuple tuple: departmentTuplesGroupByCity){
            String name=(String) tuple.get(0);
            Long count=(Long)tuple.get(1);
            logger.info("name "+ name+ " | count "+count);
        } */

//        List<Object[]> departments=criteriaDao.getDepartmentsSQLNativeQuery(factory);
//        List<Object[]> departments=criteriaDao.getDepartmentHibernateNativeQuery(factory);

     /*   List<Object[]> departments=criteriaDao.getDepartmentHibernateNativeQueryViaAvoidMetaData(factory);
        for(Object[] anObject: departments){
            for(Object dept : anObject){
                logger.info(dept.toString());
            }
            sleep(5);
        } */

//        List<Department> departments=criteriaDao.getDepartmentsEntityQueries(factory);
//        departments.forEach(d->logger.info(d.toString()));

//        List<Student> students=criteriaDao.getStudentsViaAssociation(factory);
//        students.forEach(d->logger.info(d.toString()));
//        List<Student> students=criteriaDao.getStudentVehicle(factory);
//        List<Student> students=criteriaDao.getStudentWithAlias(factory);
  /*  List<Object> students=criteriaDao.getStudentSameColumnNameButAliases(factory);
        for (Object o:students){
            logger.info(o.toString());
//            Student student=(Student)o;
//            logger.info(student.getId()+" || "+ student.getDepartment().getDeptId());
        } */
//        List<Vehicle> vehicles=criteriaDao.getVehiclesViaHandleInheritance(factory);
//        vehicles.forEach(d->logger.info(d.toString()));

       /* List<Vehicle> purpleVehicle=criteriaDao.getVehicleViaColor(factory,"p");
        purpleVehicle.forEach(d->logger.info(d.toString())); */
        EntityManager entityManager=factory.createEntityManager();
//        getRevisionHistory(entityManager);
      /*  List<Department> departments=getNthRevision(entityManager,102);
       departments.forEach(d->logger.info(d.getName())); */
//
//        Query query= entityManager.createNamedQuery("get_adhar_by_state");
//        query.setParameter("state","india");
     /*   TypedQuery<AdharCard> adharCardTypedQuery=entityManager.createNamedQuery("get_adhar_by_state",AdharCard.class);
        adharCardTypedQuery.setParameter("state","india")
        .setFlushMode(FlushModeType.COMMIT)
                .setHint("jakarta.persistence.query.timeout",1);
        List<AdharCard> adharCards=adharCardTypedQuery.getResultList(); */

        Session session=entityManager.unwrap(Session.class);
      /* SelectionQuery<?> badQuery=session.createSelectionQuery("update AdharCard a set a.state=:state where a.id=:id ");
        badQuery.setParameter("state","usa");
        badQuery.setParameter("id",1);
        badQuery.getResultList(); */

//        MutationQuery query=session.createMutationQuery("get_adhar_by_state");
//        query.executeUpdate();
        EntityTransaction transaction=null;
        try
        {
             transaction=entityManager.getTransaction();
            transaction.begin();
            int batchSize=5;
//            Employee employee1=entityManager.find(Employee.class,297);
//            employee1.setIstracEmployeeID("TR_"+LocalDateTime.now().getSecond());

            AuditReader reader=AuditReaderFactory.get(entityManager);
//            entityManager.merge(employee1);
            /*AuditQuery queryHistoryOfEmployee=reader.createQuery()
                    .forRevisionsOfEntity(Employee.class,true,true)
                            .add(AuditEntity.property("id").eq(180));
            List<Employee> history=queryHistoryOfEmployee.getResultList();
            history.forEach(e->logger.info(e)); */



            AuditQuery queryHistoryOfEmployeeRev=reader.createQuery()
                    .forRevisionsOfEntity(Employee.class,true,false)
                    .add(AuditEntity.revisionType().ne(RevisionType.ADD))
//                    .add(AuditEntity.property("name").eq(181));
                    .add(AuditEntity.property("name").hasChanged());
            List<Employee> historyRev=queryHistoryOfEmployeeRev.getResultList();
            historyRev.forEach(e->logger.info(e));
            /*for(Object item : historyRev){
//                Employee employee=(Employee) ((Object[])item)[0];
                EmployeeRevision employeeRevision=(EmployeeRevision)((Object[])item)[1];
                RevisionType revisionType=(RevisionType) ((Object[])item)[2];

//                logger.info("User Changed "+ employee.toString());

                logger.info("revised by ->  "+ employeeRevision.getUserName()+ " revised through Ip -> "+ employeeRevision.getIpAddress()+ " revised time -> "+ employeeRevision.getRevisionDate());
                logger.info(" rev type "+ revisionType);
            }*/
//            employee.setName("New_Name_"+LocalDateTime.now().getSecond());
         /*   for(int i=120;i<130;i++){
                if(i>0 && i%batchSize==0){
                    entityManager.flush();
                    entityManager.clear();
                }
                Employee employe=new Employee();

                employe.setName(String.format("Person-%d",i));
                employe.setIstracEmployeeID(String.format("TR1078-%d",i));
                entityManager.persist(employe);
                delay(100);
            }*/
            transaction.commit();
        }catch (RuntimeException e){
            if(transaction!=null && transaction.isActive())
            {
                transaction.rollback();
                throw e;
            }
        }finally {
            if(entityManager!=null){
                entityManager.close();
            }
        }


    }
    private static void delay(int second){
        try {
            TimeUnit.MILLISECONDS.sleep(second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private static List<Department> getNthRevision(EntityManager entityManager,Number revisionNumber){
        List<Department> department=AuditReaderFactory
                .get(entityManager)
                .createQuery()
                .forEntitiesAtRevision(Department.class,revisionNumber)
                .getResultList();
        return department;
    }

    private static void getRevisionHistory(EntityManager entityManager) {
        List<Number> revisions =  AuditReaderFactory
                .get(entityManager).getRevisions(Department.class,2L);
        revisions.forEach(r->logger.info(r));
    }

    private static void updateDepartment(EntityManagerFactory factory,String newName) {
        EntityManager entityManager5= factory.createEntityManager();
        EntityTransaction transaction=entityManager5.getTransaction();
        transaction.begin();
        Department department=entityManager5.find(Department.class,2L);
        logger.info(department.toString());
        department.setName(newName);
        entityManager5.persist(department);
        entityManager5.flush();
        transaction.commit();
        entityManager5.close();
    }

    private static void sleep(long sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}


