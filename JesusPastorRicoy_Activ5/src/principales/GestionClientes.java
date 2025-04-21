package principales;

import java.util.List;
import java.util.Scanner;

import modelo.dao.ClientesDao;
import modelo.dao.ClientesDaoImplMy8Jdbc;
import modelo.javabeans.Clientes;

public class GestionClientes {
    private static Scanner Leer = new Scanner(System.in);
    private static ClientesDao cdao = new ClientesDaoImplMy8Jdbc();

    public static void main(String[] args) {
        int opcion = 0;

        do {
        	
            opcion = pintarmenu();

            switch (opcion) {
                case 1:
                    insertOne();
                    break;
                case 2:
                    findById();
                    break;
                case 3:
                    findAll();
                    break;
                case 4:
                    deleteOne();
                    break;
                case 5:
                    exportar();
                    break;
                case 6:
                    importar();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
        System.out.println("Fin de la aplicacion.");
        Leer.close();
    }

    public static int pintarmenu() {
    	int opcion = 0;
        System.out.println("\nMENÚ GESTIÓN CLIENTES");
        System.out.println("1. Alta del Cliente");
        System.out.println("2. Buscar un Cliente");
        System.out.println("3. Mostrar Todos");
        System.out.println("4. Eliminar un Cliente");
        System.out.println("5. Exportar a fichero");
        System.out.println("6. Importar desde fichero");
        System.out.println("7. Salir");
        
        System.out.println("\nTeclea una opcion, 7 para salir");
		opcion = Leer.nextInt();
		
		while (opcion < 1 || opcion > 7) {
			System.out.println("Opcion incorrecta, validos del 1 al 7");
			opcion = Leer.nextInt();
		}
		
		return opcion;
    }

    public static void insertOne() {
        System.out.println("\nALTA CLIENTE");

        System.out.print("Cif: ");
        String cif = Leer.nextLine();

        System.out.print("Nombre: ");
        String nombre = Leer.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = Leer.nextLine();

        System.out.print("Domicilio: ");
        String domicilio = Leer.nextLine();

        System.out.print("Facturación anual: ");
        double facturacion = Double.parseDouble(Leer.nextLine());

        System.out.print("Nº de empleados: ");
        int empleados = Integer.parseInt(Leer.nextLine());

        Clientes cliente1 = new Clientes(cif, nombre, apellidos, domicilio, facturacion, empleados);
        int resultado = cdao.insertOne(cliente1);

        if (resultado == 1) {
            System.out.println("✅ Cliente dado de alta.");
        } else {
            System.out.println("❌ Error al dar de alta.");
        }
    }

    public static void findById() {
        System.out.println("\nBUSCAR CLIENTE");
        System.out.print("Introduce el CIF: ");
        String cif = Leer.nextLine();

        Clientes c = cdao.findById(cif);
        if (c != null) {
            System.out.println("Cliente encontrado:\n" + c);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public static void findAll() {
        System.out.println("\nLISTA DE CLIENTES");
        List<Clientes> lista = cdao.findAll();
        for (Clientes ele : lista) {
            System.out.println(ele);
        }
    }

    public static void deleteOne() {
        System.out.println("\nELIMINAR CLIENTE");
        System.out.print("Introduce el CIF: ");
        String cif = Leer.nextLine();

        int resultado = cdao.deleteOne(cif);
        if (resultado == 1) {
            System.out.println("Cliente eliminado.");
        } else {
            System.out.println("Cliente no encontrado o error.");
        }
    }

    public static void exportar() {
        System.out.println("\nEXPORTAR CLIENTES");
        System.out.print("Nombre del fichero (ej: clientes.obj): ");
        String fichero = Leer.nextLine();
        String resultado = cdao.exportar(fichero);
        System.out.println(resultado);
    }

    public static void importar() {
        System.out.println("\nIMPORTAR CLIENTES");
        System.out.print("Nombre del fichero (ej: clientes.obj): ");
        String fichero = Leer.nextLine();
        List<Clientes> lista = cdao.importar(fichero);
        System.out.println("Clientes importados:");
        for (Clientes ele : lista) {
            System.out.println(ele);
        }
    }
}