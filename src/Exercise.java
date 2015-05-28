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
        String createUsers = "CREATE TABLE IF NOT EXISTS users (id_user INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255), surname varchar(255))";
        String createDatasets = "CREATE TABLE IF NOT EXISTS datasets (id_dataset INTEGER PRIMARY KEY AUTOINCREMENT, collision varchar(255), gaussParameters varchar(255), polynomialParameters varchar(255))";
        String createResults = "CREATE TABLE IF NOT EXISTS results (id_result INTEGER PRIMARY KEY AUTOINCREMENT, id_user int, id_dataset int)";
        try {
            stat.execute(createUsers);
            stat.execute(createDatasets);
            stat.execute(createResults);
        } catch (SQLException e) {
            System.err.println("Table creating error");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertUser(String name, String surname) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into users values (NULL, ?, ?);");
            prepStmt.setString(1, name);
            prepStmt.setString(2, surname);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Error inserting user");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertDataset(String collision, String gaussParameters, String polynomialParameters) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into datasets values (NULL, ?, ?, ?);");
            prepStmt.setString(1, collision);
            prepStmt.setString(2, gaussParameters);
            prepStmt.setString(2, polynomialParameters);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Error in dataset");
            return false;
        }
        return true;
    }

    public boolean insertResults(int idUser, int idDataset) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into results values (NULL, ?, ?);");
            prepStmt.setInt(1, idUser);
            prepStmt.setInt(2, idDataset);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Error in adding fit results");
            return false;
        }
        return true;
    }

    public List<User> selectUsers() {
        List<User> users = new LinkedList<User>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM users");
            int id;
            String name, surname;
            while (result.next()) {
                id = result.getInt("id_user");
                name = result.getString("name");
                surname = result.getString("surname");
                users.add(new User(id, name, surname));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return users;
    }

    public List<Dataset> selectDatasets() {
        List<Dataset> datasets = new LinkedList<Dataset>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM datasets");
            int id;
            String collision, gaussParameters, polynomialParameters;
            while (result.next()) {
                id = result.getInt("id_dataset");
                collision = result.getString("collision");
                gaussParameters = result.getString("gaussParameters");
                polynomialParameters = result.getString("polynomialParameters");
               datasets.add(new Dataset(id,collision, gaussParameters,polynomialParameters));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return datasets;
    }

    public List<Result> selectResults() {
        List<Result> results = new LinkedList<Result>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM results");
            int id;
            int idUser,idDataset;
            while (result.next()) {
                id = result.getInt("id_result");
                idUser = result.getInt("id_user");
                idDataset = result.getInt("id_dataset");
                results.add(new Result(id,idUser,idDataset));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return results;
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
