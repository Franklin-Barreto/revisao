package revisao.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import revisao.modelo.EntidadeBase;

public class CrudGeneric<T extends EntidadeBase> implements Crud<T> {

	Set<T> entidades = new HashSet<>();
	Map<Integer, T> entidadePorId = new HashMap<>();

	@Override
	public void adiciona(T entidade) {
		this.entidades.add(entidade);
		this.entidadePorId.put(entidade.getId(), entidade);
	}

	@Override
	public T buscaPorId(int id) {
		return entidadePorId.get(id);
	}

	@Override
	public Set<T> buscarTodos() {
		return entidades;
	}

	@Override
	public void remove(int id) {
		this.entidades.remove(buscaPorId(id));
		this.entidadePorId.remove(id);

	}

	@Override
	public int totalRegistros() {
		return this.entidades.size();
	}

}
