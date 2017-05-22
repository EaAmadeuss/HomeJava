package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.CRUD.dao.Procc_Type_Dao;
import ua.com.dto.filter.TypeFilter;
import ua.com.enity.Procc_Type;
import ua.com.service.Procc_Type_Service;

@Service
public class Procc_Type_ServiceImpl implements Procc_Type_Service {

	@Autowired
	private Procc_Type_Dao proccTypeDao;
	
	public void save(Procc_Type proccType) {
		proccTypeDao.save(proccType);
	}

	public List<Procc_Type> findAll() {
		return proccTypeDao.findAll();
	}

	public Procc_Type findOne(int id) {
		return proccTypeDao.findOne(id);
	}

	public void delete(int id) {
		proccTypeDao.delete(id);
	}

	public Procc_Type findByType(String proccType) {
		return proccTypeDao.findByType(proccType);
	}

	public List<Procc_Type> findByModelId(int id) {
		return proccTypeDao.findByModelId(id);
	}

	@Override
	public Page<Procc_Type> findAll(TypeFilter filter, Pageable pageable) {
		return proccTypeDao.findAll(findByTypeLike(filter), pageable);
	}

	private Specification<Procc_Type> findByTypeLike(TypeFilter filter){
		return(root, query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("type")), filter.getSearch().toLowerCase()+"%");
		};
	}

}
