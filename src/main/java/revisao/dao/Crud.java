package revisao.dao;

import java.util.Set;

import revisao.modelo.BaseEntity;

public interface Crud<J> {

	void save(BaseEntity entity);

	<T> T find(Class<T> clazz, int id);

	<T> int totalRecords(Class<T> clazz);

	<T> Set<T> findAll(Class<T> clazz);

	void remove(BaseEntity entity);
}
