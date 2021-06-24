package revisao.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	public static EntityManager createEntityManager() {
		EntityManagerFactory emf  =Persistence.createEntityManagerFactory("escola");
		return emf.createEntityManager();
	}

}
