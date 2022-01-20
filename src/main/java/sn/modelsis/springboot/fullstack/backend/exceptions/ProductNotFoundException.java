package sn.modelsis.springboot.fullstack.backend.exceptions;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException(Integer id) {
		super(String.format("Product with Id %d not found", id));
	}

	public ProductNotFoundException(String field, String value) {
		super(String.format("Product with %s : %s not found", field, value));
	}
}
