package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.CRUD.dao.Type_Dao;
import ua.com.dto.filter.TypeFilter;
import ua.com.enity.Models;
import ua.com.enity.Type;
import ua.com.service.FileWriter;
import ua.com.service.FileWriter.Folder;
import ua.com.service.Type_Service;

@Service
public class Type_ServiceImpl implements Type_Service{

	@Autowired
	private Type_Dao goodTypeDaoFinal;
	
	@Autowired
	private FileWriter fileWriter;

	public void save(Type goodType) {
		
		MultipartFile file = goodType.getFile();
		
		goodType = goodTypeDaoFinal.saveAndFlush(goodType);
		
		if(fileWriter.write(Folder.TYPES, file, goodType.getId())){
			goodType.setVersion(goodType.getVersion()+1);
			
			goodTypeDaoFinal.save(goodType);
		}
		
		
	}



	public List<Type> findAll() {
		return goodTypeDaoFinal.findAll();
	}



	public Type findOne(int id) {
		return goodTypeDaoFinal.findOne(id);
	}



	public void delete(int id) {
		
		goodTypeDaoFinal.delete(id);
	}
	
	public Type findByType(String type) {
		return goodTypeDaoFinal.findByType(type);
	}



	public List<Type> findByModelId(int id) {
		return goodTypeDaoFinal.findByModelId(id);
	}



	@Override
	public Page<Type> findAll(TypeFilter filter, Pageable pageable) {
		return goodTypeDaoFinal.findAll(findByTypeLike(filter), pageable);
	}
	
	private Specification<Type> findByTypeLike(TypeFilter filter){
		return (root, query, cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("type")), filter.getSearch().toLowerCase()+"%");
		};
	}

}
