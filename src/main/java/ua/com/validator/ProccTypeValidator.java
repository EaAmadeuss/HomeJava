package ua.com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.enity.Procc_Type;
import ua.com.service.Procc_Type_Service;

public class ProccTypeValidator implements Validator {

	private final Procc_Type_Service proccTypeService;

	public ProccTypeValidator(Procc_Type_Service proccTypeService) {
		super();
		this.proccTypeService = proccTypeService;
	}

	public boolean supports(Class<?> clazz) {
		return Procc_Type.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		Procc_Type proccType = (Procc_Type) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "", "Can not be empty");
		
		if(proccTypeService.findByType(proccType.getType())!=null){
			errors.rejectValue("type", "", "Already exists");
		}
	}
	
	
}
