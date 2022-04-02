package logico;

import java.util.ArrayList;

public class Doctor extends Persona {
	private String Especialidad;
	private ArrayList<Cita>misCitas;
	
	public Doctor(String cedula, String nombre, String dirrecion, String telefono, char sexo, String especialidad) {
		super(cedula, nombre, dirrecion, telefono, sexo);
		Especialidad = especialidad;
		this.misCitas = new ArrayList<>();
	}
	
	public String getEspecialidad() {
		return Especialidad;
	}
	public void setEspecialidad(String especialidad) {
		Especialidad = especialidad;
	}
	public ArrayList<Cita> getMisCitas() {
		return misCitas;
	}
	public void setMisCitas(ArrayList<Cita> misCitas) {
		this.misCitas = misCitas;
	}

}
