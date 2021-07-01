package revisao.modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Palestra extends EntidadeBase {

	private String tema;
	private int duracaoMinutos;
	@ManyToOne
	private Palestrante palestrante;

	public Palestra(String tema, int duracao) {
		this.tema = tema;
		this.duracaoMinutos = duracao;
	}
	
	protected Palestra() {}

	public String getTema() {
		return tema;
	}

	public int getDuracaoMinutos() {
		return duracaoMinutos;
	}

	public Palestrante getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(Palestrante palestrante) {
		this.palestrante = palestrante;
	}

}
