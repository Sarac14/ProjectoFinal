package logico;

public class Persona {
	
	protected String cedula;
	protected String nombre;
	protected String dirrecion;
	protected String telefono;
	
	public Persona(String cedula, String nombre, String dirrecion, String telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.dirrecion = dirrecion;
		this.telefono = telefono;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDirrecion() {
		return dirrecion;
	}
	public void setDirrecion(String dirrecion) {
		this.dirrecion = dirrecion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
