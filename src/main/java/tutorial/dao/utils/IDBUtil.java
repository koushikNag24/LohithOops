package tutorial.dao.utils;

import tutorial.dao.Student;

import java.sql.SQLException;
import java.util.List;

public interface IDBUtil {
    List<Student> getStudents() throws SQLException;

    List<Student> getAStudent(String nameToSearch) throws SQLException;

    int save(Student student) throws Exception;

    int updateStudentToDatabase(Student updatedStudent) throws Exception;

    int deleteStudent(Student deletedStudent) throws Exception;

    int connectToDatabase(String databaseServer,String port,String database,String user,String password) throws SQLException;
}
