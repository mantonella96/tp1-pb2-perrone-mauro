package gestionnotasalumnos;

import java.util.ArrayList;

public class Universidad {

	private ArrayList<Profesor> profesores = new ArrayList<Profesor>();
	private ArrayList<Comicion> comiciones = new ArrayList<Comicion>();
	private ArrayList<Aula> aulas = new ArrayList<Aula>();
	private ArrayList<Materia> materias = new ArrayList<Materia>();
	private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	private ArrayList<CicloLectivo> ciclosLectivos = new ArrayList<CicloLectivo>();
	private ArrayList<Curso> cursos = new ArrayList<Curso>();

	public Universidad() {

	}

	public Boolean AgregarMaterias(Materia materia) {
		Boolean b = false;
		Boolean aux = false;
		for (int i = 0; i < materias.size(); i++) {
			if (materias.get(i).getId() == materia.getId()) {
				aux = true;
			}
		}
		if (aux == false) {
			materias.add(materia);
			b = true;
		}
		return b;
	}

	public Boolean AgregarAlumnos(Alumno alumno) {
		Boolean b = false;
		Boolean aux = false;
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDni() == alumno.getDni()) {
				aux = true;
			}
		}
		if (aux == false) {
			alumnos.add(alumno);
			b = true;
		}
		return b;
	}

	public Boolean CrearCicloLectivo(CicloLectivo cicloLectivo) {
		Boolean b = false;
		Boolean aux = false;
		for (int i = 0; i < ciclosLectivos.size(); i++) {
			if (ciclosLectivos.get(i).getId() == cicloLectivo.getId()
				&& 
				 ciclosLectivos.get(i).getFechaInicioCicloLectivo().getMes() == cicloLectivo.getFechaInicioCicloLectivo().getMes()
				&& 
				 ciclosLectivos.get(i).getFechaInicioCicloLectivo().getAño() == cicloLectivo.getFechaInicioCicloLectivo().getAño()
	 			&& 
				 ciclosLectivos.get(i).getFechaFinalizacionCicloLectivo().getMes() == cicloLectivo.getFechaFinalizacionCicloLectivo().getMes()
				&& 
				 ciclosLectivos.get(i).getFechaFinalizacionCicloLectivo().getAño() == cicloLectivo.getFechaFinalizacionCicloLectivo().getAño()) {
				aux = true;
			}
		}
		if (aux == false) {
			ciclosLectivos.add(cicloLectivo);
			b = true;
		}
		return b;
	}

	public Boolean AgregarProfesor(Profesor profesor) {
		Boolean b = false;
		Boolean aux = false;
		for (int i = 0; i < profesores.size(); i++) {
			if (profesores.get(i).getDni() == profesor.getDni()) {
				aux = true;
			}
		}
		if (aux == false) {
			profesores.add(profesor);
			b = true;
		}
		return b;
	}

	public Boolean CrearAula(Aula aula) {
		Boolean b = false;
		Boolean aux = false;
		for (int i = 0; i < aulas.size(); i++) {
			if (aulas.get(i).getId() == aula.getId()) {
				aux = true;
			}
		}
		if (aux == false) {
			aulas.add(aula);
			b = true;
		}
		return b;
	}

	public Boolean CrearComicion(Comicion comicion) {
		Boolean b = false;
		Boolean aux = false;
		for (int i = 0; i < comiciones.size(); i++) {
			if (comiciones.get(i).getId() == comicion.getId() && comiciones.get(i).getTurno() == comicion.getTurno()) {
				aux = true;
			}
		}
		if (aux == false) {
			AgregarMaterias(comicion.getMateria());
			CrearCicloLectivo(comicion.getCicloLectivo());
			comiciones.add(comicion);
			b = true;
		}
		return b;
	}

	public Boolean CrearCurso(Curso curso) {
		Boolean b = false;
		Boolean aux = false;
		Integer contadorAlumnos = 0;
		for (int i = 0; i < cursos.size(); i++) {
			if (cursos.get(i).getId() == curso.getId()) {
				aux = true;
			}
		}
		if (aux == false) {
			CrearAula(curso.getAula());
			CrearComicion(curso.getComicion());
			AgregarProfesor(curso.getProfesor());
			for (int j = 0; j < alumnos.size(); j++) {
				for (int k = 0; k < curso.getAlumnosCurso().size(); k++) {
					if (alumnos.get(j).getDni() == curso.getAlumnosCurso().get(k).getDni()) {
						contadorAlumnos++;
					}
				}
			}
			if (contadorAlumnos <= curso.getAula().getCantidadDeAlumnos()) {
				cursos.add(curso);
				b = true;
			}
		}
		return b;
	}

	public Boolean AsignarMateriaCorrelativa(Materia materia, Materia correlativa) {
		Boolean b = false;

		for (int i = 0; i < materias.size(); i++) {
			if (materias.get(i).getId() == materia.getId()) {
				materia.setCodigoCorrelativa(correlativa.getId());
				materia.setTieneCorrelativa(true);
				b = true;
			}
		}

		return b;
	}

	public Boolean EliminarMateriaCorrelativa(Materia correlativa) {
		Boolean b = false;

		for (int i = 0; i < materias.size(); i++) {
			if (materias.get(i).getId() == correlativa.getId()) {
				correlativa.setCodigoCorrelativa(null);
				correlativa.setTieneCorrelativa(false);
				b = true;
			}
		}

		return b;
	}

	public Boolean CalificarAlumno(Curso curso, Alumno alumno, Integer notaParcial1, Integer notaParcial2) {
		Boolean b = false;

		for (int i = 0; i < cursos.size(); i++) {
			if (cursos.get(i).getId() == curso.getId()) {
				for (int j = 0; j < curso.getAlumnosCurso().size(); j++) {
					if (curso.getAlumnosCurso().get(j).getDni() == alumno.getDni()) {
						if(curso.getComicion().getMateria().getTieneCorrelativa() == true) {
							for(int k=0; k<alumno.getAprobadas().size(); k++) {
								if(alumno.getAprobadas().get(k).getId() == curso.getComicion().getMateria().getCodigoCorrelativa()) {
									if (notaParcial1 >= 1 && notaParcial1 <= 10 && notaParcial2 >= 1 && notaParcial2 <= 10) {
										curso.getComicion().getMateria().setNotaParcial1(notaParcial1);
										curso.getComicion().getMateria().setNotaParcial2(notaParcial2);
										alumno.AproboMateria(curso.getComicion().getMateria());
										b = true;
									}
								}
							}
						}
					}
				}
			}
		}

		return b;
	}
	
	public void MostrarMateriasAprobadas(Alumno alumno) {
		for (int k=0; k<alumnos.size(); k++) {
			if(alumnos.get(k).getDni() == alumno.getDni()) {
				System.out.println("MATERIA --- 1° PACIAL --- 2° PARICAL");
				for(int i=0; i<alumno.getAprobadas().size(); i++) {
					System.out.println(alumno.getAprobadas().get(i).getNombre()+ "---" +alumno.getAprobadas().get(i).getNotaParcial1()+ "---" +alumno.getAprobadas().get(i).getNotaParcial2());
				}
			}
		}
		
	}

}
