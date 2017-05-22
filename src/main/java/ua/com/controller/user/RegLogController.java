package ua.com.controller.user;



import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;











import ua.com.dto.filter.ModelFilter;
import ua.com.dto.filter.TypeFilter;
import ua.com.enity.User;
import ua.com.service.Type_Service;
import ua.com.service.User_Service;
import ua.com.validator.UsersValidator;

@Controller
public class RegLogController {

	@Autowired
	private User_Service userService;
	
	@Autowired
	private Type_Service goodTypeService;
	
	@ModelAttribute("filter")
	private ModelFilter getFilter(){
		return new ModelFilter();
	}
	
	
	
	@InitBinder("user")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new UsersValidator(userService));
	}
	
	@GetMapping("/RegForm")
	public String registration(Model model, Principal principal){
		model.addAttribute("user", new User());
		model.addAttribute("types",goodTypeService.findAll() );
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		return "user-RegForm";
	}
	
	@PostMapping("/RegForm")
	public String save(@ModelAttribute("user")@Valid User user, BindingResult br){
		if(br.hasErrors()) return "user-RegForm";
//		if(user.getPassword().equals(user.getRepPassword())){
//			
//		}
		userService.save(user);
		userService.sendMail("Registration status", user.getEmail(), "Congratz, "+user.getFirstName()+"! You successfully joined Hustle team!");
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(Model model , Principal principal){
		model.addAttribute("types",goodTypeService.findAll() );
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		return "user-login";
	}
	
	
	
	
}
