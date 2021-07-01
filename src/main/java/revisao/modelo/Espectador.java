package revisao.modelo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Espectador extends Participante {
	@OneToMany(mappedBy = "espectador")
	private Set<EventoInscricao> inscricoes = new HashSet<>();
	@OneToOne(mappedBy = "espectador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Endereco endereco;

	public Espectador(String nome, String telefone, String email, Endereco endereco) {
		super(nome, telefone, email);
		this.endereco = endereco;
		endereco.setEspectador(this);

	}

	protected Espectador() {
	}

	public int totalEventosRegistrados() {
		return inscricoes.size();
	}

	public Set<Evento> getEventos() {
		return inscricoes.stream().map(EventoInscricao::getEvento).collect(Collectors.toSet());
	}

	public Endereco getEndereco() {
		return endereco;
	}

}
