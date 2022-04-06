package logico;

import java.io.Serializable;
import java.sql.Date;

public class Consulta extends Proceso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String sintomas;
	private String diagnostico;

	public Consulta(String codigo, String paciente, String doctor, String fecha, String sintomas,
			String diagnostico) {
		super(codigo, paciente, doctor,fecha);
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}


}
