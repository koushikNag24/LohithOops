import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.postgresql.util.PSQLException;

import java.sql.SQLException;


class AppMainTest {

    /**
     *  Attempts to connect to the designated Database base through legitimate parameters and return 1 if connection status is successful.
     * @throws SQLException
     */
    @Test
    void connectToDatabaseSuccessful() throws SQLException {
        String databaseServer="127.0.0.1";
        String port="5432";
        String database="udemy_db";
        String user="koushik";
        String password="123";
        int connectedStatus=AppMain.connectToDatabase(databaseServer,port,database,user,password);
        Assert.assertEquals(1,connectedStatus);

    }

    /**
     *Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong password is entered
     */
    @Test
    void connectToDatabaseFailureWrongPassword() {
        String databaseServer="127.0.0.1";
        String port="5432";
        String database="udemy_db";
        String user="koushik";
        String password="1123";

        Assert.assertThrows(SQLException.class,()->AppMain.connectToDatabase(databaseServer,port
        ,database,user,password));

    }

    /**
     * Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong server is entered
     */
    @Test
    void connectToDatabaseFailureWrongServerIP() {
        String databaseServer="127.1.0.1";
        String port="5432";
        String database="udemy_db";
        String user="koushik";
        String password="1123";

        Assert.assertThrows(SQLException.class,()->AppMain.connectToDatabase(databaseServer,port
                ,database,user,password));

    }

    /**
     * Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong port is entered
     */
    @Test
    void connectToDatabaseFailureWrongPort() {
        String databaseServer="127.1.0.1";
        String port="4432";
        String database="udemy_db";
        String user="koushik";
        String password="123";

        Assert.assertThrows(SQLException.class,()->AppMain.connectToDatabase(databaseServer,port
                ,database,user,password));

    }


    /**
     * Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong database is entered
     */
    @Test
    void connectToDatabaseFailureWrongDatabase() {
        String databaseServer="127.0.0.1";
        String port="5432";
        String database="testdb1";
        String user="koushik";
        String password="123";

        Assert.assertThrows(SQLException.class,()->AppMain.connectToDatabase(databaseServer,port
                ,database,user,password));

    }

    /**
     * Attempts to connect to the designated Database base through legitimate parameters and return -1 if wrong username is entered
     */
    @Test
    void connectToDatabaseFailureWrongUsername() throws SQLException {
        String databaseServer="127.0.0.1";
        String port="5432";
        String database="udemy_db";
        String user="manish";
        String password="123";

        Assert.assertThrows(SQLException.class,()->AppMain.connectToDatabase(databaseServer,port
                ,database,user,password));

    }


}