package revisao.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Curso extends EntidadeBase {

	private String nome;
	@OneToMany
	private List<Materia> materias = new ArrayList<>();
	@ManyToMany
	private List<Aluno> alunos = new ArrayList<>();

	public Curso(String nome) {
		this.nome = nome;
	}

	public Curso() {
	}

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

	public void adicionaMateria(Materia materia) {
		this.materias.add(materia);

	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void adicionaAluno(Aluno aluno) {
		aluno.adicionaCurso(this);
		this.alunos.add(aluno);
	}
	
	public void setAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public List<String> getNomeAlunos() {
		return alunos.stream().map(Aluno::getNome).collect(Collectors.toList());
	}

}
