package revisao.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import revisao.dao.CrudGenericJpa;
import revisao.modelo.Aluno;
import revisao.modelo.Curso;
import revisao.modelo.EntidadeBase;
import revisao.modelo.Materia;

public class SistemaTest {

	private CrudGenericJpa<EntidadeBase> crud;
	private Aluno joao;
	private Aluno maria;
	private Curso backend;
	private Curso frontend;
	private Materia orientacaoObjeto;
	private Materia mysql;
	private Aluno pedro;
	private Aluno antonio;
	private Aluno helena;

	@BeforeEach
	void inicializa() {
		crud = new CrudGenericJpa<>();
		this.joao = new Aluno("João", 14587);
		this.maria = new Aluno("Maria", 87487);
		this.pedro = new Aluno("Pedro", 2457);
		this.antonio = new Aluno("Antonio", 6985);
		this.helena = new Aluno("Helena", 3654);

		this.backend = new Curso("backend");

		this.joao.adicionaCurso(backend);

		this.orientacaoObjeto = new Materia("Orientação a Objetos", 40);
		this.mysql = new Materia("Banco de dados com MySql", 38);

		this.backend.adicionaMateria(orientacaoObjeto);
		this.backend.adicionaMateria(mysql);

		this.backend.adicionaAluno(antonio);
		this.backend.adicionaAluno(helena);
		this.backend.adicionaAluno(pedro);
		this.backend.adicionaAluno(maria);

		crud.salva(antonio);
		crud.salva(helena);
		crud.salva(pedro);
		crud.salva(maria);
		crud.salva(joao);
		crud.salva(orientacaoObjeto);
		crud.salva(mysql);
		crud.salva(backend);

	}

	@Test
	void buscaCursoAlunoTest() {
		Aluno joao = crud.buscarPorId(Aluno.class, 1);
		List<Curso> cursos = joao.getCursos();
		assertEquals(1, joao.quantidadeCursos());
	}

	@Test
	void buscaAlunosCurso() {
		Curso curso = this.crud.buscarPorId(Curso.class, 1);
		List<String> nomes = curso.getNomeAlunos();
		assertEquals(5, nomes.size());
		assertTrue(nomes.contains("João"));
	}
}
