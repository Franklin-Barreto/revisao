package revisao.dao;

import java.util.Set;

import javax.persistence.EntityManager;

import revisao.modelo.Aluno;

public class AlunoDaoJpa implements Crud<Aluno> {

	private EntityManager em = JpaUtil.createEntityManager();

	@Override
	public void adiciona(Aluno entidade) {
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
	}

	@Override
	public Aluno buscaPorId(int id) {
		return em.find(Aluno.class, id);
	}

	@Override
	public int totalRegistros() {
		return em.createQuery("SELECT count(a) FROM Aluno a", Integer.class).getSingleResult();
		//return em.createQuery("SELECT a FROM Aluno a",Aluno.class).getResultList().size();
	}

	@Override
	public Set<Aluno> buscarTodos() {
		
		return (Set<Aluno>) em.createNativeQuery("SELECT * FROM Aluno").getResultList();
	}

	@Override
	public void remove(int id) {
		em.remove(buscaPorId(id));
	}

}
