package kr.elroy.studentmanagement.config;


import kr.elroy.studentmanagement.exception.DomainException;
import kr.elroy.studentmanagement.exception.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WebExceptionHandler {
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handleDomainException(DomainException exception) {
        return ResponseEntity
                .status(exception.getErrorCode().getHttpStatus())
                .body(ErrorResponse.from(exception.getErrorCode()));
    }
}