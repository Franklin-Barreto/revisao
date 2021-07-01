package revisao.modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class EventoPalestra extends EntidadeBase {

	@ManyToOne
	private Evento evento;
	@ManyToOne
	private Palestrante palestrante;
	@ManyToOne
	private Palestra palestra;

	public EventoPalestra( Palestrante palestrante, Palestra palestra) {
		this.palestrante = palestrante;
		this.palestra = palestra;
	}
	
	protected EventoPalestra() {}

	public Evento getEvento() {
		return evento;
	}

	public Palestrante getPalestrante() {
		return palestrante;
	}

	public Palestra getPalestra() {
		return palestra;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	

}
