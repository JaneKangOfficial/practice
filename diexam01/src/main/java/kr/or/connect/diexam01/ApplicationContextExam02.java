package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam02 {

	public static void main(String[] args) {
		// Spring IoC 컨테이너
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Car car = (Car) ac.getBean("c");
		car.run();
		
		// 사용할 Car 만 알고 있으면 된다.
		// Engine은 몰라도 된다. 
		
		
	}
}
