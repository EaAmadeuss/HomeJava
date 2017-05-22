package ua.com.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.dto.filter.TypeFilter;
import ua.com.enity.Screan;

public interface Screan_Service {

	void save (Screan screanType);
	
	List<Screan> findAll();
	Screan findOne(int id);
	void delete(int id);
	
	Screan findByType(String typeName);
	
	List<Screan> findByModelId(int id);
	
	Page<Screan> findAll(TypeFilter filter , Pageable pageable);
	
	
}
