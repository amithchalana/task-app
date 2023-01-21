package lk.ijse.dep9.app.advice;

import lk.ijse.dep9.app.dto.ErrorResponseMessageDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ErrorResponseMessageDTO uncaughtExceptions(Throwable t) {
        return new ErrorResponseMessageDTO(t.getMessage(),405);

    }
}
