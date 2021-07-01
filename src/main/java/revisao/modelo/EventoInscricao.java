package revisao.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class EventoInscricao extends EntidadeBase {

	@ManyToOne
	private Espectador espectador;
	@ManyToOne
	private Evento evento;

	private LocalDate dataRegistro = LocalDate.now();

	public EventoInscricao(Espectador espectador, Evento evento) {
		this.espectador = espectador;
		this.evento = evento;
	}
	
	protected EventoInscricao() {};

	public Espectador getEspectador() {
		return espectador;
	}

	public Evento getEvento() {
		return evento;
	}

	public LocalDate getDataRegistro() {
		return dataRegistro;
	}

}
