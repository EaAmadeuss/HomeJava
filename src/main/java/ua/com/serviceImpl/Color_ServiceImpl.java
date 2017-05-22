package ua.com.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.CRUD.dao.Model_Dao;
import ua.com.CRUD.dao.Color_Dao;
import ua.com.dto.filter.TypeFilter;
import ua.com.enity.Color;

import ua.com.service.Color_Service;

@Service
public class Color_ServiceImpl implements Color_Service {

	@Autowired
	private Color_Dao goodDao;
	@Autowired
	private Model_Dao modelDao;

	public void save(Color color) {
		goodDao.save(color);
	}

	
	public List<Color> findAll() {
		return goodDao.findAll();
	}

	
	public Color findOne(int id) {
		return goodDao.findOne(id);
	}

	
	public void delete(int id) {
		modelDao.save(modelDao.findByGoodId(id).stream().peek(e->e.setColor(null)).collect(Collectors.toList()));
		goodDao.delete(id);
		
	}


	public List<Color> findByModelId(int id) {
		return goodDao.findByModelId(id);
	}


	public Color findByMadeCountry(String color) {
		return goodDao.findByMadeCountry(color);
	}


	@Override
	public Page<Color> findAll(TypeFilter filter, Pageable pageable) {
		return goodDao.findAll(findByTypeLike(filter), pageable);
	}

	private Specification<Color> findByTypeLike(TypeFilter filter){
		return(root, query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("color")), filter.getSearch().toLowerCase()+"%");
		};
	}



	
	










}
