package Model;
import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
public static Connection createConnection() throws Exception{
	 Class.forName("com.mysql.cj.jdbc.Driver");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/puzzlegame?useSSL=false","root","root");
     return con;
}
}
 // Database connection class