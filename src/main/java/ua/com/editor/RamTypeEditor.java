package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.enity.Ram_Type;
import ua.com.service.Ram_Type_Service;



public class RamTypeEditor extends PropertyEditorSupport {

	
	private final Ram_Type_Service ramTypeService;

	public RamTypeEditor(Ram_Type_Service ramTypeService) {
		super();
		this.ramTypeService = ramTypeService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

	
		Ram_Type ramType = ramTypeService.findOne(Integer.valueOf(text));
		setValue(ramType);
		
	}
	
	
}
