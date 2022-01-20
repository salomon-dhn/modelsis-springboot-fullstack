package sn.modelsis.springboot.fullstack.backend.exceptions;


@SuppressWarnings("serial")
public class NoDataFoundException extends RuntimeException {

	public NoDataFoundException() {
		super("No Data Found");
	}
}