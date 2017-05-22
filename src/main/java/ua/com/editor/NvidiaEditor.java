package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.enity.Nvidia;
import ua.com.service.Nvidia_Service;

public class NvidiaEditor extends PropertyEditorSupport {

	private final Nvidia_Service nvidiaService;

	public NvidiaEditor(Nvidia_Service nvidiaService) {
		super();
		this.nvidiaService = nvidiaService;
	}
	
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Nvidia nvidia = nvidiaService.fidnOne(Integer.valueOf(text));
		setValue(nvidia);
	}
	
	
}
