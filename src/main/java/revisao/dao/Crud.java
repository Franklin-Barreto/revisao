package revisao.dao;

import java.util.Set;

public interface Crud<T> {

	void save(T entity);
	T find(int id);
	int totalRecords();
	Set<T> findAll();
	void remove(int id);
}
