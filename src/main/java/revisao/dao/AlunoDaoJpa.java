package revisao.dao;

import revisao.modelo.Aluno;

public class AlunoDaoJpa extends CrudGenericJpa<Aluno> {

	public Aluno buscarPorId( int id) {
		return buscarPorId(Aluno.class, id);
	}
}
