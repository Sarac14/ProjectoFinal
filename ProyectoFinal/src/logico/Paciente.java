package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Paciente extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	private String tipoSangre;
	private String edad;
	private float peso;
	private float estatura;
	private float presionAlterial;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<HistorialClinico> miHistorialClinicos;

	public Paciente(String cedula, String nombre, String direccion, String telefono, char sexo, String tipoSangre,
			String edad, float peso, float estatura, float presionAlterial) {
		super(cedula, nombre, direccion, telefono, sexo);
		this.tipoSangre = tipoSangre;
		this.peso = peso;
		this.estatura = estatura;
		this.presionAlterial = presionAlterial;
		this.edad = edad;
		this.misVacunas = new ArrayList<>();
		this.miHistorialClinicos = new ArrayList<>();
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

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public void agregarHistorial(HistorialClinico auxHistorialClinico) {
		miHistorialClinicos.add(auxHistorialClinico);
	}

}
