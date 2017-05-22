package ua.com.CRUD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import org.springframework.data.jpa.repository.Query;

import ua.com.enity.Nvidia;

public interface Nvidia_Dao  extends JpaRepository<Nvidia, Integer>, JpaSpecificationExecutor<Nvidia> {

	
	Nvidia findByType(String typeName);
	
	@Query("select i from Nvidia i join i.goodModels m where m.id=?1")
	List<Nvidia> findByModelId(int id);
	
	
}
