package vn.coder.student;

import java.util.List;
import java.util.Scanner;

public class MainView {
	public Scanner scanner;

	public MainView() {
		scanner = new Scanner(System.in);
	}

	/**
	 * create menu
	 */
	public void showMenu() {
		System.out.println("-----------menu------------");
		System.out.println("1. Add student.");
		System.out.println("2. Edit student by id.");
		System.out.println("3. Delete student by id.");
		System.out.println("4. Sort student by gpa.");
		System.out.println("5. Sort student by name.");
		System.out.println("6. Show student.");
		System.out.println("0. exit.");
		System.out.println("---------------------------");
		System.out.print("Please choose: ");
	}

	public String getUserChoose() {
		return scanner.nextLine();
	}

	public Student createStudent() {
		String name = inputName();
		String address = inputAddress();
		byte age = inputAge();
		float gpa = inputGpa();
		return new Student(name, age, address, gpa);
	}

	/**
	 * input student name
	 * 
	 * @return student name
	 */
	private String inputName() {
		System.out.print("Input student name: ");
		return scanner.nextLine();
	}

	/**
	 * input student address
	 * 
	 * @return student address
	 */
	private String inputAddress() {
		System.out.print("Input student address: ");
		return scanner.nextLine();
	}

	/**
	 * input student gpa
	 * 
	 * @return gpa
	 */
	private float inputGpa() {
		System.out.print("Input student gpa: ");
		while (true) {
			try {
				float gpa = Float.parseFloat((scanner.nextLine()));
				if (gpa < 0.0 && gpa > 10.0) {
					throw new NumberFormatException();
				}
				return gpa;
			} catch (NumberFormatException ex) {
				System.out.print("invalid! Input student age again: ");
			}
		}
	}

	/**
	 * input student age
	 * 
	 * @return student age
	 */
	private byte inputAge() {
		System.out.print("Input student age: ");
		while (true) {
			try {
				byte age = Byte.parseByte((scanner.nextLine()));
				if (age < 0 && age > 100) {
					throw new NumberFormatException();
				}
				return age;
			} catch (NumberFormatException ex) {
				System.out.print("invalid! Input student id again: ");
			}
		}
	}

	/**
	 * input student id
	 * 
	 * @return student id
	 */
	public int inputId() {
		System.out.print("Input student id: ");
		while (true) {
			try {
				int id = Integer.parseInt((scanner.nextLine()));
				return id;
			} catch (NumberFormatException ex) {
				System.out.print("invalid! Input student id again: ");
			}
		}
	}

	public Student changeStudent(Student student) {
		Student std = createStudent();
		std.setId(student.getId());
		return std;
	}
	/**
	 * show list student to screen
	 */
	public void viewStudents(List<Student> studentList) {
		for (Student student : studentList) {
			System.out.format("%5d | ", student.getId());
			System.out.format("%20s | ", student.getName());
			System.out.format("%5d | ", student.getAge());
			System.out.format("%20s | ", student.getAddress());
			System.out.format("%10.1f%n", student.getGpa());
		}
	}
}
