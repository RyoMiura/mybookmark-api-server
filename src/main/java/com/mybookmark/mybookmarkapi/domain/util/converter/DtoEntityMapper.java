package com.mybookmark.mybookmarkapi.domain.util.converter;

import java.lang.reflect.Type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoEntityMapper {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public DtoEntityMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public <T, D> D fromDtoToEntity(T source, Type destinationType) {
		return modelMapper.map(source, destinationType);
	}
	
	public <T, D> D fromEntityToDto(T source, Type destinationType) {
		return modelMapper.map(source, destinationType);
	}

}
