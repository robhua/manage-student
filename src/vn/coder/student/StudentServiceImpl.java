package vn.coder.student;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImpl implements StudentService {

	private List<Student> studentList;

	@Autowired
	private StudentDao studentDao;

	@PostConstruct
	public void afterContructor() {
		studentList = studentDao.read();
	}

	/**
	 * Add a student
	 * 
	 * @param student
	 */
	public void addStudent(Student student) {
		int id = studentList.size() > 0 ? studentList.size() + 1 : 1;
		student.setId(id);

		studentList.add(student);
		studentDao.write(studentList);
	}

	/**
	 * Edit a student by id
	 * 
	 * @param id
	 */
	public void editStudent(Student student) {
		Student cachedStudent = getStudentById(student.getId());
		cachedStudent.setName(student.getName());
		cachedStudent.setAge(student.getAge());
		cachedStudent.setAddress(student.getAddress());
		cachedStudent.setGpa(student.getGpa());

		studentDao.write(studentList);
	}

	/**
	 * Delete a student by id
	 * 
	 * @param id
	 *            : student id
	 */
	public void deleteStudent(int id) {
		Student student = getStudentById(id);
		if (student != null) {
			studentList.remove(student);
			studentDao.write(studentList);
		} else {
			System.out.printf("id = %d not existed.\n", id);
		}
	}

	/**
	 * sort student by name
	 */
	public void sortStudentByName() {
		Collections.sort(studentList, new SortStudentByName());
	}

	/**
	 * sort student by id
	 */
	public void sortStudentByGPA() {
		Collections.sort(studentList, new SortStudentByGPA());
	}

	// getter && setter
	public List<Student> getStudents() {
		return studentList;
	}

	public Student getStudentById(int id) {
		for (Student student : studentList) {
			if (student.getId() == id) {
				return student;
			}
		}

		return null;
	}
}
