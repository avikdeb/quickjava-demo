import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// Database connection and CRUD operations.
public class MySQLDemo2 {

    public static Connection getMySQLDBConnection() throws Exception {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306";
        String schema = "quickjava";
        String user = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url+"/"+schema, user, password);
            if (connection!=null){
                System.out.println("[INFO] Database connection established successfully.");
            } else {
                System.out.println("[ERROR] Database connection is NULL.");
            }
        } catch (Exception e) {
            System.out.println("[ERROR] Exception caught. Please refer stack trace.");
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        try {
            Connection connection = getMySQLDBConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM quickjava.emp;");
            while (resultSet.next()) {
                System.out.println("Id : "+resultSet.getInt("idemp"));
                System.out.println("Firstname : "+resultSet.getString("firstname"));
                System.out.println("Lastname : "+resultSet.getString("lastname"));
                System.out.println("Nickname : "+resultSet.getString("nickname"));
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}