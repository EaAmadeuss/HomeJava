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
import ua.com.enity.Ram_Type;
import ua.com.service.Type_Service;
import ua.com.service.Ram_Type_Service;
import ua.com.validator.RamTypeValidator;

@Controller
@RequestMapping("/admin/ramTypes")
@SessionAttributes("ramType")
public class Ram_Type_Controller {
	
	@Autowired
	private Ram_Type_Service ramTypeService;
	
	@Autowired
	private Type_Service goodTypeService;

	@RequestMapping("/")
	public String goHome(){
		return "user-index";
	}
	
	@InitBinder("ramType")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new RamTypeValidator(ramTypeService));
	}
	
	@ModelAttribute("ramType")
	public Ram_Type getForm(){
		return new Ram_Type();
	}
	
	@ModelAttribute("filter")
	public TypeFilter getFilter(){
		return new TypeFilter();
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		status.setComplete();
		return "redirect:/admin/ramTypes"+getParams(pageable, filter);
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("types", goodTypeService.findAll());
		model.addAttribute("page", ramTypeService.findAll(filter, pageable));
		return "admin-ramTypes";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id , Model model , @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		model.addAttribute("ramType", ramTypeService.findOne(id));
		return show(model,pageable, filter);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		ramTypeService.delete(id);
		return "redirect:/admin/ramTypes"+getParams(pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("ramType") @Valid Ram_Type ramType,BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeFilter filter){
		if(br.hasErrors()) return show(model,pageable, filter);
		ramTypeService.save(ramType);
		status.setComplete();
		return "redirect:/admin/ramTypes"+getParams(pageable, filter);
	}
	
}
