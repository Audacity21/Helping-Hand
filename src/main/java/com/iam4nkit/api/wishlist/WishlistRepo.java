package com.iam4nkit.api.wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepo extends JpaRepository<Wishlist,Integer>{
	

}
