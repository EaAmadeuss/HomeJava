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
import ua.com.enity.Nvidia;
import ua.com.service.Type_Service;
import ua.com.service.Nvidia_Service;
import ua.com.validator.NvidiaValidator;



@Controller
@RequestMapping("/admin/nvidia")
@SessionAttributes("nvidia")
public class Nvidia_Controller {

	
	@Autowired
	private Nvidia_Service nvidiaService;
	
	@Autowired
	private Type_Service goodTypeService;
	
	@RequestMapping("/")
	public String goHome(){
		return "user-index";
	}
	
	@InitBinder("nvidia")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new NvidiaValidator(nvidiaService));
	}
	
	@ModelAttribute("nvidia")
	private Nvidia getForm(){
		return new Nvidia();
	}
	
	@ModelAttribute("filter")
	private TypeFilter getFilter(){
		return new TypeFilter();
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, 
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") TypeFilter filter){
		status.setComplete();
		return "redirect:/admin/nvidia"+getParams(pageable, filter);
	}
	
	@GetMapping
	public String show(Model model,
			@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("types", goodTypeService.findAll());
		model.addAttribute("page", nvidiaService.findAll(filter, pageable));
		return "admin-nvidia";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id , Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("nvidia", nvidiaService.fidnOne(id));
		return show(model, pageable, filter);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") TypeFilter filter){
		nvidiaService.delete(id);
		return "redirect:/admin/nvidia"+getParams(pageable, filter);
	}
	
	
	@PostMapping
	public String save(@ModelAttribute("nvidia")@Valid Nvidia nvidia,
			BindingResult br, Model model, 
			SessionStatus status,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") TypeFilter filter){
		if(br.hasErrors()) return show(model, pageable, filter);
		nvidiaService.save(nvidia);
		status.setComplete();
		return "redirect:/admin/nvidia"+getParams(pageable, filter);
	}

}
