package revisao.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Palestrante extends Participante {

	@OneToMany(mappedBy = "palestrante",cascade = CascadeType.ALL)
	List<Palestra> palestras = new ArrayList<>();

	public Palestrante(String nome, String telefone, String email) {
		super(nome, telefone, email);
	}
	
	protected Palestrante() {};

	public void adicionaPalestra(Palestra palestra) {
		palestra.setPalestrante(this);
		this.palestras.add(palestra);
	}

	public Palestra obterPalestraPorTema(String tema) {
		return palestras.stream().filter(p -> p.getTema().equals(tema)).findFirst()
				.orElseThrow(() -> new RuntimeException("Palestra não encontrada"));
	}
}
