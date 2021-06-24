package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import revisao.dao.AlunoDao;
import revisao.dao.AlunoDaoJpa;
import revisao.dao.Crud;
import revisao.modelo.Aluno;

public class AlunoDaoTest {

	@Test
	public void adicionaAlunoTest() {
		Crud<Aluno> alunoDao = new AlunoDaoJpa();
		alunoDao.adiciona(new Aluno("João", 14558));
		assertEquals(1, alunoDao.totalRegistros());
	}

	@Test
	public void exibirTodosOsAlunos() {
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.adiciona(new Aluno("João", 14558));
		alunoDao.adiciona(new Aluno("Maria", 78897));
		assertEquals(2, alunoDao.totalRegistros());
	}

	@Test
	public void exibirAlunoPorRa() {
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.adiciona(new Aluno("João", 14558));
		alunoDao.adiciona(new Aluno("Maria", 78897));
		assertEquals(new Aluno("João", 14558), alunoDao.buscaPorId(14558));
	}
}
