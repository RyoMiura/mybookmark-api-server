package com.mybookmark.mybookmarkapi.web.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateTagForm extends FormBean {
	
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
