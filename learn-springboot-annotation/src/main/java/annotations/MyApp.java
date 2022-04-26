package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import otherPackages.Helper;

import java.util.Date;

@SpringBootApplication
@ComponentScan(basePackages = {"annotations","otherPackages"})
public class MyApp implements CommandLineRunner {
    @Autowired
    private Student student;
    @Autowired
    private Employee emp;
    @Autowired
    private Helper help;

    @Autowired
    private Date date;
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.student.greet();
        System.out.println("Current date : "+this.date.toString());
        this.emp.whatisyourname();
        this.help.pleaseHelp();
    }
}
