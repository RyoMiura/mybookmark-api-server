package com.mybookmark.mybookmarkapi.web.bookmark;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateTagForm {
	
	@NotBlank
	@Size(max=20)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
