package com.mybookmark.mybookmarkapi.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mybookmark.mybookmarkapi.common.dto.TagDto;
import com.mybookmark.mybookmarkapi.common.error.exception.DuplicateDBValueException;
import com.mybookmark.mybookmarkapi.common.error.exception.NotFoundDBResourceException;
import com.mybookmark.mybookmarkapi.domain.entity.TagEntity;
import com.mybookmark.mybookmarkapi.domain.repository.TagRepository;
import com.mybookmark.mybookmarkapi.domain.util.converter.DtoEntityMapper;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private DtoEntityMapper dtoEntityMapper;
	
	public Collection<TagDto> readTags() {
		List<TagEntity> entities = tagRepository.findAll();
		List<TagDto> dtos = new ArrayList<>();
		entities.forEach(entity -> {
			dtos.add(dtoEntityMapper.fromEntityToDto(entity, TagDto.class));
		});
		return dtos;
	}
		
	public void createTag(TagDto dto) {
		try {
			TagEntity entity = dtoEntityMapper.fromDtoToEntity(dto, TagEntity.class);
			tagRepository.save(entity);			
		} catch (DataIntegrityViolationException e) {
			throw new DuplicateDBValueException();
		}
	}
	
	public void updateTag(long tagId, TagDto dto) {
		TagEntity entity = dtoEntityMapper.fromDtoToEntity(dto, TagEntity.class);
		if (entity != null) {
			entity.setTagId(tagId);
			tagRepository.save(entity);			
		} else {
			throw new NotFoundDBResourceException();
		}
	}
	
}
