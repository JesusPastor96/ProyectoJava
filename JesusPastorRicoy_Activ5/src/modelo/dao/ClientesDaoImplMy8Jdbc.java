package modelo.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Clientes;

public class ClientesDaoImplMy8Jdbc extends AbsGenericoDaoImpl implements ClientesDao{

	
	public ClientesDaoImplMy8Jdbc() {
		super();
	}

	@Override
	public int insertOne(Clientes clientes) {
		sql = "insert into clientes (cif, nombre, apellidos, domicilio, facturacion_anual, numero_empleados) values (?,?,?,?,?,?)";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, clientes.getCif());
	        ps.setString(2, clientes.getNombre());
	        ps.setString(3, clientes.getApellidos());
	        ps.setString(4, clientes.getDomicilio());
	        ps.setDouble(5, clientes.getFacturacion_anual());
	        ps.setInt(6, clientes.getNumero_empleados());

	        filas = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Clientes findById(String cif) {
		 sql = "SELECT * FROM clientes WHERE cif = ?";
	     Clientes clientes = null;

	     try {
	       ps = conn.prepareStatement(sql);
	       ps.setString(1, cif);
	       rs = ps.executeQuery();

	         if (rs.next()) {
	           clientes = new Clientes();

	           clientes.setCif(rs.getString("cif"));
	           clientes.setNombre(rs.getString("nombre"));
	           clientes.setApellidos(rs.getString("apellidos"));
	           clientes.setDomicilio(rs.getString("domicilio"));
	           clientes.setFacturacion_anual(rs.getDouble("facturacion_anual"));
	           clientes.setNumero_empleados(rs.getInt("numero_empleados"));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return clientes;
	    }

	@Override
	public List<Clientes> findAll() {
		sql = "select * from clientes";
		List<Clientes> aux = new ArrayList<Clientes>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Clientes clientes = new Clientes();
				
				clientes.setCif(rs.getString("cif"));
				clientes.setNombre(rs.getString("nombre"));
				clientes.setApellidos(rs.getString("apellidos"));
                clientes.setDomicilio(rs.getString("domicilio"));
                clientes.setFacturacion_anual(rs.getDouble("facturacion_anual"));
                clientes.setNumero_empleados(rs.getInt("numero_empleados"));
                
                aux.add(clientes);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}

	@Override
	public int deleteOne(String cif) {
		sql = "delete from clientes where cif = ?";
		filas = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif);
			filas = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public String exportar(String nombreFichero) {
		List<Clientes> aux = new ArrayList<Clientes>();
		
		try {
			FileOutputStream fos = new FileOutputStream(nombreFichero);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(aux);
			
			oos.close();
			fos.close();
			
			return "Clientes bien exportados";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Fichero no existe";
		}
		
	}

	@Override
	public List<Clientes> importar(String nombreFichero) {
		List<Clientes> aux = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(nombreFichero);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			aux = (List<Clientes>) ois.readObject();
			
			ois.close();
			fis.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}
	
	
}
