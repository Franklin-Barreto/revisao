package revisao.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import revisao.dao.EventoDao;
import revisao.dao.JpaUtil;
import revisao.modelo.Endereco;
import revisao.modelo.Espectador;
import revisao.modelo.Evento;
import revisao.modelo.EventoPalestra;
import revisao.modelo.Palestra;
import revisao.modelo.Palestrante;

@TestInstance(Lifecycle.PER_CLASS)
public class EventoDaoJpaTest {

	private EntityManager em = JpaUtil.createEntityManager();
	private EventoDao eventoDao = new EventoDao(em);
	private Evento eventoOk;
	private Evento eventoOk2;
	private Evento eventoOk3;
	private Palestrante carlos;
	private Palestrante manuel;
	private Palestra cleanCode;
	private Palestra cleanArch;
	private Palestra solid;
	private Espectador espectador;

	@BeforeAll
	void initialize() {
		em.getTransaction().begin();
		eventoOk3 = new Evento("RubyCon", LocalDateTime.of(2021, Month.AUGUST, 25, 15, 00),
				LocalDateTime.of(2021, Month.AUGUST, 25, 21, 00), 30, LocalDate.of(2021, Month.AUGUST, 24));
		
		espectador = new Espectador("Carlos", "1194778547", "carlos@hotmail.com", new Endereco("Alamenda Santos", 1452, "Jardim Paulistano", "S�o Paulo", "SP", null));
		eventoDao.salva(espectador);
		
		carlos = new Palestrante("Carlos", "115877889", "carlos@hotmail.com");
		cleanCode = new Palestra("Clean Code", 60);
		cleanArch = new Palestra("Clean Architecture", 120);
		carlos.adicionaPalestra(cleanCode);
		carlos.adicionaPalestra(cleanArch);
		eventoDao.salva(carlos);
		
		manuel = new Palestrante("Manuel", "1178856547", "manuel@hotmail.com");
		solid = new Palestra("Solid", 30);
		manuel.adicionaPalestra(solid);
		eventoDao.salva(manuel);
		
		eventoOk = new Evento("JavaCon", LocalDateTime.of(2021, Month.SEPTEMBER, 25, 15, 00),
				LocalDateTime.of(2021, Month.SEPTEMBER, 25, 21, 00), 30, LocalDate.of(2021, Month.SEPTEMBER, 24));
		eventoOk.adicionaPalestra(new EventoPalestra(carlos, cleanArch));
		eventoOk.adicionaPalestra(new EventoPalestra(carlos, cleanCode));
		eventoDao.salva(eventoOk);
		
		eventoOk2 = new Evento("PhpCon", LocalDateTime.of(2021, Month.AUGUST, 25, 15, 00),
				LocalDateTime.of(2021, Month.AUGUST, 25, 21, 00), 30, LocalDate.of(2021, Month.AUGUST, 24));
		eventoOk2.adicionaPalestra(new EventoPalestra(manuel, solid));
		eventoDao.salva(eventoOk2);
		
		em.getTransaction().commit();
	}

	@Test
	void cadastrarEventoComSucesso() {
		em.getTransaction().begin();
		eventoDao.salva(eventoOk3);
		em.getTransaction().commit();
		assertEquals(3, eventoOk3.getId());
	}

	@Test
	void cadastrarPalestranteComSucesso() {
		Palestrante palestrante = new Palestrante("Pedro", "1187459658", "pedro@hotmail.com");
		em.getTransaction().begin();
		eventoDao.salva(palestrante);
		em.getTransaction().commit();
		assertEquals(3, palestrante.getId());
	}

	@Test
	void adicionaPalestraAoEventoComSucesso() {
		em.getTransaction().begin();
		eventoOk.adicionaPalestra(new EventoPalestra(carlos, carlos.obterPalestraPorTema("Clean Code")));
		em.getTransaction().commit();
		assertEquals(3, eventoDao.totalPalestraPorIdEvento(1));
	}

	@Test
	void buscarPalestrasEvento() {
		assertEquals(2, eventoOk.obterTodasPalestras().size());
	}
	
	@Test
	void registrarEspectadorComSucesso() {
		eventoOk.registraParticipante(espectador);
	}
	
}
