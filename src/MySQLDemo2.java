import java.sql.*;
import java.util.HashMap;
import java.util.Map;

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

    public static void closeMySQLConnection(Connection conn) {
        try {
            if (conn!=null) {
                conn.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // Simple SELECT with Statement (not recommended)
    public static void getEmpDetails(Connection conn) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.createStatement();
            // READ operation (SELECT)
            resultSet = statement.executeQuery("SELECT * FROM quickjava.emp;");
            while (resultSet.next()) {
                System.out.println("[INFO] [Statement call] Id : " + resultSet.getInt("idemp"));
                System.out.println("[INFO] [Statement call] Firstname : " + resultSet.getString("firstname"));
                System.out.println("[INFO] [Statement call] Lastname : " + resultSet.getString("lastname"));
                System.out.println("[INFO] [Statement call] Nickname : " + resultSet.getString("nickname"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        resultSet.close();
        statement.close();
    }

    // CRUD 1 - Simple INSERT (Create) with Prepared Statement (recommended)
    public static void insertEmp(Connection conn) throws SQLException {
        String insertSQL = "INSERT INTO quickjava.emp (firstname, lastname, nickname) VALUES (?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(insertSQL);

            // Set parameters
            pstmt.setString(1, "purva");
            pstmt.setString(2, "vats");
            pstmt.setString(3, "purva");

            int rowAffected = pstmt.executeUpdate();
            System.out.println("[INFO] [Prepared Statement call] Row affected : "+rowAffected);

        } catch(SQLException e){
            e.printStackTrace();
        }
        pstmt.close();
    }
    // CRUD 2 - Simple SELECT (Read) with Prepared Statement (recommended)
    public static void getNicknameByFirstnameLastname(Connection conn) throws SQLException {
        String selectSQL = "SELECT * FROM quickjava.emp WHERE firstname = ? AND lastname = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(selectSQL);

            // Set parameters
            pstmt.setString(1, "avik");
            pstmt.setString(2, "deb");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("[INFO] [Prepared Statement call] Registered nickname : "+rs.getString("nickname"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        rs.close();
        pstmt.close();
    }

    // CRUD 3 - Simple UPDATE with Prepared statement (recommended)
    public static void updateNicknameById(Connection conn) throws SQLException {
        String updateSQL = "UPDATE quickjava.emp SET nickname= ? WHERE idemp = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(updateSQL);

            // Set parameters
            pstmt.setString(1, "dada");
            pstmt.setInt(2, 1);
            pstmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        pstmt.close();
    }

    // Driver code to test DB operations.
    public static void main(String[] args) {
        try {
            Connection connection = getMySQLDBConnection();
            insertEmp(connection);
            getEmpDetails(connection);
            getNicknameByFirstnameLastname(connection);
            updateNicknameById(connection);
            getNicknameByFirstnameLastname(connection);

            closeMySQLConnection(connection);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}