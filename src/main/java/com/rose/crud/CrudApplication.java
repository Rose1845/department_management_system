package com.rose.crud;


import com.rose.crud.user.gender.Gender;
import com.rose.crud.user.request.RegistrationRequest;
import com.rose.crud.user.role.Role;
import com.rose.crud.user.service.UserService;
import com.rose.crud.user.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(UserServiceImpl userService){
//		return args -> {
//			var admin = RegistrationRequest.builder()
//					.email("alvinealvine703@gmail.com")
//					.firstName("feiza")
//					.lastName("mary")
//					.gender(Gender.MALE)
//					.password("angelajuma@")
//					.role(Role.USER)
//					.build();
//			System.out.println("Manager toke"+ userService.register(admin).getToken());
//		};
//	}

}


