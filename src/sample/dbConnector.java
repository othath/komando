package sample;
import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnector {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "javafx";
        String databaseUser = "Mehdi";
        String databasePassword = "2129";
        String url = "jdbc:mysql://localhost/"+databaseName;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
}
