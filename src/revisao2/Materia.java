package revisao2;

import database.EntidadeBase;

public class Materia extends EntidadeBase {

	private String titulo;
	private double horas;

	public Materia(Integer id,String titulo, double horas) {
		super(id);
		this.titulo = titulo;
		this.horas = horas;
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
