package com.javatechnie.spring.mysql.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@ComponentScan({"com.javatechnie.spring.mysql.api.controller"})
@EntityScan("com.javatechnie.spring.mysql.api.model")
@EnableJpaRepositories("com.javatechnie.spring.mysql.api.dao")
@EnableAutoConfiguration*/
public class SpringMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlApplication.class, args);
	}

}
