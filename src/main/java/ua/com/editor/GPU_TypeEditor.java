package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.enity.GPU_Type;
import ua.com.service.GPU_Type_Service;

public class GPU_TypeEditor  extends PropertyEditorSupport{

	private final GPU_Type_Service gpuTypeService;

	public GPU_TypeEditor(GPU_Type_Service gpuTypeService) {
		super();
		this.gpuTypeService = gpuTypeService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		GPU_Type gpuType = gpuTypeService.findOne(Integer.valueOf(text));
		setValue(gpuType);
	
	}
	
	
}
