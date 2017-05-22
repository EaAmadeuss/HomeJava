package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.enity.Procc_Type;
import ua.com.service.Procc_Type_Service;

public class ProccTypeEditor extends PropertyEditorSupport {

	
	private final Procc_Type_Service proccTypeService;

	public ProccTypeEditor(Procc_Type_Service proccTypeService) {
		super();
		this.proccTypeService = proccTypeService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		Procc_Type proccType = proccTypeService.findOne(Integer.valueOf(text));
		setValue(proccType);
		
	}
	
	
}
