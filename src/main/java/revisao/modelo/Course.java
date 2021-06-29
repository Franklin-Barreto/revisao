package revisao.modelo;


import java.util.ArrayList;
import java.util.List;

public class Course {

	private String name;
	private List<Subject> subjects = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public double getTotalHours() {
		
		
		return subjects.stream().mapToDouble(Subject::getHours).sum();
	}

}
