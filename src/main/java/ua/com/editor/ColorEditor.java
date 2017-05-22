package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.enity.Color;

import ua.com.service.Color_Service;

public class ColorEditor extends PropertyEditorSupport {

	private final Color_Service colorservice;

	public ColorEditor(Color_Service colorservice) {
		super();
		this.colorservice = colorservice;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Color color = colorservice.findOne(Integer.valueOf(text));
		setValue(color);
	
	}
	
	
}
