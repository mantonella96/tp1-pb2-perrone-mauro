package gestionnotasalumnos;

public class Aula {
	
	private Integer id;
	private Integer cantidadDeAlumnos;
	
	public Aula(Integer id, Integer cantidadDeAlumnos) {
		this.id = id;
		this.cantidadDeAlumnos = cantidadDeAlumnos;
	}

	public Integer getId() {
		return id;
	}

	public Integer getCantidadDeAlumnos() {
		return cantidadDeAlumnos;
	}
	
	

}
