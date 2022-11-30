package com.iam4nkit.api.cart;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iam4nkit.api.wishlist.Wishlist;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CartResource {
	
	@Autowired
	public CartRepo cr;
	
	@PostMapping("/cart")
	public ResponseEntity<Object> createWishlist(@RequestBody Cart cart) {
		List<Cart> l = cr.findAll();
		for(Cart p: l) {
			if((p.getEmail()).equals(cart.getEmail()) && (p.getTitle()).equals(cart.getTitle()))
				return null;
		}
		Cart savedProduct = cr.save(cart);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	                .buildAndExpand(savedProduct.getId()).toUri();

	     return ResponseEntity.created(location).build();
    }
	@DeleteMapping("/cart/{cid}")
    public void deleteProducts(@PathVariable int cid) {
        cr.deleteById(cid);
    }
	@DeleteMapping("/cart")
    public void deleteProductsEmail(@RequestParam(value="email") String email) {
        List<Cart> c = cr.findAll();
        for(Cart l: c) {
        	if(l.getEmail().equals(email)) {
        		cr.deleteById(l.getCid());
        	}
        }
    }
	
	@GetMapping("/cart/{email}")
    public List<Cart> retrieveProduct(@PathVariable String email) {
        return cr.getItemsbyEmail(email);
    }
	
	@GetMapping("/cartSum/{email}")
    public double totalSum(@PathVariable String email) {
        List<Cart> l = cr.findAll();
        double sum =0;
        for(Cart w: l) {
        	if(w.getEmail().equals(email)) {
        		sum +=w.getPrice();
        	}
        	
        }
        return sum;
        
    }


}
