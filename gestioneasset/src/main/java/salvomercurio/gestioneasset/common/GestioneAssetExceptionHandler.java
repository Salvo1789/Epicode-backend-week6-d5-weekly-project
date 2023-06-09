package salvomercurio.gestioneasset.common;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import salvomercurio.gestioneasset.common.exception.ApiError;
import salvomercurio.gestioneasset.common.exception.AssetException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GestioneAssetExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AssetException.class)
	protected ResponseEntity<Object> handleEpicodeException(AssetException ex) {

		ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}
