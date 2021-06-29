package revisao.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import revisao.dao.CrudGenericJpa;
import revisao.modelo.Aluno;
import revisao.modelo.EntidadeBase;
import revisao.modelo.Materia;

public class CrudGenericDaoJpaTest {

	private CrudGenericJpa<EntidadeBase> crud;

	@BeforeEach
	void inicializa() {
		crud = new CrudGenericJpa<>();
		Set<EntidadeBase> entidades = new HashSet<>(Arrays.asList(new Aluno("João", 14587), new Aluno("Maria", 87487),
				new Materia("Orientação a Objetos", 40), new Materia("Banco de dados com MySql", 38)));
		entidades.stream().forEach(e -> crud.salva(e));
	}

	@Test
	void insereEntidadeTest() {
		crud.salva(new Aluno("Pedro", 6587));
		assertEquals(3, crud.totaRegistros(Aluno.class));
	}

	@Test
	void buscarPorIdTest() {
		Aluno joao = crud.buscarPorId(Aluno.class, 1);
		assertEquals("João", joao.getNome());
	}
}
