package vn.coder.student;

import java.util.List;

/**
 * StudentDao class
 * 
 * @author viettuts.vn
 */
public interface StudentDao {
    public static final String STUDENT_FILE_NAME = "student.txt";

    /**
     * save list student to file
     * 
     * @param studentList: list student to save
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
     * @param is: input stream
     */
}
