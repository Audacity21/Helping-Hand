package com.iam4nkit.api.order;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iam4nkit.api.cart.Cart;
import com.iam4nkit.api.cart.CartRepo;
import com.iam4nkit.api.product.Product;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OrderResource {
	
	@Autowired
	public CartRepo cr;
	
	@Autowired
	public OrderRepo or;
	
	@PostMapping("/order/{email}")
	public String order(HttpServletRequest request, @PathVariable String email) {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		List<Cart> l = cr.getItemsbyEmail(email);
		for(Cart c : l) {
			Order o = new Order();
			o.setPid(c.getId());
			o.setEmail(email);
			o.setTitle(c.getTitle());
			o.setTimestamp(ts);
			o.setPrice(c.getPrice());
			o.setIsDelivered(0);
			or.save(o);
		}
		cr.deleteByEmail(email);
		
		return "Ordered";
	}
	
	@GetMapping("/order/{email}")
	public List<Order> retrieveProduct(@PathVariable String email) {
        return or.getOrdersbyEmail(email);
    }
	
	@GetMapping("/order")
    public List<Order> retrieveAllOrders() {
        return or.findAll();
    }

}
