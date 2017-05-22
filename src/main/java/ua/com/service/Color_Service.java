package ua.com.service;

import java.util.List;











import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.dto.filter.TypeFilter;
import ua.com.enity.Color;
import ua.com.enity.Type;

public interface Color_Service {

	void save (Color color);
	List<Color> findAll();
	Color findOne(int id);
	void delete(int id);
	
	Color findByMadeCountry(String color);
	
	List<Color> findByModelId(int id);


	Page<Color> findAll(TypeFilter filter, Pageable pageable);

	
}
