package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AbsGenericoDaoImpl {
	
	protected Connection conn;
	protected PreparedStatement ps; //el actor principal para preparar y ejecutar
	protected ResultSet rs; // para leer el fichero que genera bbddatos
	protected String sql; //la sentencia sql
	protected int filas; //para actualizar
	
	public AbsGenericoDaoImpl() {
		
		conn = ConexionMy8.getConexion();
	}
}

