package com.iam4nkit.api.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{
	
	@Query("SELECT a from Cart a where email=?1")
	public List<Cart> getItemsbyEmail(String email);
	
	@Transactional
	@Modifying
	@Query("DELETE from Cart c where c.email=:email")
	public void deleteByEmail(String email);
	
}
