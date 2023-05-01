package ironhack.IronLibrary;

import ironhack.IronLibrary.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IronLibraryApplication implements CommandLineRunner {
	@Autowired
	Menu menu;

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(IronLibraryApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		menu.userInteraction();
	}
}
