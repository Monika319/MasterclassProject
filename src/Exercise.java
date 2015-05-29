import javax.xml.crypto.Data;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by monika03 on 28.05.15.
 */
public class Exercise {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:exercise.db";

    private Connection conn;
    private Statement stat;

    public Exercise() {
        try {
            Class.forName(Exercise.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("No JDBC driver found.");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Connection problem.");
            e.printStackTrace();
        }

        createTables();
    }


    public boolean createTables() {
        String createUsers = "CREATE TABLE IF NOT EXISTS users(nameSurname varchar(255) , collision varchar(255) , total varchar(255), background varchar(255),signal varchar(255),mean varchar(255),sigma varchar(255),PRIMARY KEY(nameSurname,collision))";
//        String createDatasets = "CREATE TABLE IF NOT EXISTS datasets (id_dataset INTEGER PRIMARY KEY AUTOINCREMENT, collision varchar(255), gaussParameters varchar(255), polynomialParameters varchar(255))";
//        String createResults = "CREATE TABLE IF NOT EXISTS results (id_result INTEGER PRIMARY KEY AUTOINCREMENT, id_user int, id_dataset int)";
        try {
            stat.execute(createUsers);
//            stat.execute(createDatasets);
//            stat.execute(createResults);
        } catch (SQLException e) {
            System.err.println("Table creating error");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertUser(String nameSurname, String collision, String total, String background, String signal, String mean, String sigma) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert or replace into users values (?,?,?,?,?,?,?);");
            prepStmt.setString(1, nameSurname);
            prepStmt.setString(2, collision);
            prepStmt.setString(3, total);
            prepStmt.setString(4, background);
            prepStmt.setString(5, signal);
            prepStmt.setString(6, mean);
            prepStmt.setString(7, sigma);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Error inserting user");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public List<User> selectUsers() {
        List<User> users = new LinkedList<User>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM users");
            String nameSurname, collision, total, background, signal, mean, sigma;
            while (result.next()) {
                // id = result.getInt("id_user");
                nameSurname = result.getString("nameSurname");
                collision = result.getString("collision");
                total = result.getString("total");
                background = result.getString("background");
                signal = result.getString("signal");
                mean = result.getString("mean");
                sigma = result.getString("sigma");

                users.add(new User(nameSurname, collision, total, background, signal, mean, sigma));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return users;
    }

    public void deleteUsers() {
        List<User> users = new LinkedList<User>();
        try {
            ResultSet result = stat.executeQuery("DELETE FROM users");
            int id;
            String name, surname;
            while (result.next()) {
//                id = result.getInt("id_user");
//                name = result.getString("name");
//                surname = result.getString("surname");
                users.clear();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // return null;
        }
        //  return users;
    }


    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error with closing connection");
            e.printStackTrace();
        }
    }
}
