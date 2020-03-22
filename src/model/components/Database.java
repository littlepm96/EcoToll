package model.components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Qui va il collegamento al Database
public class Database {
	
	private static String LOCATION="jdbc:mysql://localhost:3306/pedaggiautostrade?serverTimezone=UTC";
		
	private static String NAME="root";
	private static String PSW="root";
	
	
	//Effettua connessione DB
	public Connection Connect() {
		
	
		Connection myConn;
		
		try {
			myConn=DriverManager.getConnection(LOCATION,NAME,PSW);
			System.out.println("\n----Connessione Effettuata Corretamente al Database---- ");
			return myConn;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}