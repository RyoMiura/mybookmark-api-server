package com.mybookmark.mybookmarkapi.web.util.converter;

import java.lang.reflect.Type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mybookmark.mybookmarkapi.web.form.FormBean;

@Component
public class DtoFormMapper {

	private ModelMapper modelMapper;
	
	@Autowired
	public DtoFormMapper(ModelMapper modelMapper) {
		// TODO Auto-generated constructor stub
		this.modelMapper = modelMapper;
		modelMapper.addConverter(new TagIdConvertRule());
	}
	
	public <T extends FormBean, D> D fromFormToDto(T source, Type destinationType) {
		return modelMapper.map(source, destinationType);
	}
	
}
