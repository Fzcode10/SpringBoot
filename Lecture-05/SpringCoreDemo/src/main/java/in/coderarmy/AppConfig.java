package in.coderarmy;

import in.strick.CartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("in.coderarmy") // If you not give Folder name then this creates beans for all current package
public class AppConfig {

    @Bean
    public User createUser(){
        return new User("Faiz", 24);
    }


    @Bean
    public CartService createCartService(){
        return new CartService();
    }
}
