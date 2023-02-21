import com.github.javafaker.Faker;
import dao.DBUtil;
import dao.Student;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.postgresql.util.PSQLException;

import java.sql.SQLException;
import java.util.List;


class AppMainTest {
    final static Logger logger = Logger.getLogger(AppMainTest.class);
    String databaseServer="127.0.0.1";
    String port="5432";
    String database="udemy_db";
    String user="koushik";
    String password="123";

    /**
     *  Attempts to connect to the designated Database base through legitimate parameters and return 1 if connection status is successful.
     * @throws SQLException
     */
    @Test
    void connectToDatabaseSuccessful() throws SQLException {

        int connectedStatus=AppMain.connectToDatabase(databaseServer,port,database,user,password);
        Assert.assertEquals(1,connectedStatus);

    }

    /**
     *Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong password is entered
     */
    @Test
    void connectToDatabaseFailureWrongPassword() {


        Assert.assertThrows(SQLException.class,()->AppMain.connectToDatabase(databaseServer,port
        ,database,user,password));

    }

    /**
     * Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong server is entered
     */
    @Test
    void connectToDatabaseFailureWrongServerIP() {


        Assert.assertThrows(SQLException.class,()->AppMain.connectToDatabase(databaseServer,port
                ,database,user,password));

    }

    /**
     * Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong port is entered
     */
    @Test
    void connectToDatabaseFailureWrongPort() {


        Assert.assertThrows(SQLException.class,()->AppMain.connectToDatabase(databaseServer,port
                ,database,user,password));

    }


    /**
     * Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong database is entered
     */
    @Test
    void connectToDatabaseFailureWrongDatabase() {


        Assert.assertThrows(SQLException.class,()->AppMain.connectToDatabase(databaseServer,port
                ,database,user,password));

    }

    /**
     * Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong username is entered
     */
    @Test
    void connectToDatabaseFailureWrongUsername() throws SQLException {


        Assert.assertThrows(SQLException.class,()->AppMain.connectToDatabase(databaseServer,port
                ,database,user,password));

    }
    @Test
    void getStudentTest()  {
        int totalStudentsInDB=8;
        DBUtil dbUtil=new DBUtil();
        List< Student> retrievedStudent= null;
        try {
            retrievedStudent = dbUtil.getStudents();
        } catch (SQLException e) {
            logger.info(String.format("SQL State: %s\n",e.getMessage()));

        }
        Assert.assertEquals(totalStudentsInDB,retrievedStudent.size());

    }
    @Test
    void saveIntoDBTest(){
        Faker faker=new Faker();
        int rowsAffected=0;
        DBUtil dbUtil=new DBUtil();
        Student student=null;
        try {
            for(int i=0;i<100000;i++){
                student=new Student(faker.hacker().noun(),faker.harryPotter().house(),faker.address().cityName().toString(), faker.pokemon().name()+"@a.com",faker.number().numberBetween(1000,2500));
                rowsAffected=  dbUtil.save(student);
                Thread.sleep(100);
            }

        } catch (Exception e) {logger.error(e.getMessage());
        }
        Assert.assertEquals(rowsAffected,1);
        try {
            List<Student> retrievedStudentName=dbUtil.getAStudent(student.getName());
            Assert.assertEquals(4,retrievedStudentName.size());
            Student retrieved=retrievedStudentName.get(0);
            Assert.assertEquals(retrieved.getName(),"abc");
            Assert.assertEquals(retrieved.getPocketMoney(),500);
            Assert.assertEquals(retrieved.getState(),"West Bengal");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void getAStudentTest(){
        int rowsRetrieved=0;
        DBUtil dbUtil=new DBUtil();
        try {
            List<Student> retrievedStudentNameChandan=dbUtil.getAStudent("chandan");
            Assert.assertEquals(2,retrievedStudentNameChandan.size());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}