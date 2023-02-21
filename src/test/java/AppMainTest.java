import com.github.javafaker.Faker;
import tutorial.dao.utils.DBUtilv1;
import tutorial.dao.utils.IDBUtil;
import tutorial.dao.Student;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

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
        IDBUtil IDBUtil =new DBUtilv1();
        int connectedStatus=IDBUtil.connectToDatabase(databaseServer,port,database,user,password);
        Assert.assertEquals(1,connectedStatus);

    }

    /**
     *Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong password is entered
     */
    @Test
    void connectToDatabaseFailureWrongPassword() {
        IDBUtil IDBUtil =new DBUtilv1();

        Assert.assertThrows(SQLException.class,()->IDBUtil.connectToDatabase(databaseServer,port
        ,database,user,password));

    }

    /**
     * Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong server is entered
     */
    @Test
    void connectToDatabaseFailureWrongServerIP() {
        IDBUtil IDBUtil =new DBUtilv1();

        Assert.assertThrows(SQLException.class,()->IDBUtil.connectToDatabase(databaseServer,port
                ,database,user,password));

    }

    /**
     * Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong port is entered
     */
    @Test
    void connectToDatabaseFailureWrongPort() {
        IDBUtil IDBUtil =new DBUtilv1();

        Assert.assertThrows(SQLException.class,()->IDBUtil.connectToDatabase(databaseServer,port
                ,database,user,password));

    }


    /**
     * Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong database is entered
     */
    @Test
    void connectToDatabaseFailureWrongDatabase() {
        IDBUtil IDBUtil =new DBUtilv1();

        Assert.assertThrows(SQLException.class,()->IDBUtil.connectToDatabase(databaseServer,port
                ,database,user,password));

    }

    /**
     * Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong username is entered
     */
    @Test
    void connectToDatabaseFailureWrongUsername() throws SQLException {

        IDBUtil IDBUtil =new DBUtilv1();
        Assert.assertThrows(SQLException.class,()->IDBUtil.connectToDatabase(databaseServer,port
                ,database,user,password));

    }
    @Test
    void getStudentTest()  {
        int totalStudentsInDB=8;
        IDBUtil IDBUtil =new DBUtilv1();
        List< Student> retrievedStudent= null;
        try {
            retrievedStudent = IDBUtil.getStudents();
        } catch (SQLException e) {
            logger.info(String.format("SQL State: %s\n",e.getMessage()));

        }
        Assert.assertEquals(totalStudentsInDB,retrievedStudent.size());

    }
    @Test
    void saveIntoDBTest(){
        Faker faker=new Faker();
        int rowsAffected=0;
        IDBUtil IDBUtil =new DBUtilv1();
        Student student=null;
        try {

                student=new Student(faker.hacker().noun(),faker.harryPotter().house(),faker.address().cityName().toString(), faker.pokemon().name()+"@a.com",faker.number().numberBetween(1000,2500));
                rowsAffected=  IDBUtil.save(student);
                Thread.sleep(100);


        } catch (Exception e) {logger.error(e.getMessage());
        }
        Assert.assertEquals(rowsAffected,1);
        try {
            List<Student> retrievedStudentName= IDBUtil.getAStudent(student.getName());
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
        IDBUtil IDBUtil =new DBUtilv1();
        try {
            List<Student> retrievedStudentNameChandan= IDBUtil.getAStudent("chandan");
            Assert.assertEquals(2,retrievedStudentNameChandan.size());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void updateStudentTest () {
        IDBUtil IDBUtil = new DBUtilv1();
        Student updatedStudent = new Student("Lohith", 71, "abc", "asd", "adsa", 55);

        try {
            int rowsAffected = IDBUtil.updateStudentToDatabase(updatedStudent);
            Assert.assertEquals(1, rowsAffected);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }


    }
    @Test
    void deleteStudentTest() {
        IDBUtil IDBUtil = new DBUtilv1();
        Student deletedStudent = new Student("capacitor", 629, "dfs", "sdf", "shdb",500);
        try {
            IDBUtil.deleteStudent(deletedStudent); // testing Delete
        List<Student> deletedStudents =  IDBUtil.getAStudent("capacitor"); // get name with capacitor
        Assert.assertEquals(0,deletedStudents.size()); // if there is no capacitor then only delete was correct !!
        } catch (Exception e) {
            logger.info(e.getMessage());
        }





    }


}
