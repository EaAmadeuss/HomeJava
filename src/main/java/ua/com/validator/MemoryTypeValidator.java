package ua.com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.enity.Memory;
import ua.com.service.Memory_Service;

public class MemoryTypeValidator implements Validator{

	
	private final Memory_Service memoryTypeService;

	public MemoryTypeValidator(Memory_Service memoryTypeService) {
		super();
		this.memoryTypeService = memoryTypeService;
	}

	public boolean supports(Class<?> clazz) {
		return Memory.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		Memory memoryType = (Memory) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "", "Can not be empty");
		
		if(memoryTypeService.findByType(memoryType.getType())!=null){
			errors.rejectValue("type", "", "Already exists");
		}
	}
	
	
}
