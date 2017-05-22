package ua.com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.method.annotation.ModelFactory;

import ua.com.dto.filter.ModelFilter;
import ua.com.dto.filter.TypeFilter;
import ua.com.dto.form.Model_Form;
import ua.com.enity.Color;
import ua.com.enity.GPU_Type;
import ua.com.enity.Models;
import ua.com.enity.Type;

import ua.com.enity.Memory;
import ua.com.enity.Nvidia;
import ua.com.enity.Procc_Type;
import ua.com.enity.Ram_Type;
import ua.com.enity.Screan;

public interface Model_Service {

	void save (Model_Form form);
	List<Models> findAll();
	Models findOne(int id);
	void delete(int id);
	
	Models findBymodelName(String modelName);
	
	
	List<Models> findByTypeId(int id);
	
	List<Models> findByGoodId(int id);

	
	Model_Form findForm(int id);

	Models findUnique(String Name, 
			String price, 
			Color  color,
			Type goodType
			,GPU_Type gpuType,
			Memory memoryType,
			Nvidia nvidiaType,
			Screan screanType,
			Procc_Type proccType, 
			Ram_Type ramType);
	
	
	
	
	
	Page<Models> findAll(Pageable pageable, ModelFilter filter);
	

	
	Page<Models> findAll(TypeFilter filter, Pageable pageable);
	

	

	
}
