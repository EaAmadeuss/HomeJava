package ua.com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.dto.filter.TypeFilter;
import ua.com.enity.Procc_Type;



public interface Procc_Type_Service {

	void save (Procc_Type proccType);
	List<Procc_Type> findAll();
	Procc_Type findOne(int id);
	void delete(int id);
	
	Procc_Type findByType(String proccType);
	
//	List<Procc_Type> findByTypeId(int id);
	
	List<Procc_Type> findByModelId(int id);

	Page<Procc_Type> findAll(TypeFilter filter , Pageable pageable);

}
