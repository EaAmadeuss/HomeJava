package ua.com.CRUD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.enity.Items;

public interface Items_Dao extends JpaRepository<Items, Integer> {

	List<Items> findByUserName(String username);
	
	List<Items> findByPurchaseStatus(int status);
	
	@Query("SELECT i FROM Items i WHERE i.userName=?1 AND i.purchaseStatus=?2")
	List<Items> findByUserNameAndPurchaseStatus(String username, int status);
}
