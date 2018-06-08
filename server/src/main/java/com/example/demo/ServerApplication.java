package com.example.demo;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManagerFactory;


@SpringBootApplication
@EnableJpaAuditing
public class ServerApplication {

//    @Bean
//    public SessionFactory sessionFactory(@Qualifier("entityManagerFactory") EntityManagerFactory emf) {
//        return emf.unwrap(SessionFactory.class);
//    }


	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
