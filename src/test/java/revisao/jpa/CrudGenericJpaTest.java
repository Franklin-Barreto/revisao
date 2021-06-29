package revisao.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import revisao.dao.CrudGenericJpa;
import revisao.modelo.BaseEntity;
import revisao.modelo.Student;
import revisao.modelo.Subject;

public class CrudGenericJpaTest {

	private CrudGenericJpa crud;
	
	@BeforeEach
	void initialize() {
		crud = new CrudGenericJpa();
		Set<BaseEntity> entities = new HashSet<>(
				Arrays.asList(
						new Student("Franklin", 1254),
						new Student("Alberto", 1254),
						new Subject("Object Oriented Programming", 40),
						new Subject("Data Structure", 28)));
		entities.stream().forEach(e-> crud.save(e));
	}
	
	@Test
	void saveStudentTest() {
		Student student = new Student("João", 789);
		crud.save(student);
		assertEquals(3,crud.totalRecords(Student.class));
	}
	
	@Test
	void findByIdTest() {
		Student student = crud.find(Student.class,1);
		assertEquals("Alberto",student.getNome());
	}
}
