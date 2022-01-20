package sn.modelsis.springboot.fullstack.backend.exceptions;

@SuppressWarnings("serial")
public class TypeNotFoundException extends RuntimeException{
	public TypeNotFoundException(Integer id) {
		super(String.format("Type with Id %d not found", id));
	}

	public TypeNotFoundException(String field, String value) {
		super(String.format("Type with %s : %s not found", field, value));
	}

}
