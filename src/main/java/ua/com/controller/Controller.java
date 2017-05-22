package ua.com.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;











import ua.com.CRUD.dao.Model_Dao;
import ua.com.enity.GPU_Type;
import ua.com.enity.Models;
import ua.com.enity.Type;
import ua.com.enity.Color;
import ua.com.enity.Memory;
import ua.com.enity.Procc_Type;
import ua.com.enity.Ram_Type;
import ua.com.enity.User;
import ua.com.service.GPU_Type_Service;
import ua.com.service.Model_Service;
import ua.com.service.Type_Service;
import ua.com.service.Color_Service;
import ua.com.service.Memory_Service;
import ua.com.service.Nvidia_Service;
import ua.com.service.Procc_Type_Service;
import ua.com.service.Ram_Type_Service;
import ua.com.service.Screan_Service;
import ua.com.service.User_Service;
import ua.com.serviceImpl.GPU_Type_ServiceImpl;
import ua.com.serviceImpl.Models_ServiceImpl;
import ua.com.serviceImpl.Type_ServiceImpl;
import ua.com.serviceImpl.Color_ServiceImpl;
import ua.com.serviceImpl.Memory_ServiceImpl;
import ua.com.serviceImpl.Nvidia_ServiceImpl;
import ua.com.serviceImpl.Procc_Type_ServiceImpl;
import ua.com.serviceImpl.Ram_Type_ServiceImpl;
import ua.com.serviceImpl.Screan_ServiceImpl;
import ua.com.serviceImpl.User_ServiceImpl;

public class Controller {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
		
		Model_Service ModelService = (Model_Service) context.getBean(Models_ServiceImpl.class);
		
		Type_Service goodTypeService = (Type_Service) context.getBean(Type_ServiceImpl.class);
		
		Color_Service goodService = (Color_Service) context.getBean(Color_ServiceImpl.class);
		
		GPU_Type_Service gpuTypeService = (GPU_Type_Service) context.getBean(GPU_Type_ServiceImpl.class);
		
		Memory_Service memoryService = (Memory_Service) context.getBean(Memory_ServiceImpl.class);
		
		Procc_Type_Service proccTypeService = (Procc_Type_Service) context.getBean(Procc_Type_ServiceImpl.class);
		
		Nvidia_Service nvidiaService = (Nvidia_Service) context.getBean(Nvidia_ServiceImpl.class);
		
		Screan_Service screanService = (Screan_Service) context.getBean(Screan_ServiceImpl.class);
		
		Ram_Type_Service  ramTypeService = (Ram_Type_Service) context.getBean(Ram_Type_ServiceImpl.class);
		
		User_Service userService = (User_Service) context.getBean(User_ServiceImpl.class);
		
		
		System.out.println(userService.findByEmail("pasha.garkavenko@gmail.com"));
		
		
		System.out.println(ramTypeService.findByRamType("16GB DDR4"));

		
		context.close();
		
		
	}

}
