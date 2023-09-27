package gestionnotasalumnos;

public class Comicion {
	
	private Integer id;
	private Materia materia;
	private CicloLectivo cicloLectivo;
	private Enum turno;
	
	public Comicion(Integer id, Materia materia, CicloLectivo cicloLectivo, Enum turno) {
		this.id = id;
		this.materia = materia;
		this.cicloLectivo = cicloLectivo;
		this.turno = turno;
	}

	public Integer getId() {
		return id;
	}

	public Materia getMateria() {
		return materia;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public Enum getTurno() {
		return turno;
	}
	
	

}
