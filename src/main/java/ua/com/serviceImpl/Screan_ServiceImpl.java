package ua.com.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.CRUD.dao.Screan_Dao;
import ua.com.dto.filter.TypeFilter;
import ua.com.enity.Screan;
import ua.com.service.Screan_Service;


@Service
public class Screan_ServiceImpl implements Screan_Service {

	@Autowired
	private Screan_Dao screanDao;

	@Override
	public void save(Screan screanType) {
		screanDao.save( screanType);
	}

	@Override
	public List<Screan> findAll() {
		return screanDao.findAll();
	}

	@Override
	public Screan findOne(int id) {
		return screanDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		screanDao.delete(id);
	}

	@Override
	public Screan findByType(String typeName) {
		return screanDao.findByType(typeName);
	}

	@Override
	public List<Screan> findByModelId(int id) {
		return screanDao.findByModelId(id);
	}

	@Override
	public Page<Screan> findAll(TypeFilter filter, Pageable pageable) {
		return screanDao.findAll(findByTypeLike(filter), pageable);
	}
	
	private Specification<Screan> findByTypeLike(TypeFilter filter){
		return(root, query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("type")), filter.getSearch().toLowerCase()+"%");
		};
	}
	
	
}
