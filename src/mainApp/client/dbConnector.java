package mainApp.client;
import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnector {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "hLfbfPAkUv";
        String databaseUser = "hLfbfPAkUv";
        String databasePassword = "3EudZO39fL";
        String url = "jdbc:mysql://remotemysql.com/"+databaseName;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
}
