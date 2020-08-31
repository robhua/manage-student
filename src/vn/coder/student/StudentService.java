package vn.coder.student;

import java.util.List;

/**
 * Student class
 * 
 * @author hunghm
 */
public interface StudentService {

	/**
	 * Add a student
	 * 
	 * @param student
	 */
	public void addStudent(Student student);

	/**
	 * Edit a student by id
	 * 
	 * @param id
	 */
	public void editStudent(Student student);

	/**
	 * Delete a student by id
	 * 
	 * @param id
	 *            : student id
	 */
	public void deleteStudent(int id);

	/**
	 * sort student by name
	 */
	public void sortStudentByName();

	/**
	 * sort student by id
	 */
	public void sortStudentByGPA();

	// getter && setter
	public List<Student> getStudents();

	public Student getStudentById(int id);
}
