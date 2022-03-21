package logico;

import java.util.ArrayList;

public class Paciente extends Persona {

	private String tipoSangre;
	private float peso;
	private float estatura;
	private float presionAlterial;
	private ArrayList<Vacuna>misVacunas;
	private ArrayList<HistorialClinico>miHistorialClinicos;


	public Paciente(String cedula, String nombre, String dirrecion, String telefono, String tipoSangre, float peso,
			float estatura, float presionAlterial, ArrayList<Vacuna> misVacunas,
			ArrayList<HistorialClinico> miHistorialClinicos) {
		super(cedula, nombre, dirrecion, telefono);
		this.tipoSangre = tipoSangre;
		this.peso = peso;
		this.estatura = estatura;
		this.presionAlterial = presionAlterial;
		this.misVacunas = misVacunas;
		this.miHistorialClinicos = miHistorialClinicos;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public float getPresionAlterial() {
		return presionAlterial;
	}

	public void setPresionAlterial(float presionAlterial) {
		this.presionAlterial = presionAlterial;
	}

	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}

	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}

	public ArrayList<HistorialClinico> getMiHistorialClinicos() {
		return miHistorialClinicos;
	}

	public void setMiHistorialClinicos(ArrayList<HistorialClinico> miHistorialClinicos) {
		this.miHistorialClinicos = miHistorialClinicos;
	}
	
}
