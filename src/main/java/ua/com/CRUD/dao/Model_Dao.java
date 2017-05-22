package ua.com.CRUD.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.dto.filter.ModelFilter;
import ua.com.enity.Models;
import ua.com.specifications.ModelSpecifications;

public interface Model_Dao extends JpaRepository<Models, Integer >, JpaSpecificationExecutor<Models> {

	Models findBymodelName(String modelName);
	
	
	
	@Query("select i from Models i  where i.goodType.id=?1")
	List<Models> findByTypeId(int id);
	
	@Query("select i from Models i  where i.color.id=?1")
	List<Models> findByGoodId(int id);


	@Query("select a from Models a"
			+ " LEFT JOIN FETCH a.goodType "
			+ "LEFT JOIN FETCH a.gpuType LEFT JOIN FETCH "
			+ "a.memoryType LEFT JOIN FETCH   "
			+ " a.nvidiaType LEFT JOIN FETCH"
			+ " a.screanType LEFT JOIN FETCH "
			+ "a.proccType LEFT JOIN FETCH "
			+ "a.ramType LEFT JOIN FETCH a.color")
	List<Models> findAll();
	

	@Query("select a from Models a"
			+ " LEFT JOIN FETCH a.goodType "
			+ "LEFT JOIN FETCH a.gpuType LEFT JOIN FETCH "
			+ "a.memoryType LEFT JOIN FETCH    "
			+ "a.nvidiaType LEFT JOIN FETCH "
			+ "a.screanType LEFT JOIN FETCH "
			+ "a.proccType LEFT JOIN FETCH "
			+ "a.ramType LEFT JOIN FETCH a.color where a.id=?1")
	Models findOne(int id);
	
	@Query("SELECT a FROM Models a WHERE a.Name=?1 "
			+ "and a.price=?2 "
			+ "and a.color.id=?3 "
			+ "and a.goodType.id=?4"
			+ " and a.gpuType.id=?5"
			+ " and a.memoryType.id=?6  "
			+ "and a.nvidiaType.id=?7"
			+ " and a.screanType.id=?8"
			+ "and a.proccType.id=?9"
			+ " and a.ramType.id=?10")
	Models findUnique(String Name, 
			int price, 
			int colorId,
			int goodTypeId
			,int gpuTypeId,
			int memoryTypeId,
			int nvidiaTypeId,
			int screanTypeId,
			int proccTypeId, 
			int ramTypeId);
	

	
}
