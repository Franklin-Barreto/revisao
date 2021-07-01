package revisao.dao;

import java.util.List;

import javax.persistence.EntityManager;

import revisao.modelo.EntidadeBase;

public class CrudGenericJpa<J> implements Crud<J> {

	protected EntityManager em;

	public void salva(EntidadeBase entity) {
	}

	public <T> T buscaPorId(Class<T> clazz, int id) {
		return null;
	}

	@Override
	public <T> List<T> buscaTodos(Class<T> clazz) {
		return null;
	}

	@Override
	public void remove(EntidadeBase entity) {
	}

	@Override
	public <T> Integer totalRegistros(Class<T> clazz) {
		return null;
	}

}
