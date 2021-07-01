package revisao.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Evento extends EntidadeBase {

	private String nome;
	private LocalDateTime dataInicio;
	private int capacidade;
	private LocalDate dataLimiteInscricao;
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	private Set<EventoInscricao> inscricoes = new HashSet<>();

	@OneToMany(mappedBy = "evento",cascade = CascadeType.ALL)
	private Set<EventoPalestra> eventoPalestras = new HashSet<>();

	private int lugaresDisponiveis;
	private LocalDateTime dataFim;

	public Evento(String nome, LocalDateTime dataInicio, LocalDateTime dataFim, int capacidade,
			LocalDate dataLimiteInscricao) {
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.capacidade = capacidade;
		this.dataLimiteInscricao = dataLimiteInscricao;
		lugaresDisponiveis = capacidade;
	}

	protected Evento() {
	}

	public String getNome() {
		return nome;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public LocalDate getDataLimiteInscricao() {
		return dataLimiteInscricao;
	}

	public void registraParticipante(Espectador usuario) {
		if (!ehDataValidaParaInscricao()) {
			throw new RuntimeException("Data de inscricao expirada");
		}
		if (!existemLugaresDisponiveis()) {
			throw new RuntimeException("Não existem mais lugares disponíveis");
		}
		inscricoes.add(new EventoInscricao(usuario, this));
		lugaresDisponiveis--;

	}

	public boolean ehDataValidaParaInscricao() {
		return (LocalDate.now().isBefore(dataLimiteInscricao) || LocalDate.now().equals(dataLimiteInscricao));
	}

	public int obterQuantidadeLugaresDisponiveis() {
		return lugaresDisponiveis;
	}

	public boolean existemLugaresDisponiveis() {
		return lugaresDisponiveis > 0;
	}

	public void adicionaPalestra(EventoPalestra eventoPalestra) {
		this.eventoPalestras.add(eventoPalestra);
		eventoPalestra.setEvento(this);
	}

	public Set<EventoPalestra> getEventoPalestras() {
		return eventoPalestras;
	}

	public Palestra obterPalestraPeloTema(String tema) {
		return eventoPalestras.stream().map(EventoPalestra::getPalestra).filter(p -> p.getTema().equals(tema))
				.findFirst().get();
	}

	public List<Palestra> obterTodasPalestras() {
		return eventoPalestras.stream().map(EventoPalestra::getPalestra).collect(Collectors.toList());
	}

}
