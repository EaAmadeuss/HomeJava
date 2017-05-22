package ua.com.validator;

import java.util.regex.Pattern;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.dto.form.Model_Form;
import ua.com.service.Model_Service;

public class ModelValidator implements Validator{

	private static final Pattern REG = Pattern.compile("^[0-9]+$");
	
	private final Model_Service goodModelService;

	public ModelValidator(Model_Service goodModelService) {
		super();
		this.goodModelService = goodModelService;
	}

	public boolean supports(Class<?> clazz) {
		return Model_Form.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Model_Form form = (Model_Form) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelName", "", "Can not be empty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "", "Can not be empty");

		
		if(!REG.matcher(form.getPrice()).matches()){
			errors.rejectValue("price", "", "Only digits here");
		}
		if(errors.getFieldError("price")==null){
			if(goodModelService.findUnique(
					form.getName(), 
					form.getPrice(), 
					form.getColor(), 
					form.getGoodType(),
					form.getGpuType(),
					form.getMemoryType(), 
					form.getNvidiaType() 
					,form.getScreanType() ,
					form.getProccType(),
					form.getRamType())!=null){
				errors.rejectValue("goodType", "", "Already exists");
			}
		}
		
	}
	
	
}
