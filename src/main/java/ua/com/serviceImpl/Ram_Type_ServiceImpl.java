package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.CRUD.dao.Ram_Type_Dao;
import ua.com.dto.filter.TypeFilter;

import ua.com.enity.Ram_Type;
import ua.com.service.Ram_Type_Service;

@Service
public class Ram_Type_ServiceImpl implements Ram_Type_Service {

	@Autowired
	private Ram_Type_Dao ramTypeDao;
	
	
	public void save(Ram_Type ramType) {
		ramTypeDao.save(ramType);		
	}

	public List<Ram_Type> findAll() {
		return ramTypeDao.findAll();
	}

	public Ram_Type findOne(int id) {
		return ramTypeDao.findOne(id);
	}

	public void delete(int id) {

		ramTypeDao.delete(id);
	}

	public Ram_Type findByRamType(String ramType) {
		return ramTypeDao.findByRamType(ramType);
	}

	public List<Ram_Type> findByModelId(int id) {
		return ramTypeDao.findByModelId(id);
	}

	@Override
	public Page<Ram_Type> findAll(TypeFilter filter, Pageable pageable) {
		return ramTypeDao.findAll(findByTypeLike(filter), pageable);
	}
	
	private Specification<Ram_Type> findByTypeLike(TypeFilter filter){
		return(root, query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("ramType")), filter.getSearch().toLowerCase()+"%");
		};
	}

	

	

}
