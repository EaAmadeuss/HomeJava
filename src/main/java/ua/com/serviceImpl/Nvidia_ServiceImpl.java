package ua.com.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.CRUD.dao.Nvidia_Dao;
import ua.com.dto.filter.TypeFilter;
import ua.com.enity.Nvidia;
import ua.com.service.Nvidia_Service;


@Service
public class Nvidia_ServiceImpl  implements Nvidia_Service{

	@Autowired
	private Nvidia_Dao nvidiaDao;

	@Override
	public void save(Nvidia nvidiaType) {
		
		nvidiaDao.save(nvidiaType);
	}

	@Override
	public List<Nvidia> findAll() {
		return nvidiaDao.findAll();
	}

	@Override
	public Nvidia fidnOne(int id) {
		return nvidiaDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		nvidiaDao.delete(id);
	}

	@Override
	public Nvidia findByType(String typeName) {
		return nvidiaDao.findByType(typeName);
	}

	@Override
	public List<Nvidia> findByModelId(int id) {
		return nvidiaDao.findByModelId(id);
	}

	@Override
	public Page<Nvidia> findAll(TypeFilter filter, Pageable pageable) {
		return nvidiaDao.findAll(findByTypeLike(filter), pageable);
	}
	
	private Specification<Nvidia> findByTypeLike(TypeFilter filter){
		return(root, query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("type")), filter.getSearch().toLowerCase()+"%");
		};
	}
	
	
	
	
}
