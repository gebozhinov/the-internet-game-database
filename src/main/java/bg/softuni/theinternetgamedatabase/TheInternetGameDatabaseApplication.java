package bg.softuni.theinternetgamedatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TheInternetGameDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheInternetGameDatabaseApplication.class, args);
	}

}
