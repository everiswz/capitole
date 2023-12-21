package com.capitole.ecommerce.price.exception;

public class ProductoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String CAUSE = "No se ha encontrado el producto";

	public ProductoNotFoundException() {
		super(new Throwable(CAUSE));
	}

}
