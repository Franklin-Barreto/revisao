package revisao.dao;

import javax.persistence.EntityManager;

import revisao.modelo.EntidadeBase;

public class CrudGenericJpa<T> {

	private EntityManager em = JpaUtil.createEntityManager();

	public void salva(EntidadeBase entidade) {
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
	}

	@SuppressWarnings("hiding")
	public <T> Integer totaRegistros(Class<T> clazz) {
		return em.createQuery("from " + clazz.getName(), clazz).getResultList().size();
	}

	@SuppressWarnings("hiding")
	public <T>T buscarPorId(Class<T> clazz, int id) {
		return em.find(clazz, id);
	}

}
