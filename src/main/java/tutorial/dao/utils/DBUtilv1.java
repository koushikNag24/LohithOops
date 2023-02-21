package tutorial.dao.utils;

import org.apache.log4j.Logger;
import tutorial.dao.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtilv1 implements IDBUtil {
    final static Logger logger = Logger.getLogger(DBUtilv1.class);
    String databaseServer = "127.0.0.1";
    String port = "5432";
    String database = "test_db";
    String user = "lohith";
    String password = "123";
    String connectionString = "jdbc:postgresql://" + databaseServer + ":" + port + "/" + database;
    private static final String SQL_INSERT = "INSERT INTO STUDENT (NAME, CITY, STATE,EMAIL,POCKET_MONEY) VALUES (?,?,?,?,?)";

    /**
     * Attempts to connect to database and
     *
     * @return id, name, email, address and department_id from the student table
     * @throws SQLException when illegal parameters are given
     */
    @Override
    public List<Student> getStudents() throws SQLException {

        List<Student> retrievedStudent = new ArrayList<>();
        String sqlQuery = "SELECT id,name,email,city,state, pocket_money from STUDENT  ORDER BY id DESC";
        try (Connection connection = DriverManager.getConnection(connectionString, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String email = resultSet.getString("email");
                int pocketMoney = resultSet.getInt("pocket_money");
                Student student = new Student(name, city, state, email, pocketMoney);
                retrievedStudent.add(student);
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());//
        } catch (Exception e) {
            logger.info(String.format("SQL State: %s\n", e.getMessage()));
            throw new SQLException(e.getMessage());
        }
        return retrievedStudent;
    }

    @Override
    public List<Student> getAStudent(String nameToSearch) throws SQLException {

        List<Student> retrievedStudent = new ArrayList<>();
        String sqlQuery = "SELECT id,name,email,city,state, pocket_money from STUDENT  WHERE NAME= (?)";
        try (Connection connection = DriverManager.getConnection(connectionString, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, nameToSearch);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String email = resultSet.getString("email");
                int pocketMoney = resultSet.getInt("pocket_money");
                Student student = new Student(name, city, state, email, pocketMoney);
                retrievedStudent.add(student);
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());//
        } catch (Exception e) {
            logger.info(String.format("SQL State: %s\n", e.getMessage()));
            throw new SQLException(e.getMessage());
        }
        return retrievedStudent;
    }

    @Override
    public int save(Student student) throws Exception {
        int rowsAffected = 0;
        try (Connection connection = DriverManager.getConnection(connectionString, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getCity());
            preparedStatement.setString(3, student.getState());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setInt(5, student.getPocketMoney());
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return rowsAffected;
    }

    @Override
    public int updateStudentToDatabase(Student updatedStudent) throws Exception {
        int rowsAffected = 0;
        String updateQuery = "update student set name='" + updatedStudent.getName() + "' where id=(?);";

        try (Connection connection = DriverManager.getConnection(connectionString, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, updatedStudent.getId());
            rowsAffected = preparedStatement.executeUpdate();
            logger.info("Updated rows : " + rowsAffected);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return rowsAffected;
    }

    @Override
    public int deleteStudent(Student deletedStudent) throws Exception {
        int rowsAffected = 0;
        String deleteQuery = "delete from student where name=(?);";
        try (Connection connection = DriverManager.getConnection(connectionString, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, deletedStudent.getName());
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return rowsAffected;
    }


    public  int connectToDatabase(String databaseServer,String port,String database,String user,String password) throws SQLException {
        int isConnected=-1;
        String connectionString="jdbc:postgresql://" +databaseServer+":"+port+"/"+database;
        try (Connection conn = DriverManager.getConnection(
                connectionString, user, password)) {

            if (conn != null) {
                isConnected=1;
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());

        } catch (Exception e) {
            throw new SQLException(e.getMessage());
//            logger.error(String.format("SQL State: %s\n%s", e.getLocalizedMessage(), e.getMessage()));
//            e.printStackTrace();
        }
        return isConnected;
    }
}
