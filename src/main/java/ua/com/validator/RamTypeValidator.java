package ua.com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.enity.Ram_Type;
import ua.com.service.Ram_Type_Service;

public class RamTypeValidator implements Validator {

	private final Ram_Type_Service ramTypeService;

	public RamTypeValidator(Ram_Type_Service ramTypeService) {
		super();
		this.ramTypeService = ramTypeService;
	}

	public boolean supports(Class<?> clazz) {
		return Ram_Type.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		Ram_Type ramType = (Ram_Type) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ramType", "", "Can not be empty");
		
		if(ramTypeService.findByRamType(ramType.getRamType())!=null){
			errors.rejectValue("ramType", "", "Already exists");
		}
	}
	
	
	
}
