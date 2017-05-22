package ua.com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.enity.Type;
import ua.com.service.Type_Service;

public class TypeValidator implements Validator {

	private final Type_Service goodTypeService;
	
	
	public TypeValidator(Type_Service goodTypeService) {
		super();
		this.goodTypeService = goodTypeService;
	}
	
	public boolean supports(Class<?> clazz) {
		return Type.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Type goodType = (Type) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "", "Can not be empty");
		if(goodTypeService.findByType(goodType.getType())!=null){
			errors.rejectValue("type", "", "Already exists");
		}
		
	}

	
	
}
