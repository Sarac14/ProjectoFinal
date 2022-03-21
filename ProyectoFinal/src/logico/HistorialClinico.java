package logico;

import java.sql.Date;

public class HistorialClinico extends Proceso {
	private String hecho;
	private Consulta laConsulta;

	public HistorialClinico(String codigo, String paciente, String doctor, Date fecha, String hecho, Consulta laConsulta) {
		super(codigo, paciente, doctor, fecha);
		this.hecho = hecho;
		this.setLaConsulta(laConsulta);
	}

	public String getHecho() {
		return hecho;
	}

	public void setHecho(String hecho) {
		this.hecho = hecho;
	}

	public Consulta getLaConsulta() {
		return laConsulta;
	}

	public void setLaConsulta(Consulta laConsulta) {
		this.laConsulta = laConsulta;
	}
}
