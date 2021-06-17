package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam03 {

	public static void main(String[] args) {
		// Spring IoC 컨테이너
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		   
//		Car car = (Car)ac.getBean("car");	// method 명으로 호출 
		Car car = (Car)ac.getBean(Car.class);	// Class Type 으로 호출 
		car.run();
		
	}
}
