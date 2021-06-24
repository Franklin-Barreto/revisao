package revisao.dao;

import java.util.Set;

public interface Crud<T> {

	void adiciona(T entidade);
	T buscaPorId(int id);
	int totalRegistros();
	Set<T> buscarTodos();
	void remove(int id);
}
