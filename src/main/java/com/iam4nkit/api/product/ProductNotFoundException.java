package com.iam4nkit.api.product;

public class ProductNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String exception) {
        super(exception);
    }
}
