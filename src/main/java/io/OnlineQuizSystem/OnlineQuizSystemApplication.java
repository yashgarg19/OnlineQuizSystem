package io.OnlineQuizSystem;

import io.OnlineQuizSystem.entity.Role;
import io.OnlineQuizSystem.entity.User;
import io.OnlineQuizSystem.entity.UserRole;
import io.OnlineQuizSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class OnlineQuizSystemApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(OnlineQuizSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting code");

//		User user = new User();
//
//		user.setFirstname("Yash");
//		user.setLastname("Khurram");
//		user.setEmail("yash@gmail.com");
//		user.setPhone("1122292");
//		user.setUsername("Yxshgarg");
//		user.setProfile("Default");
//
//		Role role = new Role();
//		role.setRoleId(44L);
//		role.setRoleName("ADMIN");
//
//		Set<UserRole> userRoles = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//		userRoles.add(userRole);
//
//		User user1= this.userService.createUser(user,userRoles);
//		System.out.println(user1.getUsername());
	}
}
