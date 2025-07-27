package Exceptions;

import com.grocerytracker.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(exception = GroceryItemNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleGroceryItemNotFoundException(GroceryItemNotFoundException ex, WebRequest webRequest){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage(ex.getMessage());
        errorResponseDTO.setRequestedUrl(webRequest.getDescription(false));
        errorResponseDTO.setStatus("Error");
        errorResponseDTO.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDTO, HttpStatusCode.valueOf(500));
    }
}
