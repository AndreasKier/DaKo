package db_connection;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Kopiert aus übung 8
public class DB_Connection {
	
	private static DB_Connection instance;
	private static Connection connection=null;
	private static Statement st=null;
	private static ResultSet rs=null;
	private String sDbDriver=null, sDbUrl=null, sUsr="", sPwd=""; {
		sDbDriver="com.mysql.jdbc.Driver";
		sDbUrl = "jdbc:mysql://localhost:3306/studienarbeit?serverTimezone=UTC";
		sUsr="root";
		sPwd="init";
	}

	//Konstruktor
	private DB_Connection()
	{ }

	//verbinden zur Datenbank
	private void connect_DB() {
		try { 
			//Database driver auswählen und connect
			Class.forName(sDbDriver);
		}
		catch(ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
		}
		try {
			connection = DriverManager.getConnection(sDbUrl, sUsr, sPwd);
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
		}
	}

	//erstelle oder gib die Datenbankverbindung (singleton pattern)
	public static DB_Connection getDbConnection(){
		if (instance == null) {
			instance = new DB_Connection();
			instance.connect_DB();
		}
		return instance;
	}
	
	//define generic SQL query for table 'student'
	public static String getAlleStudenten() {
		return "SELECT * FROM student";
	}

	//connect and execute input query and return boolean
	public boolean executequery(String SQLquery) throws SQLException {

		//insert resp. delete resp. modify data base entry
		if (connection==null) throw new SQLException("Keine gültige Verbindung zur Datenbank");
		if (SQLquery==null) throw new SQLException("Ungültiger SQL-Befehl");
		Statement st = connection.createStatement();
		st.execute(SQLquery);
		return true;
	}
	
	//connect and execute input query and return result set
	public ResultSet executequery_rs(String SQLquery) throws SQLException { 
		// select entries
		if (connection==null) throw new SQLException("Keine gültige Verbindung zur Datenbank");
		if (SQLquery==null) throw new SQLException("Ungültiger SQL-Befehl");
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(SQLquery);
		return rs;
	}

	//2. connect, execute input query and return generatedID of the generated key
	public int executequery_autoKey(String SQLquery, boolean autoKey) throws SQLException {
		if (connection==null) throw new SQLException("Keine gültige Verbindung zur Datenbank");
		if (SQLquery==null) throw new SQLException("Ungültiger SQL-Befehl");
		Statement st = connection.createStatement();
		st = connection.createStatement();
		if (autoKey) {
			ResultSet generatedKeys = null;
			int generatedID = -1;
			st.execute(SQLquery, Statement.RETURN_GENERATED_KEYS);
			generatedKeys = st.getGeneratedKeys();
			if (generatedKeys.next())
				generatedID = generatedKeys.getInt(1);
			else throw new SQLException("Es wurden keine erzeugten Keys gefunden" + SQLquery);
			
			if (generatedID == -1) throw new SQLException("Es wurde kein erzeugter Key gefunden" + SQLquery);
			if (generatedKeys != null)
				generatedKeys.close();
			return generatedID;
		}
		else st.execute(SQLquery);
		return 0;
	}

	// save closing SQL query
	public void disconnect() throws SQLException{
		if (st != null) st.close();
		if (rs != null) rs.close();
	}
}
