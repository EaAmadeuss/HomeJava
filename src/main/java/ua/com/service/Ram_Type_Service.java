package ua.com.service;

import java.util.List;





import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.dto.filter.TypeFilter;
import ua.com.enity.Ram_Type;



public interface Ram_Type_Service {

	void save (Ram_Type ramType);
	List<Ram_Type> findAll();
	Ram_Type findOne(int id);
	void delete(int id);
	
	Ram_Type findByRamType(String ramType);
	
//	List<Ram_Type> findByTypeId(int id);
	
	List<Ram_Type> findByModelId(int id);
	
	Page<Ram_Type> findAll(TypeFilter filter, Pageable pageable);


	
}
