package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.CRUD.dao.Memory_Dao;
import ua.com.dto.filter.TypeFilter;
import ua.com.enity.Memory;
import ua.com.service.Memory_Service;

@Service
public class Memory_ServiceImpl implements Memory_Service{

	@Autowired
	private Memory_Dao memoryDao;
	
	public void save(Memory memoryType) {
		memoryDao.save(memoryType);
	}

	public List<Memory> findAll() {
		
		return memoryDao.findAll();
	}

	public Memory findOne(int id) {
		return memoryDao.findOne(id);
	}

	public void delete(int id) {

		memoryDao.delete(id);
	}

	
	public Memory findByType(String typeName) {
		return memoryDao.findByType(typeName);
	}

	public List<Memory> findByModelId(int id) {
		return memoryDao.findByModelId(id);
	}

	@Override
	public Page<Memory> findAll(TypeFilter filter, Pageable pageable) {
		return memoryDao.findAll(findByTypeLike(filter), pageable);
	}
	
	private Specification<Memory> findByTypeLike(TypeFilter filter){
		return(root, query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("type")), filter.getSearch().toLowerCase()+"%");
		};
	}

	

}
