package logico;

import java.util.ArrayList;

public class Enfermedad {
	
	private String enfermedadNombre;
	private ArrayList<String>sintomas;
	
	public Enfermedad(String enfermedadNombre) {
		super();
		this.enfermedadNombre = enfermedadNombre;
		this.sintomas = new ArrayList<>();
	}
	/*
	 * tos
	 * fiebre
	 * dolor de cabeza
	 * dolor muscular
	 * nauseas
	 * mareos
	 * dolor gastrico
	 * vomitos
	 * diarrea
	 * ictericia
	 * indigestion
	 * taquicardia
	 * fatiga
	 * 
	 * */
	public String getEnfermedadNombre() {
		return enfermedadNombre;
	}

	public void setEnfermedadNombre(String enfermedadNombre) {
		this.enfermedadNombre = enfermedadNombre;
	}

	public ArrayList<String> getSintomas() {
		return sintomas;
	}

	public void setSintomas(ArrayList<String> sintomas) {
		this.sintomas = sintomas;
	}

}
