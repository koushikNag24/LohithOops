package dao;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    final static Logger logger = Logger.getLogger(DBUtil.class);
    String databaseServer="127.0.0.1";
    String port="5432";
    String database="test_db";
    String user="lohith";
    String password="123";
    String connectionString="jdbc:postgresql://" +databaseServer+":"+port+"/"+database;
    private static final String SQL_INSERT = "INSERT INTO STUDENT (NAME, CITY, STATE,EMAIL,POCKET_MONEY) VALUES (?,?,?,?,?)";
    /**
     * Attempts to connect to database and
     * @return id, name, email, address and department_id from the student table
     * @throws SQLException when illegal parameters are given
     */
    public  List<Student> getStudents() throws SQLException {

        List<Student> retrievedStudent=new ArrayList<>();
        String sqlQuery="SELECT id,name,email,city,state, pocket_money from STUDENT  ORDER BY id DESC";
        try(Connection connection= DriverManager.getConnection(connectionString,user,password)){
            PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String city=resultSet.getString("city");
                String state=resultSet.getString("state");
                String email=resultSet.getString("email");
                int pocketMoney=resultSet.getInt("pocket_money");
                Student student=new Student(name,city,state, email, pocketMoney);
                retrievedStudent.add(student);
            }
        }
        catch (SQLException e) {
        throw new SQLException(e.getMessage());//
    } catch (Exception e) {
            logger.info(String.format("SQL State: %s\n", e.getMessage()));
            throw new SQLException(e.getMessage());
    }
        return retrievedStudent;
    }

    public  List<Student> getAStudent(String nameToSearch) throws SQLException {

        List<Student> retrievedStudent=new ArrayList<>();
        String sqlQuery="SELECT id,name,email,city,state, pocket_money from STUDENT  WHERE NAME= (?)";
        try(Connection connection= DriverManager.getConnection(connectionString,user,password)){
            PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,nameToSearch);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String city=resultSet.getString("city");
                String state=resultSet.getString("state");
                String email=resultSet.getString("email");
                int pocketMoney=resultSet.getInt("pocket_money");
                Student student=new Student(name,city,state, email, pocketMoney);
                retrievedStudent.add(student);
            }
        }
        catch (SQLException e) {
            throw new SQLException(e.getMessage());//
        } catch (Exception e) {
            logger.info(String.format("SQL State: %s\n", e.getMessage()));
            throw new SQLException(e.getMessage());
        }
        return retrievedStudent;
    }

    public int save(Student student) throws Exception {
        int rowsAffected=0;
        try(Connection connection= DriverManager.getConnection(connectionString,user,password)) {
            PreparedStatement preparedStatement=connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getCity());
            preparedStatement.setString(3,student.getState());
            preparedStatement.setString(4,student.getEmail());
            preparedStatement.setInt(5,student.getPocketMoney());
            rowsAffected= preparedStatement.executeUpdate();
        }
        catch (SQLException e){
                throw new SQLException(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return rowsAffected;
        }

        public int updateStudentToDatabase() {
        String updateQuery = "update "
        }

}
