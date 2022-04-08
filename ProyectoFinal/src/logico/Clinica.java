package logico;

import java.io.Serializable;

import java.util.ArrayList;

import logico.Clinica;

public class Clinica implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Cita> misCitas;
	private ArrayList<Consulta> misConsultas;
	private ArrayList<Doctor> misDoctores;
	private ArrayList<Enfermedad> misEnfermedades;
	private ArrayList<HistorialClinico> misHistoriales;
	private ArrayList<Paciente> misPacientes;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<Persona> misPersonas;
	public static Clinica clinica = null;
	private static Clinica control;
	private static Doctor loginDoctor;
	private ArrayList<String> sintomasPaciente;
	

	public Clinica() {
		super();
		misCitas = new ArrayList<>();
		misConsultas = new ArrayList<>();
		misDoctores = new ArrayList<>();
		misEnfermedades = new ArrayList<>();
		misHistoriales = new ArrayList<>();
		misPacientes = new ArrayList<>();
		misVacunas = new ArrayList<>();
		misPersonas = new ArrayList<>();
		sintomasPaciente = new ArrayList<>();
		
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
		return misEnfermedades;
	}

	public void setMiEnfermedades(ArrayList<Enfermedad> miEnfermedades) {
		this.misEnfermedades = miEnfermedades;
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

	public ArrayList<Enfermedad> getMisEnfermedades() {
		return misEnfermedades;
	}

	public void setMisEnfermedades(ArrayList<Enfermedad> misEnfermedades) {
		this.misEnfermedades = misEnfermedades;
	}

	public static Clinica getClinica() {
		return clinica;
	}

	public static void setClinica(Clinica clinica) {
		Clinica.clinica = clinica;
	}

	public static Clinica getControl() {
		return control;
	}

	public static void setControl(Clinica control) {
		Clinica.control = control;
	}

	public static Doctor getLoginDoctor() {
		return loginDoctor;
	}

	public static void setLoginDoctor(Doctor loginDoctor) {
		Clinica.loginDoctor = loginDoctor;
	}

	public void agregarCita(Cita cita) {
		misCitas.add(cita);
	}

	public void agregarPersona(Persona persona) {
		misPersonas.add(persona);

	}

	public void agregarDoctor(Doctor doctor) {
		misDoctores.add(doctor);
	}

	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}

	public void setMisPersonas(ArrayList<Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}

	public static Clinica getInstance() {
		if (clinica == null) {
			clinica = new Clinica();
		}
		return clinica;
	}

	public Paciente buscarPaciente(String buscar) {
		for (Paciente auxPaciente : misPacientes) {
			if (auxPaciente.getCedula().equalsIgnoreCase(buscar)) {
				return auxPaciente;
			}

		}
		return null;
	}

	public Persona buscarPersonaPorNombre(String buscar) {
		for (Persona auxPaciente : misPersonas) {
			if (auxPaciente instanceof Doctor) {
				return null;
			} else {
				if (auxPaciente.getNombre().equalsIgnoreCase(buscar)) {
					return auxPaciente;
				}

			}
		}
		return null;
	}

	public Doctor buscarDoctor(String buscar) {
		for (Doctor auxdoDoctor : this.misDoctores) {
			if (auxdoDoctor.getCedula().equalsIgnoreCase(buscar)) {
				return auxdoDoctor;
			}
		}
		return null;
	}
	
	public Doctor buscarDoctorporNombre(String buscar) {
		for (Doctor auxdoDoctor : this.misDoctores) {
			if (auxdoDoctor.getNombre().equalsIgnoreCase(buscar)) {
				return auxdoDoctor;
			}
		}
		return null;
	}

	public Vacuna buscarVacuna(String buscar) {
		for (Vacuna auxVacuna : this.misVacunas) {
			if (auxVacuna.getCodigo().equalsIgnoreCase(buscar)) {
				return auxVacuna;
			}
		}
		return null;
	}

	public Enfermedad buscarEnfermedad(String buscar) {
		for (Enfermedad auxEnfermedad : this.misEnfermedades) {
			if (auxEnfermedad.getEnfermedadNombre().equalsIgnoreCase(buscar)) {
				return auxEnfermedad;
			}
		}
		return null;
	}

	public Cita buscarCita(String buscar) {
		for (Cita auxCita : misCitas) {
			if (auxCita.getCodigo().equalsIgnoreCase(buscar)) {
				return auxCita;
			}
		}
		return null;
	}

	public int buscarIndexForPersona(String aux) {
		int i = 0;
		int index = -1;
		boolean encontrado = false;
		while (encontrado == false && misPacientes.size() < i) {
			if (misPacientes.get(i).getCedula().contains(aux)) {
				index = i;
				encontrado = true;
			}
			i++;
		}
		return index;
	}

	public void agregarPaciemnte(Paciente paciente) {
		misPacientes.add(paciente);
	}

	public void agregarConsulta(Consulta auxConsulta) {
		misConsultas.add(auxConsulta);
	}

	public void agregarHistorial(HistorialClinico auxConsulta) {
		misHistoriales.add(auxConsulta);
	}

	public boolean confirmLogin(String user, String pass) {
		boolean login = false;
		for (Doctor userDoc : misDoctores) {
			if (userDoc.getUsuarioDoctor().equals(user) && userDoc.getContrasenaDoctor().equals(pass)) {
				loginDoctor = userDoc;
				login = true;
			}
		}
		return login;
	}

	public void agregarEnfermedad(Enfermedad enfermedad) {
		misEnfermedades.add(enfermedad);

	}

	public void agregarVacuna(Vacuna vacuna) {
		misVacunas.add(vacuna);

	}

	public ArrayList<String> getSintomasPaciente() {
		return sintomasPaciente;
	}

	public void setSintomasPaciente(ArrayList<String> sintomasPaciente) {
		this.sintomasPaciente = sintomasPaciente;
	}
	
	public ArrayList<Enfermedad> buscarEnfermedadesPorSintomas(ArrayList<String> sintomasArrayList) {
		
		ArrayList<Enfermedad>encontradas = new ArrayList<>();
		
		for (String dato : sintomasArrayList) {
			for (Enfermedad auxEnfermedad : misEnfermedades) {
				for (String string : auxEnfermedad.getSintomas()) {
					
				}
			}
		}
		
		return encontradas;
	}
}
