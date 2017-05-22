package ua.com.CRUD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.enity.Color;
import ua.com.enity.Models;

public interface Color_Dao extends JpaRepository<Color, Integer> , JpaSpecificationExecutor<Color>{

	Color findByMadeCountry(String madeCountry);

	
	@Query("select i from Color i join i.models m where m.id=?1")
	List<Color> findByModelId(int id);
	


	
}
