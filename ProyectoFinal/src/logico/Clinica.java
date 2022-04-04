package logico;

import java.security.KeyStore.TrustedCertificateEntry;

import java.util.ArrayList;

import javax.swing.plaf.InputMapUIResource;

import logico.Clinica;

public class Clinica {

	private ArrayList<Cita>misCitas;
	private ArrayList<Consulta>misConsultas;
	private ArrayList<Doctor>misDoctores;
	private ArrayList<Enfermedad>misEnfermedades;
	private ArrayList<HistorialClinico>misHistoriales;
	private ArrayList<Paciente>misPacientes;
	private ArrayList<Vacuna>misVacunas;
	private ArrayList<Persona>misPersonas;
	public static Clinica clinica = null;

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

	public static Clinica getInstance() {
		if (clinica == null) {
			clinica = new Clinica();
		}
		return clinica;
	}

	public Persona buscarPaciente(String buscar) {
		for(Persona auxPaciente: misPacientes) {
			if(auxPaciente instanceof Paciente) {
				if(auxPaciente.getCedula().equalsIgnoreCase(buscar)) {
					return auxPaciente;
				}
			}

		}
		return null;
	}

	public Persona buscarPersonaPorNombre(String buscar) {
		for(Persona auxPaciente: misPersonas) {
			if(auxPaciente instanceof Doctor) {
				return null;
			}else{
				if(auxPaciente.getNombre().equalsIgnoreCase(buscar)) {
					return auxPaciente;
				}

			}
		}
			return null;
		}

		public Doctor buscarDoctor(String buscar) {
			for(Doctor auxdoDoctor: this.misDoctores) {
				if(auxdoDoctor.getCedula().equalsIgnoreCase(buscar)) {
					return auxdoDoctor;
				}
			}
			return null;
		}
	
		public Vacuna buscarVacuna(String buscar) {
			for(Vacuna auxVacuna: this.misVacunas) {
				if(auxVacuna.getCodigo().equalsIgnoreCase(buscar)) {
					return auxVacuna;
				}
			}
			return null;
		}

		public Enfermedad buscarEnfermedad(String buscar) {
			for(Enfermedad auxEnfermedad: this.misEnfermedades) {
				if(auxEnfermedad.getEnfermedadNombre().equalsIgnoreCase(buscar)) {
					return auxEnfermedad;
				}
			}
			return null;
		}

		public Cita buscarCita(String buscar) {
			for(Cita auxCita: misCitas) {
				if(auxCita.getCodigo().equalsIgnoreCase(buscar)) {
					return auxCita;
				}
			}
			return null;
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

		public int buscarIndexForPersona(String aux) {
			int i = 0;
			int index = -1;
			boolean encontrado = false;
			while(encontrado == false && misPacientes.size() < i) {
				if(misPacientes.get(i).getCedula().contains(aux)) {
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
	}
