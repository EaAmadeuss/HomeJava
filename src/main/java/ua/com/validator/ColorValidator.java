package ua.com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.enity.Color;

import ua.com.service.Color_Service;

public class ColorValidator implements Validator {

	private final Color_Service colorservice;
	
	public ColorValidator(Color_Service colorservice) {
		super();
		this.colorservice = colorservice;
	}
	

	public boolean supports(Class<?> clazz) {
		return Color.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		Color goods = (Color) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", "", "Can not be empty");
		
		if(colorservice.findByMadeCountry(goods.getMadeCountry())!=null){
			errors.rejectValue("color", "", "Already exists");
		}
	}

	
	
}
