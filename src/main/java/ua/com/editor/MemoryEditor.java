package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.enity.Memory;
import ua.com.service.Memory_Service;

public class MemoryEditor extends PropertyEditorSupport{

	private final Memory_Service memoryService;

	public MemoryEditor(Memory_Service memoryService) {
		super();
		this.memoryService = memoryService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		Memory memory = memoryService.findOne(Integer.valueOf(text));
		setValue(memory);
	}
	
	
}
