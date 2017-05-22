package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.CRUD.dao.PeopleDao;
import ua.com.enity.People;
import ua.com.service.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService {

	@Autowired
	private PeopleDao peopleDao;
	
	@Override
	public List<People> findAll() {
		return peopleDao.findAll();
	}

	@Override
	public People findOne(int id) {
		return peopleDao.findOne(id);
	}

	@Override
	public People save(People people) {
		return peopleDao.saveAndFlush(people);
	}

	@Override
	public void delete(int id) {
		peopleDao.delete(id);
	}

	
}
