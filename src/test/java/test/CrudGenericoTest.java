package test;

import org.junit.jupiter.api.BeforeEach;

import revisao.dao.Crud;
import revisao.dao.CrudGeneric;
import revisao.modelo.EntidadeBase;

public class CrudGenericoTest {

	private Crud<EntidadeBase> repositorio = new CrudGeneric<>();
	@BeforeEach
	void inicializa() {
		
	}
}
