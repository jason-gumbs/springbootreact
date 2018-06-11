package com.example.demo;


;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

    private static final Logger log = LoggerFactory.getLogger(ServerApplication.class);

   public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

//	@Bean
//    public CommandLineRunner demo(UserRepository repository) {
//        return (args) -> {
//            // save a couple of Users
//            repository.save(new User("will", "123"));
//            repository.save(new User("Chloe", "O'Brian"));
//            repository.save(new User("Kim", "Bauer"));
//            repository.save(new User("David", "Palmer"));
//            repository.save(new User("Michelle", "Dessler"));
//
//            // fetch all Users
//            log.info("Users found with findAll():");
//            log.info("-------------------------------");
//            for (User user : repository.findAll()) {
//                log.info(user.toString());
//            }
//            log.info("");
//
//            // fetch an individual User by ID
//            repository.findById(1L)
//                    .ifPresent(User -> {
//                        log.info("User found with findById(1L):");
//                        log.info("--------------------------------");
//                        log.info(User.toString());
//                        log.info("");
//                    });
//
//            // fetch Users by last name
//            log.info("User found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//         ;
//            // for (User bauer : repository.findByLastName("Bauer")) {
//            // 	log.info(bauer.toString());
//            // }
//            log.info("");
//        };
//    }


}
