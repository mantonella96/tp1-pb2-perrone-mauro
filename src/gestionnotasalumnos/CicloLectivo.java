package gestionnotasalumnos;

public class CicloLectivo {
	
	private Integer id;
	private Fecha fechaInicioCicloLectivo;
	private Fecha fechaFinalizacionCicloLectivo;
	private Fecha fechaInicioIncripcion;
	private Fecha fechaFinalizacionInscripcion;
	
	public CicloLectivo(Integer id, Fecha fechaInicioCicloLectivo, Fecha fechaFinalizacionCicloLectivo, Fecha fechaInicioIncripcion, Fecha fechaFinalizacionInscripcion) {
		this.id = id;
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
		this.fechaInicioIncripcion = fechaInicioIncripcion;
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}

	public Integer getId() {
		return id;
	}

	public Fecha getFechaInicioCicloLectivo() {
		return fechaInicioCicloLectivo;
	}

	public Fecha getFechaFinalizacionCicloLectivo() {
		return fechaFinalizacionCicloLectivo;
	}
	

}
