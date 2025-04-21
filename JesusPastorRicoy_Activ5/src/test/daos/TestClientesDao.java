package test.daos;

import java.util.List;

import modelo.dao.ClientesDao;
import modelo.dao.ClientesDaoImplMy8Jdbc;
import modelo.javabeans.Clientes;

public class TestClientesDao {
	private static ClientesDao cdao;
	
	static {
		cdao = new ClientesDaoImplMy8Jdbc();
	}
	public static void main(String[] args) {
		//finById();
		//insertOne();
		//findAll();
		//deleteOne();
		//exportar();
		importar();
	}
	
	public static void finById() {
		System.out.println("MOSTRAR UNA REGION");
		
		System.out.println("EL Cliente existe : " + cdao.findById("A11111111"));
		System.out.println("EL Cliente NOOO existe : " + cdao.findById("A11111133"));
	}
	public static void insertOne() {
		System.out.println("\nINSERTAR UN CLIENTE\n");
    	Clientes cliente1 = new Clientes("77173844H", "Jesus", "Pastor", "C/ Tahivilla", 85000.0, 10);
    	System.out.println("Cliente nuevo insertado: " + cdao.insertOne(cliente1));
	}
	public static void findAll() {
		System.out.println("\nTodos\n");
		for(Clientes ele: cdao.findAll())
			System.out.println(ele);
	}
	public static void deleteOne() {
		switch(cdao.deleteOne("B33333333")) {
		case 1: System.out.println("Borrado");
		break;
		case 0: System.out.println("No existe");
		break;
		default: System.out.println("No se puede eliminar, porque no hay cliente con este cif");
		}
	}
	public static void exportar() {
        System.out.println("\nExportamos cliente a fichero\n");
        String mensaje = cdao.exportar("clientes.obj");
        System.out.println(mensaje);
    }
	 public static void importar() {
	        System.out.println("\nImportamos Cliente a fichero\n");
	        List<Clientes> lista = cdao.importar("clientes.obj");
	        for (Clientes ele : lista) {
	            System.out.println(ele);
	        }
	    }
	}

