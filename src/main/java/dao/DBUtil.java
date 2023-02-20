package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    /**
     * Attempts to connect to database and
     * @return id, name, email, address and department_id from the student table
     * @throws SQLException when illegal parameters are given
     */
    public  List<Student> getStudents() throws SQLException {
        String databaseServer="127.0.0.1";
        String port="5432";
        String database="udemy_db";
        String user="koushik";
        String password="123";
        String connectionString="jdbc:postgresql://" +databaseServer+":"+port+"/"+database;
        List<Student> retrievedStudent=new ArrayList<>();
        String sqlQuery="SELECT id,name,email,address,dept_fk_id from STUDENT  ORDER BY id DESC";
        try(Connection connection= DriverManager.getConnection(connectionString,user,password)){
            PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");
                String address=resultSet.getString("address");
                int deptFK=resultSet.getInt("dept_fk_id");
                Student student=new Student(name,id,address,email,deptFK);
                retrievedStudent.add(student);
            }
        }
        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        throw new SQLException(e.getCause());
//
    } catch (Exception e) {
        e.printStackTrace();
    }
        return retrievedStudent;
    }
}
