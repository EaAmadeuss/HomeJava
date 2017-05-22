package ua.com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.dto.filter.TypeFilter;
import ua.com.enity.Type;

public interface Type_Service {

	void save (Type goodType);
	List<Type> findAll();
	Type findOne(int id);
	void delete(int id);
	
	Type findByType(String type);
	
	List<Type> findByModelId(int id);
	
	Page<Type> findAll(TypeFilter filter, Pageable pageable);
}
