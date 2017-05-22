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
import ua.com.enity.Procc_Type;
import ua.com.service.Type_Service;
import ua.com.service.Procc_Type_Service;
import ua.com.validator.ProccTypeValidator;

@Controller
@RequestMapping("/admin/proccTypes")
@SessionAttributes("proccType")
public class Procc_Type_Controller {
	
	@Autowired
	private Procc_Type_Service proccTypeService;
	
	@Autowired
	private Type_Service goodTypeService;

	@RequestMapping("/")
	public String goHome(){
		return "user-index";
	}
	
	@InitBinder("proccType")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new ProccTypeValidator(proccTypeService));
	}
	
	
	@ModelAttribute("proccType")
	public Procc_Type getForm(){
		return new Procc_Type();
	}
	
	@ModelAttribute("filter")
	public TypeFilter getFilter(){
		return new TypeFilter();
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		status.setComplete();
		return "redirect:/admin/proccTypes"+getParams(pageable, filter);
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("types", goodTypeService.findAll());
		model.addAttribute("page", proccTypeService.findAll(filter, pageable));
		return "admin-proccTypes";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id , Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("proccType", proccTypeService.findOne(id));
		return show(model, pageable, filter);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		proccTypeService.delete(id);
		return "redirect:/admin/proccTypes"+getParams(pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("proccType")@Valid Procc_Type proccType,BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		if(br.hasErrors()) return show(model, pageable, filter);
		proccTypeService.save(proccType);
		status.setComplete();
		return "redirect:/admin/proccTypes"+getParams(pageable, filter);
	}
	
}
