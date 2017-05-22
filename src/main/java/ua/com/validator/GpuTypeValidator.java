package ua.com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.enity.GPU_Type;
import ua.com.service.GPU_Type_Service;

public class GpuTypeValidator implements Validator{

	private final GPU_Type_Service gpuTypeService;
	
	public GpuTypeValidator(GPU_Type_Service gpuTypeService) {
		super();
		this.gpuTypeService = gpuTypeService;
	}

	public boolean supports(Class<?> clazz) {
		return GPU_Type.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		GPU_Type gpuType = (GPU_Type) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "", "Can not be empty");
		
		if(gpuTypeService.findByType(gpuType.getType())!=null){
			errors.rejectValue("type", "", "Already exists");
		}
	}

}
