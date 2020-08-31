package vn.coder.student.data;

import java.util.List;

import vn.coder.student.Student;

public interface Reader {
	/**
	 * save list student to file
	 * 
	 * @param studentList
	 *            : list student to save
	 */
	public void write(List<Student> studentList);

	/**
	 * read list student from file
	 * 
	 * @return list student
	 */
	public List<Student> read();

	/**
	 * close input stream
	 * 
	 * @param is
	 *            : input stream
	 */
}
