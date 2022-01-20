package sn.modelsis.springboot.fullstack.backend;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("SampleLogger");

	      //Logging the information
	    logger.info("Demarrage de BackendApplication, Date et heure : {} ", LocalDateTime.now());
		SpringApplication.run(BackendApplication.class, args);
	}

}
