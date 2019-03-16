package connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String URL = "jdbc:mysql://localhost:3306/musica";
	private static final String SENHA = "logatti";
	private static final String USUARIO = "root";

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
}
