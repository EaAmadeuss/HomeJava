package ua.com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.enity.Nvidia;
import ua.com.service.Nvidia_Service;

public class NvidiaValidator implements Validator {

	private final Nvidia_Service nvidiaService;

	public NvidiaValidator(Nvidia_Service nvidiaService) {
		super();
		this.nvidiaService = nvidiaService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Nvidia.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Nvidia nvidiaType = (Nvidia) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "",
				"Can not be empty");

		if (nvidiaService.findByType(nvidiaType.getType()) != null) {
			errors.rejectValue("type", "", "Already exists");
		}
	}

}
