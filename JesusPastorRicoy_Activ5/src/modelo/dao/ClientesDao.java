package modelo.dao;

import java.util.List;

import modelo.javabeans.Clientes;

public interface ClientesDao {
	
	int insertOne(Clientes clientes); //Alta del Cliente
	Clientes findById(String cif);	//Buscar un CLiente
	List<Clientes> findAll(); //Mostrar Todos
	int deleteOne(String cif); //Eliminar un cliente
	
	String exportar(String nombreFichero);
	List<Clientes> importar(String nombreFichero);
	
}
