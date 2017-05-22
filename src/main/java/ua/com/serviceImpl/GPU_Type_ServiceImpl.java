package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.CRUD.dao.GPU_Type_Dao;
import ua.com.dto.filter.TypeFilter;
import ua.com.enity.GPU_Type;
import ua.com.service.GPU_Type_Service;

@Service
public class GPU_Type_ServiceImpl implements GPU_Type_Service {

	@Autowired
	private GPU_Type_Dao gpuTypeDao;
	
	public void save(GPU_Type gpuType) {
		gpuTypeDao.save(gpuType);
		
	}

	
	public List<GPU_Type> findAll() {
		return gpuTypeDao.findAll();
	}

	
	public GPU_Type findOne(int id) {
		return gpuTypeDao.findOne(id);
	}

	
	public void delete(int id) {
		gpuTypeDao.delete(id);
	}


	
	public GPU_Type findByType(String typeName) {
		return gpuTypeDao.findByType(typeName);
	}


	public List<GPU_Type> findByModelId(int id) {
		return gpuTypeDao.findByModelId(id);
	}


	@Override
	public Page<GPU_Type> findAll(TypeFilter filter, Pageable pageable) {
		return gpuTypeDao.findAll(findByTypeLike(filter), pageable);
	}
	
	private Specification<GPU_Type> findByTypeLike(TypeFilter filter){
		return(root, query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("type")), filter.getSearch().toLowerCase()+"%");
		};
	}


	

}
