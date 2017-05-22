package ua.com.serviceImpl;

import java.util.List;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;








import ua.com.CRUD.dao.Model_Dao;
import ua.com.dto.filter.ModelFilter;
import ua.com.dto.filter.TypeFilter;
import ua.com.dto.form.Model_Form;
import ua.com.enity.Color;
import ua.com.enity.GPU_Type;
import ua.com.enity.Models;
import ua.com.enity.Type;

import ua.com.enity.Memory;
import ua.com.enity.Nvidia;
import ua.com.enity.Procc_Type;
import ua.com.enity.Ram_Type;
import ua.com.enity.Screan;
import ua.com.service.FileWriter;
import ua.com.service.Model_Service;
import ua.com.service.FileWriter.Folder;
import ua.com.specifications.ModelSpecifications;

@Service
public class Models_ServiceImpl implements Model_Service {
 

	
	@Autowired
	private Model_Dao goodModelDao;
	
	@Autowired
	private FileWriter fileWriter;
	
	@Override
	public void save(Model_Form form) {

		Models entity = new Models();
		
		entity.setId(form.getId());
		
		entity.setName(form.getName());
		
		entity.setPrice(new Integer(form.getPrice()));
		
		entity.setColor(form.getColor());
		
		entity.setType(form.getGoodType());
		
		entity.setGpuType(form.getGpuType());
		
		entity.setMemoryType(form.getMemoryType());
		
		
		
		entity.setProccType(form.getProccType());
		
		entity.setRamType(form.getRamType());
		
		
entity.setNvidiaType(form.getNvidiaType());
		
		entity.setScreanType(form.getScreanType());
		
		goodModelDao.save(entity);
		
		entity = goodModelDao.saveAndFlush(entity);
		
	
		
		if(fileWriter.write(Folder.Models, form.getFile(),entity.getId())){
			
			entity.setVersion(form.getVersion()+1);
			
			goodModelDao.save(entity);
		}


	}

	public List<Models> findAll() {
		return goodModelDao.findAll();
		
	}

	
	public Models findOne(int  id) {
		
		return goodModelDao.findOne(id);
		
	}

	
	public void delete(int id) {

		goodModelDao.delete(id);
		
	}

	public Models findBymodelName(String modelName) {
		return goodModelDao.findBymodelName(modelName);
	}

	public List<Models> findByTypeId(int id) {
		return goodModelDao.findByTypeId(id);
	}

	public List<Models> findByGoodId(int id) {
		return goodModelDao.findByGoodId(id);
	}

	public Model_Form findForm(int id) {
		Models entity = findOne(id);
		
		Model_Form form = new Model_Form();
		
		form.setPrice(String.valueOf(entity.getPrice()));
		
		form.setId(entity.getId());
		
		form.setName(entity.getName());
		
		form.setColor(entity.getColor());
		
		form.setGoodType(entity.getType());
		
		form.setGpuType(entity.getGpuType());
		
		form.setMemoryType(entity.getMemoryType());
		
		form.setNvidiaType(entity.getNvidiaType());
		
		form.setScreanType(entity.getScreanType());
		
		form.setProccType(entity.getProccType());
		
		form.setRamType(entity.getRamType());
		
		return form;
	}

	public Models findUnique(String modelName, String price, Color color,
			Type goodType, GPU_Type gpuType, Memory memoryType, Nvidia nvidiaType, Screan screanType, 
			Procc_Type proccType, Ram_Type ramType) {
		return goodModelDao.findUnique(modelName, new Integer(price), color.getId(), goodType.getId(), gpuType.getId(), memoryType.getId(), nvidiaType.getId()  ,screanType.getId()  , proccType.getId(), ramType.getId());
	}

	@Override
	public Page<Models> findAll(Pageable pageable, ModelFilter filter) {
		return goodModelDao.findAll(new ModelSpecifications(filter), pageable);
	}

	@Override
	public Page<Models> findAll(TypeFilter filter, Pageable pageable) {
		return goodModelDao.findAll(findByModelNameLike(filter), pageable);
	}
	
	private Specification<Models> findByModelNameLike(TypeFilter filter){
		return(root, query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("Name")), filter.getSearch().toLowerCase()+"%");
		};
	}

	
}
