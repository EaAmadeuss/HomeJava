package ua.com.CRUD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.enity.GPU_Type;
import ua.com.enity.Models;

public interface GPU_Type_Dao extends JpaRepository<GPU_Type, Integer>, JpaSpecificationExecutor<GPU_Type> {

	GPU_Type findByType(String typeName);
	
//	@Query("select i from GPU_Type i join i.goodModels m where m.id=?1")
//	List<GPU_Type> findByTypeId(int id);
	
	
	@Query("select i from GPU_Type i join i.goodModels m where m.id=?1")
	List<GPU_Type> findByModelId(int id);
}
