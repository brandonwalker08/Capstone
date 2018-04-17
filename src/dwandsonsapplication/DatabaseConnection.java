package dwandsonsapplication;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;


public class DatabaseConnection {

	
	public Connection connect() {
		Connection connect = null;
                
		
		try {
			String location  = "jdbc:sqlite:C:/DWandSons/sqlite3/gui/SQLiteStudio/Customers.db";
			
			connect = DriverManager.getConnection(location);
			if(connect != null) {
			}
			
		}
		
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return connect;
	}

	
}