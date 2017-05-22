package ua.com.CRUD.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.enity.GPU_Type;
import ua.com.enity.Models;
import ua.com.enity.Procc_Type;

public interface Procc_Type_Dao extends JpaRepository<Procc_Type, Integer>, JpaSpecificationExecutor<Procc_Type> {

	Procc_Type findByType(String proccType);
	
//	@Query("select i from Procc_Type i join i.goodModels m where m.id=?1")
//	List<Procc_Type> findByTypeId(int id);
	
	
	@Query("select i from Procc_Type i join i.goodModels m where m.id=?1")
	List<Procc_Type> findByModelId(int id);
	
}
