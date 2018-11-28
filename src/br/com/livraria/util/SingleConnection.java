package br.com.livraria.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {

	private static String url = "jdbc:postgresql://localhost:5432/bd_livraria";
	private static String user = "postgres";
	private static String password = "postgres";

	public static Connection getConection() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeConection() {
		try {
			getConection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
