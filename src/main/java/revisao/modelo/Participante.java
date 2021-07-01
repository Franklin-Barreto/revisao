package revisao.modelo;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Participante extends EntidadeBase {

	private String nome;
	private String telefone;
	private String email;

	public Participante(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	
	}
	
	protected Participante() {}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}


}
