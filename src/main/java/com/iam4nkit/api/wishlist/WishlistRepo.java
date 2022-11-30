package com.iam4nkit.api.wishlist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface WishlistRepo extends JpaRepository<Wishlist,Integer>{
	

	@Query("SELECT a from Wishlist a where email=?1")
	public List<Wishlist> getItemsbyEmail(String email);
	
}
