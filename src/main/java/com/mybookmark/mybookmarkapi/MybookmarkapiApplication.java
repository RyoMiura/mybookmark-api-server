package com.mybookmark.mybookmarkapi;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mybookmark.mybookmarkapi.entity.Bookmark;
import com.mybookmark.mybookmarkapi.repository.BookmarkRepository;

@SpringBootApplication
public class MybookmarkapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybookmarkapiApplication.class, args);
	}
	
	/**
	 * DB検証用コード
	 * 
	 * @param bookmarkRepository
	 * @return
	 */
	@Bean
	public CommandLineRunner init(BookmarkRepository bookmarkRepository) {
//		return (evt) -> Arrays.asList(
//				"jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
//				.forEach(
//						a -> {
//							bookmarkRepository.save(new Bookmark(0, "aaa", "aaa", "", null, 0));
//						});
//		return (evt) -> { System.out.println("hello world"); };
		return (evt) -> bookmarkRepository.save(new Bookmark(0, "aaa", "aaa", "", null));
	}
	
}
