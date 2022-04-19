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


	public static void setControl(Clinica control) {
		Clinica.clinica = control;
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
			if (auxVacuna.getNombre().equalsIgnoreCase(buscar)) {
				return auxVacuna;
			}
		}
		return null;
	}
	
	public void sumarDosisVacuna (String vacuna) {
		Vacuna laVacuna = buscarVacuna(vacuna);
		modificarVacuna(laVacuna);
	}
	
	public int buscarIndexForVacuna(String aux) {
		int i = 0;
		int index = -1;
		boolean encontrado = false;
		while (!encontrado && misVacunas.size() > i) {
			if (misVacunas.get(i).getCodigo().contains(aux)) {
				index = i;
				encontrado = true;
			}
			i++;
		}
		return index;
	}
	
	public void agregarVacunaPaciente(String cedula, String laVacuna) {
		int i = buscarIndexForPaciente(cedula);
		Vacuna auxVacuna = buscarVacuna(laVacuna);
		misPacientes.get(i).agregarVacuna(auxVacuna);
		
	}
	
	public void modificarVacuna(Vacuna newVacuna) {
		int index = buscarIndexForVacuna(newVacuna.getCodigo());
		int cantVacunas = newVacuna.getCantVacunas();
		cantVacunas++;
		misVacunas.get(index).setCantVacunas(cantVacunas);

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
			if (auxCita.getCedula().equalsIgnoreCase(buscar)) {
				return auxCita;
			}
		}
		return null;
	}
	
	public Cita buscarCitaCod(String buscar) {
		for (Cita auxCita : misCitas) {
			if (auxCita.getCodigo().equalsIgnoreCase(buscar)) {
				return auxCita;
			}
		}
		return null;
	}

	public int buscarIndexForPaciente(String aux) {
		int i = 0;
		int index = -1;
		boolean encontrado = false;
		while (!encontrado && misPacientes.size() > i) {
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

		for (String sintoma : sintomasArrayList) {
			for (Enfermedad auxEnfermedad : misEnfermedades) {
				for (String string : auxEnfermedad.getSintomas()) {
					if(sintoma.equalsIgnoreCase(string)) {
						if(!encontradas.contains(auxEnfermedad)) {
							encontradas.add(auxEnfermedad);
						}
						break;
					}
				}
			}
		}

		return encontradas;
	}
	public int buscarIndexForDoctor(String posSel) {
		int aux = -1;
		boolean encontrado =  false;
		int i = 0;
		while(!encontrado && i< misDoctores.size()) {
			if(misDoctores.get(i).getCedula().equalsIgnoreCase(posSel)) {
				aux = i;
				encontrado = true;
			}
			i++;
		}
		return aux;
	}

	public void modificarDoctor(Doctor elDoctor) {
		int index = buscarIndexForDoctor(elDoctor.getCedula());
		misDoctores.get(index).setNombre(elDoctor.getNombre());
		misDoctores.get(index).setTelefono(elDoctor.getTelefono());
		misDoctores.get(index).setDireccion(elDoctor.getDireccion());
		misDoctores.get(index).setEspecialidad(elDoctor.getEspecialidad());
		misDoctores.get(index).setAnioExp(elDoctor.getAnioExp());
		misDoctores.get(index).setUsuarioDoctor(elDoctor.getUsuarioDoctor());
		misDoctores.get(index).setContrasenaDoctor(elDoctor.getContrasenaDoctor());

	}

	public void modificarPaciente(Paciente newPaciente) {
		int index = buscarIndexForPaciente(newPaciente.getCedula());

		misPacientes.get(index).setNombre(newPaciente.getNombre());
		misPacientes.get(index).setCedula(newPaciente.getCedula());
		misPacientes.get(index).setDireccion(newPaciente.getDireccion());
		misPacientes.get(index).setTelefono(newPaciente.getTelefono());
		misPacientes.get(index).setEdad(newPaciente.getEdad());
		misPacientes.get(index).setEnfermo(newPaciente.isEnfermo());

	}

	public void modificarEnfermedad(Enfermedad newEnfermedad) {
		int index = buscarIndexForEnfermedad(newEnfermedad.getEnfermedadNombre());

		misEnfermedades.get(index).setEnfermedadNombre(newEnfermedad.getEnfermedadNombre());
		misEnfermedades.get(index).setSintomas(newEnfermedad.getSintomas());
	}

	private int buscarIndexForEnfermedad(String enfermedadNombre) {
		int aux = -1;
		boolean encontrado =  false;
		int i = 0;
		while(!encontrado && i< misEnfermedades.size()) {
			if(misEnfermedades.get(i).getEnfermedadNombre().equalsIgnoreCase(enfermedadNombre)) {
				aux = i;
				encontrado = true;
			}
			i++;
		}
		return aux;
	}

	public void modificarPersona(Persona persona) {
		int index = buscarIndexForPersona(persona.getCedula());

		misPersonas.get(index).setCedula(persona.getCedula());
		misPersonas.get(index).setDireccion(persona.getDireccion());
		misPersonas.get(index).setNombre(persona.getNombre());
		misPersonas.get(index).setSexo(persona.sexo);
		misPersonas.get(index).setTelefono(persona.getTelefono());

	}

	private int buscarIndexForPersona(String cedula) {
		int i = 0;
		int index = -1;
		boolean encontrado = false;
		while (!encontrado && misPersonas.size() > i) {
			if (misPacientes.get(i).getCedula().contains(cedula)) {
				index = i;
				encontrado = true;
			}
			i++;
		}
		return index;
	}

	public void modificarCita(Cita newCita) {
		int index = buscarIndexForCita(newCita.getCodigo());
		
		misCitas.get(index).setCedula(newCita.getCedula());
		misCitas.get(index).setCodigo(newCita.getCodigo());
		misCitas.get(index).setDoctor(newCita.getDoctor());
		misCitas.get(index).setFecha(newCita.getFecha());
		misCitas.get(index).setHora(newCita.getHora());
		misCitas.get(index).setPersona(newCita.getPersona());
		misCitas.get(index).setTipo(newCita.getTipo());
	}

	private int buscarIndexForCita(String codigo) {
		int i = 0;
		int index = -1;
		boolean encontrado = false;
		while (!encontrado && misCitas.size() > i) {
			if (misCitas.get(i).getCodigo().contains(codigo)) {
				index = i;
				encontrado = true;
			}
			i++;
		}
		return index;
	}
	
	public Consulta buscarConsulta(String buscar) {
		for (Consulta auxcConsulta : misConsultas) {
			if (auxcConsulta.getCodigo().equalsIgnoreCase(buscar)) {
				return auxcConsulta;
			}
		}
		return null;
	}

	public Paciente buscarPacientePorNombre(String nombre) {
		for (Paciente aux : misPacientes) {
			if(aux.getNombre().equalsIgnoreCase(nombre)) {
				return aux;
			}
		}
		return null;
	}

	public void agregarHistorialPaciente(HistorialClinico auxHistorialClinico, String cedula) {

		int index = buscarIndexForPaciente(cedula);
		misPacientes.get(index).agregarHistorial(auxHistorialClinico);
	}
}
