package com.mybookmark.mybookmarkapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mybookmark.mybookmarkapi.common.secure.UserRole;
import com.mybookmark.mybookmarkapi.domain.user.UserDto;
import com.mybookmark.mybookmarkapi.domain.user.UserService;

@SpringBootApplication
public class MybookmarkapiApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(MybookmarkapiApplication.class, args);
	}
	
	/**
	 * 色々と検証用コード(後で消すよ)
	 * 
	 * @param bookmarkRepository
	 * @return
	 */
	@Bean
	public CommandLineRunner init(UserService userService) {
					
		return (evt) -> {
			
			UserDto user1 = new UserDto();
			user1.setLoginId("myuser");
			user1.setPassword("myuser");			
			userService.createCommonUser(user1);

			UserDto user2 = new UserDto();
			user2.setLoginId("books");
			user2.setPassword("books");			
			userService.createCommonUser(user2);

			
//			tagRepository.save(new TagEntity("google"));
//			tagRepository.save(new TagEntity("ie"));

		};
	}
	
}
