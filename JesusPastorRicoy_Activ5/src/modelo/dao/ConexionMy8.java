package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMy8 {
	
	private static Connection conn;
	private String urlXampp = "jdbc:mysql://localhost:3306/proyectos_fp_2025";
	private String user = "root";
	private String passwordXampp = "";
	
	private ConexionMy8() {
	try {
		conn = DriverManager.getConnection(urlXampp, user, passwordXampp);
		System.out.println("CONEXION ESTABLECIDA");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		System.out.println("CONEXION NOO ESTABLECIDA");
	}
	}
	
	public static Connection getConexion() {
		
		if (conn == null)
			new ConexionMy8();
		
		return conn;
	}
}

