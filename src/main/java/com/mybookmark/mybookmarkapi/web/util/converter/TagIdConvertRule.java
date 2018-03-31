package com.mybookmark.mybookmarkapi.web.util.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import com.mybookmark.mybookmarkapi.common.dto.TagDto;

public class TagIdConvertRule implements Converter<Long, TagDto> {

	@Override
	public TagDto convert(MappingContext<Long, TagDto> context) {
		TagDto dto = new TagDto(); dto.setTagId(context.getSource());
		return dto;
	}

}
