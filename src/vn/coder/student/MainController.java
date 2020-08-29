package vn.coder.student;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main class
 * 
 * @author HungHM
 */
public class MainController {
	@Autowired
	private MainView mainView;

	@Autowired
	StudentService studentService;

	@PostConstruct
	public void start() {
		boolean exit = false;
		int studentId;

		// show menu
		mainView.showMenu();
		while (true) {
			switch (mainView.getUserChoose()) {
			case "1":
				studentService.addStudent(mainView.createStudent());
				break;
			case "2":
				studentId = mainView.inputId();
				Student student = mainView.changeStudent(studentService
						.getStudentById(studentId));

				studentService.editStudent(student);
				break;
			case "3":
				studentId = mainView.inputId();
				studentService.deleteStudent(studentId);
				break;
			case "4":
				studentService.sortStudentByGPA();
				break;
			case "5":
				studentService.sortStudentByName();
				break;
			case "6":
				mainView.viewStudents(studentService.getStudents());
				break;
			case "0":
				System.out.println("exited!");
				exit = true;
				break;
			default:
				System.out
						.println("invalid! please choose action in below menu:");
				break;
			}
			if (exit) {
				break;
			}
			// show menu
			mainView.showMenu();
		}
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		context.close();
	}

}
