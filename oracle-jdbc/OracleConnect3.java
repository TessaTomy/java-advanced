import java.sql.*;
import java.util.*;

public class OracleConnect3 {
    
    
    public static void main(String[] args) throws Exception {
        
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "manager";
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Connecting...");
        
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        
     
        try { stmt.executeUpdate("DROP TABLE book"); } catch(Exception e) {} 
        stmt.executeUpdate("CREATE TABLE book (id NUMBER, author VARCHAR2(20), title VARCHAR2(50), price NUMBER)");
        System.out.println("Table Created.");

        int c = -1;
        while (c != 0) {
            System.out.println("\n1.Insert\n2.Display All\n3.Search by Title\n4.Update Price\n5.Search by Author\n6.Delete by title\n0.Exit\n>> ");
            c = sc.nextInt();
            sc.nextLine(); 

            switch (c) {
               case 1 -> {
		    System.out.println("Enter ID, Author, Title, and Price:");
		    
		    String sql = "INSERT INTO book VALUES(?, ?, ?, ?)";
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, sc.nextInt());      
		    sc.nextLine();                     
		    pstmt.setString(2, sc.nextLine());  
		    pstmt.setString(3, sc.nextLine());  
		    pstmt.setInt(4, sc.nextInt());     
		    
		    pstmt.executeUpdate();
		    System.out.println("Success!");
		    pstmt.close();
		}
                case 2 -> {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM book");
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getInt(4));
                    }
                    rs.close();
                }
                case 3->{
                	PreparedStatement p=conn.prepareStatement("Select * from book where title=?");
                	System.out.print("Title :");
                	p.setString(1,sc.nextLine());
                	ResultSet rs=p.executeQuery();
                	if(rs.next())
                	{
                		do{
                			System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getInt(4));
                		}while(rs.next());
                	}
                	else
                		System.out.println("Book not Found !!");
                	p.close();
                	rs.close();
                }
                case 5->{
                	PreparedStatement p=conn.prepareStatement("Select * from book where author=?");
                	System.out.print("Author :");
                	p.setString(1,sc.nextLine());
                	ResultSet rs=p.executeQuery();
                	if(rs.next())
                	{
                		do{
                			System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getInt(4));
                		}while(rs.next());
                	}
                	else
                		System.out.println("Book not Found !!");
                	p.close();
                	rs.close();
                }
                case 6->{
                	PreparedStatement p=conn.prepareStatement("Delete from book where title=?");
                	System.out.print("Title :");
                	p.setString(1,sc.nextLine());
                	try{
                		p.executeUpdate();
                	}
                	catch(Exception e ){}
                	
                	
                	p.close();
                	
                }
                 case 4->{
                	PreparedStatement p=conn.prepareStatement("Update book set price=? where title=?");
                	System.out.print("Title :");
                	p.setString(2,sc.nextLine());
                	System.out.print("Updated Price :");
                	p.setInt(1,sc.nextInt());
                	
                	try{
                		p.executeUpdate();
                	}
                	catch(Exception e ){}
                	
                	
                	p.close();
                	
                }
                case 0 -> System.out.println("Closing...");
            }
        }

        
        stmt.close();
        conn.close();
        sc.close();
    }
}

