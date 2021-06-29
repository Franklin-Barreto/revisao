package revisao.modelo;

import javax.persistence.Entity;

@Entity
public class Subject extends BaseEntity {

	private String name;
	private double hours;

	public Subject(String name, double hours) {
		this.name = name;
		this.hours = hours;
	}

	public String getName() {
		return name;
	}

	public double getHours() {
		return hours;
	}

	@Override
	public String toString() {
		return "Materia [titulo=" + name + ", horas=" + hours + "]";
	}

}
