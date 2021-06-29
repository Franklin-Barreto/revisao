package revisao.modelo;

import javax.persistence.Entity;

@Entity
public class Materia extends EntidadeBase {

	private String titulo;
	private double horas;

	public Materia(String titulo, double horas) {
		this.titulo = titulo;
		this.horas = horas;
	}
	
	public Materia() {
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}

	public double getHoras() {
		return horas;
	}

	@Override
	public String toString() {
		return "Materia [titulo=" + titulo + ", horas=" + horas + "]";
	}

}
