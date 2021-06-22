package test;

import java.util.ArrayList;
import java.util.List;

import revisao2.Curso;
import revisao2.Materia;

public class CursoDetalhesTest {

	public static void main(String[] args) {

		Curso curso = new Curso();
		curso.setNome("Análise e Desenvolvimento de Sistemas");
		List<Materia> materias = new ArrayList<>();
		materias.add(new Materia("Estrutura de dados", 45));
		materias.add(new Materia("Algoritmos", 40));
		materias.add(new Materia("Banco de dados", 30));
		materias.add(new Materia("Programação Orientada Objeto", 40));
		curso.setMaterias(materias);
		System.out.println(curso.getTotalHoras());
	}
}
