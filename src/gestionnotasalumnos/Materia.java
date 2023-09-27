package gestionnotasalumnos;

public class Materia {
	
	private Integer id;
	private String nombre;
	private Boolean tieneCorrelativa;
	private Integer codigoCorrelativa;
	private Integer notaParcial1;
	private Integer notaParcial2;

	public Materia(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.tieneCorrelativa = false;
	}

	public Integer getId() {
		return id;
	}

	public Integer getCodigoCorrelativa() {
		return codigoCorrelativa;
	}

	public void setCodigoCorrelativa(Integer codigoCorrelativa) {
		this.codigoCorrelativa = codigoCorrelativa;
		this.tieneCorrelativa = true;
	}

	public Integer getNotaParcial1() {
		return notaParcial1;
	}

	public Integer getNotaParcial2() {
		return notaParcial2;
	}

	public void setNotaParcial1(Integer notaParcial1) {
		this.notaParcial1 = notaParcial1;
	}

	public void setNotaParcial2(Integer notaParcial2) {
		this.notaParcial2 = notaParcial2;
	}

	public Boolean getTieneCorrelativa() {
		return tieneCorrelativa;
	}

	public void setTieneCorrelativa(Boolean tieneCorrelativa) {
		this.tieneCorrelativa = tieneCorrelativa;
	}

	public String getNombre() {
		return nombre;
	}
	
	


}
