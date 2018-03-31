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
import com.mybookmark.mybookmarkapi.web.util.converter.BeanMapper;

@SpringBootApplication
public class MybookmarkapiApplication {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BeanMapper beanMapper;
	
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
		
		
//		System.out.println(dto.getTitle());
//		System.out.println(dto.getUrl());
//		dto.getTags().forEach((tag) -> {System.out.println(tag.getName());});
			
		return (evt) -> {
			CreateBookmarkForm bookmark = new CreateBookmarkForm();
			bookmark.setTitle("hello");
			bookmark.setUrl("url");
			long[] ids = { 1, 2 };
			bookmark.setTags(ids);
			
//			modelMapper.addConverter(new Converter<Long, TagDto>() {
//
//				@Override
//				public TagDto convert(MappingContext<Long, TagDto> context) {
//					TagDto dto = new TagDto(); dto.setTagId(context.getSource());
//					return dto;
//				}
//			});
//			
//			BeanMapper beanMapper = new BeanMapper();
//			BeanMapper beanMapper2 = new BeanMapper();
//			System.out.println(BookmarkDto.class);
//			BookmarkDto dto = modelMapper.map(bookmark, BookmarkDto.class);
			System.out.println(beanMapper);
			BookmarkDto dto = beanMapper.fromFormToDto(bookmark, BookmarkDto.class);
			dto.getTags().forEach((tag) -> { System.out.println(tag.getTagId()); });

			
			tagRepository.save(new TagEntity("google"));
			tagRepository.save(new TagEntity("ie"));

			Set<TagEntity> tags = new HashSet<>();
			TagEntity tag = new TagEntity(null); tag.setTagId(1);
			tags.add(tag);

			bookmarkRepository.save(new BookmarkEntity(0, "aaa", "aaa", "", tags));
		};
	}
	
}
