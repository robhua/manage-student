package vn.coder.student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
	FileOutputStream fos = null;
	FileInputStream fis = null;
	
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;

	/**
	 * save list student to file
	 * 
	 * @param studentList
	 *            : list student to save
	 */
	public void write(List<Student> studentList) {
		try {
			fos = new FileOutputStream(new File(STUDENT_FILE_NAME));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(studentList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStream(fos);
			closeStream(oos);
		}
	}

	/**
	 * read list student from file
	 * 
	 * @return list student
	 */
	public List<Student> read() {
		List<Student> studentList = new ArrayList<>();

		try {
			fis = new FileInputStream(new File(STUDENT_FILE_NAME));
			ois = new ObjectInputStream(fis);
			studentList = (List<Student>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStream(fis);
			closeStream(ois);
		}
		return studentList;
	}

	/**
	 * close input stream
	 * 
	 * @param is
	 *            : input stream
	 */
	private void closeStream(InputStream is) {
		try {
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * close output stream
	 * 
	 * @param os
	 *            : output stream
	 */
	private void closeStream(OutputStream os) {
		try {
			if (os != null) {
				os.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
