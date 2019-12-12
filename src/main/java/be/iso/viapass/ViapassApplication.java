package be.iso.viapass;

import be.iso.viapass.services.mainRunToTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ViapassApplication {

	public static void main(String[] args) {

		SpringApplication.run(ViapassApplication.class, args);
//		mainRunToTest.mainRunToTestDB();
	}

}
