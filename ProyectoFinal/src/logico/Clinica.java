package logico;

import java.util.ArrayList;

public class Clinica {
	
	private ArrayList<Cita>misCitas;
	private ArrayList<Consulta>misConsultas;
	private ArrayList<Doctor>misDoctores;
	private ArrayList<Enfermedad>miEnfermedades;
	private ArrayList<HistorialClinico>misHistoriales;
	private ArrayList<Paciente>misPacientes;
	private ArrayList<Vacuna>misVacunas;
	
	public Clinica(ArrayList<Cita> misCitas, ArrayList<Consulta> misConsultas, ArrayList<Doctor> misDoctores,
			ArrayList<Enfermedad> miEnfermedades, ArrayList<HistorialClinico> misHistoriales,
			ArrayList<Paciente> misPacientes, ArrayList<Vacuna> misVacunas) {
		super();
		this.misCitas = misCitas;
		this.misConsultas = misConsultas;
		this.misDoctores = misDoctores;
		this.miEnfermedades = miEnfermedades;
		this.misHistoriales = misHistoriales;
		this.misPacientes = misPacientes;
		this.misVacunas = misVacunas;
	}

	public ArrayList<Cita> getMisCitas() {
		return misCitas;
	}

	public void setMisCitas(ArrayList<Cita> misCitas) {
		this.misCitas = misCitas;
	}

	public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}

	public void setMisConsultas(ArrayList<Consulta> misConsultas) {
		this.misConsultas = misConsultas;
	}

	public ArrayList<Doctor> getMisDoctores() {
		return misDoctores;
	}

	public void setMisDoctores(ArrayList<Doctor> misDoctores) {
		this.misDoctores = misDoctores;
	}

	public ArrayList<Enfermedad> getMiEnfermedades() {
		return miEnfermedades;
	}

	public void setMiEnfermedades(ArrayList<Enfermedad> miEnfermedades) {
		this.miEnfermedades = miEnfermedades;
	}

	public ArrayList<HistorialClinico> getMisHistoriales() {
		return misHistoriales;
	}

	public void setMisHistoriales(ArrayList<HistorialClinico> misHistoriales) {
		this.misHistoriales = misHistoriales;
	}

	public ArrayList<Paciente> getMisPacientes() {
		return misPacientes;
	}

	public void setMisPacientes(ArrayList<Paciente> misPacientes) {
		this.misPacientes = misPacientes;
	}

	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}

	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}
	
	

}
