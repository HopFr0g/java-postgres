package me.glitch.leonelpoletti.javapostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavapostgresApplication {
	/*
	@Autowired
	private UserRepository userRepo;
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(JavapostgresApplication.class, args);
	}
	
	/*
	@Override
	public void run(String... args) throws Exception {
		List<User> users = userRepo.findAll();
		
		for (User user : users)
			System.out.println(user.toString());
	}
	*/
}