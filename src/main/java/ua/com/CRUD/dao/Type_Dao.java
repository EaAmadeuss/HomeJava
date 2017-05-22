package ua.com.CRUD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.enity.GPU_Type;
import ua.com.enity.Type;

public interface Type_Dao extends JpaRepository<Type, Integer>, JpaSpecificationExecutor<Type> {

	Type findByType(String type);
	
	@Query("select i from Good_Type i join i.goodModels m where m.id=?1")
	List<Type> findByModelId(int id);
}
