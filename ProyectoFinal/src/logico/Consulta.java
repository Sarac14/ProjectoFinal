package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Consulta extends Proceso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<String> sintomas;
	private String diagnostico;
	private String enfermedad;

	public Consulta(String codigo, String paciente, String doctor, String fecha, ArrayList<String> sintomas,
			String diagnostico, String enfermedad) {
		super(codigo, paciente, doctor,fecha);
		sintomas = new ArrayList<>();
		this.diagnostico = diagnostico;
		this.enfermedad = enfermedad;
	}

	
	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}


	public ArrayList<String> getSintomas() {
		return sintomas;
	}


	public void setSintomas(ArrayList<String> sintomas) {
		this.sintomas = sintomas;
	}


	public String getEnfermedad() {
		return enfermedad;
	}


	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}


}
