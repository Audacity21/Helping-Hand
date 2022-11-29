package com.iam4nkit.api.wishlist;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class WishlistResource {
	@Autowired
	public WishlistRepo wr;
	
	@PostMapping("/wishlist")
	public ResponseEntity<Object> createWishlist(@RequestBody Wishlist wishlist) {
		List<Wishlist> l = wr.findAll();
		for(Wishlist p: l) {
			if((p.getEmail()).equals(wishlist.getEmail()) && (p.getTitle()).equals(wishlist.getTitle()))
				return null;
		}
		Wishlist savedProduct = wr.save(wishlist);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	                .buildAndExpand(savedProduct.getId()).toUri();

	     return ResponseEntity.created(location).build();
    }
	
	@DeleteMapping("/wishlist/{id}")
    public void deleteProducts(@PathVariable int id) {
        wr.deleteById(id);
    }
	
	@GetMapping("/wishlist/{email}")
    public List<Wishlist> retrieveProduct(@PathVariable String email) {
        List<Wishlist> l = wr.findAll();
        for(Wishlist w: l) {
        	if(!w.getEmail().equals(email)) {
        		l.remove(w);
        	}
        }
        return l;
    }
}
