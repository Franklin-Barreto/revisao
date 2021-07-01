package revisao.unitario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import revisao.modelo.Endereco;
import revisao.modelo.Espectador;
import revisao.modelo.Evento;
import revisao.modelo.EventoPalestra;
import revisao.modelo.Palestra;
import revisao.modelo.Palestrante;

public class EventoTest {

	private Evento eventoOk;
	private Espectador usuario;

	@BeforeEach
	void inicializa() {
		eventoOk = new Evento("Nome", LocalDateTime.of(2021, Month.JULY, 2, 21, 00),
				LocalDateTime.of(2021, Month.JULY, 2, 23, 00), 30, LocalDate.of(2021, Month.JUNE, 30));
		Endereco endereco = new Endereco("Av Osvaldo vale cordeiro", 1360, "Jardim Brasilia", "São Paulo", "SP",
				"Ap 122 bloco b");
		usuario = new Espectador("Franklin", "11975215595", "fpbarreto@digitalhouse.com", endereco);
	}

	@Test
	void testaInscricaoDataNoPrazo() {
		eventoOk.registraParticipante(usuario);
		assertTrue(eventoOk.ehDataValidaParaInscricao());
	}

	@Test
	void testaInscricaoDataExpirada() {
		Evento evento = new Evento("Nome", LocalDateTime.of(2021, Month.JULY, 2, 21, 00),
				LocalDateTime.of(2021, Month.JULY, 2, 23, 00), 30, LocalDate.of(2021, Month.JUNE, 29));
		assertFalse(evento.ehDataValidaParaInscricao());
	}

	@Test
	void obterQuantidadeDeLugaresDisponiveisTest() {
		eventoOk.registraParticipante(usuario);
		eventoOk.registraParticipante(usuario);
		assertEquals(28, eventoOk.obterQuantidadeLugaresDisponiveis());
	}

	@Test
	void checaExcecaoLugaresDisponiveis() {
		Evento evento = new Evento("Nome", LocalDateTime.of(2021, Month.JULY, 2, 12, 00),
				LocalDateTime.of(2021, Month.JULY, 2, 17, 00), 1, LocalDate.of(2021, Month.JUNE, 30));
		Endereco endereco = new Endereco("Av Osvaldo vale cordeiro", 1360, "Jardim Brasilia", "São Paulo", "SP",
				"Ap 122 bloco b");
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			evento.registraParticipante(
					new Espectador("Franklin", "11975215595", "fpbarreto@digitalhouse.com", endereco));
			evento.registraParticipante(
					new Espectador("Franklin", "11975215595", "fpbarreto@digitalhouse.com", endereco));
		});
		assertEquals("Não existem mais lugares disponíveis", ex.getMessage());
	}

	@Test
	void adicionaPalestranteOkTest() {
		Palestrante palestrante = new Palestrante("Franklin", "11975215595", "fpbarreto@digitalhouse.com");
		palestrante.adicionaPalestra(new Palestra("Microsservicos", 60));
		EventoPalestra eventoPalestra = new EventoPalestra(palestrante, palestrante.obterPalestraPorTema("Microsservicos"));
		assertEquals("Microsservicos", eventoPalestra.getPalestra().getTema());
	}
}
