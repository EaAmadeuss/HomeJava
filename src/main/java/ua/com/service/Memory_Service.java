package ua.com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.dto.filter.TypeFilter;
import ua.com.enity.Memory;


public interface Memory_Service  {

	void save (Memory memoryType);
	List<Memory> findAll();
	Memory findOne(int id);
	void delete(int id);
	
	Memory findByType(String typeName);
	
	List<Memory> findByModelId(int id);
	
	Page<Memory> findAll(TypeFilter filter, Pageable pageable);

	
}
