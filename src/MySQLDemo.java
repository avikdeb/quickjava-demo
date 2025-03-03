import java.sql.*;

// Database connection and a simple query statement execution.
public class MySQLDemo {
    public static void main(String[] args) {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/quickjava";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM quickjava.emp;");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("idemp"));
                System.out.println(resultSet.getString("firstname"));
                System.out.println(resultSet.getString("lastname"));
                System.out.println(resultSet.getString("nickname"));
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}