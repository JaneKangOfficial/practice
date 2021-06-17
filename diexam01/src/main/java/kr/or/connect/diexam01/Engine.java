package kr.or.connect.diexam01;

import org.springframework.stereotype.Component;

//ApplicationConfig2.java 에서 @ComponentScan 사용 
@Component
public class Engine {

	public Engine() {
		System.out.println("Engine 생성자");
	}
	
	public void exec() {
		System.out.println("엔진이 동작합니다.");
	}
	
}
