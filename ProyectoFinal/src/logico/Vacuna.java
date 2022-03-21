package logico;

import java.sql.Date;

public class Vacuna extends Proceso {
	
	private String nombre;

	public Vacuna(String codigo, String paciente, String doctor, Date fecha, String nombreñ) {
		super(codigo, paciente, doctor, fecha);
		this.nombre = nombreñ;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
