package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.enity.Screan;
import ua.com.service.Screan_Service;

public class ScreanEditor extends PropertyEditorSupport {

	
	
	private final Screan_Service screanService;

	public ScreanEditor(Screan_Service screanService) {
		super();
		this.screanService = screanService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
	
		Screan screan = screanService.findOne(Integer.valueOf(text));
		setValue(screan);
	}
	
}
