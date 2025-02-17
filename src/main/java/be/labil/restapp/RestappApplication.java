package be.labil.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestappApplication {

	public static void main(String[] args) {
		//System.setProperty("file.encoding", StandardCharsets.UTF_8.name());
		SpringApplication.run(RestappApplication.class, args);
	}

}
