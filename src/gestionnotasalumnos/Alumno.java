package gestionnotasalumnos;

import java.util.ArrayList;

public class Alumno {
	
	
	private Integer dni;
	private String nombre;
	private String apellido;
	private Fecha fechaDeIngreso;
	private ArrayList<Materia> aprobadas = new ArrayList<Materia>();
	
	public Alumno () {
		
	}
	
	public Alumno(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}
	
	public Boolean AproboMateria(Materia materia) {
		Boolean b = false;
		Boolean aux = false;
		for(int i=0; i<aprobadas.size(); i++) {
			if(aprobadas.get(i).getId() == materia.getId()) {
				aux = true;
			}
		}
		if(aux == false) {
			if(materia.getNotaParcial1() >= 4 && materia.getNotaParcial2() >= 4) {
				aprobadas.add(materia);
				b = true;
			}
		}
		
		return b;
	}

	public ArrayList<Materia> getAprobadas() {
		return aprobadas;
	}

	public void setAprobadas(ArrayList<Materia> aprobadas) {
		this.aprobadas = aprobadas;
	}
	
	


}
