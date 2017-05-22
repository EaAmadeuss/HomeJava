package ua.com.controller.admin;

import static ua.com.util.ParamBuilder.getParams;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.dto.filter.TypeFilter;
import ua.com.enity.GPU_Type;
import ua.com.service.GPU_Type_Service;
import ua.com.service.Type_Service;
import ua.com.validator.GpuTypeValidator;


@Controller
@RequestMapping("/admin/gpuTypes")
@SessionAttributes("gpuType")
public class GPU_Type_Controller {

	@Autowired
	private GPU_Type_Service gpuTypeService;
	
	@Autowired
	private Type_Service goodTypeService;
	
	@RequestMapping("/")
	public String goHome(){
		return "user-index";
	}
	
	
	@InitBinder("gpuType")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new GpuTypeValidator(gpuTypeService));
	}
	
	@ModelAttribute("gpuType")
	public GPU_Type getForm(){
		return new GPU_Type();
	}
	
	@ModelAttribute("filter")
	public TypeFilter getFilter(){
		return new TypeFilter();
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		status.setComplete();
		return "redirect:/admin/gpuTypes"+getParams(pageable, filter);
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("types", goodTypeService.findAll());
		model.addAttribute("page", gpuTypeService.findAll(filter, pageable));
		return "admin-gpuTypes";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("gpuType", gpuTypeService.findOne(id));
		return show(model, pageable, filter);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		gpuTypeService.delete(id);
		return "redirect:/admin/gpuTypes"+getParams(pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("gpuType")@Valid GPU_Type gpuType,BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		if(br.hasErrors()) return show(model, pageable, filter);
		gpuTypeService.save(gpuType);
		status.setComplete();
		return "redirect:/admin/gpuTypes"+getParams(pageable, filter);
	}
	
}
