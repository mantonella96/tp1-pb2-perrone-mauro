package gestionnotasalumnos;

import java.util.ArrayList;

public class Curso {
	
	private Integer id;
	private Aula aula;
	private Profesor profesor;
	private Comicion comicion;
	private ArrayList<Alumno> alumnosCurso = new ArrayList<Alumno>();
	
	public Curso(Integer id, Aula aula, Profesor profesor, Comicion comicion, ArrayList<Alumno> alumnosCurso) {
		this.id = id;
		this.aula = aula;
		this.profesor = profesor;
		this.comicion = comicion;
		this.alumnosCurso = alumnosCurso;
	}
	
	public Integer getId() {
		return id;
	}

	public Aula getAula() {
		return aula;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public Comicion getComicion() {
		return comicion;
	}

	public ArrayList<Alumno> getAlumnosCurso() {
		return alumnosCurso;
	}
	
	public Boolean AgregarAlumnoAlCurso(Alumno alumno) {
		Boolean b = false;
		Boolean aux = false;
		for(int i = 0;i < alumnosCurso.size(); i++) {
			if(alumnosCurso.get(i).getDni() == alumno.getDni()) {
				aux = true;
			}
		}
		if(aux == false) {
			alumnosCurso.add(alumno);
			b = true;
		}
		return b;
	}
	


}
