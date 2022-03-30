package logico;

import java.sql.Date;

public class Vacuna{
	
	private String codigo;
	private String nombre;
	private Enfermedad enfermedad;
	private String fechaCaducidad;


	public Vacuna(String codigo, String nombre, Enfermedad enfermedad, String fechaCaducidad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.enfermedad = enfermedad;
		this.fechaCaducidad = fechaCaducidad;

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

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	
}
