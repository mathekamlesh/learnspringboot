package annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class MyConfig {
    @Bean
    public Student getStudent(){
        return new Student("Kamlesh");
    }
    @Bean
    public Date getDate(){
        return new Date();
    }
}
