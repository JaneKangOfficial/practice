package kr.or.connect.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// ApplicationConfig2.java 에서 @ComponentScan 사용 
@Component
public class Car {

	@Autowired
	private Engine v8;
	
	public Car() {
		System.out.println("Car 생성자");
	}
	
	// ApplicationConfig2.java 에서는 setter method를 @Autowired 로 대체한다. (setter method 삭제) 	
 	// ApplicationFonfig.java 에서 사용 setter method 
	public void setEngine(Engine e) {
		this.v8 = e;
	}
	
	public void run() {
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec();
	}
	
	
	
/*	
// Spring IoC 컨테이너가 수행하기 위해서는 설정파일(resources -> applicationContext.xml)에 해당 Bean들을 등록해야 한다. 
	public static void main(String[] args) {
		Engine e = new Engine();
		Car c = new Car();
		c.setEngine(e);
//	같은 의미이다. (property는 getter, setter)
// 	<bean id="e" class="kr.or.connect.diexam01.Engine"/>
//	<bean id="c" class="kr.or.connect.diexam01.Car">
//		<property name="engine" ref="e"></property>
//	</bean>
 
		c.run();
// 	같은 의미이다. 
// 	ApplicationContextExam02.java -> main

	}
*/	
	
	
}
