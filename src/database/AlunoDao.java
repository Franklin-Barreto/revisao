package database;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import revisao2.Aluno;

public class AlunoDao {

	Set<Aluno> alunos = new HashSet<>();
	Map<Integer, Aluno> alunosPorRa = new HashMap<>();

	public void adiciona(Aluno aluno) {
		alunosPorRa.put(aluno.getRa(), aluno);
		this.alunos.add(aluno);
	}

	public Integer totalAlunos() {
		return this.alunos.size();
	}

	public Set<Aluno> buscarTodos() {
		return alunos;
	}

	public Aluno obterAlunoPorRa(int ra) {
		if (alunosPorRa.containsKey(ra)) {
			return alunosPorRa.get(ra);
		}
		throw new NoSuchElementException("Aluno não existe");
	}

	public void remove(int ra) {
		alunos.remove(obterAlunoPorRa(ra));
		alunosPorRa.remove(ra);
	}
}
