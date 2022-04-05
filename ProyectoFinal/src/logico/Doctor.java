package logico;

import java.util.ArrayList;

public class Doctor extends Persona {
	private String Especialidad;
	private ArrayList<Cita>misCitas;
	private String usuarioDoctor;
	private String contrasenaDoctor;
	
	public Doctor(String cedula, String nombre, String direccion, String telefono, char sexo, String especialidad,
			ArrayList<Cita> misCitas, String usuarioDoctor, String contrasenaDoctor) {
		super(cedula, nombre, direccion, telefono, sexo);
		Especialidad = especialidad;
		this.misCitas = misCitas;
		this.usuarioDoctor = usuarioDoctor;
		this.contrasenaDoctor = contrasenaDoctor;
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

	public String getUsuarioDoctor() {
		return usuarioDoctor;
	}

	public void setUsuarioDoctor(String usuarioDoctor) {
		this.usuarioDoctor = usuarioDoctor;
	}

	public String getContrasenaDoctor() {
		return contrasenaDoctor;
	}

	public void setContrasenaDoctor(String contrasenaDoctor) {
		this.contrasenaDoctor = contrasenaDoctor;
	}

}
