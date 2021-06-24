package revisao.modelo;


import java.util.ArrayList;
import java.util.List;

public class Curso {

	private String nome;
	private List<Materia> materias = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public double getTotalHoras() {
		
		
		return materias.stream().mapToDouble(Materia::getHoras).sum();
	}

}
