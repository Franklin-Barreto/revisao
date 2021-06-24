package revisao.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import revisao.dao.AlunoDaoJpa;
import revisao.modelo.Aluno;

public class AlunoDaoJpaTest {

	AlunoDaoJpa jpa;
	Aluno aluno;
	Aluno aluno2;

	@BeforeEach
	void inicializa() {
		jpa = new AlunoDaoJpa();
		aluno = new Aluno("José Carlos", 14587);
		aluno2 = new Aluno("Antonio Carlos", 74587);
		jpa.adiciona(aluno);
	}

	@Test
	void adicionaAlunoTest() {
		jpa.adiciona(aluno2);
		assertEquals(2, aluno2.getId());
	}

	@Test
	void buscaAlunoPorIdTest() {
		Aluno doBanco = jpa.buscaPorId(1);
		assertEquals("José Carlos", doBanco.getNome());
	}
}
