package revisao.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends EntidadeBase {

	private String nome;
	private int ra;
	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<Endereco> enderecos;
	@ManyToMany(mappedBy = "alunos")
	private List<Curso> cursos = new ArrayList<>();

	public Aluno(String nome, int ra) {
		this.nome = nome;
		this.ra = ra;
	}

	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public int getRa() {
		return ra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ra;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ra != other.ra)
			return false;
		return true;
	}

	public void adicionaCurso(Curso curso) {
		curso.setAluno(this);
		this.cursos.add(curso);
	}

	public List<Curso> getCursos() {
		return Collections.unmodifiableList(cursos);
	}

	public Integer quantidadeCursos() {
		return cursos.size();
	}
	
	

}
