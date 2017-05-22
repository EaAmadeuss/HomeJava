package ua.com.CRUD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.enity.GPU_Type;
import ua.com.enity.Models;
import ua.com.enity.Memory;

public interface Memory_Dao extends JpaRepository<Memory, Integer>, JpaSpecificationExecutor<Memory> {

	Memory findByType(String typeName);
	
	@Query("select i from Memory i join i.goodModels m where m.id=?1")
	List<Memory> findByModelId(int id);
	
}
