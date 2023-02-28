package tutorial.dao.utils.jpahibernate.service;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import tutorial.dao.utils.jpahibernate.exception.ArgumentNullException;
import tutorial.dao.utils.jpahibernate.exception.NoMeasurementException;
import tutorial.dao.utils.jpahibernate.model.AdharCard;
import tutorial.dao.utils.jpahibernate.model.Department;
import tutorial.dao.utils.jpahibernate.model.Student;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class DepartmentService {

    Faker faker=new Faker();
    final static Logger logger = Logger.getLogger(DepartmentService.class);
    public  Department getDepartment(Faker faker) {
        Department department = new Department();
        department.setName(faker.university().prefix());
        department.setClosed(false);
        InetAddress addr=null;
        try {
            addr  = InetAddress.getByName("www.yahoo.com");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }


        department.setAddress(addr);

        HashMap<String,Boolean> healthStatus=new HashMap<>();
        healthStatus.put("isInc1Fine",true);
        healthStatus.put("isInc2Fine",false);
        department.setPayload(healthStatus);
        department.setDepartmentPassword("123");
        department.setCountry(faker.country().name());
        department.setState(faker.address().state());
        department.setCity(faker.address().cityName());
        department.setCollege(faker.university().name());
        department.setFund(BigDecimal.valueOf(1200));
        department.setStartDate(LocalDate.now().minusYears(10));
        return department;
    }
    public void logDepartment(Department department) throws ArgumentNullException, NoMeasurementException {
        SectionService.GuardAgainstNull(department,"department");
        logger.info(department.getFullAddress());
        logger.info(department.getYearlyFund());
        Set<Student> students=department.getStudents();
        SectionService.GuardCollectionAgainstNullEmpty(students);
        students.forEach(s->logger.info(s));
    }
    public AdharCard  getAdharCard(){
        AdharCard adharCard=new AdharCard();
        adharCard.setState(faker.address().stateAbbr());
        adharCard.setActive(new Random().nextBoolean());
        adharCard.setName(faker.name().username());
        return adharCard;
    }
}
