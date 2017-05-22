package ua.com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.dto.filter.TypeFilter;
import ua.com.enity.GPU_Type;


public interface GPU_Type_Service  {

	void save (GPU_Type gpuType);
	List<GPU_Type> findAll();
	GPU_Type findOne(int id);
	void delete(int id);
	
	GPU_Type findByType(String typeName);
	
//	List<GPU_Type> findByTypeId(int id);
	
	List<GPU_Type> findByModelId(int id);
	
	Page<GPU_Type> findAll(TypeFilter filter, Pageable pageable);
}
