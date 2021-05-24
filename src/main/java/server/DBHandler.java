package server;

import java.sql.*;



public class DBHandler {
	private static Connection connection;
	private static PreparedStatement psCreatingNewClient;
	private static PreparedStatement psIsCopy ;
//	private static PreparedStatement ;
//
//	private static PreparedStatement ;
//	private static PreparedStatement;

	public static boolean connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:main.db");
			prepareAllStatements();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void disconnect() {
		try {
			psCreatingNewClient.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}



	private static void prepareAllStatements() throws SQLException {
		psCreatingNewClient = connection.prepareStatement("INSERT INTO clientData(first_name, last_name, passport, is_banned) VALUES (? ,? ,? ,? );");
		// psIsCopy = connection.prepareStatement("SELECT id, first_name, last_name, passport FROM clientData WHERE id = ? AND first_name = ? AND last_name = ? AND passport = ?;");
	}


	private static void findingSimilarities(){

	}
//
//	public static String getClientDataByPassport(int passport) {
//		String firstName = null;
//		String lastName = null;
//		String passportN = null;
//		Integer id = null;
//		try {
//			psIsCopy.setInt(4,passport);
////			psIsCopy.setString(1, first_name);
////			psIsCopy.setString(2, last_name);
////			psIsCopy.setString(3, passport);
//			ResultSet rs = psIsCopy.executeQuery();
//			if (rs.next()) {
//				id=rs.getInt(1);
//				firstName = rs.getString(2);
//				lastName = rs.getString(3);
//			//	passportN = rs.getString(4);
//			}
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return id+ " "+ firstName+" "+ lastName+" "+ passport ;
//	}
//
//
//	private static boolean isCopy(String first_name, String last_name, String passport){

//		if((first_name+" "+ last_name + " " +passport) == getClientData()){
//			return true;
//		}
//		return false;
//	}


	

	public static boolean creatingNewClient(String first_name, String last_name, String passport) {
		try {
			psCreatingNewClient.setString(1, first_name);
			psCreatingNewClient.setString(2, last_name);
			psCreatingNewClient.setString(3, passport);
			psCreatingNewClient.setInt(3, 0);
//			if(isCopy(first_name,last_name,passport)){
//				return false;
//			}
			psCreatingNewClient.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
//	private static Connection connection;
//	private static PreparedStatement stm;
//
//	public void connect() throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.cj.jdbc.JdbcConnection");
//		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/main.db");
//		stm = (PreparedStatement)connection.createStatement();
//
//	}
//	public void disconnect(){
//		try {
//			stm.close();
//		} catch (SQLException throwables) {
//			throwables.printStackTrace();
//		}
//		try {
//			connection.close();
//		} catch (SQLException throwables) {
//			throwables.printStackTrace();
//		}
//	}

