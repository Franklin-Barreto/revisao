package revisao.dao;

import javax.persistence.EntityManager;

import revisao.modelo.Evento;

public class EventoDao extends CrudGenericJpa<Evento> {

	public EventoDao(EntityManager em) {
		super(em);
	}
	
	public long totalPalestraPorIdEvento(int eventoId) {
		return em.createQuery("SELECT count(ep) FROM Evento e join e.eventoPalestras ep WHERE e.id = :id",Long.class).setParameter("id",eventoId).getSingleResult();
	} 
}
