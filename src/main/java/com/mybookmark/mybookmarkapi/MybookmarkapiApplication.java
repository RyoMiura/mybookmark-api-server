package com.mybookmark.mybookmarkapi;


import java.util.HashSet;
import java.util.Set;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mybookmark.mybookmarkapi.common.dto.BookmarkDto;
import com.mybookmark.mybookmarkapi.common.dto.TagDto;
import com.mybookmark.mybookmarkapi.domain.entity.BookmarkEntity;
import com.mybookmark.mybookmarkapi.domain.entity.TagEntity;
import com.mybookmark.mybookmarkapi.domain.repository.BookmarkRepository;
import com.mybookmark.mybookmarkapi.domain.repository.TagRepository;
import com.mybookmark.mybookmarkapi.web.form.CreateBookmarkForm;
import com.mybookmark.mybookmarkapi.web.util.converter.DtoFormMapper;

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
	public CommandLineRunner init(BookmarkRepository bookmarkRepository, TagRepository tagRepository) {
					
		return (evt) -> {
			
//			tagRepository.save(new TagEntity("google"));
//			tagRepository.save(new TagEntity("ie"));

		};
	}
	
}
