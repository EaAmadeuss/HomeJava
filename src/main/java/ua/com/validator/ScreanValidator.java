package ua.com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.enity.Screan;
import ua.com.service.Screan_Service;

public class ScreanValidator implements Validator {

	private final Screan_Service screanService;

	public ScreanValidator(Screan_Service screanService) {
		super();
		this.screanService = screanService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Screan.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Screan screanType = (Screan) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "",
				"Can not be empty");

		if (screanService.findByType(screanType.getType()) != null) {
			errors.rejectValue("type", "", "Already exists");
		}

	}
}
