package revisao.dao;

import java.util.List;

import javax.persistence.EntityManager;

import revisao.modelo.BaseEntity;
import revisao.modelo.Student;

public class CrudGenericJpa<T> {

	private EntityManager em = JpaUtil.createEntityManager();

	public void save(BaseEntity entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public int totalRecords(Class<Student> clazz) {
		return em.createQuery("from "+clazz.getName()).getResultList().size();
	}

	public <T>T find(Class<?> clazz, int id) {
		return  (T) em.find(clazz, id);
	}
	
	static <T> List<T> add(List<T> list, T a, T b) {
	    list.add(a);
	    list.add(b);
	    return list;
	}
	

}
