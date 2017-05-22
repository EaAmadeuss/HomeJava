package ua.com.CRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.enity.User;

public interface User_Dao extends JpaRepository<User, Integer> {


	
	User findByEmail(String email);
	
	User findByMobilePhone(String mobilePhone);
	
	User findByPostCode(int postCode);
	
}
