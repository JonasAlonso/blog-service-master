package es.kairosds.blogservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ComentarioOfensivoException extends Exception {

	public ComentarioOfensivoException() {
		super();
	}

	public ComentarioOfensivoException(String message) {
		super(message);
	}
}
