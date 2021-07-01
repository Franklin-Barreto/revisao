package revisao.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class Endereco extends EntidadeBase {

	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String complemento;
	@OneToOne(fetch = FetchType.LAZY)
	private Espectador espectador;

	public Endereco(String logradouro, int numero, String bairro, String cidade, String estado,String complemento) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
	}
	
	protected Endereco() {}
	

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
	
	public String getComplemento() {
		return complemento;
	}

	public void setEspectador(Espectador espectador) {
		this.espectador = espectador;
	}

}
