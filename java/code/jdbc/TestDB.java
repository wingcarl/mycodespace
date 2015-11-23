package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class TestDB {
	
	public static void main(String[] args) throws IOException{
		try{
			runTest();
		}catch(SQLException ex){
			for(Throwable t : ex)
				t.printStackTrace();
		}
	}
	public static void runTest() throws SQLException,IOException{
		try(Connection conn = getConnection()){
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
			stmt.executeUpdate("INSERT INTO Greetings VALUES('Hello,World')");
			
			try(ResultSet result = stmt.executeQuery("SELECT * FROM Greetings")){
				if(result.next())
					System.out.println(result.getString("Message"));
			}
		}
	}
	public static Connection getConnection() throws SQLException,IOException{
		Properties props = new Properties();
		try(InputStream inStream = Files.newInputStream(Paths.get("mail","database.properties"))){
			props.load(inStream);
			String drivers = props.getProperty("jdbc.drivers");
			if(drivers!=null) System.setProperty("jdbc.drivers", drivers);
			String url = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			
			return DriverManager.getConnection(url, username, password);
		}
	}
}
