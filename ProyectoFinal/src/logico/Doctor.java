package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Doctor extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	private String Especialidad;
	private ArrayList<Cita> misCitas;
	private ArrayList<Paciente> misPacientes;
	private String usuarioDoctor;
	private String contrasenaDoctor;

	public Doctor(String cedula, String nombre, String direccion, String telefono, char sexo, String especialidad,
			String usuarioDoctor, String contrasenaDoctor) {

		super(cedula, nombre, direccion, telefono, sexo);
		Especialidad = especialidad;
		this.misCitas = new ArrayList<>();
		this.misPacientes = new ArrayList<>();
		this.usuarioDoctor = usuarioDoctor;
		this.contrasenaDoctor = contrasenaDoctor;
	}

	public ArrayList<Paciente> getMisPacientes() {
		return misPacientes;
	}

	public void setMisPacientes(ArrayList<Paciente> misPacientes) {
		this.misPacientes = misPacientes;
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
	public void agregarCita(Cita cita) {
		misCitas.add(cita);
	}

	public void agregarPersona(Paciente paciente) {
		misPacientes.add(paciente);

	}

}
