package revisao.dao;

import java.util.List;

import revisao.modelo.EntidadeBase;

public interface Crud<J> {

	void salva(EntidadeBase entity);

	<T> T buscaPorId(Class<T> clazz, int id);

	<T> Integer totalRegistros(Class<T> clazz);

	<T> List<T> buscaTodos(Class<T> clazz);

	void remove(EntidadeBase entity);
}
