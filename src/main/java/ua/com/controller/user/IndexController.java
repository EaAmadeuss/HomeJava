package ua.com.controller.user;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.dto.filter.ModelFilter;
import ua.com.dto.form.Model_Form;
import ua.com.enity.Items;
import ua.com.enity.User;
import ua.com.service.GPU_Type_Service;
import ua.com.service.Model_Service;
import ua.com.service.Type_Service;
import ua.com.service.Color_Service;
import ua.com.service.ItemsService;
import ua.com.service.Memory_Service;
import ua.com.service.Procc_Type_Service;
import ua.com.service.Ram_Type_Service;
import ua.com.service.User_Service;

@Controller
public class IndexController {
	
	@Autowired
	private Model_Service goodModelService;
	
	@Autowired
	private Type_Service goodTypeService;
	
	@Autowired
	private Color_Service goodService;
	
	@Autowired
	private GPU_Type_Service gpuTypeService;
	
	@Autowired
	private Memory_Service memoryService;
	
	@Autowired
	private Procc_Type_Service proccTypeService;
	
	@Autowired
	private Ram_Type_Service ramTypeService;
	
	@Autowired
	private User_Service userService;
	
	@Autowired
	private ItemsService itemService;
	
	@ModelAttribute("filter")
	private ModelFilter getFilter(){
		return new ModelFilter();
	}
	
	@GetMapping("/peoples")
	public String people(){
		return "user-people";
	}
	

	@RequestMapping("/user/hustleMain")
	public String index(@PathVariable int id, Principal principal, Model model ){
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		model.addAttribute("username",userService.findOne(id));
		return "user-hustleMain";
	}

	
	@RequestMapping("/hustleMain")
	public String hustleMain(Model model, Principal principal ){
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}	
		model.addAttribute("types",goodTypeService.findAll() );
		return "user-hustleMain";
	}
	
	// work w/ ("/RegForm") or w/o ??//?? 
	@RequestMapping("/RegForm")
	public String regForm(Principal principal, Model model){
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		return "user-RegForm";
	}
	
//	@RequestMapping
//	public String goodModels(Model model){
//		model.addAttribute("models", goodModelService.findAll());
//		return "user-index";
//	}
	
//	@RequestMapping("/model/{id}")
//	public String goodSearch(@PathVariable int id, Model model){
//		model.addAttribute("model", goodModelService.findOne(id));
//		model.addAttribute("goods", goodService.findByGoodModelId(id));
//		return "user-models";
//	}
	
	@RequestMapping("/admin/goodModels")
	public String adminPage(Model model, Principal principal){
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		return "admin-goodModels";
	}
	
	@RequestMapping("/")
	public String goodType(@ModelAttribute("purchaseInfo") Items item, Model model, Principal principal){
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		model.addAttribute("types",goodTypeService.findAll() );
		return "user-hustleMain";
	}	
	
	
	@RequestMapping("/type/{id}")
	public String typeModelSearch(@PathVariable int id, Model model , Principal principal){
		model.addAttribute("types", goodTypeService.findAll());
		model.addAttribute("type", goodTypeService.findOne(id));
		model.addAttribute("models",  goodModelService.findByTypeId(id));
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		return "user-fromTypeToModels";
	}
	
	@RequestMapping("//model/")
	public String goodModel(Model model, Principal principal){
		model.addAttribute("models", goodModelService.findAll());
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		return "user-ModelsDescript";
	}
	
	@RequestMapping("/model/{id}")
	public String modelGoodSearch(@PathVariable int id, Model model, Principal principal){
		model.addAttribute("types", goodTypeService.findAll());
		model.addAttribute("model", goodModelService.findOne(id));
		model.addAttribute("modelTypes", goodTypeService.findByModelId(id));
		model.addAttribute("goods", goodService.findByModelId(id));
		model.addAttribute("gpu_types", gpuTypeService.findByModelId(id));
		model.addAttribute("memory_types", memoryService.findByModelId(id));
		model.addAttribute("procc_types", proccTypeService.findByModelId(id));
		model.addAttribute("ram_types", ramTypeService.findByModelId(id));
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		return "user-ModelsDescript";
	}
	
	@ModelAttribute("purchaseInfo")
	public Items getForm(){
		return new Items();
	}
	
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id, Model model, 
			Pageable pageable,@ModelAttribute("purchaseInfo") Items item, Principal principal,
			SessionStatus status){
		if(principal!=null){
			System.out.println(principal.getName());
			item.setUserName(principal.getName());
			item.setGoodName(goodModelService.findOne(id).getName());
			item.setTotalPrice(goodModelService.findOne(id).getPrice()*item.getQuantity());
			item.setFullName(userService.findByEmail(principal.getName()).getFullName());
			item.setDeliveryAddressCountry(userService.findByEmail(principal.getName()).getDeliveryAddressCountry());
			item.setDeliveryAddressCity(userService.findByEmail(principal.getName()).getDeliveryAddressCity());
			item.setDeliveryHomeAddress(userService.findByEmail(principal.getName()).getDeliveryHomeAddress());
			itemService.save(item);
			status.setComplete();
		}
		return "redirect:/model/{id}";
	}
	
	@RequestMapping("/supportArea")
	public String supportArea(Model model, Principal principal){
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		model.addAttribute("types",goodTypeService.findAll() );
		return "user-supportArea";
	}
	
	@RequestMapping("/warrantyAndUpgrade")
	public String warrantyAndUpgrade(Model model, Principal principal){
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		model.addAttribute("types",goodTypeService.findAll() );
		return "user-warrantyAndUpgrade";
	}
	
	@RequestMapping("/giftCards")
	public String giftCards(Model model, Principal principal){
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		model.addAttribute("types",goodTypeService.findAll() );
		return "user-giftCards";
	}
	
	
	@RequestMapping("/advReward")
	public String advReward(Model model, Principal principal){
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		model.addAttribute("types",goodTypeService.findAll() );
		return "user-advReward";
	}
	
	
	@RequestMapping("/hustleDeals")
	public String hustleDeals(Model model, Principal principal){
		model.addAttribute("types", goodTypeService.findAll());
		if(principal!=null){
			System.out.println(principal.getName());
			model.addAttribute("username", principal.getName());
		}
		return "user-hustleDeals";
	}
}
