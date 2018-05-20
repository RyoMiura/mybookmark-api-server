package com.mybookmark.mybookmarkapi.web.util.converter;

import java.lang.reflect.Type;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mybookmark.mybookmarkapi.domain.bookmark.TagDto;

@Component
public class DtoFormMapper implements Converter<Long, TagDto> {

	private ModelMapper modelMapper;
	
	@Autowired
	public DtoFormMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
		modelMapper.addConverter(this);
	}
	
	public <T, D> D fromFormToDto(T source, Type destinationType) {
		return modelMapper.map(source, destinationType);
	}

	
	@Override
	public TagDto convert(MappingContext<Long, TagDto> context) {
		TagDto dto = new TagDto(); dto.setTagId(context.getSource());
		return dto;
	}
	
}
