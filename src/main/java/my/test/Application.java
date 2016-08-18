package my.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@SpringBootApplication
@Import({ResourceConfig.class})
@EnableMapRepositories("my.test")

public class Application {

    public static void main(String[] args) throws Exception {
    	ApplicationContext context = SpringApplication.run(new Class[]{Application.class}, args);
     }

}
