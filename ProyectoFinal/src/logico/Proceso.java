package logico;

import java.sql.Date;

public abstract class Proceso {

	protected String codigo;
	protected String paciente;
	protected String doctor;
	protected Date fecha;
	
	public Proceso(String codigo, String paciente, String doctor, Date fecha) {
		super();
		this.codigo = codigo;
		this.paciente = paciente;
		this.doctor = doctor;
		this.fecha = fecha;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
