package logico;

import java.util.Date;

public class Cita {
	private String codigo;
	private String cedula;
	private String persona;
	private	String fecha;
	private String doctor;
	
	public Cita(String codigo, String cedula, String persona, String fecha, String doctor) {
		super();
		this.setCodigo(codigo);
		this.cedula = cedula;
		this.persona = persona;
		this.fecha = fecha;
		this.doctor = doctor;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getPersona() {
		return persona;
	}
	public void setPersona(String persona) {
		this.persona = persona;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
