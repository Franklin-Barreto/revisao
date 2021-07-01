package revisao.dao;

import java.util.List;

import javax.persistence.EntityManager;

import revisao.modelo.EntidadeBase;

public class CrudGenericJpa<J> implements Crud<J> {

	protected EntityManager em;
	
	public CrudGenericJpa(EntityManager em) {
		this.em = em;
	}	

	public void salva(EntidadeBase entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public <T> T buscaPorId(Class<T> clazz, int id) {
		return em.find(clazz, id);
	}

	@Override
	public <T> List<T> buscaTodos(Class<T> clazz) {
		return em.createQuery("from " + clazz.getName(),clazz).getResultList();
	}

	@Override
	public void remove(EntidadeBase entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	@Override
	public <T> int totalRegistros(Class<T> clazz) {
		return em.createQuery("from " + clazz.getName()).getResultList().size();
	}
	
	public void atualiza(EntidadeBase entidade) {
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
	}

}
