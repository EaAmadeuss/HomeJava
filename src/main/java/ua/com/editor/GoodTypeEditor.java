package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.enity.Type;
import ua.com.service.Type_Service;

public class GoodTypeEditor extends PropertyEditorSupport {

	private final Type_Service goodTypeService;

	public GoodTypeEditor(Type_Service goodTypeService) {
		this.goodTypeService = goodTypeService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Type goodType = goodTypeService.findOne(Integer.valueOf(text));
		setValue(goodType);
	}
	
	
	
}
