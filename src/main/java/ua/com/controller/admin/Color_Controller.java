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
import ua.com.enity.Color;

import ua.com.service.Model_Service;
import ua.com.service.Type_Service;
import ua.com.service.Color_Service;
import ua.com.validator.ColorValidator;


@Controller
@RequestMapping("/admin/Color")
@SessionAttributes("Color")
public class Color_Controller {
	
	@Autowired
	private Color_Service colorservice;
	
	@Autowired
	private Type_Service goodTypeService;
	
	@Autowired
	private Model_Service goodModelService;
	
	@RequestMapping("/")
	public String goHome(){
		return "user-index";
	}
	
	@InitBinder("Color")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new ColorValidator(colorservice));
	}
	
	@ModelAttribute("Color")
	public Color getForm(){
		return new Color();
	}
	
	@ModelAttribute("filter")
	public TypeFilter getFilter(){
		return new TypeFilter();
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		status.setComplete();
		return "redirect:/admin/Color"+getParams(pageable, filter);
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("types", goodTypeService.findAll());
		model.addAttribute("page", colorservice.findAll(filter, pageable));
		return "admin-Color";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id , Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("Color", colorservice.findOne(id));
		return show(model, pageable, filter);
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){		
		colorservice.delete(id);
		return "redirect:/admin/Color"+getParams(pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("Color")@Valid Color goods,BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		if(br.hasErrors()) return show(model, pageable, filter);
		colorservice.save(goods);
		status.setComplete();
		return "redirect:/admin/Color"+getParams(pageable, filter);
		
	}

	
	
}
