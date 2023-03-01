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
        String[] states={"india","china","japan"};
        String[] cities={"kolkata","beijing","jalpaiguri","tokyo"};
        String randomState=states[new Random().nextInt(states.length)];
        String randomCity=cities[new Random().nextInt(cities.length)];
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
        department.setCountry(randomState);
        department.setState(randomState);
        department.setCity(randomCity);
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
        String[] states={"india","china","japan"};
        String randomState=states[new Random().nextInt(states.length)];
        AdharCard adharCard=new AdharCard();
        adharCard.setState(randomState);
        adharCard.setActive(new Random().nextBoolean());
        adharCard.setName(faker.name().username());
        return adharCard;
    }
    public String getStateCity(){
        HashMap<String,String> stateCityMap=new HashMap<>();
        String[] city={"kolkata","beijing","jalpaiguri","tokyo"};
        stateCityMap.put("kolkata","india");
        stateCityMap.put("beijing","china");
        stateCityMap.put("jalpaiguri","india");
        stateCityMap.put("tokyo","japan");
        String randomCity=city[new Random().nextInt(city.length)];
        return stateCityMap.get(randomCity)+"_"+randomCity;

    }
    public String getCourse(){
        String[] courses={"CS","ECE","MECH","CIVIL"};
        return courses[new Random().nextInt(courses.length)];
    }

}
