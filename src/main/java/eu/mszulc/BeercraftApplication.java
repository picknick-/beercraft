package eu.mszulc;

import eu.mszulc.model.User;
import eu.mszulc.model.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeercraftApplication {

    private static final Logger log = LoggerFactory.getLogger(BeercraftApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(BeercraftApplication.class, args);
    }

}

