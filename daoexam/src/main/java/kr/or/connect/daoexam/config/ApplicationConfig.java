package kr.or.connect.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"kr.or.connect.daoexam.dao"})	// package 여러개 나열도 가능 
@Import({DBConfig.class})
public class ApplicationConfig {

}
