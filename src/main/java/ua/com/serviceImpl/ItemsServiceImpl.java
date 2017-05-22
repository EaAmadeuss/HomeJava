package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import ua.com.CRUD.dao.Items_Dao;
import ua.com.enity.Items;
import ua.com.enity.User;
import ua.com.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	Items_Dao itemsDaoFinal;
	
	@Override
	public void save(Items item) {
		
		itemsDaoFinal.save(item);
	}

	@Override
	public List<Items> findAll() {
		return itemsDaoFinal.findAll();
	}

	@Override
	public Items findOne(int id) {
		return itemsDaoFinal.findOne(id);
	}

	@Override
	public void delete(int id) {
		itemsDaoFinal.delete(id);
	}

	@Override
	public List<Items> findByUserName(String username) {
		return itemsDaoFinal.findByUserName(username);
	}

	@Override
	public List<Items> findByPurchaseStatus(int status) {
		return itemsDaoFinal.findByPurchaseStatus(status);
	}

	@Override
	public List<Items> findByUserNameAndPurchaseStatus(String username,	int status) {
		return itemsDaoFinal.findByUserNameAndPurchaseStatus(username, status);
	}

}
