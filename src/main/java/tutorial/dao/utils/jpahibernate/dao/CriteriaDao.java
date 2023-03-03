package tutorial.dao.utils.jpahibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;
import org.junit.Assert;
import tutorial.dao.utils.jpahibernate.model.Student;
import tutorial.dao.utils.jpahibernate.model.Vehicle;
import tutorial.dao.utils.jpahibernate.model.wrapper.StudentWrapper;

import java.util.List;
import java.util.Optional;

public class CriteriaDao {
    public Optional<Student> getStudentByName(EntityManagerFactory factory,String name){
        EntityManager entityManager=factory.createEntityManager();
        Optional<Student>  student;
        CriteriaBuilder builder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> root=criteria.from(Student.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("name"),name));
        student =entityManager.createQuery(criteria).getResultStream().findFirst();
        return student;
    }
    public List<String> getStudentCities(EntityManagerFactory factory,String name){
        EntityManager entityManager=factory.createEntityManager();
        CriteriaBuilder builder=entityManager.getCriteriaBuilder();
        CriteriaQuery<String> criteria= builder.createQuery(String.class);
        Root<Student> root=criteria.from(Student.class);
        criteria.select(root.get("city"));
        criteria.where(builder.equal(root.get("name"),name));
        List<String> cities=entityManager.createQuery(criteria).getResultList();
        return cities;
    }
    public List<Object[]> getStudentCityState(EntityManagerFactory factory,String name){
        EntityManager entityManager= factory.createEntityManager();
        CriteriaBuilder builder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        Root<Student> root= criteriaQuery.from(Student.class);
        Path<Long> idPath=root.get("id");
        Path<String> city=root.get("city");
        Path<String> state=root.get("state");
        criteriaQuery.select(builder.array(idPath,city,state));
//                        or
        criteriaQuery.multiselect(idPath,city,state);
        criteriaQuery.where(builder.equal(root.get("name"),name));
        List<Object[]> idCityState=entityManager.createQuery(criteriaQuery).getResultList();
        return  idCityState;
    }
    public List<StudentWrapper> fetchStudentWrappers(EntityManagerFactory factory,String name){
        EntityManager entityManager= factory.createEntityManager();
        CriteriaBuilder builder= entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentWrapper> criteriaQuery= builder.createQuery(StudentWrapper.class);
        Root<Student> root= criteriaQuery.from(Student.class);
        Path<Long> idPath=root.get("id");
        Path<String> cityPath=root.get("city");
        Path<String> statePath=root.get("state");
        criteriaQuery.select(builder.construct(StudentWrapper.class,idPath,cityPath,statePath));
        criteriaQuery.where(builder.equal(root.get("name"),name));
        List<StudentWrapper> wrappers=entityManager.createQuery(criteriaQuery).getResultList();
        return wrappers;
    }
    public List<Tuple> getStudentViaMultipleRoots(EntityManagerFactory factory,String studentPrefix,String color){
        EntityManager entityManager= factory.createEntityManager();
        CriteriaBuilder builder= entityManager.getCriteriaBuilder();;
        CriteriaQuery<Tuple> criteria= builder.createQuery(Tuple.class);
        Root<Student> studentRoot=criteria.from(Student.class);
        Root<Vehicle> vehicleRoot=criteria.from(Vehicle.class);
        criteria.multiselect(studentRoot,vehicleRoot);

        Predicate studentRestriction=builder.and(
                builder.like(studentRoot.get("name"),studentPrefix),
                builder.isNotNull(studentRoot.get("state"))
        );
        Predicate vehicleRestriction= builder.and(
                builder.equal(vehicleRoot.get("color"),color)
        );
        criteria.where(builder.and(studentRestriction,vehicleRestriction));
        List<Tuple> tuples=entityManager.createQuery(criteria).getResultList();
        return tuples;

    }
    public List<Vehicle> getVehiclesViaCriteriaJoin(EntityManagerFactory factory,String course){
        EntityManager entityManager= factory.createEntityManager();
        CriteriaBuilder builder= entityManager.getCriteriaBuilder();;
        CriteriaQuery<Vehicle>  criteriaQuery=builder.createQuery(Vehicle.class);
        Root<Vehicle>  root=criteriaQuery.from(Vehicle.class);
        Join<Vehicle,Student> studentJoin=root.join("student");

        Join<Student,String> courseJoin=studentJoin.join("courses");
        criteriaQuery.where(builder.equal(courseJoin.get("name"),course));
        List<Vehicle> vehicles=entityManager.createQuery(criteriaQuery).getResultList();
        return vehicles;
    }
    public List<Vehicle> getVehiclesViaCriteriaFetch(EntityManagerFactory factory,String color){
        EntityManager entityManager= factory.createEntityManager();
        CriteriaBuilder builder= entityManager.getCriteriaBuilder();;
        CriteriaQuery<Vehicle>  criteriaQuery=builder.createQuery(Vehicle.class);
        Root<Vehicle>  root=criteriaQuery.from(Vehicle.class);
        Fetch<Vehicle,Student> studentJoin=root.fetch("student");

        Fetch<Student,String> courseJoin=studentJoin.fetch("courses");
        criteriaQuery.where(builder.equal(root.get("color"),color));
        List<Vehicle> vehicles=entityManager.createQuery(criteriaQuery).getResultList();
        return vehicles;
    }
}
