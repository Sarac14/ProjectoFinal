package logico;

import java.sql.Date;

public class Vacuna{
	
	private String codigo;
	private String nombre;
	private Enfermedad enfermedad;
	private Date fechaCaducidad;
	private int cantReal;

	

	public Vacuna(String codigo, String nombre, Enfermedad enfermedad, Date fechaCaducidad, int cantReal) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.enfermedad = enfermedad;
		this.fechaCaducidad = fechaCaducidad;
		this.cantReal = cantReal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Enfermedad getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getCantReal() {
		return cantReal;
	}

	public void setCantReal(int cantReal) {
		this.cantReal = cantReal;
	}
	
	
}
