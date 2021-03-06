package vn.coder.student;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
	@Bean
	public StudentService studentService() {
		return new StudentService();
	}
	
	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
	
	@Bean
	public MainController mainController() {
		return new MainController();
	}
	
	@Bean
	public MainView mainView() {
		return new MainView();
	}
}
