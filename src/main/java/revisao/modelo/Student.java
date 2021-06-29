package revisao.modelo;

import javax.persistence.Entity;

@Entity
public class Student extends BaseEntity {

	private String nome;
	private int ra;

	public Student(String nome, int ra) {
		this.nome = nome;
		this.ra = ra;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public int getRa() {
		return ra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ra;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ra != other.ra)
			return false;
		return true;
	}

}
