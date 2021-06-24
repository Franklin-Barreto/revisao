package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import revisao.dao.Banco;
import revisao.modelo.Aluno;
import revisao.modelo.EntidadeBase;
import revisao.modelo.Materia;

class BancoTest {

	private Banco banco;

	@BeforeEach
	void iniciar() {
		this.banco = new Banco();
		Set<EntidadeBase> entidades = new HashSet<>(Arrays.asList(new Aluno("Pedro", 5789), new Aluno("Antonio", 4789),
				new Aluno("Maria", 1547), new Aluno("Alice", 6587)));

		entidades.addAll(Arrays.asList(new Materia(1, "Banco de dados com Mysql", 40),
				new Materia(1, "Algoritmos e estrutura de dados", 48), new Materia(1, "Java Básico", 38),
				new Materia(1, "Persistência com Jpa e Hibernate", 40)));
		entidades.stream().forEach(e -> {
			String nome = e.getClass().getSimpleName().toLowerCase();
			banco.adiciona(nome, e);
		});

	}

	@Test
	void adicionaTest() {
		banco.adiciona("aluno", new Aluno("Franklin", 245));
		assertEquals(5, banco.totalElementos("aluno"));
	}

	@Test
	void buscarTodosTest() {
		Set<Aluno> tabela = banco.buscarTodos("aluno");
		assertEquals(4, tabela.size());
	}

}
