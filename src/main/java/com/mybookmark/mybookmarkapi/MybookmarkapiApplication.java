package com.mybookmark.mybookmarkapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mybookmark.mybookmarkapi.common.dto.UserDto;
import com.mybookmark.mybookmarkapi.domain.entity.AuthorityEntity;
import com.mybookmark.mybookmarkapi.domain.repository.AuthorityRepository;
import com.mybookmark.mybookmarkapi.domain.service.UserService;

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
	public CommandLineRunner init(AuthorityRepository authorityRepository, UserService userService) {
					
		return (evt) -> {
			
			authorityRepository.save(new AuthorityEntity("ADMIN"));
			authorityRepository.save(new AuthorityEntity("USER"));
			
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
