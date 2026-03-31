import java.sql.*;

public class OracleConnect {
    
    public static void main(String[] args) throws SQLException {
        
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "manager";

        System.out.println("Connecting...");
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();

        
        try { stmt.executeUpdate("DROP TABLE JAVA_TEST"); } catch(Exception e) {}
        
        stmt.executeUpdate("CREATE TABLE JAVA_TEST (id NUMBER, name VARCHAR2(50))");
        System.out.println("Table Created.");

       
        stmt.executeUpdate("INSERT INTO JAVA_TEST VALUES (1, 'Gemini User')");
        stmt.executeUpdate("INSERT INTO JAVA_TEST VALUES (2, 'Java Coder')");
        System.out.println("Data Inserted.");

        
        ResultSet rs = stmt.executeQuery("SELECT * FROM JAVA_TEST");
        System.out.println("--- Table Contents ---");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt(1) + " | Name: " + rs.getString(2));
        }

      
        rs.close();
        stmt.close();
        conn.close();
        System.out.println("Done!");
    }
}
