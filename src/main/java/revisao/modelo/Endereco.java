package revisao.modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Endereco extends EntidadeBase {

	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	@ManyToOne
	@JoinColumn(name = "aluno_fk")
	private Aluno aluno;

	public Endereco(String logradouro, int numero, String bairro, String cidade, String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public String getLogradouro() {
		return logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

}
