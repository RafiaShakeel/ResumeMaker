import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    public Connection connectDatabase(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3302/resume_maker", "root", "root");
            System.out.println("Connection Established");
            return con;


        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
