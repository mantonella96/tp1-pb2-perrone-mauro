package gestionnotasalumnos;

public class Profesor {
	
	private Integer dni;
	private String nombre;
	private String apellido;
	
	public Profesor(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}
	
	

}
