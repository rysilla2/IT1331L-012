package comp.uap.it311l.passwordencryptorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan( "comp.uap.it311l" )
public class PasswordEncryptorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordEncryptorApiApplication.class, args);
	}

}
