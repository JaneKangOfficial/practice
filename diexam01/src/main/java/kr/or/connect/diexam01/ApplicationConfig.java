package kr.or.connect.diexam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 	Java config를 이용한 설정을 위한 어노테이션

	@Configuration
	스프링 설정 클래스를 선언하는 어노테이션

	@Bean
	bean을 정의하는 어노테이션
	
	@ComponentScan
	@Controller, @Service, @Repository, @Component 어노테이션이 붙은 클래스를 찾아 컨테이너에 등록
	
	@Component
	컴포넌트 스캔의 대상이 되는 애노테이션 중 하나로써 주로 유틸, 기타 지원 클래스에 붙이는 어노테이션
	
	@Autowired
	주입 대상이되는 bean을 컨테이너에 찾아 주입하는 어노테이션
 */

/*
 	@Configuration 은 스프링 설정 클래스라는 의미를 가집니다.
	JavaConfig로 설정을 할 클래스 위에는 @Configuration가 붙어 있어야 합니다.
	ApplicationContext중에서 AnnotationConfigApplicationContext는 JavaConfig클래스를 읽어들여 IoC와 DI를 적용하게 됩니다.
	이때 설정파일 중에 @Bean이 붙어 있는 메소드들을 AnnotationConfigApplicationContext는 자동으로 실행하여 그 결과로 리턴하는 객체들을 기본적으로 싱글턴으로 관리를 하게 됩니다.
 */

@Configuration	// @Bean으로 직접 생성 
public class ApplicationConfig {
	@Bean
	public Car car(Engine e) {
		Car c = new Car();
		c.setEngine(e);
		return c;
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
}
