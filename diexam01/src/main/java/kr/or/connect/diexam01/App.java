package kr.or.connect.diexam01;

/*
 	Spring Framework란?
 	- 엔터프라이즈 급 어플리케이션을 구축할 수 있는 가벼운 솔루션이자, 원-스탑-숍(one-stop-shop)
 	- 원하는 부분만 가져다 사용할 수 있도록 모듈화가 잘 되어 있다.
 	- IoC 컨테이너이다.
 	- 선언적으로 트랜잭션을 관리할 수 있다.
 	- 완전한 기능을 갖춘 MVC Framework를 제공한다.
 	- AOP 지원
 	- 스프링은 도메 논리 코드와 쉽게 분리될 수 있는 구조를 가지고 있다.
  
  	Spring Framework Runtime
  	- Data Access/Integration
  		JDBC, ORM, OXM, JMS, Transactions
  	- Web
  		WebSocket, Servlet, Web, Portlet
  	- AOP
  	- Aspects
  	- Instrumentation
  	- Messaging
  	- Core Container
  		Beans, Core, Context, SpEL
  	- Test
  	
  	AOP와 인스트루멘테이션(Instrumentation)
  	- spring-AOP : AOP 얼라이언스(Aliance)와 호환되는 방법으로 AOP를 지원한다.
  	- spring-aspects : AspectJ와의 통합을 제공한다.
  	- spring-instrument : 인스트루멘테이션을 지원하는 클래스와 특정 WAS에서 사용하는 클래스로더 구현체를 제공한다. 
  							참고로 BCI (Byte Code Instrumentations)는 런타임이나 로드(Load) 때 클래스의 바이트 코드에 변경을 가하는 방법을 말합니다. 
 
 	메시징(Messaging)
 	- spring-messaging : 스프링 프레임워크 4는 메시지 기반 어플리케이션을 작성할 수 있는 Message, MessageChannel, MessageHandler 등을 제공한다.
 						또한, 해당 모듈에는 메소드에 메시지를 맵핑하기 위한 어노테이션도 포함되어 있으며, Spring MVC 어노테이션과 유사하다.
 
 	데이터 엑세스(Data Access) / 통합(Integration)
 	- 데이터 엑세스/통합 계층은 JDBC, ORM, OXM, JMS 및 트랜잭션 모듈로 구성되어 있다.
 	- spring-jdbc : 자바 JDBC 프로그래밍을 쉽게 할 수 있도록 기능을 제공한다.
 	- spring-tx : 선언적 트랜잭션 관리를 할 수 있는 기능을 제공한다.
 	- spring-orm : JPA, JDO 및 Hibernate 를 포함한 ORM API를 위한 통합 레이어를 제공한다.
 	- spring-oxm : JAXB, Castor, XMLBeans, JiBX 및 XStream 과 같은 Object/XML 맵핑을 지원한다.
 	- spring-jms : 메시지 생성(producing) 및 사용(consuming)을 위한 기능을 제공, Spring Framework 4.1부터 spring-messaging 모듈과의 통합을 제공한다.
 	
 	웹(Web)
 	- 웹 계층은 spring-web, spring-webmvc, spring-websocket, spring-webmvc-portlet 모듈로 구성된다.
 	- spring-web : 멀티 파트 파일 업로드, 서블릿 리스너 등 웹 지향 통합 기능을 제공한다. HTTP 클리이언트와 Spring의 원격 지원을 위한 웹 관련 부분을 제공한다.
 	- spring-webmvc : Web-Servlet 모듈이라고도 불리며, Spring MVC 및 REST 웹 서비스 구현을 포함한다.
 	- spring-websocket : 웹 소켓을 지원한다.
 	- spring-webmvc-portlet : 포틀릿 환경에서 사용할 MVC 구현을 제공한다. 
 	
 	컨테이너(Container)
	- 컨테이너는 인스턴스의 생명주기를 관리하며, 생성된 인스턴스에게 추가적인 기능을 제공합니다.
			예를 들어, Servlet을 실행해주는 WAS는 Servlet 컨테이너를 가지고 있다고 말합니다.
	- WAS는 웹 브라우저로부터 서블릿 URL에 해당하는 요청을 받으면, 서블릿을 메모리에 올린 후 실행합니다.
			개발자가 서블릿 클래스를 작성했지만, 실제로 메모리에 올리고 실행하는 것은 WAS가 가지고 있는 Servlet 컨테이너입니다.
	- Servlet컨테이너는 동일한 서블릿에 해당하는 요청을 받으면, 또 메모리에 올리지 않고 기존에 메모리에 올라간 서블릿을 실행하여 그 결과를 웹 브라우저에게 전달합니다.
	- 컨테이너는 보통 인스턴스의 생명주기를 관리하며, 생성된 인스턴스들에게 추가적인 기능을 제공하는 것을 말합니다.
	
	IoC(Inversion of Control) 
	- 컨테이너가 코드 대신 오브젝트의 제어권을 갖고 있어 IoC(제어의 역전)이라 합니다.
		예를 들어, 서블릿 클래스는 개발자가 만들지만, 그 서블릿의 메소드를 알맞게 호출하는 것은 WAS입니다.
		이렇게 개발자가 만든 어떤 클래스나 메소드를 다른 프로그램이 대신 실행해주는 것을 제어의 역전이라고 합니다.
	
	DI(Dependency Injection)
	- DI는 의존성 주입이란 뜻을 가지고 있으며, 클래스 사이의 의존 관계를 빈(Bean) 설정 정보를 바탕으로 컨테이너가 자동으로 연결해주는 것을 말합니다.
 	
 	Spring에서 제공하는 IoC/DI 컨테이너
	- BeanFactory : IoC/DI에 대한 기본 기능을 가지고 있습니다.
	- ApplicationContext : BeanFactory의 모든 기능을 포함하며, 일반적으로 BeanFactory보다 추천됩니다. 트랜잭션처리, AOP등에 대한 처리를 할 수 있습니다. BeanPostProcessor, BeanFactoryPostProcessor등을 자동으로 등록하고, 국제화 처리, 어플리케이션 이벤트 등을 처리할 수 습니다.
	- BeanPostProcessor : 컨테이너의 기본로직을 오버라이딩하여 인스턴스화 와 의존성 처리 로직 등을 개발자가 원하는 대로 구현 할 수 있도록 합니다.
	- BeanFactoryPostProcessor : 설정된 메타 데이터를 커스터마이징 할 수 있습니다.

 */

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
