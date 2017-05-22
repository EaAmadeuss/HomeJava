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
import ua.com.enity.Screan;
import ua.com.service.Type_Service;
import ua.com.service.Screan_Service;
import ua.com.validator.ScreanValidator;


@Controller
@RequestMapping("/admin/screan")
@SessionAttributes("screan")
public class Screan_Controller {

	@Autowired
	private Screan_Service screanService;
	
	@Autowired
	private Type_Service goodTypeService;
	
	@RequestMapping("/")
	public String goHome(){
		return "user-index";
	}
	
	@InitBinder("screan")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new ScreanValidator(screanService));
	}
	
	@ModelAttribute("screan")
	private Screan getForm(){
		return new Screan();
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
		return "redirect:/admin/screan"+getParams(pageable, filter);
	}
	
	@GetMapping
	public String show(Model model,
			@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("types", goodTypeService.findAll());
		model.addAttribute("page", screanService.findAll(filter, pageable));
		return "admin-screan";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id , Model model,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("screan", screanService.findOne(id));
		return show(model, pageable, filter);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") TypeFilter filter){
		screanService.delete(id);
		return "redirect:/admin/screan"+getParams(pageable, filter);
	}
	
	
	@PostMapping
	public String save(@ModelAttribute("screan")@Valid Screan screan,
			BindingResult br, Model model, 
			SessionStatus status,
			@PageableDefault Pageable pageable,
			@ModelAttribute("filter") TypeFilter filter){
		if(br.hasErrors()) return show(model, pageable, filter);
		screanService.save(screan);
		status.setComplete();
		return "redirect:/admin/screan"+getParams(pageable, filter);
	}

}
