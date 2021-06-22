package revisao2;

public class Materia {

	private String titulo;
	private double horas;

	public Materia(String titulo, double horas) {
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
