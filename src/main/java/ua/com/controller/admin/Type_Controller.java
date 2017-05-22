package ua.com.controller.admin;

import javax.validation.Valid;

import static ua.com.util.ParamBuilder.*;

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
import ua.com.enity.Type;
import ua.com.service.Type_Service;
import ua.com.validator.TypeValidator;


@Controller
@RequestMapping("/admin/Types")
@SessionAttributes("Types")
public class Type_Controller {
	
	@Autowired
	private Type_Service typeservice;
	
	@RequestMapping("/")
	public String goHome(){
		return "user-index";
	}
	
	@InitBinder("Types")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new TypeValidator(typeservice));
	}
	
	
	@ModelAttribute("Types")
	public Type getForm(){
		return new Type();
	}
	
	@ModelAttribute("filter")
	public TypeFilter getFilter(){
		return new TypeFilter();
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		status.setComplete();
		return "redirect:/admin/Types"+getParams(pageable, filter);
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("types", typeservice.findAll());
		model.addAttribute("page", typeservice.findAll(filter, pageable));
		return "admin-Types";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id , Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("Types", typeservice.findOne(id));
		return show(model, pageable, filter);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		typeservice.delete(id);
		return "redirect:/admin/Types"+getParams(pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("Types") @Valid Type goodType,BindingResult br, Model model, SessionStatus status,@PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		if(br.hasErrors()) return show(model, pageable, filter);
		typeservice.save(goodType);
		status.setComplete();
		return "redirect:/admin/Types"+getParams(pageable, filter);
	}
	
	

}
