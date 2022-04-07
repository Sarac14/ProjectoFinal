package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class HistorialClinico extends Proceso implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Consulta> misConsulta;
	private Consulta laConsulta;

	public HistorialClinico(String codigo, String paciente, String doctor, String fecha, Consulta laConsulta) {
		super(codigo, paciente, doctor, fecha);
		this.setLaConsulta(laConsulta);
	}

	public void agregarConsulta(Consulta nuevaConsulta) {
		misConsulta.add(nuevaConsulta);
	}

	public ArrayList<Consulta> getMisConsulta() {
		return misConsulta;
	}

	public void setMisConsulta(ArrayList<Consulta> misConsulta) {
		this.misConsulta = misConsulta;
	}

	public Consulta getLaConsulta() {
		return laConsulta;
	}

	public void setLaConsulta(Consulta laConsulta) {
		this.laConsulta = laConsulta;
	}

}
