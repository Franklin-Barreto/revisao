package revisao.dao;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import revisao.modelo.EntidadeBase;

public class Banco {

	Crud<EntidadeBase> tabela;
	Map<String, Crud<EntidadeBase>> banco = new HashMap<>();

	public void adiciona(String tabelaNome, EntidadeBase entidade) {
		tabela = obterTabela(tabelaNome);
		tabela.adiciona(entidade);
		banco.put(tabelaNome, tabela);
	}

	public int totalElementos(String tabelaNome) {
		tabela = obterTabela(tabelaNome);
		return tabela.totalRegistros();
	}

	@SuppressWarnings("unchecked")
	public <T> Set<T> buscarTodos(String tabelaNome) {
		tabela = obterTabela(tabelaNome);
		return (Set<T>) tabela.buscarTodos();
	}

	private Crud<EntidadeBase> obterTabela(String tabelaNome) {
		if (!banco.containsKey(tabelaNome)) {
			return new CrudGeneric<>();
		}
		return banco.get(tabelaNome);
	}
}
