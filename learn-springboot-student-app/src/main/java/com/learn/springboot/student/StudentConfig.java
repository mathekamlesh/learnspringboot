package com.learn.springboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (
            StudentRepository resository
    ){
        return args -> {
            Student kamlesh = new Student(
                    "Kamlesh",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    "mathekamlesh@gmail.com"
            );
            Student mathe = new Student(
                    "Mathe",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    "mathekamlesh@gmail.com"
            );

            Student kapil = new Student(
                    "Kapil",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    "mathekamlesh@gmail.com"
            );

            resository.saveAll(Arrays.asList(kamlesh,mathe,kapil));

        };
    }
}
