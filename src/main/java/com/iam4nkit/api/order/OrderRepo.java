package com.iam4nkit.api.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{
	
	@Query("SELECT a from Order a where email=?1")
	public List<Order> getOrdersbyEmail(String email);

}
