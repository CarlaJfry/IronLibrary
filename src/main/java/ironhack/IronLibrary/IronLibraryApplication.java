package ironhack.IronLibrary;

import ironhack.IronLibrary.model.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IronLibraryApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(IronLibraryApplication.class, args);

		Menu menu = new Menu();
		menu.userInteraction();
	}

}
