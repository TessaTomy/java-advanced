import java.sql.*;

public class OracleConnect2 {
    public static void main(String[] args) throws SQLException {
        
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "manager";

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connected!");

        
        String insertSQL = "INSERT INTO JAVA_TEST (id, name) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertSQL);

       
        pstmt.setInt(1, 500);
        pstmt.setString(2, "Alice");
        pstmt.executeUpdate(); // Runs the first insert

        pstmt.setInt(1, 600);
        pstmt.setString(2, "Bob");
        pstmt.executeUpdate(); // Runs the second insert
        
        System.out.println("2 rows inserted using PreparedStatement.");

      
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM JAVA_TEST");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + " | Name: " + rs.getString("name"));
        }

      
        rs.close();
        stmt.close();
        pstmt.close();
        conn.close();
    }
}
