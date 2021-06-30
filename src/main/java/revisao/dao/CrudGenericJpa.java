package revisao.dao;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import revisao.modelo.BaseEntity;

public class CrudGenericJpa<J> implements Crud<J> {

	private EntityManager em = JpaUtil.createEntityManager();

	public void save(BaseEntity entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public <T> T find(Class<T> clazz, int id) {
		return em.find(clazz, id);
	}

	@Override
	public <T> Set<T> findAll(Class<T> clazz) {
		return em.createQuery("from " + clazz.getName(),clazz).getResultStream().collect(Collectors.toSet());
	}

	@Override
	public void remove(BaseEntity entity) {
		em.remove(entity);
	}

	@Override
	public <T> int totalRecords(Class<T> clazz) {
		return em.createQuery("from " + clazz.getName()).getResultList().size();
	}

}
