package com.mybookmark.mybookmarkapi;


import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mybookmark.mybookmarkapi.entity.BookmarkEntity;
import com.mybookmark.mybookmarkapi.entity.TagEntity;
import com.mybookmark.mybookmarkapi.repository.BookmarkRepository;
import com.mybookmark.mybookmarkapi.repository.TagRepository;

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
	public CommandLineRunner init(BookmarkRepository bookmarkRepository, TagRepository tagRepository) {
		
		return (evt) -> {
			tagRepository.save(new TagEntity("google"));
			tagRepository.save(new TagEntity("ie"));

			Set<TagEntity> tags = new HashSet<>();
			TagEntity tag = new TagEntity(null); tag.setTagId(1);
			tags.add(tag);

			bookmarkRepository.save(new BookmarkEntity(0, "aaa", "aaa", "", tags));
		};
	}
	
}
