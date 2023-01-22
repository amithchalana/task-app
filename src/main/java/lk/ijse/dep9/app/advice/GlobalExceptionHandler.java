package lk.ijse.dep9.app.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(Throwable.class)
//    public ErrorResponseMessageDTO uncaughtExceptions(Throwable t) {
//        t.printStackTrace();
//        return new ErrorResponseMessageDTO(t.getMessage(),405);
//
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object> validationException(MethodArgumentNotValidException e) {
//        String message = e.getFieldErrors().stream().map(err -> err.getField() + ":" + err.getDefaultMessage() + ",")
//                .reduce((prev, curr) -> prev + curr).get();
//        return new ErrorResponseMessageDTO(message,400);

        HashMap<String, Object> errAttributes = new LinkedHashMap<>();
        errAttributes.put("status",HttpStatus.BAD_REQUEST.value());
        errAttributes.put("status",HttpStatus.BAD_REQUEST.getReasonPhrase());
        errAttributes.put("status",new Date().toString());
        List<String> validationList = e.getFieldErrors().stream().map(err -> err.getField() + ": " +
                err.getDefaultMessage()).collect(Collectors.toList());
        errAttributes.put("errors",validationList);
        return errAttributes;
    }
}
