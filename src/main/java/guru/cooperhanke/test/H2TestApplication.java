package guru.cooperhanke.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class H2TestApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(H2TestApplication.class);

	@Autowired
	JournalService service;

	public static void main(String[] args) {
		SpringApplication.run(H2TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("@@ Inserting Data...");
		service.insertData();
		log.info("@@ findAll() call...");
		service.findAll().forEach(entry -> log.info(entry.toString()));
	}
}
