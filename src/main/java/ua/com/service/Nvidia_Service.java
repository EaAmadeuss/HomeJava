package ua.com.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.dto.filter.TypeFilter;
import ua.com.enity.Nvidia;

public interface Nvidia_Service {

	void save(Nvidia nvidiaType);
	
	List<Nvidia> findAll();
	
	Nvidia fidnOne(int id);
	
	void delete(int id);
	
	Nvidia findByType(String typeName);
	
	List<Nvidia> findByModelId(int id);
	
	Page<Nvidia> findAll (TypeFilter filter, Pageable pageable);
	
}
