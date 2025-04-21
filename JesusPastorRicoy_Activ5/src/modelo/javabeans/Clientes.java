package modelo.javabeans;

import java.io.Serializable;

public class Clientes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String cif;
	private String nombre;
	private String apellidos;
	private String domicilio;
	private double facturacion_anual;
	private int numero_empleados;
	
	public Clientes(String cif, String nombre, String apellidos, String domicilio, double facturacion_anual,
			int numero_empleados) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.domicilio = domicilio;
		this.facturacion_anual = facturacion_anual;
		this.numero_empleados = numero_empleados;
	}

	public Clientes() {
		super();
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public double getFacturacion_anual() {
		return facturacion_anual;
	}

	public void setFacturacion_anual(double facturacion_anual) {
		this.facturacion_anual = facturacion_anual;
	}

	public int getNumero_empleados() {
		return numero_empleados;
	}

	public void setNumero_empleados(int numero_empleados) {
		this.numero_empleados = numero_empleados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((cif == null) ? 0 : cif.hashCode());
		result = prime * result + ((domicilio == null) ? 0 : domicilio.hashCode());
		long temp;
		temp = Double.doubleToLongBits(facturacion_anual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + numero_empleados;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Clientes))
			return false;
		Clientes other = (Clientes) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (cif == null) {
			if (other.cif != null)
				return false;
		} else if (!cif.equals(other.cif))
			return false;
		if (domicilio == null) {
			if (other.domicilio != null)
				return false;
		} else if (!domicilio.equals(other.domicilio))
			return false;
		if (Double.doubleToLongBits(facturacion_anual) != Double.doubleToLongBits(other.facturacion_anual))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numero_empleados != other.numero_empleados)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", domicilio=" + domicilio
				+ ", facturacion_anual=" + facturacion_anual + ", numero_empleados=" + numero_empleados + "]";
	}
	
	
}

	
