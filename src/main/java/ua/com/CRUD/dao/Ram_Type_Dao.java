package ua.com.CRUD.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.enity.GPU_Type;
import ua.com.enity.Models;
import ua.com.enity.Ram_Type;

public interface Ram_Type_Dao extends JpaRepository<Ram_Type, Integer> , JpaSpecificationExecutor<Ram_Type>{
	
	Ram_Type findByRamType(String ramType);
	
//	@Query("select i from Ram_Type i join i.goodModels m where m.id=?1")
//	List<Ram_Type> findByTypeId(int id);

	
	@Query("select i from Ram_Type i join i.goodModels m where m.id=?1")
	List<Ram_Type> findByModelId(int id);
	
//	@Query(value="SELECT a FROM Ram_Type a", countQuery="SELECT count(a.id) FROM Ram_Type a")
//	Page<Ram_Type> findAll(Pageable pageable);
	
}
